USE computer_firm;
#1
SELECT model FROM pc WHERE model LIKE '%1%1%';

USE secondary_raw_materials_company;
#2
SELECT * FROM outcome WHERE `date` LIKE '_____03%';
#3
SELECT * FROM outcome_o WHERE `date` LIKE '________14%';

USE ships;
#4
SELECT `name` FROM ships WHERE `name` LIKE 'W%n';
#5
SELECT `name` FROM ships WHERE `name` LIKE '%e%e%';
#6
SELECT `name`, launched FROM ships WHERE `name` NOT LIKE '%a';
#7
SELECT `name` FROM battles WHERE `name` LIKE '% %' AND `name` NOT LIKE '%c';

USE airport;
#8
SELECT * FROM trip WHERE time_out BETWEEN '1900-01-01 12:00:00' AND '1900-01-01 17:00:00';
#9
SELECT * FROM trip WHERE time_in BETWEEN '1900-01-01 17:00:00' AND '1900-01-01 23:00:00'; 
#10
SELECT `date` FROM pass_in_trip WHERE place LIKE '1_';
#11
SELECT `date` FROM pass_in_trip WHERE place LIKE '%c';
#12
SELECT SUBSTRING_INDEX(`name`, " ", -1) AS last_name FROM passenger WHERE `name` LIKE '% C%';
#13
SELECT SUBSTRING_INDEX(`name`, " ", -1) AS last_name FROM passenger WHERE `name` NOT LIKE '% J%'; 
