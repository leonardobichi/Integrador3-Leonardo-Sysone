-- Crear base de datos afa
CREATE DATABASE IF NOT EXISTS `afa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
-- Usar base de datos afa
USE `afa`;

-- Crear tabla equipos

CREATE TABLE `equipos` (
  `cuit` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Aplicar datos de los equipos

INSERT INTO `equipos` (`cuit`, `nombre`, `categoria`) VALUES
(11335599, 'River Plate', 'A'),
(12344321, 'Boca Juniors', 'A'),
(12345678, 'Racing', 'A'),
(12345666, 'Independiente', 'A'),
(12323442, 'Arsenal', 'A'),
(13434521, 'Lanús', 'A');

-- Crear tabla historial_jugadores

CREATE TABLE `historial_jugadores` (
  `id` int(11) NOT NULL,
  `dni_jugador` int(11) NOT NULL,
  `cuit_equipo` int(11) NOT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `posicion` enum('DELANTERO','DEFENSOR','MEDIOCAMPISTA','ARQUERO') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Aplicar los datos al historial_jugadores

INSERT INTO `historial_jugadores` (`id`, `dni_jugador`, `cuit_equipo`, `fecha_inicio`, `fecha_fin`, `posicion`) VALUES
(1, 42222221, 11335599, '2019-11-04', '2020-11-03', 'DELANTERO'),
(2, 42222222, 11335599, '2020-12-03', '2022-12-04', 'DELANTERO'),
(3, 42222223, 12344321, '2017-11-03', '2020-08-07', 'DELANTERO'),
(4, 42222224, 12344321, '2019-02-02', NULL, 'DEFENSOR'),
(5, 42222225, 12345678, '2019-10-25', NULL, 'DEFENSOR'),
(6, 42222226, 12345678, '2019-11-03', NULL, 'DEFENSOR'),
(7, 42222227, 12345666, '2019-11-03', NULL, 'MEDIOCAMPISTA'),
(8, 42222228, 12323442, '2019-11-03', NULL, 'MEDIOCAMPISTA'),
(9, 42222229, 13434521, '2019-11-03', NULL, 'ARQUERO');

-- Crear tabla jugadores

CREATE TABLE `jugadores` (
  `dni` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Aplicar datos de los jugadores

INSERT INTO `jugadores` (`dni`, `nombre`, `apellido`) VALUES
(42222221, 'Carlos', 'Tevez'),
(42222222, 'Gonzalo', 'Maroni'),
(42222223, 'Franco', 'Armani'),
(42222224, 'Javier', 'Mascherano'),
(42222225, 'Toto', 'Salvio'),
(42222226, 'Carlos', 'Izquierdoz'),
(42222227, 'Licha', 'Lopez'),
(42222228, 'Edwin', 'Cardona'),
(42222229, 'Carlos', 'Izquierdoz');

-- Identificador de la tabla equipos

ALTER TABLE `equipos`
  ADD PRIMARY KEY (`cuit`);
  
-- Identificador de la tabla historial_jugadores

ALTER TABLE `historial_jugadores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `dni_jugador` (`dni_jugador`),
  ADD KEY `cuit_equipo` (`cuit_equipo`);

-- Identificador de la tabla jugadores

ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`dni`);

-- Auto incremento de la tabla historial_jugadores

ALTER TABLE `historial_jugadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

-- Filtros de la tabla historial_jugadores

ALTER TABLE `historial_jugadores`
  ADD CONSTRAINT `historial_jugadores_ibfk_1` FOREIGN KEY (`dni_jugador`) REFERENCES `jugadores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `historial_jugadores_ibfk_2` FOREIGN KEY (`cuit_equipo`) REFERENCES `equipos` (`cuit`) ON DELETE CASCADE ON UPDATE CASCADE;

-- Confirmar cambio
  
COMMIT;