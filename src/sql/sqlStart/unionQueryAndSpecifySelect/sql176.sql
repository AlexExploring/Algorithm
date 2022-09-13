Create table If Not Exists Employee (id int, salary int);
Truncate table Employee;
insert into Employee (id, salary) values ('1', '100');
insert into Employee (id, salary) values ('2', '200');
insert into Employee (id, salary) values ('3', '300');

# 题解1 不能处理有多个最高薪水的情况
SELECT (
    SELECT
        DISTINCT Salary
    FROM
        Employee
    ORDER BY Salary DESC
    LIMIT 1 OFFSET 1) AS SecondHighestSalary;

# 题解2
SELECT IFNULL ( (
        SELECT DISTINCT Salary
            FROM Employee
            ORDER BY Salary DESC
            LIMIT 1 OFFSET 1),
            NULL) AS SecondHighestSalary;

# 题解3  可以处理有多个最高薪水的情况
select
    max(Salary) SecondHighestSalary
from
    Employee
where Salary < (select max(Salary) from Employee)