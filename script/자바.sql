create table professors(
pcode char(3) primary key,
pname VARCHAR2(100),
dept VARCHAR2(100),
hiredate DATE,
title VARCHAR2(100),
salary NUMBER
);


SELECT * FROM professors order by pcode;
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

UPDATE professors
SET dept='��ȸ', hiredate='24-04-13', title='������', salary=3000000
WHERE pcode='222';