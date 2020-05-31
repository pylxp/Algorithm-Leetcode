# Write your MySQL query statement below
# 返回第二高的薪水，那么不难想到，是个降序取第二个数的问题
# 即通过ORDER BY Salary DESC降序后，通过limit 1,1 从索引1开始取一个数即可
# 难点在于如果为null，可以通过临时表解决，也可以IFNULL解决

select
    IFNULL(
        (SELECT DISTINCT Salary
        from Employee
        ORDER BY Salary DESC
        LIMIT 1, 1),
    null) AS SecondHighestSalary