DELIMITER //
CREATE TRIGGER InsertPharmacy
AFTER INSERT
ON pharmacy FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM street WHERE street.street=new.street)=0
THEN SIGNAL SQLSTATE  '45000'
	SET MESSAGE_TEXT = 'Can`t insert such street';
END IF;
END //
DELIMITER ;

DROP  TRIGGER InsertPharmacy;