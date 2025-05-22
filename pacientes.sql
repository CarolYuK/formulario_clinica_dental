-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-05-2025 a las 15:39:26
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pacientes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `dniNie` varchar(20) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `tratamiento` varchar(100) NOT NULL,
  `fechaRegistro` date NOT NULL,
  `fechaVisita` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`id`, `nombre`, `apellido`, `dniNie`, `telefono`, `email`, `tratamiento`, `fechaRegistro`, `fechaVisita`) VALUES
(1, 'Usuario', 'Beta', 'X1234567A', '637457454', 'usuario@gmail.com', 'Blanqueamiento Dental', '2025-05-20', '2025-05-20'),
(2, 'María', 'Cuenca', '453289A', '854236372', 'mcuenca@gmail.com', 'Odontopediatría', '2025-05-07', '2025-05-06'),
(3, 'Segovia', 'Martín', '892446X', '389354574', 'smatin@gmail.com', 'Estética Dental', '2025-05-06', '2025-05-01'),
(4, 'Connor', 'Kent', '4298442E', '834289206', 'superman@gmail.com', 'Blanqueamiento Dental', '2025-05-23', '2025-05-24'),
(5, 'Elena', 'Avalor', '3987534I', '636356735', ' princesa@gmail.com', 'Implantes Dentales', '2025-05-07', '2025-05-14'),
(6, 'Carol', 'Chaparro', 'X123456789E', '660786543', ' estudiante@digitech.com', 'Blanqueamiento Dental', '2025-05-01', '2025-05-13'),
(7, 'Paula', 'Montilla', 'Y987654321E', '660124578', ' estudiante2@digitech.com', 'Implantes Dentales', '2025-05-02', '2025-05-13'),
(8, 'Gonzalo', 'Malhablado', 'O28744526A', '94587639', ' gonzalom@gmail.com', 'Blanqueamiento Dental', '2025-05-07', '2025-05-24'),
(9, 'Mónica', 'Teruel', 'U824920T', '8935873', ' monicateruel@gmail.com', 'Ortodencia y Brackets', '2025-05-05', '2025-05-20'),
(10, 'Estrella', 'Solaris', '4242985Q', '3824285', ' solaris@gmail.com', 'Odontopediatría', '2025-05-06', '2025-05-14');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
