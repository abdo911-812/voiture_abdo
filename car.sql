-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2025 at 10:58 AM
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
-- Database: `car`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id_client` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `num_permis` varchar(255) DEFAULT NULL,
  `photo_permis` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id_client`, `adresse`, `cin`, `email`, `nom`, `num_permis`, `photo_permis`, `prenom`, `telephone`) VALUES
(21, 'Casablanca', 'C200001', 'omar.elidrissi@gmail.com', 'El Idrissi', 'PERM-201', 'https://images.unsplash.com/photo-1', 'Omar', '0711122233'),
(22, 'Rabat', 'C200002', 'fatima.benali@gmail.com', 'Benali', 'PERM-202', 'https://images.unsplash.com/photo-2', 'Fatima', '0712233444'),
(23, 'Fès', 'C200003', 'amina.karim@gmail.com', 'Karim', 'PERM-203', 'https://images.unsplash.com/photo-3', 'Amina', '0713344555');

-- --------------------------------------------------------

--
-- Table structure for table `contrat_location`
--

CREATE TABLE `contrat_location` (
  `id` bigint(20) NOT NULL,
  `date_debut` datetime(6) DEFAULT NULL,
  `date_fin` datetime(6) DEFAULT NULL,
  `prix_loaction` varchar(255) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `employee` bigint(20) DEFAULT NULL,
  `voiture_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contrat_location`
--

INSERT INTO `contrat_location` (`id`, `date_debut`, `date_fin`, `prix_loaction`, `statut`, `client_id`, `employee`, `voiture_id`) VALUES
(3, '2025-08-01 10:00:00.000000', '2025-08-07 10:00:00.000000', '1800', 'EN_COURS', 22, 12, 16),
(4, '2025-08-10 09:00:00.000000', '2025-08-15 09:00:00.000000', '1500', 'RESERVE', 23, 13, 17);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id_employee` bigint(20) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `num_permis` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `photo_permis` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `role` enum('ADMINISTRATEUR','EMPLOYE') DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id_employee`, `adresse`, `cin`, `email`, `nom`, `num_permis`, `password`, `photo_permis`, `prenom`, `role`, `telephone`) VALUES
(12, 'Casablanca', 'E100001', 'khalid.elghazi@rentcar.ma', 'El Ghazi', 'DRV-001', '{noop}admin', 'https://images.unsplash.com/photo-4', 'Khalid', 'ADMINISTRATEUR', '0610101010'),
(13, 'Rabat', 'E100002', 'salma.bouazza@rentcar.ma', 'Bouazza', 'DRV-002', '{noop}salma', 'https://images.unsplash.com/photo-5', 'Salma', 'EMPLOYE', '0610202020');

-- --------------------------------------------------------

--
-- Table structure for table `etat_voiture`
--

CREATE TABLE `etat_voiture` (
  `id` bigint(20) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `image_arrier` varchar(255) DEFAULT NULL,
  `image_devent` varchar(255) DEFAULT NULL,
  `image_droit` varchar(255) DEFAULT NULL,
  `image_gouche` varchar(255) DEFAULT NULL,
  `kilometrage` varchar(255) DEFAULT NULL,
  `typeoperation` varchar(255) DEFAULT NULL,
  `contratlocation` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `etat_voiture`
--

INSERT INTO `etat_voiture` (`id`, `date`, `image_arrier`, `image_devent`, `image_droit`, `image_gouche`, `kilometrage`, `typeoperation`, `contratlocation`) VALUES
(1, '2025-08-07 10:00:00.000000', 'https://images.unsplash.com/photo-back', 'https://images.unsplash.com/photo-front', 'https://images.unsplash.com/photo-right', 'https://images.unsplash.com/photo-left', '12000', 'RETOUR', 3);

-- --------------------------------------------------------

--
-- Table structure for table `lesinfraction`
--

CREATE TABLE `lesinfraction` (
  `id` bigint(20) NOT NULL,
  `date` datetime(6) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `prixpay` varchar(255) DEFAULT NULL,
  `type_charge` varchar(255) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `voiture_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lesinfraction`
--

INSERT INTO `lesinfraction` (`id`, `date`, `image`, `prixpay`, `type_charge`, `client_id`, `voiture_id`) VALUES
(1, '2025-07-30 12:00:00.000000', 'https://images.unsplash.com/photo-infraction', '200.0', 'SPEEDING', 21, 16),
(2, '2025-08-01 13:15:00.000000', 'https://images.unsplash.com/photo-stop', '150.0', 'STOP_SIGN', 22, 17);

-- --------------------------------------------------------

--
-- Table structure for table `maintenance`
--

CREATE TABLE `maintenance` (
  `id` bigint(20) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `prixpay` varchar(255) DEFAULT NULL,
  `typemaintenance` enum('AMORTISSEURS','AMPOULES','ASSURANCE_BRIS_DE_GLACE','ASSURANCE_CATASTROPHE_NATURELLE','ASSURANCE_INCENDIE','ASSURANCE_RESPONSABILITE_CIVILE','ASSURANCE_TOUS_RISQUES','ASSURANCE_VOL','AUTRE','BALAIS_ESSUIE_GLACE','BATTERIE','BATTERIE_REMPLACEMENT','BOUGIES_ALLUMAGE','CARBURANT','CARROSSERIE','CARTE_GRISE','CERTIFICAT_IMMATRICULATION','CLIMATISATION','CONTRAVENTION','CONTROLE_TECHNIQUE','COURROIE_DISTRIBUTION','DEPANNAGE','DETAILING','DIAGNOSTIC','DIRECTION','DISQUES_FREIN','ECHAPPEMENT','EMBRAYAGE','ESSUIE_GLACES','FILTRE_AIR','FILTRE_CARBURANT','FILTRE_HABITACLE','FILTRE_HUILE','FRANCHISE_ASSURANCE','FREINS','HUILE_MOTEUR','LAVAGE_EXTERIEUR','LAVAGE_PROFESSIONNEL','LIQUIDES','LIQUIDE_FREIN','LIQUIDE_LAVE_GLACE','LIQUIDE_REFROIDISSEMENT','MISE_EN_FOURRIERE','NETTOYAGE_INTERIEUR','PHARES','PLAQUETTES_FREIN','PNEUS','REMORQUAGE','RENOUVELLEMENT_ASSURANCE','REPARATION_ALTERNATEUR','REPARATION_BOITE_VITESSE','REPARATION_CARROSSERIE','REPARATION_DEMARREUR','REPARATION_ELECTRIQUE','REPARATION_MOTEUR','REPARATION_PARE_BRISE','REPARATION_POMPE_A_CARBURANT','REPARATION_POMPE_A_EAU','REPARATION_TURBO','REVISION_PERIODIQUE','STATIONNEMENT','SUSPENSION','TAXE_VEHICULE','TRANSMISSION','VIDANGE','VIGNETTE') DEFAULT NULL,
  `voiture_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `maintenance`
--

INSERT INTO `maintenance` (`id`, `date`, `prixpay`, `typemaintenance`, `voiture_id`) VALUES
(1, '2025-07-20 09:00:00', '800.0', 'VIDANGE', 16),
(2, '2025-07-25 11:00:00', '500.0', 'FREINS', 17);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `voiture_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`id`, `date`, `client_id`, `voiture_id`) VALUES
(4, '2025-08-01', 21, 16),
(5, '2025-08-05', 22, 17),
(6, '2025-08-10', 23, 18);

-- --------------------------------------------------------

--
-- Table structure for table `voiture`
--

CREATE TABLE `voiture` (
  `id_voiture` bigint(20) NOT NULL,
  `annee` varchar(255) DEFAULT NULL,
  `couleur` varchar(255) DEFAULT NULL,
  `datefine_assurance` datetime(6) DEFAULT NULL,
  `datefinusage` datetime(6) DEFAULT NULL,
  `immatriculation` varchar(255) DEFAULT NULL,
  `kilometrage` int(11) NOT NULL,
  `marque` varchar(255) DEFAULT NULL,
  `modele` varchar(255) DEFAULT NULL,
  `photo_arriere` varchar(255) DEFAULT NULL,
  `photo_devant` varchar(255) DEFAULT NULL,
  `prix_location` float DEFAULT NULL,
  `prix_voiture` varchar(255) DEFAULT NULL,
  `statut` enum('DISPONIBLE','EN_MAINTENANCE','HORS_SERVICE','LOUE') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `voiture`
--

INSERT INTO `voiture` (`id_voiture`, `annee`, `couleur`, `datefine_assurance`, `datefinusage`, `immatriculation`, `kilometrage`, `marque`, `modele`, `photo_arriere`, `photo_devant`, `prix_location`, `prix_voiture`, `statut`) VALUES
(16, '2024', 'Gris', '2026-12-31 00:00:00.000000', '2031-12-31 00:00:00.000000', '0001-X-99', 5000, 'Peugeot', '208', 'https://images.unsplash.com/photo-1606192951191-364a7336d7f4', 'https://images.unsplash.com/photo-1606192951191-364a7336d7f4', 350, '170000.0', 'DISPONIBLE'),
(17, '2020', 'Noir', '2025-06-30 00:00:00.000000', '2028-06-30 00:00:00.000000', '2222-X-77', 42000, 'Renault', 'Clio', 'https://images.unsplash.com/photo-1592194996308-7b43878e84a6', 'https://images.unsplash.com/photo-1592194996308-7b43878e84a6', 270, '140000.0', 'DISPONIBLE'),
(18, '2021', 'Vert', '2025-08-20 00:00:00.000000', '2029-08-20 00:00:00.000000', '3333-Y-88', 31000, 'Kia', 'Sportage', 'https://images.unsplash.com/photo-1604697983110-b74c773c0e64', 'https://images.unsplash.com/photo-1604697983110-b74c773c0e64', 420, '250000.0', 'EN_MAINTENANCE'),
(19, '2023', 'Rouge', '2026-12-31 00:00:00.000000', '2031-12-31 00:00:00.000000', '4444-Z-11', 10000, 'BMW', 'X5', 'https://images.unsplash.com/photo-1601924928578-05b7a04f7a4a', 'https://images.unsplash.com/photo-1601924928578-05b7a04f7a4a', 600, '450000.0', 'DISPONIBLE'),
(20, '2019', 'Blanc', '2024-11-11 00:00:00.000000', '2029-11-11 00:00:00.000000', '5555-A-22', 60000, 'Dacia', 'Logan', 'https://images.unsplash.com/photo-1612392061786-4c8a1cb6f3a3', 'https://images.unsplash.com/photo-1612392061786-4c8a1cb6f3a3', 250, '100000.0', 'DISPONIBLE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`),
  ADD UNIQUE KEY `UKo134qppytog4wbuhqpiuf0ued` (`cin`),
  ADD UNIQUE KEY `UKedver7gtbfldp50jtkypbtr89` (`nom`),
  ADD UNIQUE KEY `UKascd2ochs32doufnbtkuxkjlv` (`num_permis`),
  ADD UNIQUE KEY `UK7vycakykc6p68w6pj8ysprj6g` (`photo_permis`),
  ADD UNIQUE KEY `UKd03eh5lo4jua7h141etdwfv2p` (`prenom`);

--
-- Indexes for table `contrat_location`
--
ALTER TABLE `contrat_location`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKo1000m35u9s5k8s825jsprn2r` (`client_id`),
  ADD KEY `FK58siub0e5eblth72y5to3yqnp` (`employee`),
  ADD KEY `FKtaux4818t351ttl5y5rv6bimh` (`voiture_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id_employee`),
  ADD UNIQUE KEY `UKqtfor7d5mkkf26elj9m0amnmv` (`cin`),
  ADD UNIQUE KEY `UKfcc3qbsfpypd9brbe245s75bf` (`nom`),
  ADD UNIQUE KEY `UKg0pdneo3retnbir4nq8xucjjo` (`num_permis`),
  ADD UNIQUE KEY `UKcvamu7xotmrfnt1scgawji2ss` (`prenom`);

--
-- Indexes for table `etat_voiture`
--
ALTER TABLE `etat_voiture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3e0el9y1sd25bnhe4b0gosk0y` (`contratlocation`);

--
-- Indexes for table `lesinfraction`
--
ALTER TABLE `lesinfraction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKab0s2imdespvs4wlq0pueiwdt` (`client_id`),
  ADD KEY `FKsn9eayxf5rcdyhbtd0t6vmsox` (`voiture_id`);

--
-- Indexes for table `maintenance`
--
ALTER TABLE `maintenance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKccbaxkxue7up6hvqb0afmrgo0` (`voiture_id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoewar6f18rkn4iptr6da4oysv` (`client_id`),
  ADD KEY `FKhcpnk3yqv8geq06p34gxka5j6` (`voiture_id`);

--
-- Indexes for table `voiture`
--
ALTER TABLE `voiture`
  ADD PRIMARY KEY (`id_voiture`),
  ADD UNIQUE KEY `UK9swv5drfatbs9a5v5ed115ef7` (`annee`),
  ADD UNIQUE KEY `UK7uqcylylxy5q8n7xav05sqjcj` (`couleur`),
  ADD UNIQUE KEY `UK2hfeuglg1sspyg90j8dbqh4ne` (`immatriculation`),
  ADD UNIQUE KEY `UK72tw6myls83b1el7raplxla4` (`marque`),
  ADD UNIQUE KEY `UKqboh1mgyreq9oxrr584fs5hry` (`modele`),
  ADD UNIQUE KEY `UK8trl0ltpvdbslnh55lxqru7en` (`prix_voiture`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `contrat_location`
--
ALTER TABLE `contrat_location`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id_employee` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `etat_voiture`
--
ALTER TABLE `etat_voiture`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `lesinfraction`
--
ALTER TABLE `lesinfraction`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `maintenance`
--
ALTER TABLE `maintenance`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `voiture`
--
ALTER TABLE `voiture`
  MODIFY `id_voiture` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contrat_location`
--
ALTER TABLE `contrat_location`
  ADD CONSTRAINT `FK58siub0e5eblth72y5to3yqnp` FOREIGN KEY (`employee`) REFERENCES `employee` (`id_employee`),
  ADD CONSTRAINT `FKo1000m35u9s5k8s825jsprn2r` FOREIGN KEY (`client_id`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `FKtaux4818t351ttl5y5rv6bimh` FOREIGN KEY (`voiture_id`) REFERENCES `voiture` (`id_voiture`);

--
-- Constraints for table `etat_voiture`
--
ALTER TABLE `etat_voiture`
  ADD CONSTRAINT `FK3e0el9y1sd25bnhe4b0gosk0y` FOREIGN KEY (`contratlocation`) REFERENCES `contrat_location` (`id`);

--
-- Constraints for table `lesinfraction`
--
ALTER TABLE `lesinfraction`
  ADD CONSTRAINT `FKab0s2imdespvs4wlq0pueiwdt` FOREIGN KEY (`client_id`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `FKsn9eayxf5rcdyhbtd0t6vmsox` FOREIGN KEY (`voiture_id`) REFERENCES `voiture` (`id_voiture`);

--
-- Constraints for table `maintenance`
--
ALTER TABLE `maintenance`
  ADD CONSTRAINT `FKccbaxkxue7up6hvqb0afmrgo0` FOREIGN KEY (`voiture_id`) REFERENCES `voiture` (`id_voiture`);

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FKhcpnk3yqv8geq06p34gxka5j6` FOREIGN KEY (`voiture_id`) REFERENCES `voiture` (`id_voiture`),
  ADD CONSTRAINT `FKoewar6f18rkn4iptr6da4oysv` FOREIGN KEY (`client_id`) REFERENCES `client` (`id_client`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
