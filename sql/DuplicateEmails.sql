SELECT DISTINCT Email
FROM Person AS P1
WHERE Email = (SELECT DISTINCT Email
    FROM Person AS P2
    WHERE P1.Email = P2.Email
        AND P1.Id != P2.Id)