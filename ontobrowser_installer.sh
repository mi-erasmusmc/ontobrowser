#!/bin/bash
#This is a comment!

echo "This script helps users to install Ontobrowser on their Linux distribution."
echo "Ontobrowser requires a) MySql 8 or above, b)Graphviz 2.28 or above c) JAVA_HOME is set to JRE 8 or above."

echo "Please confirm the above 3 requirements are fulfilled on this machine? (y/n)"
read yesno

if [ "$yesno" != "y" ]; then 
  exit
fi

echo "Creating temporary installation folder .tmp_onto"
rm -rf .tmp_onto
mkdir .tmp_onto
cd .tmp_onto

echo "Downloading MySql connector-java-jar file"
wget -O "mysql.tar.xz" "https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.13.zip"

echo "Extracting connector-java-jar from the downloaded zip"
unzip "mysql.tar.xz" -d "mysqlj"

echo "Downloading Wildfly"
wget -O "wildfly.tar.gz" "https://download.jboss.org/wildfly/14.0.1.Final/wildfly-14.0.1.Final.tar.gz"

echo "Extracting wildfly"
tar -xvzf "wildfly.tar.gz"

mkdir -p "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main"
cp "mysqlj/mysql-connector-java-8.0.13/mysql-connector-java-8.0.13.jar" "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main"
wget -O "wildfly-14.0.1.Final/modules/system/layers/base/com/mysql/main/module.xml" https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/wildfly_mysql_config/module.xml
wget -O "wildfly-14.0.1.Final/standalone/configuration/standalone.xml" https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/wildfly_mysql_config/standalone.xml
wget -O "wildfly-14.0.1.Final/standalone/deployments/ontobrowser.war" https://github.com/nikhitajatain/ontobrowser/raw/master/target/ontobrowser.war

echo "Enter MySql IP address (default is 'localhost', but if you don't want to change this then please press Enter) "
read mysql_ip

if [ "$mysql_ip" != "" ]; then
	sed -i "s/localhost/${mysql_ip}/g" wildfly-14.0.1.Final/standalone/configuration/standalone.xml
else
	mysql_ip="localhost"
fi

echo "Enter MySql port address (default is '3306', but if you don't want to change this then please press Enter) "
read mysql_port

if [ "$mysql_port" != "" ]; then
	sed -i "s/3306/${mysql_port}/g" wildfly-14.0.1.Final/standalone/configuration/standalone.xml
else
	mysql_port="3306"
fi

echo "Enter MySql username (default is 'root', but if you don't want to change this then please press Enter)"
read new_user_name

if [ "$new_user_name" != "" ]; then
	sed -i "s@<user-name>root</user-name>@<user-name>${new_user_name}</user-name>@g" wildfly-14.0.1.Final/standalone/configuration/standalone.xml
else
   new_user_name="root"
fi

echo "Enter MySql password (default is 'root', but if you don't want to change this then please press Enter)"
read password

if [ "$password" != "" ]; then
	sed -i "s@<password>root</password>@<password>${password}</password>@g" wildfly-14.0.1.Final/standalone/configuration/standalone.xml
else
   password="root"
fi

echo "Enter the port number on which the ontobrowser web-application should run (default is '8080', but if you don't want to change this then please press Enter)"
read ontobrowser_web_port
if [ "$ontobrowser_web_port" != "" ]; then
	sed -i "s/8080/${ontobrowser_web_port}/g" wildfly-14.0.1.Final/standalone/configuration/standalone.xml
fi

echo "Loading MySql schema for ontobrowser"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e 'drop SCHEMA if exists ontobrowser'

mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e 'CREATE SCHEMA ontobrowser'

wget  https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/create_schema_mysql.sql
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password ontobrowser < create_schema_mysql.sql

wget https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/insert_initial_data_mysql.sql
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password ontobrowser < insert_initial_data_mysql.sql

wget https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/insert_crtld_vocab_example.sql
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password ontobrowser < insert_crtld_vocab_example.sql

wget https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/insert_curator_mysql.sql
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password ontobrowser < insert_curator_mysql.sql

read -e -p "Enter installation path for Ontobrowser:" final_path
mv wildfly-14.0.1.Final/ $final_path

cd ..
rm -r .tmp_onto

echo "Installation complete"
echo "You can run wildfly by executing the standalone.sh file in $final_path/wildfly-14.0.1.Final/bin folder."