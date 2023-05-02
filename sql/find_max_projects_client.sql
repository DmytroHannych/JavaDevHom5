select name, p.Project_count from client c
right join
(SELECT client_id, COUNT(client_id) AS Project_count
FROM project
GROUP BY client_id
HAVING COUNT(client_id) = (
  SELECT MAX(project_count)
  FROM (
    SELECT COUNT(client_id) AS project_count
    FROM project
    GROUP BY client_id
  ) AS project_counts
))p on p.client_id = c.id

