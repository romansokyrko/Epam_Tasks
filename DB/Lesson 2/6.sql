USE computer_firm;
#1
SELECT CONCAT('середня ціна=', `avg`) AS `avg` FROM (SELECT AVG(price) as `avg` FROM laptop) s;
#2
SELECT CONCAT('код: ', code) code, CONCAT('модель: ', model) model, CONCAT('швидкість: ', speed) speed, CONCAT('ram: ', ram) ram, CONCAT('hd: ', hd) hd, CONCAT('cd: ', cd) cd, CONCAT('ціна: ', price) price FROM pc;

USE `secondary_raw_materials_company`;
#3
SELECT CONCAT(YEAR(date),'.', MONTH(date),',',DAY(date)) date FROM income;

USE ships;
#4
SELECT ship, battle, REPLACE(REPLACE(REPLACE(result, 'OK', 'цілий'),'damaged', 'пошкоджений'),'sunk','потоплений') result FROM outcomes;

SELECT ship, battle, CASE WHEN result = 'OK' THEN 'цілий' WHEN result = 'damaged' THEN 'пошкоджений' ELSE 'потоплений' END result FROM outcomes;
