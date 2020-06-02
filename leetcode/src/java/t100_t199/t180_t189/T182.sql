# Write your MySQL query statement below
# 查找重复的电子邮箱
# 即先根据电子邮箱分组
# 再查找数量大于1的邮箱即可

SELECT Email FROM Person
GROUP BY Email
HAVING count(Email) > 1