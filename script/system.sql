/* ����� ���� */
create user java identified by pass;
create user product identified by pass;

/* ����� ���� */
drop user java;

/* ���� �ο� */
/* ����� ���� */
create user java identified by pass;

/* ����� ���� */
drop user java;

/* ���� �ο� */
grant connect, resource, dba to java;
grant connect, resource, dba to product;

create table professors(
pcode NUMBER,
pname VARCHAR2(100),
dept VARCHAR2(100),
hiredate DATE,
title VARCHAR2(100),
salary NUMBER
);


SELECT * FROM professors;
insert into professors(pcode,pname,dept,hiredate,title,salary)
values('221', '�̺���', '����', '75/04/03', '������', 3000000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('228','���籤','����','91/09/19','�α���',2500000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('311','������','����','94/06/09','�α���',2300000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('509','����ȯ','����','92/10/14','������',2000000);

delete from professors where pcode = 228;
commit;



create table professors(
pcode NUMBER,
pname VARCHAR2(100),
dept VARCHAR2(100),
hiredate DATE,
title VARCHAR2(100),
salary NUMBER
);


SELECT * FROM professors;
insert into professors(pcode,pname,dept,hiredate,title,salary)
values('221', '�̺���', '����', '75/04/03', '������', 3000000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('228','���籤','����','91/09/19','�α���',2500000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('311','������','����','94/06/09','�α���',2300000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('509','����ȯ','����','92/10/14','������',2000000);

delete from professors where pcode = 228;
commit;