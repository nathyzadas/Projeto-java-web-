-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 15-Ago-2023 às 21:19
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `fourbarber`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `admin`
--

CREATE TABLE `admin` (
  `idAdmin` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `login` varchar(100) NOT NULL,
  `senha` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `admin`
--

INSERT INTO `admin` (`idAdmin`, `nome`, `login`, `senha`) VALUES
(1, 'admin', 'admin@gmail.com', '12345678');

-- --------------------------------------------------------

--
-- Estrutura da tabela `agenda`
--

CREATE TABLE `agenda` (
  `idAgenda` int(11) NOT NULL,
  `dataAgenda` varchar(100) NOT NULL,
  `horaAgenda` varchar(100) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `nomeServico` varchar(100) NOT NULL,
  `nomeFuncionario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `idProduto` int(11) NOT NULL,
  `nomeProduto` varchar(255) NOT NULL,
  `descProduto` text DEFAULT NULL,
  `fotoProduto` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbagenda`
--

CREATE TABLE `tbagenda` (
  `idAgenda` int(11) NOT NULL,
  `dataAgenda` varchar(10) NOT NULL,
  `horaAgenda` varchar(5) NOT NULL,
  `idServico` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idFuncionario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbagenda`
--

INSERT INTO `tbagenda` (`idAgenda`, `dataAgenda`, `horaAgenda`, `idServico`, `idcliente`, `idFuncionario`) VALUES
(19, '08/08/2023', '10:10', 20, 23, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcliente`
--

CREATE TABLE `tbcliente` (
  `idcliente` int(11) NOT NULL,
  `nomeCliente` varchar(100) DEFAULT NULL,
  `cpfCliente` varchar(14) DEFAULT NULL,
  `celularCliente` varchar(14) DEFAULT NULL,
  `emailCliente` varchar(100) DEFAULT NULL,
  `senha` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbcliente`
--

INSERT INTO `tbcliente` (`idcliente`, `nomeCliente`, `cpfCliente`, `celularCliente`, `emailCliente`, `senha`) VALUES
(23, 'juliana', '123.456.789-10', '(21)9999-9991', 'juliana@gmail.com', '12345678'),
(24, 'wan', '123.456.789-80', '(21)91234-5678', 'wan@gmail.com', '12345678'),
(28, 'abcd', '123.456.789-14', '(21)2345-6789', 'abc@gmail.com', '12345678'),
(29, 'abcd', '123.456.789-14', '(21)2345-6789', 'abcde@gmail.com', '12345678'),
(30, 'yyyyyyyy', '123.456.789-23', '(21)3456-7890', 'yy@gmail.com', '12345678');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcontato`
--

CREATE TABLE `tbcontato` (
  `idContato` int(11) NOT NULL,
  `emailContato` varchar(100) DEFAULT NULL,
  `textoContato` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbcontato`
--

INSERT INTO `tbcontato` (`idContato`, `emailContato`, `textoContato`) VALUES
(8, 'juliana@gmail.com', 'kjhuhuhhuho');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbfuncionario`
--

CREATE TABLE `tbfuncionario` (
  `idFuncionario` int(11) NOT NULL,
  `nomeFuncionario` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbfuncionario`
--

INSERT INTO `tbfuncionario` (`idFuncionario`, `nomeFuncionario`) VALUES
(1, 'Mariana'),
(2, 'Cauan'),
(3, 'Gabriel'),
(4, 'Julio');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbproduto`
--

CREATE TABLE `tbproduto` (
  `idProduto` int(11) NOT NULL,
  `nomeProduto` varchar(100) DEFAULT NULL,
  `descProduto` varchar(100) DEFAULT NULL,
  `fotoProduto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbservico`
--

CREATE TABLE `tbservico` (
  `idServico` int(11) NOT NULL,
  `nomeServico` varchar(50) NOT NULL,
  `fotoServico` varchar(255) NOT NULL,
  `descServico` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tbservico`
--

INSERT INTO `tbservico` (`idServico`, `nomeServico`, `fotoServico`, `descServico`) VALUES
(20, 'Barba', '5.barba.jpg', 'kjnjksanjkcnak');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Índices para tabela `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`idAgenda`);

--
-- Índices para tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`idProduto`);

--
-- Índices para tabela `tbagenda`
--
ALTER TABLE `tbagenda`
  ADD PRIMARY KEY (`idAgenda`),
  ADD KEY `fk_id_cliente` (`idcliente`),
  ADD KEY `fk_id_servico` (`idServico`),
  ADD KEY `fk_tbagenda_tbfuncionario` (`idFuncionario`);

--
-- Índices para tabela `tbcliente`
--
ALTER TABLE `tbcliente`
  ADD PRIMARY KEY (`idcliente`);

--
-- Índices para tabela `tbcontato`
--
ALTER TABLE `tbcontato`
  ADD PRIMARY KEY (`idContato`);

--
-- Índices para tabela `tbfuncionario`
--
ALTER TABLE `tbfuncionario`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- Índices para tabela `tbproduto`
--
ALTER TABLE `tbproduto`
  ADD PRIMARY KEY (`idProduto`);

--
-- Índices para tabela `tbservico`
--
ALTER TABLE `tbservico`
  ADD PRIMARY KEY (`idServico`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `admin`
--
ALTER TABLE `admin`
  MODIFY `idAdmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `agenda`
--
ALTER TABLE `agenda`
  MODIFY `idAgenda` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `idProduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `tbagenda`
--
ALTER TABLE `tbagenda`
  MODIFY `idAgenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de tabela `tbcontato`
--
ALTER TABLE `tbcontato`
  MODIFY `idContato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `tbfuncionario`
--
ALTER TABLE `tbfuncionario`
  MODIFY `idFuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tbproduto`
--
ALTER TABLE `tbproduto`
  MODIFY `idProduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de tabela `tbservico`
--
ALTER TABLE `tbservico`
  MODIFY `idServico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tbagenda`
--
ALTER TABLE `tbagenda`
  ADD CONSTRAINT `fk_id_cliente` FOREIGN KEY (`idCliente`) REFERENCES `tbcliente` (`idcliente`),
  ADD CONSTRAINT `fk_id_servico` FOREIGN KEY (`idServico`) REFERENCES `tbservico` (`idServico`),
  ADD CONSTRAINT `fk_tbagenda_tbfuncionario` FOREIGN KEY (`idFuncionario`) REFERENCES `tbfuncionario` (`idFuncionario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
