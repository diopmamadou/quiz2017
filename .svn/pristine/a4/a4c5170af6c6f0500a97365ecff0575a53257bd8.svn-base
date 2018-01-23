-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2017-12-22 12:24:08
-- 服务器版本： 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quiz2017`
--

-- --------------------------------------------------------

--
-- 表的结构 `choisir`
--

CREATE TABLE `choisir` (
  `id_personne` int(11) NOT NULL,
  `id_quiz` int(11) NOT NULL,
  `id_proposition` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `personne`
--

CREATE TABLE `personne` (
  `idpersonne` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `mdp` varchar(45) NOT NULL,
  `droits` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `proposition`
--

CREATE TABLE `proposition` (
  `idproposition` int(11) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `bonneReponse` tinyint(1) DEFAULT NULL,
  `numeroQuestion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `question`
--

CREATE TABLE `question` (
  `idquestion` int(11) NOT NULL,
  `libelle` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `quiz`
--

CREATE TABLE `quiz` (
  `idquiz` int(11) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `etat` int(11) DEFAULT NULL,
  `dateDebutQuiz` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `noQuestionCourante` int(11) DEFAULT NULL,
  `etape` int(11) NOT NULL,
  `dateDebutQuestion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `quiz_question`
--

CREATE TABLE `quiz_question` (
  `id_quiz` int(11) NOT NULL,
  `id_question` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `choisir`
--
ALTER TABLE `choisir`
  ADD PRIMARY KEY (`id_personne`,`id_quiz`,`id_proposition`),
  ADD KEY `fk_choi_id_quiz_idx` (`id_quiz`),
  ADD KEY `fk_choi_id_proposition_idx` (`id_proposition`),
  ADD KEY `fk_choi_id_personne` (`id_personne`);

--
-- Indexes for table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`idpersonne`),
  ADD UNIQUE KEY `email_UNIQUE` (`mail`);

--
-- Indexes for table `proposition`
--
ALTER TABLE `proposition`
  ADD PRIMARY KEY (`idproposition`),
  ADD KEY `fk_numeroQuestion_idx` (`numeroQuestion`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`idquestion`);

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`idquiz`);

--
-- Indexes for table `quiz_question`
--
ALTER TABLE `quiz_question`
  ADD PRIMARY KEY (`id_quiz`,`id_question`),
  ADD KEY `fk_qq_id_question_idx` (`id_question`),
  ADD KEY `fk_qq_id_quiz` (`id_quiz`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `personne`
--
ALTER TABLE `personne`
  MODIFY `idpersonne` int(11) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `proposition`
--
ALTER TABLE `proposition`
  MODIFY `idproposition` int(11) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `question`
--
ALTER TABLE `question`
  MODIFY `idquestion` int(11) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `quiz`
--
ALTER TABLE `quiz`
  MODIFY `idquiz` int(11) NOT NULL AUTO_INCREMENT;
--
-- 限制导出的表
--

--
-- 限制表 `choisir`
--
ALTER TABLE `choisir`
  ADD CONSTRAINT `fk_choi_id_personne` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`idpersonne`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_choi_id_proposition` FOREIGN KEY (`id_proposition`) REFERENCES `proposition` (`idproposition`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_choi_id_quiz` FOREIGN KEY (`id_quiz`) REFERENCES `quiz` (`idquiz`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- 限制表 `proposition`
--
ALTER TABLE `proposition`
  ADD CONSTRAINT `fk_numeroQuestion` FOREIGN KEY (`numeroQuestion`) REFERENCES `question` (`idquestion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- 限制表 `quiz_question`
--
ALTER TABLE `quiz_question`
  ADD CONSTRAINT `fk_qq_id_question` FOREIGN KEY (`id_question`) REFERENCES `question` (`idquestion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_qq_id_quiz` FOREIGN KEY (`id_quiz`) REFERENCES `quiz` (`idquiz`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
