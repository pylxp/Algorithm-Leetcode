# Write your MySQL query statement below
# 相差天数为1  dateDiff(W1.RecordDate,W2.RecordDate) = 1
# 温度比昨天更高 W1.Temperature > W2.Temperature

SELECT W1.Id FROM Weather W1 JOIN Weather W2
ON W1.Temperature > W2.Temperature
AND dateDiff(W1.RecordDate,W2.RecordDate) = 1