CREATE TABLE person (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	enabled BOOLEAN NOT NULL,
    street VARCHAR(50),
    city VARCHAR(50),
    state VARCHAR(10),
    state_full VARCHAR(50),
    zipcode INT,
    phone_number VARCHAR(20),
    mobile_number VARCHAR(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO moneyapi.person (name, enabled, street, city, state, state_full, zipcode, phone_number, mobile_number) VALUES('Tulio Gabriel', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO moneyapi.person (name, enabled, street, city, state, state_full, zipcode, phone_number, mobile_number) VALUES('Katiusy Lures', 0, 'R. T', 'Cuiabá', 'MT', 'Mato Grosso', 78055746, '9999999999', '888888888');
INSERT INTO moneyapi.person (name, enabled, street, city, state, state_full, zipcode, phone_number, mobile_number) VALUES('João da Silva', 0, 'Av. Hist. Rubens de Mendonça', 'Cuiabá', 'MT', 'Mato Grosso', NULL, NULL, NULL);
INSERT INTO moneyapi.person (name, enabled, street, city, state, state_full, zipcode, phone_number, mobile_number) VALUES('Caroline Cunha Xavier', 1, 'Av. Brasil', 'Cuiabá', 'MT', 'Mato Grosso', 12345000, NULL, NULL);
INSERT INTO moneyapi.person (name, enabled, street, city, state, state_full, zipcode, phone_number, mobile_number) VALUES('Pedro Cardoso', 1, 'Av. Ubirarama, 157', 'Mineiros', 'GO', 'Goiás', 12345000, NULL, NULL);
