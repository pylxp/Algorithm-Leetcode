# Write your MySQL query statement below
# 组合两个表,要求返回FirstName, LastName, City, State字段
# 考察对left join的使用,主要两个表的共同主键

select P.FirstName, P.LastName, A.City, A.State from Person P
left join Address A
on P.PersonId = A.PersonId;