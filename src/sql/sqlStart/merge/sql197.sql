Create table If Not Exists Weather (id int, recordDate date, temperature int);
Truncate table Weather;
insert into Weather (id, recordDate, temperature) values ('1', '2015-01-01', '10');
insert into Weather (id, recordDate, temperature) values ('2', '2015-01-02', '25');
insert into Weather (id, recordDate, temperature) values ('3', '2015-01-03', '20');
insert into Weather (id, recordDate, temperature) values ('4', '2015-01-04', '30');

# Ìâ½â1
SELECT
    w1.id as id
FROM
    weather as w1 inner join weather as w2
    on DATEDIFF(w1.recordDate,w2.recordDate) = 1
    and w1.temperature  > w2.temperature