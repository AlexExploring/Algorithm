Create table If Not Exists Employee (id int, salary int);
Truncate table Employee;
insert into Employee (id, salary) values ('1', '100');
insert into Employee (id, salary) values ('2', '200');
insert into Employee (id, salary) values ('3', '300');

# ���1 ���ܴ����ж�����нˮ�����
SELECT (
    SELECT
        DISTINCT Salary
    FROM
        Employee
    ORDER BY Salary DESC
    LIMIT 1 OFFSET 1) AS SecondHighestSalary;

# ���2
SELECT IFNULL ( (
        SELECT DISTINCT Salary
            FROM Employee
            ORDER BY Salary DESC
            LIMIT 1 OFFSET 1),
            NULL) AS SecondHighestSalary;

# ���3  ���Դ����ж�����нˮ�����
select
    max(Salary) SecondHighestSalary
from
    Employee
where Salary < (select max(Salary) from Employee)