SELECT DISTINCT a.Num
FROM Logs AS a, Logs AS b, Logs AS c
WHERE a.Num = b.Num
    AND b.Num = c.Num
    AND b.Id = a.Id + 1
    AND c.Id = b.Id + 1