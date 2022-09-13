Create table If Not Exists Person (id int, email varchar(255));
Truncate table Person;
insert into Person (id, email) values ('1', 'a@b.com');
insert into Person (id, email) values ('2', 'c@d.com');
insert into Person (id, email) values ('3', 'a@b.com');

# 题解1
select email
from (
    select email,count(email) as times
    from person
    group by email
) as tmp
where tmp.times > 1;

# 题解1
select email
from person
group by email
having count(email) > 1;

