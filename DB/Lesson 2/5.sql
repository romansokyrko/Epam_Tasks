USE computer_firm;
#1
SELECT DISTINCT maker FROM product WHERE EXISTS (SELECT * FROM pc WHERE model=product.model);
#2
SELECT DISTINCT maker FROM product WHERE EXISTS (SELECT * FROM pc WHERE model=product.model AND speed>=750);
#3
SELECT DISTINCT maker FROM product WHERE EXISTS (SELECT * FROM pc WHERE model=product.model AND speed>=750) AND maker IN (SELECT maker FROM product WHERE EXISTS (SELECT * FROM laptop WHERE model=product.model AND speed>=750));
#4
SELECT * FROM product p1 WHERE `type`='Printer' AND EXISTS (SELECT *  FROM product p2 WHERE maker=p1.maker AND EXISTS (SELECT * FROM pc WHERE p2.model=model AND speed IN (SELECT MAX(speed) max FROM pc)));

USE ships;
#5
SELECT `name`, launched, displacement FROM ships LEFT JOIN classes USING(class) WHERE launched>1922 AND `type`='bb' AND displacement>35000;

SELECT `name`, launched, classes.displacement FROM ships, classes WHERE ships.class=classes.class AND launched>1922 AND EXISTS(SELECT * FROM classes WHERE ships.class=class AND `type`='bb' AND displacement>35000);
