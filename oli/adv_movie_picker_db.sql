-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 11, 2025 at 10:50 AM
-- Server version: 5.7.24
-- PHP Version: 8.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `adv_movie_picker_db`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addMovie` (IN `titleIN` VARCHAR(150), IN `lenghtIN` INT(11), IN `genreIdIN` INT(11), IN `ratingIN` DECIMAL(10), IN `ageRestrictionIN` VARCHAR(10))   BEGIN

INSERT INTO `movie`(
	`movie`.`title`,
    `movie`.`lenght`,
    `movie`.`genre_id`,
    `movie`.`rating`,
    `movie`.`age_restriction`
)
VALUES(
	titleIN,
    lenghtIN,
    genreIdIN,
    ratingIN,
    ageRestrictionIN
);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteMovie` (IN `idIN` INT(11))   BEGIN

DELETE FROM `movie` 
WHERE `movie`.`id` = idIN;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllMovie` ()   BEGIN

SELECT * FROM `movie`;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getMovieById` (IN `idIN` INT(11))   BEGIN
 SELECT
 	`movie`.`id` as 'movie_id',
    `movie`.`title`,
    `movie`.`lenght`,
    `movie`.`genre_id`,
    `movie`.`rating`,
    `movie`.`age_restriction`
 FROM `movie`
 WHERE `movie`.`id` = idIN;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateMovie` (IN `titleIN` VARCHAR(150), IN `lenghtIN` INT(11), IN `genreIdIN` INT(11), IN `ratingIN` DECIMAL(10), IN `ageRestrictionIN` VARCHAR(10))   BEGIN 
    UPDATE `movie` SET
    `title`= titleIN,
    `lenght` = lenghtIN,
    `genre_id`= genreIN,
    `rating`= ratingIN,
    `age_restriction` = ageRestrictionIN;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `director`
--

CREATE TABLE `director` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `director`
--

INSERT INTO `director` (`id`, `first_name`, `last_name`) VALUES
(1, 'Francis Ford', 'Coppola'),
(2, 'Steven', 'Spielberg'),
(3, 'Robert', 'Zemeckis'),
(4, 'Frank', 'Darabont'),
(5, 'David', 'Fincher'),
(6, 'Christopher', 'Nolan'),
(7, 'Lana', 'Wachowski'),
(8, 'Lilly', 'Wachowsk'),
(9, 'Denis', 'Villeneuve'),
(10, 'John', 'McTiernan'),
(11, 'George', 'Miller'),
(12, 'Ridley', 'Scott'),
(13, 'Chad', 'Stahelski');

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`id`, `name`) VALUES
(1, 'Drama'),
(2, 'Sci‑Fi'),
(3, 'Action');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `title` varchar(150) NOT NULL,
  `lenght` int(11) NOT NULL COMMENT 'in minutes',
  `genre_id` int(11) NOT NULL,
  `rating` decimal(10,0) NOT NULL,
  `age_restriction` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`id`, `title`, `lenght`, `genre_id`, `rating`, `age_restriction`) VALUES
(1, 'The Godfather', 175, 1, '9', 'R'),
(2, 'Schindler\'s List', 195, 1, '9', 'R'),
(3, 'Forrest Gump', 142, 1, '9', 'PG-13'),
(4, 'The Shawshank Redemption', 142, 1, '9', 'R'),
(5, 'Fight Club', 139, 1, '9', 'R'),
(6, 'Inception', 148, 2, '9', 'PG-13'),
(7, 'The Matrix', 136, 2, '9', 'R'),
(8, 'Blade Runner 2049', 164, 2, '8', 'R'),
(9, 'Interstellar', 169, 2, '9', 'PG-13'),
(10, 'Arrival', 116, 2, '8', 'PG-13'),
(11, 'Die Hard', 132, 3, '8', 'R'),
(12, 'Mad Max: Fury Road', 120, 3, '8', 'R'),
(13, 'Gladiator', 155, 3, '9', 'R'),
(14, 'John Wick', 101, 3, '7', 'R'),
(15, 'The Dark Knight', 152, 3, '9', 'PG-13'),
(16, 'dsads', 121, 1, '1', 'R');

-- --------------------------------------------------------

--
-- Table structure for table `movie_x_director`
--

CREATE TABLE `movie_x_director` (
  `id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `director_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movie_x_director`
--

INSERT INTO `movie_x_director` (`id`, `movie_id`, `director_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 7, 8),
(9, 8, 9),
(10, 9, 6),
(11, 10, 9),
(12, 11, 10),
(13, 12, 11),
(14, 13, 12),
(15, 14, 13),
(16, 15, 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `title` (`title`);

--
-- Indexes for table `movie_x_director`
--
ALTER TABLE `movie_x_director`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `director`
--
ALTER TABLE `director`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `movie_x_director`
--
ALTER TABLE `movie_x_director`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
