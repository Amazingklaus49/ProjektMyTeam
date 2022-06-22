-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: mysqldb
-- Erstellungszeit: 22. Jun 2022 um 06:48
-- Server-Version: 8.0.28
-- PHP-Version: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `f1team`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Driver`
--

CREATE TABLE `Driver` (
  `vorname` varchar(250) NOT NULL,
  `nachname` varchar(250) NOT NULL,
  `jahrgang` int NOT NULL,
  `nationalitaet` varchar(250) NOT NULL,
  `teamIDFS` int NOT NULL,
  `driverID` int NOT NULL
) ENGINE=InnoDB;

--
-- Daten für Tabelle `Driver`
--

INSERT INTO `Driver` (`vorname`, `nachname`, `jahrgang`, `nationalitaet`, `teamIDFS`, `driverID`) VALUES
('Max', 'Verstappen', 1997, 'NLD', 2, 1),
('Daniel', 'Ricciardo', 1989, 'AUS', 3, 2),
('Sergio', 'Pérez', 1990, 'MEX', 2, 3),
('George', 'Russel', 1998, 'GB', 1, 4),
('Lando', 'Norris', 1999, 'GB', 3, 5),
('Lewis', 'Hamilton', 1985, 'GB', 1, 6);

-- --------------------------------------------------------

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Team`
--

CREATE TABLE `Team` (
  `name` varchar(250) NOT NULL,
  `teamID` int NOT NULL
) ENGINE=InnoDB;

--
-- Daten für Tabelle `Team`
--

INSERT INTO `Team` (`name`, `teamID`) VALUES
('Mercedes', 1),
('Red Bull Racing', 2),
('McLaren', 3);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `Driver`
--
ALTER TABLE `Driver`
  ADD UNIQUE KEY `driverID` (`driverID`),
  ADD KEY `teamIDFS` (`teamIDFS`) USING BTREE;

--
-- Indizes für die Tabelle `Team`
--
ALTER TABLE `Team`
  ADD UNIQUE KEY `teamID` (`teamID`);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `Driver`
--
ALTER TABLE `Driver`
  ADD CONSTRAINT `FK3w0pnj2dbgrhxjxmoda8o407t` FOREIGN KEY (`teamIDFS`) REFERENCES `team` (`teamID`),
  ADD CONSTRAINT `teamIDFS` FOREIGN KEY (`teamIDFS`) REFERENCES `Team` (`teamID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
