echo "Loading MySql schema for ontobrowser now"
mysql -h localhost -P 3306 -u root -proot -e 'drop SCHEMA if exists ontobrowser'

mysql -h localhost -P 3306 -u root -proot -e 'CREATE SCHEMA ontobrowser'

mysql -h localhost -P 3306 -u root -proot ontobrowser < /create_schema_mysql.sql

mysql -h localhost -P 3306 -u root -proot ontobrowser < /insert_initial_data_mysql.sql

mysql -h localhost -P 3306 -u root -proot ontobrowser < /insert_crtld_vocab_example.sql

mysql -h localhost -P 3306 -u root -proot ontobrowser < /insert_curator_mysql.sql
