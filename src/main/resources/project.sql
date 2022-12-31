create table student (
    st_id int identity;
    st_name varchar(200);
    st_roll int;
    st_class int;
);

insert into student(st_id,st_name,st_roll,st_class) values (1,'Hareram',1,1);

select * from student;

select * from student where st_id = 1;
