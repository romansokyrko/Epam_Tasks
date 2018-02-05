DELIMITER //
CREATE PROCEDURE insert_employee(
	surname VARCHAR(30),
    name CHAR(30),
    midle_name VARCHAR(30),
    identity_number CHAR(10),
    passport CHAR(10),
    experience DECIMAL (10, 1),
    birthday DATE,
    post VARCHAR(15),
    pharmacy_id INT)
INSERT INTO employee (
			surname, 
            name, 
            midle_name,
            identity_number,
            passport,
            experience,
            birthday,
            post,
            pharmacy_id) VALUES (
            surname, 
            name, 
            midle_name,
            identity_number,
            passport,
            experience,
            birthday,
            post,
            pharmacy_id)
	
//
DELIMITER ;

DROP PROCEDURE insert_employee;