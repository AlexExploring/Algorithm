Create table If Not Exists Tree (id int, p_id int);
Truncate table Tree;
insert into Tree (id) values ('1');
insert into Tree (id, p_id) values ('2', '1');
insert into Tree (id, p_id) values ('3', '1');
insert into Tree (id, p_id) values ('4', '2');
insert into Tree (id, p_id) values ('5', '2');

# ���1
select
    id,
    'Root' as Type
from Tree
where
    p_id is null