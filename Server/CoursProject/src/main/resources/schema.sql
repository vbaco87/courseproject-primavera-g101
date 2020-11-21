
DROP TABLE if EXISTS users;
CREATE TABLE users
(
  id VARCHAR (256) PRIMARY KEY ,
  name VARCHAR (20) ,
  second_name VARCHAR (20),
  email VARCHAR (255),
  password VARCHAR(70) NOT NULL DEFAULT '123456',
  phone_number VARCHAR(15) ,
  birthday DATE,
  country VARCHAR (20),
  city VARCHAR (20),
  city_home_address VARCHAR (255),
  user_type NUMBER (2)
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

-- id primary key
DROP TABLE if EXISTS entries;
CREATE TABLE entries

(
id INT AUTO_INCREMENT PRIMARY KEY,
account_id VARCHAR (256),
quantity DOUBLE,
type VARCHAR2(7),

FOREIGN KEY (account_id) REFERENCES accounts(user_id)


);

DROP TABLE if EXISTS auctions;

CREATE TABLE auctions(
  id VARCHAR (256) PRIMARY KEY ,
  creator_id VARCHAR (256) NOT NULL ,
  total_bitcoins NUMBER NOT NULL,
  price NUMBER NOT NULL,
  opening_date DATE NOT NULL,
  closing_date DATE NOT NULL,
  status VARCHAR(256) NULL DEFAULT '1',
  FOREIGN KEY (creator_id) REFERENCES users(id)
);

DROP TABLE if EXISTS bids;

CREATE TABLE bids(
  id VARCHAR (256) PRIMARY KEY ,
  user_id VARCHAR (256) NOT NULL,
  auction_id VARCHAR (256) NOT NULL,
  bitcoins NUMBER NOT NULL,
  amount NUMBER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (auction_id) REFERENCES auctions(id)
);

DROP TABLE if EXISTS winners;
CREATE TABLE winners(
  id INT AUTO_INCREMENT PRIMARY KEY,
  amount NUMBER,
  price NUMBER,
  auction_id VARCHAR(256),
  user_id VARCHAR (256), 
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (auction_id) REFERENCES auctions(id)
);

DROP TABLE if EXISTS purchases;
CREATE TABLE purchases(
   id VARCHAR (256) PRIMARY KEY,
   amount NUMBER NOT NULL,
   price NUMBER NOT NULL,
   user_broker_id VARCHAR (256),
   FOREIGN KEY (user_broker_id) REFERENCES users(id)
);

DROP TABLE if EXISTS transactions;
CREATE TABLE transactions(
   id VARCHAR (256) PRIMARY KEY,
   transaction_date DATE,
   purchases_id VARCHAR (256),
   FOREIGN KEY (purchases_id) REFERENCES purchases(id)


);

