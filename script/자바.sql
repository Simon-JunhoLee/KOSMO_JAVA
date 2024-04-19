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
values('221', '이병렬', '전산', '75/04/03', '정교수', 3000000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('228','이재광','전산','91/09/19','부교수',2500000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('311','강승일','전자','94/06/09','부교수',2300000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('509','오문환','건축','92/10/14','조교수',2000000);

delete from professors where pcode = 228;
commit;

UPDATE professors
SET dept='사회', hiredate='24-04-13', title='정교수', salary=3000000
WHERE pcode='222';