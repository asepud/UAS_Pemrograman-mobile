-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2021 at 03:18 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `buku`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` int(9) NOT NULL,
  `judul` varchar(70) DEFAULT NULL,
  `penulis` varchar(30) DEFAULT NULL,
  `jenis` varchar(30) DEFAULT NULL,
  `tahun` char(5) DEFAULT NULL,
  `image` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `judul`, `penulis`, `jenis`, `tahun`, `image`) VALUES
(1, 'ayat-ayat cinta', 'Habbiburrahman', 'Roman', '2015', 'ayat.jpg'),
(2, 'laskar pelangi', 'Andrea Hirata', 'novel', '2014', ''),
(3, 'Negeri Para Bedebah', 'Tere Liye', 'Roman', '2010', ''),
(4, 'garis waktu', 'fiersa besari', 'novel', '2011', ''),
(5, 'Jalan Pulang', 'Jazuli Imam', 'Roman', '2016', ''),
(6, 'Resign', 'Almira Bestari', 'Novel', '2017', ''),
(7, 'Maaf Tuhan Kami Sedang Sibuk', 'Ahmad Rifai ', 'Motivasi', '2011', ''),
(72, 'coba', 'test', 'test', '1235', NULL),
(73, 'test', 'test', 'dicoba', '12345', NULL),
(74, 'coba', 'test', 'test', '1239', NULL),
(75, 'edit text', 'test', 'dicoba', '12345', NULL),
(76, 'edit text', 'testpenulis', 'dicoba', '12345', NULL),
(77, 'edit text', 'testpenulis', 'dicoba123', '12345', NULL),
(79, 'dgdfgfd', 'hfgfdgf', 'drtyuo', '12345', NULL),
(80, 'matematika kehidupan', 'ustad yusuf mansyur', 'motivasi', '2010', NULL),
(81, 'catatan juang', 'fiersa besari', 'perjalanan', '2016', NULL),
(82, 'sdsd', 'sfdf', 'sffffgg', '123', NULL),
(83, 'sdfg', 'asdfr', 'ssdfgfd', '12345', NULL),
(84, 'a', 'a', 'a', '123', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `profil`
--

CREATE TABLE `profil` (
  `id` int(11) NOT NULL,
  `npm` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `kelas` varchar(20) NOT NULL,
  `jurusan` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profil`
--

INSERT INTO `profil` (`id`, `npm`, `nama`, `kelas`, `jurusan`, `email`, `telp`) VALUES
(1, 'Asep Udin', '43a87006170337', 'TI 7BM', 'Teknik Informatika', 'asepud28@gmail.com', '089765470804');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT for table `profil`
--
ALTER TABLE `profil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
