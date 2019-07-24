#!/bin/bash
#This is a comment!

echo "This script uploads the ontologies and codelist."
echo "Please confirm the ontobrowser is running? (y/n)"
read yesno

if [ "$yesno" != "y" ]; then 
  exit
fi

echo "Creating temporary installation folder .tmp_onto"
rm -rf .tmp_onto
mkdir .tmp_onto
cd .tmp_onto


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

curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@hpath.obo" -u SYSTEM "http://localhost:8080/ontobrowser/ontologies/hpath"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@in-life_observation.obo" -u SYSTEM "http://localhost:8080/ontobrowser/ontologies/inlife_observation"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@ma.obo" -u SYSTEM "http://localhost:8080/ontobrowser/ontologies/Mouse%20adult%20gross%20anatomy"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@moa.obo" -u SYSTEM "http://localhost:8080/ontobrowser/ontologies/moa"

curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C66729.obo" -u SYSTEM "http://localhost:8080/ontobrowser/ontologies/terms_C66729"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C66732.obo" -u SYSTEM "http://localhost:8080/ontobrowser/ontologies/terms_C66732"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C67154.obo" -u SYSTEM "http://localhost:8080/ontobrowser/ontologies/terms_C67154"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C77530.obo" -u SYSTEM "http://localhost:8080/ontobrowser/ontologies/terms_C77530"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C77808.obo" -u SYSTEM "http://localhost:8080/ontobrowser/ontologies/terms_C77808"
curl -s -S -H "Content-Type: application/obo;charset=utf-8" -X PUT --data-binary "@terms_C85493.obo" -u SYSTEM "http://localhost:8080/ontobrowser/ontologies/terms_C85493"

cd ..
rm -r .tmp_onto
