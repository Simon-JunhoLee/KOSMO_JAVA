/* 사용자 생성 */
create user java identified by pass;
create user product identified by pass;

/* 사용자 삭제 */
drop user java;

/* 권한 부여 */
/* 사용자 생성 */
create user java identified by pass;

/* 사용자 삭제 */
drop user java;

/* 권한 부여 */
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
values('221', '이병렬', '전산', '75/04/03', '정교수', 3000000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('228','이재광','전산','91/09/19','부교수',2500000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('311','강승일','전자','94/06/09','부교수',2300000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('509','오문환','건축','92/10/14','조교수',2000000);

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
values('221', '이병렬', '전산', '75/04/03', '정교수', 3000000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('228','이재광','전산','91/09/19','부교수',2500000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('311','강승일','전자','94/06/09','부교수',2300000);
insert into professors(pcode,pname,dept,hiredate,title,salary) 
values('509','오문환','건축','92/10/14','조교수',2000000);

delete from professors where pcode = 228;
commit;