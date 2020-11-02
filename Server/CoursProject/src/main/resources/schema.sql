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
  cityhomeAddress VARCHAR (255),
  userType NUMBER (2)
);

