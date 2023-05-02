INSERT INTO worker (name, birthday, level, salary)
 VALUES
 ('Petro', '1997-01-07','Junior', 1200),
 ('Ivan', '1998-10-17','Trainee', 850),
 ('Alex', '2000-01-12','Trainee', 800),
 ('Iryna', '1993-08-27','Middle', 2800),
 ('Maryna', '2003-11-11','Junior', 1000),
 ('Ander', '2002-12-17','Senior', 4800),
 ('Oleg', '1996-05-05','Middle', 2400),
 ('Olga', '1995-06-06','Junior', 1100),
 ('Yriy', '1998-02-25','Middle', 2500),
 ('Dmytro','1997-02-07','Senior', 5100);

INSERT INTO client (id, name) VALUES
   (1,'Igor'),
   (2,'Alex'),
   (3,'Bruno'),
   (4,'Fill'),
   (5,'Alex2');
INSERT INTO project (id, client_id, start_date, finish_date) VALUES
(1, 1, '2020-05-12','2021-05-05'),
(2, 2, '2021-01-12','2021-12-05'),
(3, 3, '2019-08-19','2022-04-05'),
(4, 4, '2021-02-02','2022-01-05'),
(5, 5, '2020-11-11','2020-12-30'),
(6, 1, '2022-01-02','2022-07-15'),
(7, 5, '2018-04-20','2019-01-01'),
(8, 3, '2021-09-10','2022-01-13'),
(9, 4, '2021-11-03','2022-02-07'),
(10, 5, '2022-08-25','2019-04-04');

INSERT INTO project_worker (project_id, worker_id) VALUES
(1,1),
(2,4),
(3,8),
(4,9),
(5,2),
(6,5),
(7,7),
(8,3),
(9,10),
(10,6);



