SELECT b.Name AS Department,a.Name AS Employee,Salary
FROM Employee AS a
    JOIN Department AS b
    ON a.DepartmentId = b.Id
WHERE Salary = (SELECT MAX(Salary)
    FROM Employee AS c
    WHERE a.DepartmentId = c.DepartmentId)