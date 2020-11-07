
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

DROP TABLE if EXISTS accounts;
CREATE TABLE accounts
(
	user_id VARCHAR (256) PRIMARY KEY,
 	bitcoin_balance DOUBLE,
	euro_balance DOUBLE,
	blocked_euros DOUBLE,
	
	FOREIGN KEY (user_id ) REFERENCES users(id)
);

DROP TABLE if EXISTS entries;
CREATE TABLE entries
( 
 account_id VARCHAR (256) PRIMARY KEY,
  id INT AUTO_INCREMENT,
  quantity DOUBLE,
  type VARCHAR2(7),
  FOREIGN KEY (account_id) REFERENCES accounts(user_id)
  

);

DROP TABLE if EXISTS auctions;

CREATE TABLE auctions(
  id VARCHAR (256) PRIMARY KEY ,
  id_creator VARCHAR (256) NOT NULL ,
  total_bitcoins NUMBER NOT NULL,
  price NUMBER NOT NULL,
  opening_date DATE NOT NULL,
  close_date DATE NOT NULL,
  id_winner VARCHAR(256) NULL,
  FOREIGN KEY (id_creator) REFERENCES users(id),
  FOREIGN KEY (id_winner) REFERENCES users(id)
);

DROP TABLE if EXISTS bids;

CREATE TABLE bids(
  id VARCHAR (256) PRIMARY KEY ,
  id_user VARCHAR (256) NOT NULL,
  id_auction VARCHAR (256) NOT NULL,
  bitcoins NUMBER NOT NULL,
  amount NUMBER NOT NULL,
  FOREIGN KEY (id_user) REFERENCES users(id),
  FOREIGN KEY (id_auction) REFERENCES auctions(id)
);
