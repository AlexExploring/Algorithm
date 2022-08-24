Create table If Not Exists Products (product_id int, store1 int, store2 int, store3 int);
Truncate table Products;
insert into Products (product_id, store1, store2, store3) values ('0', '95', '100', '105');
insert into Products (product_id, store1, store3) values ('1', '70', '80');

# Ã‚Ω‚1
select product_id,store1,store1 as price
from
    products
where store1 is not null;