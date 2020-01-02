-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-01-2020 a las 15:25:35
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `logisticsdemo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deactivation`
--

CREATE TABLE `deactivation` (
  `id` bigint(20) NOT NULL,
  `date_creation` date DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `item_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `deactivation`
--

INSERT INTO `deactivation` (`id`, `date_creation`, `reason`, `item_id`, `user_id`) VALUES
(12, '2020-01-02', '\"Nada\"', 1, 1),
(13, '2020-01-02', '\"Nada\"', 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `items`
--

CREATE TABLE `items` (
  `id` bigint(20) NOT NULL,
  `available` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  `date_creation` date DEFAULT NULL,
  `id_creator` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `items`
--

INSERT INTO `items` (`id`, `available`, `description`, `value`, `date_creation`, `id_creator`) VALUES
(1, 0, 'Item1', 2.5, '2020-01-01', 1),
(2, 0, 'Item2', 0.6, '0006-06-06', 1),
(3, 1, 'Item3', 6.66, '2020-01-01', 1),
(4, 1, 'Item4', 6.66, '2020-01-01', 1),
(5, 1, 'Item5', 6.66, '2020-01-01', 1),
(6, 1, 'ITem6', 6.66, '2020-01-01', 1),
(7, 1, 'Item7', 6.66, '2020-01-01', 1),
(8, 1, 'Item8', 0, '2020-01-01', 1),
(9, 1, 'Item9', 6.66, '2020-01-01', 1),
(10, 1, 'Item10', 6.66, '2020-01-01', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `itemsupplier`
--

CREATE TABLE `itemsupplier` (
  `id_item` bigint(20) NOT NULL,
  `id_supplier` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `itemsupplier`
--

INSERT INTO `itemsupplier` (`id_item`, `id_supplier`) VALUES
(4, 1),
(4, 2),
(1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pricereduction`
--

CREATE TABLE `pricereduction` (
  `Id` int(11) NOT NULL,
  `end_date` date DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `id_item` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pricereduction`
--

INSERT INTO `pricereduction` (`Id`, `end_date`, `quantity`, `start_date`, `id_item`) VALUES
(1, '0007-07-07', 2.3, '0005-05-05', 2),
(2, '0007-07-07', 2.2, '0006-06-06', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `supplier`
--

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL,
  `Name` varchar(280) NOT NULL,
  `Country` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `supplier`
--

INSERT INTO `supplier` (`id`, `Name`, `Country`) VALUES
(1, 'ACME', 'EEUU'),
(2, 'MERCADONA', 'ESPANA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `roles` varchar(30) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `active`, `roles`, `password`, `username`, `token`) VALUES
(1, 1, 'admin', '12345', 'Admin', NULL),
(2, 1, 'user', '12345', 'User', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usersecurity`
--

CREATE TABLE `usersecurity` (
  `id` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `login` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_items`
--

CREATE TABLE `user_items` (
  `user_id` bigint(20) NOT NULL,
  `items_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `deactivation`
--
ALTER TABLE `deactivation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbycu93gtmj12go7ue19qoyfe7` (`item_id`),
  ADD KEY `FK2sid2fuxbh1ohhx9momcy0qb5` (`user_id`);

--
-- Indices de la tabla `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKakbc7ltwxarijn16xb0lb3b19` (`id_creator`);

--
-- Indices de la tabla `itemsupplier`
--
ALTER TABLE `itemsupplier`
  ADD KEY `FK3e4prj4k6ppf1hynuh7wmdbis` (`id_supplier`),
  ADD KEY `FK399o2lp443b9e6sciwqp7sxlh` (`id_item`);

--
-- Indices de la tabla `pricereduction`
--
ALTER TABLE `pricereduction`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usersecurity`
--
ALTER TABLE `usersecurity`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user_items`
--
ALTER TABLE `user_items`
  ADD UNIQUE KEY `UK_tlo50fyjf4e0doh49qpdkiu8j` (`items_id`),
  ADD KEY `FKsc13vadlnprevdtur1i0h4y1d` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
