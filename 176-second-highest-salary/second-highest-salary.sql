-- Write your PostgreSQL query statement below
SELECT (select distinct salary   
FROM Employee
ORDER BY  salary DESC
limit 1 offset 1) as SecondHighestSalary;