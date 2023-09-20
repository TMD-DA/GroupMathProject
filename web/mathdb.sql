-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 20, 2023 at 08:50 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mathdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignments`
--



CREATE TABLE `assignments` (
  `assignmentID` int(11) NOT NULL,
  `assignmentType` varchar(20) NOT NULL,
  `classID` int(11) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assignments`
--

INSERT INTO `assignments` (`assignmentID`, `assignmentType`, `classID`, `description`) VALUES
(1, 'drill', 1, 'Drill on basic math'),
(2, 'test', 1, 'Test on basic math'),
(3, 'drill', 2, 'Drill on advanced math concepts'),
(4, 'test', 2, 'Test on advanced math concepts');

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `classID` int(11) NOT NULL,
  `className` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`classID`, `className`, `description`) VALUES
(1, 'Math-1000', 'Basic Math'),
(2, 'Math-2002', 'Advanced math');

-- --------------------------------------------------------

--
-- Table structure for table `parent`
--

CREATE TABLE `parent` (
  `parentID` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `parent`
--

INSERT INTO `parent` (`parentID`, `password`, `firstName`, `lastName`, `userID`) VALUES
(1, 'password3', 'John', 'Smith', 1);

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `questionID` int(11) NOT NULL,
  `assignmentID` int(11) NOT NULL,
  `question` text NOT NULL,
  `answer` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`questionID`, `assignmentID`, `question`, `answer`) VALUES
(1, 1, 'What is 1+1', '2'),
(2, 2, 'What is 2+2', '4');

-- --------------------------------------------------------

--
-- Table structure for table `studentscores`
--

CREATE TABLE `studentscores` (
  `resultID` int(11) NOT NULL,
  `assignmentID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `resultScore` decimal(10,0) NOT NULL,
  `resultWeight` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studentscores`
--

INSERT INTO `studentscores` (`resultID`, `assignmentID`, `userID`, `resultScore`, `resultWeight`) VALUES
(1, 1, 1, 9, 10),
(2, 2, 1, 8, 11);

-- --------------------------------------------------------

--
-- Table structure for table `userclass`
--

CREATE TABLE `userclass` (
  `classID` int(11) NOT NULL,
  `userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userclass`
--

INSERT INTO `userclass` (`classID`, `userID`) VALUES
(1, 2),
(1, 1),
(2, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(256) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `userType` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `username`, `password`, `firstName`, `lastName`, `email`, `userType`) VALUES
(1, 'dt655510', 'password1', 'Dylan', 'Tran', 'dt655510@southeast.edu', 'student'),
(2, 'gray', 'password2', 'Glenn', 'Ray', 'gray@southeast.edu', 'teacher');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignments`
--
ALTER TABLE `assignments`
  ADD PRIMARY KEY (`assignmentID`);

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`classID`);

--
-- Indexes for table `parent`
--
ALTER TABLE `parent`
  ADD PRIMARY KEY (`parentID`),
  ADD KEY `fk_parentUser` (`userID`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`questionID`),
  ADD KEY `fk_questionAssignment` (`assignmentID`),
  ADD KEY `questionID` (`questionID`);

--
-- Indexes for table `studentscores`
--
ALTER TABLE `studentscores`
  ADD PRIMARY KEY (`resultID`),
  ADD KEY `fk_assignmentScore` (`assignmentID`),
  ADD KEY `fk_userScore` (`userID`);

--
-- Indexes for table `userclass`
--
ALTER TABLE `userclass`
  ADD KEY `fk_classID` (`classID`),
  ADD KEY `fk_userID` (`userID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assignments`
--
ALTER TABLE `assignments`
  MODIFY `assignmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `classes`
--
ALTER TABLE `classes`
  MODIFY `classID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `parent`
--
ALTER TABLE `parent`
  MODIFY `parentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `questionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `studentscores`
--
ALTER TABLE `studentscores`
  MODIFY `resultID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `parent`
--
ALTER TABLE `parent`
  ADD CONSTRAINT `fk_parentUser` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`);

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `fk_questionAssignment` FOREIGN KEY (`assignmentID`) REFERENCES `assignments` (`assignmentID`);

--
-- Constraints for table `studentscores`
--
ALTER TABLE `studentscores`
  ADD CONSTRAINT `fk_assignmentScore` FOREIGN KEY (`assignmentID`) REFERENCES `assignments` (`assignmentID`),
  ADD CONSTRAINT `fk_userScore` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`);

--
-- Constraints for table `userclass`
--
ALTER TABLE `userclass`
  ADD CONSTRAINT `fk_classID` FOREIGN KEY (`classID`) REFERENCES `classes` (`classID`),
  ADD CONSTRAINT `fk_userID` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
