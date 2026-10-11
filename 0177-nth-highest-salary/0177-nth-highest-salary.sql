CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
        SELECT DISTINCT getNthHighestSalary
        FROM(
            SELECT e.salary AS getNthHighestSalary, DENSE_RANK() OVER(ORDER BY e.salary DESC) AS rnk
            FROM Employee e
        ) AS temp
        WHERE temp.rnk=N

  );
END