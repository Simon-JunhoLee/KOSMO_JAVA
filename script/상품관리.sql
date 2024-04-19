-- product TABLE 생성
CREATE TABLE PRODUCT(
	code char(3) NOT NULL PRIMARY KEY,
	name varchar2(100) NOT NULL,
	price NUMBER DEFAULT 0
);

SELECT * FROM PRODUCT;

INSERT INTO PRODUCT(code, name, price) VALUES('101', '냉장고', 3500000);
INSERT INTO PRODUCT(code, name, price) VALUES('102', '세탁기', 2300000);
INSERT INTO PRODUCT(code, name, price) VALUES('103', '스타일러', '2800000');

-- sale TABLE 생성
CREATE TABLE sale(
	seq NUMBER,
	code char(3) NOT NULL,
	sale_date DATE DEFAULT sysdate,
	cnt NUMBER DEFAULT 1,
	price NUMBER DEFAULT 0,
	PRIMARY KEY(code, sale_date),
	CONSTRAINT fk_code FOREIGN KEY (code) REFERENCES PRODUCT(code)  
);

SELECT * FROM sale;

-- DROP TABLE sale;

INSERT INTO SALE VALUES(1, '101', '2024-04-01', 12, 3200000);
INSERT INTO SALE VALUES(2, '102', '2024-04-01', 5, 2250000);
INSERT INTO SALE VALUES(3, '103', '2024-04-02', 6, 2680000);
INSERT INTO SALE VALUES(4, '101', '2024-04-03', 18, 3300000);

-- SEQUENCE 생성
CREATE SEQUENCE PRODUCT.seq_sale
	INCREMENT BY 1
	START WITH 5
	MINVALUE 1
	MAXVALUE 99999;

-- DROP SEQUENCE product.seq_sale;

INSERT INTO SALE (SEQ, CODE, SALE_DATE, CNT) VALUES(seq_sale.nextval, '103', '2024-04-05', 11);
DELETE FROM sale WHERE seq = 5;

UPDATE SALE SET CNT = 12 WHERE SEQ = 6;

-- PRODUCT 테이블과 SALE 테이블 inner join
SELECT p.NAME, p.PRICE, s.*
FROM PRODUCT p , SALE s
WHERE p.CODE = s.CODE;

create view view_sale as
select s.*, p.name
from product p, sale s
where p.code=s.code;

-- drop view view_sale;

SELECT * FROM view_sale
WHERE price >= 1500000
ORDER BY sale_date, code;

SELECT MAX(code)+1 AS code FROM PRODUCT;

select * from view_sale;

CREATE VIEW view_sales AS 
select sale_date, code, name, sum(cnt) as total_sum, sum(price*cnt) as total
from view_sale
group by sale_date, code, name
order by sale_date, code;

drop view view_sales;

SELECT * FROM view_sales;
commit;

SELECT SALE_DATE, SUM(CNT) AS total_cnt, SUM(CNT)*PRICE AS total
FROM VIEW_SALE
WHERE CODE = '103'
GROUP BY SALE_DATE, price;
COMMIT;
SELECT seq_sale.nextval FROM DUAL;
INSERT INTO sale VALUES(seq_sale.nextval, '101', '24-04-05', 3, 3250000);
INSERT INTO sale VALUES(seq_sale.nextval, '101', '24-04-06', 1, 3250000);
INSERT INTO sale VALUES(seq_sale.nextval, '102', '24-04-05', 3, 2100000);
INSERT INTO sale VALUES(seq_sale.nextval, '102', '24-04-06', 2, 2400000);