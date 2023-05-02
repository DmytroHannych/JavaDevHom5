select project_id, Sum(salary)*p.MonthDiff as Salary from project_worker pw
left join worker w on w.id = pw.worker_id
left join (select id, DATEDIFF(MONTH, start_date, finish_date) AS MonthDiff from project) p on p.id = pw.project_id
group by project_id, p.MonthDiff
order by Salary desc