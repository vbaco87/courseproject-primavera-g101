INSERT INTO users VALUES ('123123123', 'Judith', 'Barberan', 'jbarberan@edu.tecnocampus.cat', '{bcrypt}$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2', '125874', '2000-05-21', 'Spain', 'Barcelona', 'c/corunya',1);
INSERT INTO users VALUES ('456456456', 'Victorius', 'Colominus', 'vcolominus@edu.tecnocampus.cat', '{bcrypt}$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2', '369258', '2000-09-05', 'Spain', 'Barcelona', 'c/canyet',1);
INSERT INTO users VALUES ('963963963', 'Patrica', 'Camacho', 'pcamacho@edu.tecnocampus.cat', '{bcrypt}$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2', '145236987', '1999-01-10', 'Spain', 'Barcelona', 'c/bac de roda',1);
INSERT INTO users VALUES ('789456163', 'Ramon', 'Llop', 'rllop@edu.tecnocampus.cat', '{bcrypt}$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2', '123123', '2003-12-12', 'Spain', 'Arenys de Mar', 'c/casaSeva',1);
INSERT INTO users VALUES ('789456113', 'Rodolfo', 'Vidal', 'rvidal@edu.tecnocampus.cat', '{bcrypt}$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2', '35795132', '2000-11-14', 'Spain', 'No se', 'c/preguntaliAell',1);
INSERT INTO users VALUES ('789456123', 'Lorena', 'Gutierrez', 'lguiti@edu.tecnocampus.cat', '{bcrypt}$2a$10$fVKfcc47q6lrNbeXangjYeY000dmjdjkdBxEOilqhapuTO5ZH0co2', '95123647', '2000-02-20', 'Spain', 'No se', 'c/preguntaliAella',1);

INSERT INTO accounts VALUES ('123123123', 2.35,1123.21,30);
INSERT INTO accounts VALUES ('456456456',5.02,2550.53,200.12);
INSERT INTO accounts VALUES ('963963963',18.4,9115.23,60.5);
INSERT INTO accounts VALUES ('789456163', 31.74,6160.34,80.25);

INSERT INTO auctions VALUES(1, '123123123', 80,90,'2020-08-21','2020-12-25', true);
INSERT INTO auctions VALUES(2, '123123123', 120,50,'2020-10-25','2020-01-29', true);
INSERT INTO auctions VALUES(3, '123123123', 15,9,'2020-12-25','2020-01-30', true);
INSERT INTO auctions VALUES(4, '123123123', 9,266,'2020-12-21','2020-01-25', true);
INSERT INTO auctions VALUES(5, '123123123', 20,25,'2020-11-12','2020-01-16', true);
INSERT INTO auctions VALUES(6, '123123123', 1,110,'2020-11-07','2020-01-08', true);
INSERT INTO auctions VALUES(7, '123123123', 1,110,'2020-10-07','2020-02-08', true);
INSERT INTO auctions VALUES(8, '123123123', 1,110,'2020-01-07','2020-02-10', true);

INSERT INTO entries VALUES (1,'123123123',2,'bitcoin');
INSERT INTO entries VALUES (2,'123123123',4,'euros');

INSERT INTO bids VALUES ('1','456456456','1','1','4');
INSERT INTO bids VALUES ('2','456456456','2','3','5');
INSERT INTO bids VALUES ('3','456456456','3','6','4');
INSERT INTO bids VALUES ('4','456456456','4','8','20');
INSERT INTO bids VALUES ('5','789456163','4','8','25');



INSERT INTO purchases VALUES ('idpurchase1', 3, 115, '123123123');
INSERT INTO purchases VALUES ('idpurchase2', 3, 115, '123123123');
INSERT INTO purchases VALUES ('idpurchase3', 3, 115, '123123123');


INSERT INTO transactions VALUES ('idtransaction1', '2000-01-10', 'idpurchase1', null);
INSERT INTO transactions VALUES ('idtransaction2', '2010-05-07', 'idpurchase2', null);
INSERT INTO transactions VALUES ('idtransaction3', '2020-08-02', 'idpurchase3', null);

INSERT INTO authorities (email, role) VALUES ('jbarberan@edu.tecnocampus.cat', 'ROLE_ADMIN');
INSERT INTO authorities (email, role) VALUES ('lguiti@edu.tecnocampus.cat', 'ROLE_BROKER');
INSERT INTO authorities (email, role) VALUES ('rvidal@edu.tecnocampus.cat', 'ROLE_BIDDER');

