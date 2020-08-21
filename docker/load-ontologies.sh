#!/bin/bash
echo "Loading the ontologies and codelist."

mysql_ip="localhost"
mysql_port="3306"
new_user_name="root"
password="root"
ontobrowser_ip="localhost"
ontobrowser_port="8080"
curator_username="SYSTEM"
curator_password=""

url=${ontobrowser_ip}:${ontobrowser_port}
#url=${ontobrowser_ip}:${ontobrowser_port}/ontobrowser

curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@hpath.obo" -u $curator_username:$curator_password "http://${url}/ontologies/hpath"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@in-life_observation.obo" -u $curator_username:$curator_password "http://${url}/ontologies/inlife_observation"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@ma.obo" -u $curator_username:$curator_password "http://${url}/ontologies/Mouse%20adult%20gross%20anatomy"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@moa.obo" -u $curator_username:$curator_password "http://${url}/ontologies/moa"

curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C66729.obo" -u $curator_username:$curator_password "http://${url}/ontologies/terms_C66729"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C66732.obo" -u $curator_username:$curator_password "http://${url}/ontologies/terms_C66732"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C67154.obo" -u $curator_username:$curator_password "http://${urlt}/ontologies/terms_C67154"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C77530.obo" -u $curator_username:$curator_password "http://${url}/ontologies/terms_C77530"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C77808.obo" -u $curator_username:$curator_password "http://${url}/ontologies/terms_C77808"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C85493.obo" -u $curator_username:$curator_password "http://${url}ß/ontologies/terms_C85493"

mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C66729')"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C66732')"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C67154')"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C77530')"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C77808')"
mysql -h $mysql_ip -P $mysql_port -u $new_user_name -p$password -e "UPDATE ontobrowser.ONTOLOGY SET IS_CODELIST = 1 WHERE (ONTOLOGY_NAME = 'terms_C85493')"
