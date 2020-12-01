#!/bin/bash 

function absolute_path {
	x=$1
	x="${x//\~/$HOME}"
	echo $x
}

echo "This script helps users to install Ontobrowser on their Linux distribution."
echo "Ontobrowser requires a) MySql 8 or above, b)Graphviz 2.28 or above c) JAVA_HOME is set to JRE 8 or above."

read -e -p "Please confirm the above 3 requirements are fulfilled on this machine? (y/n): " yesno

if [ "$yesno" != "y" ]; then 
  exit
fi

echo "Creating temporary installation folder '.tmp_onto'"
rm -rf .tmp_onto
mkdir .tmp_onto
cd .tmp_onto

echo "Downloading MySQL java connector"
curl -# -Lo "mysql.zip" "https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.13.zip"
unzip -qq "mysql.zip" -d "mysqlj"

echo "Downloading Wildfly"
curl -# -Lo "wildfly.tar.gz" "https://download.jboss.org/wildfly/14.0.1.Final/wildfly-14.0.1.Final.tar.gz"
tar -xzf "wildfly.tar.gz"

mkdir -p "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main"
#if [ -f "../wildfly_mysql_config/standalone.xml" ] 
#then
#	cp "../wildfly_mysql_config/standalone.xml" "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main/standalone.xml"
#else
 	echo "Downloading standalone WildFly configuration" 
	curl -# -Lo "wildfly-14.0.1.Final/standalone/configuration/standalone.xml" https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/wildfly_mysql_config/standalone-local.xml
#fi

mkdir -p "wildfly-14.0.1.Final/standalone/deployments"
cp "mysqlj/mysql-connector-java-8.0.13/mysql-connector-java-8.0.13.jar" "wildfly-14.0.1.Final/standalone/deployments"
if test -f "../target/ontobrowser.war"; then
	cp "../target/ontobrowser.war" "wildfly-14.0.1.Final/standalone/deployments"
else
	echo "Downloading ontobrowser war" 
	curl -# -Lo "wildfly-14.0.1.Final/standalone/deployments/ontobrowser.war" https://github.com/nikhitajatain/ontobrowser/raw/master/target/ontobrowser.war
fi

read -e -p "Enter MySql hostname/IP address (default is 'localhost'): " mysql_ip
read -e -p "Enter MySql port address (default is '3306'): " mysql_port

if [ "$mysql_ip" == "" ]; then
	mysql_ip="localhost"
fi

if [ "$mysql_port" == "" ]; then
	mysql_port="3306"
fi

sed "s/localhost:3306/${mysql_ip}:${mysql_port}/g" wildfly-14.0.1.Final/standalone/configuration/standalone.xml > wildfly-14.0.1.Final/standalone/configuration/standalone.sav
mv wildfly-14.0.1.Final/standalone/configuration/standalone.sav wildfly-14.0.1.Final/standalone/configuration/standalone.xml

read -e -p "Enter MySql username (default is 'root'): " new_user_name

if [ "$new_user_name" != "" ]; then
	sed "s@<user-name>root</user-name>@<user-name>${new_user_name}</user-name>@g" wildfly-14.0.1.Final/standalone/configuration/standalone.xml > wildfly-14.0.1.Final/standalone/configuration/standalone.sav
	mv wildfly-14.0.1.Final/standalone/configuration/standalone.sav wildfly-14.0.1.Final/standalone/configuration/standalone.xml
else
	new_user_name="root"
fi

# modify the standalone.xml so that it works on other platforms
sed "s/jdbc:mysql:\/\/localhost:3306\/ontobrowser/jdbc:mysql:\/\/localhost:3306\/ontobrowser?serverTimezone=UTC/g" wildfly-14.0.1.Final/standalone/configuration/standalone.xml > wildfly-14.0.1.Final/standalone/configuration/standalone.sav
mv wildfly-14.0.1.Final/standalone/configuration/standalone.sav wildfly-14.0.1.Final/standalone/configuration/standalone.xml
sed "s/<driver>com.mysql<\/driver>/<driver-class>com.mysql.cj.jdbc.Driver<\/driver-class><driver>mysql-connector-java-8.0.13.jar<\/driver>/g" wildfly-14.0.1.Final/standalone/configuration/standalone.xml > wildfly-14.0.1.Final/standalone/configuration/standalone.sav
mv wildfly-14.0.1.Final/standalone/configuration/standalone.sav wildfly-14.0.1.Final/standalone/configuration/standalone.xml

sed '/<drivers>/,/<\/drivers>/d' wildfly-14.0.1.Final/standalone/configuration/standalone.xml > wildfly-14.0.1.Final/standalone/configuration/standalone.sav
mv wildfly-14.0.1.Final/standalone/configuration/standalone.sav wildfly-14.0.1.Final/standalone/configuration/standalone.xml

read -e -p  "Enter MySql password (default is 'root'): " password

if [ "$password" != "" ]; then
	sed "s@<password>root</password>@<password>${password}</password>@g" wildfly-14.0.1.Final/standalone/configuration/standalone.xml > wildfly-14.0.1.Final/standalone/configuration/standalone.sav
	mv wildfly-14.0.1.Final/standalone/configuration/standalone.sav wildfly-14.0.1.Final/standalone/configuration/standalone.xml
else
	password="root"
fi

read -e -p "Enter the port number for the ontobrowser web-app (default is '8080'): " ontobrowser_web_port
if [ "$ontobrowser_web_port" != "" ]; then
	sed "s/8080/${ontobrowser_web_port}/g" wildfly-14.0.1.Final/standalone/configuration/standalone.xml > wildfly-14.0.1.Final/standalone/configuration/standalone.sav
	mv wildfly-14.0.1.Final/standalone/configuration/standalone.sav wildfly-14.0.1.Final/standalone/configuration/standalone.xml
fi

echo "Loading MySQL schema for ontobrowser"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e 'drop SCHEMA if exists ontobrowser' 2>&1 | grep -v "Using a password"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e 'CREATE SCHEMA ontobrowser' 2>&1 | grep -v "Using a password"

for FILE in create_schema_mysql.sql insert_initial_data_mysql.sql insert_crtld_vocab_example.sql insert_curator_mysql.sql
do
	echo "processing file $FILE..."
	if test -f "../target/mysql/$FILE"; then
		SQLfile="../target/mysql/$FILE"
	else 
		curl -sO https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/mysql/$FILE
		SQLFile=$FILE
	fi
	mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password ontobrowser < $SQLFile 2>&1 | grep -v "Using a password"
done

read -e -p "Installation path for Ontobrowser:" path
abs_path=`absolute_path $path`
final_path=$(echo $abs_path | sed 's:/*$::')

echo "final destination path is $final_path"

if [ -d "$final_path/wildfly-14.0.1.Final" ]
then
	echo "cleaning previous installation" 
	rm -rf "$final_path/wildfly-14.0.1.Final"
fi

mv wildfly-14.0.1.Final/ $final_path

cd ..
rm -r .tmp_onto

echo "Installation complete"
echo "You can run wildfly by executing $final_path/wildfly-14.0.1.Final/bin/standalone.sh"