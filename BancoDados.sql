create database BancoProjeto;
use BancoProjeto;
CREATE TABLE PessoaFisica (
  `idClienteF` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `nomePai` VARCHAR(45) NOT NULL,
  `nomeMae` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idClienteF`));

CREATE TABLE PessoaJuridica (
  `idClienteJ` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(45) NOT NULL,
  `nomeFantasia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idClienteJ`));

CREATE TABLE TipoServico (
  `idTipoServico` INT NOT NULL,
  `nomeServico` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoServico`));

INSERT INTO TipoServico (nomeServico) values ('Conta Corrente');
INSERT INTO TipoServico (nomeServico) values ('Conta Poupanca');
INSERT INTO TipoServico (nomeServico) values ('Seguro');
  
CREATE TABLE ServicoF (
  `idServico` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `numero` INT NOT NULL,
  `saldo` DOUBLE NOT NULL,
  `situacao` TINYINT NOT NULL,
  `idTipoServico` INT NOT NULL,
  PRIMARY KEY (`idServico`),
  INDEX `idCliente_idx` (`idCliente` ASC),
  INDEX `idTipoServico_idx` (`idTipoServico` ASC),
  CONSTRAINT `idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `PessoaFisica` (`idClienteF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idTipoServico`
    FOREIGN KEY (`idTipoServico`)
    REFERENCES `TipoServico` (`idTipoServico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    CREATE TABLE ServicoJ (
  `idServico` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `numero` INT NOT NULL,
  `saldo` DOUBLE NOT NULL,
  `situacao` TINYINT NOT NULL,
  `idTipoServico` INT NOT NULL,
  PRIMARY KEY (`idServico`),
  INDEX `idCliente_idx` (`idCliente` ASC),
  INDEX `idTipoServico_idx` (`idTipoServico` ASC),
  CONSTRAINT `idClienteJ`
    FOREIGN KEY (`idCliente`)
    REFERENCES `PessoaJuridica` (`idClienteJ`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idTipoServicoJ`
    FOREIGN KEY (`idTipoServico`)
    REFERENCES `TipoServico` (`idTipoServico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


