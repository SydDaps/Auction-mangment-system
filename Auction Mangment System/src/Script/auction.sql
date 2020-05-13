CREATE TABLE Customers (
    cusID int NOT NULL AUTO_INCREMENT,
    cusName varChar(100)  UNIQUE,
    cusPassword varchar(100) NOT NULL,
     isCusLoggedIn bool ,
    PRIMARY KEY (cusID)
    );
-- INSERT INTO Customers (cusName,cusPassword)
-- VALUES ("test", "2131") ;

-- CREATE TABLE aucItems (
--     itemID int NOT NULL AUTO_INCREMENT,
--     itemName varChar(100) ,
--     itemPrice decimal(15,2),
--     PRIMARY KEY (itemID)
-- );

-- CREATE TABLE bids (
--     bidID int NOT NULL  AUTO_INCREMENT,
--     cusID int,
--     itemID int,
--     bidAmount decimal(15,2),
--     PRIMARY KEY (bidID),
--     FOREIGN KEY (cusID) REFERENCES customers(cusID),
-- 	FOREIGN KEY (itemID) REFERENCES aucItems(itemID)
-- );

-- INSERT INTO aucItems (itemName,itemPrice)
-- VALUES 
--     ("Typewriter", 3000.00),
--     ("Old car", 23000.00),
--     ("Shoe", 43000.00),
--     ("Mustang", 323000.00);
--     
    
-- INSERT INTO bids (cusID,itemID,bidAmount)
-- VALUES 
--     (3,3, 3000.00),
-- 	(2,3, 4000.00),
-- 	(1,3, 5000.00),
-- 	(3,4, 3000.00),
-- 	(1,4, 3000.00);
   
   
    
-- SELECT bids.bidID, customers.cusName, aucItems.itemID, bids.bidAmount
-- FROM ((bids
-- INNER JOIN Customers ON bids.cusID = customers.cusID)
-- INNER JOIN aucItems ON bids.itemID = aucItems.itemID)
-- where aucItems.itemID = 4 ORDER BY bidAmount DESC;
    
-- CREATE TABLE timeKeeper(
--     timeKeeperID int NOT NULL  AUTO_INCREMENT,
--     itemID int,
--     stopTime time,
--     isSold boolean DEFAULT false,
--     PRIMARY KEY (timeKeeperID),
-- 	FOREIGN KEY (itemID) REFERENCES aucItems(itemID)
-- ); 
--     

-- CREATE TABLE bids (
--     bidID int NOT NULL  AUTO_INCREMENT,
--     cusID int,
--     itemID int,
--     bidAmount decimal(15,2),
--     PRIMARY KEY (bidID),
--     FOREIGN KEY (cusID) REFERENCES customers(cusID),
-- 	FOREIGN KEY (itemID) REFERENCES aucItems(itemID)
-- );

-- SELECT timeKeeper.itemID,  aucItems.itemID, timeKeeper.isSold
-- FROM (timeKeeper
-- INNER JOIN aucItems ON timeKeeper.itemID = aucItems.itemID)
-- where isSold = true;

-- CREATE TABLE aucItems (
--     itemID int NOT NULL AUTO_INCREMENT,
--     itemName varChar(100) ,
--     itemPrice decimal(15,2),
--     onScreenNow boolean,
--     PRIMARY KEY (itemID)
-- );

-- INSERT INTO aucItems (itemName,itemPrice,onScreenNow)
-- VALUES 
--     ("Typewriter", 3000.00,true),
--     ("Old car", 23000.00,true),
--     ("Shoe", 43000.00,true),
--     ("Mustang", 323000.00,true),
--     ("radio", 400.00,false),
-- 	("dummy", 323000.00,true),
-- 	("Gameboy", 3000.00,false);

-- SELECT timeKeeper.itemID,  aucItems.itemID, timeKeeper.isSold
-- FROM (timeKeeper
-- INNER JOIN aucItems ON timeKeeper.itemID = aucItems.itemID)
-- where isSold = true; 


-- scrirpt
CREATE TABLE aucItems (
    itemID int NOT NULL AUTO_INCREMENT,
    itemName varChar(100) ,
    itemPrice decimal(15,2),
    onScreenNow boolean Default true,
    PRIMARY KEY (itemID)
);

INSERT INTO aucItems (itemName,itemPrice)
VALUES 
 --    ("Typewriter", 1000.00),
    ("Old car", 2000.00),
    ("Shoe", 3000.00),
    ("Mustang", 4000.00),
    ("radio", 5000.00),
	   ("cd", 6000.00),
	   ("Gameboy", 7000.00),
	   ("Green Camera", 8000.00),
	   ("Green car", 9000.00),
	   ("Vinyl", 10000.00),
	   ("Motor", 11000.00),
	   ("Abstract", 12000.00),
	   ("First Computer", 13000.00),
	   ("Red Car", 14000.00),
	   ("Old Camera", 15000.00),
	   ("telephone", 16000.00);

CREATE TABLE bids (
    bidID int NOT NULL  AUTO_INCREMENT,
    cusID int,
    itemID int,
    bidAmount decimal(15,2),
    isSuccess boolean default false,
    PRIMARY KEY (bidID),
    FOREIGN KEY (cusID) REFERENCES customers(cusID),
	FOREIGN KEY (itemID) REFERENCES aucItems(itemID)
);

CREATE TABLE timeKeeper(
    timeKeeperID int NOT NULL  AUTO_INCREMENT,
    itemID int,
    stopTime time,
    isSold boolean DEFAULT false,
    PRIMARY KEY (timeKeeperID),
	FOREIGN KEY (itemID) REFERENCES aucItems(itemID)
); 


-- SELECT 
--     *
-- FROM
--     bids where cusID = 1 AND isSuccess = true;

-- SELECT  aucItems.itemNAME, bids.bidAmount FROM ((bids
-- INNER JOIN Customers ON bids.cusID = customers.cusID)
-- INNER JOIN aucItems ON bids.itemID = aucItems.itemID)
-- where customers.cusID = 1
-- ORDER BY bidAmount DESC;

-- SELECT   customers.cusID, customers.cusName, aucItems.itemName , bids.bidAmount,  bids.isSuccess FROM ((bids
-- INNER JOIN Customers ON bids.cusID = customers.cusID)
-- INNER JOIN aucItems ON bids.itemID = aucItems.itemID);


-- SELECT bids.bidID, customers.cusName, aucItems.itemID, MAX(bids.bidAmount) FROM ((bids 
-- INNER JOIN Customers ON bids.cusID = customers.cusID) INNER JOIN aucItems ON bids.itemID = aucItems.itemID)
-- where aucItems.itemID = 12;

-- select * from aucItems;


