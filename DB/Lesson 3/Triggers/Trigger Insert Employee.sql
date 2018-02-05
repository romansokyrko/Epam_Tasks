DELIMITER //
CREATE TRIGGER InsertEmployee
AFTER INSERT
ON employee FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM post WHERE post=new.post)=0
THEN SIGNAL SQLSTATE  '45000'
	SET MESSAGE_TEXT = 'Can`t insert such post';
END IF;
IF (SELECT COUNT(*) FROM pharmacy WHERE pharmacy.id=new.pharmacy_id)=0
THEN SIGNAL SQLSTATE  '45000'
	SET MESSAGE_TEXT = 'Can`t insert such pharmacy_id';
END IF;
END //
DELIMITER ;

DROP  TRIGGER InsertEmployee;