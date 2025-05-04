Notes on BCB

* BigCloneBench: https://github.com/clonebench/BigCloneBench

1. Extract the bigclonebench.tar.gz
2. It will have a .pgsql file.
3. Go to PostgreSQL bin directory (example: C:\Program Files\PostgreSQL\14\bin) and open CMD
4. Open PGAdmin and create database: bigclonebenchtest (we can give any name to database) and role with full permission: bigclonebench
5. Open PGAdmin and create role with full permission: postgresql
6. Execute: psql -U db_user db_name < absolute path of .pgsql file (source to command: https://bobcares.com/blog/psql-to-restore-a-text-dump/)

* Query 1: psql -U bigclonebench bigclonebench < "F:\bigclonebench.pgsql"
* The query 1 will work on linux machine but in Windows it will not work as it has issues with "\\" line-separators. 
Thus, it will throw syntax errors on Windows machines (source: https://stackoverflow.com/questions/1797954/postgresql-database-restore-from-dump-syntax-error).

* Therefore, in Windows we can use Query 2.
* Query 2: psql -d bigclonebenchtest -U postgresql -f "F:\bigclonebench.pgsql" -1
* Query 2 tested on Windows and works like charm!
* -f fileName: Read commands from the file filename, rather than standard input. It will solve line-separators syntax error issues.
* -1 means for single transaction.
*  We can specify that the whole dump should be restored as a single transaction, so the restore is either fully completed or fully rolled back. 
This mode can be specified by passing the -1 or --single-transaction command-line options to psql. 
When using this mode, be aware that even a minor error can rollback a restore that has already run for many hours. 
However, that might still be preferable to manually cleaning up a complex database after a partially restored dump. 

Double quotes important in the path!

Notes:
1. psql — PostgreSQL interactive terminal
2. Synopsis: psql [option...] [dbname [username]]

*****************************************************************
Console Output:

C:\Program Files\PostgreSQL\14\bin>psql -d bigclonebenchtest -U postgresql -f "F:\bigclonebench.pgsql" -1
Password for user postgresql:
SET
SET
SET
SET
SET
 set_config
------------

(1 row)


SET
SET
SET
SET
CREATE EXTENSION
COMMENT
CREATE FUNCTION
ALTER FUNCTION
CREATE AGGREGATE
ALTER AGGREGATE
SET
SET
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE SEQUENCE
ALTER TABLE
ALTER SEQUENCE
CREATE TABLE
ALTER TABLE
CREATE SEQUENCE
ALTER TABLE
ALTER SEQUENCE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE TABLE
ALTER TABLE
CREATE SEQUENCE
ALTER TABLE
ALTER SEQUENCE
ALTER TABLE
ALTER TABLE
ALTER TABLE
COPY 8584153
COPY 279032
COPY 20840366
COPY 43
COPY 22285855
COPY 75673
COPY 329500
COPY 329500
COPY 335231
COPY 22285855
COPY 101
COPY 86224
 setval
--------
     45
(1 row)


  setval
----------
 23725449
(1 row)


 setval
--------
  97633
(1 row)


ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
CREATE INDEX
CREATE INDEX
CREATE INDEX
CREATE INDEX
CREATE INDEX
CREATE INDEX
CREATE INDEX
CREATE INDEX
CREATE INDEX
CREATE INDEX
CREATE INDEX
CREATE INDEX
CREATE INDEX
CREATE INDEX
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
ALTER TABLE
GRANT

C:\Program Files\PostgreSQL\14\bin>