-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: movies
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movie_list`
--

DROP TABLE IF EXISTS `movie_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_list` (
  `id` int NOT NULL,
  `movie_name` varchar(60) NOT NULL,
  `movie_director` varchar(45) NOT NULL,
  `movie_category` varchar(45) NOT NULL,
  `movie_imdb` double NOT NULL,
  `movie_hint` varchar(400) NOT NULL,
  `movie_date` int NOT NULL,
  `movie_price` varchar(10) NOT NULL,
  `movie_time` varchar(10) NOT NULL,
  `movie_image_url` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_list`
--

LOCK TABLES `movie_list` WRITE;
/*!40000 ALTER TABLE `movie_list` DISABLE KEYS */;
INSERT INTO `movie_list` VALUES (1,'The Shawshank Redemption ','Frank Darabont ','Drama',9.3,'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.',1994,'10 dollars','142 min',''),(2,'The Godfather','Francis Ford Coppola ','Crime, Drama',9.2,'An organized crime dynasty\'s aging patriarch transfers control of his clandestine empire to his reluctant son.',1972,'15 dollars','175 min',NULL),(3,'The Dark Knight ','Christopher Nolan ','Action, Crime, Drama',9,'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.',2008,'12 dollars','152 min',NULL),(4,'The Godfather: Part II ','Francis Ford Coppola','Crime, Drama',9,'The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.',1974,'15 dollars','202 min',NULL),(5,'12 Angry Men','Sidney Lumet ','Crime, Drama',9,'A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.',1957,'10 dollars','96 min',NULL),(6,'The Lord of the Rings: The Return of the King','Peter Jackson ','Action, Adventure, Drama',8.9,'Gandalf and Aragorn lead the World of Men against Sauron\'s army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.',2003,'20 dollars','201 min',NULL),(7,'Pulp Fiction','Quentin Tarantino ','Crime, Drama',8.9,'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.',1994,'7 dollars','154 min',NULL),(8,'Schindler\'s List ','Steven Spielberg ','Biography, Drama, History',8.9,'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis',1993,'5 dollars','195 min',NULL),(9,'Inception','Christopher Nolan ','Action, Adventure, Sci-Fi',8.8,'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.',2010,'9 dollars','148 min',NULL),(10,'Fight Club','David Fincher','Drama',8.8,'An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.',1999,'13 dollars','139 min',NULL),(11,' The Lord of the Rings: The Fellowship of the Ring ','Peter Jackson ','Action, Adventure, Drama',8.8,'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.',2001,'20 dollars','178 min',''),(12,'Forrest Gump','Robert Zemeckis','Drama, Romance',8.8,'The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate and other historical events unfold through the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.',1994,'10 dollars','142 min',NULL),(13,'The Good, the Bad and the Ugly ','Sergio Leone','Western',8.8,'A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.',1966,'8 dollars','178 min',''),(14,'The Lord of the Rings: The Two Towers','Peter Jackson ','Action, Adventure, Drama',8.7,'While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron\'s new ally, Saruman, and his hordes of Isengard.',2002,'20 dollars','179 min',NULL),(15,'The Matrix','Lana Wachowski, Lilly Wachowski','Action, Sci-Fi',8.7,'When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.',1999,'15 dollars','142 min',NULL),(16,'Goodfellas ','Martin Scorsese ','Biography, Crime, Drama',8.7,'The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.',1990,'10 dollars','146 min',''),(17,'Star Wars: Episode V - The Empire Strikes Back','Irvin Kershner',' Action, Adventure, Fantasy',8.7,'After the Rebels are brutally overpowered by the Empire on the ice planet Hoth, Luke Skywalker begins Jedi training with Yoda, while his friends are pursued by Darth Vader and a bounty hunter named Boba Fett all over the galaxy.',1980,'12 dollars','124 min',''),(18,'One Flew Over the Cuckoo\'s Nest ','Milos Forman ','Drama',8.7,'A criminal pleads insanity and is admitted to a mental institution, where he rebels against the oppressive nurse and rallies up the scared patients.',1975,'5 dollars','133 min',NULL),(19,'Hamilton ','Thomas Kail ','Biography, Drama, History',8.6,'The real life of one of America\'s foremost founding fathers and first Secretary of the Treasury, Alexander Hamilton. Captured live on Broadway from the Richard Rodgers Theater with the original Broadway cast.',2020,'15 dollars','160 min',NULL),(20,'Parasite','Bong Joon Ho','Comedy, Drama, Thriller',8.6,'Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.',2019,'12 dollars','132 min','');
/*!40000 ALTER TABLE `movie_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-20 14:47:28
