create table UserTable(id int, name varchar(30), email varchar(20), pid varchar(20),
constraint p_key primary key(id));

create table ProjectTable(pid varchar(20), pname varchar(30), budget int);

insert into UserTable values(1,'User1','us@gg.com','p1');
insert into UserTable values(2,'User2','us2@gg.com','p1');
insert into UserTable values(3,'User3','us3@gg.com','p2');
insert into UserTable values(4,'User4','us4@gg.com','p4');

insert into ProjectTable values('p1','att',1000);
insert into ProjectTable values('p2','LinkedIn',2000);
insert into ProjectTable values('p3','att',1000);
insert into ProjectTable values('p4','att',1000);

#Method 1
select * from UserTable u1 inner join ProjectTable p1 on u1.pid=p1.pid;

#Method 2
select * from UserTable u1,ProjectTable p1 where u1.pid in (select pid from ProjectTable) and u1.pid=p1.pid;
