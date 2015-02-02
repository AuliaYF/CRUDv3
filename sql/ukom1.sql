-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 02, 2015 at 06:43 PM
-- Server version: 5.5.41-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ukom1`
--

-- --------------------------------------------------------

--
-- Table structure for table `bidang_studi`
--

CREATE TABLE IF NOT EXISTS `bidang_studi` (
  `bidang_kode` char(10) NOT NULL,
  `bidang_nama` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`bidang_kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bidang_studi`
--

INSERT INTO `bidang_studi` (`bidang_kode`, `bidang_nama`) VALUES
('BDSTD00001', 'Bidang Studi 1'),
('BDSTD00002', 'Bidang Studi 2');

-- --------------------------------------------------------

--
-- Table structure for table `guru`
--

CREATE TABLE IF NOT EXISTS `guru` (
  `Guru_kode` char(10) NOT NULL,
  `Kompetensi_kode` char(10) DEFAULT NULL,
  `Guru_NIP` char(16) DEFAULT NULL,
  `Guru_Nama` varchar(25) DEFAULT NULL,
  `Guru_alamat` varchar(50) DEFAULT NULL,
  `Guru_telpon` int(11) DEFAULT NULL,
  PRIMARY KEY (`Guru_kode`),
  KEY `Kompetensi_kode` (`Kompetensi_kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kompetensi_keahlian`
--

CREATE TABLE IF NOT EXISTS `kompetensi_keahlian` (
  `Kompetensi_kode` char(10) NOT NULL,
  `bidang_kode` char(10) DEFAULT NULL,
  `Kompetensi_nama` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Kompetensi_kode`),
  KEY `bidang_kode` (`bidang_kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kompetensi_keahlian`
--

INSERT INTO `kompetensi_keahlian` (`Kompetensi_kode`, `bidang_kode`, `Kompetensi_nama`) VALUES
('KPTKH00001', 'BDSTD00001', 'Kompetensi Keahlian 1');

-- --------------------------------------------------------

--
-- Table structure for table `nilai`
--

CREATE TABLE IF NOT EXISTS `nilai` (
  `Nilai_kode` char(10) NOT NULL,
  `Siswa_NISN` char(10) DEFAULT NULL,
  `Guru_kode` char(10) DEFAULT NULL,
  `SK_kode` char(10) DEFAULT NULL,
  `Nilai_angka` float DEFAULT NULL,
  `Nilai_huruf` text,
  PRIMARY KEY (`Nilai_kode`),
  KEY `Guru_kode` (`Guru_kode`),
  KEY `SK_kode` (`SK_kode`),
  KEY `Siswa_NISN` (`Siswa_NISN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE IF NOT EXISTS `siswa` (
  `Siswa_NISN` char(10) NOT NULL,
  `Kompetensi_kode` char(10) DEFAULT NULL,
  `Siswa_nama` varchar(30) DEFAULT NULL,
  `Siswa_alamat` varchar(50) DEFAULT NULL,
  `Siswa_tgl_lahir` date DEFAULT NULL,
  `Siswa_foto` longblob,
  PRIMARY KEY (`Siswa_NISN`),
  KEY `Kompetensi_kode` (`Kompetensi_kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `standar_kompetensi`
--

CREATE TABLE IF NOT EXISTS `standar_kompetensi` (
  `SK_kode` char(10) NOT NULL,
  `Kompetensi_kode` char(10) DEFAULT NULL,
  `SK_nama` varchar(60) DEFAULT NULL,
  `SK_kelas` text,
  PRIMARY KEY (`SK_kode`),
  KEY `Kompetensi_kode` (`Kompetensi_kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `standar_kompetensi`
--

INSERT INTO `standar_kompetensi` (`SK_kode`, `Kompetensi_kode`, `SK_nama`, `SK_kelas`) VALUES
('SKKPT00001', 'KPTKH00001', 'Standar Kompetensi 1', '12'),
('SKKPT00002', 'KPTKH00001', 'Standar Kompetensi 2', '12');

-- --------------------------------------------------------

--
-- Table structure for table `wali_murid`
--

CREATE TABLE IF NOT EXISTS `wali_murid` (
  `Wali_id` char(10) NOT NULL,
  `Siswa_NISN` char(10) DEFAULT NULL,
  `Wali_nama_ayah` varchar(25) DEFAULT NULL,
  `Wali_pekerjaan_ayah` varchar(15) DEFAULT NULL,
  `Wali_nama_ibu` varchar(25) DEFAULT NULL,
  `Wali_pekerjaan_ibu` varchar(15) DEFAULT NULL,
  `Wali_alamat` varchar(50) DEFAULT NULL,
  `Wali_telpon` int(11) DEFAULT NULL,
  PRIMARY KEY (`Wali_id`),
  KEY `Siswa_NISN` (`Siswa_NISN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `guru`
--
ALTER TABLE `guru`
  ADD CONSTRAINT `guru_ibfk_1` FOREIGN KEY (`Kompetensi_kode`) REFERENCES `kompetensi_keahlian` (`Kompetensi_kode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `kompetensi_keahlian`
--
ALTER TABLE `kompetensi_keahlian`
  ADD CONSTRAINT `kompetensi_keahlian_ibfk_1` FOREIGN KEY (`bidang_kode`) REFERENCES `bidang_studi` (`bidang_kode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `nilai`
--
ALTER TABLE `nilai`
  ADD CONSTRAINT `nilai_ibfk_1` FOREIGN KEY (`Guru_kode`) REFERENCES `guru` (`Guru_kode`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nilai_ibfk_2` FOREIGN KEY (`SK_kode`) REFERENCES `standar_kompetensi` (`SK_kode`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nilai_ibfk_3` FOREIGN KEY (`Siswa_NISN`) REFERENCES `siswa` (`Siswa_NISN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `siswa`
--
ALTER TABLE `siswa`
  ADD CONSTRAINT `siswa_ibfk_1` FOREIGN KEY (`Kompetensi_kode`) REFERENCES `kompetensi_keahlian` (`Kompetensi_kode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `standar_kompetensi`
--
ALTER TABLE `standar_kompetensi`
  ADD CONSTRAINT `standar_kompetensi_ibfk_1` FOREIGN KEY (`Kompetensi_kode`) REFERENCES `kompetensi_keahlian` (`Kompetensi_kode`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `wali_murid`
--
ALTER TABLE `wali_murid`
  ADD CONSTRAINT `wali_murid_ibfk_1` FOREIGN KEY (`Siswa_NISN`) REFERENCES `siswa` (`Siswa_NISN`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
