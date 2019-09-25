CREATE TABLE expense_record (
                                id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
                                description VARCHAR(50) NOT NULL,
                                invoice_expiration_date DATE NOT NULL,
                                payable_date DATE,
                                amount DECIMAL(10,2) NOT NULL,
                                observation VARCHAR(100),
                                type VARCHAR(20) NOT NULL,
                                category_id BIGINT(20) NOT NULL,
                                person_id BIGINT(20) NOT NULL,
                                FOREIGN KEY (category_id) REFERENCES category(id),
                                FOREIGN KEY (person_id) REFERENCES person(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('Salário mensal', '2017-06-10', null, 6500.00, 'Distribuição de lucros', 'REVENUE', 1, 1);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('Bahamas', '2017-02-10', '2017-02-10', 100.32, null, 'EXPENSE', 2, 2);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('Top Club', '2017-06-10', null, 120, null, 'REVENUE', 3, 3);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Geração', 'REVENUE', 3, 4);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('DMAE', '2017-06-10', null, 200.30, null, 'EXPENSE', 3, 5);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 'REVENUE', 6, 4);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('Bahamas', '2017-06-10', null, 500, null, 'REVENUE', 7, 1);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('Top Club', '2017-03-10', '2017-03-10', 400.32, null, 'EXPENSE', 8, 4);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('Despachante', '2017-06-10', null, 123.64, 'Multas', 'EXPENSE', 9, 3);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('Pneus', '2017-04-10', '2017-04-10', 665.33, null, 'REVENUE', 10, 5);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('Café', '2017-06-10', null, 8.32, null, 'EXPENSE', 5, 1);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('Eletrônicos', '2017-04-10', '2017-04-10', 2100.32, null, 'EXPENSE', 4, 5);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('Instrumentos', '2017-06-10', null, 1040.32, null, 'EXPENSE', 3, 4);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('Café', '2017-04-10', '2017-04-10', 4.32, null, 'EXPENSE', 2, 4);
INSERT INTO expense_record (description, invoice_expiration_date, payable_date, amount, observation, type, category_id, person_id) values ('Lanche', '2017-06-10', null, 10.20, null, 'EXPENSE', 1, 4);