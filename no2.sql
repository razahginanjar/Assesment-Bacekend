create table people
(
    id int,
    name varchar(150),
    parent_id int,
    primary key(id),
    foreign key fk_parent(parent_id) references people(id)
)engine=innodb;

insert into people (id, name)
values(1, 'zaki'),
      (2, 'ilham'),
      (3, 'irwan'),
      (4, 'arka');

update people
set parent_id = 3
where id = 4;
update people
set parent_id = 2
where id = 1;
update people
set parent_id = 2
where id = 2;

select p.id, p.name, po.name as parent_name from people as p
 left join people as po on p.parent_id = po.id;