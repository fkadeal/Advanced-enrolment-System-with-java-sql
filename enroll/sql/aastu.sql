-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 07, 2021 at 01:54 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aastu`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `CourseId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `CourseName` varchar(50) NOT NULL,
  `price` double(8,2) NOT NULL,
  `credit_hour` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`CourseId`, `CourseName`, `price`, `credit_hour`) VALUES
(00001, 'Java', 66.00, 7),
(00002, 'Python', 2000.00, 5),
(00003, 'C++', 55.00, 21),
(00004, 'SQL', 89999.00, 5),
(00005, 'Go', 250.00, 6);

-- --------------------------------------------------------

--
-- Table structure for table `enrollinfo`
--

CREATE TABLE `enrollinfo` (
  `EnrollId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `userId` varchar(12) NOT NULL,
  `CourseId` varchar(12) NOT NULL,
  `cost` double(12,2) UNSIGNED NOT NULL,
  `amount` int(8) UNSIGNED NOT NULL,
  `date` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('mili', '1', 0),
('fka', 'deal', 1),
('bedasa', '1', 1),
('bedasa', '1', 1),
('cep/o56/13', 'seni', 1),
('senait', 'sun', 1),
('1212', '1212', 1);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `userId` varchar(12) NOT NULL,
  `StaffName` varchar(50) NOT NULL,
  `phoneNumber` varchar(14) NOT NULL,
  `role` varchar(8) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`userId`, `StaffName`, `phoneNumber`, `role`, `salary`) VALUES
('e001', 'FKADEAL', '+2511234567890', 'Manager', 50000.00),
('mili', 'MILIYON', '+2511234567891', 'General', 30000.00);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `userId` varchar(12) NOT NULL,
  `StudentName` varchar(30) NOT NULL,
  `PhoneNumber` varchar(14) NOT NULL,
  `Address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`userId`, `StudentName`, `PhoneNumber`, `Address`) VALUES
('bedasa', 'bedasa', '+251932976031', 'addos'),
('c001', 'Matos', '+2511234567890', 'addis ababa'),
('deba', 'Dbela', '+2511763923789', 'addis ababa'),
('cep/o56/13', 'senait', '+251925361823', 'addis'),
('senait', 'senait alemayehu', '+251925361823', 'addis'),
('1212', 'fkadeal', '+251932970631', 'addis ababa');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
