-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2019-03-01 09:12:04
-- 服务器版本： 5.5.62
-- PHP 版本： 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `flyui`
--

-- --------------------------------------------------------

--
-- 表的结构 `fly_about`
--

CREATE TABLE `fly_about` (
  `aboutId` int(11) NOT NULL,
  `imageurl` varchar(255) NOT NULL,
  `aboutText` text NOT NULL,
  `aboutSort` int(11) NOT NULL DEFAULT '0',
  `remark` text,
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_about`
--

INSERT INTO `fly_about` (`aboutId`, `imageurl`, `aboutText`, `aboutSort`, `remark`, `edittime`, `userid`, `ip`) VALUES
(1, '/uiweb/uploads/58/a3ee19fdd8c6473532ca9463b90077.jpg', '身处在前端社区的繁荣之下，我们都在有意或无意地追逐。而 layui 偏偏回望当初，奔赴在返璞归真的漫漫征途，自信并勇敢着，追寻于原生态的书写指令，试图以最简单的方式诠释高效。身处在前端社区的繁荣之下，我们都在有意或无意地追逐。而 layui 偏偏回望当初，奔赴在返璞归真的漫漫征途，自信并勇敢着，追寻于原生态的书写指令，试图以最简单的方式诠释高效。身处在前端社区的繁荣之下，我们都在有意或无意地追逐。而 layui 偏偏回望当初，奔赴在返璞归真的漫漫征途，自信并勇敢着，追寻于原生态的书写指令，试图以最简单的方式诠释高效', 0, NULL, '2019-02-23 01:10:48', 0, '192.168.1.119'),
(2, '/uiweb/uploads/eb/eeb8f691d4836161e6bde902abf265.jpg', '拥有双面的不仅是人生，还有Layui。一面极简，一面丰盈。极简是视觉所见的外在，是开发所念的简易。丰盈是倾情雕琢的内在，是信手拈来的承诺。一切本应如此，简而全，双重体验。拥有双面的不仅是人生，还有Layui。一面极简，一面丰盈。极简是视觉所见的外在，是开发所念的简易。丰盈是倾情雕琢的内在，是信手拈来的承诺。一切本应如此，简而全，双重体验。', 0, NULL, '2019-02-23 03:29:12', 0, '192.168.1.119'),
(3, '/uiweb/uploads/f9/d546081201d174ffe28d6e5b24207c.jpg', '拥有双面的不仅是人生，还有Layui。一面极简，一面丰盈。极简是视觉所见的外在，是开发所念的简易。丰盈是倾情雕琢的内在，是信手拈来的承诺。一切本应如此，简而全，双重体验。', 0, NULL, '2019-02-23 02:17:00', 0, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_cases`
--

CREATE TABLE `fly_cases` (
  `casesId` int(11) NOT NULL,
  `casesTitle` varchar(255) NOT NULL,
  `imageurl` varchar(255) NOT NULL,
  `casesText` text NOT NULL,
  `remark` text,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_cases`
--

INSERT INTO `fly_cases` (`casesId`, `casesTitle`, `imageurl`, `casesText`, `remark`, `createtime`, `userid`, `ip`) VALUES
(1, '名牌工厂店', '/uiweb/uploads/8c/e959e3095e392fd7f8c63177cfac0a.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。', '', '2019-02-22 09:21:47', 0, '192.168.1.119'),
(2, '测试没试', '/uiweb/uploads/12/993f4446443c2d7f25596512720cdf.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。', '', '2019-02-22 09:25:07', 0, '192.168.1.119'),
(3, '纟纟纟x', '/uiweb/uploads/c6/4c0069727708f55646a135eba53c4f.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。', '', '2019-02-22 09:38:07', 0, '192.168.1.119'),
(4, 'cccccccccc', '/uiweb/uploads/d8/0f7d89969851465634660e03e4f922.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。', '', '2019-02-22 09:49:09', 0, '192.168.1.119'),
(5, 'ccccc', '/uiweb/uploads/4b/86c495bffe7e2f2f0b8d11d30f580d.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。', '', '2019-02-22 09:50:22', 0, '192.168.1.119'),
(6, 'bbbb', '/uiweb/uploads/fb/373749569112755e4149c01d7f7346.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。', '', '2019-02-22 09:50:30', 0, '192.168.1.119'),
(7, '一家工厂企业的商品展示一家工厂企业的商品展示', '/uiweb/uploads/8e/7104e94ab1cb641dfb3bee60f207dc.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。', '', '2019-02-22 09:50:40', 0, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_cell`
--

CREATE TABLE `fly_cell` (
  `cellId` int(11) NOT NULL,
  `celltypeId` int(11) NOT NULL,
  `themeName` varchar(255) DEFAULT NULL,
  `width` int(11) NOT NULL DEFAULT '0',
  `height` int(11) NOT NULL DEFAULT '0',
  `imageurl1` varchar(255) DEFAULT NULL,
  `imageurl2` varchar(255) DEFAULT NULL,
  `textTitle` varchar(255) DEFAULT NULL,
  `textSize` int(11) DEFAULT '24',
  `textColor` char(9) DEFAULT '#FFFFFFFF',
  `textAlign` varchar(10) DEFAULT 'CENTER',
  `textFont` varchar(255) DEFAULT NULL,
  `textTop` int(11) DEFAULT '0',
  `textBottom` int(11) DEFAULT '0',
  `textLeft` int(11) DEFAULT '0',
  `textRight` int(11) DEFAULT '0',
  `packName` varchar(255) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  `action` varchar(1024) DEFAULT NULL,
  `flyAction` varchar(1024) DEFAULT NULL,
  `intentFlag` varchar(20) DEFAULT NULL,
  `remark` text,
  `extend` text,
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) DEFAULT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_cell`
--

INSERT INTO `fly_cell` (`cellId`, `celltypeId`, `themeName`, `width`, `height`, `imageurl1`, `imageurl2`, `textTitle`, `textSize`, `textColor`, `textAlign`, `textFont`, `textTop`, `textBottom`, `textLeft`, `textRight`, `packName`, `className`, `action`, `flyAction`, `intentFlag`, `remark`, `extend`, `edittime`, `userid`, `ip`) VALUES
(15, 1, '', 212, 317, 'http://192.168.1.119:801/uiweb/uploads/c8/6018220c4ee22e77fc786d0f426418.png', '', '导航', 24, '', '', '', 0, 0, 0, 0, 'com.autonavi.amapauto', 'com.autonavi.amapauto.MainMapActivity', '', 'gps', '0x10200000', '', NULL, '2019-02-28 07:23:59', 0, '192.168.1.119'),
(16, 23, '', 212, 317, 'http://192.168.1.119:801/uiweb/uploads/0f/87821bfe4d2ceed787c0b7f4520ae3.png', '', '收音机', 24, '', '', '', 0, 0, 0, 0, 'com.jancar.radios', 'com.jancar.radio.RadioActivity', '', 'fm', '0x10200000', '', NULL, '2019-02-28 05:31:30', 0, '192.168.1.119'),
(17, 1, '', 212, 317, 'http://192.168.1.119:801/uiweb/uploads/b4/5f3074145ee304968b55d10c9d1ed4.png', '', '电话', 24, '', '', '', 0, 0, 0, 0, 'com.jancar.bluetooth.phone', 'com.jancar.bluetooth.phone.view.MainActivity', '', 'btdial', '', '', NULL, '2019-02-28 05:20:49', 0, '192.168.1.119'),
(18, 1, '', 212, 317, 'http://192.168.1.119:801/uiweb/uploads/ef/260b41ec0675e60869569b84fd52bb.png', '', '手机互连', 24, '', '', '', 0, 0, 0, 0, 'net.easyconn', 'net.easyconn.WelcomeActivity', '', 'elink', '', '', NULL, '2019-02-28 05:21:16', 0, '192.168.1.119'),
(19, 1, '', 212, 317, 'http://192.168.1.119:801/uiweb/uploads/7b/34563bd1049ce673e11625742926d3.png', '', '视频', 24, '', '', '', 0, 0, 0, 0, 'com.jancar.player.video', 'com.jancar.player.video.VideoActivity', '', 'video', '', '', NULL, '2019-02-28 05:21:41', 0, '192.168.1.119'),
(20, 1, '', 212, 317, 'http://192.168.1.119:801/uiweb/uploads/27/b48342fb63e9c166be68a33c9534db.png', '', '蓝牙音乐', 24, '', '', '', 0, 0, 0, 0, 'com.jancar.bluetooth.phone', 'com.jancar.bluetooth.phone.view.MusicActivity', '', 'a2dp', '', '', NULL, '2019-02-28 05:22:07', 0, '192.168.1.119'),
(21, 1, '', 212, 317, 'http://192.168.1.119:801/uiweb/uploads/39/279aab526e8a8555ed6694ef77209a.png', '', '音乐', 24, '', '', '', 0, 0, 0, 0, 'com.jancar.player.music', 'com.jancar.player.music.MusicActivity', '', 'music', '', '', NULL, '2019-02-28 05:22:35', 0, '192.168.1.119'),
(22, 1, '', 212, 317, 'http://192.168.1.119:801/uiweb/uploads/61/70539390aa7b1008e93213c44443bd.png', '', '图片', 24, '', '', '', 0, 0, 0, 0, 'com.jancar.player.photo', 'com.jancar.player.photo.PhotoActivity', '', 'image', '', '', NULL, '2019-02-28 05:32:33', 0, '192.168.1.119'),
(23, 1, '', 212, 317, 'http://192.168.1.119:801/uiweb/uploads/ae/c411e7147141d149176ca3ea2e27ab.png', '', '设置', 24, '', '', '', 0, 0, 0, 0, 'com.jancar.settingss', 'com.jancar.settings.view.activity.MainActivity', '', 'setting', '', '', NULL, '2019-02-28 05:18:45', 0, '192.168.1.119'),
(24, 1, '', 212, 317, 'http://192.168.1.119:801/uiweb/uploads/01/7c0cd91527fd7063c17dd700c2a82b.png', '', '外部输入', 24, '', '', '', 0, 0, 0, 0, 'com.jancar.avin', 'com.jancar.avin.MainActivity', '', 'avin', '', '', NULL, '2019-02-28 05:18:13', 0, '192.168.1.119'),
(25, 1, '', 212, 317, 'http://192.168.1.119:801/uiweb/uploads/4f/784d6be45e2470d41356cc8cb93cd1.png', '', '应用', 24, '', '', '', 0, 0, 0, 0, 'com.android.launcher3', 'com.android.launcher3.Launcher', '', 'app', '', '', NULL, '2019-02-28 05:17:39', 0, '192.168.1.119'),
(26, 1, '', 226, 360, 'http://192.168.1.119:801/uiweb/uploads/98/16365f287b4bb1088fb5a6e87422bb.png', '', '收音机', 24, '', '', '', 0, 0, 0, 0, '', '', '', 'fm', '', '', NULL, '2019-02-28 07:28:19', 0, '192.168.1.119'),
(27, 1, '', 226, 360, 'http://192.168.1.119:801/uiweb/uploads/16/c19411b6378fc65cf9c8748ffdd38e.png', '', '导航', 24, '', '', '', 0, 0, 0, 0, '', '', '', 'gps', '', '', NULL, '2019-02-28 07:28:36', 0, '192.168.1.119'),
(28, 1, '', 224, 178, 'http://192.168.1.119:801/uiweb/uploads/2a/0e68f37f5dc43997b59fc60cc6012c.png', '', '手机互连', 24, '', '', '', 0, 0, 0, 0, '', '', '', 'elink', '', '', NULL, '2019-02-28 07:28:55', 0, '192.168.1.119'),
(29, 1, '', 224, 178, 'http://192.168.1.119:801/uiweb/uploads/ad/5a1fcdacaa57c76347a835866af15e.png', '', '蓝牙音乐', 24, '', '', '', 0, 0, 0, 0, '', '', '', 'a2dp', '', '', NULL, '2019-02-28 07:29:13', 0, '192.168.1.119'),
(30, 1, '', 224, 178, 'http://192.168.1.119:801/uiweb/uploads/c9/b7850a33071914ceaa2cade7a9e947.png', '', '电话', 24, '', '', '', 0, 0, 0, 0, '', '', '', 'btdial', '', '', NULL, '2019-02-28 07:29:41', 0, '192.168.1.119'),
(31, 1, '', 224, 178, 'http://192.168.1.119:801/uiweb/uploads/a8/08edecfa47a2d2bb59d09fa5878b68.png', '', '音乐', 24, '', '', '', 0, 0, 0, 0, '', '', '', 'music', '', '', NULL, '2019-02-28 07:29:54', 0, '192.168.1.119'),
(32, 1, '', 226, 360, 'http://192.168.1.119:801/uiweb/uploads/84/2b41d38f193de15aee341fe5565a86.png', '', '视频', 24, '', '', '', 0, 0, 0, 0, '', '', '', 'video', '', '', NULL, '2019-02-28 07:30:06', 0, '192.168.1.119'),
(33, 1, '', 226, 360, 'http://192.168.1.119:801/uiweb/uploads/41/d435ffe832ac5ae52f17e225b9461e.png', '', '图片', 24, '', '', '', 0, 0, 0, 0, '', '', '', 'image', '', '', NULL, '2019-02-28 07:30:18', 0, '192.168.1.119'),
(34, 1, '', 224, 178, 'http://192.168.1.119:801/uiweb/uploads/7a/85cfe4d088c35e3825fe2b00c664c2.png', '', '设置', 24, '', '', '', 0, 0, 0, 0, '', '', '', 'setting', '', '', NULL, '2019-02-28 07:30:32', 0, '192.168.1.119'),
(35, 1, '', 224, 178, 'http://192.168.1.119:801/uiweb/uploads/38/ec79cc2aec48002bbc53a3b5a67f5d.png', '', '应用', 24, '', '', '', 0, 0, 0, 0, '', '', '', 'app', '', '', NULL, '2019-02-28 07:30:50', 0, '192.168.1.119'),
(36, 1, '', 224, 178, 'http://192.168.1.119:801/uiweb/uploads/d6/4c1e0501ce6c02329fbc8f6c1ae4ff.png', '', '外部输入', 24, '', '', '', 0, 0, 0, 0, '', '', '', 'avin', '', '', NULL, '2019-02-28 07:31:08', 0, '192.168.1.119'),
(37, 25, '', 262, 240, 'http://192.168.1.119:801/uiweb/uploads/5f/1f811aa95f638f767988a00f01394e.png', '', '', 64, '', '', '', 0, 30, 10, 0, '', '', '', '', '', '', NULL, '2019-03-01 07:41:05', 0, '192.168.1.119'),
(38, 26, '', 650, 236, 'http://192.168.1.119:801/uiweb/uploads/57/129fe006e2a381c9bf8f43897f8ad0.png', '', '', 24, '', '', '', 0, 0, 0, 0, '', '', '', '', '', '', NULL, '2019-02-28 09:30:48', 0, '192.168.1.119'),
(39, 1, '', 112, 112, 'http://192.168.1.119:801/uiweb/uploads/25/4df8e5261c6cf929c55282982930ff.png', '', '导航', 22, '', '', '', 0, -50, 0, 0, '', '', '', 'gps', '', '', NULL, '2019-03-01 01:00:22', 0, '192.168.1.119'),
(40, 1, '', 112, 112, 'http://192.168.1.119:801/uiweb/uploads/30/68a49cd794ad8de5b772758f22a042.png', '', '收音机', 22, '', '', '', 0, -50, 0, 0, '', '', '', 'fm', '', '', NULL, '2019-03-01 01:00:14', 0, '192.168.1.119'),
(41, 1, '', 112, 112, 'http://192.168.1.119:801/uiweb/uploads/8c/c7d7cb1215ec18e70d53da4767bd37.png', '', '应用', 22, '', '', '', 0, -50, 0, 0, '', '', '', 'app', '', '', NULL, '2019-03-01 01:00:07', 0, '192.168.1.119'),
(42, 1, '', 112, 112, 'http://192.168.1.119:801/uiweb/uploads/87/9d9fc1e1e0eace983aab1963f9c16a.png', '', '拔号', 22, '', '', '', 0, -50, 0, 0, '', '', '', 'btdial', '', '', NULL, '2019-03-01 01:00:00', 0, '192.168.1.119'),
(43, 1, '', 112, 112, 'http://192.168.1.119:801/uiweb/uploads/4e/bc1a24ead403511fd0379e8153ee4a.png', '', '蓝牙音乐', 22, '', '', '', 0, -50, 0, 0, '', '', '', 'a2dp', '', '蓝牙音乐', NULL, '2019-03-01 00:59:50', 0, '192.168.1.119'),
(46, 25, '', 387, 600, '', '', '', 80, '', '', '', 160, 160, 0, 0, '', '', '', '', '', '', NULL, '2019-03-01 07:41:28', 0, '192.168.1.119'),
(47, 27, '', 120, 102, 'http://192.168.1.119:801/uiweb/uploads/46/c79fe3d145713998afe5865c61f99f.png', '', '收音机', 24, '', '', '', 0, -80, 0, 0, '', '', '', 'fm', '', '', NULL, '2019-03-01 00:59:37', 0, '192.168.1.119'),
(48, 27, '', 120, 102, 'http://192.168.1.119:801/uiweb/uploads/43/486861fd73071b856bbb1447ba3267.png', '', '导航', 24, '', '', '', 0, -80, 0, 0, '', '', '', 'gps', '', '', NULL, '2019-03-01 01:20:48', 0, '192.168.1.119'),
(49, 27, '', 120, 102, 'http://192.168.1.119:801/uiweb/uploads/94/b44dd5837053b7d4f4bb1edcf088ed.png', '', '电话', 24, '', '', '', 0, -80, 0, 0, '', '', '', 'btdial', '', '', NULL, '2019-03-01 01:21:09', 0, '192.168.1.119'),
(50, 27, '', 120, 102, 'http://192.168.1.119:801/uiweb/uploads/fb/64a713876910c0db1ac700fef4014f.png', '', '手机互联', 24, '', '', '', 0, -80, 0, 0, '', '', '', 'elink', '', '', NULL, '2019-03-01 01:21:18', 0, '192.168.1.119'),
(51, 27, '', 120, 102, 'http://192.168.1.119:801/uiweb/uploads/18/1f189d48cdd19534a11a2b8b82e6c7.png', '', '蓝牙音乐', 24, '', '', '', 0, -80, 0, 0, '', '', '', 'a2dp', '', '', NULL, '2019-03-01 01:21:28', 0, '192.168.1.119'),
(52, 27, '', 120, 102, 'http://192.168.1.119:801/uiweb/uploads/df/26e5dd51ff3083c69dd564340c9be7.png', '', '视频', 24, '', '', '', 0, -80, 0, 0, '', '', '', 'video', '', '', NULL, '2019-03-01 01:21:35', 0, '192.168.1.119'),
(53, 27, '', 120, 102, 'http://192.168.1.119:801/uiweb/uploads/3b/61e5ac2c0600022bd032493591ff73.png', '', '音乐', 24, '', '', '', 0, -80, 0, 0, '', '', '', 'music', '', '', NULL, '2019-03-01 01:21:42', 0, '192.168.1.119'),
(54, 27, '', 120, 102, 'http://192.168.1.119:801/uiweb/uploads/1a/873420ae313b8241fb4c81478f6a8b.png', '', '设置', 24, '', '', '', 0, -80, 0, 0, '', '', '', 'setting', '', '', NULL, '2019-03-01 01:21:56', 0, '192.168.1.119'),
(55, 27, '', 120, 102, 'http://192.168.1.119:801/uiweb/uploads/31/922eb99e24bce5aae6ebedcf7426e0.png', '', '处部输入', 24, '', '', '', 0, -80, 0, 0, '', '', '', 'avin', '', '', NULL, '2019-03-01 01:22:04', 0, '192.168.1.119'),
(56, 27, '', 120, 102, 'http://192.168.1.119:801/uiweb/uploads/29/d48f76b6ebd6fcd1a4b1d993abbaa9.png', '', '应用', 24, '', '', '', 0, -80, 0, 0, '', '', '', 'app', '', '', NULL, '2019-03-01 01:22:10', 0, '192.168.1.119'),
(57, 27, '', 120, 102, 'http://192.168.1.119:801/uiweb/uploads/f0/ef35a722458f52b8c430e4abd055d5.png', '', '图片', 24, '', '', '', 0, -80, 0, 0, '', '', '', 'image', '', '', NULL, '2019-03-01 01:22:15', 0, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_celltype`
--

CREATE TABLE `fly_celltype` (
  `celltypeId` int(11) NOT NULL,
  `celltype` int(11) NOT NULL DEFAULT '0',
  `celltypeName` varchar(255) NOT NULL,
  `imageurl` varchar(255) NOT NULL,
  `extend` varchar(255) DEFAULT NULL,
  `remark` text,
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_celltype`
--

INSERT INTO `fly_celltype` (`celltypeId`, `celltype`, `celltypeName`, `imageurl`, `extend`, `remark`, `edittime`, `userid`, `ip`) VALUES
(1, 1, '通用控件', '/uiweb/uploads/ef/260b41ec0675e60869569b84fd52bb.png', '', '包含图片，文字，点击事件。', '2019-02-28 01:45:13', 0, '192.168.1.119'),
(23, 2, '收音机控件', 'http://192.168.1.119:801/uiweb/uploads/0f/87821bfe4d2ceed787c0b7f4520ae3.png', '', '特殊控件，跟系统平台相关。', '2019-02-28 01:46:34', 0, '192.168.1.119'),
(24, 0, '静态图片', 'http://192.168.1.119:801/uiweb/uploads/37/604a49f3cef26a842dca53f265c4cc.png', '', '只显示图片并且无点击事件。', '2019-02-28 01:45:22', 0, '192.168.1.119'),
(25, 3, '日期控件', 'http://192.168.1.119:801/uiweb/uploads/5f/1f811aa95f638f767988a00f01394e.png', NULL, '用来显示日期的控件', '2019-02-28 09:28:40', 0, '192.168.1.119'),
(26, 4, '媒体信息控件', 'http://192.168.1.119:801/uiweb/uploads/57/129fe006e2a381c9bf8f43897f8ad0.png', NULL, '显示媒体播放信息', '2019-02-28 09:30:38', 0, '192.168.1.119'),
(27, 5, '镜像控件', 'http://192.168.1.119:801/uiweb/uploads/dd/b5de46782680c61408d1f636a6071b.png', NULL, '可以生成镜像的图片', '2019-02-28 09:51:29', 0, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_event`
--

CREATE TABLE `fly_event` (
  `eventId` int(11) NOT NULL,
  `eventname` varchar(255) NOT NULL,
  `packname` varchar(255) NOT NULL,
  `classname` varchar(255) DEFAULT NULL,
  `data` text,
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `fly_history`
--

CREATE TABLE `fly_history` (
  `historyId` int(11) NOT NULL,
  `imageurl` varchar(255) NOT NULL,
  `historyTitle` varchar(255) NOT NULL,
  `historyText` text NOT NULL,
  `remark` text,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_history`
--

INSERT INTO `fly_history` (`historyId`, `imageurl`, `historyTitle`, `historyText`, `remark`, `createtime`, `userid`, `ip`) VALUES
(1, '/uiweb/uploads/c6/035a74237d5db8c5fecf9f27aed033.png', '2018年4月', '我们于华翰科技园成立了', NULL, '2019-02-23 03:23:20', 0, '192.168.1.119'),
(2, '/uiweb/uploads/69/220e370672bda3779f913d88e7d17f.png', '2018年10月', '我们来到了创维创新谷这个美丽的地方', NULL, '2019-02-23 02:46:27', 0, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_migrations`
--

CREATE TABLE `fly_migrations` (
  `version` bigint(20) NOT NULL,
  `migration_name` varchar(100) DEFAULT NULL,
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `breakpoint` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_migrations`
--

INSERT INTO `fly_migrations` (`version`, `migration_name`, `start_time`, `end_time`, `breakpoint`) VALUES
(20170822041240, 'Rbac', '2019-03-01 03:29:03', '2019-03-01 03:29:03', 0);

-- --------------------------------------------------------

--
-- 表的结构 `fly_news`
--

CREATE TABLE `fly_news` (
  `newsId` int(11) NOT NULL,
  `newsTitle` varchar(255) NOT NULL,
  `newsSort` int(11) NOT NULL DEFAULT '0',
  `imageurl1` varchar(255) DEFAULT NULL,
  `imageurl2` varchar(255) DEFAULT NULL,
  `newsText` text NOT NULL,
  `remark` text,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_news`
--

INSERT INTO `fly_news` (`newsId`, `newsTitle`, `newsSort`, `imageurl1`, `imageurl2`, `newsText`, `remark`, `createtime`, `userid`, `ip`) VALUES
(1, '外交部：5G全球产业链供应链等无法人为割裂或剥离', 1, '/uiweb/uploads/4c/b32fd9b6fae5c378c2c0410e7cf70f.jpg', '/uiweb/uploads/15/4ee5c4d6d4a95003335ae5ebc7e6c9.jpg', '　　“外交部发言人办公室”公众号消息，在2月21日外交部例行记者会上，有记者问：下周，世界移动通讯大会将在巴塞罗那召开，5G技术将成为会议热点话题之一。我们注意到，一段时间以来，围绕中国企业参与有关国家的5G网络建设有不少议论。有人认为中国企业的产品和设备存在安全隐患，应将其排除在5G网络建设之外。你对此有何评论？\r\n　　耿爽：第五代移动通信技术（5G）作为一项前沿科技，不是某个或某几个国家的专属，而是关乎全球经济发展、世界各国利益和人类文明进步的大事。\r\n　　5G技术是全球化大潮下各国交流合作的产物，是国际社会共同的高科技创新成果。它的全球产业链、供应链、价值链高度融合，无法人为割裂或剥离，否则将会影响互利共赢的多边合作，损害开放包容的市场环境，破坏公平、公正、非歧视的国际规则。\r\n　　在全球化时代，没有哪一个国家可以脱离世界独立发展，也没有哪一项技术的开发与应用可以拒绝合作。中方将继续秉持共商共建共享原则，同各方共同把握新一轮科技革命带来的巨大发展机遇，加强包括5G在内的科技交流与合作，努力实现共同发展、互利共赢，为促进全人类福祉作出积极贡献。\r\n　　在这一进程中，我们希望各国都能基于自己的独立判断作出符合自身利益、符合时代潮流的选择。', '', '2019-02-21 10:09:51', 0, '192.168.1.119'),
(3, '物理学家在环形装置内发现“非一般”的光行为', 0, '/uiweb/uploads/8e/466e3e87d66d8a0e5b9c4c9a968aa9.jpg', '', '　　新浪科技讯 北京时间2月22日消息，据国外媒体报道，来自英国的物理学家团队建造了一台环形机器，当光脉冲在里面围绕着彼此旋转时，控制光行为的一般规律不再适用。\r\n\r\n　　在正常情况下，光会展现出某种物理对称性。首先，假设你有一盘记录了光行为的录像带，那么无论是正放还是倒放，你会发现光在两个时间方向上的行为是一样的。这一现象被称为“时间反演对称”。其次，光能以波的形式进行传播，会表现出所谓的“偏振”现象：相对于波的运动而发生的振荡。这种偏振通常保持不变，提供了另一种对称性。\r\n\r\n\r\n　　但是，在这个环形装置内部，光既失去了时间反演对称性，其偏振也发生改变。光波在环形装置内会转圈并相互共振，产生在外界通常不存在的效应。\r\n\r\n　　研究人员已经知道，在特定条件下，当光在光学环形装置内部运行时，会失去时间反演对称性。光波的波峰不会在对称性所要求的位置出现。在1月10日发表于《物理评论快报》（Physical Review Letters）杂志的一篇新论文中，来自英国国家物理实验室（National Physical Laboratory，简称NPL）的研究团队指出，在这一现象发生的同时，光的偏振也会发生改变。\r\n\r\n　　研究团队将细心定时的激光脉冲射入名为“光学环形谐振器”的装置中，光的波峰排列方式没有呈现出时间反演对称性。当光束互相环绕时，只形成了单一时间方向上的模式。与此同时，光失去了垂直偏振——光波不再以严格的上下方式运动，而是形成了椭圆形。\r\n\r\n　　物理学家在一份声明中说，这项研究为光的操纵打开了新的大门，将使研究人员的工作更加精确，并为原子钟和量子计算机等设备中的光学环路提供新的设计。', NULL, '2019-02-22 01:36:12', 0, '192.168.1.119'),
(4, ' 怎么得到 thinkphp 查询结果的返回条数1', 0, '/uiweb/uploads/4e/5d2087efc0c4c74acd1d3612b20c62.png', '', '　　怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数\r\n　　怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数\r\n　　怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数', NULL, '2019-02-22 04:01:48', 0, '192.168.1.119'),
(5, ' 怎么得到 thinkphp 查询结果的返回条数', 0, '/uiweb/uploads/15/4ee5c4d6d4a95003335ae5ebc7e6c9.jpg', '', '　　怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数　　怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数　　怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数　　怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数　　怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数怎么得到 thinkphp 查询结果的返回条数', NULL, '2019-02-22 04:01:59', 0, '192.168.1.119'),
(6, ' 怎么得到 thinkphp 查询结果的返回条数', 0, '/uiweb/uploads/4c/b32fd9b6fae5c378c2c0410e7cf70f.jpg', '', '\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数', NULL, '2019-02-22 04:02:09', 0, '192.168.1.119'),
(7, ' 怎么得到 thinkphp 查询结果的返回条数', 0, '/uiweb/uploads/15/4ee5c4d6d4a95003335ae5ebc7e6c9.jpg', '', '\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数', NULL, '2019-02-22 04:02:16', 0, '192.168.1.119'),
(8, ' 怎么得到 thinkphp 查询结果的返回条数2', 0, '/uiweb/uploads/15/4ee5c4d6d4a95003335ae5ebc7e6c9.jpg', '', '\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数', NULL, '2019-02-22 04:02:25', 0, '192.168.1.119'),
(9, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1', 0, '/uiweb/uploads/38/0967ac8187cb0608342065a8bacf7d.png', '', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1', NULL, '2019-02-22 07:15:42', 0, '192.168.1.119'),
(10, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试2', 0, '/uiweb/uploads/01/7c0cd91527fd7063c17dd700c2a82b.png', '', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1', NULL, '2019-02-22 07:15:52', 0, '192.168.1.119'),
(11, '2测试测试测试测试222222222222222222222', 0, '/uiweb/uploads/4f/784d6be45e2470d41356cc8cb93cd1.png', '/uiweb/uploads/76/a6a23737af8ba27d3577f4ec5f5bd2.png', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1', NULL, '2019-02-22 07:16:04', 0, '192.168.1.119'),
(12, '测试测试测试测试测试测试测试测试测试测试测wwww', 0, 'http://192.168.1.119:801/uiweb/uploads/8e/466e3e87d66d8a0e5b9c4c9a968aa9.jpg', '', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1', NULL, '2019-02-22 07:17:34', 0, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_page`
--

CREATE TABLE `fly_page` (
  `pageId` int(11) NOT NULL,
  `pageName` varchar(255) NOT NULL,
  `imageurl` varchar(255) NOT NULL,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `remark` text,
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) DEFAULT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_page`
--

INSERT INTO `fly_page` (`pageId`, `pageName`, `imageurl`, `width`, `height`, `remark`, `edittime`, `userid`, `ip`) VALUES
(5, '第一页', '', 1024, 600, 'Launcher-AP1', '2019-02-27 08:42:44', 0, '192.168.1.119'),
(6, '第二页', '', 1024, 600, 'Launcher-AP1', '2019-02-27 08:42:36', 0, '192.168.1.119'),
(7, '第三页', '', 1024, 600, 'Launcher-AP1', '2019-02-27 08:42:56', 0, '192.168.1.119'),
(8, '第一页', '', 1024, 600, 'Launcher-AP2', '2019-02-28 07:32:03', 0, '192.168.1.119'),
(9, '第二页', '', 1024, 600, 'Launcher-AP2', '2019-02-28 08:29:10', 0, '192.168.1.119'),
(11, '第一页', '', 1024, 600, 'Launcher-AP3', '2019-02-28 09:09:35', 0, '192.168.1.119'),
(12, '第一页', '', 1024, 600, 'Launcher-AP4', '2019-02-28 09:55:44', 0, '192.168.1.119'),
(13, '第二页', '', 1024, 600, 'Launcher-AP4', '2019-03-01 01:09:54', 0, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_pagecell`
--

CREATE TABLE `fly_pagecell` (
  `id` int(11) NOT NULL,
  `pageId` int(11) NOT NULL,
  `cellId` int(11) NOT NULL,
  `x` int(11) NOT NULL,
  `y` int(11) NOT NULL,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_pagecell`
--

INSERT INTO `fly_pagecell` (`id`, `pageId`, `cellId`, `x`, `y`, `width`, `height`) VALUES
(1, 3, 9, 308, 122, 212, 317),
(2, 3, 9, 783, 129, 212, 317),
(3, 3, 10, 546, 126, 212, 317),
(4, 3, 12, 62, 122, 212, 317),
(5, 4, 9, 55, 143, 212, 317),
(6, 4, 10, 306, 144, 212, 317),
(7, 5, 15, 42, 141, 212, 317),
(8, 5, 17, 526, 141, 212, 317),
(9, 5, 18, 768, 141, 212, 317),
(10, 5, 16, 284, 141, 212, 317),
(11, 6, 19, 42, 141, 212, 317),
(12, 6, 20, 284, 141, 212, 317),
(13, 6, 21, 526, 141, 212, 317),
(14, 6, 22, 768, 141, 212, 317),
(15, 8, 26, 44, 132, 226, 360),
(16, 8, 27, 282, 132, 226, 360),
(17, 8, 28, 522, 132, 224, 178),
(18, 8, 29, 760, 132, 224, 178),
(19, 8, 30, 522, 311, 224, 178),
(20, 8, 31, 760, 311, 224, 178),
(21, 9, 32, 44, 132, 226, 360),
(22, 9, 33, 282, 132, 226, 360),
(23, 9, 34, 522, 132, 224, 178),
(24, 9, 35, 760, 132, 224, 178),
(25, 9, 36, 522, 311, 224, 178),
(26, 9, 30, 760, 311, 224, 178),
(27, 10, 36, 81, 45, 224, 178),
(28, 10, 35, 104, 294, 224, 178),
(29, 10, 35, 104, 294, 224, 178),
(30, 10, 28, 461, 290, 224, 178),
(31, 7, 25, 526, 141, 212, 317),
(32, 7, 23, 42, 141, 212, 317),
(33, 7, 24, 284, 141, 212, 317),
(34, 7, 15, 768, 141, 212, 317),
(35, 11, 37, 41, 121, 262, 240),
(36, 11, 38, 334, 121, 650, 236),
(37, 11, 39, 41, 420, 112, 112),
(38, 11, 40, 248, 420, 112, 112),
(39, 11, 41, 454, 420, 112, 112),
(40, 11, 42, 659, 420, 112, 112),
(41, 11, 43, 866, 420, 112, 112),
(42, 13, 46, 0, 0, 387, 600),
(43, 13, 53, 387, 121, 120, 102),
(44, 13, 57, 608, 121, 120, 102),
(45, 13, 54, 828, 121, 120, 102),
(46, 13, 55, 387, 349, 120, 102),
(47, 13, 56, 608, 349, 120, 102),
(48, 12, 46, 0, 0, 387, 600),
(49, 12, 47, 387, 121, 120, 102),
(50, 12, 48, 608, 121, 120, 102),
(51, 12, 49, 829, 121, 120, 102),
(52, 12, 50, 387, 349, 120, 102),
(53, 12, 51, 608, 349, 120, 102),
(54, 12, 52, 829, 349, 120, 102);

-- --------------------------------------------------------

--
-- 表的结构 `fly_permission`
--

CREATE TABLE `fly_permission` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '权限名称',
  `path` varchar(100) NOT NULL DEFAULT '' COMMENT '权限路径',
  `description` varchar(200) NOT NULL DEFAULT '' COMMENT '权限描述',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '权限状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- --------------------------------------------------------

--
-- 表的结构 `fly_product`
--

CREATE TABLE `fly_product` (
  `productId` int(11) NOT NULL,
  `imageurl` varchar(255) NOT NULL,
  `productSort` int(11) NOT NULL,
  `productTitle` varchar(255) NOT NULL,
  `productDetail` text NOT NULL,
  `iconurl` varchar(255) NOT NULL,
  `remark` text,
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_product`
--

INSERT INTO `fly_product` (`productId`, `imageurl`, `productSort`, `productTitle`, `productDetail`, `iconurl`, `remark`, `edittime`, `userid`, `ip`) VALUES
(2, '/uiweb/uploads/23/e3cf886844a7287f16c2583dbef583.jpg', 1, '核心板', '核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板', '/uiweb/uploads/21/911649e1292399373950dfa2b9acbf.png', '', '2019-03-01 06:21:46', 0, '192.168.1.119'),
(3, '/uiweb/uploads/23/e3cf886844a7287f16c2583dbef583.jpg', 2, '一体板', '一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板', '/uiweb/uploads/30/c3804c8eeb10fc1021e76a62ebb609.png', '', '2019-02-21 08:54:16', 0, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_recruitment`
--

CREATE TABLE `fly_recruitment` (
  `recruitmentId` int(11) NOT NULL,
  `recruitmentTitle` varchar(255) NOT NULL,
  `recruitmentText` text NOT NULL,
  `recruitmentStatu` int(11) NOT NULL DEFAULT '1',
  `remark` text,
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_recruitment`
--

INSERT INTO `fly_recruitment` (`recruitmentId`, `recruitmentTitle`, `recruitmentText`, `recruitmentStatu`, `remark`, `edittime`, `userid`, `ip`) VALUES
(1, 'JAVA 工程师', '1、前端开发及维护工作；\r\n2、有良好的技术基础，熟悉 Web 标准，熟练掌握多种 Web 驾驶技术；\r\n3、掌握行业内流行的类库，Vue.js， React 等主流框架；\r\n4、参与公司驾驶工程的设计、研发；\r\n5、了解不同浏览器之间的差异，移动设备之间的差异。', 1, NULL, '2019-02-23 01:22:19', 0, '192.168.1.119'),
(2, '前端工程师', '1、前端开发及维护工作；\r\n 2、有良好的技术基础，熟悉 Web 标准，熟练掌握多种 Web 驾驶技术； \r\n3、掌握行业内流行的类库，Vue.js， React 等主流框架；\r\n 4、参与公司驾驶工程的设计、研发； \r\n5、了解不同浏览器之间的差异，移动设备之间的差异。', 1, NULL, '2019-02-23 03:33:00', 0, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_role`
--

CREATE TABLE `fly_role` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '角色名称',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父角色id',
  `description` varchar(200) NOT NULL DEFAULT '' COMMENT '描述信息',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '角色状态',
  `sort_num` int(11) NOT NULL DEFAULT '0' COMMENT '排序值',
  `left_key` int(11) NOT NULL DEFAULT '0' COMMENT '用来组织关系的左值',
  `right_key` int(11) NOT NULL DEFAULT '0' COMMENT '用来组织关系的右值',
  `level` int(11) NOT NULL DEFAULT '0' COMMENT '所处层级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- --------------------------------------------------------

--
-- 表的结构 `fly_role_permission`
--

CREATE TABLE `fly_role_permission` (
  `id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色Id',
  `permission_id` int(11) NOT NULL DEFAULT '0' COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限对应表';

-- --------------------------------------------------------

--
-- 表的结构 `fly_theme`
--

CREATE TABLE `fly_theme` (
  `themeId` int(11) NOT NULL,
  `themeName` varchar(64) NOT NULL,
  `themeType` int(11) DEFAULT NULL,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `imageurl` varchar(255) DEFAULT NULL,
  `isMirror` tinyint(1) NOT NULL,
  `animType` int(11) NOT NULL,
  `remark` text,
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_theme`
--

INSERT INTO `fly_theme` (`themeId`, `themeName`, `themeType`, `width`, `height`, `imageurl`, `isMirror`, `animType`, `remark`, `edittime`, `userid`, `ip`) VALUES
(5, 'Launcher-AP1', NULL, 1024, 600, 'http://192.168.1.119:801/uiweb/uploads/4c/b32fd9b6fae5c378c2c0410e7cf70f.jpg', 1, 1, '', '2019-03-01 05:06:46', 0, '192.168.1.119'),
(7, 'Launcher-AP2', NULL, 1024, 600, 'http://192.168.1.119:801/uiweb/uploads/f8/fc65ab56c952ebccd91be18b9a2d06.png', 1, 1, '', '2019-03-01 07:31:37', 0, '192.168.1.119'),
(12, 'Launcher-AP3', NULL, 1024, 600, 'http://192.168.1.119:801/uiweb/uploads/b0/c768931cd086751d854d1847e181cf.png', 0, 0, '', '2019-02-28 09:48:15', 0, '192.168.1.119'),
(13, 'Launcher-AP4', NULL, 1024, 600, 'http://192.168.1.119:801/uiweb/uploads/2f/e2f98c6ff84f553cc7c7079b721ad1.png', 0, 1, '', '2019-03-01 05:06:10', 0, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_themepage`
--

CREATE TABLE `fly_themepage` (
  `id` int(11) NOT NULL,
  `themeId` int(11) NOT NULL,
  `pageId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_themepage`
--

INSERT INTO `fly_themepage` (`id`, `themeId`, `pageId`) VALUES
(1, 6, 1),
(2, 6, 3),
(3, 6, 4),
(9, 5, 5),
(10, 5, 6),
(11, 5, 7),
(12, 12, 11),
(13, 13, 12),
(14, 13, 13),
(24, 7, 8),
(25, 7, 9);

-- --------------------------------------------------------

--
-- 表的结构 `fly_user`
--

CREATE TABLE `fly_user` (
  `id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户账号',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '用户密码',
  `mobile` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号码',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `last_login_time` int(11) NOT NULL DEFAULT '0' COMMENT '最后登录时间',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '用户状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- --------------------------------------------------------

--
-- 表的结构 `fly_user_role`
--

CREATE TABLE `fly_user_role` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色对应关系';

-- --------------------------------------------------------

--
-- 表的结构 `fly_welcome`
--

CREATE TABLE `fly_welcome` (
  `welcomeId` int(11) NOT NULL,
  `imageurl` varchar(255) NOT NULL,
  `welcomeTitle` varchar(255) DEFAULT NULL,
  `welcomeText` text,
  `welcomeSort` int(11) NOT NULL DEFAULT '0',
  `userid` int(11) NOT NULL,
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_welcome`
--

INSERT INTO `fly_welcome` (`welcomeId`, `imageurl`, `welcomeTitle`, `welcomeText`, `welcomeSort`, `userid`, `edittime`, `ip`) VALUES
(1, 'http://192.168.1.119:801/uiweb/uploads/4c/b32fd9b6fae5c378c2c0410e7cf70f.jpg', '深圳景安驰', '保持驾驶安全永远是第一重要，任何新功能的增加都必须先考虑这个原则。', 1, 0, '2019-02-28 08:26:17', '192.168.1.119'),
(3, '/uiweb/uploads/3b/1b79b7bfda8e8841538b7291782506.jpg', '深圳景安驰', '车载系统不是手机系统的简单移植，手机上的应用大部分也不适合车载系统。', 2, 0, '2019-02-21 07:10:00', '192.168.1.119'),
(4, 'http://192.168.1.119:801/uiweb/uploads/4c/b32fd9b6fae5c378c2c0410e7cf70f.jpg', '深圳景安驰', '车载系统不是手机系统的简单移植，手机上的应用大部分也不适合车载系统。车载系统不是手机系统的简单移植，手机上的应用大部分也不适合车载系统。', 3, 0, '2019-03-01 06:21:33', '192.168.1.119');

--
-- 转储表的索引
--

--
-- 表的索引 `fly_about`
--
ALTER TABLE `fly_about`
  ADD PRIMARY KEY (`aboutId`);

--
-- 表的索引 `fly_cases`
--
ALTER TABLE `fly_cases`
  ADD PRIMARY KEY (`casesId`);

--
-- 表的索引 `fly_cell`
--
ALTER TABLE `fly_cell`
  ADD PRIMARY KEY (`cellId`),
  ADD KEY `id` (`cellId`),
  ADD KEY `type` (`celltypeId`);

--
-- 表的索引 `fly_celltype`
--
ALTER TABLE `fly_celltype`
  ADD PRIMARY KEY (`celltypeId`),
  ADD KEY `celltypeId` (`celltypeId`);

--
-- 表的索引 `fly_event`
--
ALTER TABLE `fly_event`
  ADD PRIMARY KEY (`eventId`);

--
-- 表的索引 `fly_history`
--
ALTER TABLE `fly_history`
  ADD PRIMARY KEY (`historyId`);

--
-- 表的索引 `fly_migrations`
--
ALTER TABLE `fly_migrations`
  ADD PRIMARY KEY (`version`);

--
-- 表的索引 `fly_news`
--
ALTER TABLE `fly_news`
  ADD PRIMARY KEY (`newsId`);

--
-- 表的索引 `fly_page`
--
ALTER TABLE `fly_page`
  ADD PRIMARY KEY (`pageId`);

--
-- 表的索引 `fly_pagecell`
--
ALTER TABLE `fly_pagecell`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tableId` (`pageId`),
  ADD KEY `cellId` (`cellId`);

--
-- 表的索引 `fly_permission`
--
ALTER TABLE `fly_permission`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `fly_product`
--
ALTER TABLE `fly_product`
  ADD PRIMARY KEY (`productId`);

--
-- 表的索引 `fly_recruitment`
--
ALTER TABLE `fly_recruitment`
  ADD PRIMARY KEY (`recruitmentId`);

--
-- 表的索引 `fly_role`
--
ALTER TABLE `fly_role`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `fly_role_permission`
--
ALTER TABLE `fly_role_permission`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `fly_theme`
--
ALTER TABLE `fly_theme`
  ADD PRIMARY KEY (`themeId`),
  ADD UNIQUE KEY `themeId` (`themeId`),
  ADD UNIQUE KEY `themeName` (`themeName`),
  ADD KEY `themeId_2` (`themeId`),
  ADD KEY `themeName_2` (`themeName`);

--
-- 表的索引 `fly_themepage`
--
ALTER TABLE `fly_themepage`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `fly_user`
--
ALTER TABLE `fly_user`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `fly_user_role`
--
ALTER TABLE `fly_user_role`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `fly_welcome`
--
ALTER TABLE `fly_welcome`
  ADD PRIMARY KEY (`welcomeId`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `fly_about`
--
ALTER TABLE `fly_about`
  MODIFY `aboutId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- 使用表AUTO_INCREMENT `fly_cases`
--
ALTER TABLE `fly_cases`
  MODIFY `casesId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- 使用表AUTO_INCREMENT `fly_cell`
--
ALTER TABLE `fly_cell`
  MODIFY `cellId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- 使用表AUTO_INCREMENT `fly_celltype`
--
ALTER TABLE `fly_celltype`
  MODIFY `celltypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- 使用表AUTO_INCREMENT `fly_event`
--
ALTER TABLE `fly_event`
  MODIFY `eventId` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `fly_history`
--
ALTER TABLE `fly_history`
  MODIFY `historyId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `fly_news`
--
ALTER TABLE `fly_news`
  MODIFY `newsId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- 使用表AUTO_INCREMENT `fly_page`
--
ALTER TABLE `fly_page`
  MODIFY `pageId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- 使用表AUTO_INCREMENT `fly_pagecell`
--
ALTER TABLE `fly_pagecell`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- 使用表AUTO_INCREMENT `fly_permission`
--
ALTER TABLE `fly_permission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `fly_product`
--
ALTER TABLE `fly_product`
  MODIFY `productId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- 使用表AUTO_INCREMENT `fly_recruitment`
--
ALTER TABLE `fly_recruitment`
  MODIFY `recruitmentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `fly_role`
--
ALTER TABLE `fly_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `fly_role_permission`
--
ALTER TABLE `fly_role_permission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `fly_theme`
--
ALTER TABLE `fly_theme`
  MODIFY `themeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- 使用表AUTO_INCREMENT `fly_themepage`
--
ALTER TABLE `fly_themepage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- 使用表AUTO_INCREMENT `fly_user`
--
ALTER TABLE `fly_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `fly_user_role`
--
ALTER TABLE `fly_user_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `fly_welcome`
--
ALTER TABLE `fly_welcome`
  MODIFY `welcomeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
