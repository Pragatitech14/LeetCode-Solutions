# Write your MySQL query statement below
select a.name 
from Employee a
join Employee b
ON a.id=b.managerId
group by a.id
HAVING COUNT(*) >= 5;