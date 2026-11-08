# Write your MySQL query statement below
SELECT contest_id ,
Round(
    Count(user_id) *100 /
    (SELECT COUNT(user_id) from Users)
    , 2
) as percentage 
FROM Register 
Group by contest_id
order by percentage desc, contest_id asc;