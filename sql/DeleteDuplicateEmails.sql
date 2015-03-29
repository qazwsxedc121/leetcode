DELETE a.*
FROM Person AS a
    INNER JOIN (SELECT MIN(Id) AS min_id, Email
        FROM Person
        GROUP BY Email) AS b
    ON a.Id > b.min_id
        AND a.Email = b.Email