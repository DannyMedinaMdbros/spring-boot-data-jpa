/* populating clients table */
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Daniel', 'Medina', 'danny.medina@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Joe', 'Doe', 'joe.doe@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Mary', 'Bue', 'mary.bue@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Jane', 'Doe', 'Jane.Doe@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Rasmus', 'Lerdorf', 'jRasmusoe.Lerdorf@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Erich', 'Gamma', 'Erich.Gamma@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Richard', 'Helm', 'Richard.Helm@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Ralph', 'Johnson', 'Ralph.Johnson@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('John', 'Vlissides', 'John.Vlissides@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('James', 'Gosling', 'James.Gosling@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('John', 'Doe', 'John.doe@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Bruce', 'Lee', 'Bruce.Lee@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Johnny', 'Doe', 'Johnny.Doe@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('John', 'Roe', 'John.dRoeoe@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Jane', 'Foe', 'Jane.Foe@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Richard', 'Doe', 'Richard.Doe@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Janie', 'Doe', 'joe.doe@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Phillip', 'Webb', 'Phillip.Webb@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Stephane', 'Nicoll', 'Stephane.Nicoll@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Sam', 'Brannen', 'Sam.Brannen@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Juergen', 'Hoeller', 'Juergen.Hoeller@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Janie', 'Roe', 'Janie.Roe@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('Joe', 'Bloggs', 'joe.Bloggs@gmail.com','2017-08-28','');
INSERT INTO clients(first_name, last_name, email, created_date, photo) VALUES('John', 'Stiles', 'John.Stiles@gmail.com','2017-08-28','');

/* populate products table  */

INSERT INTO products (name, price, created_date) VALUES('Panasonic Screen LCD',25990,NOW());
INSERT INTO products (name, price, created_date) VALUES('Digital Camera Sony DSC-W320B',12990,NOW());
INSERT INTO products (name, price, created_date) VALUES('Apple Ipod Shuffle',14990,NOW());
INSERT INTO products (name, price, created_date) VALUES('Sony Notebook Z110',27990,NOW());
INSERT INTO products (name, price, created_date) VALUES('Multifunctional HP M2280',6990,NOW());
INSERT INTO products (name, price, created_date) VALUES('Benotto Bicycle 26 inches',4990,NOW());
INSERT INTO products (name, price, created_date) VALUES('Desktop Office 5 pices',31990,NOW());

/* Bills examples */

INSERT INTO bills (description, observation, client_id, created_date) VALUES ('Office equipment bill', null, 1, NOW());
INSERT INTO bill_items (quantity, bill_id, product_id) VALUES(1,1,1);
INSERT INTO bill_items (quantity, bill_id, product_id) VALUES(2,1,4);
INSERT INTO bill_items (quantity, bill_id, product_id) VALUES(1,1,5);
INSERT INTO bill_items (quantity, bill_id, product_id) VALUES(1,1,7);

INSERT INTO bills (description, observation, client_id, created_date) VALUES ('Bicycles bill', null, 1, NOW());
INSERT INTO bill_items (quantity, bill_id, product_id) VALUES(3,2,6);


