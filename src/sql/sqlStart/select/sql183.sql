Create table If Not Exists Customers (id int, name varchar(255));
Create table If Not Exists Orders (id int, customerId int);
Truncate table Customers;
insert into Customers (id, name) values ('1', 'Joe');
insert into Customers (id, name) values ('2', 'Henry');
insert into Customers (id, name) values ('3', 'Sam');
insert into Customers (id, name) values ('4', 'Max');
Truncate table Orders;
insert into Orders (id, customerId) values ('1', '3');
insert into Orders (id, customerId) values ('2', '1');

# 题解1
select
    name as 'Customers'
from Customers
where id not in (
    select customerId
    from Orders
);

# 题解2
select
    c.name as Customers
from Customers as c
left join Orders as o on c.Id = o.CustomerId
where o.CustomerId is null;
