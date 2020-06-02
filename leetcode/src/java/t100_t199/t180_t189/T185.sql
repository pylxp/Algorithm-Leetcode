# Write your MySQL query statement below
# 根据DepartmentId分组E.DepartmentId = E1.DepartmentId
# 选出前三高工资count(DISTINCT E1.Salary)  <3
# 最终结果根据名字升序，工资降序排列ORDER BY D.Name ASC,E.Salary DESC

SELECT
	D.Name Department,
	E.Name Employee,
	E.Salary Salary
FROM
	Employee E,Department D
WHERE
	E.DepartmentId = D.Id
	AND
    (SELECT count(DISTINCT E1.Salary)
		FROM
            Employee E1
		WHERE
            E.Salary < E1.Salary
            AND
            E.DepartmentId = E1.DepartmentId) <3
ORDER BY
    D.Name ASC,
    E.Salary DESC