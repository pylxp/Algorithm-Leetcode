# Write your MySQL query statement below
# 查找超过经理收入的员工
# 实际就等同于先查找员工的工资 SELECT E.Name Employee FROM Employee E
# 再收入对应的经理工资 (SELECT DISTINCT Id,Salary FROM Employee) M ON E.ManagerId  = M.Id
# 然后筛选出收入超过经理的员工 WHERE E.Salary  > M.Salary

SELECT E.Name Employee
FROM Employee E
LEFT JOIN (SELECT DISTINCT Id,Salary FROM Employee) M ON E.ManagerId  = M.Id
WHERE E.Salary  > M.Salary