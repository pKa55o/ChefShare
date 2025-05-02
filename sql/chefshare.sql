-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 28, 2025 lúc 06:09 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `chefshare`
--
DROP DATABASE IF EXISTS `chefshare`;
CREATE DATABASE IF NOT EXISTS `chefshare` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `chefshare`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baidang`
--

CREATE TABLE `baidang` (
  `id_baidang` int(11) NOT NULL,
  `id_nguoidung` varchar(255) DEFAULT NULL,
  `id_phanloai` int(11) DEFAULT NULL,
  `tieude` varchar(80) NOT NULL,
  `thumbnail` blob DEFAULT NULL,
  `mota` varchar(255) DEFAULT NULL,
  `thoigiannau` int(11) DEFAULT NULL,
  `khauphan` int(11) DEFAULT NULL,
  `thoigiandang` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baidang_cachnau`
--

CREATE TABLE `baidang_cachnau` (
  `id_baidang` int(11) NOT NULL,
  `id_cachnau` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baidang_chidan`
--

CREATE TABLE `baidang_chidan` (
  `id_baidang` int(11) NOT NULL,
  `id_chidan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baidang_dathich`
--

CREATE TABLE `baidang_dathich` (
  `id_baidang` int(11) NOT NULL,
  `id_nguoidung` varchar(255) NOT NULL,
  `thoigianthich` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baidang_dungcu`
--

CREATE TABLE `baidang_dungcu` (
  `id_baidang` int(11) NOT NULL,
  `id_dungcu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baidang_nguyenlieu`
--

CREATE TABLE `baidang_nguyenlieu` (
  `id_baidang` int(11) NOT NULL,
  `id_nguyenlieu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cachnau`
--

CREATE TABLE `cachnau` (
  `id_cachnau` int(11) NOT NULL,
  `cachnau` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `cachnau`
--

INSERT INTO `cachnau` (`id_cachnau`, `cachnau`) VALUES
(1111, 'xào'),
(1112, 'Nướng'),
(1113, 'Chiên'),
(1114, 'lẩu'),
(1115, 'luộc'),
(1116, 'hấp'),
(1117, 'hầm');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chidan`
--

CREATE TABLE `chidan` (
  `id_chidan` int(11) NOT NULL,
  `id_baidang` int(11) NOT NULL,
  `buoc` int(11) NOT NULL,
  `mota` text NOT NULL,
  `anh` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dungcu`
--

CREATE TABLE `dungcu` (
  `id_dungcu` int(11) NOT NULL,
  `dungcu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `dungcu`
--

INSERT INTO `dungcu` (`id_dungcu`, `dungcu`) VALUES
(3333, 'bếp hồng ngoại'),
(3334, 'bếp củi'),
(3335, 'nồi chiên không dầu'),
(3336, 'bếp ga'),
(3337, 'than');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
--

CREATE TABLE `nguoidung` (
  `id_nguoidung` varchar(255) NOT NULL,
  `ten_nguoidung` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nguoidung`
--

INSERT INTO `nguoidung` (`id_nguoidung`, `ten_nguoidung`) VALUES
('HFhEieJFNRNetJysnXCEi3VEtFL2', 'Vũ Đâyyy');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguyenlieu`
--

CREATE TABLE `nguyenlieu` (
  `id_nguyenlieu` int(11) NOT NULL,
  `nguyenlieu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nguyenlieu`
--

INSERT INTO `nguyenlieu` (`id_nguyenlieu`, `nguyenlieu`) VALUES
(4444, 'cà rốt'),
(4445, 'cà chua'),
(4446, 'cà pháo'),
(4447, 'cà tím'),
(4448, 'thơm'),
(4449, 'dưa gan'),
(4450, 'thịt gà'),
(4451, 'thịt bò'),
(4452, 'thịt heo'),
(4453, 'cá ngừ'),
(4454, 'cá thu'),
(4455, 'cá nục'),
(4456, 'cá trích'),
(4457, 'rau mồng tơi'),
(4458, 'rau muống'),
(4459, 'rau diếp cá'),
(4460, 'rau má'),
(4461, 'cải thảo'),
(4462, 'khoai tây'),
(4463, 'giá đỗ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanloai`
--

CREATE TABLE `phanloai` (
  `id_phanloai` int(11) NOT NULL,
  `phanloai` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phanloai`
--

INSERT INTO `phanloai` (`id_phanloai`, `phanloai`) VALUES
(1, 'bài đăng'),
(2, 'cuộc thi'),
(3, 'cuộc thi 2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `theodoi`
--

CREATE TABLE `theodoi` (
  `id_nguoidung` varchar(255) NOT NULL,
  `id_nguoitheodoi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `theodoi`
--

INSERT INTO `theodoi` (`id_nguoidung`, `id_nguoitheodoi`) VALUES
('HFhEieJFNRNetJysnXCEi3VEtFL2', 'HFhEieJFNRNetJysnXCEi3VEtFL2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongbao`
--

CREATE TABLE `thongbao` (
  `id_thongbao` int(11) NOT NULL,
  `ten_thongbao` varchar(255) NOT NULL,
  `noidung` varchar(255) DEFAULT NULL,
  `thoigian_thongbao` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `thongbao`
--

INSERT INTO `thongbao` (`id_thongbao`, `ten_thongbao`, `noidung`, `thoigian_thongbao`) VALUES
(6666, 'Cập nhật hệ thống', 'cập nhật lần 1', '2025-04-27 14:48:19'),
(6667, 'Bảo trì hệ thống', 'cập nhật lần 2', '2025-04-27 14:49:09'),
(6668, 'Sửa hệ thống', 'cập nhật lần 3', '2025-04-27 14:49:09'),
(6669, 'Cập nhật hệ thống', 'cập nhật lần 4', '2025-04-27 14:49:09');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `baidang`
--
ALTER TABLE `baidang`
  ADD PRIMARY KEY (`id_baidang`),
  ADD KEY `id_nguoidung` (`id_nguoidung`),
  ADD KEY `id_phanloai` (`id_phanloai`);

--
-- Chỉ mục cho bảng `baidang_cachnau`
--
ALTER TABLE `baidang_cachnau`
  ADD KEY `baidang_cachnau_ibfk_1` (`id_baidang`),
  ADD KEY `baidang_cachnau_ibfk_2` (`id_cachnau`);

--
-- Chỉ mục cho bảng `baidang_chidan`
--
ALTER TABLE `baidang_chidan`
  ADD KEY `baidang_chidan_ibfk_1` (`id_baidang`),
  ADD KEY `baidang_chidan_ibfk_2` (`id_chidan`);

--
-- Chỉ mục cho bảng `baidang_dathich`
--
ALTER TABLE `baidang_dathich`
  ADD PRIMARY KEY (`id_baidang`,`id_nguoidung`),
  ADD KEY `id_nguoidung` (`id_nguoidung`);

--
-- Chỉ mục cho bảng `baidang_dungcu`
--
ALTER TABLE `baidang_dungcu`
  ADD KEY `baidang_dungcu_ibfk_1` (`id_baidang`),
  ADD KEY `baidang_dungcu_ibfk_2` (`id_dungcu`);

--
-- Chỉ mục cho bảng `baidang_nguyenlieu`
--
ALTER TABLE `baidang_nguyenlieu`
  ADD KEY `baidang_nguyenlieu_ibfk_1` (`id_baidang`),
  ADD KEY `baidang_nguyenlieu_ibfk_2` (`id_nguyenlieu`);

--
-- Chỉ mục cho bảng `cachnau`
--
ALTER TABLE `cachnau`
  ADD PRIMARY KEY (`id_cachnau`);

--
-- Chỉ mục cho bảng `chidan`
--
ALTER TABLE `chidan`
  ADD PRIMARY KEY (`id_chidan`),
  ADD KEY `id_baidang` (`id_baidang`);

--
-- Chỉ mục cho bảng `dungcu`
--
ALTER TABLE `dungcu`
  ADD PRIMARY KEY (`id_dungcu`);

--
-- Chỉ mục cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`id_nguoidung`);

--
-- Chỉ mục cho bảng `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  ADD PRIMARY KEY (`id_nguyenlieu`);

--
-- Chỉ mục cho bảng `phanloai`
--
ALTER TABLE `phanloai`
  ADD PRIMARY KEY (`id_phanloai`);

--
-- Chỉ mục cho bảng `theodoi`
--
ALTER TABLE `theodoi`
  ADD PRIMARY KEY (`id_nguoidung`,`id_nguoitheodoi`),
  ADD KEY `id_nguoitheodoi` (`id_nguoitheodoi`);

--
-- Chỉ mục cho bảng `thongbao`
--
ALTER TABLE `thongbao`
  ADD PRIMARY KEY (`id_thongbao`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `baidang`
--
ALTER TABLE `baidang`
  MODIFY `id_baidang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3040175;

--
-- AUTO_INCREMENT cho bảng `cachnau`
--
ALTER TABLE `cachnau`
  MODIFY `id_cachnau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1120;

--
-- AUTO_INCREMENT cho bảng `chidan`
--
ALTER TABLE `chidan`
  MODIFY `id_chidan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2222;

--
-- AUTO_INCREMENT cho bảng `dungcu`
--
ALTER TABLE `dungcu`
  MODIFY `id_dungcu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3338;

--
-- AUTO_INCREMENT cho bảng `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  MODIFY `id_nguyenlieu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4464;

--
-- AUTO_INCREMENT cho bảng `phanloai`
--
ALTER TABLE `phanloai`
  MODIFY `id_phanloai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5555;

--
-- AUTO_INCREMENT cho bảng `thongbao`
--
ALTER TABLE `thongbao`
  MODIFY `id_thongbao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6670;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `baidang`
--
ALTER TABLE `baidang`
  ADD CONSTRAINT `baidang_ibfk_1` FOREIGN KEY (`id_nguoidung`) REFERENCES `nguoidung` (`id_nguoidung`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `baidang_ibfk_2` FOREIGN KEY (`id_phanloai`) REFERENCES `phanloai` (`id_phanloai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `baidang_cachnau`
--
ALTER TABLE `baidang_cachnau`
  ADD CONSTRAINT `baidang_cachnau_ibfk_1` FOREIGN KEY (`id_baidang`) REFERENCES `baidang` (`id_baidang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `baidang_cachnau_ibfk_2` FOREIGN KEY (`id_cachnau`) REFERENCES `cachnau` (`id_cachnau`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `baidang_chidan`
--
ALTER TABLE `baidang_chidan`
  ADD CONSTRAINT `baidang_chidan_ibfk_1` FOREIGN KEY (`id_baidang`) REFERENCES `baidang` (`id_baidang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `baidang_chidan_ibfk_2` FOREIGN KEY (`id_chidan`) REFERENCES `chidan` (`id_chidan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `baidang_dathich`
--
ALTER TABLE `baidang_dathich`
  ADD CONSTRAINT `baidang_dathich_ibfk_1` FOREIGN KEY (`id_baidang`) REFERENCES `baidang` (`id_baidang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `baidang_dathich_ibfk_2` FOREIGN KEY (`id_nguoidung`) REFERENCES `nguoidung` (`id_nguoidung`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `baidang_dungcu`
--
ALTER TABLE `baidang_dungcu`
  ADD CONSTRAINT `baidang_dungcu_ibfk_1` FOREIGN KEY (`id_baidang`) REFERENCES `baidang` (`id_baidang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `baidang_dungcu_ibfk_2` FOREIGN KEY (`id_dungcu`) REFERENCES `dungcu` (`id_dungcu`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `baidang_nguyenlieu`
--
ALTER TABLE `baidang_nguyenlieu`
  ADD CONSTRAINT `baidang_nguyenlieu_ibfk_1` FOREIGN KEY (`id_baidang`) REFERENCES `baidang` (`id_baidang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `baidang_nguyenlieu_ibfk_2` FOREIGN KEY (`id_nguyenlieu`) REFERENCES `nguyenlieu` (`id_nguyenlieu`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chidan`
--
ALTER TABLE `chidan`
  ADD CONSTRAINT `chidan_ibfk_1` FOREIGN KEY (`id_baidang`) REFERENCES `baidang` (`id_baidang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `theodoi`
--
ALTER TABLE `theodoi`
  ADD CONSTRAINT `theodoi_ibfk_1` FOREIGN KEY (`id_nguoidung`) REFERENCES `nguoidung` (`id_nguoidung`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `theodoi_ibfk_2` FOREIGN KEY (`id_nguoitheodoi`) REFERENCES `nguoidung` (`id_nguoidung`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
