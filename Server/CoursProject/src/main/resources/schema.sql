
DROP TABLE if EXISTS users;
CREATE TABLE users
(
  id VARCHAR (256) PRIMARY KEY ,
  name VARCHAR (20) ,
  secondName VARCHAR (20),
  email VARCHAR (255),
  password VARCHAR(70) NOT NULL DEFAULT '123456',
  phoneNumber VARCHAR(15) ,
  birthday DATE,
  country VARCHAR (20),
  city VARCHAR (20),
  cityhomeAddress VARCHAR (255),
  userType NUMBER (2)
);
DROP TABLE if EXISTS account;
CREATE TABLE account
(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  bitcoin DOUBLE ,
  eurosTotal DOUBLE,
  eurosLocked DOUBLE

);

DROP TABLE if EXISTS accounts;
CREATE TABLE accounts
(
	user_id VARCHAR (256) PRIMARY KEY,
 	bitcoin_balance DECIMAL(10,10),
	blocked_euros DECIMAL(10,2),
	euro_balance DECIMAL(10,2)
	FOREIGN KEY (userId ) REFERENCES users(id)



);
DROP TABLE if EXISTS entry;
CREATE TABLE entry
(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  quantity DOUBLE ,
  type VARCHAR2(7),
  account_id int

);
