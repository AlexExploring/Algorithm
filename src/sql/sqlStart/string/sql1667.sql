Create table If Not Exists Users (user_id int, name varchar(40));
Truncate table Users;
insert into Users (user_id, name) values ('1', 'aLice');
insert into Users (user_id, name) values ('2', 'bOB');

# Ã‚Ω‚1
select
    user_id,
    concat(upper(left(name,1)),lower(right(name,(length(name)-1)))) as name
from users
order by user_id;