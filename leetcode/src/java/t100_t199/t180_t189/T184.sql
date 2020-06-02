# Write your MySQL query statement below
# 根据DepartmentId分组GROUP BY DepartmentId
# 在Employee中查找出同DepartmentId的最大工资SELECT max(Salary),DepartmentId FROM Employee
SELECT
    D.Name Department,
    E.Name Employee,
    E.Salary Salary
FROM
    Employee E,Department D
WHERE
    E.DepartmentId=D.Id
    AND
    (E.Salary,E.DepartmentId)
    in (SELECT max(Salary),DepartmentId FROM Employee GROUP BY DepartmentId);