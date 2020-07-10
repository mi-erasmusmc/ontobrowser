#!/bin/bash
#This is a comment!

echo "This script uploads the ontologies and codelist."

echo "Creating temporary installation folder .tmp_onto"
rm -rf .tmp_onto
mkdir .tmp_onto
cd .tmp_onto

read -e -p "Enter MySql hostname/IP address (default is 'localhost') " mysql_ip

if [ "$mysql_ip" == "" ]; then
	mysql_ip="localhost"
fi

read -e -p "Enter MySql port address (default is '3306'): " mysql_port

if [ "$mysql_port" == "" ]; then
	mysql_port="3306"
fi

read -e -p "Enter MySql username (default is 'etransafe'): " new_user_name

if [ "$new_user_name" == "" ]; then
	new_user_name="etransafe"
fi

read -e -p "Enter MySql password (default is 'etransafe'): " password

if [ "$password" == "" ]; then
	password="etransafe"
fi


read -e -p "Enter Ontobrowser hostname/IP address (default is 'localhost'): " ontobrowser_ip

if [ "$ontobrowser_ip" == "" ]; then
	ontobrowser_ip="localhost"
fi

read -e -p "Enter Ontobrowser port address (default is '8080'): " ontobrowser_port

if [ "$ontobrowser_port" == "" ]; then
	ontobrowser_port="8080"
fi

read -e -p "Should we remove all previous ontologies and codelists? (y/n): " yesno

if [ "$yesno" == "y" ]; then 
	echo "Loading MySql schema for ontobrowser"
	mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e 'drop SCHEMA if exists ontobrowser' 2>&1 | grep -v "Using a password"
	mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e 'CREATE SCHEMA ontobrowser' 2>&1 | grep -v "Using a password"


	for FILE in create_schema_mysql.sql insert_initial_data_mysql.sql insert_crtld_vocab_example.sql insert_curator_mysql.sql
	do
		echo "processing file $FILE..."
		if test -f "../mysql/$FILE"; then
			SQLFile="../mysql/$FILE"
		else 
			curl -sO https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/mysql/$FILE
			SQLFile=$FILE
		fi
		mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password ontobrowser < $SQLFile 2>&1 | grep -v "Using a password"
	done
fi

read -e -p "Please restart ontobrowser and press enter: " temp

read -e -p "Please confirm the ontobrowser is running? (y/n): " yesno

if [ "$yesno" != "y" ]; then 
  exit
fi

read -e -p "Enter the port number on which the ontobrowser web-application should run (default is '8080'): " ontobrowser_web_port

curl -O https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/ontologies/hpath.obo
curl -O https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/ontologies/in-life_observation.obo
curl -O https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/ontologies/ma.obo
curl -O https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/ontologies/moa.obo

curl -O https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/codelists/code_list.obo/terms_C66729.obo
curl -O https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/codelists/code_list.obo/terms_C66732.obo
curl -O https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/codelists/code_list.obo/terms_C67154.obo
curl -O https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/codelists/code_list.obo/terms_C77530.obo
curl -O https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/codelists/code_list.obo/terms_C77808.obo
curl -O https://raw.githubusercontent.com/mi-erasmusmc/ontobrowser/master/codelists/code_list.obo/terms_C85493.obo

curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@hpath.obo" -u SYSTEM "http://${ontobrowser_ip}:${ontobrowser_port}/ontobrowser/ontologies/hpath"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@in-life_observation.obo" -u SYSTEM "http://${ontobrowser_ip}:${ontobrowser_port}/ontobrowser/ontologies/inlife_observation"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@ma.obo" -u SYSTEM "http://${ontobrowser_ip}:${ontobrowser_port}/ontobrowser/ontologies/Mouse%20adult%20gross%20anatomy"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@moa.obo" -u SYSTEM "http://${ontobrowser_ip}:${ontobrowser_port}/ontobrowser/ontologies/moa"

curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C66729.obo" -u SYSTEM "http://${ontobrowser_ip}:${ontobrowser_port}/ontobrowser/ontologies/terms_C66729"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C66732.obo" -u SYSTEM "http://${ontobrowser_ip}:${ontobrowser_port}/ontobrowser/ontologies/terms_C66732"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C67154.obo" -u SYSTEM "http://${ontobrowser_ip}:${ontobrowser_port}/ontobrowser/ontologies/terms_C67154"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C77530.obo" -u SYSTEM "http://${ontobrowser_ip}:${ontobrowser_port}/ontobrowser/ontologies/terms_C77530"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C77808.obo" -u SYSTEM "http://${ontobrowser_ip}:${ontobrowser_port}/ontobrowser/ontologies/terms_C77808"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C85493.obo" -u SYSTEM "http://${ontobrowser_ip}:${ontobrowser_port}/ontobrowser/ontologies/terms_C85493"

mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C66729')" 2>&1 | grep -v "Using a password"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C66732')" 2>&1 | grep -v "Using a password"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C67154')" 2>&1 | grep -v "Using a password"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C77530')" 2>&1 | grep -v "Using a password"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C77808')" 2>&1 | grep -v "Using a password"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C85493')" 2>&1 | grep -v "Using a password"

cd ..
rm -r .tmp_onto