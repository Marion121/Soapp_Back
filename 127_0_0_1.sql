-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 04 avr. 2023 à 21:47
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `appliasso_bdd`
--
CREATE DATABASE IF NOT EXISTS `appliasso_bdd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `appliasso_bdd`;

-- --------------------------------------------------------

--
-- Structure de la table `association`
--

CREATE TABLE `association` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `mdp` varchar(100) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `couleur` varchar(10) NOT NULL,
  `description` varchar(100) NOT NULL,
  `logo` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `association`
--

INSERT INTO `association` (`id`, `nom`, `mdp`, `mail`, `couleur`, `description`, `logo`) VALUES
(1, 'BDE', 'bde', 'bde@epfedu.fr', 'jaune', 'c\'est cool', 'nice.com');

-- --------------------------------------------------------

--
-- Structure de la table `bureau`
--

CREATE TABLE `bureau` (
  `id` int(11) NOT NULL,
  `id_association` int(11) NOT NULL,
  `id_etudiant` int(11) NOT NULL,
  `role` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `promotion` varchar(10) NOT NULL,
  `mdp` varchar(100) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `formation` varchar(100) NOT NULL,
  `photo` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `lieu` varchar(100) DEFAULT NULL,
  `date_creation` datetime NOT NULL DEFAULT current_timestamp(),
  `date_evenement` datetime NOT NULL,
  `validation` tinyint(1) NOT NULL,
  `id_association_evenement` int(11) NOT NULL,
  `nbr_place` int(11) DEFAULT NULL,
  `date_heure_shotgun` datetime DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `lien` varchar(200) DEFAULT NULL,
  `titre_lien` varchar(50) DEFAULT NULL,
  `prix_cotisant` float DEFAULT NULL,
  `prix_non_cotisant` float DEFAULT NULL,
  `photo` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id`, `nom`, `lieu`, `date_creation`, `date_evenement`, `validation`, `id_association_evenement`, `nbr_place`, `date_heure_shotgun`, `description`, `lien`, `titre_lien`, `prix_cotisant`, `prix_non_cotisant`, `photo`) VALUES
(0, 'Soiree', 'cachan', '2023-04-04 20:05:06', '2023-04-05 20:03:57', 1, 1, 22, '2023-04-11 20:03:57', 'ca marche', 'letsgo.com', 'letsgo', 11, 12, 'photo.png');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `association`
--
ALTER TABLE `association`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `bureau`
--
ALTER TABLE `bureau`
  ADD KEY `FKrlkusrgoxkadwwp6ooij34dx4` (`id_association`),
  ADD KEY `FK8xqr13hrtjm3ealf5fjm5pix1` (`id_etudiant`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdl4softn648mfnamd89vaectk` (`id_association_evenement`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bureau`
--
ALTER TABLE `bureau`
  ADD CONSTRAINT `FK8xqr13hrtjm3ealf5fjm5pix1` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id`),
  ADD CONSTRAINT `FKrlkusrgoxkadwwp6ooij34dx4` FOREIGN KEY (`id_association`) REFERENCES `association` (`id`);

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `FKdl4softn648mfnamd89vaectk` FOREIGN KEY (`id_association_evenement`) REFERENCES `association` (`id`);
--
-- Base de données : `bwob_bdd`
--
CREATE DATABASE IF NOT EXISTS `bwob_bdd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bwob_bdd`;

-- --------------------------------------------------------

--
-- Structure de la table `acheteur`
--

CREATE TABLE `acheteur` (
  `id` bigint(20) NOT NULL,
  `user_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL,
  `email_admin` varchar(255) DEFAULT NULL,
  `nom_admin` varchar(255) DEFAULT NULL,
  `password_admin` varchar(255) DEFAULT NULL,
  `prenom_admin` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

CREATE TABLE `annonce` (
  `id` bigint(20) NOT NULL,
  `categorie` varchar(50) DEFAULT NULL,
  `code_postal` varchar(5) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `type_importance` varchar(20) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `devise` varchar(20) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `titre` varchar(50) DEFAULT NULL,
  `type_livraison` varchar(20) DEFAULT NULL,
  `validite` bit(1) DEFAULT NULL,
  `ville` varchar(50) DEFAULT NULL,
  `pays_fk` bigint(20) DEFAULT NULL,
  `user_fk` bigint(20) DEFAULT NULL,
  `poids` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `message_acheteur`
--

CREATE TABLE `message_acheteur` (
  `id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `offre_acheteur_fk` bigint(20) DEFAULT NULL,
  `user_envoyeur_fk` bigint(20) DEFAULT NULL,
  `user_receveur_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `message_voyageur`
--

CREATE TABLE `message_voyageur` (
  `id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `offre_voyageur_fk` bigint(20) DEFAULT NULL,
  `user_envoyeur_fk` bigint(20) DEFAULT NULL,
  `user_receveur_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `offre_achateur`
--

CREATE TABLE `offre_achateur` (
  `id` bigint(20) NOT NULL,
  `date_offre` datetime DEFAULT NULL,
  `devise` varchar(20) DEFAULT NULL,
  `phase_offre` varchar(20) DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `acheteur_fk` bigint(20) DEFAULT NULL,
  `annonce_fk` bigint(20) DEFAULT NULL,
  `pays_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `offre_acheteur`
--

CREATE TABLE `offre_acheteur` (
  `id` bigint(20) NOT NULL,
  `date_offre` datetime DEFAULT NULL,
  `devise` varchar(20) DEFAULT NULL,
  `phase_offre` varchar(20) DEFAULT NULL,
  `poids` float DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `acheteur_fk` bigint(20) DEFAULT NULL,
  `annonce_fk` bigint(20) DEFAULT NULL,
  `pays_fk` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `offre_voyageur`
--

CREATE TABLE `offre_voyageur` (
  `id` bigint(20) NOT NULL,
  `date_offre` datetime DEFAULT NULL,
  `devise` varchar(20) DEFAULT NULL,
  `phase_offre` varchar(20) DEFAULT NULL,
  `prix` float DEFAULT NULL,
  `annonce_fk` bigint(20) DEFAULT NULL,
  `pays_fk` bigint(20) DEFAULT NULL,
  `voyageur_fk` bigint(20) DEFAULT NULL,
  `poids` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

CREATE TABLE `pays` (
  `id` bigint(20) NOT NULL,
  `nom` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `pays`
--

INSERT INTO `pays` (`id`, `nom`) VALUES
(2, 'france');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `ci` varchar(255) DEFAULT NULL,
  `jd` varchar(255) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `code_postal` varchar(5) DEFAULT NULL,
  `date_creation` datetime DEFAULT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pays` varchar(45) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `verifier` bit(1) DEFAULT NULL,
  `ville` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `ci`, `jd`, `adresse`, `code_postal`, `date_creation`, `date_naissance`, `email`, `nom`, `password`, `pays`, `photo`, `prenom`, `telephone`, `verifier`, `ville`) VALUES
(1, NULL, NULL, '10 Cité de la Concorde', '92220', '2023-03-13 21:09:31', NULL, 'leo.comte@epfedu.fr', 'Comte', 'l', 'FRANCE', NULL, 'Leo', '0781746881', b'0', 'Bagneux'),
(2, NULL, NULL, '10 Cité de la Concorde', '92220', '2023-03-22 15:31:00', NULL, 'leocomte6@gmail.com', 'RE', 'o', 'France', NULL, 'T', '0781746881', b'0', 'Bagneux'),
(3, NULL, NULL, '10 Cité de la Concorde', '92220', '2023-03-22 15:31:48', NULL, 'leocomte6@gmail.com', 'Comte', 'o', 'France', NULL, 'Leo', '0781746881', b'0', 'Bagneux'),
(4, NULL, NULL, '10 Cité de la Concorde', '92220', '2023-03-22 15:39:22', NULL, 'leocomte6@gmail.com', 'Comte', 'L', 'FRANCE', NULL, 'Leo', '0781746881', b'0', 'Bagneux'),
(5, NULL, NULL, '10 Cité de la Concorde', '92220', '2023-03-24 16:59:10', NULL, 'leocomte6@gmail.com', 'Comte', 'l', 'France', NULL, 'Leo', '0781746881', b'0', 'Bagneux'),
(6, NULL, NULL, '10 Cité de la Concorde', '92220', '2023-03-24 17:03:07', NULL, 'leocomte6@gmail.com', 'Comte', 'l', 'France', NULL, 'Leo', '0781746881', b'0', 'Bagneux');

-- --------------------------------------------------------

--
-- Structure de la table `voyageur`
--

CREATE TABLE `voyageur` (
  `id` bigint(20) NOT NULL,
  `user_fk` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `voyageur_pays`
--

CREATE TABLE `voyageur_pays` (
  `voyageur_fk` bigint(20) NOT NULL,
  `pays_fk` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `acheteur`
--
ALTER TABLE `acheteur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_fk` (`user_fk`);

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1s8vb10cq6pvvaqxrcdswn80c` (`pays_fk`),
  ADD KEY `FKfuqbtxfimhyy7qtilbc3sl8lp` (`user_fk`);
ALTER TABLE `annonce` ADD FULLTEXT KEY `description-titre` (`description`,`titre`);

--
-- Index pour la table `message_acheteur`
--
ALTER TABLE `message_acheteur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKexin4hoeobhdd45sd0pq83o8r` (`offre_acheteur_fk`),
  ADD KEY `FKdc41cr5r19voxf8w3febxf9on` (`user_envoyeur_fk`),
  ADD KEY `FKp5eegmokdpcc77cloi3lfqdus` (`user_receveur_fk`);

--
-- Index pour la table `message_voyageur`
--
ALTER TABLE `message_voyageur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9yktcq3tpjlqvah0thfy2wm8h` (`offre_voyageur_fk`),
  ADD KEY `FKkaocrv2yqs8m8hm7msswnee3b` (`user_envoyeur_fk`),
  ADD KEY `FK2bnsnlmlypytywwyoa4dwkceh` (`user_receveur_fk`);

--
-- Index pour la table `offre_achateur`
--
ALTER TABLE `offre_achateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtejnhtc84nsv4n6e7bylpr3c2` (`acheteur_fk`),
  ADD KEY `FKgxadc59fe175b6ue059uvbxvp` (`annonce_fk`),
  ADD KEY `FK1gw3b11ev5jbpsx98d8l9nk8m` (`pays_fk`);

--
-- Index pour la table `offre_acheteur`
--
ALTER TABLE `offre_acheteur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl8gf7wfgdufr7c62bc2c6x7vk` (`acheteur_fk`),
  ADD KEY `FK20c42gs3q7tolul8prmgm6ydd` (`annonce_fk`),
  ADD KEY `FKnktxn4ow9y9yqmw1b18dwblwo` (`pays_fk`);

--
-- Index pour la table `offre_voyageur`
--
ALTER TABLE `offre_voyageur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK54sbw493vtl676hxqbw8ajs6i` (`annonce_fk`),
  ADD KEY `FKlu3fo555cgq2co231ug8iujgi` (`pays_fk`),
  ADD KEY `FK3uiv8475tkj5p4yy88g6euq8q` (`voyageur_fk`);

--
-- Index pour la table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `voyageur`
--
ALTER TABLE `voyageur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_fk` (`user_fk`);

--
-- Index pour la table `voyageur_pays`
--
ALTER TABLE `voyageur_pays`
  ADD KEY `FKjh67pkjsfqnfny1uiheibt5e7` (`pays_fk`),
  ADD KEY `FK6se6fjhee1njboxxr70m0u7ui` (`voyageur_fk`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `acheteur`
--
ALTER TABLE `acheteur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `message_acheteur`
--
ALTER TABLE `message_acheteur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `message_voyageur`
--
ALTER TABLE `message_voyageur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `offre_achateur`
--
ALTER TABLE `offre_achateur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `offre_acheteur`
--
ALTER TABLE `offre_acheteur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `offre_voyageur`
--
ALTER TABLE `offre_voyageur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pays`
--
ALTER TABLE `pays`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `voyageur`
--
ALTER TABLE `voyageur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `acheteur`
--
ALTER TABLE `acheteur`
  ADD CONSTRAINT `acheteur_ibfk_1` FOREIGN KEY (`user_fk`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `FK1s8vb10cq6pvvaqxrcdswn80c` FOREIGN KEY (`pays_fk`) REFERENCES `pays` (`id`),
  ADD CONSTRAINT `FKfuqbtxfimhyy7qtilbc3sl8lp` FOREIGN KEY (`user_fk`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `message_acheteur`
--
ALTER TABLE `message_acheteur`
  ADD CONSTRAINT `FKdc41cr5r19voxf8w3febxf9on` FOREIGN KEY (`user_envoyeur_fk`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKexin4hoeobhdd45sd0pq83o8r` FOREIGN KEY (`offre_acheteur_fk`) REFERENCES `offre_achateur` (`id`),
  ADD CONSTRAINT `FKp5eegmokdpcc77cloi3lfqdus` FOREIGN KEY (`user_receveur_fk`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `message_voyageur`
--
ALTER TABLE `message_voyageur`
  ADD CONSTRAINT `FK2bnsnlmlypytywwyoa4dwkceh` FOREIGN KEY (`user_receveur_fk`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK9yktcq3tpjlqvah0thfy2wm8h` FOREIGN KEY (`offre_voyageur_fk`) REFERENCES `offre_voyageur` (`id`),
  ADD CONSTRAINT `FKkaocrv2yqs8m8hm7msswnee3b` FOREIGN KEY (`user_envoyeur_fk`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `offre_achateur`
--
ALTER TABLE `offre_achateur`
  ADD CONSTRAINT `FK1gw3b11ev5jbpsx98d8l9nk8m` FOREIGN KEY (`pays_fk`) REFERENCES `pays` (`id`),
  ADD CONSTRAINT `FKgxadc59fe175b6ue059uvbxvp` FOREIGN KEY (`annonce_fk`) REFERENCES `annonce` (`id`),
  ADD CONSTRAINT `FKtejnhtc84nsv4n6e7bylpr3c2` FOREIGN KEY (`acheteur_fk`) REFERENCES `acheteur` (`id`);

--
-- Contraintes pour la table `offre_voyageur`
--
ALTER TABLE `offre_voyageur`
  ADD CONSTRAINT `FK3uiv8475tkj5p4yy88g6euq8q` FOREIGN KEY (`voyageur_fk`) REFERENCES `voyageur` (`id`),
  ADD CONSTRAINT `FK54sbw493vtl676hxqbw8ajs6i` FOREIGN KEY (`annonce_fk`) REFERENCES `annonce` (`id`),
  ADD CONSTRAINT `FKlu3fo555cgq2co231ug8iujgi` FOREIGN KEY (`pays_fk`) REFERENCES `pays` (`id`);

--
-- Contraintes pour la table `voyageur`
--
ALTER TABLE `voyageur`
  ADD CONSTRAINT `voyageur_ibfk_1` FOREIGN KEY (`user_fk`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Contraintes pour la table `voyageur_pays`
--
ALTER TABLE `voyageur_pays`
  ADD CONSTRAINT `FK6se6fjhee1njboxxr70m0u7ui` FOREIGN KEY (`voyageur_fk`) REFERENCES `voyageur` (`id`),
  ADD CONSTRAINT `FKjh67pkjsfqnfny1uiheibt5e7` FOREIGN KEY (`pays_fk`) REFERENCES `pays` (`id`);
--
-- Base de données : `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Structure de la table `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) NOT NULL DEFAULT '',
  `user` varchar(255) NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `query` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Structure de la table `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) NOT NULL,
  `col_name` varchar(64) NOT NULL,
  `col_type` varchar(64) NOT NULL,
  `col_length` text DEFAULT NULL,
  `col_collation` varchar(64) NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) DEFAULT '',
  `col_default` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Structure de la table `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `column_name` varchar(64) NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `transformation` varchar(255) NOT NULL DEFAULT '',
  `transformation_options` varchar(255) NOT NULL DEFAULT '',
  `input_transformation` varchar(255) NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Structure de la table `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) NOT NULL,
  `settings_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

-- --------------------------------------------------------

--
-- Structure de la table `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL,
  `export_type` varchar(10) NOT NULL,
  `template_name` varchar(64) NOT NULL,
  `template_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

--
-- Déchargement des données de la table `pma__export_templates`
--

INSERT INTO `pma__export_templates` (`id`, `username`, `export_type`, `template_name`, `template_data`) VALUES
(1, 'root', 'server', 'appliasso_bdd', '{\"quick_or_custom\":\"quick\",\"what\":\"sql\",\"db_select[]\":[\"appliasso_bdd\",\"bwob_bdd\",\"phpmyadmin\",\"test\",\"zdj62853\"],\"aliases_new\":\"\",\"output_format\":\"sendit\",\"filename_template\":\"@SERVER@\",\"remember_template\":\"on\",\"charset\":\"utf-8\",\"compression\":\"none\",\"maxsize\":\"\",\"codegen_structure_or_data\":\"data\",\"codegen_format\":\"0\",\"csv_separator\":\",\",\"csv_enclosed\":\"\\\"\",\"csv_escaped\":\"\\\"\",\"csv_terminated\":\"AUTO\",\"csv_null\":\"NULL\",\"csv_structure_or_data\":\"data\",\"excel_null\":\"NULL\",\"excel_columns\":\"something\",\"excel_edition\":\"win\",\"excel_structure_or_data\":\"data\",\"json_structure_or_data\":\"data\",\"json_unicode\":\"something\",\"latex_caption\":\"something\",\"latex_structure_or_data\":\"structure_and_data\",\"latex_structure_caption\":\"Structure de la table @TABLE@\",\"latex_structure_continued_caption\":\"Structure de la table @TABLE@ (suite)\",\"latex_structure_label\":\"tab:@TABLE@-structure\",\"latex_relation\":\"something\",\"latex_comments\":\"something\",\"latex_mime\":\"something\",\"latex_columns\":\"something\",\"latex_data_caption\":\"Contenu de la table @TABLE@\",\"latex_data_continued_caption\":\"Contenu de la table @TABLE@ (suite)\",\"latex_data_label\":\"tab:@TABLE@-data\",\"latex_null\":\"\\\\textit{NULL}\",\"mediawiki_structure_or_data\":\"data\",\"mediawiki_caption\":\"something\",\"mediawiki_headers\":\"something\",\"htmlword_structure_or_data\":\"structure_and_data\",\"htmlword_null\":\"NULL\",\"ods_null\":\"NULL\",\"ods_structure_or_data\":\"data\",\"odt_structure_or_data\":\"structure_and_data\",\"odt_relation\":\"something\",\"odt_comments\":\"something\",\"odt_mime\":\"something\",\"odt_columns\":\"something\",\"odt_null\":\"NULL\",\"pdf_report_title\":\"\",\"pdf_structure_or_data\":\"data\",\"phparray_structure_or_data\":\"data\",\"sql_include_comments\":\"something\",\"sql_header_comment\":\"\",\"sql_use_transaction\":\"something\",\"sql_compatibility\":\"NONE\",\"sql_structure_or_data\":\"structure_and_data\",\"sql_create_table\":\"something\",\"sql_auto_increment\":\"something\",\"sql_create_view\":\"something\",\"sql_create_trigger\":\"something\",\"sql_backquotes\":\"something\",\"sql_type\":\"INSERT\",\"sql_insert_syntax\":\"both\",\"sql_max_query_size\":\"50000\",\"sql_hex_for_binary\":\"something\",\"sql_utc_time\":\"something\",\"texytext_structure_or_data\":\"structure_and_data\",\"texytext_null\":\"NULL\",\"yaml_structure_or_data\":\"data\",\"\":null,\"as_separate_files\":null,\"csv_removeCRLF\":null,\"csv_columns\":null,\"excel_removeCRLF\":null,\"json_pretty_print\":null,\"htmlword_columns\":null,\"ods_columns\":null,\"sql_dates\":null,\"sql_relation\":null,\"sql_mime\":null,\"sql_disable_fk\":null,\"sql_views_as_tables\":null,\"sql_metadata\":null,\"sql_drop_database\":null,\"sql_drop_table\":null,\"sql_if_not_exists\":null,\"sql_simple_view_export\":null,\"sql_view_current_user\":null,\"sql_or_replace_view\":null,\"sql_procedure_function\":null,\"sql_truncate\":null,\"sql_delayed\":null,\"sql_ignore\":null,\"texytext_columns\":null}');

-- --------------------------------------------------------

--
-- Structure de la table `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) NOT NULL,
  `tables` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Structure de la table `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL DEFAULT '',
  `db` varchar(64) NOT NULL DEFAULT '',
  `table` varchar(64) NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Structure de la table `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) NOT NULL,
  `item_name` varchar(64) NOT NULL,
  `item_type` varchar(64) NOT NULL,
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Structure de la table `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Structure de la table `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) NOT NULL,
  `tables` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Déchargement des données de la table `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{\"db\":\"appliasso_bdd\",\"table\":\"association\"},{\"db\":\"appliasso_bdd\",\"table\":\"evenement\"},{\"db\":\"appliasso_bdd\",\"table\":\"etudiant\"},{\"db\":\"appliasso_bdd\",\"table\":\"bureau\"},{\"db\":\"bwob_bdd\",\"table\":\"user\"},{\"db\":\"bwob_bdd\",\"table\":\"pays\"},{\"db\":\"bwob_bdd\",\"table\":\"annonce\"}]');

-- --------------------------------------------------------

--
-- Structure de la table `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) NOT NULL DEFAULT '',
  `master_table` varchar(64) NOT NULL DEFAULT '',
  `master_field` varchar(64) NOT NULL DEFAULT '',
  `foreign_db` varchar(64) NOT NULL DEFAULT '',
  `foreign_table` varchar(64) NOT NULL DEFAULT '',
  `foreign_field` varchar(64) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Structure de la table `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL DEFAULT '',
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `search_name` varchar(64) NOT NULL DEFAULT '',
  `search_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Structure de la table `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Structure de la table `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `display_field` varchar(64) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Structure de la table `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) NOT NULL,
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL,
  `prefs` text NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Structure de la table `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text NOT NULL,
  `schema_sql` text DEFAULT NULL,
  `data_sql` longtext DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Structure de la table `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Déchargement des données de la table `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2023-04-04 17:52:47', '{\"Console\\/Mode\":\"collapse\",\"lang\":\"fr\",\"NavigationWidth\":282}');

-- --------------------------------------------------------

--
-- Structure de la table `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) NOT NULL,
  `tab` varchar(64) NOT NULL,
  `allowed` enum('Y','N') NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Structure de la table `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) NOT NULL,
  `usergroup` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Index pour la table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Index pour la table `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Index pour la table `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Index pour la table `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Index pour la table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Index pour la table `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Index pour la table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Index pour la table `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Index pour la table `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Index pour la table `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Index pour la table `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Index pour la table `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Index pour la table `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Base de données : `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;
--
-- Base de données : `zdj62853`
--
CREATE DATABASE IF NOT EXISTS `zdj62853` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `zdj62853`;

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

CREATE TABLE `consultation` (
  `Id_Consultation` int(11) NOT NULL,
  `Date_Consultation` date DEFAULT NULL,
  `Compte_Rendu_Consultation` varchar(5000) DEFAULT NULL,
  `Id_Patient` int(11) DEFAULT NULL,
  `Id_Medecin` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

CREATE TABLE `medecin` (
  `Id_Medecin` int(11) NOT NULL,
  `Nom_Medecin` varchar(50) DEFAULT NULL,
  `Prenom_Medecin` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `medecin`
--

INSERT INTO `medecin` (`Id_Medecin`, `Nom_Medecin`, `Prenom_Medecin`) VALUES
(1, 'Zammouri', 'Amin'),
(2, 'Gaume', 'Antoine');

-- --------------------------------------------------------

--
-- Structure de la table `ordonnance`
--

CREATE TABLE `ordonnance` (
  `Id_Ordonnance` int(11) NOT NULL,
  `Date_Ordonnance` date DEFAULT NULL,
  `Detail_Medicament` varchar(5000) DEFAULT NULL,
  `Id_Consultation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `Id_Patient` int(11) NOT NULL,
  `Nom_Patient` varchar(50) DEFAULT NULL,
  `Prenom_Patient` varchar(50) DEFAULT NULL,
  `Sexe_Patient` varchar(50) DEFAULT NULL,
  `Adresse_Patient` varchar(50) DEFAULT NULL,
  `Ville_Patient` varchar(50) DEFAULT NULL,
  `Departement_Patient` varchar(50) DEFAULT NULL,
  `Date_Naissance_Patient` varchar(10) DEFAULT NULL,
  `Situation_Familiale_Patient` varchar(50) DEFAULT NULL,
  `Affiliation_Mutuelle` varchar(50) DEFAULT NULL,
  `Date_Creation_Dossier` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`Id_Patient`, `Nom_Patient`, `Prenom_Patient`, `Sexe_Patient`, `Adresse_Patient`, `Ville_Patient`, `Departement_Patient`, `Date_Naissance_Patient`, `Situation_Familiale_Patient`, `Affiliation_Mutuelle`, `Date_Creation_Dossier`) VALUES
(15, 'Alfredo', 'Alfred', 'Homme', NULL, 'AlfredCity', '21', '', 'Marie(e)', 'Alfredi', ''),
(16, 'Depit', 'Chloe', 'Femme', NULL, 'Antony', '92160', '1998-02-12', 'Celibataire', 'AIMA', '2023-02-21'),
(17, 'Encore', 'Unpatient', 'Femme', NULL, 'ici', 'oui', '2023-02-04', 'Celibataire', 'a', '2023-03-11');

-- --------------------------------------------------------

--
-- Structure de la table `rendez_vous`
--

CREATE TABLE `rendez_vous` (
  `Id_Rendez_Vous` int(11) NOT NULL,
  `Date_Rendez_Vous` date DEFAULT NULL,
  `Salle_Rendez_Vous` varchar(50) DEFAULT NULL,
  `Id_Patient` int(11) NOT NULL,
  `Id_Medecin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `rendez_vous`
--

INSERT INTO `rendez_vous` (`Id_Rendez_Vous`, `Date_Rendez_Vous`, `Salle_Rendez_Vous`, `Id_Patient`, `Id_Medecin`) VALUES
(1, '2023-02-28', 'a', 15, 2),
(2, '2023-03-05', 'Bureau du docteur', 15, 1),
(4, '2023-03-02', 'p212', 16, 1),
(6, '2023-02-24', 'P212', 15, 1),
(7, '2023-03-03', 'p212', 16, 1),
(8, '2023-03-04', 'A206', 16, 2);

-- --------------------------------------------------------

--
-- Structure de la table `secretaire`
--

CREATE TABLE `secretaire` (
  `Id_Secretaire` int(11) NOT NULL,
  `Nom_Secretaire` varchar(50) DEFAULT NULL,
  `Prenom_Secretaire` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `secretaire`
--

INSERT INTO `secretaire` (`Id_Secretaire`, `Nom_Secretaire`, `Prenom_Secretaire`) VALUES
(1, 'Secrétaire', 'Alfred');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `Id_Utilisateur` int(11) NOT NULL,
  `Login` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Type_Utilisateur` varchar(50) DEFAULT NULL,
  `Last_Login` date DEFAULT NULL,
  `Id_Medecin` int(11) DEFAULT NULL,
  `Id_Secretaire` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`Id_Utilisateur`, `Login`, `Password`, `Type_Utilisateur`, `Last_Login`, `Id_Medecin`, `Id_Secretaire`) VALUES
(1, 'secretaire', '123', 'Secretaire', NULL, NULL, 1),
(2, 'zammouri', '123', 'Medecin', NULL, 1, NULL),
(3, 'Gaumee', '123', 'Medecin', NULL, 2, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`Id_Consultation`),
  ADD KEY `FK_Consultation_Id_Patient` (`Id_Patient`),
  ADD KEY `FK_Consultation_Id_Medecin` (`Id_Medecin`);

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`Id_Medecin`);

--
-- Index pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  ADD PRIMARY KEY (`Id_Ordonnance`),
  ADD KEY `FK_Ordonnance_Id_Consultation` (`Id_Consultation`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`Id_Patient`);

--
-- Index pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD PRIMARY KEY (`Id_Rendez_Vous`),
  ADD KEY `FK_Rendez_Vous_Id_Patient` (`Id_Patient`),
  ADD KEY `FK_Rendez_Vous_Id_Medecin` (`Id_Medecin`);

--
-- Index pour la table `secretaire`
--
ALTER TABLE `secretaire`
  ADD PRIMARY KEY (`Id_Secretaire`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`Id_Utilisateur`),
  ADD KEY `FK_Utilisateur_Id_Medecin` (`Id_Medecin`),
  ADD KEY `FK_Utilisateur_Id_Secretaire` (`Id_Secretaire`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `consultation`
--
ALTER TABLE `consultation`
  MODIFY `Id_Consultation` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `medecin`
--
ALTER TABLE `medecin`
  MODIFY `Id_Medecin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  MODIFY `Id_Ordonnance` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `Id_Patient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  MODIFY `Id_Rendez_Vous` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `secretaire`
--
ALTER TABLE `secretaire`
  MODIFY `Id_Secretaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `Id_Utilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `FK_Consultation_Id_Medecin` FOREIGN KEY (`Id_Medecin`) REFERENCES `medecin` (`Id_Medecin`),
  ADD CONSTRAINT `FK_Consultation_Id_Patient` FOREIGN KEY (`Id_Patient`) REFERENCES `patient` (`Id_Patient`);

--
-- Contraintes pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  ADD CONSTRAINT `FK_Ordonnance_Id_Consultation` FOREIGN KEY (`Id_Consultation`) REFERENCES `consultation` (`Id_Consultation`);

--
-- Contraintes pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD CONSTRAINT `FK_Rendez_Vous_Id_Medecin` FOREIGN KEY (`Id_Medecin`) REFERENCES `medecin` (`Id_Medecin`),
  ADD CONSTRAINT `FK_Rendez_Vous_Id_Patient` FOREIGN KEY (`Id_Patient`) REFERENCES `patient` (`Id_Patient`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK_Utilisateur_Id_Medecin` FOREIGN KEY (`Id_Medecin`) REFERENCES `medecin` (`Id_Medecin`),
  ADD CONSTRAINT `FK_Utilisateur_Id_Secretaire` FOREIGN KEY (`Id_Secretaire`) REFERENCES `secretaire` (`Id_Secretaire`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
