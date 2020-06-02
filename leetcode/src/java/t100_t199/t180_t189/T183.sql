# Write your MySQL query statement below
# 查找从不订购的客户
# 即查找出所有的客户 SELECT C.Name `Customers` FROM Customers C
# 留下不存在与订单表的客户 LEFT JOIN Orders O ON C.Id=O.CustomerId WHERE O.CustomerId is null

SELECT C.Name `Customers` FROM Customers C
LEFT JOIN Orders O ON C.Id=O.CustomerId
WHERE O.CustomerId is NUll