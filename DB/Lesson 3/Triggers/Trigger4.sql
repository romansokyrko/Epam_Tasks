DELIMITER //
CREATE TRIGGER UpdatePost
BEFORE UPDATE
ON post FOR EACH ROW
BEGIN
	IF new.post != old.post
    THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Can`t update post';
	END IF;
END //
DELIMITER ;

DROP  TRIGGER InsertEmployeeTrigger3;