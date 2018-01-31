USE computer_firm;
#1
SELECT DISTINCT maker, (SELECT COUNT(*) FROM pc JOIN product USING(model) WHERE maker=p1.maker) pc,
	(SELECT COUNT(*) FROM laptop JOIN product USING(model) WHERE maker=p1.maker) laptop, 
    (SELECT COUNT(*) FROM printer JOIN product USING(model) WHERE maker=p1.maker) printer
    FROM product p1;
#2
SELECT DISTINCT maker, (SELECT AVG(screen) FROM laptop JOIN product USING(model) WHERE maker=p1.maker) avg FROM product p1 WHERE type='laptop';
#3
SELECT DISTINCT maker, (SELECT MAX(price) FROM pc JOIN product USING(model) WHERE maker=p1.maker) max_price FROM product p1 WHERE type='pc';
#4
SELECT DISTINCT maker, (SELECT MIN(price) FROM pc JOIN product USING(model) WHERE maker=p1.maker) max_price FROM product p1 WHERE type='pc';
#5
SELECT DISTINCT speed, (SELECT AVG(price) FROM pc WHERE speed=p1.speed) avg_price FROM pc p1 WHERE speed>600;