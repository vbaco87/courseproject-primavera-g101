INSERT INTO users VALUES ('123123123', 'Judith', 'Barberan', 'jbarberan@edu.tecnocampus.cat', '147147', '125874', '2000-05-21', 'Spain', 'Barcelona', 'c/corunya',0);
INSERT INTO users VALUES ('456456456', 'Victorius', 'Colominus', 'vcolominus@edu.tecnocampus.cat', '98741236', '369258', '2000-09-05', 'Spain', 'Barcelona', 'c/canyet',1);
INSERT INTO users VALUES ('963963963', 'Patrica', 'Camacho', 'pcamacho@edu.tecnocampus.cat', '951951', '145236987', '1999-01-10', 'Spain', 'Barcelona', 'c/bac de roda',0);
INSERT INTO users VALUES ('789456163', 'Ramon', 'Llop', 'rllop@edu.tecnocampus.cat', '123123', '123123', '2003-12-12', 'Spain', 'Arenys de Mar', 'c/casaSeva',0);
INSERT INTO users VALUES ('789456113', 'Rodolfo', 'Vidal', 'rvidal@edu.tecnocampus.cat', '321321', '35795132', '2000-11-14', 'Spain', 'No se', 'c/preguntaliAell',2);
INSERT INTO users VALUES ('789456123', 'Lorena', 'Gutierrez', 'lguiti@edu.tecnocampus.cat', '852147', '95123647', '2000-02-20', 'Spain', 'No se', 'c/preguntaliAella',0);

INSERT INTO accounts VALUES ('123123123', 2.35,123.21,30);
INSERT INTO accounts VALUES ('456456456',5.02,13.53,28);
INSERT INTO accounts VALUES ('963963963',18.4,95.23,60.5);
INSERT INTO accounts VALUES ('789456163', 31.74,660.34,80.25);

INSERT INTO auctions VALUES(1, '123123123', 80,90,'2020-08-21','2020-08-25');
INSERT INTO auctions VALUES(2, '123123123', 120,50,'2020-10-25','2020-10-29');
INSERT INTO auctions VALUES(3, '123123123', 15,9,'2020-12-25','2020-12-30');
INSERT INTO auctions VALUES(4, '123123123', 160,266,'2020-12-21','2020-12-25');
INSERT INTO auctions VALUES(5, '123123123', 20,25,'2020-11-12','2020-11-16');
INSERT INTO auctions VALUES(6, '123123123', 1,110,'2020-11-07','2020-11-08');
INSERT INTO auctions VALUES(7, '123123123', 1,110,'2020-10-07','2020-12-08');
INSERT INTO auctions VALUES(8, '123123123', 1,110,'2020-01-07','2020-12-10');

INSERT INTO entries VALUES (1,'123123123',2,'bitcoin');
INSERT INTO entries VALUES (2,'123123123',4,'euros');

INSERT INTO bids VALUES ('1','456456456','1','1','4');
INSERT INTO bids VALUES ('2','456456456','2','3','5');
INSERT INTO bids VALUES ('3','456456456','3','6','4');
INSERT INTO bids VALUES ('4','456456456','4','8','20');
INSERT INTO bids VALUES ('5','789456163','4','8','20');

INSERT INTO winners VALUES ('1',5, 10, '1', '456456456');
INSERT INTO winners VALUES ('2',15, 12, '2','456456456');

INSERT INTO purchases VALUES ('idpurchase1', 3, 115, '123123123');
INSERT INTO purchases VALUES ('idpurchase2', 3, 115, '123123123');
INSERT INTO purchases VALUES ('idpurchase3', 3, 115, '123123123');


INSERT INTO transactions VALUES ('idtransaction1', '2000-01-10', 'idpurchase1');
INSERT INTO transactions VALUES ('idtransaction2', '2010-05-07', 'idpurchase2');
INSERT INTO transactions VALUES ('idtransaction3', '2020-08-02', 'idpurchase3');

