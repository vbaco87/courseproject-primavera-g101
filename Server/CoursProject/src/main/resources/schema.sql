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

DROP TABLE if EXISTS auctions;

CREATE TABLE auctions(
  id VARCHAR (256) PRIMARY KEY ,
  id_creator VARCHAR (256) NOT NULL ,
  total_bitcoins NUMBER NOT NULL,
  price NUMBER NOT NULL,
  opening_date DATE NOT NULL,
  close_date DATE NOT NULL,
  FOREIGN KEY (id_creator) REFERENCES users(id)
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



