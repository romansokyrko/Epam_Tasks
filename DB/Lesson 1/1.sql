USE computer_firm;
#1
SELECT maker, `type` FROM product WHERE `type`='PC';
#2
SELECT model, ram, screen, price FROM laptop WHERE price>1000 ORDER BY ram, price DESC;
#3
SELECT * FROM printer WHERE color='y' ORDER BY price DESC;
#4
SELECT model, speed, hd, cd, price FROM pc WHERE (cd='12x' OR cd ='24x') AND price<600 ORDER BY speed DESC;

USE ships;
#5
SELECT `name`, class FROM ships ORDER BY `name`;

USE computer_firm;
#6
SELECT * FROM pc WHERE speed>=500 AND price<800 ORDER BY price DESC;
#7
SELECT * FROM printer WHERE `type`!='matrix' AND price<300 ORDER BY `type` DESC;
#8
SELECT model, speed FROM pc WHERE price BETWEEN 400 AND 600 ORDER BY hd;
#9
SELECT pc.model, pc.speed, pc.hd FROM pc, product WHERE (pc.hd=10 OR pc.hd=20) AND pc.model=product.model AND product.maker='A' ORDER BY pc.speed;
#10
SELECT model, speed, hd, price FROM laptop WHERE screen>=12 ORDER BY price DESC;
#11
SELECT model, `type`, price FROM printer WHERE price<300 ORDER BY type DESC;
#12
SELECT model, ram, price FROM laptop WHERE ram=64 ORDER BY screen;
#13
SELECT model, ram, price FROM pc WHERE ram>64 ORDER BY hd;
#14
SELECT model, speed, price FROM pc WHERE speed BETWEEN 500 AND 750 ORDER BY hd DESC;

USE secondary_raw_materials_company;
#15
SELECT * FROM outcome_o WHERE `out`>2000 ORDER BY `date` DESC;
#16
SELECT * FROM income_o WHERE inc BETWEEN 5000 AND 10000 ORDER BY inc;
#17
SELECT * FROM income WHERE `point`=1 ORDER BY inc;
#18
SELECT * FROM outcome WHERE `point`=2 ORDER BY `out`;

use ships;
#19
SELECT * FROM classes WHERE country='Japan' ORDER BY `type`;
#20
SELECT `name`, launched FROM ships WHERE launched BETWEEN 1940 AND 1942 ORDER BY launched DESC; 
#21
SELECT ship, battle, result FROM outcomes WHERE battle='Guadalcanal' ORDER BY ship DESC;
#22
SELECT ship, battle, result FROM outcomes WHERE result='sunk' ORDER BY ship DESC;
#23
SELECT class, displacement FROM classes WHERE displacement>=40000 ORDER BY `type`;

use airport;
#24
SELECT trip_no, town_from, town_to FROM trip WHERE town_from='London' OR town_to='London' ORDER BY time_out;
#25
SELECT trip_no, plane, town_from, town_to FROM trip WHERE plane='TU-134' ORDER BY time_out DESC;
#26
SELECT trip_no, plane, town_from, town_to FROM trip WHERE plane!='IL-86' ORDER BY plane;
#27
SELECT trip_no, town_from, town_to FROM trip WHERE town_from!='Rostov' AND town_to!='Rostov' ORDER BY plane;