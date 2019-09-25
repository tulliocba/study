CREATE TABLE category (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO moneyapi.category (name) VALUES('Lazer');
INSERT INTO moneyapi.category (name) VALUES('Alimentação');
INSERT INTO moneyapi.category (name) VALUES('Supermercado');
INSERT INTO moneyapi.category (name) VALUES('Farmácia');
INSERT INTO moneyapi.category (name) VALUES('Outros');
INSERT INTO moneyapi.category (name) VALUES('Impostos');
INSERT INTO moneyapi.category (name) VALUES('Educação');
INSERT INTO moneyapi.category (name) VALUES('Transporte');
INSERT INTO moneyapi.category (name) VALUES('Imobiliário');
INSERT INTO moneyapi.category (name) VALUES('Extraordinários');
