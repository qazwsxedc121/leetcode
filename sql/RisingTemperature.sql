SELECT Id
FROM Weather AS a
WHERE Temperature > (SELECT Temperature
    FROM Weather AS b
    WHERE DATEDIFF(a.Date,b.Date) = 1)