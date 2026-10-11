# Write your MySQL query statement below

-- select DISTINCT SecondHighestSalary
-- from(   
--     select e.salary AS SecondHighestSalary,
--         DENSE_RANK() OVER (ORDER BY e.salary DESC) AS rnk
--     from Employee e
-- )  AS temp
-- where rnk=2;

SELECT(
    SELECT DISTINCT SecondHighestSalary
    FROM(
        SELECT e.salary AS SecondHighestSalary, DENSE_RANK() OVER(ORDER BY e.salary DESC) AS rnk
        FROM Employee e
    ) AS temp
    WHERE rnk=2
) AS SecondHighestSalary;

