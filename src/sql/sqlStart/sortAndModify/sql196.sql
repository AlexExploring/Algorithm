Create table If Not Exists Person (Id int, Email varchar(255));
Truncate table Person;
insert into Person (id, email) values ('1', 'john@example.com');
insert into Person (id, email) values ('2', 'bob@example.com');
insert into Person (id, email) values ('3', 'john@example.com');

# ���1 delete + �Ӳ�ѯ
DELETE
FROM
    Person
WHERE
    id NOT IN (
        SELECT * FROM (
            SELECT min( id ) FROM Person GROUP BY email) as t
    );

# ���2 ������ӣ�https://leetcode.cn/problems/delete-duplicate-emails/solution/dui-guan-fang-ti-jie-zhong-delete-he-de-jie-shi-by/
# ��ѯ���
SELECT p1.*,p2.*
FROM
    Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id;

Delete p1
FROM
    Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id;