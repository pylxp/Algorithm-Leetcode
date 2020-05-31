# Write your MySQL query statement below
# 查找所有至少连续出现3次的数
# 那么无非是两步，第一，统计每个数连续出现的次数，做临时表
# IF(@pre=L.Num, @cnt+1, 1)， (SELECT @pre:=null, @cnt:=0) b)
# 查找出现次数大于3的数
# SELECT DISTINCT A.Num ConsecutiveNums WHERE A.cnt >= 3

SELECT DISTINCT A.Num ConsecutiveNums
FROM (
    SELECT L.Num ,
       @cnt:=IF(@pre=L.Num, @cnt+1, 1) cnt,
       @pre:=L.Num pre
    FROM Logs L, (SELECT @pre:=null, @cnt:=0) b) A
WHERE A.cnt >= 3