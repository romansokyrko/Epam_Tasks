USE computer_firm;
#1
SELECT model, price FROM printer WHERE price IN (SELECT MAX(price) FROM printer);
#2
SELECT model, speed FROM laptop WHERE speed<ALL(SELECT speed FROM pc); 

SELECT model, speed FROM laptop WHERE speed< (SELECT MIN(speed) FROM pc); 
#3
SELECT model, price FROM printer WHERE price IN (SELECT MIN(price) FROM printer WHERE color='y') AND  color='y';
#4
SELECT maker, COUNT(*) count FROM product WHERE `type`='pc' GROUP BY maker HAVING COUNT(*)>=2;
#5
SELECT AVG(hd) avg FROM pc LEFT JOIN product USING(model) WHERE maker IN (SELECT maker FROM product WHERE type='printer'); 