select id AS NAME, DATEDIFF(MONTH, p.start_date, p.finish_date) AS MonthDiff from project p
ORDER BY MONTHDIFF DESC
LIMIT 1;
