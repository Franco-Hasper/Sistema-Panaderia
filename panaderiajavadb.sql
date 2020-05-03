-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-05-2020 a las 01:50:11
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `panaderiajavadb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_razon_social` int(11) NOT NULL,
  `codigo_estado` int(11) NOT NULL,
  `codigo_tipo_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre`, `apellido`, `codigo_razon_social`, `codigo_estado`, `codigo_tipo_cliente`) VALUES
(1, 'Consumidor', 'Final', 1, 1, 1),
(2, 'Nahuel', 'Hernandez', 5, 1, 2),
(4, '132', '23', 6, 1, 2),
(5, 'hola', 'apellido', 7, 1, 2),
(6, '99999', '999999', 1, 1, 2),
(7, '13', '131', 1, 1, 2),
(8, 'gjgj', 'gjgj', 1, 1, 2),
(9, 'hol', 'aaa', 1, 1, 2),
(10, '54', '453', 1, 1, 2),
(11, '55', '554', 1, 2, 2),
(12, '88', '88', 1, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `corte_caja`
--

CREATE TABLE IF NOT EXISTS `corte_caja` (
  `id_corte_caja` int(11) NOT NULL AUTO_INCREMENT,
  `total_ingresos` double NOT NULL,
  `total_egresos` double NOT NULL,
  `balance` double NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `codigo_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_corte_caja`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `corte_caja`
--

INSERT INTO `corte_caja` (`id_corte_caja`, `total_ingresos`, `total_egresos`, `balance`, `fecha`, `codigo_estado`) VALUES
(1, 120, 60, 60, '2019-11-03 22:38:12', 1),
(2, 353, 4594, -4241, '2019-11-04 03:14:56', 2),
(3, 0, 100, -100, '2019-11-04 03:32:37', 1),
(4, 101, 10, 91, '2019-11-04 03:37:11', 1),
(5, 0, 250, -250, '2019-11-05 23:34:35', 2),
(6, 200, 10, 190, '2020-04-08 22:53:49', 1),
(7, 1956, 0, 1956, '2020-04-08 03:11:21', 2),
(8, 1956, 6262, -4306, '2020-04-08 03:12:44', 1),
(9, 1956, 6282, -4326, '2020-04-08 03:14:40', 2),
(10, 9545, 144, 9401, '2020-04-25 01:44:34', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE IF NOT EXISTS `cuenta` (
  `id_cuenta` int(11) NOT NULL AUTO_INCREMENT,
  `balance` double NOT NULL,
  `codigo_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id_cuenta`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`id_cuenta`, `balance`, `codigo_cliente`) VALUES
(1, 200, 2),
(2, 4100, 7),
(3, 321, 6),
(4, 655, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion_cliente`
--

CREATE TABLE IF NOT EXISTS `direccion_cliente` (
  `id_direccion_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_cliente` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `numero` int(11) NOT NULL,
  `codigo_tipo_domicilio` int(11) NOT NULL,
  `codigo_localidad` int(11) NOT NULL,
  PRIMARY KEY (`id_direccion_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `direccion_cliente`
--

INSERT INTO `direccion_cliente` (`id_direccion_cliente`, `codigo_cliente`, `nombre`, `numero`, `codigo_tipo_domicilio`, `codigo_localidad`) VALUES
(1, 1, 'Lavalle', 1224, 1, 1),
(2, 1, '132', 13, 2, 1),
(4, 5, '4141', 4141, 2, 1),
(5, 6, '99999', 999, 2, 3),
(6, 7, '444', 11111111, 1, 1),
(7, 4, '333oooo', 11111111, 1, 1),
(8, 7, '777777777777777', 447452757, 2, 2),
(9, 7, '323', 74, 1, 1),
(11, 7, '14412', 4224, 1, 1),
(12, 5, '44', 44, 1, 1),
(13, 8, 'gj', 541, 1, 1),
(14, 4, 'ggg', 6262, 1, 1),
(16, 10, '43', 453, 1, 1),
(17, 11, '55', 55, 1, 1),
(18, 2, '123', 123, 1, 1),
(19, 2, '12', 12, 1, 1),
(20, 12, '88', 88, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion_proveedor`
--

CREATE TABLE IF NOT EXISTS `direccion_proveedor` (
  `id_direccion_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_proveedor` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `numero` int(11) NOT NULL,
  `codigo_localidad` int(11) NOT NULL,
  PRIMARY KEY (`id_direccion_proveedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `direccion_proveedor`
--

INSERT INTO `direccion_proveedor` (`id_direccion_proveedor`, `codigo_proveedor`, `nombre`, `numero`, `codigo_localidad`) VALUES
(1, 1, 'Lavalle', 658, 1),
(2, 2, 'Corrientes', 9874, 2),
(3, 3, 'oooo', 214, 1),
(4, 4, 'Iguazu', 4658, 1),
(5, 5, 'ffff', 232323, 1),
(7, 6, '77', 77, 1),
(8, 4, '44', 44, 1),
(9, 1, '54', 43, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE IF NOT EXISTS `estado` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `valor` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id_estado`, `valor`) VALUES
(1, 'true'),
(2, 'false'),
(3, 'realizado'),
(4, 'pendiennte'),
(5, 'cancelado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gasto`
--

CREATE TABLE IF NOT EXISTS `gasto` (
  `id_gasto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `precio_total` double NOT NULL,
  `fecha` date NOT NULL,
  `codigo_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_gasto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `gasto`
--

INSERT INTO `gasto` (`id_gasto`, `descripcion`, `precio_total`, `fecha`, `codigo_estado`) VALUES
(1, 'mantenimiento de maquinarias', 15, '2019-10-30', 1),
(2, 'varios', 250, '2019-11-05', 2),
(3, 'oo', 45, '2020-04-06', 2),
(4, 'adad', 262, '2020-04-07', 2),
(5, 'ip', 542, '2020-04-07', 2),
(6, 'uouo', 6262, '2020-04-08', 1),
(7, 'asdd', 543, '2020-04-08', 2),
(8, 'fgdg', 875, '2020-04-17', 2),
(9, '41', 44, '2020-04-24', 1),
(10, '11', 100, '2020-04-24', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingreso_mat_prima`
--

CREATE TABLE IF NOT EXISTS `ingreso_mat_prima` (
  `id_ingreso_mat_prima` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_materia_prima` int(11) NOT NULL,
  `total_envases` double NOT NULL,
  `ud_por_envase` double NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `precio_total` double NOT NULL,
  `codigo_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_ingreso_mat_prima`),
  KEY `codigoMateriaPrima` (`codigo_materia_prima`),
  KEY `estado` (`codigo_estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=18 ;

--
-- Volcado de datos para la tabla `ingreso_mat_prima`
--

INSERT INTO `ingreso_mat_prima` (`id_ingreso_mat_prima`, `codigo_materia_prima`, `total_envases`, `ud_por_envase`, `fecha`, `precio_total`, `codigo_estado`) VALUES
(1, 1, 2, 10, '2019-09-04 03:00:00', 121, 1),
(5, 2, 102, 15, '2019-10-02 03:00:00', 22, 2),
(6, 3, 78, 69, '2020-04-16 03:00:00', 351063, 1),
(7, 1, 22, 22, '2019-11-04 03:00:00', 100, 1),
(8, 7, 10, 5, '2019-11-04 04:15:43', 200, 1),
(9, 2, 11, 11, '2019-11-05 02:57:04', 11, 1),
(10, 2, 123, 22, '2019-11-06 17:03:06', 30, 1),
(11, 11, 41, 41, '2020-04-03 22:00:47', 41, 1),
(12, 11, 44, 44, '2020-04-03 22:10:38', 44, 1),
(13, 12, 333, 333, '2020-04-03 22:11:09', 333, 1),
(14, 11, 20, 20, '2020-04-08 03:14:16', 20, 2),
(15, 5, 10, 10, '2020-04-21 01:15:57', 1111, 1),
(16, 5, 10, 111, '2020-04-21 01:16:02', 1111111, 1),
(17, 11, 10, 10, '2020-05-03 00:07:52', 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `iva`
--

CREATE TABLE IF NOT EXISTS `iva` (
  `id_iva` int(11) NOT NULL AUTO_INCREMENT,
  `porcentaje` float NOT NULL,
  `codigo_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_iva`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `iva`
--

INSERT INTO `iva` (`id_iva`, `porcentaje`, `codigo_estado`) VALUES
(1, 0.23, 2),
(2, 0.25, 2),
(3, 0.21, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localidad`
--

CREATE TABLE IF NOT EXISTS `localidad` (
  `id_localidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `cod_postal` int(11) NOT NULL,
  `codigo_provincia` int(11) NOT NULL,
  PRIMARY KEY (`id_localidad`),
  KEY `provincia` (`codigo_provincia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `localidad`
--

INSERT INTO `localidad` (`id_localidad`, `nombre`, `cod_postal`, `codigo_provincia`) VALUES
(1, 'Obera', 3360, 1),
(2, 'Apostoles', 3345, 1),
(3, '25 de Mayo', 4451, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE IF NOT EXISTS `marca` (
  `id_marca` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_marca`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`id_marca`, `nombre`) VALUES
(1, 'Andes'),
(2, 'Cañuela'),
(3, 'MariaClara');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiaprima_marca_proveedor`
--

CREATE TABLE IF NOT EXISTS `materiaprima_marca_proveedor` (
  `id_materiaprima_marca_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_materia_prima` int(11) NOT NULL,
  `codigo_marca` int(11) NOT NULL,
  `codigo_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`id_materiaprima_marca_proveedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `materiaprima_marca_proveedor`
--

INSERT INTO `materiaprima_marca_proveedor` (`id_materiaprima_marca_proveedor`, `codigo_materia_prima`, `codigo_marca`, `codigo_proveedor`) VALUES
(1, 1, 2, 6),
(2, 1, 1, 1),
(3, 2, 1, 1),
(4, 2, 1, 1),
(5, 3, 1, 1),
(6, 5, 1, 1),
(7, 6, 2, 2),
(8, 7, 1, 1),
(9, 8, 1, 3),
(10, 9, 1, 1),
(11, 10, 1, 1),
(12, 11, 1, 1),
(13, 12, 1, 1),
(14, 13, 1, 1),
(15, 14, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matprima`
--

CREATE TABLE IF NOT EXISTS `matprima` (
  `id_materia_prima` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(125) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_ud_medida` int(11) NOT NULL,
  `codigo_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_materia_prima`),
  KEY `u_medida` (`codigo_ud_medida`),
  KEY `estado` (`codigo_estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=15 ;

--
-- Volcado de datos para la tabla `matprima`
--

INSERT INTO `matprima` (`id_materia_prima`, `nombre`, `codigo_ud_medida`, `codigo_estado`) VALUES
(1, 'ggo', 1, 1),
(2, 'llll', 1, 2),
(3, 'uuuuu', 1, 2),
(4, 'uuuu', 1, 1),
(5, 'Prueba', 1, 1),
(6, 'adad', 1, 2),
(7, 'Harina', 2, 2),
(8, 'hhh', 1, 1),
(9, 'tt', 1, 1),
(10, 'jppjp', 1, 1),
(11, 'ppp', 1, 1),
(12, 'hiu', 1, 1),
(13, 'yii', 1, 1),
(14, 'uu', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matprima_marca`
--

CREATE TABLE IF NOT EXISTS `matprima_marca` (
  `id_materia_prima_marca` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_materia_prima` int(11) NOT NULL,
  `codigo_marca` int(11) NOT NULL,
  PRIMARY KEY (`id_materia_prima_marca`),
  KEY `idmatprima` (`codigo_materia_prima`),
  KEY `idmarca` (`codigo_marca`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=26 ;

--
-- Volcado de datos para la tabla `matprima_marca`
--

INSERT INTO `matprima_marca` (`id_materia_prima_marca`, `codigo_materia_prima`, `codigo_marca`) VALUES
(1, 1, 1),
(12, 14, 3),
(13, 15, 3),
(14, 16, 1),
(15, 17, 1),
(16, 5, 1),
(17, 6, 2),
(18, 7, 1),
(19, 8, 1),
(20, 9, 1),
(21, 10, 1),
(22, 11, 1),
(23, 12, 1),
(24, 13, 1),
(25, 14, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matprima_proveedor`
--

CREATE TABLE IF NOT EXISTS `matprima_proveedor` (
  `id_materiaprima_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_materia_prima` int(11) NOT NULL,
  `codigo_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`id_materiaprima_proveedor`),
  KEY `idmatprima` (`codigo_materia_prima`),
  KEY `idproveedor` (`codigo_proveedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=22 ;

--
-- Volcado de datos para la tabla `matprima_proveedor`
--

INSERT INTO `matprima_proveedor` (`id_materiaprima_proveedor`, `codigo_materia_prima`, `codigo_proveedor`) VALUES
(1, 1, 1),
(8, 14, 2),
(9, 15, 3),
(10, 16, 1),
(11, 17, 1),
(12, 5, 1),
(13, 6, 2),
(14, 7, 1),
(15, 8, 3),
(16, 9, 1),
(17, 10, 1),
(18, 11, 1),
(19, 12, 1),
(20, 13, 1),
(21, 14, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento_cuenta`
--

CREATE TABLE IF NOT EXISTS `movimiento_cuenta` (
  `id_movimiento_cuenta` int(11) NOT NULL AUTO_INCREMENT,
  `motivo` varchar(90) COLLATE utf8_spanish_ci NOT NULL,
  `monto` double NOT NULL,
  `balance` double NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `codigo_cuenta` int(11) NOT NULL,
  PRIMARY KEY (`id_movimiento_cuenta`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=43 ;

--
-- Volcado de datos para la tabla `movimiento_cuenta`
--

INSERT INTO `movimiento_cuenta` (`id_movimiento_cuenta`, `motivo`, `monto`, `balance`, `fecha`, `codigo_cuenta`) VALUES
(20, 'Monto Inicial', 100, 100, '2020-04-06 03:03:37', 1),
(36, 'k', 100, 200, '2020-04-05 22:29:49', 1),
(37, 'Monto Inicial', 2000, 2000, '2020-04-20 22:09:14', 2),
(38, 'asd', 2100, 4100, '2020-04-20 22:09:24', 2),
(40, 'Monto Inicial', 321, 321, '2020-04-23 20:33:48', 3),
(41, 'Monto Inicial', 600, 600, '2020-04-25 01:15:29', 4),
(42, '788', 55, 655, '2020-04-25 01:16:00', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precio_materia_prima`
--

CREATE TABLE IF NOT EXISTS `precio_materia_prima` (
  `id_precio_materia_prima` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_materia_prima` int(11) NOT NULL,
  `precio_bruto_unidad` double NOT NULL,
  `fecha` date NOT NULL,
  `precio_total_unidad` double NOT NULL,
  `codigo_iva` int(11) NOT NULL,
  `codigo_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_precio_materia_prima`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `precio_materia_prima`
--

INSERT INTO `precio_materia_prima` (`id_precio_materia_prima`, `codigo_materia_prima`, `precio_bruto_unidad`, `fecha`, `precio_total_unidad`, `codigo_iva`, `codigo_estado`) VALUES
(1, 1, 10, '2019-10-03', 12, 1, 1),
(2, 2, 13, '2019-10-10', 14, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precio_producto`
--

CREATE TABLE IF NOT EXISTS `precio_producto` (
  `id_precio` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_producto` int(11) NOT NULL,
  `precio_bruto` float NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `precio_total` float NOT NULL,
  `codigo_iva` int(11) NOT NULL,
  `codigo_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_precio`),
  KEY `iva` (`codigo_iva`),
  KEY `idproducto` (`codigo_producto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `precio_producto`
--

INSERT INTO `precio_producto` (`id_precio`, `codigo_producto`, `precio_bruto`, `fecha`, `precio_total`, `codigo_iva`, `codigo_estado`) VALUES
(1, 1, 23, '2019-10-17 03:00:00', 25.22, 1, 2),
(2, 1, 44, '2019-10-18 03:00:00', 46, 1, 2),
(3, 2, 23, '2019-10-12 03:00:00', 460.33, 1, 2),
(4, 2, 777, '2019-10-25 03:00:00', 1000.21, 1, 2),
(5, 2, 777, '2019-10-31 03:00:00', 900, 1, 2),
(6, 2, 23, '2019-11-07 03:00:00', 230, 1, 2),
(7, 1, 44, '2019-11-13 03:00:00', 120, 1, 1),
(8, 2, 36, '2019-12-11 03:00:00', 652, 1, 1),
(9, 3, 250, '2019-11-04 03:00:00', 302.5, 3, 1),
(10, 4, 51, '2019-11-04 03:00:00', 61.71, 3, 1),
(11, 5, 60, '2019-11-04 03:00:00', 72.6, 3, 2),
(12, 6, 22, '2020-04-24 22:31:47', 26.62, 3, 1),
(13, 5, 10, '2020-04-24 23:35:23', 12.1, 3, 2),
(14, 5, 5445, '2020-04-24 23:38:25', 6588.45, 3, 2),
(15, 5, 44, '2020-04-25 01:18:17', 53.24, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `estado` (`codigo_estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`, `descripcion`, `codigo_estado`) VALUES
(1, 'Pan', 'panificados', 1),
(2, 'torraditas', 'aaaaaaa', 2),
(3, 'Torta', 'Dulces', 1),
(4, '41', '41', 1),
(5, 'gaspacho', 'nd', 1),
(6, '22', '22', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_venta`
--

CREATE TABLE IF NOT EXISTS `producto_venta` (
  `id_producto_venta` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_producto` int(11) NOT NULL,
  `total_unidades` double NOT NULL,
  `codigo_venta` int(11) NOT NULL,
  PRIMARY KEY (`id_producto_venta`),
  KEY `idproducto` (`codigo_producto`),
  KEY `idpedido` (`codigo_venta`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=66 ;

--
-- Volcado de datos para la tabla `producto_venta`
--

INSERT INTO `producto_venta` (`id_producto_venta`, `codigo_producto`, `total_unidades`, `codigo_venta`) VALUES
(1, 1, 5, 1),
(3, 1, 2, 5),
(5, 2, 10, 8),
(6, 2, 3, 10),
(7, 4, 7, 11),
(8, 1, 10, 12),
(9, 5, 5, 13),
(10, 3, 5, 14),
(12, 3, 3, 16),
(13, 2, 3, 17),
(14, 2, 20, 18),
(15, 3, 1, 19),
(16, 1, 1, 20),
(34, 2, 1, 21),
(35, 2, 1, 21),
(36, 2, 1, 21),
(37, 1, 1, 22),
(39, 5, 5, 15),
(40, 2, 4, 23),
(41, 1, 4, 7),
(42, 3, 4, 7),
(43, 3, 4, 7),
(44, 3, 4, 7),
(45, 1, 1, 24),
(46, 2, 1, 24),
(47, 3, 1, 24),
(48, 1, 12, 25),
(49, 1, 12, 25),
(50, 1, 12, 25),
(51, 1, 12, 25),
(52, 1, 12, 25),
(53, 1, 12, 25),
(54, 2, 12, 25),
(55, 2, 12, 25),
(56, 3, 12, 25),
(57, 3, 12, 25),
(59, 3, 10, 27),
(60, 3, 10, 27),
(62, 2, 10, 26),
(63, 2, 7, 26),
(64, 1, 4, 28),
(65, 2, 74, 28);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE IF NOT EXISTS `proveedor` (
  `id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `codigo_estado` int(11) NOT NULL,
  PRIMARY KEY (`id_proveedor`),
  KEY `estado` (`codigo_estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id_proveedor`, `nombre`, `codigo_estado`) VALUES
(1, 'AndesDistribuciones', 1),
(2, 'MariaClaraDistribuciones', 1),
(3, 'EcoPanDistribuciones', 1),
(4, 'Amarilla Gas', 1),
(5, 'dlgdg', 1),
(6, '77', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE IF NOT EXISTS `provincia` (
  `id_provincia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_provincia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`id_provincia`, `nombre`) VALUES
(1, 'Misiones'),
(2, 'Corrientes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `razon_social`
--

CREATE TABLE IF NOT EXISTS `razon_social` (
  `id_razon_social` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_razon_social`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `razon_social`
--

INSERT INTO `razon_social` (`id_razon_social`, `nombre`) VALUES
(1, 'Particular'),
(2, 'Escuela 309'),
(5, '13'),
(6, '23'),
(7, '6541');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefono_cliente`
--

CREATE TABLE IF NOT EXISTS `telefono_cliente` (
  `id_telefono` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_cliente` int(11) NOT NULL,
  `numero` decimal(15,0) NOT NULL,
  `codigo_tipo_telefono` int(11) NOT NULL,
  PRIMARY KEY (`id_telefono`),
  KEY `tipo` (`codigo_tipo_telefono`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `telefono_cliente`
--

INSERT INTO `telefono_cliente` (`id_telefono`, `codigo_cliente`, `numero`, `codigo_tipo_telefono`) VALUES
(1, 1, '3755324', 1),
(3, 1, '999999', 1),
(5, 5, '4141', 1),
(7, 7, '123', 1),
(8, 5, '99', 1),
(10, 5, '6546', 1),
(11, 4, '4', 1),
(12, 8, '411', 1),
(13, 2, '2030', 1),
(14, 2, '6699', 1),
(15, 9, '453', 1),
(16, 10, '453', 1),
(17, 11, '55', 1),
(18, 5, '76', 1),
(19, 12, '88', 1),
(20, 9, '444', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefono_proveedor`
--

CREATE TABLE IF NOT EXISTS `telefono_proveedor` (
  `id_telefono_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_proveedor` int(11) NOT NULL,
  `numero` decimal(11,0) NOT NULL,
  `codigo_tipo_telefono` int(11) NOT NULL,
  PRIMARY KEY (`id_telefono_proveedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `telefono_proveedor`
--

INSERT INTO `telefono_proveedor` (`id_telefono_proveedor`, `codigo_proveedor`, `numero`, `codigo_tipo_telefono`) VALUES
(2, 2, '3755', 1),
(3, 3, '659884', 2),
(4, 4, '57445', 2),
(5, 5, '95959', 2),
(6, 5, '41', 1),
(7, 6, '77', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_cliente`
--

CREATE TABLE IF NOT EXISTS `tipo_cliente` (
  `id_tipo_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_tipo_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tipo_cliente`
--

INSERT INTO `tipo_cliente` (`id_tipo_cliente`, `nombre`) VALUES
(1, 'consumidor final'),
(2, 'cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_domicilio`
--

CREATE TABLE IF NOT EXISTS `tipo_domicilio` (
  `id_tipo_domicilio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_tipo_domicilio`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tipo_domicilio`
--

INSERT INTO `tipo_domicilio` (`id_tipo_domicilio`, `nombre`) VALUES
(1, 'recidencia'),
(2, 'envio');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_telefono`
--

CREATE TABLE IF NOT EXISTS `tipo_telefono` (
  `id_tipo_telefono` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_tipo_telefono`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tipo_telefono`
--

INSERT INTO `tipo_telefono` (`id_tipo_telefono`, `nombre`) VALUES
(1, 'fijo'),
(2, 'movil');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_venta`
--

CREATE TABLE IF NOT EXISTS `tipo_venta` (
  `id_tipo_venta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_tipo_venta`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `tipo_venta`
--

INSERT INTO `tipo_venta` (`id_tipo_venta`, `nombre`) VALUES
(1, 'venta simple'),
(2, 'pedido');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `udmedida`
--

CREATE TABLE IF NOT EXISTS `udmedida` (
  `id_unidad_de_medida` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_unidad_de_medida`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `udmedida`
--

INSERT INTO `udmedida` (`id_unidad_de_medida`, `nombre`) VALUES
(1, 'Lts.'),
(2, 'Kgs.'),
(3, 'Uds.'),
(4, 'Otros.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE IF NOT EXISTS `venta` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_cliente` int(11) NOT NULL,
  `fecha_hora_venta` datetime NOT NULL,
  `preciototal` double NOT NULL,
  `codigo_estado` int(11) NOT NULL,
  `codigo_tipo_venta` int(11) NOT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `idtipo` (`codigo_tipo_venta`),
  KEY `idestadoventa` (`codigo_estado`),
  KEY `idcliente` (`codigo_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=29 ;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `codigo_cliente`, `fecha_hora_venta`, `preciototal`, `codigo_estado`, `codigo_tipo_venta`) VALUES
(1, 1, '2019-10-02 08:27:10', 230, 2, 1),
(2, 1, '2019-11-04 10:00:00', 250, 2, 1),
(5, 1, '2019-11-06 00:00:00', 1200, 2, 1),
(7, 1, '2020-04-12 00:18:40', 4110, 2, 1),
(8, 1, '2019-11-06 00:00:00', 6520, 2, 2),
(10, 6, '2020-04-07 17:37:08', 5868, 2, 2),
(11, 7, '2020-04-07 17:38:02', 431, 4, 2),
(12, 2, '2020-04-07 18:35:27', 1200, 2, 2),
(13, 2, '2020-04-07 20:28:42', 363, 2, 1),
(14, 1, '2020-04-07 20:32:11', 1512.5, 2, 1),
(15, 7, '2020-04-07 20:39:16', 363, 2, 1),
(16, 2, '2020-04-08 00:00:00', 1956, 2, 2),
(17, 2, '2020-04-07 23:21:34', 1956, 2, 2),
(18, 1, '2020-04-10 00:17:49', 13040, 2, 1),
(19, 5, '2020-04-10 18:25:04', 1074.5, 2, 1),
(20, 1, '2020-04-10 18:32:03', 1497, 2, 1),
(21, 1, '2020-04-11 21:32:02', 1956, 2, 1),
(22, 8, '2020-04-11 23:33:36', 120, 2, 1),
(23, 2, '2020-04-11 23:34:52', 2608, 3, 1),
(24, 1, '2020-04-14 00:19:41', 1074.5, 3, 1),
(25, 5, '2020-04-14 18:53:59', 31548, 3, 1),
(26, 7, '2020-04-24 00:00:00', 11084, 3, 1),
(27, 7, '2020-04-24 22:25:49', 6050, 3, 1),
(28, 5, '2020-04-25 00:00:00', 48728, 4, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
