# Write your MySQL query statement below
SELECT MAX(NUM) as num
FROM MyNumbers 
WHERE NUM IN 
    (SELECT num FROM MyNumbers
      GROUP BY num
      HAVING COUNT(num)=1 );