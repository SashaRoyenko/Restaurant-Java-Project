Create Database restaurant;
use restaurant;
DROP TABLE IF EXISTS `user`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(65) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` enum('user','admin') DEFAULT 'user',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_role_idx` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES (1,'Alexandr','Royenko','+380982827486','sasharoyenko@gmail.com','24042000','admin'),(2,'Orest','Shemelyuk','+380976970365','shemelyukorest@gmail.com','11052000','user'),(3,'Nikita','Bortnichuk','+380930613483','nikita.bortnichuk41@gmail.com','13081999','user'),(9,'Vasia','Tereniak','+380681015027','vasya@vasya','11111111','user'),(10,'Test','test','+380964625970','test@test','testTest1','user'),(11,'Адмін','Адмін','+380911111111','admin@admin','adminAdmin2019','admin'),(13,'Finish','Кінець','1234567891','in_the_end@lp.com','1qaz2wsx3edC','user');

 SET NAMES utf8 ;

DROP TABLE IF EXISTS `drink`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drink` (
  `drink_id` int(11) NOT NULL AUTO_INCREMENT,
  `drink_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `drink_volume` decimal(5,2) NOT NULL,
  `drink_price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`drink_id`),
  UNIQUE KEY `name_UNIQUE` (`drink_name`),
  UNIQUE KEY `iddrink_UNIQUE` (`drink_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `drink` VALUES (1,'Cola',0.50,12.50),(2,'Pepsi',0.33,10.50),(3,'Sprite',1.00,20.50),(4,'Apple juice',0.70,8.75),(30,'WILD GOOSE, BC',0.35,150.00),(31,'STRONG BOW',0.44,300.00),(32,'MOJITO',0.50,50.00),(33,'WHISKEY SOUR',0.10,120.00),(34,'JAMESON',0.50,600.00),(35,'CAPTAIN MORGAN',0.70,500.00);


DROP TABLE IF EXISTS `dish`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dish` (
  `dish_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_bin NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `weight` smallint(1) DEFAULT NULL,
  PRIMARY KEY (`dish_id`),
  UNIQUE KEY `iddish_UNIQUE` (`dish_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

LOCK TABLES `dish` WRITE;

INSERT INTO `dish` VALUES (1,'green chicken curry',25.00,200),(2,'Burrata',18.00,120),(3,'MUSSELS',40.00,100),(4,'CAESAR',30.00,170),(5,'CHICKEN BURGER',18.00,110),(6,'VEGETABLE MANCHURIAN',286.00,200),(7,'CHILLI FISH',400.00,350),(8,'CHILLI MUSHROOM',340.00,150),(9,'PANEER PAKORA',260.00,100),(10,'CHICKEN FINGERS',300.00,400);
UNLOCK TABLES;


DROP TABLE IF EXISTS `ingredient`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `ingredient` (
  `ingredient_id` int(11) NOT NULL AUTO_INCREMENT,
  `ingredient_name` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ingredient_id`),
  UNIQUE KEY `name_UNIQUE` (`ingredient_name`),
  UNIQUE KEY `idingridient_UNIQUE` (`ingredient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

LOCK TABLES `ingredient` WRITE;

INSERT INTO `ingredient` VALUES (3,'Apple aubergine'),(2,'Basil'),(26,'Chicken strips'),(4,'Coconut '),(24,'Indian cheese'),(1,'Pork'),(12,'asparagus'),(19,'chillie'),(11,'country bread'),(16,'croutons'),(10,'fennel-tomato broth'),(18,'fish'),(25,'flour'),(8,'french fries'),(14,'herbs'),(9,'jalapeño aioli'),(6,'lettuce'),(22,'mushrooms'),(13,'olive oil'),(17,'parmesan'),(23,'sauce'),(5,'sault'),(15,'smoked whitefish dressing'),(20,'spices'),(7,'tomato'),(21,'vegetables');

UNLOCK TABLES;

DROP TABLE IF EXISTS `dish_ingredients`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `dish_ingredients` (
  `dish_ingredients_id` int(11) NOT NULL AUTO_INCREMENT,
  `dish_dish_id` int(11) NOT NULL,
  `ingredient_ingredient_id` int(11) NOT NULL,
  PRIMARY KEY (`dish_ingredients_id`),
  KEY `fk_ingridient_idx` (`ingredient_ingredient_id`),
  KEY `fk_dish_idx` (`dish_dish_id`),
  CONSTRAINT `fk_dish` FOREIGN KEY (`dish_dish_id`) REFERENCES `dish` (`dish_id`),
  CONSTRAINT `fk_ingridient` FOREIGN KEY (`ingredient_ingredient_id`) REFERENCES `ingredient` (`ingredient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


LOCK TABLES `dish_ingredients` WRITE;

INSERT INTO `dish_ingredients` VALUES (1,1,2),(2,1,3),(3,1,4),(4,2,13),(5,2,12),(6,2,14),(7,3,10),(8,3,11),(9,4,15),(10,4,16),(11,4,17),(12,5,6),(13,5,7),(14,5,8),(15,5,9),(16,5,17),(17,6,19),(18,6,20),(19,6,21),(20,7,19),(21,7,20),(22,7,18),(23,8,19),(24,8,22),(25,8,23),(26,9,24),(27,9,25),(28,9,20),(29,10,26),(30,10,14);

UNLOCK TABLES;

DROP TABLE IF EXISTS `dishes`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `dishes` (
  `dishes_id` int(11) NOT NULL AUTO_INCREMENT,
  `dishes_dish_id` int(11) NOT NULL,
  `order_products_dishes_id` int(11) NOT NULL,
  PRIMARY KEY (`dishes_id`),
  KEY `fk_dishes_dish1_idx` (`dishes_dish_id`),
  KEY `fk_dishes_order_products1_idx` (`order_products_dishes_id`),
  CONSTRAINT `fk_dishes_dish1` FOREIGN KEY (`dishes_dish_id`) REFERENCES `dish` (`dish_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_dishes_order_products1` FOREIGN KEY (`order_products_dishes_id`) REFERENCES `order_products` (`order_products_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

LOCK TABLES `dishes` WRITE;

INSERT INTO `dishes` VALUES (1,1,1),(2,2,1),(6,1,1),(17,4,3),(19,5,3),(22,3,1),(23,3,1),(29,3,8),(30,3,9);

UNLOCK TABLES;


DROP TABLE IF EXISTS `drinks`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drinks` (
  `drinks_id` int(11) NOT NULL AUTO_INCREMENT,
  `drinks_drink_id` int(11) NOT NULL,
  `order_products_drinks_id` int(11) NOT NULL,
  PRIMARY KEY (`drinks_id`),
  KEY `fk_drinks_drink1_idx` (`drinks_drink_id`),
  KEY `fk_drinks_order_products1_idx` (`order_products_drinks_id`),
  CONSTRAINT `fk_drinks_drink1` FOREIGN KEY (`drinks_drink_id`) REFERENCES `drink` (`drink_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_drinks_order_products1` FOREIGN KEY (`order_products_drinks_id`) REFERENCES `order_products` (`order_products_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

LOCK TABLES `drinks` WRITE;

INSERT INTO `drinks` VALUES (2,3,1),(12,4,3),(13,1,3),(14,2,3);

UNLOCK TABLES;

DROP TABLE IF EXISTS `order_products`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_products` (
  `order_products_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_user_id` int(11) NOT NULL,
  PRIMARY KEY (`order_products_id`),
  UNIQUE KEY `order_products_id_UNIQUE` (`order_products_id`),
  KEY `fk_user_idx` (`user_user_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

LOCK TABLES `order_products` WRITE;
INSERT INTO `order_products` VALUES (1,1),(9,2),(3,9),(4,10),(8,11);
UNLOCK TABLES;

DROP TABLE IF EXISTS `order`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `bill` decimal(20,2) DEFAULT '0.00',
  `address` varchar(200) COLLATE utf8_bin NOT NULL,
  `paid` tinyint(1) NOT NULL DEFAULT '0',
  `checked` tinyint(1) DEFAULT '0',
  `user_user_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `orderId_UNIQUE` (`order_id`),
  KEY `fk_order_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_order_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



LOCK TABLES `order` WRITE;
INSERT INTO `order` VALUES (1,'2019-05-25 14:27:29',56.75,'Yangelya 5, 3-15',0,1,2),(6,'2019-05-25 16:47:20',56.75,'32',1,1,2),(7,'2019-05-25 16:52:59',NULL,'123',1,1,2),(8,'2019-06-10 20:05:39',NULL,'1',1,1,2),(9,'2019-06-10 20:05:40',56.75,'1233422',1,1,2),(10,'2019-06-10 20:05:40',56.75,'547567sdf',1,1,2),(11,'2019-06-10 20:05:40',56.75,'vasya',0,1,2),(12,'2019-06-10 22:26:29',136.75,'Test order address',0,0,2),(13,'2019-06-10 22:44:13',136.75,'Dormitor 4',1,1,2),(14,'2019-06-12 12:18:12',140,'Grinchenka 4, 25',1,1,13);
UNLOCK TABLES;
