-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2024 at 11:49 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `homework`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `text` varchar(100) DEFAULT NULL,
  `author` int(11) DEFAULT NULL,
  `post` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `text`, `author`, `post`) VALUES
(13, 'Sjajno', 4, 14),
(14, 'Veselo', 4, 14),
(15, 'Super za nase ptice!', 3, 16);

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE `posts` (
  `id` int(11) NOT NULL,
  `author` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `text` varchar(1000) NOT NULL,
  `date` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`id`, `author`, `title`, `text`, `date`) VALUES
(14, 3, 'Misteriozna Svetlost iznad Beograda', 'Beograd, Srbija – Stanovnici glavnog grada su sinoć bili svedoci neobičnog fenomena. Oko 22 časa, misteriozna svetlost obasjala je nebo iznad Beograda, ostavljajući mnoge građane zapanjenim i zbunjenim.\r\n\r\nPrema izjavama očevidaca, svetlost je bila intenzivna, bele boje, i trajala je nekoliko minuta pre nego što je naglo nestala. Stručnjaci iz Astronomskog društva Srbije su odmah reagovali, ali za sada nemaju objašnjenje za ovaj neobični događaj.\r\n\r\n\"U pitanju bi mogao biti meteor koji je izgoreo u atmosferi, ali tako jak sjaj je zaista redak,\" izjavio je dr. Nikola Jovanović iz Astronomskog društva. \"Nastavljamo sa istraživanjem i nadamo se da ćemo uskoro imati više informacija.\"\r\n\r\nStanovnici su svoje iskustvo delili na društvenim mrežama, gde su postavljali fotografije i snimke misteriozne svetlosti. Pojedini su izrazili zabrinutost, dok su drugi spekulisali o vanzemaljskim posetiocima.\r\n\r\nOvaj neobični događaj podstakao je interesovanje javnosti, ali za sada, misterija ostaje nereš', ''),
(15, 4, 'Novi Tehnološki Park u Novom Sadu', 'Novi Sad, Srbija – U srpskoj IT industriji dogodio se veliki korak napred. Danas je svečano otvoren novi Tehnološki park u Novom Sadu, koji će pružiti podršku startup kompanijama i mladim inovatorima iz regiona.\r\n\r\nNovi Tehnološki park, smešten na 10.000 kvadratnih metara, opremljen je najnovijom tehnologijom i modernim radnim prostorom. Projekat je realizovan uz podršku Vlade Srbije i Evropske unije, a cilj je stvaranje inovativnog ekosistema koji će privući talente iz celog sveta.\r\n\r\nMinistar za tehnološki razvoj, Ivana Petrović, prisustvovala je otvaranju i istakla značaj ovog projekta. \"Ovo je veliki korak za našu zemlju. Tehnološki park će biti centar inovacija i kreativnosti, i pomoći će nam da postanemo lideri u IT industriji,\" izjavila je ona.', ''),
(16, 2, 'Otkrivena Nova Vrsta Ptice u Nacionalnom Parku Tara', 'Tara, Srbija – Biolozi su danas objavili uzbudljivu vest o otkriću nove vrste ptice u Nacionalnom parku Tara. Ova vrsta, nazvana \"tarinski zlatni čvorak\" (Sturnus aurum tara), razlikuje se od poznatih vrsta po jedinstvenom zlatnom perju i specifičnom pesmom.\r\n\r\nDr. Milena Marković, vodeći biolog na projektu, ističe da je otkriće rezultat višegodišnjeg istraživanja i napornog rada. \"Pronašli smo ovu vrstu dok smo proučavali migracione obrasce ptica. Njeno prelepo zlatno perje i melodiozna pesma odmah su nam privukli pažnju,\" rekla je dr. Marković.\r\n\r\nNacionalni park Tara već je poznat po svojoj biodiverzitetu, ali ovo otkriće dodatno ističe njegov značaj. \"Ovo je veliko priznanje za naš tim i dokaz koliko je važno zaštititi naše prirodno bogatstvo,\" dodala je dr. Marković.\r\n\r\nLokalne vlasti i ekološke organizacije već rade na planovima za zaštitu tarinskog zlatnog čvorka, kako bi se osiguralo da ova nova vrsta može sigurno da se razvija u svom prirodnom staništu.', '');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `password`) VALUES
(2, 'Pera', 'QGiSgJwdneO4C5uob3szLGzY+NEx1puxw/CrXJtmi18='),
(3, 'Mika', '1VGdPCmjsqKb56TZTvCnVHYSNSikhjWFbNvbfnMvXZE='),
(4, 'Misko', 'U6CKGJt/RXll9wmZdQVKYled+RvSQBCqzHKU/JGn8xY=');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `post` (`post`),
  ADD KEY `author` (`author`);

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `csk` (`author`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `author` FOREIGN KEY (`author`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`post`) REFERENCES `posts` (`id`);

--
-- Constraints for table `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `csk` FOREIGN KEY (`author`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
