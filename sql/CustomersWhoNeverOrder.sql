SELECT Name
FROM Orders AS o
    RIGHT JOIN Customers AS c
    On c.Id = o.CustomerId
WHERE o.Id IS NULL