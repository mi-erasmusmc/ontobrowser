#!/bin/bash
#This is a comment!

echo "This script uploads the ontologies and codelist."

echo "Creating temporary installation folder .tmp_onto"
rm -rf .tmp_onto
mkdir .tmp_onto
cd .tmp_onto

echo "Enter MySql hostname/IP address (default is 'localhost', but if you don't want to change this then please press Enter) "
read mysql_ip

if [ "$mysql_ip" == "" ]; then
	mysql_ip="localhost"
fi

echo "Enter MySql port address (default is '3306', but if you don't want to change this then please press Enter) "
read mysql_port

if [ "$mysql_port" == "" ]; then
	mysql_port="3306"
fi

echo "Enter MySql username (default is 'root', but if you don't want to change this then please press Enter)"
read new_user_name

if [ "$new_user_name" == "" ]; then
	new_user_name="root"
fi

echo "Enter MySql password (default is 'root', but if you don't want to change this then please press Enter)"
read password

if [ "$password" == "" ]; then
	password="root"
fi


echo "Enter Ontobrowser hostname/IP address (default is 'localhost', but if you don't want to change this then please press Enter) "
read ontobrowser_ip

if [ "$ontobrowser_ip" == "" ]; then
	ontobrowser_ip="localhost"
fi

echo "Enter Ontobrowser port address (default is '8080', but if you don't want to change this then please press Enter) "
read ontobrowser_port

if [ "$ontobrowser_port" == "" ]; then
	ontobrowser_port="8080"
fi

echo "Should we remove all previous ontologies and codelists? (y/n)"
read yesno

if [ "$yesno" == "y" ]; then 

echo "Loading MySql schema for ontobrowser"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e 'drop SCHEMA if exists ontobrowser'

mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e 'CREATE SCHEMA ontobrowser'

curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/create_schema_mysql.sql
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password ontobrowser < create_schema_mysql.sql

curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/insert_initial_data_mysql.sql
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password ontobrowser < insert_initial_data_mysql.sql

curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/insert_crtld_vocab_example.sql
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password ontobrowser < insert_crtld_vocab_example.sql

curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/mysql/insert_curator_mysql.sql
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password ontobrowser < insert_curator_mysql.sql

echo "Please restart ontobrowser and press enter"
read temp

fi

echo "Please confirm the ontobrowser is running? (y/n)"
read yesno

if [ "$yesno" != "y" ]; then 
  exit
fi

#echo "Enter the port number on which the ontobrowser web-application should run (default is '8080', but if you don't want to change this then please press Enter)"
#read ontobrowser_web_port

#if [ "$ontobrowser_web_port" != "" ]; then
#	set it to 8080 if it is empty
#fi

curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/ontologies/hpath.obo
curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/ontologies/in-life_observation.obo
curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/ontologies/ma.obo
curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/ontologies/moa.obo

curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C66729.obo
curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C66732.obo
curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C67154.obo
curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C77530.obo
curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C77808.obo
curl -O https://raw.githubusercontent.com/nikhitajatain/ontobrowser/master/codelists/code_list.obo/terms_C85493.obo

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

mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C66729')"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C66732')"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C67154')"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C77530')"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C77808')"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C85493')"

cd ..
rm -r .tmp_onto
