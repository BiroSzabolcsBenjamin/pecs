-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Gép: localhost:3306
-- Létrehozás ideje: 2025. Sze 29. 19:56
-- Kiszolgáló verziója: 5.7.24
-- PHP verzió: 8.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `jax_rs_api_teszt_db`
--

DELIMITER $$
--
-- Eljárások
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addRole` (IN `nameIN` VARCHAR(100))   BEGIN

INSERT INTO `role`(
	`role`.`name`
)
VALUES(
	nameIN
);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteRole` (IN `idIN` INT(11))   BEGIN

UPDATE `role`
SET `role`.`deleted_at` = CURRENT_TIMESTAMP,
	`role`.`is_deleted` = 1
WHERE `role`.`id` = idIN;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUser` (IN `idIN` INT(11))   BEGIN

UPDATE `user`
SET `user`.`deleted_at` = CURRENT_TIMESTAMP,
	`user`.`is_deleted` = 1
WHERE `user`.`id` = idIN;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllRole` ()   BEGIN

SELECT *
FROM `role`
WHERE `role`.`is_deleted` = 0;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllUser` ()   BEGIN

SELECT
	`user`.`id` AS 'user_id',
    `user`.`first_name`,
    `user`.`last_name`,
    `user`.`img`,
    `user`.`email`,
    `user`.`phone`,
    `user`.`guid`,
    `user`.`created_at`,
    `user`.`last_login`,
    `user`.`register_finished_at`
FROM `user`
WHERE `user`.`is_deleted` = 0 AND `user`.`register_finished_at` IS NOT NULL;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getRoleById` (IN `idIN` INT(11))   BEGIN

SELECT *
FROM `role`
WHERE `role`.`id` = idIN AND `role`.`is_deleted` = 0;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserById` (IN `idIN` INT(11))   BEGIN

SELECT
	`user`.`id` AS 'user_id',
    `user`.`first_name`,
    `user`.`last_name`,
    `user`.`img`,
    `user`.`email`,
    `user`.`phone`,
    `user`.`guid`,
    `user`.`created_at`,
    `user`.`last_login`,
    `user`.`register_finished_at`
FROM `user`
WHERE `user`.`id` = idIN AND `user`.`is_deleted` = 0 AND `user`.`register_finished_at` IS NOT NULL;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `registerUser` (IN `firstNameIN` VARCHAR(100), IN `lastNameIN` VARCHAR(100), IN `emailIN` VARCHAR(100), IN `passwordIN` MEDIUMTEXT, IN `phoneIN` VARCHAR(30))   BEGIN

-- Insert into user
INSERT INTO `user`(
	`user`.`first_name`,
    `user`.`last_name`,
    `user`.`email`,
    `user`.`password`,
    `user`.`auth_secret`,
    `user`.`phone`,
    `user`.`guid`,
    `user`.`reg_token`
)
VALUES(
	firstNameIN,
    lastNameIN,
    emailIN,
    SHA2(passwordIN,256),
    "-",
    phoneIN,
    UUID(),
    UUID()
);

-- Insert into user_x_role
SET @user_id = LAST_INSERT_ID();

INSERT INTO `user_x_role`(
	`user_x_role`.`user_id`,
    `user_x_role`.`role_id`
)
VALUES(
	@user_id, -- user_id
    6 -- role_id
);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateRole` (IN `idIN` INT(11), IN `nameIN` VARCHAR(100))   BEGIN

UPDATE `role`
SET `role`.`name` = nameIN
WHERE `role`.`id` = idIN;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUser` (IN `idIN` INT(11), IN `firtNameIN` VARCHAR(100), IN `lastNameIN` VARCHAR(100), IN `emailIN` VARCHAR(100), IN `phoneIN` VARCHAR(30))   BEGIN

UPDATE `user`
SET `user`.`first_name` = firtNameIN,
	`user`.`last_name` = lastNameIN,
    `user`.`email` = emailIN,
    `user`.`phone` = phoneIN
WHERE `user`.`id` = idIN;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `role`
--

INSERT INTO `role` (`id`, `name`, `created_at`, `deleted_at`, `is_deleted`) VALUES
(1, 'updateTest', '2025-09-24 17:35:35', '2025-09-25 09:39:52', 1),
(2, 'role2', '2025-09-24 17:35:35', NULL, 0),
(3, 'role3', '2025-09-24 17:35:35', NULL, 0),
(4, 'role4', '2025-09-24 17:35:35', NULL, 0),
(5, 'role5', '2025-09-24 17:35:35', NULL, 0),
(6, 'test', '2025-09-25 09:33:27', NULL, 0),
(7, 'updateTest2', '2025-09-29 21:56:03', '2025-09-29 21:56:13', 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `img` varchar(255) NOT NULL DEFAULT 'default_path',
  `email` varchar(100) NOT NULL,
  `password` mediumtext,
  `auth_secret` varchar(16) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `guid` varchar(64) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `last_login` datetime DEFAULT NULL,
  `register_finished_at` datetime DEFAULT NULL,
  `reg_token` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `img`, `email`, `password`, `auth_secret`, `phone`, `guid`, `created_at`, `deleted_at`, `is_deleted`, `last_login`, `register_finished_at`, `reg_token`) VALUES
(1, 'asdUpdateTest', 'asd', 'default_path', 'anyad@gmail.com', 'asdasd', 'asd', 'asd', 'asd', '2025-08-19 14:18:49', '2025-09-16 10:18:26', 1, NULL, '2025-09-09 10:20:04', ''),
(2, 'elso2', 'masodik2', 'default_path', 'email2', 'd70248b5d7370271ea6fc490ce66cb358d45e7a921ee5219af9963a4a9b93034', '-', 'asd2', '27377fb8-7f48-11f0-a84c-047c16ad0c4e', '2025-08-22 13:07:07', '2025-09-29 21:50:57', 1, NULL, '2025-09-09 10:20:04', '27377ffc-7f48-11f0-a84c-047c16ad0c4e'),
(3, 'asd', 'asd', 'default_path', 'asd@gmail.com', '8824b75fce97a37823f83ef90075f6063ec897320f979e2df0b928ffc141b2b6', '-', 'asd', '34a9d123-7f4f-11f0-a84c-047c16ad0c4e', '2025-08-22 13:57:36', NULL, 0, NULL, '2025-09-09 10:20:04', '34a9d12b-7f4f-11f0-a84c-047c16ad0c4e'),
(9, 'asd', 'asd', 'default_path', 'asdasdasd@gmail.com', '8824b75fce97a37823f83ef90075f6063ec897320f979e2df0b928ffc141b2b6', '-', 'asd', '40b9addf-87d8-11f0-a687-047c16ad0c4e', '2025-09-02 10:38:51', NULL, 0, NULL, '2025-09-09 10:20:04', '40b9ade6-87d8-11f0-a687-047c16ad0c4e'),
(10, 'asd', 'asd', 'default_path', 'asdasdasd2@gmail.com', '8824b75fce97a37823f83ef90075f6063ec897320f979e2df0b928ffc141b2b6', '-', 'asd', '5e462dee-9d6c-11f0-9cfc-047c16ad0c4e', '2025-09-29 21:42:01', NULL, 0, NULL, NULL, '5e462e26-9d6c-11f0-9cfc-047c16ad0c4e'),
(11, 'asd', 'asd', 'default_path', 'asdasdasd3@gmail.com', '8824b75fce97a37823f83ef90075f6063ec897320f979e2df0b928ffc141b2b6', '-', 'asd', '9866aff8-9d6d-11f0-9cfc-047c16ad0c4e', '2025-09-29 21:50:48', NULL, 0, NULL, NULL, '9866affe-9d6d-11f0-9cfc-047c16ad0c4e');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user_x_role`
--

CREATE TABLE `user_x_role` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `user_x_role`
--

INSERT INTO `user_x_role` (`id`, `user_id`, `role_id`) VALUES
(1, 10, 6),
(2, 11, 6);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `email_2` (`email`),
  ADD KEY `id` (`id`),
  ADD KEY `first_name` (`first_name`),
  ADD KEY `last_name` (`last_name`);

--
-- A tábla indexei `user_x_role`
--
ALTER TABLE `user_x_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `role_id` (`role_id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT a táblához `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT a táblához `user_x_role`
--
ALTER TABLE `user_x_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
