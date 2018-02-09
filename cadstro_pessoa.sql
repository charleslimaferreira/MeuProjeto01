

CREATE TABLE `pessoa` (
  `id_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  `cpf` char(11) DEFAULT NULL,
  `data_nascimento` date NOT NULL,
  `email` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_pessoa`)
);

CREATE TABLE `telefone` (
  `id_telefone` int(11) NOT NULL AUTO_INCREMENT,
  `ddd` char(2) DEFAULT NULL,
  `numero_telefone` char(9) DEFAULT NULL,
  PRIMARY KEY (`id_telefone`)
  CONTRAINTS FOREIGN KEY()
);

ALTER TABLE telefone ADD CONSTRAINT fk_pessoa FOREIGN KEY (id_telefone) REFERENCES telefone( id_pessoa);


