CREATE DATABASE IF NOT EXISTS `todo` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `todo`;
DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `description` varchar(100) NOT NULL,
                        `status` int(11) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4;

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;

INSERT IGNORE INTO `task` VALUES
                              (1,'Plan family dinner',0),
                              (2,'Help kids with homework',1),
                              (3,'Buy groceries for the week',1),
                              (4,'Schedule doctor appointments',0),
                              (5,'Organize family game night',2),
                              (6,'Clean the living room',1),
                              (7,'Do laundry',0),
                              (8,'Cook dinner',0),
                              (9,'Help kids with school project',1),
                              (10,'Plan family vacation',2),
                              (11,'Go to parent-teacher conference',0),
                              (12,'Bake cookies for school bake sale',0),
                              (13,'Attend kids’ sports game',1),
                              (14,'Walk the dog',0),
                              (15,'Water the plants',2),
                              (16,'Fix the leaky faucet',2),
                              (17,'Mow the lawn',0),
                              (18,'Take out the trash',0),
                              (19,'Wash the car',1),
                              (20,'Plan a birthday party',1),
                              (21,'Buy gifts for the holidays',1),
                              (22,'Call relatives',2),
                              (23,'Plan a movie night',0),
                              (24,'Make a family budget',0),
                              (25,'Go grocery shopping',2),
                              (26,'Pick up dry cleaning',1),
                              (27,'Make lunch for kids',0),
                              (28,'Read bedtime story',1),
                              (29,'Help kids with their chores',0),
                              (30,'Assemble new furniture',0),
                              (31,'Paint the kids’ room',2),
                              (32,'Plan a picnic',2),
                              (33,'Visit grandparents',2),
                              (34,'Organize photos',0),
                              (35,'Clean the garage',1),
                              (36,'Plan a hiking trip',0),
                              (37,'Buy school supplies',1),
                              (38,'Prepare kids for school',0),
                              (39,'Iron clothes',0),
                              (40,'Pack lunches for tomorrow',1),
                              (41,'Do the dishes',0),
                              (42,'Vacuum the house',2),
                              (43,'Change light bulbs',0),
                              (44,'Make a grocery list',2),
                              (45,'Buy new clothes for kids',1),
                              (46,'Plan a surprise for spouse',0),
                              (47,'Decorate the house for holidays',2),
                              (48,'Make breakfast',0),
                              (49,'Clean the kids’ room',0),
                              (50,'Organize a playdate',2);

/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
