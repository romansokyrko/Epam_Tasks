DELIMITER //
CREATE TRIGGER CheckIdentityNumberEmployee
AFTER INSERT
ON employee FOR EACH ROW
BEGIN
IF (new.identity_number RLIKE '[0]{2}$')
THEN SIGNAL SQLSTATE  '45000'
	SET MESSAGE_TEXT = 'Can`t insert such id: id can`t end with 00';
END IF;
END //
DELIMITER ;

DROP  TRIGGER CheckIdentityNumberEmployee;