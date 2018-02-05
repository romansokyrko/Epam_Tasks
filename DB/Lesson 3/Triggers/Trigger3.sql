DELIMITER //
CREATE TRIGGER CheckMinistryCodeMedicine
AFTER INSERT
ON medicine FOR EACH ROW
BEGIN
IF NOT(convert(new.ministry_code USING cp1251) RLIKE convert('^[^МП][^МП]-[0-9][0-9][0-9]-[0-9][0-9]$' USING cp1251))
THEN SIGNAL SQLSTATE  '45000'
	SET MESSAGE_TEXT = 'Can`t insert such ministry_code: wrong format!';
END IF;
END //
DELIMITER ;

DROP  TRIGGER InsertEmployeeTrigger3;