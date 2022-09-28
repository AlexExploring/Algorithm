Create table If Not Exists Sales (sale_date date, fruit ENUM('apples', 'oranges'), sold_num int);
Truncate table Sales;
insert into Sales (sale_date, fruit, sold_num) values ('2020-05-01', 'apples', '10');
insert into Sales (sale_date, fruit, sold_num) values ('2020-05-01', 'oranges', '8');
insert into Sales (sale_date, fruit, sold_num) values ('2020-05-02', 'apples', '15');
insert into Sales (sale_date, fruit, sold_num) values ('2020-05-02', 'oranges', '15');
insert into Sales (sale_date, fruit, sold_num) values ('2020-05-03', 'apples', '20');
insert into Sales (sale_date, fruit, sold_num) values ('2020-05-03', 'oranges', '0');
insert into Sales (sale_date, fruit, sold_num) values ('2020-05-04', 'apples', '15');
insert into Sales (sale_date, fruit, sold_num) values ('2020-05-04', 'oranges', '16');

# 题解1
select
    t1.sale_date,
    (t1.sold_num-t2.sold_num) as diff
from (
    select sale_date,sold_num
    from sales
    where fruit = 'apples'
    order by sale_date
) as t1 left join (
    select sale_date,sold_num
    from sales
    where fruit = 'oranges'
    order by sale_date
)  as t2 on t1.sale_date = t2.sale_date;

# 题解2
select
    sale_date,
    sum(if(fruit = 'apples', sold_num, -sold_num)) as diff
from sales
group by sale_date;
