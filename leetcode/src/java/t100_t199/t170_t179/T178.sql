# Write your MySQL query statement below
# mysql8.0新特性开窗函数DENSE_RANK()解决排名问题即可
# 这里注意，Rank为关键字，要用``括起来

SELECT Score,
    DENSE_RANK() OVER(ORDER BY Score DESC) AS 'Rank'
FROM Scores