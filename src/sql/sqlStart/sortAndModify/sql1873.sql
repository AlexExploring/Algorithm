Create table If Not Exists Employees (employee_id int, name varchar(30), salary int);
Truncate table Employees;
insert into Employees (employee_id, name, salary) values ('2', 'Meir', '3000');
insert into Employees (employee_id, name, salary) values ('3', 'Michael', '3800');
insert into Employees (employee_id, name, salary) values ('7', 'Addilyn', '7400');
insert into Employees (employee_id, name, salary) values ('8', 'Juan', '6100');
insert into Employees (employee_id, name, salary) values ('9', 'Kannon', '7700');

# 题解1 if语句
select
    employee_id,
    if(employee_id%2 != 0 and name not like 'M%',salary,0) as bonus
from Employees
order by employee_id;

# 题解2 case语句
select
    employee_id,
    case
        when employee_id%2 = 1 and name not like 'M%' then salary
        when employee_id%2 = 0 or name like 'M%' then 0
    end as bonus
from employees
order by employee_id