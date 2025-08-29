DROP TABLE IF EXISTS medical_records;

CREATE TABLE medical_records (
    id INT PRIMARY KEY,
    patient_name VARCHAR(255),
    diagnosis VARCHAR(255),
    bill_amount INT,
    patient_age INT
);

INSERT INTO medical_records (id, patient_name, diagnosis, bill_amount, patient_age) VALUES
(1, 'John Smith', 'Hypertension', 5000, 45),
(2, 'Jane Doe', 'Diabetes', 6000, 50),
(3, 'Peter Jones', 'Asthma', 4500, 35),
(4, 'Mary Williams', 'Hypertension', 5200, 48),
(5, 'David Brown', 'Diabetes', 6100, 55),
(6, 'Susan Davis', 'Arthritis', 7000, 60),
(7, 'Robert Miller', 'Hypertension', 4800, 42),
(8, 'Linda Wilson', 'Diabetes', 6300, 58),
(9, 'Michael Moore', 'Asthma', 4600, 38),
(10, 'Karen Taylor', 'Hypertension', 5100, 47);