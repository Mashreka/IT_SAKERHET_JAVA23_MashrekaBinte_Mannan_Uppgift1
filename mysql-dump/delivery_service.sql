-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Oct 03, 2024 at 09:24 PM
-- Server version: 8.0.35
-- PHP Version: 8.2.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `delivery_service`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `created_at`, `updated_at`) VALUES
(2, 'mas', '6b51d431df5d7f141cbececcf79edf3dd861c3b4069f0b11661a3eefacbba918', 'mas', '2024-09-30 23:22:01', '2024-09-30 23:22:01'),
(3, 'rah', '6b51d431df5d7f141cbececcf79edf3dd861c3b4069f0b11661a3eefacbba918', 'rah', '2024-09-30 23:46:05', '2024-09-30 23:46:05'),
(4, 'nou', 'd89d557fdf6330ffa41b722f7359660f988d541996df52bbdd8c3c6c2f8f3ce8', 'nou', '2024-10-01 00:00:43', '2024-10-01 00:00:43'),
(7, 'Sadaf', '6b51d431df5d7f141cbececcf79edf3dd861c3b4069f0b11661a3eefacbba918', 'sad', '2024-10-03 19:34:12', '2024-10-03 19:34:12'),
(8, 'Nourin', '6b51d431df5d7f141cbececcf79edf3dd861c3b4069f0b11661a3eefacbba918', 'mas@gri.se', '2024-10-03 20:38:52', '2024-10-03 20:38:52'),
(13, 'mita', '6b51d431df5d7f141cbececcf79edf3dd861c3b4069f0b11661a3eefacbba918', 'mita@gmail.com', '2024-10-03 20:46:40', '2024-10-03 20:46:40'),
(14, 'test', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'test@exam.com', '2024-10-03 20:53:02', '2024-10-03 20:53:02'),
(18, 'mukta', '6b51d431df5d7f141cbececcf79edf3dd861c3b4069f0b11661a3eefacbba918', 'mu', '2024-10-03 21:02:18', '2024-10-03 21:02:18');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
