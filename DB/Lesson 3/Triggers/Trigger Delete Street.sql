DELIMITER //
CREATE TRIGGER DeleteStreet
AFTER DELETE
ON street FOR EACH ROW
BEGIN
IF (SELECT COUNT(*) FROM pharmacy WHERE pharmacy.street=old.street)>0
THEN SIGNAL SQLSTATE  '45000'
	SET MESSAGE_TEXT = 'Can`t delete street';
END IF;
END //
DELIMITER ;

DROP  TRIGGER DeletePharmacy;