# Write your MySQL query statement below
SELECT v.customer_id ,count(*) as  count_no_trans
from Visits v LEFT JOIN Transactions t ON v.visit_id = t.visit_id
 where t.transaction_id IS null
 GROUP BY v.customer_id;