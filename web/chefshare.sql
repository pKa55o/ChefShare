-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 26, 2025 at 03:09 PM
-- Server version: 8.0.35
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chefshare`
--

-- --------------------------------------------------------

--
-- Table structure for table `baidang`
--

CREATE TABLE `baidang` (
  `id_baidang` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `id_nguoidung` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_phanloai` int DEFAULT NULL,
  `id_cachnau` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin,
  `id_dungcu` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin,
  `id_nguyenlieu` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin,
  `thumbnail` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mota` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `thoigiannau` int DEFAULT NULL,
  `khauphan` int DEFAULT NULL,
  `chidan` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin,
  `soluong_nguoithich` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin,
  `thoigiandang` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ;

--
-- Dumping data for table `baidang`
--

INSERT INTO `baidang` (`id_baidang`, `id_nguoidung`, `id_phanloai`, `id_cachnau`, `id_dungcu`, `id_nguyenlieu`, `thumbnail`, `mota`, `thoigiannau`, `khauphan`, `chidan`, `soluong_nguoithich`, `thoigiandang`) VALUES
('baidang1', 'HFhEieJFNRNetJysnXCEi3VEtFL2', 1, '[\"cachnau1\", \"cachnau2\"]', '[\"dungcu1\", \"dungcu2\"]', '[\"nguyenlieu1\", \"nguyenlieu2\"]', 'thumbnail1.jpg', 'Bước 1: Chiên gà, Bước 2: Nướng cá. Món ăn hấp dẫn với nhiều cách chế biến.', 2025, 4, '[{\"bước\":1,\"mô tả\":\"Chiên gà với gia vị.\",\"link ảnh\":\"http://example.com/step1.jpg\"},{\"bước\":2,\"mô tả\":\"Nướng cá với sốt chanh.\",\"link ảnh\":\"http://example.com/step2.jpg\"}]', '[\"150\", \"200\", \"250\"]', '2025-04-22 02:00:00'),
('baidang2', 'HFhEieJFNRNetJysnXCEi3VEtFL2', 2, '[\"cachnau2\"]', '[\"dungcu1\"]', '[\"nguyenlieu3\"]', 'thumbnail2.jpg', 'Bước 1: Nướng thịt heo với gia vị. Món ăn đơn giản nhưng ngon.', 2025, 2, '[{\"bước\":1,\"mô tả\":\"Nướng thịt heo với gia vị.\",\"link ảnh\":\"http://example.com/step3.jpg\"}]', '[\"180\", \"220\"]', '2025-04-22 04:00:00'),
('baidang3', 'HFhEieJFNRNetJysnXCEi3VEtFL2', 3, '[\"cachnau1\", \"cachnau3\"]', '[\"dungcu3\"]', '[\"nguyenlieu1\"]', 'thumbnail3.jpg', 'Bước 1: Hấp gà với gia vị đặc biệt. Món ăn với cách chế biến phong phú.', 2025, 3, '[{\"bước\":1,\"mô tả\":\"Hấp gà với gia vị đặc biệt.\",\"link ảnh\":\"http://example.com/step4.jpg\"}]', '[\"250\", \"300\"]', '2025-04-22 07:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `cachnau`
--

CREATE TABLE `cachnau` (
  `id_cachnau` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `cachnau` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cachnau`
--

INSERT INTO `cachnau` (`id_cachnau`, `cachnau`) VALUES
('cachnau1', 'Chiên'),
('cachnau2', 'Nướng'),
('cachnau3', 'Hấp');

-- --------------------------------------------------------

--
-- Table structure for table `dathich`
--

CREATE TABLE `dathich` (
  `id_baidang` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `id_nguoidung` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `thoigianthich` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dathich`
--

INSERT INTO `dathich` (`id_baidang`, `id_nguoidung`, `thoigianthich`) VALUES
('baidang1', 'HFhEieJFNRNetJysnXCEi3VEtFL2', '2025-04-22 03:30:00'),
('baidang2', 'HFhEieJFNRNetJysnXCEi3VEtFL2', '2025-04-22 05:30:00'),
('baidang3', 'HFhEieJFNRNetJysnXCEi3VEtFL2', '2025-04-22 08:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `dungcu`
--

CREATE TABLE `dungcu` (
  `id_dungcu` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `dungcu` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dungcu`
--

INSERT INTO `dungcu` (`id_dungcu`, `dungcu`) VALUES
('dungcu1', 'Chảo'),
('dungcu2', 'Lò nướng'),
('dungcu3', 'Nồi hấp');

-- --------------------------------------------------------

--
-- Table structure for table `nguoidung`
--

CREATE TABLE `nguoidung` (
  `id_nguoidung` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `ten_nguoidung` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nguoidung`
--

INSERT INTO `nguoidung` (`id_nguoidung`, `ten_nguoidung`) VALUES
('HFhEieJFNRNetJysnXCEi3VEtFL2', 'Vũ Đâyyy');

-- --------------------------------------------------------

--
-- Table structure for table `nguyenlieu`
--

CREATE TABLE `nguyenlieu` (
  `id_nguyenlieu` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nguyenlieu` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nguyenlieu`
--

INSERT INTO `nguyenlieu` (`id_nguyenlieu`, `nguyenlieu`) VALUES
('nguyenlieu1', 'Gà'),
('nguyenlieu2', 'Cá'),
('nguyenlieu3', 'Thịt heo');

-- --------------------------------------------------------

--
-- Table structure for table `phanloai`
--

CREATE TABLE `phanloai` (
  `id_phanloai` int NOT NULL,
  `phanloai` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phanloai`
--

INSERT INTO `phanloai` (`id_phanloai`, `phanloai`) VALUES
(1, 'bài đăng'),
(2, 'cuộc thi'),
(3, 'cuộc thi 2');

-- --------------------------------------------------------

--
-- Table structure for table `theodoi`
--

CREATE TABLE `theodoi` (
  `id_nguoidung` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `id_nguoitheodoi` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `theodoi`
--

INSERT INTO `theodoi` (`id_nguoidung`, `id_nguoitheodoi`) VALUES
('HFhEieJFNRNetJysnXCEi3VEtFL2', 'HFhEieJFNRNetJysnXCEi3VEtFL2');

-- --------------------------------------------------------

--
-- Table structure for table `thongbao`
--

CREATE TABLE `thongbao` (
  `id_thongbao` int NOT NULL,
  `id_nguoidan` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `noidung` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `thoigianthongbao` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thongbao`
--

INSERT INTO `thongbao` (`id_thongbao`, `id_nguoidan`, `noidung`, `thoigianthongbao`) VALUES
(1, 'HFhEieJFNRNetJysnXCEi3VEtFL2', 'Chào bạn! Bạn có món ăn mới trong bếp.', '2025-04-22 03:00:00'),
(2, 'HFhEieJFNRNetJysnXCEi3VEtFL2', 'Món ăn của bạn đã có người thích!', '2025-04-22 05:00:00'),
(3, 'HFhEieJFNRNetJysnXCEi3VEtFL2', 'Cập nhật về công thức mới.', '2025-04-22 08:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `baidang`
--
ALTER TABLE `baidang`
  ADD PRIMARY KEY (`id_baidang`),
  ADD KEY `id_nguoidung` (`id_nguoidung`),
  ADD KEY `id_phanloai` (`id_phanloai`);

--
-- Indexes for table `cachnau`
--
ALTER TABLE `cachnau`
  ADD PRIMARY KEY (`id_cachnau`);

--
-- Indexes for table `dathich`
--
ALTER TABLE `dathich`
  ADD PRIMARY KEY (`id_baidang`,`id_nguoidung`),
  ADD KEY `id_nguoidung` (`id_nguoidung`);

--
-- Indexes for table `dungcu`
--
ALTER TABLE `dungcu`
  ADD PRIMARY KEY (`id_dungcu`);

--
-- Indexes for table `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`id_nguoidung`);

--
-- Indexes for table `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  ADD PRIMARY KEY (`id_nguyenlieu`);

--
-- Indexes for table `phanloai`
--
ALTER TABLE `phanloai`
  ADD PRIMARY KEY (`id_phanloai`);

--
-- Indexes for table `theodoi`
--
ALTER TABLE `theodoi`
  ADD PRIMARY KEY (`id_nguoidung`,`id_nguoitheodoi`),
  ADD KEY `id_nguoitheodoi` (`id_nguoitheodoi`);

--
-- Indexes for table `thongbao`
--
ALTER TABLE `thongbao`
  ADD PRIMARY KEY (`id_thongbao`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `thongbao`
--
ALTER TABLE `thongbao`
  MODIFY `id_thongbao` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `baidang`
--
ALTER TABLE `baidang`
  ADD CONSTRAINT `baidang_ibfk_1` FOREIGN KEY (`id_nguoidung`) REFERENCES `nguoidung` (`id_nguoidung`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `baidang_ibfk_2` FOREIGN KEY (`id_phanloai`) REFERENCES `phanloai` (`id_phanloai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dathich`
--
ALTER TABLE `dathich`
  ADD CONSTRAINT `dathich_ibfk_1` FOREIGN KEY (`id_baidang`) REFERENCES `baidang` (`id_baidang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dathich_ibfk_2` FOREIGN KEY (`id_nguoidung`) REFERENCES `nguoidung` (`id_nguoidung`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `theodoi`
--
ALTER TABLE `theodoi`
  ADD CONSTRAINT `theodoi_ibfk_1` FOREIGN KEY (`id_nguoidung`) REFERENCES `nguoidung` (`id_nguoidung`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `theodoi_ibfk_2` FOREIGN KEY (`id_nguoitheodoi`) REFERENCES `nguoidung` (`id_nguoidung`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
