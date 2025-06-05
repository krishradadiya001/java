-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2024 at 01:59 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gamezone`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `user_name` varchar(30) NOT NULL,
  `game_name` varchar(30) NOT NULL,
  `booking_date` date NOT NULL,
  `duration` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`user_name`, `game_name`, `booking_date`, `duration`) VALUES
('krish', 'horse', '2024-08-16', 30),
('kenil', 'bikeracing', '2024-11-23', 20),
('romil', 'tic tac toe', '2024-02-21', 30),
('darshan', 'chess', '2024-06-19', 50),
('kk', 'horse', '2024-02-12', 20);

-- --------------------------------------------------------

--
-- Table structure for table `games`
--

CREATE TABLE `games` (
  `game_name` varchar(30) NOT NULL,
  `game_type` varchar(30) NOT NULL,
  `availability` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `games`
--

INSERT INTO `games` (`game_name`, `game_type`, `availability`, `price`) VALUES
('carracing', 'multiplayer', 0, 200),
('bikeracing', 'multiplayer', 0, 300),
('tic tac toe', 'multiplayer', 0, 100),
('snack', 'multiplayer', 0, 400),
('horse', 'singleplayer', 1, 500),
('chess', 'boardgame', 1, 250),
('ludo', 'boardtype', 1, 230),
('kbcgame', 'quiztype', 1, 250),
('carrom', 'boardtype', 0, 350);

-- --------------------------------------------------------

--
-- Table structure for table `leaderboard`
--

CREATE TABLE `leaderboard` (
  `user_name` varchar(30) NOT NULL,
  `game_name` varchar(30) NOT NULL,
  `score` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `leaderboard`
--

INSERT INTO `leaderboard` (`user_name`, `game_name`, `score`) VALUES
('krish', 'horse', 500),
('darshan', 'carracing', 300),
('romil', 'snack', 100),
('romil', 'tic tac toe', 200),
('kenil', 'chess', 350),
('ronak', 'carrom', 550);

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `user_name` varchar(30) NOT NULL,
  `amount` int(11) NOT NULL,
  `payment_method` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`user_name`, `amount`, `payment_method`) VALUES
('krish', 300, 'card'),
('krish', 300, 'card'),
('darshan', 400, 'cash'),
('ronak', 500, 'card'),
('romil', 200, 'card'),
('rushil', 550, 'card');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_name` varchar(30) NOT NULL,
  `userID` varchar(100) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_name`, `userID`, `password`) VALUES
('krish', 'krishradadiya19@gmail.com', 'Krish@12'),
('darshan', 'nakumdarshan@gmail.com', 'Nakum@22'),
('kenil', 'kenilbabariya12@gmail.com', 'Krish@123'),
('romil', 'romilmonapara12@gmail.com', 'Romil@123'),
('ronak', 'ronakhirapara1@gmail.com', 'Ronak@12'),
('rushil', 'rushilkotadiya1@gmail.com', 'Rushil@12'),
('kk', 'kk12@gmail.com', 'Kk123@123');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
