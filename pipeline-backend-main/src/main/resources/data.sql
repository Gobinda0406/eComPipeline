DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  dept VARCHAR(250) NOT NULL
);

INSERT INTO employees (id, name, dept) VALUES
  ('1', 'Debojit', 'IT'),
  ('2', 'Gobindo', 'IT');