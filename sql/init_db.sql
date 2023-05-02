CREATE TABLE worker (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR NOT NULL CHECK (LENGTH(name) >= 2 AND LENGTH(name) <=1000),
birthday DATE CHECK ( birthday > '1900-01-01'),
level VARCHAR (20) NOT NULL CHECK (level in ('Trainee', 'Junior', 'Middle', 'Senior')),
salary INT CHECK (salary >= 100 AND salary <= 100000)
);

CREATE TABLE client (
id INT NOT NULL PRIMARY KEY,
name VARCHAR NOT NULL CHECK(LENGTH(name) >= 2 AND LENGTH(name) <=1000)
);

CREATE TABLE project (
id INT NOT NULL PRIMARY KEY,
client_id INT,
start_date DATE,
finish_date DATE
);

CREATE TABLE project_worker (
project_id INT,
 worker_id INT,
PRIMARY KEY (project_id, worker_id),
FOREIGN KEY (project_id) REFERENCES project(id),
FOREIGN KEY (worker_id) REFERENCES worker(id)
);