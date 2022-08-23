Create table If Not Exists Customer (id int, name varchar(25), referee_id int);
Truncate table Customer;
insert into Customer (id, name) values ('1', 'Will');
insert into Customer (id, name) values ('2', 'Jane');
insert into Customer (id, name, referee_id) values ('3', 'Alex', '2');
insert into Customer (id, name) values ('4', 'Bill');
insert into Customer (id, name, referee_id) values ('5', 'Zack', '1');
insert into Customer (id, name, referee_id) values ('6', 'Mark', '2');

# Ìâ½â1
select
    name
from Customer
where referee_id is null or referee_id != 2;