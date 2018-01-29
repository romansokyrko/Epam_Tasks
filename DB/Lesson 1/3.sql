USE computer_firm;
#1
SELECT maker, `type`, speed, hd FROM product JOIN pc USING(model) WHERE hd<=8;
#2
SELECT DISTINCT maker FROM product JOIN pc USING(model) WHERE speed>=600;
#3
SELECT DISTINCT maker FROM product JOIN laptop USING(model) WHERE speed<=500;
#4
SELECT l1.model, l2.model, l1.ram, l1.hd FROM laptop l1, laptop l2 WHERE l1.model>l2.model AND l1.ram=l2.ram AND l1.hd=l2.hd;

USE ships;
#5
SELECT c1.country country, c1.class, c1.`type`, c2.class, c2.`type` FROM classes c1, classes c2 WHERE c1.country=c2.country AND c1.`type`='bc' AND c2.`type`='bb';

USE computer_firm;
#6
SELECT DISTINCT pc.model, maker FROM pc LEFT JOIN product USING(model) WHERE price<600;
#7
SELECT DISTINCT printer.model, maker FROM printer LEFT JOIN product USING(model) WHERE price>300; 
#8
SELECT pc.model, maker, price FROM pc LEFT JOIN product USING(model); 
#9
SELECT product.model, maker, price FROM pc RIGHT JOIN product USING(model) WHERE `type`='pc'; 
#10
SELECT maker, `type`, laptop.model, speed FROM laptop LEFT JOIN product USING(model) WHERE speed>600; 

USE ships;
#11
SELECT ships.*, displacement FROM ships LEFT JOIN classes USING(class);
#12
SELECT outcomes.*, `date` FROM outcomes LEFT JOIN battles ON battles.`name`=outcomes.battle WHERE result!='sunk';
#13
SELECT ships.*, country FROM ships LEFT JOIN classes USING(class);

USE airport;
#14
SELECT trip.*, `name` AS company FROM trip LEFT JOIN company USING(ID_comp) WHERE plane='Boeing';
#15
SELECT passenger.*, `date` FROM passenger LEFT JOIN pass_in_trip USING(ID_psg);