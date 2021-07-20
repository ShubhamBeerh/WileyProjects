
create table company_table(autoID int auto_increment, id int, name varchar(30), project varchar(30),
company varchar(30), cost_incurred varchar(30), constraint pk_key primary key(autoID));
alter table company_table add constraint UC_Emp unique(id,project,cost_incurred);
insert into company_table values(null,01,'E1','P1,P2','C1',concat('1000',',','1500'));
insert into company_table values(null,02,'E2','P2','C2','1500');
insert into company_table values(null,03,'E3','P1,P3','C1','3000');
drop table company_table ;
select * from company_table;

#1NF
truncate table company_table;
insert into company_table values(null,1,'E1','P1','C1','1000');
insert into company_table values(null,1,'E1','P1','C1','1500');
insert into company_table values(null,1,'E1','P2','C1','1000');
insert into company_table values(null,1,'E1','P2','C1','1500');
insert into company_table values(null,2,'E2','P2','C2','1500');
insert into company_table values(null,3,'E3','P1','C1','3000');
insert into company_table values(null,3,'E3','P3','C1','3000');
select * from company_table;

#2NF -> Employee Name is dependent only on id and not on (id,project,cost) therefore partial dependency
create table employee_data(id int, name varchar(30), constraint PK_id primary key(id));
insert into employee_data values(1,'E1');
insert into employee_data values(2,'E2');
insert into employee_data values(3,'E3');
select * from employee_data;
alter table company_table drop column name;
select * from company_table;

#Let's have a column say, CompanyMotto that will depend on CompanyName and will inject a transitive dependency
alter table company_table add column motto varchar(30);
update company_table set motto='Work Hard, Work Smart' where company ='C1';
update company_table set motto='The Sky is the Limit' where company ='C2';
select * from company_table ct ;

#3NF
create table motto_table(company varchar(30), motto varchar(30), constraint PK_company primary key(company));
insert into motto_table values('C1','Work Hard, Work Smart');
insert into motto_table values('C2','The Sky is the Limit');
alter table company_table drop column motto;
select * from motto_table;
select * from company_table ct ;


