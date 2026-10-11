CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
        select DISTINCT getNthHighestSalary
        from(
            select e.salary AS getNthHighestSalary, DENSE_RANK() OVER(ORDER BY e.salary DESC) AS rnk
            from Employee e
        ) AS temp
        where temp.rnk=N

  );
END