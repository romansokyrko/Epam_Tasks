USE computer_firm;
#1
SELECT DISTINCT maker FROM product  WHERE `type`='PC' AND maker NOT IN (SELECT maker FROM product WHERE `type`='Laptop');
#2
SELECT DISTINCT maker FROM product WHERE `type`='PC' AND maker!=ALL (SELECT maker FROM product WHERE `type`='Laptop'); 
#3
SELECT DISTINCT maker FROM product WHERE `type` = 'PC' AND NOT maker=ANY (SELECT maker FROM product WHERE `type`='Laptop'); 
#4
SELECT DISTINCT maker FROM product  WHERE `type`='PC' AND maker IN (SELECT maker FROM product WHERE `type`='Laptop');
#5
SELECT DISTINCT maker FROM product  WHERE `type`='PC' AND NOT maker!=ALL (SELECT maker FROM product WHERE `type`='Laptop');
#6
SELECT DISTINCT maker FROM product  WHERE `type`='PC' AND maker=ANY (SELECT maker FROM product WHERE `type`='Laptop');