CONNECT 'jdbc:derby:D:\Database\Derby\cart';

CREATE TABLE PRODUCT (PRODUCT_ID INT NOT NULL, PRODUCT_NAME VARCHAR(20) NOT NULL, CATEGORY VARCHAR(20) NOT NULL, PRICE INT, PRIMARY KEY (PRODUCT_ID));
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, CATEGORY, PRICE) VALUES (1233, 'Angel & Demons', 'Books', 100);
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, CATEGORY, PRICE) VALUES (1234, 'Windmills of gods','Books', 100);
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, CATEGORY, PRICE) VALUES (1235, 'Tell me your dreams', 'Books', 100);
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, CATEGORY, PRICE) VALUES (1236, 'Deceptions point', 'Books', 105);
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, CATEGORY, PRICE) VALUES (1237, 'Half Girl Friend', 'Books', 107);