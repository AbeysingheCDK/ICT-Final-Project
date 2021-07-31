-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 31, 2021 at 08:19 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qems`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `user_name` varchar(255) NOT NULL,
  `password` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`user_name`, `password`) VALUES
('qems', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `all_questions`
--

CREATE TABLE `all_questions` (
  `questionID` int(3) NOT NULL,
  `question` varchar(255) NOT NULL,
  `option1` varchar(255) NOT NULL,
  `option2` varchar(255) NOT NULL,
  `option3` varchar(255) NOT NULL,
  `option4` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `all_questions`
--

INSERT INTO `all_questions` (`questionID`, `question`, `option1`, `option2`, `option3`, `option4`, `answer`) VALUES
(1, 'Question One', 'a', 'b', 'c', 'd', 'a'),
(2, 'Question Two', 'A', 'B', 'C', 'D', 'C'),
(3, 'Question Three', 'A', 'B', 'C', 'D', 'C'),
(4, 'Question Four', 'A', 'B', 'C', 'D', 'D'),
(5, 'Question Five', 'A', 'B', 'C', 'D', 'A'),
(6, 'Question Sixth ', 'A', 'B', 'C', 'D', 'A'),
(7, 'Question Seven', 'A', 'B', 'C', 'D', 'C'),
(8, 'Question Eight ', 'A', 'B', 'C', 'D', 'D'),
(9, 'Question Nine', 'A', 'B', 'C', 'D', 'A'),
(10, 'Question Ten', 'A', 'B', 'C', 'D', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `all_result`
--

CREATE TABLE `all_result` (
  `roll_no` int(11) NOT NULL,
  `reg_no` varchar(255) NOT NULL,
  `stu_name` varchar(255) NOT NULL,
  `marks` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `all_result`
--

INSERT INTO `all_result` (`roll_no`, `reg_no`, `stu_name`, `marks`) VALUES
(7, 'AR96301', 'Dilakshi', '7'),
(8, 'AR96213', 'Amaya', '7'),
(9, 'AR96565', 'Rashmi', '7'),
(10, 'AR96755', 'Chathumini', '6'),
(11, '96322', 'Inuri Perera', '6');

-- --------------------------------------------------------

--
-- Table structure for table `student_reg`
--

CREATE TABLE `student_reg` (
  `roll_no` int(5) NOT NULL,
  `reg_no` varchar(7) NOT NULL,
  `stu_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `tp` varchar(10) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_reg`
--

INSERT INTO `student_reg` (`roll_no`, `reg_no`, `stu_name`, `address`, `tp`, `gender`, `email`) VALUES
(1, 'AR96301', 'Dilakshi Abeysinghe', 'No.1/7 B, Nalluruwa, Panadura', '0775262421', 'Female', 'cdkabeysinghe@gmail.com'),
(2, 'AR96565', 'Rashmi Pituwala', 'Thalawa, Anuradhapura', '0714521456', 'Female', 'rspiltuwal@gmail.com'),
(3, 'AR96755', 'Chathumini Maleesha', 'Mathara, Deniyaya', '0774521624', 'Female', 'maleeshatch@gmail.com'),
(4, 'AR96566', 'Dileka Nipuni', 'No.112, Morawinna, Panadura', '0774526235', 'Female', 'dnipuni@gmail.com'),
(5, 'AR96232', 'Sahanya Sandali', 'Malamulla, Panadura', '0724512645', 'Female', 'sandali12@gmail.com'),
(6, 'AR96213', 'Amaya Savindi', 'Malamulla, Panadura', '0775231426', 'Female', 'amayasavindi@gmail.com'),
(7, '96322', 'Inuri Perera', 'Waskaduwa, Kalutara', '0772451236', 'Female', 'inuriperera@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`user_name`);

--
-- Indexes for table `all_questions`
--
ALTER TABLE `all_questions`
  ADD PRIMARY KEY (`questionID`);

--
-- Indexes for table `all_result`
--
ALTER TABLE `all_result`
  ADD PRIMARY KEY (`roll_no`);

--
-- Indexes for table `student_reg`
--
ALTER TABLE `student_reg`
  ADD PRIMARY KEY (`roll_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `all_questions`
--
ALTER TABLE `all_questions`
  MODIFY `questionID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `all_result`
--
ALTER TABLE `all_result`
  MODIFY `roll_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `student_reg`
--
ALTER TABLE `student_reg`
  MODIFY `roll_no` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
