SELECT name, birthday, 'YOUNGEST' AS TYPE FROM worker
WHERE birthday = (SELECT MIN(birthday) FROM worker)
UNION
SELECT name, birthday, 'OLDEST' AS TYPE FROM worker
WHERE birthday = (SELECT MAX(birthday) FROM worker);
