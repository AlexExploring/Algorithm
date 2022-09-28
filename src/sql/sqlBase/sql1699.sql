Create table If Not Exists Calls (from_id int, to_id int, duration int);
Truncate table Calls;
insert into Calls (from_id, to_id, duration) values ('1', '2', '59');
insert into Calls (from_id, to_id, duration) values ('2', '1', '11');
insert into Calls (from_id, to_id, duration) values ('1', '3', '20');
insert into Calls (from_id, to_id, duration) values ('3', '4', '100');
insert into Calls (from_id, to_id, duration) values ('3', '4', '200');
insert into Calls (from_id, to_id, duration) values ('3', '4', '200');
insert into Calls (from_id, to_id, duration) values ('4', '3', '499');

# Ã‚Ω‚1  group by
select if(from_id < to_id, from_id, to_id) as person1,
       if(from_id > to_id, from_id, to_id) as person2,
       count(*)                            as call_count,
       sum(duration)                       as total_duration
from calls
group by person1,person2;
