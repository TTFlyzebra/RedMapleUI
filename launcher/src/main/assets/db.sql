-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2019-06-24 00:44:16
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
  `status` int(11) NOT NULL DEFAULT '1',
  `remark` text,
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_about`
--

INSERT INTO `fly_about` (`aboutId`, `imageurl`, `aboutText`, `status`, `remark`, `edittime`, `userid`, `ip`) VALUES
(1, 'http://127.0.0.1/uiweb/uploads/58/a3ee19fdd8c6473532ca9463b90077.jpg', '身处在前端社区的繁荣之下，我们都在有意或无意地追逐。而 layui 偏偏回望当初，奔赴在返璞归真的漫漫征途，自信并勇敢着，追寻于原生态的书写指令，试图以最简单的方式诠释高效。身处在前端社区的繁荣之下，我们都在有意或无意地追逐。而 layui 偏偏回望当初，奔赴在返璞归真的漫漫征途，自信并勇敢着，追寻于原生态的书写指令，试图以最简单的方式诠释高效。身处在前端社区的繁荣之下，我们都在有意或无意地追逐。而 layui 偏偏回望当初，奔赴在返璞归真的漫漫征途，自信并勇敢着，追寻于原生态的书写指令，试图以最简单的方式诠释高效', 1, NULL, '2019-03-09 08:24:58', 0, '192.168.1.119'),
(2, 'http://127.0.0.1/uiweb/uploads/eb/eeb8f691d4836161e6bde902abf265.jpg', '拥有双面的不仅是人生，还有Layui。一面极简，一面丰盈。极简是视觉所见的外在，是开发所念的简易。丰盈是倾情雕琢的内在，是信手拈来的承诺。一切本应如此，简而全，双重体验。拥有双面的不仅是人生，还有Layui。一面极简，一面丰盈。极简是视觉所见的外在，是开发所念的简易。丰盈是倾情雕琢的内在，是信手拈来的承诺。一切本应如此，简而全，双重体验。', 1, NULL, '2019-03-09 08:25:03', 0, '192.168.1.119'),
(3, 'http://127.0.0.1/uiweb/uploads/f9/d546081201d174ffe28d6e5b24207c.jpg', '拥有双面的不仅是人生，还有Layui。一面极简，一面丰盈。极简是视觉所见的外在，是开发所念的简易。丰盈是倾情雕琢的内在，是信手拈来的承诺。一切本应如此，简而全，双重体验。', 1, NULL, '2019-03-11 06:06:59', 0, '192.168.1.119'),
(4, 'http://127.0.0.1/uiweb/uploads/8c/e959e3095e392fd7f8c63177cfac0a.jpg', '关于我们', 0, NULL, '2019-03-11 02:21:11', 6, '192.168.1.119'),
(5, 'http://127.0.0.1/uiweb/uploads/12/993f4446443c2d7f25596512720cdf.jpg', 'test', 0, NULL, '2019-03-11 06:07:22', 6, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_cases`
--

CREATE TABLE `fly_cases` (
  `casesId` int(11) NOT NULL,
  `casesTitle` varchar(255) NOT NULL,
  `imageurl` varchar(255) NOT NULL,
  `casesText` text NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `remark` text,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_cases`
--

INSERT INTO `fly_cases` (`casesId`, `casesTitle`, `imageurl`, `casesText`, `status`, `remark`, `createtime`, `userid`, `ip`) VALUES
(1, '名牌工厂店', 'http://127.0.0.1/uiweb/uploads/8c/e959e3095e392fd7f8c63177cfac0a.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。', 1, '', '2019-02-22 09:21:47', 0, '192.168.1.119'),
(2, '测试没试', 'http://127.0.0.1/uiweb/uploads/12/993f4446443c2d7f25596512720cdf.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。', 1, '', '2019-02-22 09:25:07', 0, '192.168.1.119'),
(3, '纟纟纟x', 'http://127.0.0.1/uiweb/uploads/c6/4c0069727708f55646a135eba53c4f.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。', 1, '', '2019-02-22 09:38:07', 0, '192.168.1.119'),
(4, 'cccccccccc', 'http://127.0.0.1/uiweb/uploads/d8/0f7d89969851465634660e03e4f922.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。', 1, '', '2019-02-22 09:49:09', 0, '192.168.1.119'),
(5, 'ccccc', 'http://127.0.0.1/uiweb/uploads/4b/86c495bffe7e2f2f0b8d11d30f580d.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。', 1, '', '2019-02-22 09:50:22', 0, '192.168.1.119'),
(6, 'bbbb', 'http://127.0.0.1/uiweb/uploads/fb/373749569112755e4149c01d7f7346.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。一家工厂企业的商品展示网站，主要以卖高端服饰为主。主要以卖高端服饰为主。主要以卖高端服饰为主。', 1, '', '2019-02-22 09:50:30', 0, '192.168.1.119'),
(7, '一家工厂企业的商品展示一家工厂企业的商品展示', 'http://127.0.0.1/uiweb/uploads/c6/4c0069727708f55646a135eba53c4f.jpg', '一家工厂企业的商品展示网站，主要以卖高端服饰为主。', 1, '', '2019-02-22 09:50:40', 6, '192.168.1.119'),
(8, '新闻新闻新闻新闻新闻', 'http://127.0.0.1/uiweb/uploads/9f/e51538edbe7cd7ab234da7af1fc7d0.jpg', '新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻新闻', 0, NULL, '2019-03-11 06:07:53', 6, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_cell`
--

CREATE TABLE `fly_cell` (
  `cellId` int(11) NOT NULL COMMENT '主键，自动递增',
  `description` varchar(255) DEFAULT NULL COMMENT '描述，方便查找搜索',
  `themeId` int(11) NOT NULL COMMENT '关联模块ID',
  `celltypeId` int(11) NOT NULL COMMENT '关联组件类型ID',
  `resId` int(11) DEFAULT NULL COMMENT '资源ID标识',
  `width` int(11) NOT NULL COMMENT '组件宽度',
  `height` int(11) NOT NULL COMMENT '组件高度',
  `backColor` varchar(9) DEFAULT NULL COMMENT '组件背景颜色',
  `filterColor` varchar(9) DEFAULT NULL COMMENT '组件过滤颜色',
  `recv` varchar(1024) DEFAULT NULL COMMENT '接收事件(JSON)',
  `send` varchar(1024) DEFAULT NULL COMMENT '发送事件(JSON)',
  `texts` text COMMENT '包含文本(JSON)',
  `images` text COMMENT '包含图片(JSON)',
  `pages` text COMMENT '包含页面(JSON)',
  `remark` text COMMENT '备注',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `userid` int(11) NOT NULL COMMENT '用户ID',
  `uptime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ip` varchar(15) NOT NULL COMMENT 'IP地址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_cell`
--

INSERT INTO `fly_cell` (`cellId`, `description`, `themeId`, `celltypeId`, `resId`, `width`, `height`, `backColor`, `filterColor`, `recv`, `send`, `texts`, `images`, `pages`, `remark`, `status`, `userid`, `uptime`, `ip`) VALUES
(15, '导航', 5, 1, 0, 212, 317, '', '', '', '{\"packName\":\"com.flyzebra.music\"}', '[{\"text\":\"{\\\"en\\\":\\\"Navigate\\\",\\\"zh_rCN\\\":\\\"\\u5bfc\\u822a\\\",\\\"zh_rTW\\\":\\\"\\u822a\\u884c\\\",\\\"ru\\\":\\\"\\u0443\\u043f\\u0440\\u0430\\u0432\\u043b\\u044f\\u0442\\u044c\\\",\\\"el\\\":\\\"\\u03c0\\u03bb\\u03bf\\u03b7\\u03b3\\u03b7\\u03b8\\u03b5\\u03af\\u03c4\\u03b5\\\",\\\"pl\\\":\\\"nawigowa\\u0107\\\",\\\"tr\\\":\\\"gezinme\\\",\\\"ar\\\":\\\"\\u0627\\u0644\\u062a\\u0646\\u0642\\u0644\\\",\\\"fa\\\":\\\"\\u062d\\u0631\\u06a9\\u062a\\\",\\\"ro\\\":\\\"Naviga\\u021bi\\\",\\\"fr\\\":\\\"naviguer\\\",\\\"hu\\\":\\\"navig\\u00e1lni\\\",\\\"it\\\":\\\"navigare\\\",\\\"th\\\":\\\"\\u0e19\\u0e33\\u0e17\\u0e32\\u0e07\\\",\\\"de\\\":\\\"navigieren\\\",\\\"uk\\\":\\\"\\u0443\\u043f\\u0440\\u0430\\u0432\\u043b\\u044f\\u0442\\u0438\\\",\\\"es\\\":\\\"Navegue\\\",\\\"pt\\\":\\\"navegar\\\"}\",\"textSize\":24,\"textLines\":2,\"textLines\":2,\"textColor\":\"\",\"textFilter\":\"\",\"left\":0,\"top\":237,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":212,\"height\":317,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c8\\/6018220c4ee22e77fc786d0f426418.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-18 05:32:57', '192.168.1.119'),
(16, '收音机', 5, 1, 0, 212, 317, '', '', '', '{\"packName\":\"com.jancar.radios\",\"className\":\"com.jancar.radio.RadioActivity\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6536\\u97f3\\u673a\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"\",\"textFilter\":\"\",\"left\":0,\"top\":237,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":212,\"height\":317,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/0f\\/87821bfe4d2ceed787c0b7f4520ae3.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:12:14', '192.168.1.119'),
(17, '电话', 5, 1, NULL, 212, 317, NULL, NULL, NULL, '{\"packName\":\"com.jancar.bluetooth.phone\",\"className\":\"com.jancar.bluetooth.phone.view.MainActivity\"}', '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u7535\\\\u8bdd\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":237,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/b4\\/5f3074145ee304968b55d10c9d1ed4.png\",\"width\":212,\"height\":317,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:32:57', '192.168.1.119'),
(18, '手机互连', 5, 1, NULL, 212, 317, NULL, NULL, NULL, '{\"packName\":\"net.easyconn\",\"className\":\"net.easyconn.WelcomeActivity\"}', '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u624b\\\\u673a\\\\u4e92\\\\u8fde\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":237,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/ef\\/260b41ec0675e60869569b84fd52bb.png\",\"width\":212,\"height\":317,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-21 01:15:15', '192.168.1.119'),
(19, '视频', 5, 1, NULL, 212, 317, NULL, NULL, NULL, '{\"packName\":\"com.flyzebra.video\",\"className\":\"\"}', '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u89c6\\\\u9891\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":237,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/7b\\/34563bd1049ce673e11625742926d3.png\",\"width\":212,\"height\":317,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:32:57', '192.168.1.119'),
(20, '蓝牙音乐', 5, 1, NULL, 212, 317, NULL, NULL, NULL, '{\"packName\":\"com.jancar.bluetooth.phone\",\"className\":\"com.jancar.bluetooth.phone.view.MusicActivity\"}', '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u84dd\\\\u7259\\\\u97f3\\\\u4e50\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":237,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/27\\/b48342fb63e9c166be68a33c9534db.png\",\"width\":212,\"height\":317,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:32:57', '192.168.1.119'),
(21, '音乐', 5, 1, NULL, 212, 317, NULL, NULL, NULL, '{\"packName\":\"com.flyzebra.music\",\"className\":\"\"}', '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u97f3\\\\u4e50\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":237,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/39\\/279aab526e8a8555ed6694ef77209a.png\",\"width\":212,\"height\":317,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:32:57', '192.168.1.119'),
(22, '图片', 5, 1, NULL, 212, 317, NULL, NULL, NULL, '{\"packName\":\"com.flyzebra.photo\",\"className\":\"\"}', '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u56fe\\\\u7247\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":237,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/61\\/70539390aa7b1008e93213c44443bd.png\",\"width\":212,\"height\":317,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:32:57', '192.168.1.119'),
(23, '设置', 5, 1, NULL, 212, 317, NULL, NULL, NULL, '{\"packName\":\"com.jancar.settingss\",\"className\":\"com.jancar.settings.view.activity.MainActivity\"}', '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u8bbe\\\\u7f6e\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":237,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/ae\\/c411e7147141d149176ca3ea2e27ab.png\",\"width\":212,\"height\":317,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:32:57', '192.168.1.119'),
(24, '外部输入', 5, 1, NULL, 212, 317, NULL, NULL, NULL, '{\"packName\":\"com.jancar.avin\",\"className\":\"com.jancar.avin.MainActivity\"}', '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u5916\\\\u90e8\\\\u8f93\\\\u5165\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":237,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/01\\/7c0cd91527fd7063c17dd700c2a82b.png\",\"width\":212,\"height\":317,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:32:57', '192.168.1.119'),
(25, '应用', 5, 1, NULL, 212, 317, NULL, NULL, NULL, '{\"packName\":\"com.android.launcher3\",\"className\":\"com.android.launcher3.Launcher\"}', '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u5e94\\\\u7528\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":237,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/4f\\/784d6be45e2470d41356cc8cb93cd1.png\",\"width\":212,\"height\":317,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:32:57', '192.168.1.119'),
(26, '收音机', 7, 1, NULL, 226, 360, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u6536\\\\u97f3\\\\u673a\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":300,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/98\\/16365f287b4bb1088fb5a6e87422bb.png\",\"width\":226,\"height\":360,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:51:42', '192.168.1.119'),
(27, '导航', 7, 1, NULL, 226, 360, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u5bfc\\\\u822a\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":300,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/16\\/c19411b6378fc65cf9c8748ffdd38e.png\",\"width\":226,\"height\":360,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:51:42', '192.168.1.119'),
(28, '手机互连', 7, 1, NULL, 224, 178, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u624b\\\\u673a\\\\u4e92\\\\u8fde\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":118,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/2a\\/0e68f37f5dc43997b59fc60cc6012c.png\",\"width\":224,\"height\":178,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:51:42', '192.168.1.119'),
(29, '蓝牙音乐', 7, 1, NULL, 224, 178, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u84dd\\\\u7259\\\\u97f3\\\\u4e50\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":118,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/ad\\/5a1fcdacaa57c76347a835866af15e.png\",\"width\":224,\"height\":178,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:51:42', '192.168.1.119'),
(30, '电话', 7, 1, NULL, 224, 178, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u7535\\\\u8bdd\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":118,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c9\\/b7850a33071914ceaa2cade7a9e947.png\",\"width\":224,\"height\":178,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:51:42', '192.168.1.119'),
(31, '音乐', 7, 1, NULL, 224, 178, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u97f3\\\\u4e50\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":118,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/a8\\/08edecfa47a2d2bb59d09fa5878b68.png\",\"width\":224,\"height\":178,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:51:42', '192.168.1.119'),
(32, '视频', 7, 1, NULL, 226, 360, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u89c6\\\\u9891\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":300,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/84\\/2b41d38f193de15aee341fe5565a86.png\",\"width\":226,\"height\":360,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:51:42', '192.168.1.119'),
(33, '图片', 7, 1, NULL, 226, 360, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u56fe\\\\u7247\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":300,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/41\\/d435ffe832ac5ae52f17e225b9461e.png\",\"width\":226,\"height\":360,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:51:42', '192.168.1.119'),
(34, '设置', 7, 1, NULL, 224, 178, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u8bbe\\\\u7f6e\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":118,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/7a\\/85cfe4d088c35e3825fe2b00c664c2.png\",\"width\":224,\"height\":178,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:51:42', '192.168.1.119'),
(35, '应用', 7, 1, NULL, 224, 178, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u5e94\\\\u7528\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":118,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/38\\/ec79cc2aec48002bbc53a3b5a67f5d.png\",\"width\":224,\"height\":178,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:51:42', '192.168.1.119'),
(36, '外部输入', 7, 1, NULL, 224, 178, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u5916\\\\u90e8\\\\u8f93\\\\u5165\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":118,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d6\\/4c1e0501ce6c02329fbc8f6c1ae4ff.png\",\"width\":224,\"height\":178,\"left\":0,\"top\":0,\"right\":0,\"bottom\":0}]', NULL, '', 1, 6, '2019-05-18 05:51:42', '192.168.1.119'),
(37, 'AP4日期控件', 12, 4, 0, 262, 240, '', '', '', '', '[{\"text\":null,\"textSize\":64,\"textLines\":0,\"textColor\":\"\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":120,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100101\\\"}\",\"send\":null},{\"text\":null,\"textSize\":26,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":120,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100102\\\"}\",\"send\":null},{\"text\":null,\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":20,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100103\\\"}\",\"send\":null},{\"text\":null,\"textSize\":12,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":55,\"top\":15,\"right\":55,\"bottom\":210,\"gravity\":1,\"recv\":\"{\\\"recvId\\\":\\\"100104\\\"}\",\"send\":null}]', '[{\"width\":262,\"height\":240,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/5f\\/1f811aa95f638f767988a00f01394e.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 01:17:59', '192.168.1.119'),
(38, 'AP4媒体信息', 12, 5, 0, 650, 236, '', '#00000000', '', '{\"packName\":\"com.jancar.radios\"}', '[{\"text\":null,\"textSize\":80,\"textLines\":0,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":200,\"top\":0,\"right\":0,\"bottom\":76,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100212\\\"}\",\"send\":null},{\"text\":null,\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":325,\"top\":140,\"right\":225,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100211\\\"}\",\"send\":null},{\"text\":null,\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":400,\"top\":140,\"right\":100,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100213\\\"}\",\"send\":null}]', '[{\"width\":650,\"height\":236,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/57\\/129fe006e2a381c9bf8f43897f8ad0.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null},{\"width\":146,\"height\":142,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/45\\/5d5e79b1c0010bcd4c103c85e36282.png\",\"filterColor\":\"\",\"left\":40,\"top\":47,\"right\":464,\"bottom\":47,\"scaleType\":0,\"recv\":null,\"send\":null},{\"width\":50,\"height\":50,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c7\\/6ff935309442c59e855aad3e8b4c4f.png\",\"filterColor\":\"\",\"left\":250,\"top\":160,\"right\":350,\"bottom\":26,\"scaleType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200302\\\"}\"},{\"width\":50,\"height\":50,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/cb\\/e06128f78e6c10c067d0c433ea910d.png\",\"filterColor\":\"\",\"left\":550,\"top\":160,\"right\":50,\"bottom\":26,\"scaleType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200303\\\"}\"}]', '[]', '', 1, 6, '2019-05-22 07:37:56', '192.168.1.119'),
(39, '导航', 12, 1, 0, 112, 162, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5bfc\\u822a\\\"}\",\"textSize\":22,\"textLines\":0,\"textColor\":\"\",\"textFilter\":\"\",\"left\":0,\"top\":112,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":112,\"height\":112,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/25\\/4df8e5261c6cf929c55282982930ff.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-18 06:06:18', '192.168.1.119'),
(40, '收音机', 12, 1, NULL, 112, 162, NULL, NULL, NULL, NULL, '[{\"textSize\":22,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u6536\\\\u97f3\\\\u673a\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":112,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/30\\/68a49cd794ad8de5b772758f22a042.png\",\"width\":112,\"height\":112,\"left\":0,\"top\":0,\"right\":0,\"bottom\":50}]', NULL, '', 1, 6, '2019-05-18 06:06:18', '192.168.1.119'),
(41, '应用', 12, 1, 0, 112, 162, '', '', '', '{\"packName\":\"com.android.launcher3\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5e94\\u7528\\\"}\",\"textSize\":22,\"textLines\":0,\"textColor\":\"\",\"textFilter\":\"\",\"left\":0,\"top\":112,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":112,\"height\":112,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/8c\\/c7d7cb1215ec18e70d53da4767bd37.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-23 06:55:41', '192.168.1.119'),
(42, '拔号', 12, 1, NULL, 112, 162, NULL, NULL, NULL, NULL, '[{\"textSize\":22,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u62d4\\\\u53f7\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":112,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/87\\/9d9fc1e1e0eace983aab1963f9c16a.png\",\"width\":112,\"height\":112,\"left\":0,\"top\":0,\"right\":0,\"bottom\":50}]', NULL, '', 1, 6, '2019-05-18 06:06:18', '192.168.1.119'),
(43, '蓝牙音乐', 12, 1, NULL, 112, 162, NULL, NULL, NULL, NULL, '[{\"textSize\":22,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u84dd\\\\u7259\\\\u97f3\\\\u4e50\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":112,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/4e\\/bc1a24ead403511fd0379e8153ee4a.png\",\"width\":112,\"height\":112,\"left\":0,\"top\":0,\"right\":0,\"bottom\":50}]', NULL, '蓝牙音乐', 1, 6, '2019-05-18 06:06:18', '192.168.1.119'),
(46, 'AP5日期控件', 13, 4, 0, 380, 500, '', '', '', '', '[{\"text\":null,\"textSize\":84,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":85,\"top\":120,\"right\":85,\"bottom\":280,\"gravity\":1,\"recv\":\"{\\\"recvId\\\":\\\"100101\\\"}\",\"send\":null},{\"text\":null,\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100103\\\"}\",\"send\":null},{\"text\":null,\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":250,\"right\":0,\"bottom\":120,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100102\\\"}\",\"send\":null},{\"text\":null,\"textSize\":14,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":85,\"top\":120,\"right\":85,\"bottom\":330,\"gravity\":1,\"recv\":\"{\\\"recvId\\\":\\\"100104\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-05-27 09:42:01', '192.168.1.119'),
(47, '收音机', 13, 5, 0, 120, 202, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6536\\u97f3\\u673a\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"\",\"textFilter\":\"\",\"left\":0,\"top\":102,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":120,\"height\":102,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/46\\/c79fe3d145713998afe5865c61f99f.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":100,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 01:18:32', '192.168.1.119'),
(48, '导航', 13, 6, NULL, 120, 202, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u5bfc\\\\u822a\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":102,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/43\\/486861fd73071b856bbb1447ba3267.png\",\"width\":120,\"height\":102,\"left\":0,\"top\":0,\"right\":0,\"bottom\":100}]', NULL, '', 1, 6, '2019-05-21 01:21:17', '192.168.1.119'),
(49, '电话', 13, 6, NULL, 120, 202, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u7535\\\\u8bdd\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":102,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/94\\/b44dd5837053b7d4f4bb1edcf088ed.png\",\"width\":120,\"height\":102,\"left\":0,\"top\":0,\"right\":0,\"bottom\":100}]', NULL, '', 1, 6, '2019-05-21 01:21:17', '192.168.1.119'),
(50, '手机互联', 13, 6, NULL, 120, 202, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u624b\\\\u673a\\\\u4e92\\\\u8054\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":102,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/fb\\/64a713876910c0db1ac700fef4014f.png\",\"width\":120,\"height\":102,\"left\":0,\"top\":0,\"right\":0,\"bottom\":100}]', NULL, '', 1, 6, '2019-05-21 01:21:17', '192.168.1.119'),
(51, '蓝牙音乐', 13, 6, NULL, 120, 202, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u84dd\\\\u7259\\\\u97f3\\\\u4e50\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":102,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/18\\/1f189d48cdd19534a11a2b8b82e6c7.png\",\"width\":120,\"height\":102,\"left\":0,\"top\":0,\"right\":0,\"bottom\":100}]', NULL, '', 1, 6, '2019-05-21 01:21:17', '192.168.1.119'),
(52, '视频', 13, 6, NULL, 120, 202, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u89c6\\\\u9891\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":102,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/df\\/26e5dd51ff3083c69dd564340c9be7.png\",\"width\":120,\"height\":102,\"left\":0,\"top\":0,\"right\":0,\"bottom\":100}]', NULL, '', 1, 6, '2019-05-21 01:21:17', '192.168.1.119'),
(53, '音乐', 13, 6, NULL, 120, 202, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u97f3\\\\u4e50\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":102,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/3b\\/61e5ac2c0600022bd032493591ff73.png\",\"width\":120,\"height\":102,\"left\":0,\"top\":0,\"right\":0,\"bottom\":100}]', NULL, '', 1, 6, '2019-05-21 01:21:17', '192.168.1.119'),
(54, '设置', 13, 6, NULL, 120, 202, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u8bbe\\\\u7f6e\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":102,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/1a\\/873420ae313b8241fb4c81478f6a8b.png\",\"width\":120,\"height\":102,\"left\":0,\"top\":0,\"right\":0,\"bottom\":100}]', NULL, '', 1, 6, '2019-05-21 01:21:17', '192.168.1.119'),
(55, '处部输入', 13, 6, NULL, 120, 202, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u5904\\\\u90e8\\\\u8f93\\\\u5165\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":102,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/31\\/922eb99e24bce5aae6ebedcf7426e0.png\",\"width\":120,\"height\":102,\"left\":0,\"top\":0,\"right\":0,\"bottom\":100}]', NULL, '', 1, 6, '2019-05-21 01:21:17', '192.168.1.119'),
(56, '应用', 13, 6, NULL, 120, 202, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u5e94\\\\u7528\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":102,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/29\\/d48f76b6ebd6fcd1a4b1d993abbaa9.png\",\"width\":120,\"height\":102,\"left\":0,\"top\":0,\"right\":0,\"bottom\":100}]', NULL, '', 1, 6, '2019-05-21 01:21:17', '192.168.1.119'),
(57, '图片', 13, 6, NULL, 120, 202, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u56fe\\\\u7247\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":102,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f0\\/ef35a722458f52b8c430e4abd055d5.png\",\"width\":120,\"height\":102,\"left\":0,\"top\":0,\"right\":0,\"bottom\":100}]', NULL, '', 1, 6, '2019-05-21 01:21:17', '192.168.1.119'),
(66, 'AP7日期控件', 18, 4, 0, 336, 100, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"18:00\\\"}\",\"textSize\":64,\"textLines\":0,\"textColor\":\"\",\"textFilter\":\"\",\"left\":10,\"top\":0,\"right\":150,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100101\\\"}\",\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"2018-01-01\\\"}\",\"textSize\":22,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":204,\"top\":50,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100102\\\"}\",\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u661f\\u671f\\u4e00\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":228,\"top\":0,\"right\":0,\"bottom\":36,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100103\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-05-22 01:19:16', '192.168.1.119'),
(67, '电话', 14, 1, 0, 105, 155, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u7535\\u8bdd\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"\",\"textFilter\":\"\",\"left\":0,\"top\":105,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":105,\"height\":105,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/e9\\/26949dd5843dcdb9bd9893caf3fd2c.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-18 06:24:08', '192.168.1.119'),
(68, '视频', 14, 1, NULL, 105, 155, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u89c6\\\\u9891\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":105,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/90\\/88f19c9582ce850cd11933b8a1208d.png\",\"width\":105,\"height\":105,\"left\":0,\"top\":0,\"right\":0,\"bottom\":50}]', NULL, '', 1, 6, '2019-05-18 06:21:34', '192.168.1.119'),
(69, '音乐', 14, 1, NULL, 105, 155, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u97f3\\\\u4e50\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":105,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/af\\/0ffa4e380deeaf581bd4738ea26a1e.png\",\"width\":105,\"height\":105,\"left\":0,\"top\":0,\"right\":0,\"bottom\":50}]', NULL, '', 1, 6, '2019-05-18 06:21:34', '192.168.1.119'),
(70, '图片', 14, 1, NULL, 105, 155, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u56fe\\\\u7247\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":105,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/23\\/a05ed14f5b2d0fec605e4f38d4efe5.png\",\"width\":105,\"height\":105,\"left\":0,\"top\":0,\"right\":0,\"bottom\":50}]', NULL, '', 1, 6, '2019-05-18 06:21:34', '192.168.1.119'),
(71, '设置', 14, 1, NULL, 105, 155, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u8bbe\\\\u7f6e\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":105,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/62\\/5beb92cb715f81447ddf02d1e97a0c.png\",\"width\":105,\"height\":105,\"left\":0,\"top\":0,\"right\":0,\"bottom\":50}]', NULL, '', 1, 6, '2019-05-18 06:21:34', '192.168.1.119'),
(72, 'AVIN', 14, 1, NULL, 105, 155, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"AVIN\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":105,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/bd\\/7dbae4c9606e19425ee24105c97847.png\",\"width\":105,\"height\":105,\"left\":0,\"top\":0,\"right\":0,\"bottom\":50}]', NULL, '', 1, 6, '2019-05-18 06:21:34', '192.168.1.119'),
(73, '收音机', 14, 1, NULL, 105, 155, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u6536\\\\u97f3\\\\u673a\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":105,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/69\\/e5c58fca385c9d67af06ebc77c8c0c.png\",\"width\":105,\"height\":105,\"left\":0,\"top\":0,\"right\":0,\"bottom\":50}]', NULL, '', 1, 6, '2019-05-18 06:21:34', '192.168.1.119'),
(74, '导航', 14, 1, NULL, 105, 155, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u5bfc\\\\u822a\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":105,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/a4\\/0f78d7a2419cadb4f31b77c8f7fb42.png\",\"width\":105,\"height\":105,\"left\":0,\"top\":0,\"right\":0,\"bottom\":50}]', NULL, '', 1, 6, '2019-05-18 06:21:34', '192.168.1.119'),
(75, '应用', 14, 1, NULL, 105, 155, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u5e94\\\\u7528\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":105,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/05\\/a16741c726afed1917c8e1b02babf5.png\",\"width\":105,\"height\":105,\"left\":0,\"top\":0,\"right\":0,\"bottom\":50}]', NULL, '', 1, 6, '2019-05-18 06:21:34', '192.168.1.119'),
(76, '手机互联', 14, 1, NULL, 105, 155, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u624b\\\\u673a\\\\u4e92\\\\u8054\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":105,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f5\\/e174af144e1336fac615000c8d9faf.png\",\"width\":105,\"height\":105,\"left\":0,\"top\":0,\"right\":0,\"bottom\":50}]', NULL, '', 1, 6, '2019-05-18 06:21:34', '192.168.1.119'),
(77, '蓝牙音乐', 14, 1, NULL, 105, 155, NULL, NULL, NULL, NULL, '[{\"textSize\":24,\"textLines\":2,\"text\":\"{\\\"zh_rCN\\\":\\\"\\\\u84dd\\\\u7259\\\\u97f3\\\\u4e50\\\"}\",\"textColor\":\"\",\"left\":0,\"top\":105,\"right\":0,\"bottom\":0,\"gravity\":0}]', '[{\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/07\\/f5f1be53d377245b0a35f5d3a8da13.png\",\"width\":105,\"height\":105,\"left\":0,\"top\":0,\"right\":0,\"bottom\":50}]', NULL, '', 1, 6, '2019-05-18 06:21:34', '192.168.1.119'),
(78, 'Launcher页面导航条', 5, 7, 0, 1024, 16, '', '', '{\"recvId\":\"400301\",\"recvContent\":\"0000\"}', '', '[{\"text\":null,\"textSize\":24,\"textLines\":2,\"textLines\":0,\"textColor\":\"\",\"textFilter\":\"\",\"left\":0,\"top\":237,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":16,\"height\":16,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/40\\/841f8b970233545b18c849c6908a49.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null},{\"width\":16,\"height\":16,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/a9\\/107fb29ec2972ec649ca6a57fbbaf5.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 01:15:51', '192.168.1.119'),
(118, '收音机频率', 5, 3, 0, 212, 50, '', '', '', '', '[{\"text\":null,\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100212\\\"}\",\"send\":null}]', '[{\"width\":473,\"height\":44,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/e9\\/aba6b567ce5857b83583b611751a79.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 01:25:58', '192.168.1.119'),
(119, '音乐歌名', 18, 1, 0, 240, 30, '', '', '', '', '[{\"text\":null,\"textSize\":20,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100222\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-05-22 03:10:35', '192.168.1.119'),
(120, '音乐', 5, 1, 0, 124, 124, '', '', '', '{\"packName\":\"com.jancar.player.music\"}', '[]', '[{\"width\":124,\"height\":124,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/1a\\/a3514a132e979810e3c33a24ce83ea.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 01:24:28', '192.168.1.119'),
(121, '音乐专辑', 23, 1, 0, 480, 50, '', '', '', '', '[{\"text\":null,\"textSize\":30,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":60,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":\"{\\\"recvId\\\":\\\"100224\\\"}\",\"send\":null}]', '[{\"width\":50,\"height\":50,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f0\\/77034a279668a43356781cef8263c7.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":430,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-28 08:07:07', '192.168.1.119'),
(122, '音乐歌手', 23, 1, 0, 480, 50, '', '', '', '', '[{\"text\":null,\"textSize\":30,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":60,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":\"{\\\"recvId\\\":\\\"100223\\\"}\",\"send\":null}]', '[{\"width\":50,\"height\":50,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f6\\/73b78d3f31f96802fbbd18a7ecf918.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":430,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-28 08:06:59', '192.168.1.119'),
(123, '音乐播放地址', 5, 1, 0, 1024, 20, '', '', '', '', '[{\"text\":null,\"textSize\":12,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100221\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-05-21 01:23:33', '192.168.1.119'),
(124, '音乐进度条', 18, 8, 0, 232, 30, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"00:00:00\\\"}\",\"textSize\":16,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":10,\"right\":0,\"bottom\":0,\"gravity\":1,\"recv\":null,\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"00:00:00\\\"}\",\"textSize\":16,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":10,\"right\":0,\"bottom\":0,\"gravity\":2,\"recv\":null,\"send\":null}]', '[{\"width\":232,\"height\":10,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/0b\\/766c3d32843788cc71f14fcca47ea3.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":232,\"height\":10,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/28\\/7effe7e601c2666ed507660acae66d.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":1,\"height\":1,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c4\\/c07b5b1da14c19ea0bf0d7ca186190.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-29 03:50:32', '192.168.1.119'),
(125, '收音机AMFM', 5, 2, 0, 55, 32, '', '', '{\"recvId\":\"100211\",\"visibleContent\":\"AM#FM\"}', '', '[]', '[{\"width\":55,\"height\":32,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/ec\\/517d877783a69c79e61e2e28aab344.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":55,\"height\":32,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/a8\\/e2f8655dd0fba7fc24a5c070e58fe8.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-30 03:54:06', '192.168.1.119'),
(126, '正在播放媒体图片', 18, 1, 0, 80, 80, '', '', '', '', '[]', '[{\"width\":80,\"height\":80,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/1a\\/a3514a132e979810e3c33a24ce83ea.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":\"{\\\"recvId\\\":\\\"100227\\\"}\",\"send\":null}]', '[]', '', 1, 6, '2019-05-22 09:34:00', '192.168.1.119'),
(127, '下一曲', 5, 1, 0, 50, 50, '', '#FF0000FF', '', '{\"eventId\":\"200303\"}', '[]', '[{\"width\":50,\"height\":50,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/cb\\/e06128f78e6c10c067d0c433ea910d.png\",\"filterColor\":\"#0000FF\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-22 09:51:00', '192.168.1.119'),
(128, '上一曲', 5, 1, 0, 50, 50, '', '#FFFF0000', '', '{\"eventId\":\"200302\"}', '[]', '[{\"width\":50,\"height\":50,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c7\\/6ff935309442c59e855aad3e8b4c4f.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-22 09:49:24', '192.168.1.119'),
(129, '收音机', 5, 1, 0, 112, 112, '', '', '', '{\"packName\":\"com.jancar.radios\"}', '[]', '[{\"width\":112,\"height\":112,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/30\\/68a49cd794ad8de5b772758f22a042.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 03:00:11', '192.168.1.119'),
(130, '收音机KZMZ', 5, 2, 0, 75, 32, '', '', '{\"recvId\":\"100213\",\"visibleContent\":\"KH#MH\"}', '', '[]', '[{\"width\":75,\"height\":32,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/86\\/e15dcd630643121ca2efb2858fc90c.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":75,\"height\":32,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/4c\\/8645c08ae50bdfc50b3809e8aa8fbd.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-30 03:54:46', '192.168.1.119'),
(131, '收音机频道', 5, 1, 0, 120, 50, '', '', '', '', '[{\"text\":null,\"textSize\":40,\"textLines\":1,\"textColor\":\"#FF0000\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100211\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-05-21 06:22:40', '192.168.1.119'),
(132, '收间机KZMZ', 5, 1, 0, 120, 50, '', '', '', '', '[{\"text\":null,\"textSize\":40,\"textLines\":1,\"textColor\":\"#FFFF00\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100213\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-05-21 07:20:28', '192.168.1.119'),
(133, '收音机频率', 5, 1, 0, 240, 100, '', '', '', '', '[{\"text\":null,\"textSize\":80,\"textLines\":1,\"textColor\":\"#FF00FF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100212\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-05-21 07:19:54', '192.168.1.119'),
(134, '视频', 18, 1, 0, 110, 160, '', '', '', '{\"packName\":\"com.flyzebra.video\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u89c6\\u9891\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":110,\"height\":110,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d5\\/80c0fbe26d9276deb0a7dc74bc6bc1.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-05 00:41:12', '192.168.1.119'),
(136, '图片', 18, 1, 0, 110, 160, '', '', '', '{\"packName\":\"com.flyzebra.photo\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u56fe\\u7247\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":110,\"height\":110,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/ff\\/42059b7b14aeeec5e65a76755e7375.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-04 01:12:19', '192.168.1.119'),
(137, '音乐', 18, 1, 0, 110, 160, '', '', '', '{\"packName\":\"com.flyzebra.music\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u97f3\\u4e50\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":110,\"height\":110,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/75\\/77099ad245546859d2209d7a5b6227.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-28 07:05:14', '192.168.1.119'),
(138, '导航', 18, 1, 0, 110, 160, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5bfc\\u822a\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":110,\"height\":110,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/29\\/346f500739e739f06954f02b53489c.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 09:48:14', '192.168.1.119'),
(139, '手机互联', 18, 1, 0, 110, 160, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u624b\\u673a\\u4e92\\u8054\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":110,\"height\":110,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/60\\/9aa4021e6eb43f9185d13d7d12d546.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 09:48:34', '192.168.1.119'),
(140, '设置', 18, 1, 0, 110, 160, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u8bbe\\u7f6e\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":110,\"height\":110,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/9d\\/b2f85c298d57c178d76b89daa3acd5.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 09:47:50', '192.168.1.119'),
(141, '蓝牙音乐', 18, 1, 0, 110, 160, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u84dd\\u7259\\u97f3\\u4e50\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":110,\"height\":110,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/2a\\/62e21e9e349cce3bc192b200a7f6fc.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 09:33:50', '192.168.1.119'),
(142, '电话', 18, 1, 0, 110, 160, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u7535\\u8bdd\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":110,\"height\":110,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/7b\\/1e3abafda47b8dc37f22d634159afb.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 09:48:29', '192.168.1.119'),
(143, '应用', 18, 1, 0, 110, 160, '', '', '', '{\"packName\":\"com.android.launcher3\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5e94\\u7528\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":110,\"height\":110,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/94\\/1166d2d0c4f4206b020a1db00e1ac7.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-28 09:17:24', '192.168.1.119'),
(144, '收音机', 18, 1, 0, 110, 160, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6536\\u97f3\\u673a\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":110,\"height\":110,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/03\\/e9d3b14511d423422f32b8e103f590.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 09:48:19', '192.168.1.119'),
(145, '媒体信息背景', 18, 1, 0, 779, 125, '', '', '', '', '[]', '[{\"width\":779,\"height\":125,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c3\\/ce5c591784862c392846caf5eeaff7.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 10:03:41', '192.168.1.119'),
(146, '音乐进度条', 5, 8, 0, 600, 30, '', '', '', '', '[{\"text\":null,\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null},{\"text\":null,\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":30,\"height\":30,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/29\\/c02cf2f567e013837e4da21b01e29a.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null},{\"width\":834,\"height\":30,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/53\\/b885c882235c7f8edc7955ee6d6f62.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null},{\"width\":834,\"height\":30,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/3a\\/ae054b61ba605d138e2441fba386af.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 01:22:59', '192.168.1.119'),
(147, '音乐歌名', 23, 1, 0, 300, 30, '', '', '', '', '[{\"text\":null,\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":1,\"recv\":\"{\\\"recvId\\\":\\\"100222\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-05-28 07:43:13', '192.168.1.119'),
(148, 'AP6日期控件', 14, 4, 0, 406, 272, '', '', '', '', '[{\"text\":null,\"textSize\":80,\"textLines\":0,\"textColor\":\"\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":136,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100101\\\"}\",\"send\":null},{\"text\":null,\"textSize\":36,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":136,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100102\\\"}\",\"send\":null},{\"text\":null,\"textSize\":36,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":20,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100103\\\"}\",\"send\":null}]', '[{\"width\":406,\"height\":272,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/15\\/22a1b70b85f3dd21b0f9dafbe8f6ac.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-21 01:16:42', '192.168.1.119'),
(149, '日期控件', 19, 5, 0, 0, 0, '', '', '', '', '[]', '[]', '[]', '', 1, 6, '2019-05-22 01:39:25', '192.168.1.119');
INSERT INTO `fly_cell` (`cellId`, `description`, `themeId`, `celltypeId`, `resId`, `width`, `height`, `backColor`, `filterColor`, `recv`, `send`, `texts`, `images`, `pages`, `remark`, `status`, `userid`, `uptime`, `ip`) VALUES
(150, 'AP8日期控件', 19, 4, 0, 308, 164, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"18:00\\\"}\",\"textSize\":80,\"textLines\":0,\"textColor\":\"\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":20,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100101\\\"}\",\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"2019-01-01\\\"}\",\"textSize\":26,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":10,\"top\":104,\"right\":154,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100102\\\"}\",\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u661f\\u671f\\u65e5\\\"}\",\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":154,\"top\":104,\"right\":10,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100103\\\"}\",\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u4e0a\\u5348\\\"}\",\"textSize\":16,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":18,\"top\":16,\"right\":20,\"bottom\":124,\"gravity\":1,\"recv\":\"{\\\"recvId\\\":\\\"100104\\\"}\",\"send\":null}]', '[{\"width\":308,\"height\":164,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/ea\\/1e050ec7ac3f8bd849039db70660be.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-22 02:11:50', '192.168.1.119'),
(151, '蓝牙电话', 19, 1, 0, 124, 174, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u84dd\\u7259\\u7535\\u8bdd\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":124,\"height\":124,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/a1\\/b158d0605ae2b728f55484d10988ae.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-22 01:53:44', '192.168.1.119'),
(152, '收音机', 19, 1, 0, 124, 174, '', '', '', '{\"packName\":\"com.jancar.radios\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6536\\u97f3\\u673a\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":124,\"height\":124,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/af\\/5a5360c22fe289a05b8b885592f713.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-22 05:55:49', '192.168.1.119'),
(153, '音乐', 19, 1, 0, 124, 174, '', '', '', '{\"packName\":\"com.jancar.player.music\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u97f3\\u4e50\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":124,\"height\":124,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/28\\/e2a1fe3f3b36653d2d2f8f0ee9993d.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-22 03:09:00', '192.168.1.119'),
(154, '应用', 19, 1, 0, 124, 174, '', '', '', '{\"packName\":\"com.android.launcher3\"}', '[{\"text\":null,\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":124,\"height\":124,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/40\\/a13e28cc672b7ab55bd1e41c174706.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-22 03:04:20', '192.168.1.119'),
(155, '导航', 19, 1, 0, 124, 174, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5bfc\\u822a\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":110,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":124,\"height\":124,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c5\\/7b15002415f6168ea4cc2f2b64cd24.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":50,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-22 01:54:58', '192.168.1.119'),
(156, '收音机信息', 19, 5, 0, 452, 190, '', '#00000000', '{\"recvId\":\"100201\",\"visibleContent\":\"02\"}', '{\"packName\":\"com.jancar.radios\"}', '[{\"text\":null,\"textSize\":56,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":72,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100212\\\"}\",\"send\":null},{\"text\":null,\"textSize\":32,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":250,\"top\":50,\"right\":0,\"bottom\":0,\"gravity\":1,\"recv\":\"{\\\"recvId\\\":\\\"100213\\\"}\",\"send\":null}]', '[{\"width\":452,\"height\":164,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/6d\\/91936409b655672a99fa721c884e2d.png\",\"filterColor\":\"\",\"left\":0,\"top\":26,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null},{\"width\":86,\"height\":82,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/dc\\/c3b48629923ae7f7c21e9c03bef994.png\",\"filterColor\":\"\",\"left\":336,\"top\":0,\"right\":30,\"bottom\":108,\"scaleType\":0,\"recv\":null,\"send\":null},{\"width\":54,\"height\":54,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/56\\/805e771ce2a140c15f2e60ecddfcbe.png\",\"filterColor\":\"#7FFFFFFF\",\"left\":48,\"top\":106,\"right\":350,\"bottom\":30,\"scaleType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200302\\\"}\"},{\"width\":54,\"height\":54,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/90\\/b0dc0c289258fa9c10d232e629c62f.png\",\"filterColor\":\"#7FFFFFFF\",\"left\":350,\"top\":106,\"right\":48,\"bottom\":30,\"scaleType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200303\\\"}\"}]', '[]', '', 1, 6, '2019-05-22 06:36:46', '192.168.1.119'),
(157, '未知源信息', 19, 5, 0, 452, 190, '', '', '{\"recvId\":\"100201\",\"disVisibleContent\":\"02#03\"}', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u672a\\u77e5\\u64ad\\u653e\\u6e90\\\"}\",\"textSize\":40,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":26,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":452,\"height\":164,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/6d\\/91936409b655672a99fa721c884e2d.png\",\"filterColor\":\"\",\"left\":0,\"top\":26,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-22 06:32:46', '192.168.1.119'),
(158, '音乐播放暂停', 19, 5, 0, 34, 34, '', '', '{\"recvId\":\"100201\",\"visibleContent\":\"03\"}', '', '[]', '[{\"width\":34,\"height\":34,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f0\\/73507b36cd8e3af7bc193423f2fa4f.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":\"{\\\"recvId\\\":\\\"100225\\\",\\\"visibleContent\\\":\\\"01\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"200301\\\"}\"},{\"width\":34,\"height\":34,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d3\\/225fcfed819ddd05ad6167165753be.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":\"{\\\"recvId\\\":\\\"100225\\\",\\\"disVisibleContent\\\":\\\"01\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"200301\\\"}\"}]', '[]', '', 0, 6, '2019-05-22 07:09:33', '192.168.1.119'),
(159, '音乐信息', 19, 5, 0, 452, 190, '', '#00000000', '{\"recvId\":\"100201\",\"visibleContent\":\"03\"}', '', '[{\"text\":null,\"textSize\":20,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":10,\"top\":100,\"right\":130,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100222\\\"}\",\"send\":null}]', '[{\"width\":452,\"height\":164,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/85\\/c724f8327cbbaae2b9ce1656ad3407.png\",\"filterColor\":\"\",\"left\":0,\"top\":26,\"right\":0,\"bottom\":0,\"scaleType\":0,\"recv\":null,\"send\":null},{\"width\":126,\"height\":126,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/80\\/a93e1472ded8ae4b041d7da44c825f.png\",\"filterColor\":\"\",\"left\":326,\"top\":0,\"right\":20,\"bottom\":88,\"scaleType\":0,\"recv\":null,\"send\":null},{\"width\":54,\"height\":54,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/56\\/805e771ce2a140c15f2e60ecddfcbe.png\",\"filterColor\":\"#7FFFFFFF\",\"left\":40,\"top\":56,\"right\":358,\"bottom\":80,\"scaleType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200302\\\"}\"},{\"width\":54,\"height\":54,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/90\\/b0dc0c289258fa9c10d232e629c62f.png\",\"filterColor\":\"#7FFFFFFF\",\"left\":240,\"top\":56,\"right\":158,\"bottom\":80,\"scaleType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200303\\\"}\"},{\"width\":106,\"height\":106,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c4\\/c07b5b1da14c19ea0bf0d7ca186190.png\",\"filterColor\":\"\",\"left\":332,\"top\":8,\"right\":28,\"bottom\":97,\"scaleType\":0,\"recv\":\"{\\\"recvId\\\":\\\"100227\\\"}\",\"send\":null},{\"width\":34,\"height\":34,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f0\\/73507b36cd8e3af7bc193423f2fa4f.png\",\"filterColor\":\"\",\"left\":150,\"top\":68,\"right\":270,\"bottom\":90,\"scaleType\":3,\"recv\":\"{\\\"recvId\\\":\\\"100225\\\",\\\"visibleContent\\\":\\\"01\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"200301\\\"}\"},{\"width\":34,\"height\":34,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d3\\/225fcfed819ddd05ad6167165753be.png\",\"filterColor\":\"\",\"left\":150,\"top\":68,\"right\":270,\"bottom\":90,\"scaleType\":3,\"recv\":\"{\\\"recvId\\\":\\\"100225\\\",\\\"disVisibleContent\\\":\\\"01\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"200301\\\"}\"}]', '[]', '', 1, 6, '2019-05-22 07:08:58', '192.168.1.119'),
(160, '圆形播放媒体图片', 18, 1, 0, 80, 80, '', '', '', '', '[]', '[{\"width\":80,\"height\":80,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/b9\\/bca675740f493d6a3d5313b617ecf6.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":1,\"recv\":\"{\\\"recvId\\\":\\\"100227\\\"}\",\"send\":null}]', '[]', '', 1, 6, '2019-05-22 09:37:28', '192.168.1.119'),
(161, '六边形播放媒体图片', 18, 1, 0, 160, 160, '', '', '', '', '[]', '[{\"width\":160,\"height\":160,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/7a\\/e370a006ac459b6964ae30892bae4d.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":2,\"recv\":\"{\\\"recvId\\\":\\\"100227\\\"}\",\"send\":null}]', '[]', '', 1, 6, '2019-05-22 09:40:37', '192.168.1.119'),
(162, '', 12, 1, 0, 1024, 140, '', '', '', '', '[]', '[{\"width\":1024,\"height\":140,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/70\\/a7c942e65386c15a7dbebdd3cd15c2.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-23 06:05:22', '192.168.1.119'),
(163, 'AP9轮播图片', 5, 42, 0, 1024, 600, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5e94\\u7528\\\"}\",\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":250,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5bfc\\u822a\\\"}\",\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":250,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6536\\u97f3\\u673a\\\"}\",\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":250,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u7535\\u8bdd\\\"}\",\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":250,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u624b\\u673a\\u4e92\\u8fde\\\"}\",\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":250,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":160,\"height\":280,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/9d\\/07cdec5f2664911d35978a7b0b6078.png\",\"filterColor\":\"#3F0000FF\",\"left\":82,\"top\":160,\"right\":782,\"bottom\":160,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"packName\\\":\\\"com.android.launcher3\\\"}\"},{\"width\":200,\"height\":350,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/09\\/53c1a9298d018b9e70dde834dd036d.png\",\"filterColor\":\"#3F0000FF\",\"left\":220,\"top\":125,\"right\":604,\"bottom\":125,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"packName\\\":\\\"com.autonavi.amapauto\\\"}\"},{\"width\":234,\"height\":402,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/08\\/899a29d5dea67f5dcf5db577e3df1e.png\",\"filterColor\":\"#3F0000FF\",\"left\":395,\"top\":99,\"right\":395,\"bottom\":109,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"packName\\\":\\\"com.jancar.radios\\\"}\"},{\"width\":200,\"height\":350,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/31\\/39af8db9ef02d23a0f3f715a809d64.png\",\"filterColor\":\"#3F0000FF\",\"left\":604,\"top\":125,\"right\":220,\"bottom\":125,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"packName\\\":\\\"com.jancar.bluetooth.phone\\\"}\"},{\"width\":160,\"height\":280,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/69\\/a12c39f4d923fc0a0aa9d0a56edab8.png\",\"filterColor\":\"#3F0000FF\",\"left\":782,\"top\":160,\"right\":82,\"bottom\":160,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"packName\\\":\\\"net.easyconn\\\"}\"}]', '[]', '', 1, 6, '2019-06-01 08:01:44', '192.168.1.119'),
(167, '收音机', 6, 1, 0, 106, 168, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6536\\u97f3\\u673a\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":106,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":106,\"height\":108,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/97\\/97ab4d5164c17f8ce6e343a3a96618.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":60,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-28 01:33:41', '192.168.1.119'),
(168, '电话', 6, 1, 0, 106, 168, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u7535\\u8bdd\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":106,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":106,\"height\":108,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/ca\\/7fdf2d4af3555fe2b51fcfbf53745a.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":60,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-28 01:33:36', '192.168.1.119'),
(169, '手机互联', 6, 1, 0, 106, 168, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u624b\\u673a\\u4e92\\u8054\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":106,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":106,\"height\":108,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/fb\\/c8a932e6d83b85af34230838821638.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":60,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-28 01:33:46', '192.168.1.119'),
(170, '蓝牙音乐', 6, 1, 0, 106, 168, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u84dd\\u7259\\u97f3\\u4e50\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":106,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":106,\"height\":108,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/2e\\/ef1340c3ffba30ac816da2c430f25c.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":60,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-28 01:33:51', '192.168.1.119'),
(171, '导航', 6, 1, 0, 106, 168, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5bfc\\u822a\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":106,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":106,\"height\":108,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/55\\/b9f0f0c56e53a0554d07acfc8b59ff.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":60,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-28 01:33:30', '192.168.1.119'),
(172, '日期控件', 6, 4, 0, 400, 360, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"18:00\\\"}\",\"textSize\":84,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":40,\"right\":0,\"bottom\":180,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100101\\\"}\",\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u661f\\u671f\\u4e00\\\"}\",\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100103\\\"}\",\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"2018-01-01\\\"}\",\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":180,\"right\":0,\"bottom\":80,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100102\\\"}\",\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u4e0b\\u5348\\\"}\",\"textSize\":14,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":90,\"top\":60,\"right\":90,\"bottom\":280,\"gravity\":1,\"recv\":\"{\\\"recvId\\\":\\\"100104\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-05-28 05:35:57', '192.168.1.119'),
(173, '音乐信息', 6, 5, 0, 452, 190, '', '#00000000', '', '{\"packName\":\"com.jancar.player.music\"}', '[{\"text\":null,\"textSize\":20,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":10,\"top\":100,\"right\":130,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100222\\\"}\",\"send\":null}]', '[{\"width\":452,\"height\":164,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/85\\/c724f8327cbbaae2b9ce1656ad3407.png\",\"filterColor\":\"\",\"left\":0,\"top\":26,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":126,\"height\":126,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/80\\/a93e1472ded8ae4b041d7da44c825f.png\",\"filterColor\":\"\",\"left\":326,\"top\":0,\"right\":20,\"bottom\":88,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":54,\"height\":54,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/56\\/805e771ce2a140c15f2e60ecddfcbe.png\",\"filterColor\":\"#7FFFFFFF\",\"left\":40,\"top\":56,\"right\":358,\"bottom\":80,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200302\\\"}\"},{\"width\":54,\"height\":54,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/90\\/b0dc0c289258fa9c10d232e629c62f.png\",\"filterColor\":\"#7FFFFFFF\",\"left\":240,\"top\":56,\"right\":158,\"bottom\":80,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200303\\\"}\"},{\"width\":106,\"height\":106,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c4\\/c07b5b1da14c19ea0bf0d7ca186190.png\",\"filterColor\":\"\",\"left\":332,\"top\":8,\"right\":28,\"bottom\":97,\"scaleType\":0,\"shapeType\":0,\"recv\":\"{\\\"recvId\\\":\\\"100227\\\"}\",\"send\":null},{\"width\":34,\"height\":34,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f0\\/73507b36cd8e3af7bc193423f2fa4f.png\",\"filterColor\":\"\",\"left\":150,\"top\":68,\"right\":270,\"bottom\":90,\"scaleType\":3,\"shapeType\":0,\"recv\":\"{\\\"recvId\\\":\\\"100225\\\",\\\"visibleContent\\\":\\\"01\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"200301\\\"}\"},{\"width\":34,\"height\":34,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d3\\/225fcfed819ddd05ad6167165753be.png\",\"filterColor\":\"\",\"left\":150,\"top\":68,\"right\":270,\"bottom\":90,\"scaleType\":3,\"shapeType\":0,\"recv\":\"{\\\"recvId\\\":\\\"100225\\\",\\\"disVisibleContent\\\":\\\"01\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"200301\\\"}\"}]', '[]', '', 1, 6, '2019-05-28 02:12:55', '192.168.1.119'),
(174, '音乐单曲列表', 23, 43, 0, 424, 400, '', '', '{\"recvId\":\"100229\",\"keyId\":\"100221\"}', '', '[]', '[]', '[{\"pageId\":10,\"width\":424,\"height\":50,\"backColor\":\"\",\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"300101\\\"}\"}]', '', 1, 6, '2019-06-01 03:39:30', '192.168.1.119'),
(175, '圆形播放媒体图片', 23, 1, 0, 147, 147, '', '', '', '', '[]', '[{\"width\":153,\"height\":153,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/b9\\/bca675740f493d6a3d5313b617ecf6.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":1,\"recv\":\"{\\\"recvId\\\":\\\"100227\\\",\\\"animId\\\":\\\"100225\\\",\\\"startAnim\\\":\\\"01\\\"}\",\"send\":null}]', '[]', '', 1, 6, '2019-06-03 01:05:29', '192.168.43.219'),
(176, '音乐图片底图', 23, 1, 0, 270, 270, '', '', '', '', '[]', '[{\"width\":270,\"height\":270,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/61\\/10ac17567717cd1c9df0435214bae8.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-28 07:38:41', '192.168.1.119'),
(177, '音乐歌名', 23, 1, 0, 480, 50, '', '', '', '', '[{\"text\":null,\"textSize\":30,\"textLines\":0,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":60,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":\"{\\\"recvId\\\":\\\"100222\\\"}\",\"send\":null}]', '[{\"width\":50,\"height\":50,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d4\\/9cabf844adb0fcfb02b645365694c8.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":430,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-28 08:07:14', '192.168.1.119'),
(178, '音乐歌名', 23, 1, 0, 50, 480, '', '', '', '', '[{\"text\":null,\"textSize\":24,\"textLines\":0,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":60,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":1,\"recv\":\"{\\\"recvId\\\":\\\"100222\\\"}\",\"send\":null}]', '[{\"width\":50,\"height\":50,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d4\\/9cabf844adb0fcfb02b645365694c8.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 0, 6, '2019-05-28 07:48:32', '192.168.1.119'),
(179, '音乐播放控制菜单', 23, 5, 0, 1024, 140, '#1FFFFFFF', '', '', '', '[]', '[{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c9\\/053f789020f8ec5a1bc5c6f1b29ffc.png\",\"filterColor\":\"#0000FF\",\"left\":212,\"top\":40,\"right\":612,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200302\\\"}\"},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c6\\/4ce7ee99e6e6140f51f89b1342a44f.png\",\"filterColor\":\"#0000FF\",\"left\":412,\"top\":40,\"right\":412,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":\"{\\\"recvId\\\":\\\"100225\\\",\\\"visibleContent\\\":\\\"01\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"200301\\\"}\"},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/b1\\/f9f68894e1bae11adbc45e6b9fe4c6.png\",\"filterColor\":\"#0000FF\",\"left\":412,\"top\":40,\"right\":412,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":\"{\\\"recvId\\\":\\\"100225\\\",\\\"disVisibleContent\\\":\\\"01\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"200301\\\"}\"},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/1c\\/074ad5ac72f40801305eb6892b4d5a.png\",\"filterColor\":\"#0000FF\",\"left\":612,\"top\":40,\"right\":212,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200303\\\"}\"},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f3\\/a71de0541c95ca0b79a6f49f04f599.png\",\"filterColor\":\"#0000FF\",\"left\":924,\"top\":40,\"right\":0,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"400201\\\"}\"}]', '[]', '', 1, 6, '2019-05-30 09:59:21', '192.168.1.119'),
(180, '音乐播放进度条', 23, 8, 0, 1024, 30, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"00:00:00\\\"}\",\"textSize\":20,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":924,\"bottom\":0,\"gravity\":4,\"recv\":null,\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"00:00:00\\\"}\",\"textSize\":20,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":924,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":null,\"send\":null}]', '[{\"width\":834,\"height\":30,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/53\\/b885c882235c7f8edc7955ee6d6f62.png\",\"filterColor\":\"\",\"left\":100,\"top\":0,\"right\":100,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":834,\"height\":30,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/3a\\/ae054b61ba605d138e2441fba386af.png\",\"filterColor\":\"\",\"left\":100,\"top\":0,\"right\":100,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":30,\"height\":30,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/29\\/c02cf2f567e013837e4da21b01e29a.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-28 09:08:33', '192.168.1.119'),
(181, '音乐播放列表', 23, 43, 0, 400, 400, '', '', '', '', '[]', '[]', '[]', '', 0, 6, '2019-05-29 00:53:26', '192.168.1.119'),
(182, 'new_AP9轮播图片', 5, 42, 0, 1024, 600, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5e94\\u7528\\\"}\",\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":250,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5bfc\\u822a\\\"}\",\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":250,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6536\\u97f3\\u673a\\\"}\",\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":250,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u7535\\u8bdd\\\"}\",\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":250,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u624b\\u673a\\u4e92\\u8fde\\\"}\",\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":250,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[{\"width\":160,\"height\":280,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/17\\/59b5938e8bf8a11b5ff72d19b20c05.png\",\"filterColor\":\"#3F0000FF\",\"left\":82,\"top\":160,\"right\":782,\"bottom\":160,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"packName\\\":\\\"com.android.launcher3\\\"}\"},{\"width\":180,\"height\":315,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c9\\/70b1864d18a5dd69ea13e4117a1348.png\",\"filterColor\":\"#3F0000FF\",\"left\":238,\"top\":135,\"right\":606,\"bottom\":130,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"packName\\\":\\\"com.autonavi.amapauto\\\"}\"},{\"width\":200,\"height\":350,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/24\\/e0deed3b33bf5e9953857ed386708b.png\",\"filterColor\":\"#3F0000FF\",\"left\":412,\"top\":115,\"right\":412,\"bottom\":135,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"packName\\\":\\\"com.jancar.radios\\\"}\"},{\"width\":180,\"height\":315,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/27\\/253e2db79ecb9ece67d6b228264481.png\",\"filterColor\":\"#3F0000FF\",\"left\":606,\"top\":135,\"right\":238,\"bottom\":130,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"packName\\\":\\\"com.jancar.bluetooth.phone\\\"}\"},{\"width\":160,\"height\":280,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/5f\\/ff9a22f80939605c4c5eaa6d0a2f80.png\",\"filterColor\":\"#3F0000FF\",\"left\":782,\"top\":160,\"right\":82,\"bottom\":160,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"packName\\\":\\\"net.easyconn\\\"}\"}]', '[]', '', 1, 6, '2019-06-17 02:23:48', '192.168.1.119'),
(184, '播放歌曲动画', 23, 45, 0, 33, 33, '', '', '{\"keyId\":\"000001\"}', '', '[]', '[{\"width\":33,\"height\":33,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/2c\\/62546be1ddc6ad70312c228c38c384.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":33,\"height\":33,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/8f\\/b128f7f55e43c7f00e2aa5947a9ee2.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":33,\"height\":33,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/a0\\/33ee0aa838682d369ead6110100ea8.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":33,\"height\":33,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/6c\\/678f3faa815e48ba2b76733ba09834.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-30 07:56:40', '192.168.1.119'),
(185, '单曲列表ITEM', 23, 1, 0, 374, 50, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6b4c\\u66f2\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":0,\"top\":0,\"right\":100,\"bottom\":0,\"gravity\":3,\"recv\":\"{\\\"keyId\\\":\\\"100222\\\"}\",\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u672a\\u77e5\\u827a\\u672f\\u5bb6\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":274,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"keyId\\\":\\\"100223\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-06-01 02:32:17', '192.168.1.119'),
(186, '列表艺术家', 23, 1, 0, 100, 50, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6b4c\\u624b\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"keyId\\\":\\\"100223\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-05-30 08:26:13', '192.168.1.119'),
(187, '音乐分页', 23, 46, 0, 424, 400, '#EA212121', '', '{\"recvId\":\"400302\",\"keyId\":\"000002\"}', '', '[]', '[]', '[{\"pageId\":13,\"width\":500,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":15,\"width\":500,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":19,\"width\":500,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":20,\"width\":500,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":21,\"width\":500,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null}]', '', 1, 6, '2019-06-01 00:57:10', '192.168.1.119'),
(188, '音乐右侧菜单', 23, 47, 0, 600, 400, '', '', '{\"recvId\":\"400201\"}', '', '[{\"text\":null,\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":-76,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":4,\"recv\":null,\"send\":null}]', '[]', '[{\"pageId\":18,\"width\":0,\"height\":0,\"backColor\":\"\",\"recv\":null,\"send\":null}]', '', 1, 6, '2019-06-04 06:39:54', '192.168.1.119'),
(189, '音乐分页导航', 23, 48, 0, 100, 400, '#EA313131', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5b58\\u50a8\\u5668\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"40030200\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"400302\\\",\\\"eventContent\\\":\\\"00\\\"}\"},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5355\\u66f2\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"40030201\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"400302\\\",\\\"eventContent\\\":\\\"01\\\"}\"},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6b4c\\u624b\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"40030202\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"400302\\\",\\\"eventContent\\\":\\\"02\\\"}\"},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u4e13\\u8f91\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"40030203\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"400302\\\",\\\"eventContent\\\":\\\"03\\\"}\"},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6587\\u4ef6\\u5939\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"40030204\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"400302\\\",\\\"eventContent\\\":\\\"04\\\"}\"}]', '[]', '[]', '', 1, 6, '2019-06-01 08:47:56', '192.168.1.119'),
(190, '存储列表', 23, 43, 0, 424, 400, '', '', '{\"recvId\":\"100401\",\"keyId\":\"100402\"}', '', '[]', '[]', '[{\"pageId\":22,\"width\":180,\"height\":180,\"backColor\":\"\",\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"300104\\\"}\"}]', '', 1, 6, '2019-06-01 05:09:48', '192.168.1.119'),
(191, '存储器名称', 23, 1, 0, 180, 30, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5b58\\u50a8\\u5668\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"keyId\\\":\\\"100403\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-05-31 09:56:44', '192.168.1.119'),
(192, '存储器', 23, 2, 0, 70, 70, '', '#FF0370E5', '{\"visibleContent\":\"emulated#udisk#storage\",\"keyId\":\"100402\"}', '', '[]', '[{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/a6\\/bf157937f33b2d8cb44c3160c1736c.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/be\\/b646718dd7e793cd9b486a353bdcdc.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/a3\\/c090527483695f2833577f9ce87ad1.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-31 09:56:26', '192.168.1.119'),
(193, '音乐循环控制', 23, 2, 0, 48, 32, '', '#FF0370E5', '{\"recvId\":\"100228\",\"visibleContent\":\"00#01#02#03\"}', '{\"eventId\":\"200305\"}', '[]', '[{\"width\":48,\"height\":32,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/9b\\/ffc3111b4e7a6590b7c02698e5ea5b.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":48,\"height\":32,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/3d\\/afa71507dbc4cdc561a4d306fd2d68.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":48,\"height\":32,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/5f\\/8340075acea615cfa4a96d6f6c0858.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":48,\"height\":32,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/cd\\/b718193dbffa8828e0f52a78fa2147.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-01 01:21:23', '192.168.1.119'),
(194, '测试文件夹', 23, 1, 0, 40, 40, '', '', '', '', '[]', '[{\"width\":40,\"height\":40,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/2e\\/238c5d0a001e84a673491dda891035.png\",\"filterColor\":\"#FE0370E5\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"11111\\\"}\"}]', '[]', '', 0, 6, '2019-06-01 07:11:31', '192.168.1.119'),
(195, '文件夹列表ITEM', 23, 1, 0, 424, 60, '', '#FF0370E5', '', '', '[{\"text\":null,\"textSize\":22,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":60,\"top\":0,\"right\":140,\"bottom\":25,\"gravity\":3,\"recv\":\"{\\\"keyId\\\":\\\"10FF03\\\"}\",\"send\":null},{\"text\":null,\"textSize\":14,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":60,\"top\":35,\"right\":40,\"bottom\":0,\"gravity\":3,\"recv\":\"{\\\"keyId\\\":\\\"10FF04\\\"}\",\"send\":null},{\"text\":null,\"textSize\":22,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":284,\"top\":0,\"right\":40,\"bottom\":25,\"gravity\":4,\"recv\":\"{\\\"keyId\\\":\\\"10FFF1\\\"}\",\"send\":null}]', '[{\"width\":40,\"height\":40,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/2e\\/238c5d0a001e84a673491dda891035.png\",\"filterColor\":\"#FF0370E5\",\"left\":0,\"top\":0,\"right\":364,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":\"{\\\"keyId\\\":\\\"10FFFF\\\"}\",\"send\":null}]', '[]', '', 1, 6, '2019-06-01 07:44:16', '192.168.1.119'),
(196, '文件夹列表', 23, 49, 0, 424, 400, '', '', '{\"recvId\":\"100232\",\"keyId\":\"100221\"}', '', '[]', '[]', '[{\"pageId\":28,\"width\":424,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":29,\"width\":424,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"300101\\\"}\"}]', '', 1, 6, '2019-06-01 08:32:02', '192.168.1.119'),
(197, '打开子项指示', 23, 2, 0, 35, 35, '', '#FF0370E5', '{\"visibleContent\":\"close#open\",\"keyId\":\"10FFF3\"}', '', '[]', '[{\"width\":35,\"height\":35,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/03\\/3db0cfc86a96c6e0672d23563f6d9f.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":35,\"height\":35,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/b4\\/772b7ae96c72545ef37b5f24d33530.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-01 07:43:35', '192.168.1.119'),
(198, '歌手列表ITEM', 23, 1, 0, 424, 60, '', '#FF0370E5', '', '', '[{\"text\":null,\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":60,\"top\":0,\"right\":140,\"bottom\":0,\"gravity\":3,\"recv\":\"{\\\"keyId\\\":\\\"100223\\\"}\",\"send\":null},{\"text\":null,\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":284,\"top\":0,\"right\":40,\"bottom\":0,\"gravity\":4,\"recv\":\"{\\\"keyId\\\":\\\"10FFF1\\\"}\",\"send\":null}]', '[{\"width\":42,\"height\":42,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/5e\\/a041b8ee9eb0b3a494ab3a87cef13f.png\",\"filterColor\":\"#FF0370E5\",\"left\":0,\"top\":0,\"right\":364,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":\"{\\\"keyId\\\":\\\"10FFFF\\\"}\",\"send\":null}]', '[]', '', 1, 6, '2019-06-03 01:08:45', '192.168.43.219'),
(199, '歌手列表', 23, 49, 0, 424, 400, '', '', '{\"recvId\":\"100230\",\"keyId\":\"100221\"}', '', '[]', '[]', '[{\"pageId\":30,\"width\":424,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":31,\"width\":424,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"300101\\\"}\"}]', '', 1, 6, '2019-06-01 08:34:56', '192.168.1.119'),
(200, '单曲列表ITEM2', 23, 1, 0, 354, 50, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6b4c\\u66f2\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":\"{\\\"keyId\\\":\\\"100222\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-06-03 01:09:38', '192.168.43.219'),
(201, '专辑列表ITEM', 23, 1, 0, 424, 60, '', '#FF0370E5', '', '', '[{\"text\":null,\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":60,\"top\":0,\"right\":140,\"bottom\":0,\"gravity\":3,\"recv\":\"{\\\"keyId\\\":\\\"100224\\\"}\",\"send\":null},{\"text\":null,\"textSize\":28,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":284,\"top\":0,\"right\":40,\"bottom\":0,\"gravity\":4,\"recv\":\"{\\\"keyId\\\":\\\"10FFF1\\\"}\",\"send\":null}]', '[{\"width\":42,\"height\":42,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/6b\\/a2079ea2b9be06bc6e10b4c6ee2b1f.png\",\"filterColor\":\"#FF0370E5\",\"left\":0,\"top\":0,\"right\":364,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":\"{\\\"keyId\\\":\\\"10FFFF\\\"}\",\"send\":null}]', '[]', '', 1, 6, '2019-06-03 01:07:47', '192.168.43.219'),
(202, '专辑列表', 23, 49, 0, 424, 400, '', '', '{\"recvId\":\"100231\",\"keyId\":\"100221\"}', '', '[]', '[]', '[{\"pageId\":24,\"width\":424,\"height\":60,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":25,\"width\":424,\"height\":50,\"backColor\":\"\",\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"300101\\\"}\"}]', '', 1, 6, '2019-06-01 08:20:50', '192.168.1.119'),
(203, '音乐歌词', 23, 50, 0, 524, 60, '#AAAAAA', '#00FF00', '{\"recvId\":\"100233\"}', '', '[]', '[]', '[]', '', 1, 6, '2019-06-03 02:12:17', '192.168.43.219'),
(204, 'new_歌手列表', 23, 49, 0, 424, 400, '', '', '{\"recvId\":\"100230\",\"keyId\":\"100221\"}', '', '[]', '[]', '[]', '', 0, 6, '2019-06-03 07:49:58', '192.168.1.119'),
(205, '图片文件夹列表', 24, 49, 0, 424, 400, '', '', '{\"recvId\":\"100232\",\"keyId\":\"100502\"}', '', '[]', '[]', '[{\"pageId\":33,\"width\":424,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":34,\"width\":120,\"height\":120,\"backColor\":\"\",\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"300103\\\"}\"}]', '', 1, 6, '2019-06-05 00:30:39', '192.168.1.119'),
(206, '文件夹列表ITEM', 24, 1, 0, 424, 60, '', '#FF0370E5', '', '', '[{\"text\":null,\"textSize\":22,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":60,\"top\":0,\"right\":140,\"bottom\":25,\"gravity\":3,\"recv\":\"{\\\"keyId\\\":\\\"10FF03\\\"}\",\"send\":null},{\"text\":null,\"textSize\":14,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":60,\"top\":35,\"right\":40,\"bottom\":0,\"gravity\":3,\"recv\":\"{\\\"keyId\\\":\\\"10FF04\\\"}\",\"send\":null},{\"text\":null,\"textSize\":22,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":284,\"top\":0,\"right\":40,\"bottom\":25,\"gravity\":4,\"recv\":\"{\\\"keyId\\\":\\\"10FFF1\\\"}\",\"send\":null}]', '[{\"width\":40,\"height\":40,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/2e\\/238c5d0a001e84a673491dda891035.png\",\"filterColor\":\"#FF0370E5\",\"left\":0,\"top\":0,\"right\":364,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":\"{\\\"keyId\\\":\\\"10FFFF\\\"}\",\"send\":null}]', '[]', '', 1, 6, '2019-06-03 08:53:28', '192.168.1.119'),
(207, '图片ITEM', 24, 1, 0, 120, 150, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u56fe\\u7247\\u6587\\u4ef6\\u540d\\\"}\",\"textSize\":20,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":0,\"top\":120,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"keyId\\\":\\\"100503\\\"}\",\"send\":null}]', '[{\"width\":120,\"height\":120,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/63\\/3e6c5cdaf6be197a192586f07ca5d1.png\",\"filterColor\":\"\",\"left\":6,\"top\":6,\"right\":6,\"bottom\":36,\"scaleType\":1,\"shapeType\":0,\"recv\":\"{\\\"recvId\\\":\\\"F00502\\\",\\\"keyId\\\":\\\"F00502\\\"}\",\"send\":null},{\"width\":120,\"height\":120,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/13\\/3abb651ffeb522be1006ae5f4a6943.png\",\"filterColor\":\"#FF0370E5\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":30,\"scaleType\":0,\"shapeType\":0,\"recv\":\"{\\\"keyId\\\":\\\"121212\\\"}\",\"send\":null}]', '[]', '', 1, 6, '2019-06-04 08:52:04', '192.168.1.119'),
(208, '图片列表', 24, 43, 0, 424, 400, '', '', '{\"recvId\":\"100501\",\"keyId\":\"100502\"}', '', '[]', '[]', '[{\"pageId\":35,\"width\":120,\"height\":150,\"backColor\":\"\",\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"300103\\\"}\"}]', '', 1, 6, '2019-06-04 08:35:08', '192.168.1.119'),
(209, '图片分页', 24, 46, 0, 424, 400, '', '', '{\"recvId\":\"400302\",\"keyId\":\"000002\"}', '', '[]', '[]', '[{\"pageId\":36,\"width\":424,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":37,\"width\":424,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":38,\"width\":424,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null}]', '', 1, 6, '2019-06-04 01:48:31', '192.168.1.119'),
(210, '图片右侧菜单', 24, 47, 0, 524, 400, '#EA212121', '', '{\"recvId\":\"400201\"}', '', '[]', '[]', '[{\"pageId\":40,\"width\":524,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null}]', '', 1, 6, '2019-06-11 06:57:54', '192.168.1.119'),
(211, '图片分页导航', 24, 48, 0, 100, 400, '#EA313131', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5b58\\u50a8\\u5668\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"40030200\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"400302\\\",\\\"eventContent\\\":\\\"00\\\"}\"},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u56fe\\u7247\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"40030201\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"400302\\\",\\\"eventContent\\\":\\\"01\\\"}\"},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6587\\u4ef6\\u5939\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"40030202\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"400302\\\",\\\"eventContent\\\":\\\"02\\\"}\"}]', '[]', '[]', '', 1, 6, '2019-06-05 01:14:30', '192.168.1.119'),
(212, '图片播放控制菜单', 24, 5, 0, 1024, 140, '#85343536', '', '', '', '[]', '[{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c9\\/053f789020f8ec5a1bc5c6f1b29ffc.png\",\"filterColor\":\"#0000FF\",\"left\":212,\"top\":0,\"right\":612,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200302\\\"}\"},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c6\\/4ce7ee99e6e6140f51f89b1342a44f.png\",\"filterColor\":\"#0000FF\",\"left\":412,\"top\":0,\"right\":412,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":\"{\\\"recvId\\\":\\\"100225\\\",\\\"visibleContent\\\":\\\"01\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"200301\\\"}\"},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/b1\\/f9f68894e1bae11adbc45e6b9fe4c6.png\",\"filterColor\":\"#0000FF\",\"left\":412,\"top\":0,\"right\":412,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":\"{\\\"recvId\\\":\\\"100225\\\",\\\"disVisibleContent\\\":\\\"01\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"200301\\\"}\"},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/1c\\/074ad5ac72f40801305eb6892b4d5a.png\",\"filterColor\":\"#0000FF\",\"left\":612,\"top\":0,\"right\":212,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200303\\\"}\"},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f3\\/a71de0541c95ca0b79a6f49f04f599.png\",\"filterColor\":\"#0000FF\",\"left\":924,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"400201\\\"}\"}]', '[]', '', 1, 6, '2019-06-11 06:59:12', '192.168.1.119'),
(213, '视频文件夹列表', 25, 49, 0, 424, 400, '', '', '{\"recvId\":\"100232\",\"keyId\":\"100502\"}', '', '[]', '[]', '[{\"pageId\":49,\"width\":424,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":50,\"width\":424,\"height\":120,\"backColor\":\"\",\"recv\":null,\"send\":null}]', '', 0, 6, '2019-06-05 01:50:04', '192.168.1.119');
INSERT INTO `fly_cell` (`cellId`, `description`, `themeId`, `celltypeId`, `resId`, `width`, `height`, `backColor`, `filterColor`, `recv`, `send`, `texts`, `images`, `pages`, `remark`, `status`, `userid`, `uptime`, `ip`) VALUES
(214, '视频分页', 25, 46, 0, 424, 400, '', '', '{\"recvId\":\"400302\",\"keyId\":\"000002\"}', '', '[]', '[]', '[{\"pageId\":43,\"width\":424,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":44,\"width\":424,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":48,\"width\":424,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null}]', '', 1, 6, '2019-06-05 01:17:38', '192.168.1.119'),
(215, '视频右侧菜单', 25, 47, 0, 524, 400, '#EA212121', '', '{\"recvId\":\"400201\"}', '', '[]', '[]', '[{\"pageId\":42,\"width\":524,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null}]', '', 1, 6, '2019-06-11 07:01:44', '192.168.1.119'),
(216, '视频播放控制菜单', 25, 5, 0, 1024, 140, '#1FFFFFFF', '', '', '', '[]', '[{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c9\\/053f789020f8ec5a1bc5c6f1b29ffc.png\",\"filterColor\":\"#0000FF\",\"left\":212,\"top\":0,\"right\":612,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200302\\\"}\"},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c6\\/4ce7ee99e6e6140f51f89b1342a44f.png\",\"filterColor\":\"#0000FF\",\"left\":412,\"top\":0,\"right\":412,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":\"{\\\"recvId\\\":\\\"100225\\\",\\\"visibleContent\\\":\\\"01\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"200301\\\"}\"},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/b1\\/f9f68894e1bae11adbc45e6b9fe4c6.png\",\"filterColor\":\"#0000FF\",\"left\":412,\"top\":0,\"right\":412,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":\"{\\\"recvId\\\":\\\"100225\\\",\\\"disVisibleContent\\\":\\\"01\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"200301\\\"}\"},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/1c\\/074ad5ac72f40801305eb6892b4d5a.png\",\"filterColor\":\"#0000FF\",\"left\":612,\"top\":0,\"right\":212,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"200303\\\"}\"},{\"width\":70,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f3\\/a71de0541c95ca0b79a6f49f04f599.png\",\"filterColor\":\"#0000FF\",\"left\":924,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":2,\"shapeType\":0,\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"400201\\\"}\"}]', '[]', '', 1, 6, '2019-06-05 00:57:03', '192.168.1.119'),
(217, '视频文件夹列表', 25, 49, 0, 424, 400, '', '', '{\"recvId\":\"100232\",\"keyId\":\"100602\"}', '', '[]', '[]', '[{\"pageId\":45,\"width\":424,\"height\":400,\"backColor\":\"\",\"recv\":null,\"send\":null},{\"pageId\":46,\"width\":120,\"height\":150,\"backColor\":\"\",\"recv\":null,\"send\":\"{\\\"eventId\\\":\\\"300102\\\"}\"}]', '', 1, 6, '2019-06-05 01:59:55', '192.168.1.119'),
(218, '视频ITEM', 25, 1, 0, 120, 150, '', '', '', '', '[{\"text\":null,\"textSize\":20,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"#FF0370E5\",\"left\":0,\"top\":120,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"keyId\\\":\\\"100603\\\"}\",\"send\":null}]', '[{\"width\":120,\"height\":120,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/a4\\/2f2e05fa4f5af997c196c396da49e3.png\",\"filterColor\":\"\",\"left\":6,\"top\":6,\"right\":6,\"bottom\":36,\"scaleType\":1,\"shapeType\":0,\"recv\":\"{\\\"recvId\\\":\\\"F00602\\\",\\\"keyId\\\":\\\"F00602\\\"}\",\"send\":null},{\"width\":120,\"height\":120,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/13\\/3abb651ffeb522be1006ae5f4a6943.png\",\"filterColor\":\"#FF0370E5\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":30,\"scaleType\":0,\"shapeType\":0,\"recv\":\"{\\\"keyId\\\":\\\"121212\\\"}\",\"send\":null}]', '[]', '', 1, 6, '2019-06-05 01:52:34', '192.168.1.119'),
(219, '视频分页导航', 25, 48, 0, 100, 400, '#EA313131', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5b58\\u50a8\\u5668\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"40030200\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"400302\\\",\\\"eventContent\\\":\\\"00\\\"}\"},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u89c6\\u9891\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"40030201\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"400302\\\",\\\"eventContent\\\":\\\"01\\\"}\"},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6587\\u4ef6\\u5939\\\"}\",\"textSize\":24,\"textLines\":2,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"40030202\\\"}\",\"send\":\"{\\\"eventId\\\":\\\"400302\\\",\\\"eventContent\\\":\\\"02\\\"}\"}]', '[]', '[]', '', 1, 6, '2019-06-05 01:18:47', '192.168.1.119'),
(220, '视频列表', 25, 43, 0, 424, 400, '', '', '{\"recvId\":\"100601\",\"keyId\":\"100602\"}', '', '[]', '[]', '[{\"pageId\":47,\"width\":120,\"height\":120,\"backColor\":\"\",\"recv\":null,\"send\":null}]', '', 1, 6, '2019-06-05 01:45:03', '192.168.1.119'),
(221, '分页导航', 26, 2, 0, 116, 480, '', '', '{\"recvId\":\"400301\",\"visibleContent\":\"01#03#02#04\"}', '', '[]', '[{\"width\":116,\"height\":480,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/ef\\/c657ab35a6cf382150277300d191dd.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":116,\"height\":480,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/2b\\/585b2856a902307ba34abe335cfb24.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":116,\"height\":480,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/0e\\/535aeb755e0f9ebd63692c5b984852.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null},{\"width\":116,\"height\":480,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/9b\\/9040a21b3900ea9852cbc9d2b62c12.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-19 02:47:26', '192.168.1.119'),
(222, '分页导航背景', 26, 1, 0, 292, 480, '', '', '', '', '[]', '[{\"width\":292,\"height\":480,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f6\\/21ac3fd1910a8bcbc584481162ee28.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 05:50:29', '192.168.1.119'),
(223, '返回', 26, 1, 0, 102, 60, '', '', '', '{\"className\":\"3\"}', '[]', '[{\"width\":102,\"height\":60,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/b1\\/d5193a67c4565014cf5d9513e96241.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:02:53', '192.168.1.119'),
(224, '设置', 26, 1, 0, 102, 60, '', '', '', '{\"packName\":\"com.jancar.settingss\"}', '[]', '[{\"width\":102,\"height\":60,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/9d\\/ec831f1891ebcbfe9c42ebe37b0d40.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:02:27', '192.168.1.119'),
(225, 'APA日期控件', 26, 4, 0, 200, 480, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"18:00\\\"}\",\"textSize\":48,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":300,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100101\\\"}\",\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u661f\\u671f\\u4e00\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":60,\"right\":0,\"bottom\":380,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100103\\\"}\",\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"2019-01-01\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":90,\"right\":0,\"bottom\":340,\"gravity\":0,\"recv\":\"{\\\"recvId\\\":\\\"100102\\\"}\",\"send\":null},{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u4e0b\\u5348\\\"}\",\"textSize\":12,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":30,\"top\":60,\"right\":30,\"bottom\":400,\"gravity\":1,\"recv\":\"{\\\"recvId\\\":\\\"100104\\\"}\",\"send\":null}]', '[]', '[]', '', 1, 6, '2019-06-14 00:47:35', '192.168.1.119'),
(226, '收音机', 26, 1, 0, 526, 70, '', '', '', '{\"packName\":\"com.jancar.radios\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u6536\\u97f3\\u673a\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#000000\",\"textFilter\":\"#FFFFFF\",\"left\":276,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":null,\"send\":null}]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/83\\/8212c65c73dfc16806754bfe56b29f.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:04:28', '192.168.1.119'),
(227, '导航', 26, 1, 0, 526, 70, '', '', '', '{\"className\":\"3\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5bfc\\u822a\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#000000\",\"textFilter\":\"#FFFFFF\",\"left\":276,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":null,\"send\":null}]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/99\\/f3d8c8d31939856f70d66209a05c45.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:04:22', '192.168.1.119'),
(228, '电话', 26, 1, 0, 526, 70, '', '', '', '{\"className\":\"3\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u7535\\u8bdd\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#000000\",\"textFilter\":\"#FFFFFF\",\"left\":276,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":null,\"send\":null}]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/b6\\/a6e6965068f1218699346b3b78ac4a.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:04:17', '192.168.1.119'),
(229, '手机互联', 26, 1, 0, 526, 70, '', '', '', '{\"className\":\"3\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u624b\\u673a\\u4e92\\u8054\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#000000\",\"textFilter\":\"#FFFFFF\",\"left\":276,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":null,\"send\":null}]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/55\\/c28dd94a5102aef70468ce97f6dedb.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:04:04', '192.168.1.119'),
(230, '音乐', 26, 1, 0, 526, 70, '', '', '', '{\"packName\":\"com.flyzebra.music\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u97f3\\u4e50\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#000000\",\"textFilter\":\"#FFFFFF\",\"left\":276,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":null,\"send\":null}]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/a1\\/59fd73b0cd579a94d503a91f6a7348.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:04:09', '192.168.1.119'),
(231, '图片', 26, 1, 0, 526, 70, '', '', '', '{\"packName\":\"com.flyzebra.photo\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u56fe\\u7247\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#000000\",\"textFilter\":\"#FFFFFF\",\"left\":276,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":null,\"send\":null}]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/3f\\/cb7f43d2895fcef82eed8ae8ce6c8f.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:03:59', '192.168.1.119'),
(232, '视频', 26, 1, 0, 526, 70, '', '', '', '{\"packName\":\"com.flyzebra.video\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u89c6\\u9891\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#000000\",\"textFilter\":\"#FFFFFF\",\"left\":276,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":null,\"send\":null}]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/0e\\/7682e832447e139ba1a474d8f72926.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:03:53', '192.168.1.119'),
(233, '蓝牙音乐', 26, 1, 0, 526, 70, '', '', '', '{\"packName\":\"2\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u84dd\\u7259\\u97f3\\u4e50\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#000000\",\"textFilter\":\"#FFFFFF\",\"left\":276,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":null,\"send\":null}]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/67\\/17fa0bd0dcd3f3f6e109986f4c4de7.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:03:43', '192.168.1.119'),
(234, 'AUX', 26, 1, 0, 526, 70, '', '', '', '{\"packName\":\"1\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"AUX\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#000000\",\"textFilter\":\"#FFFFFF\",\"left\":276,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":null,\"send\":null}]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/a7\\/31e8af88f6c6f5b5543cb031779fc4.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:03:36', '192.168.1.119'),
(235, '应用', 26, 1, 0, 526, 70, '', '', '', '{\"packName\":\"com.android.launcher3\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u5e94\\u7528\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#000000\",\"textFilter\":\"#FFFFFF\",\"left\":276,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":null,\"send\":null}]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d0\\/698c994b2478d3e66c303b4029b864.png\",\"filterColor\":\"#7F000000\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 07:32:44', '192.168.1.119'),
(236, '', 26, 1, 0, 526, 70, '', '', '', '', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"WELCOME  TO  VW\\\"}\",\"textSize\":40,\"textLines\":1,\"textColor\":\"#FFFFFF\",\"textFilter\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":0,\"recv\":null,\"send\":null}]', '[]', '[]', '', 1, 6, '2019-06-13 09:55:24', '192.168.1.119'),
(237, '', 26, 1, 0, 196, 206, '', '', '', '', '[]', '[{\"width\":196,\"height\":206,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/6a\\/5548b0f46b5734fecff1f87fd06ee1.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-14 00:43:48', '192.168.1.119'),
(238, '设置', 26, 1, 0, 526, 70, '', '', '', '{\"packName\":\"com.android.setttings\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u8bbe\\u7f6e\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#000000\",\"textFilter\":\"#FFFFFF\",\"left\":276,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":null,\"send\":null}]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/fe\\/53f6ae6a03a50e1c5ff8c74d8505b1.png\",\"filterColor\":\"#7F000000\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-13 09:54:25', '192.168.1.119'),
(239, 'new_设置', 26, 1, 0, 526, 70, '', '', '', '{\"packName\":\"com.android.setttings\"}', '[{\"text\":\"{\\\"zh_rCN\\\":\\\"\\u8bbe\\u7f6e\\\"}\",\"textSize\":24,\"textLines\":1,\"textColor\":\"#000000\",\"textFilter\":\"#FFFFFF\",\"left\":276,\"top\":0,\"right\":0,\"bottom\":0,\"gravity\":3,\"recv\":null,\"send\":null}]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/fe\\/53f6ae6a03a50e1c5ff8c74d8505b1.png\",\"filterColor\":\"#7F000000\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-13 09:54:25', '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_cellpage`
--

CREATE TABLE `fly_cellpage` (
  `pageId` int(11) NOT NULL COMMENT '主键，自动递增',
  `cellId` int(11) NOT NULL COMMENT '关联组件ID',
  `subcellId` int(11) NOT NULL COMMENT '关联子组件ＩＤ',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `userid` int(11) NOT NULL COMMENT '用户ID',
  `ip` varchar(16) NOT NULL COMMENT 'IP地址',
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_cellpage`
--

INSERT INTO `fly_cellpage` (`pageId`, `cellId`, `subcellId`, `status`, `userid`, `ip`, `edittime`) VALUES
(1, 174, 0, 1, 6, '192.168.1.119', '2019-06-01 08:34:23'),
(2, 174, 7, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(3, 174, 8, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(4, 174, 0, 1, 6, '192.168.1.119', '2019-06-01 08:34:18'),
(5, 174, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(6, 174, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(7, 174, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(8, 174, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(9, 174, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(10, 174, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(11, 186, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(12, -1, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(13, -1, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(14, 187, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(15, 187, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(16, 174, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(17, 174, 0, 1, 6, '192.168.1.119', '2019-06-01 08:34:10'),
(18, -1, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(19, 187, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(20, 187, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(21, 187, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(22, -1, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(23, -1, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(24, -1, 0, 0, 6, '192.168.1.119', '2019-06-01 08:34:48'),
(25, 196, 0, 0, 6, '192.168.1.119', '2019-06-01 08:34:50'),
(26, 196, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(27, 196, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(28, 196, 0, 1, 6, '192.168.1.119', '2019-06-01 08:33:47'),
(29, 196, 0, 1, 6, '192.168.1.119', '2019-06-01 08:33:53'),
(30, 199, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(31, 199, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(32, 205, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(33, 205, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(34, 205, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(35, 208, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(36, 209, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(37, 209, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(38, 209, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(39, 210, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(40, 210, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(41, -1, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(42, 215, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(43, 214, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(44, 214, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(45, 217, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(46, 217, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(47, 220, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(48, 214, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(49, 213, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(50, 213, 0, 1, 6, '192.168.1.119', '0000-00-00 00:00:00'),
(51, -1, 0, 1, 6, '192.168.1.119', '2019-06-21 07:41:33');

-- --------------------------------------------------------

--
-- 表的结构 `fly_cellpagecell`
--

CREATE TABLE `fly_cellpagecell` (
  `id` int(11) NOT NULL COMMENT '主键，自动递增',
  `pageId` int(11) NOT NULL COMMENT '关联页面ＩＤ',
  `cellId` int(11) NOT NULL COMMENT '关联组件ＩＤ',
  `x` int(11) NOT NULL COMMENT 'ｘ坐标',
  `y` int(11) NOT NULL COMMENT 'ｙ坐标',
  `width` int(11) NOT NULL COMMENT '宽度',
  `height` int(11) NOT NULL COMMENT '高度'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_cellpagecell`
--

INSERT INTO `fly_cellpagecell` (`id`, `pageId`, `cellId`, `x`, `y`, `width`, `height`) VALUES
(2, 1, 176, 127, 22, 270, 270),
(3, 1, 143, 500, 83, 110, 160),
(4, 4, 182, -22, -83, 1024, 600),
(5, 9, 184, 5, 13, 33, 33),
(20, 12, 174, 0, 0, 500, 400),
(23, 14, 176, 95, 44, 270, 270),
(24, 17, 176, 34, 37, 270, 270),
(56, 15, 174, 0, 0, 500, 400),
(69, 13, 190, 0, 0, 400, 400),
(90, 10, 184, 8, 8, 33, 33),
(91, 10, 185, 51, 0, 374, 50),
(92, 23, 195, 0, 0, 424, 60),
(94, 21, 196, 0, 0, 424, 400),
(125, 22, 192, 71, 23, 70, 70),
(126, 22, 191, 10, 110, 180, 30),
(131, 19, 199, 0, 0, 424, 400),
(136, 20, 202, 0, 0, 424, 400),
(139, 26, 195, 0, 0, 424, 60),
(140, 26, 197, 390, 10, 35, 35),
(141, 27, 200, 50, 0, 374, 50),
(142, 27, 184, 8, 6, 33, 33),
(143, 28, 195, 0, 0, 424, 60),
(144, 28, 197, 390, 10, 35, 35),
(149, 30, 198, 0, 0, 424, 60),
(150, 30, 197, 390, 10, 35, 35),
(151, 24, 197, 390, 10, 35, 35),
(152, 24, 201, 0, 0, 424, 60),
(153, 18, 187, 76, 0, 424, 400),
(154, 18, 189, 500, 0, 100, 400),
(155, 18, 193, 25, 354, 48, 32),
(166, 25, 184, 25, 10, 33, 33),
(167, 25, 200, 70, 0, 354, 50),
(168, 31, 184, 25, 10, 33, 33),
(169, 31, 200, 60, 0, 354, 50),
(170, 29, 200, 60, 0, 354, 50),
(171, 29, 184, 25, 10, 33, 33),
(172, 32, 206, 0, 0, 424, 60),
(175, 33, 206, 0, 0, 424, 60),
(176, 33, 197, 390, 10, 35, 35),
(178, 36, 190, 0, 0, 424, 400),
(179, 37, 208, 0, 0, 424, 400),
(180, 38, 205, 0, 0, 424, 400),
(181, 39, 211, 424, 0, 100, 400),
(182, 39, 209, 0, 0, 424, 400),
(183, 40, 211, 424, 0, 100, 400),
(184, 40, 209, 0, 0, 424, 400),
(187, 35, 207, 11, 0, 120, 150),
(188, 34, 207, 11, 0, 120, 150),
(190, 43, 190, 0, 0, 424, 400),
(195, 47, 218, 10, 0, 120, 150),
(196, 44, 220, 0, 0, 424, 400),
(200, 49, 206, 0, 0, 424, 60),
(202, 50, 218, 10, 0, 120, 150),
(203, 48, 217, 0, 0, 424, 400),
(205, 46, 218, 10, 0, 120, 150),
(206, 45, 206, 0, 0, 424, 60),
(207, 45, 197, 390, 10, 35, 35),
(209, 42, 219, 424, 0, 100, 400),
(210, 42, 214, 0, 0, 424, 400);

-- --------------------------------------------------------

--
-- 表的结构 `fly_celltype`
--

CREATE TABLE `fly_celltype` (
  `celltypeId` int(11) NOT NULL COMMENT '主键，自动递增',
  `celltype` int(11) NOT NULL DEFAULT '0' COMMENT '组件类型标识',
  `celltypeName` varchar(255) NOT NULL COMMENT '组件类型名称',
  `imageurl` varchar(255) NOT NULL COMMENT '组件类型图片展示',
  `html` text NOT NULL COMMENT '可生成组件html代码',
  `description` text NOT NULL COMMENT '组件创建说明等内容',
  `extend` varchar(255) DEFAULT NULL COMMENT '扩展选项',
  `remark` text COMMENT '备注',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `userid` int(11) NOT NULL COMMENT '用户ＩＤ',
  `ip` varchar(16) NOT NULL COMMENT 'ＩＰ地址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_celltype`
--

INSERT INTO `fly_celltype` (`celltypeId`, `celltype`, `celltypeName`, `imageurl`, `html`, `description`, `extend`, `remark`, `status`, `edittime`, `userid`, `ip`) VALUES
(1, 0, '通用控件', 'http://127.0.0.1/uiweb/uploads/4c/b32fd9b6fae5c378c2c0410e7cf70f.jpg', '', '', '', '相当于ImageView', 1, '2019-05-21 00:53:59', 6, '192.168.1.119'),
(2, 1, '简单图片文字', 'http://127.0.0.1/uiweb/uploads/ec/517d877783a69c79e61e2e28aab344.png', '', '', '', '包含图片，文字，点击事件。', 1, '2019-05-21 06:16:02', 6, '192.168.1.119'),
(3, 2, '图片数字', 'http://127.0.0.1/uiweb/uploads/e9/aba6b567ce5857b83583b611751a79.png', '', '', '', '特殊控件，跟系统平台相关。', 1, '2019-05-21 00:54:06', 6, '192.168.1.119'),
(4, 3, '日期控件', 'http://127.0.0.1/uiweb/uploads/80/7048235eca8611e36b03c9a943adaf.png', '', '', '', '用来显示日期的控件', 1, '2019-05-21 00:54:12', 6, '192.168.1.119'),
(5, 4, '媒体信息控件', 'http://127.0.0.1/uiweb/uploads/af/d0a90782db989dbd2bab5dd993a3e2.png', '', '', '', '显示媒体播放信息', 1, '2019-05-31 06:20:53', 6, '192.168.1.119'),
(6, 5, '镜像控件', 'http://127.0.0.1/uiweb/uploads/51/b013a08f7ad2ff3de49e3b9740cdd0.png', '', '', '', '可以生成镜像的图片', 1, '2019-05-21 00:55:04', 6, '192.168.1.119'),
(7, 6, '页面导航条', 'http://127.0.0.1/uiweb/uploads/40/841f8b970233545b18c849c6908a49.png', '', '', '', '用来展示当前显示页面为哪一页', 1, '2019-05-22 07:14:34', 6, '192.168.1.119'),
(8, 7, '进度条', 'http://127.0.0.1/uiweb/uploads/28/7effe7e601c2666ed507660acae66d.png', '', '', '', '显示进度条', 1, '2019-06-04 01:51:18', 6, '192.168.1.119'),
(42, 8, '轮播图片', '', '', '', NULL, NULL, 1, '2019-06-04 01:51:10', 6, '192.168.1.119'),
(43, 9, '列表控件', '', '显示所有应用列表', '', NULL, NULL, 1, '2019-05-28 03:26:54', 6, '192.168.1.119'),
(44, 10, '测试', '', 'sssss', '', NULL, NULL, 0, '2019-05-28 01:21:38', 6, '192.168.1.119'),
(45, 10, '帧动画控件', '', '', '', NULL, NULL, 1, '2019-05-30 00:43:50', 6, '192.168.1.119'),
(46, 11, '分页组件', '', '', '', NULL, NULL, 1, '2019-05-31 06:20:06', 6, '192.168.1.119'),
(47, 12, '页面组件', '', '', '', NULL, NULL, 1, '2019-05-31 07:57:06', 6, '192.168.1.119'),
(48, 13, '分页控件导航', '', '', '', NULL, NULL, 1, '2019-05-31 06:27:36', 6, '192.168.1.119'),
(49, 14, '分组列表', '', '', '', NULL, NULL, 1, '2019-06-01 02:01:01', 6, '192.168.1.119'),
(50, 15, '音乐歌词', '', '', '', NULL, NULL, 1, '2019-06-03 01:13:53', 6, '192.168.43.219');

-- --------------------------------------------------------

--
-- 表的结构 `fly_history`
--

CREATE TABLE `fly_history` (
  `historyId` int(11) NOT NULL,
  `imageurl` varchar(255) NOT NULL,
  `historyTitle` varchar(255) NOT NULL,
  `historyText` text NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `remark` text,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_history`
--

INSERT INTO `fly_history` (`historyId`, `imageurl`, `historyTitle`, `historyText`, `status`, `remark`, `createtime`, `userid`, `ip`) VALUES
(1, 'http://127.0.0.1/uiweb/uploads/c6/035a74237d5db8c5fecf9f27aed033.png', '2018年4月', '我们于华翰科技园成立了', 1, NULL, '2019-03-11 06:06:09', 0, '192.168.1.119'),
(2, 'http://127.0.0.1/uiweb/uploads/69/220e370672bda3779f913d88e7d17f.png', '2018年10月', '我们来到了创维创新谷这个美丽的地方', 1, NULL, '2019-03-11 06:06:07', 0, '192.168.1.119');

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
  `status` int(11) NOT NULL DEFAULT '1',
  `remark` text,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_news`
--

INSERT INTO `fly_news` (`newsId`, `newsTitle`, `newsSort`, `imageurl1`, `imageurl2`, `newsText`, `status`, `remark`, `createtime`, `userid`, `ip`) VALUES
(1, '外交部：5G全球产业链供应链等无法人为割裂或剥离', 1, 'http://127.0.0.1/uiweb/uploads/4c/b32fd9b6fae5c378c2c0410e7cf70f.jpg', '/uiweb/uploads/15/4ee5c4d6d4a95003335ae5ebc7e6c9.jpg', '　　“外交部发言人办公室”公众号消息，在2月21日外交部例行记者会上，有记者问：下周，世界移动通讯大会将在巴塞罗那召开，5G技术将成为会议热点话题之一。我们注意到，一段时间以来，围绕中国企业参与有关国家的5G网络建设有不少议论。有人认为中国企业的产品和设备存在安全隐患，应将其排除在5G网络建设之外。你对此有何评论？\r\n　　耿爽：第五代移动通信技术（5G）作为一项前沿科技，不是某个或某几个国家的专属，而是关乎全球经济发展、世界各国利益和人类文明进步的大事。\r\n　　5G技术是全球化大潮下各国交流合作的产物，是国际社会共同的高科技创新成果。它的全球产业链、供应链、价值链高度融合，无法人为割裂或剥离，否则将会影响互利共赢的多边合作，损害开放包容的市场环境，破坏公平、公正、非歧视的国际规则。\r\n　　在全球化时代，没有哪一个国家可以脱离世界独立发展，也没有哪一项技术的开发与应用可以拒绝合作。中方将继续秉持共商共建共享原则，同各方共同把握新一轮科技革命带来的巨大发展机遇，加强包括5G在内的科技交流与合作，努力实现共同发展、互利共赢，为促进全人类福祉作出积极贡献。\r\n　　在这一进程中，我们希望各国都能基于自己的独立判断作出符合自身利益、符合时代潮流的选择。', 1, '', '2019-02-21 10:09:51', 0, '192.168.1.119'),
(3, '物理学家在环形装置内发现“非一般”的光行为', 0, 'http://127.0.0.1/uiweb/uploads/8e/466e3e87d66d8a0e5b9c4c9a968aa9.jpg', '', '　　新浪科技讯 北京时间2月22日消息，据国外媒体报道，来自英国的物理学家团队建造了一台环形机器，当光脉冲在里面围绕着彼此旋转时，控制光行为的一般规律不再适用。\r\n\r\n　　在正常情况下，光会展现出某种物理对称性。首先，假设你有一盘记录了光行为的录像带，那么无论是正放还是倒放，你会发现光在两个时间方向上的行为是一样的。这一现象被称为“时间反演对称”。其次，光能以波的形式进行传播，会表现出所谓的“偏振”现象：相对于波的运动而发生的振荡。这种偏振通常保持不变，提供了另一种对称性。\r\n\r\n\r\n　　但是，在这个环形装置内部，光既失去了时间反演对称性，其偏振也发生改变。光波在环形装置内会转圈并相互共振，产生在外界通常不存在的效应。\r\n\r\n　　研究人员已经知道，在特定条件下，当光在光学环形装置内部运行时，会失去时间反演对称性。光波的波峰不会在对称性所要求的位置出现。在1月10日发表于《物理评论快报》（Physical Review Letters）杂志的一篇新论文中，来自英国国家物理实验室（National Physical Laboratory，简称NPL）的研究团队指出，在这一现象发生的同时，光的偏振也会发生改变。\r\n\r\n　　研究团队将细心定时的激光脉冲射入名为“光学环形谐振器”的装置中，光的波峰排列方式没有呈现出时间反演对称性。当光束互相环绕时，只形成了单一时间方向上的模式。与此同时，光失去了垂直偏振——光波不再以严格的上下方式运动，而是形成了椭圆形。\r\n\r\n　　物理学家在一份声明中说，这项研究为光的操纵打开了新的大门，将使研究人员的工作更加精确，并为原子钟和量子计算机等设备中的光学环路提供新的设计。', 1, NULL, '2019-02-22 01:36:12', 0, '192.168.1.119'),
(6, ' 怎么得到 thinkphp 查询结果的返回条数', 0, 'http://127.0.0.1/uiweb/uploads/4c/b32fd9b6fae5c378c2c0410e7cf70f.jpg', '', '\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数', 0, NULL, '2019-02-22 04:02:09', 0, '192.168.1.119'),
(7, ' 怎么得到 thinkphp 查询结果的返回条数', 0, 'http://127.0.0.1/uiweb/uploads/15/4ee5c4d6d4a95003335ae5ebc7e6c9.jpg', '', '\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数', 0, NULL, '2019-02-22 04:02:16', 0, '192.168.1.119'),
(8, ' 怎么得到 thinkphp 查询结果的返回条数2', 0, 'http://127.0.0.1/uiweb/uploads/15/4ee5c4d6d4a95003335ae5ebc7e6c9.jpg', '', '\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数\r\n怎么得到 thinkphp 查询结果的返回条数', 0, NULL, '2019-02-22 04:02:25', 0, '192.168.1.119'),
(12, '测试测试测试测试测试测试测试测试测试测试测wwww', 0, 'http://127.0.0.1/uiweb/uploads/8e/466e3e87d66d8a0e5b9c4c9a968aa9.jpg', '', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试1', 0, NULL, '2019-02-22 07:17:34', 0, '192.168.1.119'),
(13, '1', 0, 'http://127.0.0.1/uiweb/uploads/8c/e959e3095e392fd7f8c63177cfac0a.jpg', '', '1', 0, NULL, '2019-03-11 06:11:21', 6, '192.168.1.119'),
(14, '111', 0, 'http://127.0.0.1/uiweb/uploads/7e/b83361c57dc762493d937381938176.jpg', 'http://127.0.0.1/uiweb/uploads/fb/373749569112755e4149c01d7f7346.jpg', '1', 0, NULL, '2019-03-11 06:13:35', 6, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_page`
--

CREATE TABLE `fly_page` (
  `pageId` int(11) NOT NULL COMMENT '主键，自动递增',
  `pageName` varchar(255) NOT NULL COMMENT '页面名称',
  `themeId` int(11) NOT NULL COMMENT '关联模板ID',
  `imageurl` varchar(255) DEFAULT NULL COMMENT '页面背景图片地址',
  `backcolor` varchar(9) DEFAULT NULL COMMENT '页面背景颜色',
  `width` int(11) NOT NULL COMMENT '宽度',
  `height` int(11) NOT NULL COMMENT '高度',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `remark` text COMMENT '备注',
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `userid` int(11) NOT NULL COMMENT '用户ＩＤ',
  `ip` varchar(16) NOT NULL COMMENT 'ＩＰ地址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_page`
--

INSERT INTO `fly_page` (`pageId`, `pageName`, `themeId`, `imageurl`, `backcolor`, `width`, `height`, `status`, `remark`, `edittime`, `userid`, `ip`) VALUES
(5, '第一页', 5, '', NULL, 1024, 600, 1, '', '2019-05-21 07:57:54', 6, '192.168.1.119'),
(6, '第二页', 5, '', NULL, 1024, 600, 1, '', '2019-05-21 07:57:54', 0, '192.168.1.119'),
(7, '第三页', 5, '', NULL, 1024, 600, 1, '', '2019-05-21 07:57:54', 0, '192.168.1.119'),
(8, '第一页', 7, '', NULL, 1024, 600, 1, '', '2019-05-21 07:57:54', 6, '192.168.1.119'),
(9, '第二页', 7, '', NULL, 1024, 600, 1, '', '2019-05-21 07:57:54', 6, '192.168.1.119'),
(11, '第一页', 12, '', NULL, 1024, 600, 1, '', '2019-05-21 07:57:54', 6, '192.168.1.119'),
(12, '第一页', 13, '', NULL, 1024, 600, 1, '', '2019-05-21 07:57:54', 6, '192.168.1.119'),
(13, '第二页', 13, '', NULL, 1024, 600, 1, '', '2019-05-21 07:57:54', 6, '192.168.1.119'),
(14, '第一页', 14, '', NULL, 1024, 600, 1, '', '2019-05-21 07:57:54', 6, '192.168.1.119'),
(44, 'Test-1', 5, '', '', 1024, 600, 1, '', '2019-05-23 00:37:25', 6, '192.168.1.119'),
(45, '第一页', 18, '', '', 1024, 600, 1, '', '2019-05-21 08:56:00', 6, '192.168.1.119'),
(46, '第一页', 19, '', '', 1024, 600, 1, '', '2019-05-23 00:36:55', 6, '192.168.1.119'),
(47, '第一页', 20, '', '', 1024, 600, 1, '', '2019-05-27 06:05:34', 6, '192.168.1.119'),
(48, 'TEST', 21, '', '', 1024, 600, 1, '', '2019-05-27 06:58:37', 6, '192.168.1.119'),
(49, '第一页', 6, '', '', 1024, 600, 1, '', '2019-05-28 01:31:16', 6, '192.168.1.119'),
(50, '第一页', 23, '', '', 1024, 600, 1, '', '2019-05-28 03:41:37', 6, '192.168.1.119'),
(51, '第二页', 20, '', '', 1024, 600, 1, '', '2019-05-29 03:07:57', 6, '192.168.1.119'),
(52, '第一页', 24, '', '', 1024, 600, 1, '', '2019-06-03 08:31:25', 6, '192.168.1.119'),
(53, 'Video', 25, '', '', 1024, 600, 1, '', '2019-06-05 00:27:07', 6, '192.168.1.119'),
(54, '第一页', 26, '', '', 800, 480, 1, '', '2019-06-12 06:14:25', 6, '192.168.1.119'),
(55, '第二页', 26, '', '', 800, 480, 1, '', '2019-06-12 06:14:15', 6, '192.168.1.119'),
(56, '第三页', 26, '', '', 800, 480, 1, '', '2019-06-12 06:14:47', 6, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_pagecell`
--

CREATE TABLE `fly_pagecell` (
  `id` int(11) NOT NULL COMMENT '主键，自动递增',
  `pageId` int(11) NOT NULL COMMENT '关联页面ＩＤ',
  `cellId` int(11) NOT NULL COMMENT '关联组件ＩＤ',
  `x` int(11) NOT NULL COMMENT 'ｘ坐标',
  `y` int(11) NOT NULL COMMENT 'ｙ坐标',
  `width` int(11) NOT NULL COMMENT '宽度',
  `height` int(11) NOT NULL COMMENT '高度'
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
(139, 12, 47, 387, 121, 120, 202),
(140, 12, 48, 608, 121, 120, 202),
(141, 12, 49, 829, 121, 120, 202),
(142, 12, 50, 387, 349, 120, 202),
(143, 12, 51, 608, 349, 120, 202),
(144, 12, 52, 829, 349, 120, 202),
(163, 22, 78, 0, 536, 1024, 16),
(1262, 32, 103, 100, 0, 400, 400),
(1263, 32, 104, 500, 0, 100, 400),
(1264, 32, 105, 32, 348, 48, 32),
(1339, 27, 100, 424, 60, 600, 400),
(1340, 27, 96, 259, 320, 45, 45),
(1386, 28, 82, 0, 460, 1024, 140),
(1387, 28, 83, 120, 120, 251, 251),
(1388, 28, 86, 540, 105, 50, 50),
(1389, 28, 85, 540, 210, 50, 50),
(1390, 28, 84, 540, 315, 50, 50),
(1391, 28, 88, 592, 315, 400, 50),
(1392, 28, 90, 592, 105, 400, 50),
(1393, 28, 89, 592, 210, 400, 50),
(1394, 28, 100, 424, 60, 600, 400),
(1405, 37, 109, 0, 0, 400, 400),
(1406, 37, 110, 399, 0, 100, 400),
(1433, 36, 101, 0, 0, 400, 400),
(1434, 36, 112, 0, 0, 400, 400),
(1455, 29, 91, 0, 5, 1024, 30),
(1456, 29, 92, 477, 40, 70, 70),
(1457, 29, 94, 287, 40, 70, 70),
(1458, 29, 93, 667, 40, 70, 70),
(1459, 29, 96, 924, 30, 100, 100),
(1467, 41, 115, 0, 0, 400, 400),
(1468, 41, 114, 400, 0, 100, 400),
(1469, 40, 101, 0, 0, 400, 400),
(1470, 40, 116, 0, 0, 400, 400),
(1471, 40, 117, 0, 0, 400, 400),
(1479, 33, 95, 0, 0, 400, 400),
(1480, 33, 101, 0, 0, 400, 400),
(1481, 33, 118, 0, 0, 400, 400),
(1482, 33, 119, 0, 0, 400, 400),
(1483, 33, 120, 0, 0, 400, 400),
(1484, 7, 25, 526, 141, 212, 317),
(1485, 7, 23, 42, 141, 212, 317),
(1486, 7, 24, 284, 141, 212, 317),
(1499, 35, 4, 90, 59, 630, 472),
(1500, 39, 1, 50, 145, 212, 317),
(1501, 39, 8, 290, 145, 212, 317),
(1502, 39, 6, 530, 145, 212, 317),
(1503, 39, 7, 770, 145, 212, 317),
(1591, 13, 53, 387, 121, 120, 202),
(1592, 13, 57, 608, 121, 120, 202),
(1593, 13, 54, 828, 121, 120, 202),
(1594, 13, 55, 387, 349, 120, 202),
(1595, 13, 56, 608, 349, 120, 202),
(1606, 24, 46, 0, 50, 380, 500),
(1607, 24, 78, 0, 536, 1024, 16),
(1614, 21, 78, 0, 536, 1024, 16),
(2195, 5, 15, 42, 141, 212, 317),
(2196, 5, 17, 526, 141, 212, 317),
(2197, 5, 18, 768, 141, 212, 317),
(2198, 5, 16, 284, 141, 212, 317),
(2199, 5, 118, 284, 251, 212, 50),
(2200, 5, 130, 403, 319, 75, 32),
(2201, 5, 125, 307, 207, 55, 32),
(2436, 14, 67, 460, 72, 105, 155),
(2437, 14, 68, 660, 72, 105, 155),
(2438, 14, 69, 860, 72, 105, 155),
(2439, 14, 70, 460, 252, 105, 155),
(2440, 14, 71, 660, 252, 105, 155),
(2441, 14, 72, 860, 252, 105, 155),
(2442, 14, 73, 60, 432, 105, 155),
(2443, 14, 74, 260, 432, 105, 155),
(2444, 14, 75, 460, 432, 105, 155),
(2445, 14, 76, 660, 432, 105, 155),
(2446, 14, 77, 860, 432, 105, 155),
(2447, 14, 148, 32, 88, 406, 272),
(2571, 46, 150, 90, 149, 308, 164),
(2572, 46, 151, 70, 400, 124, 174),
(2573, 46, 155, 262, 400, 124, 174),
(2574, 46, 154, 454, 400, 124, 174),
(2575, 46, 153, 636, 400, 124, 174),
(2576, 46, 152, 828, 400, 124, 174),
(2577, 46, 157, 496, 123, 452, 190),
(2578, 46, 156, 496, 123, 452, 190),
(2579, 46, 159, 496, 123, 452, 190),
(2877, 44, 119, 648, 241, 240, 30),
(2878, 44, 123, 0, 65, 1024, 20),
(2879, 44, 121, 628, 97, 200, 30),
(2880, 44, 122, 615, 169, 200, 30),
(2881, 44, 125, 548, 277, 55, 32),
(2882, 44, 118, 192, 400, 212, 50),
(2883, 44, 124, 338, 486, 240, 20),
(2884, 44, 126, 51, 426, 80, 80),
(2885, 44, 127, 758, 520, 50, 50),
(2886, 44, 128, 450, 523, 50, 50),
(2887, 44, 126, 62, 132, 80, 80),
(2888, 44, 126, 642, 265, 80, 80),
(2889, 44, 126, 880, 335, 80, 80),
(2890, 44, 126, 886, 99, 80, 80),
(2891, 44, 126, 239, 249, 80, 80),
(2892, 44, 120, 423, 96, 124, 124),
(2893, 44, 129, 219, 95, 112, 112),
(2894, 44, 131, 37, 342, 120, 50),
(2895, 44, 130, 231, 510, 75, 32),
(2896, 44, 132, 438, 405, 120, 50),
(2897, 44, 130, 402, 256, 75, 32),
(2898, 44, 133, 390, 306, 240, 100),
(2899, 44, 160, 587, 470, 80, 80),
(2900, 44, 160, 922, 466, 80, 80),
(2901, 44, 160, 909, 218, 80, 80),
(2902, 44, 160, 92, 230, 80, 80),
(2903, 44, 161, 686, 333, 160, 160),
(2919, 45, 140, 250, 235, 110, 160),
(2920, 45, 134, 440, 233, 110, 160),
(2921, 45, 136, 630, 235, 110, 160),
(2922, 45, 137, 820, 235, 110, 160),
(2923, 45, 139, 820, 420, 110, 160),
(2924, 45, 142, 630, 420, 110, 160),
(2925, 45, 143, 440, 420, 110, 160),
(2926, 45, 144, 250, 420, 110, 160),
(2927, 45, 138, 60, 420, 110, 160),
(2928, 45, 145, 122, 80, 779, 125),
(2929, 45, 119, 263, 104, 240, 30),
(2930, 45, 124, 263, 139, 232, 30),
(2931, 45, 66, 541, 88, 336, 100),
(2932, 45, 141, 60, 235, 110, 160),
(2933, 45, 160, 150, 98, 80, 80),
(2942, 11, 37, 41, 121, 262, 240),
(2943, 11, 38, 334, 121, 650, 236),
(2944, 11, 162, 0, 460, 1024, 140),
(2945, 11, 39, 41, 420, 112, 162),
(2946, 11, 40, 248, 418, 112, 162),
(2947, 11, 41, 454, 420, 112, 162),
(2948, 11, 42, 659, 420, 112, 162),
(2949, 11, 43, 866, 420, 112, 162),
(2955, 48, 160, 341, 205, 80, 80),
(2956, 48, 161, 523, 184, 160, 160),
(2957, 48, 127, 852, 275, 50, 50),
(2980, 49, 172, 40, 60, 400, 360),
(2981, 49, 173, 490, 106, 452, 190),
(3051, 47, 163, 0, -5, 1024, 600),
(3052, 51, 182, 0, -5, 1024, 600),
(3288, 50, 176, 137, 137, 270, 270),
(3289, 50, 175, 202, 195, 147, 147),
(3290, 50, 177, 524, 145, 480, 50),
(3291, 50, 121, 524, 340, 480, 50),
(3292, 50, 122, 524, 245, 480, 50),
(3293, 50, 179, 0, 460, 1024, 140),
(3294, 50, 180, 0, 475, 1024, 30),
(3295, 50, 188, 424, 60, 600, 400),
(3296, 50, 203, 16, 400, 524, 60),
(3318, 52, 210, 500, 60, 524, 400),
(3319, 52, 212, 0, 460, 1024, 140),
(3321, 53, 215, 500, 60, 524, 400),
(3322, 53, 216, 0, 460, 1024, 140),
(3401, 54, 226, 233, 55, 526, 70),
(3402, 54, 227, 233, 130, 526, 70),
(3403, 54, 229, 233, 380, 526, 70),
(3404, 54, 228, 233, 305, 526, 70),
(3405, 54, 236, 233, 218, 526, 70),
(3406, 55, 230, 233, 55, 526, 70),
(3407, 55, 231, 233, 130, 526, 70),
(3408, 55, 232, 233, 305, 526, 70),
(3409, 55, 233, 233, 380, 526, 70),
(3410, 55, 236, 233, 218, 526, 70),
(3419, 56, 235, 233, 55, 526, 70),
(3420, 56, 234, 233, 130, 526, 70),
(3421, 56, 236, 233, 218, 526, 70),
(3422, 56, 238, 233, 305, 526, 70);

-- --------------------------------------------------------

--
-- 表的结构 `fly_permission`
--

CREATE TABLE `fly_permission` (
  `id` int(11) NOT NULL,
  `pid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '权限名称',
  `path` varchar(100) NOT NULL DEFAULT '' COMMENT '权限路径',
  `description` varchar(200) NOT NULL DEFAULT '' COMMENT '权限描述',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '权限状态',
  `create_time` int(11) NOT NULL COMMENT '创建时间',
  `userid` int(11) NOT NULL,
  `ip` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

--
-- 转存表中的数据 `fly_permission`
--

INSERT INTO `fly_permission` (`id`, `pid`, `name`, `path`, `description`, `status`, `create_time`, `userid`, `ip`) VALUES
(48, 0, '设置访问权限后台管理模块', '/auth', '分配管理用户权限', 1, 1552027443, 6, '192.168.1.119'),
(49, 48, '权限节点编辑', '/auth/permission', '分配网站的权限节点', 1, 1552030063, 6, '192.168.1.119'),
(50, 49, '显示页面', '/auth/permission/index', '权限节点编辑显示页面', 1, 1552030161, 6, '192.168.1.119'),
(51, 49, '添加权限节点', '/auth/permission/add', '添加权限节点', 1, 1552030183, 6, '192.168.1.119'),
(52, 49, '编辑权限节点', '/auth/permission/edit', '编辑权限节点', 1, 1552030212, 6, '192.168.1.119'),
(53, 49, '删除权限节点', '/auth/permission/del', '删除权限节点', 1, 1552030225, 6, '192.168.1.119'),
(54, 48, '用户权限分配', '/auth/user', '用户权限分配', 1, 1552030271, 6, '192.168.1.119'),
(55, 54, '显示页面', '/auth/user/index', '显示用户列表页面', 1, 1552030383, 6, '192.168.1.119'),
(56, 54, '用户数据操作', '/auth/user/api', '用户数据操作', 1, 1552030411, 6, '192.168.1.119'),
(57, 54, '设置用户角色', '/auth/user/userrole', '设置用户角色', 1, 1552030455, 6, '192.168.1.119'),
(58, 48, '权限角色管理', '/auth/role', '权限角色管理', 1, 1552030591, 6, '192.168.1.119'),
(59, 58, '显示页面', '/auth/role/index', '显示角色列表页面', 1, 1552030647, 6, '192.168.1.119'),
(60, 58, '添加角色页面', '/auth/role/add', '添加角色', 1, 1552030685, 6, '192.168.1.119'),
(61, 58, '修改角色页面', '/auth/role/edit', '修改角色页面', 1, 1552030854, 6, '192.168.1.119'),
(62, 58, '角色数据操作', '/auth/role/api', '角色数据操作', 1, 1552030889, 6, '192.168.1.119'),
(65, 58, '分配角色权限', '/auth/role/rolepermission', '分配角色权限', 1, 1552031297, 6, '192.168.1.119'),
(67, 49, '分配权限页面', '/auth/permission/dispath', '分配权限页面', 1, 1552093401, 6, '192.168.1.119'),
(68, 0, '公司网站数据访问接口', '/api', '网站提供的数据接口', 1, 1552093561, 6, '192.168.1.119'),
(72, 68, '首页', '/api/welcome', 'welcome数据表的访问权限', 1, 1552093909, 6, '192.168.1.119'),
(73, 72, '获取', '/api/welcome/get', '获取数据', 1, 1552093924, 6, '192.168.1.119'),
(74, 72, '添加', '/api/welcome/post', '添加数据', 1, 1552093958, 6, '192.168.1.119'),
(75, 72, '修改', '/api/welcome/put', '修改数据', 1, 1552093975, 6, '192.168.1.119'),
(76, 72, '删除', '/api/welcome/delete', '删除数据', 1, 1552094020, 6, '192.168.1.119'),
(77, 68, '产品', '/api/product', 'product数据表的访问权限', 1, 1552094652, 6, '192.168.1.119'),
(78, 77, '获取', '/api/product/get', 'get', 1, 1552094722, 6, '192.168.1.119'),
(79, 77, '添加', '/api/product/post', 'post', 1, 1552094733, 6, '192.168.1.119'),
(80, 77, '修改', '/api/product/put', 'put', 1, 1552094753, 6, '192.168.1.119'),
(81, 77, '删除', '/api/product/delete', 'delete', 1, 1552094804, 6, '192.168.1.119'),
(82, 68, '新闻', '/api/news', 'news数据表的访问权限', 1, 1552094985, 6, '192.168.1.119'),
(83, 82, '获取', '/api/news/get', 'get', 1, 1552095022, 6, '192.168.1.119'),
(84, 82, '添加', '/api/news/post', 'post', 1, 1552095036, 6, '192.168.1.119'),
(85, 82, '修改', '/api/news/put', 'put', 1, 1552095061, 6, '192.168.1.119'),
(86, 82, '删除', '/api/news/delete', 'delete', 1, 1552095082, 6, '192.168.1.119'),
(87, 68, '案例', '/api/cases', 'cases', 1, 1552095498, 6, '192.168.1.119'),
(88, 87, '获取', '/api/cases/get', 'get', 1, 1552095810, 6, '192.168.1.119'),
(89, 87, '添加', '/api/cases/post', 'post', 1, 1552095826, 6, '192.168.1.119'),
(90, 87, '修改', '/api/cases/put', 'put', 1, 1552095968, 6, '192.168.1.119'),
(91, 87, '删除', '/api/cases/delete', 'delete', 1, 1552095981, 6, '192.168.1.119'),
(92, 68, '关于', '/api/about', 'about', 1, 1552096467, 6, '192.168.1.119'),
(93, 92, '获取', '/api/about/get', 'get', 1, 1552096476, 6, '192.168.1.119'),
(94, 92, '添加', '/api/about/post', 'post', 1, 1552096486, 6, '192.168.1.119'),
(95, 92, '修改', '/api/about/put', 'put', 1, 1552096496, 6, '192.168.1.119'),
(96, 92, '删除', '/api/about/delete', 'delete', 1, 1552096511, 6, '192.168.1.119'),
(97, 68, '招聘', '/api/recruitment', 'recruitment', 1, 1552096545, 6, '192.168.1.119'),
(98, 97, '获取', '/api/recruitment/get', 'get', 1, 1552096566, 6, '192.168.1.119'),
(99, 97, '添加', '/api/recruitment/post', 'post', 1, 1552096581, 6, '192.168.1.119'),
(100, 97, '修改', '/api/recruitment/put', 'put', 1, 1552096606, 6, '192.168.1.119'),
(101, 97, '删除', '/api/recruitment/delete', 'delete', 1, 1552096618, 6, '192.168.1.119'),
(102, 68, '历史', '/api/history', 'history', 1, 1552096655, 6, '192.168.1.119'),
(103, 102, '获取', '/api/history/get', 'get', 1, 1552096715, 6, '192.168.1.119'),
(104, 102, '添加', '/api/history/post', 'post', 1, 1552096726, 6, '192.168.1.119'),
(105, 102, '修改', '/api/history/put', 'put', 1, 1552096745, 6, '192.168.1.119'),
(106, 102, '删除', '/api/history/delete', 'delete', 1, 1552096779, 6, '192.168.1.119'),
(107, 0, '公司网站后台管理页面', '/home', '公司网站后台页面', 1, 1552096912, 6, '192.168.1.119'),
(108, 107, '首页', '/home/welcome', '首页修改后台页面', 1, 1552096943, 6, '192.168.1.119'),
(109, 108, '显示列表', '/home/welcome/index', '显示列表', 1, 1552096990, 6, '192.168.1.119'),
(110, 108, '添加内容', '/home/welcome/add', '添加内容', 1, 1552097017, 6, '192.168.1.119'),
(111, 108, '修改内容', '/home/welcome/edit', '修改内容', 1, 1552097083, 6, '192.168.1.119'),
(112, 107, '产品', '/home/product', '产品修改后台页面', 1, 1552097188, 6, '192.168.1.119'),
(113, 107, '新闻', '/home/news', '新闻修改后台操作页面', 1, 1552097236, 6, '192.168.1.119'),
(114, 112, '显示列表', '/home/product/index', '显示列表', 1, 1552097260, 6, '192.168.1.119'),
(115, 107, '案例', '/home/cases', '案例修改后台操作页面', 1, 1552097302, 6, '192.168.1.119'),
(116, 107, '关于', '/home/about', '关于修改后台操作页面', 1, 1552097326, 6, '192.168.1.119'),
(117, 107, '招聘', '/home/recruitment', '招聘修改后台操作页面', 1, 1552097352, 6, '192.168.1.119'),
(118, 107, '历史', '/home/history', '历史修改后台操作页面', 1, 1552097376, 6, '192.168.1.119'),
(119, 113, '显示列表', '/home/news/index', '显示列表', 1, 1552097409, 6, '192.168.1.119'),
(120, 115, '显示列表', '/home/cases/index', '显示列表', 1, 1552097419, 6, '192.168.1.119'),
(121, 116, '显示列表', '/home/about/index', '显示列表', 1, 1552097428, 6, '192.168.1.119'),
(122, 117, '显示列表', '/home/recruitment/index', '显示列表', 1, 1552097453, 6, '192.168.1.119'),
(123, 118, '显示列表', '/home/history/index', '显示列表', 1, 1552097461, 6, '192.168.1.119'),
(124, 112, '添加内容', '/home/product/add', '添加内容', 1, 1552097480, 6, '192.168.1.119'),
(125, 113, '添加内容', '/home/news/add', '添加内容', 1, 1552097486, 6, '192.168.1.119'),
(126, 115, '添加内容', '/home/cases/add', '添加内容', 1, 1552097492, 6, '192.168.1.119'),
(127, 116, '添加内容', '/home/about/add', '添加内容', 1, 1552097499, 6, '192.168.1.119'),
(128, 117, '添加内容', '/home/recruitment/add', '添加内容', 1, 1552097505, 6, '192.168.1.119'),
(129, 118, '添加内容', '/home/history/add', '添加内容', 1, 1552097513, 6, '192.168.1.119'),
(130, 112, '修改内容', '/home/product/edit', '修改内容', 1, 1552097556, 6, '192.168.1.119'),
(131, 113, '修改内容', '/home/news/edit', '修改内容', 1, 1552097562, 6, '192.168.1.119'),
(132, 115, '修改内容', '/home/cases/edit', '修改内容', 1, 1552097569, 6, '192.168.1.119'),
(133, 116, '修改内容', '/home/about/edit', '修改内容', 1, 1552097577, 6, '192.168.1.119'),
(134, 117, '修改内容', '/home/recruitment/edit', '修改内容', 1, 1552097584, 6, '192.168.1.119'),
(135, 118, '修改内容', '/home/history/edit', '修改内容', 1, 1552097592, 6, '192.168.1.119');

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
  `status` int(11) NOT NULL DEFAULT '1',
  `iconurl` varchar(255) NOT NULL,
  `remark` text,
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_product`
--

INSERT INTO `fly_product` (`productId`, `imageurl`, `productSort`, `productTitle`, `productDetail`, `status`, `iconurl`, `remark`, `edittime`, `userid`, `ip`) VALUES
(2, 'http://127.0.0.1/uiweb/uploads/23/e3cf886844a7287f16c2583dbef583.jpg', 1, '核心板', '核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板核心板', 1, '/uiweb/uploads/21/911649e1292399373950dfa2b9acbf.png', '', '2019-03-01 06:21:46', 0, '192.168.1.119'),
(3, 'http://127.0.0.1/uiweb/uploads/13/f8d257805c7dfe62baa69adc8eaaea.jpg', 2, '一体板', '一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板一体板', 1, '/uiweb/uploads/30/c3804c8eeb10fc1021e76a62ebb609.png', '', '2019-03-11 06:05:43', 6, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_recruitment`
--

CREATE TABLE `fly_recruitment` (
  `recruitmentId` int(11) NOT NULL,
  `recruitmentTitle` varchar(255) NOT NULL,
  `recruitmentText` text NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `remark` text,
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) NOT NULL,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_recruitment`
--

INSERT INTO `fly_recruitment` (`recruitmentId`, `recruitmentTitle`, `recruitmentText`, `status`, `remark`, `edittime`, `userid`, `ip`) VALUES
(1, 'JAVA 工程师', '1、前端开发及维护工作；\r\n2、有良好的技术基础，熟悉 Web 标准，熟练掌握多种 Web 驾驶技术；\r\n3、掌握行业内流行的类库，Vue.js， React 等主流框架；\r\n4、参与公司驾驶工程的设计、研发；\r\n5、了解不同浏览器之间的差异，移动设备之间的差异。', 1, NULL, '2019-02-23 01:22:19', 0, '192.168.1.119'),
(2, '前端工程师', '1、前端开发及维护工作；\r\n 2、有良好的技术基础，熟悉 Web 标准，熟练掌握多种 Web 驾驶技术； \r\n3、掌握行业内流行的类库，Vue.js， React 等主流框架；\r\n 4、参与公司驾驶工程的设计、研发； \r\n5、了解不同浏览器之间的差异，移动设备之间的差异。', 1, NULL, '2019-03-11 06:06:04', 0, '192.168.1.119');

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
  `level` int(11) NOT NULL DEFAULT '0' COMMENT '所处层级',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ip` varchar(20) NOT NULL,
  `userid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

--
-- 转存表中的数据 `fly_role`
--

INSERT INTO `fly_role` (`id`, `name`, `parent_id`, `description`, `status`, `sort_num`, `left_key`, `right_key`, `level`, `createtime`, `ip`, `userid`) VALUES
(3, '系统管理员', 0, '系统管理员，拥有所有权限。', 1, 0, 13, 14, 1, '2019-03-06 07:24:27', '192.168.1.119', 6),
(8, '公司网站管理员', 0, '负责公司网站内容的修改和编辑', 1, 0, 1, 2, 1, '2019-03-09 02:51:12', '192.168.1.119', 6);

-- --------------------------------------------------------

--
-- 表的结构 `fly_role_permission`
--

CREATE TABLE `fly_role_permission` (
  `id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色Id',
  `permission_id` int(11) NOT NULL DEFAULT '0' COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限对应表';

--
-- 转存表中的数据 `fly_role_permission`
--

INSERT INTO `fly_role_permission` (`id`, `role_id`, `permission_id`) VALUES
(292, 3, 48),
(293, 3, 49),
(294, 3, 50),
(295, 3, 51),
(296, 3, 52),
(297, 3, 53),
(298, 3, 67),
(299, 3, 54),
(300, 3, 55),
(301, 3, 56),
(302, 3, 57),
(303, 3, 58),
(304, 3, 59),
(305, 3, 60),
(306, 3, 61),
(307, 3, 62),
(308, 3, 65),
(309, 3, 68),
(310, 3, 72),
(311, 3, 73),
(312, 3, 74),
(313, 3, 75),
(314, 3, 76),
(315, 3, 77),
(316, 3, 78),
(317, 3, 79),
(318, 3, 80),
(319, 3, 81),
(320, 3, 82),
(321, 3, 83),
(322, 3, 84),
(323, 3, 85),
(324, 3, 86),
(325, 3, 87),
(326, 3, 88),
(327, 3, 89),
(328, 3, 90),
(329, 3, 91),
(330, 3, 92),
(331, 3, 93),
(332, 3, 94),
(333, 3, 95),
(334, 3, 96),
(335, 3, 97),
(336, 3, 98),
(337, 3, 99),
(338, 3, 100),
(339, 3, 101),
(340, 3, 102),
(341, 3, 103),
(342, 3, 104),
(343, 3, 105),
(344, 3, 106),
(345, 3, 107),
(346, 3, 108),
(347, 3, 109),
(348, 3, 110),
(349, 3, 111),
(350, 3, 112),
(351, 3, 114),
(352, 3, 124),
(353, 3, 130),
(354, 3, 113),
(355, 3, 119),
(356, 3, 125),
(357, 3, 131),
(358, 3, 115),
(359, 3, 120),
(360, 3, 126),
(361, 3, 132),
(362, 3, 116),
(363, 3, 121),
(364, 3, 127),
(365, 3, 133),
(366, 3, 117),
(367, 3, 122),
(368, 3, 128),
(369, 3, 134),
(370, 3, 118),
(371, 3, 123),
(372, 3, 129),
(373, 3, 135),
(374, 8, 68),
(375, 8, 72),
(376, 8, 73),
(377, 8, 74),
(378, 8, 75),
(379, 8, 76),
(380, 8, 77),
(381, 8, 78),
(382, 8, 79),
(383, 8, 80),
(384, 8, 81),
(385, 8, 82),
(386, 8, 83),
(387, 8, 84),
(388, 8, 85),
(389, 8, 86),
(390, 8, 87),
(391, 8, 88),
(392, 8, 89),
(393, 8, 90),
(394, 8, 91),
(395, 8, 92),
(396, 8, 93),
(397, 8, 94),
(398, 8, 95),
(399, 8, 96),
(400, 8, 97),
(401, 8, 98),
(402, 8, 99),
(403, 8, 100),
(404, 8, 101),
(405, 8, 102),
(406, 8, 103),
(407, 8, 104),
(408, 8, 105),
(409, 8, 106),
(410, 8, 107),
(411, 8, 108),
(412, 8, 109),
(413, 8, 110),
(414, 8, 111),
(415, 8, 112),
(416, 8, 114),
(417, 8, 124),
(418, 8, 130),
(419, 8, 113),
(420, 8, 119),
(421, 8, 125),
(422, 8, 131),
(423, 8, 115),
(424, 8, 120),
(425, 8, 126),
(426, 8, 132),
(427, 8, 116),
(428, 8, 121),
(429, 8, 127),
(430, 8, 133),
(431, 8, 117),
(432, 8, 122),
(433, 8, 128),
(434, 8, 134),
(435, 8, 118),
(436, 8, 123),
(437, 8, 129),
(438, 8, 135);

-- --------------------------------------------------------

--
-- 表的结构 `fly_subcell`
--

CREATE TABLE `fly_subcell` (
  `subcellId` int(11) NOT NULL COMMENT '主键，自动递增',
  `cellId` int(11) NOT NULL COMMENT '关联组件ID',
  `description` varchar(255) DEFAULT NULL COMMENT '组件描述，方便查找搜索',
  `themeId` int(11) NOT NULL COMMENT '关联模板ID',
  `celltypeId` int(11) NOT NULL COMMENT '组件类型',
  `resId` int(11) DEFAULT NULL COMMENT '资源ＩＤ',
  `width` int(11) NOT NULL COMMENT '宽度',
  `height` int(11) NOT NULL COMMENT '高度',
  `backColor` varchar(9) DEFAULT NULL COMMENT '背景颜色',
  `filterColor` varchar(9) DEFAULT NULL COMMENT '过滤颜色',
  `recv` varchar(1024) DEFAULT NULL COMMENT '接收数据（ＪＳＯＮ）',
  `send` varchar(1024) DEFAULT NULL COMMENT '发送数据（ＪＳＯＮ）',
  `texts` text COMMENT '包含文字（ＪＳＯＮ）',
  `images` text COMMENT '包含图片（ＪＳＯＮ）',
  `pages` text COMMENT '包含页面（ＪＳＯＮ）',
  `remark` text COMMENT '备注',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `userid` int(11) NOT NULL COMMENT '用户ID',
  `uptime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `ip` varchar(15) NOT NULL COMMENT 'ＩＰ地址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_subcell`
--

INSERT INTO `fly_subcell` (`subcellId`, `cellId`, `description`, `themeId`, `celltypeId`, `resId`, `width`, `height`, `backColor`, `filterColor`, `recv`, `send`, `texts`, `images`, `pages`, `remark`, `status`, `userid`, `uptime`, `ip`) VALUES
(5, 163, '', 5, 1, 0, 0, 0, '', '', '', '', '[]', '[{\"width\":0,\"height\":0,\"url\":\"\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-05-27 05:51:33', '192.168.1.119'),
(6, 235, '', 1, 1, 0, 526, 70, '', '', '', '', '[]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/b2\\/e5856d0fe6336f7488ab94d194acd4.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-13 07:58:02', '192.168.1.119'),
(7, 226, '', 1, 1, 0, 526, 70, '', '', '', '', '[]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/98\\/f09b5a6f0f15797f266508be5459a3.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 07:57:53', '192.168.1.119'),
(8, 227, '', 1, 1, 0, 526, 70, '', '', '', '', '[]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/74\\/e98d8b0c4a87f3e3a863222d98550a.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 07:58:06', '192.168.1.119'),
(9, 228, '', 1, 1, 0, 526, 70, '', '', '', '', '[]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/6e\\/c9fa4a6732c452d1642efe7526135e.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 07:58:18', '192.168.1.119'),
(10, 229, '', 1, 1, 0, 526, 70, '', '', '', '', '[]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c8\\/a09169653f1cfef31b7f05bf9f7610.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 07:58:29', '192.168.1.119'),
(11, 230, '', 1, 1, 0, 526, 70, '', '', '', '', '[]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/54\\/3bbc5f8504eb3ffa987810f3b44b54.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 07:58:42', '192.168.1.119'),
(12, 231, '', 1, 1, 0, 526, 70, '', '', '', '', '[]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/e0\\/5b0a9cae14f6d1044918c8ce3458b4.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 07:59:00', '192.168.1.119'),
(13, 232, '', 1, 1, 0, 526, 70, '', '', '', '', '[]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/04\\/7b5bdf8a8f592996f1fd6648a98068.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 07:59:10', '192.168.1.119'),
(14, 233, '', 1, 1, 0, 526, 70, '', '', '', '', '[]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/0b\\/597ff5bfe00493199311cd483727be.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 07:59:21', '192.168.1.119'),
(15, 234, '', 1, 1, 0, 526, 70, '', '', '', '', '[]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/54\\/203fac7e3e12060f18376ea216a9ae.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 07:59:32', '192.168.1.119'),
(16, 224, '', 1, 1, 0, 102, 60, '', '', '', '', '[]', '[{\"width\":102,\"height\":60,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f6\\/ce1d679d5956b4a9c5d94e9a1f8ef0.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:02:09', '192.168.1.119'),
(18, 223, '', 1, 1, 0, 102, 60, '', '', '', '', '[]', '[{\"width\":102,\"height\":60,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/04\\/6c8102096c054ded4c8d603e132179.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-12 08:02:54', '192.168.1.119'),
(21, 238, '', 1, 1, 0, 526, 70, '', '', '', '', '[]', '[{\"width\":526,\"height\":70,\"url\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/e8\\/dc62ebddac54599bd10e5192b06163.png\",\"filterColor\":\"\",\"left\":0,\"top\":0,\"right\":0,\"bottom\":0,\"scaleType\":0,\"shapeType\":0,\"recv\":null,\"send\":null}]', '[]', '', 1, 6, '2019-06-13 09:54:26', '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_theme`
--

CREATE TABLE `fly_theme` (
  `themeId` int(11) NOT NULL COMMENT '主键，自动递增',
  `themeName` varchar(255) NOT NULL COMMENT '模板名称',
  `themeType` int(11) NOT NULL DEFAULT '0' COMMENT '模板类型',
  `screenWidth` int(11) NOT NULL COMMENT '屏幕宽度',
  `screenHeight` int(11) NOT NULL COMMENT '屏幕高度',
  `left` int(11) NOT NULL DEFAULT '0' COMMENT '左边间距',
  `top` int(11) NOT NULL DEFAULT '0' COMMENT '顶部间距',
  `right` int(11) NOT NULL DEFAULT '0' COMMENT '右边间距',
  `bottom` int(11) NOT NULL DEFAULT '0' COMMENT '底部间距',
  `imageurl` varchar(255) DEFAULT NULL COMMENT '背景图片地址',
  `exampleurl` varchar(1024) DEFAULT NULL COMMENT '模板展示图片地址',
  `backcolor` varchar(9) DEFAULT NULL COMMENT '背景颜色',
  `isMirror` tinyint(1) NOT NULL COMMENT '子控件是否显示镜像',
  `animType` int(11) NOT NULL COMMENT '页面切换动画',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '数据状态',
  `remark` text COMMENT '备注',
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `userid` int(11) NOT NULL COMMENT '用户ＩＤ',
  `ip` varchar(20) NOT NULL COMMENT 'ＩＰ地址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_theme`
--

INSERT INTO `fly_theme` (`themeId`, `themeName`, `themeType`, `screenWidth`, `screenHeight`, `left`, `top`, `right`, `bottom`, `imageurl`, `exampleurl`, `backcolor`, `isMirror`, `animType`, `status`, `remark`, `edittime`, `userid`, `ip`) VALUES
(1, 'TEST', 0, 1024, 600, 0, 0, 0, 0, 'http://127.0.0.1/uiweb/uploads/ab/28e5638d06162e861e06623f205887.png', 'http://127.0.0.1/uiweb/uploads/ab/28e5638d06162e861e06623f205887.png', '', 0, 0, 1, '', '2019-05-28 01:24:25', 6, '192.168.1.119'),
(5, 'Launcher-AP1', 0, 1024, 600, 0, 0, 1024, 600, 'http://127.0.0.1/uiweb/uploads/5d/2f2c0d98a61327de56237b6f6da25c.png', 'http://127.0.0.1/uiweb/uploads/82/d522d13cc3cc511587dbeafb9c9d3e.png', '', 1, 1, 1, '', '2019-06-17 02:41:25', 6, '192.168.1.119'),
(6, 'Launcher-AP2', 0, 1024, 600, 0, 0, 0, 0, 'http://127.0.0.1/uiweb/uploads/5d/2f2c0d98a61327de56237b6f6da25c.png', 'http://127.0.0.1/uiweb/uploads/ae/821f0e4be5205eaac49ffbbdc9de59.png', '', 0, 0, 1, '', '2019-06-11 09:54:25', 6, '192.168.1.119'),
(7, 'Launcher-AP3', 0, 1024, 600, 0, 0, 1024, 600, 'http://127.0.0.1/uiweb/uploads/f8/fc65ab56c952ebccd91be18b9a2d06.png', 'http://127.0.0.1/uiweb/uploads/65/580a5dc97c7ef0e6593fdc93d6f484.png', '', 1, 1, 1, '', '2019-06-17 02:41:31', 6, '192.168.1.119'),
(12, 'Launcher-AP4', 0, 1024, 600, 0, 0, 1024, 600, 'http://127.0.0.1/uiweb/uploads/cf/a58b71a904c624fea7c85c670eba4a.png', 'http://127.0.0.1/uiweb/uploads/c9/dcb1202c2b78ffd528100492520875.png', '', 0, 0, 1, '', '2019-05-27 08:00:19', 6, '192.168.1.119'),
(13, 'Launcher-AP5', 0, 1024, 600, 296, 0, 1024, 600, 'http://127.0.0.1/uiweb/uploads/2f/e2f98c6ff84f553cc7c7079b721ad1.png', 'http://127.0.0.1/uiweb/uploads/dd/b5de46782680c61408d1f636a6071b.png', '', 0, 2, 1, '', '2019-05-27 08:00:33', 6, '192.168.1.119'),
(14, 'Launcher-AP6', 0, 1024, 600, 0, 0, 1024, 600, 'http://127.0.0.1/uiweb/uploads/d3/b3bb3a1a9a2ae08b6585c8512d769b.png', 'http://127.0.0.1/uiweb/uploads/3b/5179a874a1801a6ce396748b34dada.png', '', 0, 0, 1, '', '2019-05-27 08:00:51', 6, '192.168.1.119'),
(18, 'Launcher-AP7', 0, 1024, 600, 0, 0, 0, 0, 'http://127.0.0.1/uiweb/uploads/42/e1f50a04f3daaa87b24d9883631db4.png', 'http://127.0.0.1/uiweb/uploads/56/074b95be1f77e433c4ba41203a21fc.png', '', 0, 1, 1, '', '2019-05-27 08:01:06', 6, '192.168.1.119'),
(19, 'Launcher-AP8', 0, 1024, 600, 0, 0, 0, 0, 'http://127.0.0.1/uiweb/uploads/b5/59862e979e64f7f54db8d27ad7ea81.png', 'http://127.0.0.1/uiweb/uploads/57/8e8c6520a478538e222bc128117a1b.png', '', 0, 0, 1, '', '2019-05-27 08:01:18', 6, '192.168.1.119'),
(20, 'Launcher-AP9', 0, 1024, 600, 0, 0, 0, 0, 'http://127.0.0.1/uiweb/uploads/5d/2f2c0d98a61327de56237b6f6da25c.png', 'http://127.0.0.1/uiweb/uploads/c4/2d9a6784290bc820e72ae90ce7865d.png', '', 0, 1, 1, '', '2019-06-17 02:39:22', 6, '192.168.1.119'),
(23, 'Music-AP1', 0, 1024, 600, 0, 0, 0, 0, 'http://127.0.0.1/uiweb/uploads/80/f3c8538b73e67ef1fb92d01aa14e35.png', '', '', 0, 0, 1, '', '2019-06-03 03:27:16', 6, '192.168.1.119'),
(24, 'Photo-AP1', 0, 1024, 600, 0, 0, 0, 0, '', '', '', 0, 0, 1, '', '2019-06-03 08:29:57', 6, '192.168.1.119'),
(25, 'Video-AP1', 0, 1024, 600, 0, 0, 0, 0, '', '', '', 0, 0, 1, '', '2019-06-05 00:26:36', 6, '192.168.1.119'),
(26, 'Launcher-APA', 0, 800, 480, 0, 0, 0, 0, 'http://127.0.0.1/uiweb/uploads/d5/3f2745a83a7f4ea7278568652b21d7.png', 'http://127.0.0.1/uiweb/uploads/d8/c1c2437852ea84238fe05bbd28c287.png', '', 0, 3, 1, '', '2019-06-17 02:40:26', 6, '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_themepage`
--

CREATE TABLE `fly_themepage` (
  `id` int(11) NOT NULL COMMENT '主键，自动递增',
  `themeId` int(11) NOT NULL COMMENT '关联模板ＩＤ',
  `pageId` int(11) NOT NULL COMMENT '关联页面ＩＤ'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_themepage`
--

INSERT INTO `fly_themepage` (`id`, `themeId`, `pageId`) VALUES
(12, 12, 11),
(13, 13, 12),
(14, 13, 13),
(26, 7, 8),
(27, 7, 9),
(30, 14, 14),
(140, 15, 28),
(155, 16, 35),
(179, 17, 39),
(333, 19, 46),
(384, 18, 45),
(391, 22, 49),
(393, 6, 49),
(397, 1, 44),
(398, 23, 50),
(399, 20, 47),
(400, 20, 51),
(402, 24, 52),
(403, 25, 53),
(411, 26, 54),
(412, 26, 56),
(413, 26, 55),
(414, 5, 5),
(415, 5, 6),
(416, 5, 7),
(417, 5, 8),
(418, 5, 9),
(419, 5, 11),
(420, 5, 12),
(421, 5, 13),
(422, 5, 14);

-- --------------------------------------------------------

--
-- 表的结构 `fly_themetopcell`
--

CREATE TABLE `fly_themetopcell` (
  `id` int(11) NOT NULL COMMENT '主键，自动递增',
  `pageId` int(11) NOT NULL COMMENT '关联页面ＩＤ',
  `cellId` int(11) NOT NULL COMMENT '关联组件ＩＤ',
  `x` int(11) NOT NULL COMMENT 'ｘ坐标',
  `y` int(11) NOT NULL COMMENT 'ｙ坐标',
  `width` int(11) NOT NULL COMMENT '宽度',
  `height` int(11) NOT NULL COMMENT '高度'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_themetopcell`
--

INSERT INTO `fly_themetopcell` (`id`, `pageId`, `cellId`, `x`, `y`, `width`, `height`) VALUES
(12, 7, 78, 0, 560, 1024, 16),
(21, 13, 78, 0, 560, 1024, 16),
(22, 13, 46, 25, 65, 380, 500),
(24, 6, 170, 459, 420, 106, 168),
(25, 6, 171, 259, 420, 106, 168),
(26, 6, 167, 59, 420, 106, 168),
(27, 6, 169, 659, 420, 106, 168),
(28, 6, 170, 859, 420, 106, 168),
(73, 26, 222, 0, 0, 292, 480),
(74, 26, 221, 163, 0, 116, 480),
(75, 26, 237, 5, 135, 196, 206),
(76, 26, 225, 0, 0, 200, 480),
(77, 5, 78, 0, 560, 1024, 16),
(78, 5, 237, 403, 144, 196, 206);

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
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

--
-- 转存表中的数据 `fly_user`
--

INSERT INTO `fly_user` (`id`, `user_name`, `password`, `mobile`, `email`, `last_login_time`, `status`, `createtime`, `ip`) VALUES
(5, 'flyzebra', '10e208ffd957f5488f795e555f483af8', '13612121212', '1@qq.com', 1551762134, 1, '0000-00-00 00:00:00', '192.168.1.119'),
(6, 'admin', 'c3284d0f94606de1fd2af172aba15bf3', '13111111111', '2@qq.com', 1551762435, 1, '0000-00-00 00:00:00', '192.168.1.119'),
(7, 'jancar', '10e208ffd957f5488f795e555f483af8', '13111111111', '3@qq.com', 1552028100, 1, '2019-03-08 06:55:00', '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_user_log`
--

CREATE TABLE `fly_user_log` (
  `id` int(11) NOT NULL COMMENT '主键，自动递增',
  `userid` int(11) NOT NULL COMMENT '用户ＩＤ',
  `event` varchar(255) NOT NULL COMMENT '事件',
  `tableName` text NOT NULL COMMENT '表名',
  `data` text NOT NULL COMMENT '数据',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ip` varchar(20) NOT NULL COMMENT 'ＩＰ地址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_user_log`
--

INSERT INTO `fly_user_log` (`id`, `userid`, `event`, `tableName`, `data`, `createtime`, `ip`) VALUES
(1, 6, 'del', 'subcell', '3', '2019-06-12 08:12:14', '192.168.1.119'),
(2, 6, 'edit', 'cell', '{\"cellId\":\"16\",\"description\":\"\\u6536\\u97f3\\u673a\",\"themeId\":5,\"celltypeId\":1,\"resId\":0,\"width\":212,\"height\":317,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"{\\\"packName\\\":\\\"com.jancar.radios\\\",\\\"className\\\":\\\"com.jancar.radio.RadioActivity\\\"}\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u6536\\\\u97f3\\\\u673a\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":2,\\\"textColor\\\":\\\"\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":237,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"images\":\"[{\\\"width\\\":212,\\\"height\\\":317,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/0f\\\\\\/87821bfe4d2ceed787c0b7f4520ae3.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-12 08:12:14', '192.168.1.119'),
(3, 6, 'login', '', '', '2019-06-13 02:13:40', '192.168.1.119'),
(4, 6, 'login', '', '', '2019-06-13 07:30:56', '192.168.1.119'),
(5, 6, 'edit', 'theme', '{\"themeName\":\"Launcher-AP1\",\"isMirror\":\"1\",\"animType\":\"1\",\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/5d\\/2f2c0d98a61327de56237b6f6da25c.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/82\\/d522d13cc3cc511587dbeafb9c9d3e.png\",\"screenWidth\":\"1024\",\"screenHeight\":\"600\",\"backcolor\":\"\",\"left\":\"0\",\"top\":\"0\",\"right\":\"1024\",\"bottom\":\"600\",\"remark\":\"\",\"themeId\":\"5\",\"ip\":\"192.168.1.119\",\"userid\":6}', '2019-06-13 07:38:30', '192.168.1.119'),
(6, 6, 'login', '', '', '2019-06-13 07:56:09', '192.168.1.119'),
(7, 6, 'edit', 'subcell', '{\"cellId\":\"235\",\"subcellId\":\"6\",\"description\":\"\",\"themeId\":1,\"celltypeId\":1,\"resId\":0,\"width\":526,\"height\":70,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":526,\\\"height\\\":70,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/b2\\\\\\/e5856d0fe6336f7488ab94d194acd4.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-13 07:58:02', '192.168.1.119'),
(8, 6, 'edit', 'cell', '{\"cellId\":\"235\",\"description\":\"\\u5e94\\u7528\",\"themeId\":26,\"celltypeId\":1,\"resId\":0,\"width\":526,\"height\":70,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"{\\\"packName\\\":\\\"com.android.launcher3\\\"}\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u5e94\\\\u7528\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#000000\\\",\\\"textFilter\\\":\\\"#FFFFFF\\\",\\\"left\\\":276,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":3,\\\"recv\\\":null,\\\"send\\\":null}]\",\"images\":\"[{\\\"width\\\":526,\\\"height\\\":70,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/d0\\\\\\/698c994b2478d3e66c303b4029b864.png\\\",\\\"filterColor\\\":\\\"#7F000000\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-13 07:58:03', '192.168.1.119'),
(9, 6, 'edit', 'theme', '{\"themeName\":\"Launcher-APA\",\"isMirror\":\"0\",\"animType\":\"3\",\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d5\\/3f2745a83a7f4ea7278568652b21d7.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d2\\/180b6539db47e6e8609786444356c1.png\",\"screenWidth\":\"800\",\"screenHeight\":\"480\",\"backcolor\":\"\",\"left\":\"0\",\"top\":\"0\",\"right\":\"0\",\"bottom\":\"0\",\"remark\":\"\",\"themeId\":\"26\",\"ip\":\"192.168.1.119\",\"userid\":6}', '2019-06-13 09:51:31', '192.168.1.119'),
(10, 6, 'add', 'cell', '{\"description\":\"\",\"themeId\":1,\"celltypeId\":1,\"resId\":0,\"width\":196,\"height\":206,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":196,\\\"height\\\":206,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/6a\\\\\\/5548b0f46b5734fecff1f87fd06ee1.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\",\"cellId\":\"237\"}', '2019-06-13 09:51:55', '192.168.1.119'),
(11, 6, 'add', 'subcell', '{\"description\":\"\",\"themeId\":1,\"celltypeId\":1,\"resId\":0,\"width\":526,\"height\":70,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":526,\\\"height\\\":70,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/e8\\\\\\/dc62ebddac54599bd10e5192b06163.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\",\"cellId\":\"238\"}', '2019-06-13 09:54:18', '192.168.1.119'),
(12, 6, 'edit', 'cell', '{\"cellId\":\"238\",\"description\":\"\\u8bbe\\u7f6e\",\"themeId\":26,\"celltypeId\":1,\"resId\":0,\"width\":526,\"height\":70,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"{\\\"packName\\\":\\\"com.android.launcher3\\\"}\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u8bbe\\\\u7f6e\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#000000\\\",\\\"textFilter\\\":\\\"#FFFFFF\\\",\\\"left\\\":276,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":3,\\\"recv\\\":null,\\\"send\\\":null}]\",\"images\":\"[{\\\"width\\\":526,\\\"height\\\":70,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/fe\\\\\\/53f6ae6a03a50e1c5ff8c74d8505b1.png\\\",\\\"filterColor\\\":\\\"#7F000000\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-13 09:54:18', '192.168.1.119'),
(13, 6, 'del', 'subcell', '19', '2019-06-13 09:54:25', '192.168.1.119'),
(14, 6, 'add', 'subcell', '{\"description\":\"\",\"themeId\":1,\"celltypeId\":1,\"resId\":0,\"width\":526,\"height\":70,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":526,\\\"height\\\":70,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/e8\\\\\\/dc62ebddac54599bd10e5192b06163.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\",\"cellId\":\"238\"}', '2019-06-13 09:54:25', '192.168.1.119'),
(15, 6, 'edit', 'cell', '{\"cellId\":\"238\",\"description\":\"\\u8bbe\\u7f6e\",\"themeId\":26,\"celltypeId\":1,\"resId\":0,\"width\":526,\"height\":70,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"{\\\"packName\\\":\\\"com.android.setttings\\\"}\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u8bbe\\\\u7f6e\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#000000\\\",\\\"textFilter\\\":\\\"#FFFFFF\\\",\\\"left\\\":276,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":3,\\\"recv\\\":null,\\\"send\\\":null}]\",\"images\":\"[{\\\"width\\\":526,\\\"height\\\":70,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/fe\\\\\\/53f6ae6a03a50e1c5ff8c74d8505b1.png\\\",\\\"filterColor\\\":\\\"#7F000000\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-13 09:54:25', '192.168.1.119'),
(16, 6, 'del', 'subcell', '20', '2019-06-13 09:54:26', '192.168.1.119'),
(17, 6, 'add', 'subcell', '{\"description\":\"\",\"themeId\":1,\"celltypeId\":1,\"resId\":0,\"width\":526,\"height\":70,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":526,\\\"height\\\":70,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/e8\\\\\\/dc62ebddac54599bd10e5192b06163.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\",\"cellId\":\"238\"}', '2019-06-13 09:54:26', '192.168.1.119'),
(18, 6, 'edit', 'cell', '{\"cellId\":\"238\",\"description\":\"\\u8bbe\\u7f6e\",\"themeId\":26,\"celltypeId\":1,\"resId\":0,\"width\":526,\"height\":70,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"{\\\"packName\\\":\\\"com.android.setttings\\\"}\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u8bbe\\\\u7f6e\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#000000\\\",\\\"textFilter\\\":\\\"#FFFFFF\\\",\\\"left\\\":276,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":3,\\\"recv\\\":null,\\\"send\\\":null}]\",\"images\":\"[{\\\"width\\\":526,\\\"height\\\":70,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/fe\\\\\\/53f6ae6a03a50e1c5ff8c74d8505b1.png\\\",\\\"filterColor\\\":\\\"#7F000000\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-13 09:54:26', '192.168.1.119'),
(19, 6, 'error', 'subcell', '0', '2019-06-13 09:55:24', '192.168.1.119'),
(20, 6, 'edit', 'cell', '{\"cellId\":\"236\",\"description\":\"\",\"themeId\":26,\"celltypeId\":1,\"resId\":0,\"width\":526,\"height\":70,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"WELCOME  TO  VW\\\\\\\"}\\\",\\\"textSize\\\":40,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"images\":\"[]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-13 09:55:24', '192.168.1.119'),
(21, 6, 'error', 'subcell', '0', '2019-06-13 09:55:26', '192.168.1.119'),
(22, 6, 'edit', 'cell', '{\"cellId\":\"236\",\"description\":\"\",\"themeId\":26,\"celltypeId\":1,\"resId\":0,\"width\":526,\"height\":70,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"WELCOME  TO  VW\\\\\\\"}\\\",\\\"textSize\\\":40,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"images\":\"[]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-13 09:55:26', '192.168.1.119'),
(23, 6, 'error', 'subcell', '0', '2019-06-13 09:58:31', '192.168.1.119'),
(24, 6, 'edit', 'cell', '{\"cellId\":\"225\",\"description\":\"APA\\u65e5\\u671f\\u63a7\\u4ef6\",\"themeId\":26,\"celltypeId\":4,\"resId\":0,\"width\":200,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"18:00\\\\\\\"}\\\",\\\"textSize\\\":48,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":300,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100101\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"2019-01-01\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":100,\\\"right\\\":0,\\\"bottom\\\":280,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100103\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u661f\\\\u671f\\\\u4e00\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":50,\\\"right\\\":0,\\\"bottom\\\":280,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100102\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u4e0b\\\\u5348\\\\\\\"}\\\",\\\"textSize\\\":12,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":10,\\\"top\\\":0,\\\"right\\\":10,\\\"bottom\\\":380,\\\"gravity\\\":1,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100104\\\\\\\"}\\\",\\\"send\\\":null}]\",\"images\":\"[]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-13 09:58:31', '192.168.1.119'),
(25, 6, 'error', 'subcell', '0', '2019-06-13 09:59:59', '192.168.1.119'),
(26, 6, 'edit', 'cell', '{\"cellId\":\"225\",\"description\":\"APA\\u65e5\\u671f\\u63a7\\u4ef6\",\"themeId\":26,\"celltypeId\":4,\"resId\":0,\"width\":200,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"18:00\\\\\\\"}\\\",\\\"textSize\\\":48,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":300,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100101\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"2019-01-01\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":50,\\\"right\\\":0,\\\"bottom\\\":330,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100103\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u661f\\\\u671f\\\\u4e00\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":430,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100102\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u4e0b\\\\u5348\\\\\\\"}\\\",\\\"textSize\\\":12,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":10,\\\"top\\\":0,\\\"right\\\":10,\\\"bottom\\\":380,\\\"gravity\\\":1,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100104\\\\\\\"}\\\",\\\"send\\\":null}]\",\"images\":\"[]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-13 09:59:59', '192.168.1.119'),
(27, 6, 'login', '', '', '2019-06-14 00:43:27', '192.168.1.119'),
(28, 6, 'error', 'subcell', '0', '2019-06-14 00:43:48', '192.168.1.119'),
(29, 6, 'edit', 'cell', '{\"cellId\":\"237\",\"description\":\"\",\"themeId\":26,\"celltypeId\":1,\"resId\":0,\"width\":196,\"height\":206,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":196,\\\"height\\\":206,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/6a\\\\\\/5548b0f46b5734fecff1f87fd06ee1.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-14 00:43:48', '192.168.1.119'),
(30, 6, 'error', 'subcell', '0', '2019-06-14 00:46:12', '192.168.1.119'),
(31, 6, 'edit', 'cell', '{\"cellId\":\"225\",\"description\":\"APA\\u65e5\\u671f\\u63a7\\u4ef6\",\"themeId\":26,\"celltypeId\":4,\"resId\":0,\"width\":200,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"18:00\\\\\\\"}\\\",\\\"textSize\\\":48,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":300,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100101\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u661f\\\\u671f\\\\u4e00\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":60,\\\"right\\\":0,\\\"bottom\\\":380,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100103\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u661f\\\\u671f\\\\u4e00\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":430,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100102\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u4e0b\\\\u5348\\\\\\\"}\\\",\\\"textSize\\\":12,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":30,\\\"top\\\":70,\\\"right\\\":30,\\\"bottom\\\":380,\\\"gravity\\\":1,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100104\\\\\\\"}\\\",\\\"send\\\":null}]\",\"images\":\"[]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-14 00:46:14', '192.168.1.119'),
(32, 6, 'error', 'subcell', '0', '2019-06-14 00:46:20', '192.168.1.119'),
(33, 6, 'edit', 'cell', '{\"cellId\":\"225\",\"description\":\"APA\\u65e5\\u671f\\u63a7\\u4ef6\",\"themeId\":26,\"celltypeId\":4,\"resId\":0,\"width\":200,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"18:00\\\\\\\"}\\\",\\\"textSize\\\":48,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":300,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100101\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u661f\\\\u671f\\\\u4e00\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":60,\\\"right\\\":0,\\\"bottom\\\":380,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100103\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"2019-01-01\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":430,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100102\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u4e0b\\\\u5348\\\\\\\"}\\\",\\\"textSize\\\":12,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":30,\\\"top\\\":70,\\\"right\\\":30,\\\"bottom\\\":380,\\\"gravity\\\":1,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100104\\\\\\\"}\\\",\\\"send\\\":null}]\",\"images\":\"[]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-14 00:46:20', '192.168.1.119'),
(34, 6, 'error', 'subcell', '0', '2019-06-14 00:46:44', '192.168.1.119'),
(35, 6, 'edit', 'cell', '{\"cellId\":\"225\",\"description\":\"APA\\u65e5\\u671f\\u63a7\\u4ef6\",\"themeId\":26,\"celltypeId\":4,\"resId\":0,\"width\":200,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"18:00\\\\\\\"}\\\",\\\"textSize\\\":48,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":300,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100101\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u661f\\\\u671f\\\\u4e00\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":60,\\\"right\\\":0,\\\"bottom\\\":380,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100103\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"2019-01-01\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":100,\\\"right\\\":0,\\\"bottom\\\":330,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100102\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u4e0b\\\\u5348\\\\\\\"}\\\",\\\"textSize\\\":12,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":30,\\\"top\\\":70,\\\"right\\\":30,\\\"bottom\\\":380,\\\"gravity\\\":1,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100104\\\\\\\"}\\\",\\\"send\\\":null}]\",\"images\":\"[]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-14 00:46:45', '192.168.1.119'),
(36, 6, 'error', 'subcell', '0', '2019-06-14 00:47:35', '192.168.1.119'),
(37, 6, 'edit', 'cell', '{\"cellId\":\"225\",\"description\":\"APA\\u65e5\\u671f\\u63a7\\u4ef6\",\"themeId\":26,\"celltypeId\":4,\"resId\":0,\"width\":200,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"18:00\\\\\\\"}\\\",\\\"textSize\\\":48,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":300,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100101\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u661f\\\\u671f\\\\u4e00\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":60,\\\"right\\\":0,\\\"bottom\\\":380,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100103\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"2019-01-01\\\\\\\"}\\\",\\\"textSize\\\":24,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":90,\\\"right\\\":0,\\\"bottom\\\":340,\\\"gravity\\\":0,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100102\\\\\\\"}\\\",\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u4e0b\\\\u5348\\\\\\\"}\\\",\\\"textSize\\\":12,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":30,\\\"top\\\":60,\\\"right\\\":30,\\\"bottom\\\":400,\\\"gravity\\\":1,\\\"recv\\\":\\\"{\\\\\\\"recvId\\\\\\\":\\\\\\\"100104\\\\\\\"}\\\",\\\"send\\\":null}]\",\"images\":\"[]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-14 00:47:35', '192.168.1.119'),
(38, 6, 'edit', 'theme', '{\"themeName\":\"Launcher-AP1\",\"isMirror\":\"1\",\"animType\":\"3\",\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/5d\\/2f2c0d98a61327de56237b6f6da25c.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/82\\/d522d13cc3cc511587dbeafb9c9d3e.png\",\"screenWidth\":\"1024\",\"screenHeight\":\"600\",\"backcolor\":\"\",\"left\":\"0\",\"top\":\"0\",\"right\":\"1024\",\"bottom\":\"600\",\"remark\":\"\",\"themeId\":\"5\",\"ip\":\"192.168.1.119\",\"userid\":6}', '2019-06-14 09:08:22', '192.168.1.119'),
(39, 6, 'login', '', '', '2019-06-17 02:23:08', '192.168.1.119'),
(40, 6, 'error', 'subcell', '0', '2019-06-17 02:23:48', '192.168.1.119'),
(41, 6, 'edit', 'cell', '{\"cellId\":\"182\",\"description\":\"new_AP9\\u8f6e\\u64ad\\u56fe\\u7247\",\"themeId\":5,\"celltypeId\":42,\"resId\":0,\"width\":1024,\"height\":600,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"\",\"send\":\"\",\"texts\":\"[{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u5e94\\\\u7528\\\\\\\"}\\\",\\\"textSize\\\":28,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":250,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u5bfc\\\\u822a\\\\\\\"}\\\",\\\"textSize\\\":28,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":250,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u6536\\\\u97f3\\\\u673a\\\\\\\"}\\\",\\\"textSize\\\":28,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":250,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u7535\\\\u8bdd\\\\\\\"}\\\",\\\"textSize\\\":28,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":250,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"text\\\":\\\"{\\\\\\\"zh_rCN\\\\\\\":\\\\\\\"\\\\u624b\\\\u673a\\\\u4e92\\\\u8fde\\\\\\\"}\\\",\\\"textSize\\\":28,\\\"textLines\\\":1,\\\"textColor\\\":\\\"#FFFFFF\\\",\\\"textFilter\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":250,\\\"right\\\":0,\\\"bottom\\\":0,\\\"gravity\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"images\":\"[{\\\"width\\\":160,\\\"height\\\":280,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/17\\\\\\/59b5938e8bf8a11b5ff72d19b20c05.png\\\",\\\"filterColor\\\":\\\"#3F0000FF\\\",\\\"left\\\":82,\\\"top\\\":160,\\\"right\\\":782,\\\"bottom\\\":160,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":\\\"{\\\\\\\"packName\\\\\\\":\\\\\\\"com.android.launcher3\\\\\\\"}\\\"},{\\\"width\\\":180,\\\"height\\\":315,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/c9\\\\\\/70b1864d18a5dd69ea13e4117a1348.png\\\",\\\"filterColor\\\":\\\"#3F0000FF\\\",\\\"left\\\":238,\\\"top\\\":135,\\\"right\\\":606,\\\"bottom\\\":130,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":\\\"{\\\\\\\"packName\\\\\\\":\\\\\\\"com.autonavi.amapauto\\\\\\\"}\\\"},{\\\"width\\\":200,\\\"height\\\":350,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/24\\\\\\/e0deed3b33bf5e9953857ed386708b.png\\\",\\\"filterColor\\\":\\\"#3F0000FF\\\",\\\"left\\\":412,\\\"top\\\":115,\\\"right\\\":412,\\\"bottom\\\":135,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":\\\"{\\\\\\\"packName\\\\\\\":\\\\\\\"com.jancar.radios\\\\\\\"}\\\"},{\\\"width\\\":180,\\\"height\\\":315,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/27\\\\\\/253e2db79ecb9ece67d6b228264481.png\\\",\\\"filterColor\\\":\\\"#3F0000FF\\\",\\\"left\\\":606,\\\"top\\\":135,\\\"right\\\":238,\\\"bottom\\\":130,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":\\\"{\\\\\\\"packName\\\\\\\":\\\\\\\"com.jancar.bluetooth.phone\\\\\\\"}\\\"},{\\\"width\\\":160,\\\"height\\\":280,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/5f\\\\\\/ff9a22f80939605c4c5eaa6d0a2f80.png\\\",\\\"filterColor\\\":\\\"#3F0000FF\\\",\\\"left\\\":782,\\\"top\\\":160,\\\"right\\\":82,\\\"bottom\\\":160,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":\\\"{\\\\\\\"packName\\\\\\\":\\\\\\\"net.easyconn\\\\\\\"}\\\"}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-17 02:23:48', '192.168.1.119'),
(42, 6, 'login', '', '', '2019-06-17 02:38:51', '192.168.1.119'),
(43, 6, 'edit', 'theme', '{\"themeName\":\"Launcher-AP9\",\"isMirror\":\"0\",\"animType\":\"1\",\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/5d\\/2f2c0d98a61327de56237b6f6da25c.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/c4\\/2d9a6784290bc820e72ae90ce7865d.png\",\"screenWidth\":\"1024\",\"screenHeight\":\"600\",\"backcolor\":\"\",\"left\":\"0\",\"top\":\"0\",\"right\":\"0\",\"bottom\":\"0\",\"remark\":\"\",\"themeId\":\"20\",\"ip\":\"192.168.1.119\",\"userid\":6}', '2019-06-17 02:39:22', '192.168.1.119'),
(44, 6, 'edit', 'theme', '{\"themeName\":\"Launcher-APA\",\"isMirror\":\"0\",\"animType\":\"3\",\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d5\\/3f2745a83a7f4ea7278568652b21d7.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/d8\\/c1c2437852ea84238fe05bbd28c287.png\",\"screenWidth\":\"800\",\"screenHeight\":\"480\",\"backcolor\":\"\",\"left\":\"0\",\"top\":\"0\",\"right\":\"0\",\"bottom\":\"0\",\"remark\":\"\",\"themeId\":\"26\",\"ip\":\"192.168.1.119\",\"userid\":6}', '2019-06-17 02:40:26', '192.168.1.119'),
(45, 6, 'edit', 'theme', '{\"themeName\":\"Launcher-AP1\",\"isMirror\":\"1\",\"animType\":\"1\",\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/5d\\/2f2c0d98a61327de56237b6f6da25c.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/82\\/d522d13cc3cc511587dbeafb9c9d3e.png\",\"screenWidth\":\"1024\",\"screenHeight\":\"600\",\"backcolor\":\"\",\"left\":\"0\",\"top\":\"0\",\"right\":\"1024\",\"bottom\":\"600\",\"remark\":\"\",\"themeId\":\"5\",\"ip\":\"192.168.1.119\",\"userid\":6}', '2019-06-17 02:41:25', '192.168.1.119'),
(46, 6, 'edit', 'theme', '{\"themeName\":\"Launcher-AP3\",\"isMirror\":\"1\",\"animType\":\"1\",\"imageurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/f8\\/fc65ab56c952ebccd91be18b9a2d06.png\",\"exampleurl\":\"http:\\/\\/192.168.1.88\\/uiweb\\/uploads\\/65\\/580a5dc97c7ef0e6593fdc93d6f484.png\",\"screenWidth\":\"1024\",\"screenHeight\":\"600\",\"backcolor\":\"\",\"left\":\"0\",\"top\":\"0\",\"right\":\"1024\",\"bottom\":\"600\",\"remark\":\"\",\"themeId\":\"7\",\"ip\":\"192.168.1.119\",\"userid\":6}', '2019-06-17 02:41:31', '192.168.1.119'),
(47, 6, 'error', 'subcell', '0', '2019-06-19 02:40:25', '192.168.1.119'),
(48, 6, 'edit', 'cell', '{\"cellId\":\"221\",\"description\":\"\\u5206\\u9875\\u5bfc\\u822a\",\"themeId\":26,\"celltypeId\":2,\"resId\":0,\"width\":116,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"{\\\"recvId\\\":\\\"400301\\\",\\\"visibleContent\\\":\\\"01#03#02#04\\\"}\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/ef\\\\\\/c657ab35a6cf382150277300d191dd.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/2b\\\\\\/585b2856a902307ba34abe335cfb24.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/0e\\\\\\/535aeb755e0f9ebd63692c5b984852.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/9b\\\\\\/9040a21b3900ea9852cbc9d2b62c12.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-19 02:40:25', '192.168.1.119'),
(49, 6, 'error', 'subcell', '0', '2019-06-19 02:40:26', '192.168.1.119'),
(50, 6, 'edit', 'cell', '{\"cellId\":\"221\",\"description\":\"\\u5206\\u9875\\u5bfc\\u822a\",\"themeId\":26,\"celltypeId\":2,\"resId\":0,\"width\":116,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"{\\\"recvId\\\":\\\"400301\\\",\\\"visibleContent\\\":\\\"01#03#02#04\\\"}\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/ef\\\\\\/c657ab35a6cf382150277300d191dd.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/2b\\\\\\/585b2856a902307ba34abe335cfb24.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/0e\\\\\\/535aeb755e0f9ebd63692c5b984852.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/9b\\\\\\/9040a21b3900ea9852cbc9d2b62c12.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-19 02:40:26', '192.168.1.119'),
(51, 6, 'error', 'subcell', '0', '2019-06-19 02:41:51', '192.168.1.119'),
(52, 6, 'edit', 'cell', '{\"cellId\":\"221\",\"description\":\"\\u5206\\u9875\\u5bfc\\u822a\",\"themeId\":26,\"celltypeId\":2,\"resId\":0,\"width\":116,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"{\\\"recvId\\\":\\\"400301\\\",\\\"visibleContent\\\":\\\"01#03#02#04\\\"}\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/ef\\\\\\/c657ab35a6cf382150277300d191dd.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/2b\\\\\\/585b2856a902307ba34abe335cfb24.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/0e\\\\\\/535aeb755e0f9ebd63692c5b984852.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/9b\\\\\\/9040a21b3900ea9852cbc9d2b62c12.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-19 02:41:51', '192.168.1.119'),
(53, 6, 'error', 'subcell', '0', '2019-06-19 02:41:52', '192.168.1.119'),
(54, 6, 'edit', 'cell', '{\"cellId\":\"221\",\"description\":\"\\u5206\\u9875\\u5bfc\\u822a\",\"themeId\":26,\"celltypeId\":2,\"resId\":0,\"width\":116,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"{\\\"recvId\\\":\\\"400301\\\",\\\"visibleContent\\\":\\\"01#03#02#04\\\"}\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/ef\\\\\\/c657ab35a6cf382150277300d191dd.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/2b\\\\\\/585b2856a902307ba34abe335cfb24.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/0e\\\\\\/535aeb755e0f9ebd63692c5b984852.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/9b\\\\\\/9040a21b3900ea9852cbc9d2b62c12.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-19 02:41:52', '192.168.1.119'),
(55, 6, 'error', 'subcell', '0', '2019-06-19 02:44:52', '192.168.1.119'),
(56, 6, 'edit', 'cell', '{\"cellId\":\"221\",\"description\":\"\\u5206\\u9875\\u5bfc\\u822a\",\"themeId\":26,\"celltypeId\":2,\"resId\":0,\"width\":116,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"{\\\"recvId\\\":\\\"400301\\\",\\\"visibleContent\\\":\\\"01#02#03#04\\\"}\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/ef\\\\\\/c657ab35a6cf382150277300d191dd.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/2b\\\\\\/585b2856a902307ba34abe335cfb24.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/0e\\\\\\/535aeb755e0f9ebd63692c5b984852.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/9b\\\\\\/9040a21b3900ea9852cbc9d2b62c12.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-19 02:44:52', '192.168.1.119'),
(57, 6, 'error', 'subcell', '0', '2019-06-19 02:44:53', '192.168.1.119'),
(58, 6, 'edit', 'cell', '{\"cellId\":\"221\",\"description\":\"\\u5206\\u9875\\u5bfc\\u822a\",\"themeId\":26,\"celltypeId\":2,\"resId\":0,\"width\":116,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"{\\\"recvId\\\":\\\"400301\\\",\\\"visibleContent\\\":\\\"01#02#03#04\\\"}\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/ef\\\\\\/c657ab35a6cf382150277300d191dd.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/2b\\\\\\/585b2856a902307ba34abe335cfb24.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/0e\\\\\\/535aeb755e0f9ebd63692c5b984852.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/9b\\\\\\/9040a21b3900ea9852cbc9d2b62c12.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-19 02:44:53', '192.168.1.119'),
(59, 6, 'error', 'subcell', '0', '2019-06-19 02:47:26', '192.168.1.119'),
(60, 6, 'edit', 'cell', '{\"cellId\":\"221\",\"description\":\"\\u5206\\u9875\\u5bfc\\u822a\",\"themeId\":26,\"celltypeId\":2,\"resId\":0,\"width\":116,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"{\\\"recvId\\\":\\\"400301\\\",\\\"visibleContent\\\":\\\"01#03#02#04\\\"}\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/ef\\\\\\/c657ab35a6cf382150277300d191dd.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/2b\\\\\\/585b2856a902307ba34abe335cfb24.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/0e\\\\\\/535aeb755e0f9ebd63692c5b984852.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/9b\\\\\\/9040a21b3900ea9852cbc9d2b62c12.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-19 02:47:26', '192.168.1.119'),
(61, 6, 'error', 'subcell', '0', '2019-06-19 02:47:33', '192.168.1.119'),
(62, 6, 'edit', 'cell', '{\"cellId\":\"221\",\"description\":\"\\u5206\\u9875\\u5bfc\\u822a\",\"themeId\":26,\"celltypeId\":2,\"resId\":0,\"width\":116,\"height\":480,\"backColor\":\"\",\"filterColor\":\"\",\"recv\":\"{\\\"recvId\\\":\\\"400301\\\",\\\"visibleContent\\\":\\\"01#03#02#04\\\"}\",\"send\":\"\",\"texts\":\"[]\",\"images\":\"[{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/ef\\\\\\/c657ab35a6cf382150277300d191dd.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/2b\\\\\\/585b2856a902307ba34abe335cfb24.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/0e\\\\\\/535aeb755e0f9ebd63692c5b984852.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null},{\\\"width\\\":116,\\\"height\\\":480,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/192.168.1.88\\\\\\/uiweb\\\\\\/uploads\\\\\\/9b\\\\\\/9040a21b3900ea9852cbc9d2b62c12.png\\\",\\\"filterColor\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":0,\\\"right\\\":0,\\\"bottom\\\":0,\\\"scaleType\\\":0,\\\"shapeType\\\":0,\\\"recv\\\":null,\\\"send\\\":null}]\",\"pages\":\"[]\",\"remark\":\"\",\"userid\":6,\"ip\":\"192.168.1.119\"}', '2019-06-19 02:47:33', '192.168.1.119'),
(63, 6, 'login', '', '', '2019-06-21 06:58:50', '192.168.1.119'),
(64, 6, 'add', 'cellpage', '{\"cellId\":\"-1\",\"subcellId\":\"0\",\"ip\":\"192.168.1.119\",\"userid\":6,\"cellpageId\":\"51\"}', '2019-06-21 07:41:33', '192.168.1.119');

-- --------------------------------------------------------

--
-- 表的结构 `fly_user_role`
--

CREATE TABLE `fly_user_role` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色对应关系';

--
-- 转存表中的数据 `fly_user_role`
--

INSERT INTO `fly_user_role` (`id`, `user_id`, `role_id`) VALUES
(18, 6, 3),
(25, 7, 3),
(26, 5, 8);

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
  `status` int(11) NOT NULL DEFAULT '1',
  `userid` int(11) NOT NULL,
  `edittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ip` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fly_welcome`
--

INSERT INTO `fly_welcome` (`welcomeId`, `imageurl`, `welcomeTitle`, `welcomeText`, `welcomeSort`, `status`, `userid`, `edittime`, `ip`) VALUES
(1, 'http://127.0.0.1/uiweb/uploads/7e/b83361c57dc762493d937381938176.jpg', '深圳景安驰', '保持驾驶安全永远是第一重要，任何新功能的增加都必须先考虑这个原则。', 1, 1, 6, '2019-03-06 08:11:52', '192.168.1.119'),
(3, '/uiweb/uploads/3b/1b79b7bfda8e8841538b7291782506.jpg', '深圳景安驰', '车载系统不是手机系统的简单移植，手机上的应用大部分也不适合车载系统。', 2, 1, 0, '2019-02-21 07:10:00', '192.168.1.119'),
(4, 'http://127.0.0.1/uiweb/uploads/7e/b83361c57dc762493d937381938176.jpg', '深圳景安驰', '车载系统不是手机系统的简单移植，手机上的应用大部分也不适合车载系统。车载系统不是手机系统的简单移植，手机上的应用大部分也不适合车载系统。', 3, 1, 0, '2019-03-11 06:05:04', '192.168.1.119');

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
  ADD PRIMARY KEY (`cellId`);

--
-- 表的索引 `fly_cellpage`
--
ALTER TABLE `fly_cellpage`
  ADD PRIMARY KEY (`pageId`);

--
-- 表的索引 `fly_cellpagecell`
--
ALTER TABLE `fly_cellpagecell`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `fly_celltype`
--
ALTER TABLE `fly_celltype`
  ADD PRIMARY KEY (`celltypeId`);

--
-- 表的索引 `fly_history`
--
ALTER TABLE `fly_history`
  ADD PRIMARY KEY (`historyId`);

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
  ADD PRIMARY KEY (`id`);

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
-- 表的索引 `fly_subcell`
--
ALTER TABLE `fly_subcell`
  ADD PRIMARY KEY (`subcellId`);

--
-- 表的索引 `fly_theme`
--
ALTER TABLE `fly_theme`
  ADD PRIMARY KEY (`themeId`);

--
-- 表的索引 `fly_themepage`
--
ALTER TABLE `fly_themepage`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `fly_themetopcell`
--
ALTER TABLE `fly_themetopcell`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `fly_user`
--
ALTER TABLE `fly_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_name` (`user_name`);

--
-- 表的索引 `fly_user_log`
--
ALTER TABLE `fly_user_log`
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
  MODIFY `aboutId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- 使用表AUTO_INCREMENT `fly_cases`
--
ALTER TABLE `fly_cases`
  MODIFY `casesId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- 使用表AUTO_INCREMENT `fly_cell`
--
ALTER TABLE `fly_cell`
  MODIFY `cellId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动递增', AUTO_INCREMENT=240;

--
-- 使用表AUTO_INCREMENT `fly_cellpage`
--
ALTER TABLE `fly_cellpage`
  MODIFY `pageId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动递增', AUTO_INCREMENT=52;

--
-- 使用表AUTO_INCREMENT `fly_cellpagecell`
--
ALTER TABLE `fly_cellpagecell`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动递增', AUTO_INCREMENT=211;

--
-- 使用表AUTO_INCREMENT `fly_celltype`
--
ALTER TABLE `fly_celltype`
  MODIFY `celltypeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动递增', AUTO_INCREMENT=51;

--
-- 使用表AUTO_INCREMENT `fly_history`
--
ALTER TABLE `fly_history`
  MODIFY `historyId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `fly_news`
--
ALTER TABLE `fly_news`
  MODIFY `newsId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- 使用表AUTO_INCREMENT `fly_page`
--
ALTER TABLE `fly_page`
  MODIFY `pageId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动递增', AUTO_INCREMENT=57;

--
-- 使用表AUTO_INCREMENT `fly_pagecell`
--
ALTER TABLE `fly_pagecell`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动递增', AUTO_INCREMENT=3423;

--
-- 使用表AUTO_INCREMENT `fly_permission`
--
ALTER TABLE `fly_permission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=136;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- 使用表AUTO_INCREMENT `fly_role_permission`
--
ALTER TABLE `fly_role_permission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=439;

--
-- 使用表AUTO_INCREMENT `fly_subcell`
--
ALTER TABLE `fly_subcell`
  MODIFY `subcellId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动递增', AUTO_INCREMENT=22;

--
-- 使用表AUTO_INCREMENT `fly_theme`
--
ALTER TABLE `fly_theme`
  MODIFY `themeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动递增', AUTO_INCREMENT=27;

--
-- 使用表AUTO_INCREMENT `fly_themepage`
--
ALTER TABLE `fly_themepage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动递增', AUTO_INCREMENT=423;

--
-- 使用表AUTO_INCREMENT `fly_themetopcell`
--
ALTER TABLE `fly_themetopcell`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动递增', AUTO_INCREMENT=79;

--
-- 使用表AUTO_INCREMENT `fly_user`
--
ALTER TABLE `fly_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- 使用表AUTO_INCREMENT `fly_user_log`
--
ALTER TABLE `fly_user_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动递增', AUTO_INCREMENT=65;

--
-- 使用表AUTO_INCREMENT `fly_user_role`
--
ALTER TABLE `fly_user_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- 使用表AUTO_INCREMENT `fly_welcome`
--
ALTER TABLE `fly_welcome`
  MODIFY `welcomeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
