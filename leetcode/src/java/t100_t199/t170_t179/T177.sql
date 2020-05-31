CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  #先进行-1赋值
  SET N = N-1;
  RETURN (
        # Write your MySQL query statement below.
        # 返回第N高的薪水，那么不难想到，是个降序取第N个数的问题
        # 即通过ORDER BY Salary DESC降序后，通过limit N-1,1 从索引N-1开始取一个数即可
        # 但是sql语句不允许写n-1这种，只能先进行set N=N-1处理
        # 难点在于如果为null，可以通过临时表解决，也可以IFNULL解决

        select
            IFNULL(
                (SELECT DISTINCT Salary
                FROM Employee
                ORDER BY Salary DESC
                LIMIT N, 1),
            NULL)
  );
END