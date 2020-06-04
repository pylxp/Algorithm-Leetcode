# Write your MySQL query statement below
# 题目只要求删除重复，不要求查询
# 那么直接删除重复项即可

DELETE P1 FROM Person P1, Person P2
WHERE P1.Email=P2.Email
AND P1.Id>P2.Id