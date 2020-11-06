DROP TABLE if EXISTS account;
CREATE TABLE account
(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  bitcoin DOUBLE ,
  eurosTotal DOUBLE,
  eurosLocked DOUBLE

);
DROP TABLE if EXISTS entry;
CREATE TABLE entry
(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  quantity DOUBLE ,
  type VARCHAR2(7),
  account_id int

);
