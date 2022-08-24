Create table If Not Exists Employees (employee_id int, name varchar(30));
Create table If Not Exists Salaries (employee_id int, salary int);
Truncate table Employees;
insert into Employees (employee_id, name) values ('2', 'Crew');
insert into Employees (employee_id, name) values ('4', 'Haven');
insert into Employees (employee_id, name) values ('5', 'Kristian');
Truncate table Salaries;
insert into Salaries (employee_id, salary) values ('5', '76071');
insert into Salaries (employee_id, salary) values ('1', '22517');
insert into Salaries (employee_id, salary) values ('4', '63539');

# 题解1 涉及到问题： union会去重，union all不去重
select
    e.employee_id as employee_id
from
    employees as e left join salaries s on e.employee_id = s.employee_id
where
    s.employee_id is null
union
select
    s.employee_id as employee_id
from
    employees as e right join salaries s on e.employee_id = s.employee_id
where e.employee_id is null
order by employee_id


