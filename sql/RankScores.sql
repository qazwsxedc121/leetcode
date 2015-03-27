SELECT Z.score, W.Rank
FROM (SELECT @row:=0) a,
	Scores AS Z
	LEFT JOIN
	(SELECT score,@row:=@row+1 AS Rank
    FROM (SELECT Score FROM Scores AS Y
		GROUP BY Score
		ORDER BY Score DESC) AS X) AS W
	ON Z.score = W.score
ORDER BY W.Rank