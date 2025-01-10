-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 10 jan. 2025 à 20:53
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `foodtekup`
--

-- --------------------------------------------------------

--
-- Structure de la table `address`
--

CREATE TABLE `address` (
  `id` bigint(20) NOT NULL,
  `creation_date` datetime NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `app_user`
--

CREATE TABLE `app_user` (
  `type` varchar(5) NOT NULL,
  `id` bigint(20) NOT NULL,
  `creation_date` datetime NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `availablity` bit(1) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` bigint(20) NOT NULL,
  `creation_date` datetime NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `total_price` double NOT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `manager_id` bigint(20) DEFAULT NULL,
  `payement_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commande_plats`
--

CREATE TABLE `commande_plats` (
  `orders_id` bigint(20) NOT NULL,
  `plats_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `delivery`
--

CREATE TABLE `delivery` (
  `id` bigint(20) NOT NULL,
  `creation_date` datetime NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `delivery_date` datetime DEFAULT NULL,
  `orderid` bigint(20) DEFAULT NULL,
  `delivery_manid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `payement`
--

CREATE TABLE `payement` (
  `id` bigint(20) NOT NULL,
  `creation_date` datetime NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `carte_number` varchar(255) DEFAULT NULL,
  `carte_type` varchar(255) DEFAULT NULL,
  `payment_date` datetime DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `plat`
--

CREATE TABLE `plat` (
  `id` bigint(20) NOT NULL,
  `creation_date` datetime NOT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `plat_name` varchar(255) DEFAULT NULL,
  `plat_prix` double NOT NULL,
  `plat_type` varchar(255) DEFAULT NULL,
  `manager_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `app_user`
--
ALTER TABLE `app_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_1j9d9a06i600gd43uu3km82jw` (`email`),
  ADD UNIQUE KEY `UK_sgg0yjxgl80p392p9ygv0yk4n` (`phone_number`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe0n8lahq2bcgaslm187jfp6cl` (`address_id`),
  ADD KEY `FKb4rcxiuk2froa0r6cmof111bd` (`client_id`),
  ADD KEY `FKr64iqox41tsidlhfm586ksvcg` (`manager_id`),
  ADD KEY `FKthckdkb75o5wlcjn1edveyb60` (`payement_id`);

--
-- Index pour la table `commande_plats`
--
ALTER TABLE `commande_plats`
  ADD PRIMARY KEY (`orders_id`,`plats_id`),
  ADD KEY `FK66kj8uxg91wriso1466ldrdh9` (`plats_id`);

--
-- Index pour la table `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbksqlw4pt3cvvr0s395bfaa9x` (`orderid`),
  ADD KEY `FK7mumfn4vf15fcvb8voxhipi4e` (`delivery_manid`);

--
-- Index pour la table `payement`
--
ALTER TABLE `payement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrb8b4uup2qgkisjvqvx5tko6l` (`order_id`);

--
-- Index pour la table `plat`
--
ALTER TABLE `plat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK419y3xb1wnsnlwce6tb349iuq` (`manager_id`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `FKb4rcxiuk2froa0r6cmof111bd` FOREIGN KEY (`client_id`) REFERENCES `app_user` (`id`),
  ADD CONSTRAINT `FKe0n8lahq2bcgaslm187jfp6cl` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `FKr64iqox41tsidlhfm586ksvcg` FOREIGN KEY (`manager_id`) REFERENCES `app_user` (`id`),
  ADD CONSTRAINT `FKthckdkb75o5wlcjn1edveyb60` FOREIGN KEY (`payement_id`) REFERENCES `payement` (`id`);

--
-- Contraintes pour la table `commande_plats`
--
ALTER TABLE `commande_plats`
  ADD CONSTRAINT `FK66kj8uxg91wriso1466ldrdh9` FOREIGN KEY (`plats_id`) REFERENCES `plat` (`id`),
  ADD CONSTRAINT `FKngbla4lcoxwgqvbwbl88rpge8` FOREIGN KEY (`orders_id`) REFERENCES `commande` (`id`);

--
-- Contraintes pour la table `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `FK7mumfn4vf15fcvb8voxhipi4e` FOREIGN KEY (`delivery_manid`) REFERENCES `app_user` (`id`),
  ADD CONSTRAINT `FKbksqlw4pt3cvvr0s395bfaa9x` FOREIGN KEY (`orderid`) REFERENCES `commande` (`id`);

--
-- Contraintes pour la table `payement`
--
ALTER TABLE `payement`
  ADD CONSTRAINT `FKrb8b4uup2qgkisjvqvx5tko6l` FOREIGN KEY (`order_id`) REFERENCES `commande` (`id`);

--
-- Contraintes pour la table `plat`
--
ALTER TABLE `plat`
  ADD CONSTRAINT `FK419y3xb1wnsnlwce6tb349iuq` FOREIGN KEY (`manager_id`) REFERENCES `app_user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
