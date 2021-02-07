-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 28, 2018 at 10:10 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
--Database: `f1`
--

-- --------------------------------------------------------

--
-- Table structure for table `Student`
--

#student honual
CREATE TABLE `Student` (
  `userId` varchar(12) NOT NULL,
  `StudentName` varchar(30) NOT NULL,
  `phoneNumber` varchar(14) NOT NULL,
  `address` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Student`
--

INSERT INTO `Student` (`userId`, `StudentName`, `phoneNumber`, `address`) VALUES
('c001', 'Matos', '+2511234567890', 'addis ababa'),
('deba', 'Dbela', '+2511763923789', 'addis ababa');

-- --------------------------------------------------------

--
-- Table structure for table `Staff`
--

CREATE TABLE `Staff` (
  `userId` varchar(12) NOT NULL,
  `StaffName` varchar(50) NOT NULL,
  `phoneNumber` varchar(14) NOT NULL,
  `role` varchar(8) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Staff`
--

INSERT INTO `Staff` (`userId`, `StaffName`, `phoneNumber`, `role`, `salary`) VALUES
('e001', 'Staff1', '+2511234567890', 'Manager', 50000.00),
('e002', 'Staff2', '+2511234567891', 'General', 30000.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(12) NOT NULL,
  `password` varchar(12) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('mili', 'mili', 0),
('fka', 'deal', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Course`
--

CREATE TABLE `Course` (
  `CourseId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `CourseName` varchar(50) NOT NULL,
  `price` double(8,2) NOT NULL,
  `credit_hour` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Course`
--

INSERT INTO `Course` (`CourseId`, `CourseName`, `price`, `credit_hour`) VALUES
(00001, 'Java', 66.00, 7),
(00002, 'Python', 2000.00, 5),
(00003, 'C++', 55.00, 21),
(00004, 'SQL', 89999.00, 5),
(00005, 'Go', 2500.00, 6);

-- --------------------------------------------------------

--
-- Table structure for table `Enrollinfo`
--

CREATE TABLE `Enrollinfo` (
  `EnrollId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `userId` varchar(12) NOT NULL,
  `CourseId` varchar(12) NOT NULL,
  `cost` double(12,2) UNSIGNED NOT NULL,
  `amount` int(8) UNSIGNED NOT NULL,
  `date` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Enrollinfo`
--

INSERT INTO `Enrollinfo` (`EnrollId`, `userId`, `CourseId`, `cost`, `amount`, `date`) VALUES
(00001, 'deba', '00003', 55.00, 1, '2018-09-26'),
(00002, 'c001', '00005', 2500.00, 1, '2018-09-28'),
(00006, 'c001', '00003', 110.00, 2, '2018-09-28');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Student`
--
ALTER TABLE `Student`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `Staff`
--
ALTER TABLE `Staff`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD UNIQUE KEY `userId` (`userId`),
  ADD UNIQUE KEY `userId_2` (`userId`);

--
-- Indexes for table `Course`
--
ALTER TABLE `Course`
  ADD PRIMARY KEY (`CourseId`);

--
-- Indexes for table `Enrollinfo`
--
ALTER TABLE `Enrollinfo`
  ADD PRIMARY KEY (`EnrollId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `userId_2` (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Course`
--
ALTER TABLE `Course`
  MODIFY `CourseId` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `Enrollinfo`
--
ALTER TABLE `Enrollinfo`
  MODIFY `EnrollId` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Enrollinfo`
--
ALTER TABLE `Enrollinfo`
  ADD CONSTRAINT `FK_PUR_CUS` FOREIGN KEY (`userId`) REFERENCES `Enrollinfo` (`userId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
