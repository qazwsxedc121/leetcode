SELECT A.name
FROM Employee AS A
    JOIN Employee AS B
    ON A.ManagerId = B.Id
WHERE A.Salary > B.Salary