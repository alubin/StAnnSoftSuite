CREATE DATABASE `ccf` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `parishdata` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `StuID` double DEFAULT NULL,
  `lblParishID` varchar(45) DEFAULT NULL,
  `DOB1` varchar(5) DEFAULT NULL,
  `StuFunction` varchar(45) DEFAULT NULL,
  `StuStatus` varchar(45) DEFAULT NULL,
  `StuLnm` varchar(45) DEFAULT NULL,
  `StuFnm` varchar(45) DEFAULT NULL,
  `Student` varchar(100) DEFAULT NULL,
  `ClsOfferedID` double DEFAULT NULL,
  `HrsCredited` double DEFAULT NULL,
  `ClsDate` varchar(100) DEFAULT NULL,
  `CrsTitle` varchar(100) DEFAULT NULL,
  `Instructor` varchar(100) DEFAULT NULL,
  `Expr1` varchar(25) DEFAULT NULL,
  `CrsLevel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
