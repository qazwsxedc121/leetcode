SELECT B.Name AS Department, A.Name AS Employee, Salary
FROM Employee AS A
    INNER JOIN Department AS B
    ON A.DepartmentId = B.Id
WHERE (SELECT COUNT(DISTINCT(Salary)) FROM Employee
       WHERE DepartmentId = A.DepartmentId AND Salary > A.Salary) < 3
ORDER BY DepartmentId,Salary DESC