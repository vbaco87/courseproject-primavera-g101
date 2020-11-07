
DROP TABLE if EXISTS users;
CREATE TABLE users
(
  id VARCHAR (256) PRIMARY KEY ,
  name VARCHAR (20) ,
  secondName VARCHAR (20),
  email VARCHAR (255),
  password VARCHAR(70) NOT NULL DEFAULT '123456',
  phoneNumber VARCHAR(15) NOT NULL,
  birthday DATE,
  country VARCHAR (20),
  city VARCHAR (20),
  cityhomeAddress VARCHAR (255)

);

DROP TABLE if EXISTS accounts;
CREATE TABLE accounts
(
	user_id VARCHAR (256) PRIMARY KEY,
 	bitcoin_balance DOUBLE,
	blocked_euros DOUBLE,
	euro_balance DOUBLE,
	FOREIGN KEY (user_id ) REFERENCES users(id)
);

DROP TABLE if EXISTS entries;
CREATE TABLE entries
(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  account_id VARCHAR (256) PRIMARY KEY,
  quantity DOUBLE,
  type VARCHAR2(7),
  FOREIGN KEY (account_id) REFERENCES accounts(user_id)
  

);
