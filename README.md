Webapp12 - Monkey Business Webshop project
-------------------------------------------
Documantation in docs folder
_____

How to import and build projects
-------------------
- First import both projects into Netbeans, and clean & build both
- Second start GlassFish server, then open Domain Admin Console.
Navigate to configurations/security/realms. Make a new realm named testrealm.
Fill with info:  
JAAS Context: jdbcRealm  
JNDI: jdbc/test  
User Table: customer  
User Name Column: username  
Password Column: password  
Group Table: customer_group  
Group Table User Name Column: customer_username  
Group Name Column: groups  
Assign Groups: default  
Digest Algorithm: none  
Password Encryption Algorithm: none  
Then hit save/ok.
- Now Start Java DB server
- Create database with info:  
Database name: MBDB  
Username: apa  
Password: apa
- Connect the database you just created
- Now run test InitiateDB in monkeyBusinessDB and you will get every table
that you need. And an admin with username apa and password apa.
- Now you should be able to run monkeyBusiness and after some time
a webpage will start in your standard browser. If this dosn't work try to
clean and build both projects.