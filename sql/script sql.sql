-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE Email (
ID numeric(4) PRIMARY KEY,
IdPessoa numeric(4),
 varchar(50)
)

CREATE TABLE DoadoDoador (
ID numeric(4) PRIMARY KEY,
idDoador numeric(4),
idItem numeric(4)
)

CREATE TABLE ValorDoador (
ID numeric(4) PRIMARY KEY,
idDoador numeric(4),
idValor numeric(4)
)

CREATE TABLE ValoresDoados (
ID numeric(4) PRIMARY KEY,
Valor numeric(20),
dataDoado date,
idCampanha numeric(4)
)

CREATE TABLE Endereco (
ID numeric(4) PRIMARY KEY,
Logradouro varchar(10),
NomeLogradouro varchar(50),
Numero numeric(4),
Municipio varchar(45),
UF varchar(2)
)

CREATE TABLE Telefone/Celular (
ID numeric(4) PRIMARY KEY,
idPessoa numeric(4),
Numero numeric(20),
Tipo Boolean
)

CREATE TABLE Tel/CelInstituicao (
ID numeric(4) PRIMARY KEY,
idInstituicao numeric(4),
Numero numeric(20),
Tipo Boolean
)

CREATE TABLE EnderecoPessoa (
ID numeric(4) PRIMARY KEY,
idPessoa numeric(4),
idEndereco numeric(4),
FOREIGN KEY(idEndereco) REFERENCES Endereco (ID)
)

CREATE TABLE Instituicao (
ID numeric(4) PRIMARY KEY,
Nome varchar(50),
tipo varchar(15),
CNJP varchar(19)
)

CREATE TABLE EnderecoIstituicao (
ID numeric(4) PRIMARY KEY,
idInstituicao numeric(4),
idEndereco numeric(4),
FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID),
FOREIGN KEY(idEndereco) REFERENCES Endereco (ID)
)

CREATE TABLE Responsavel (
ID numeric(4) PRIMARY KEY,
idPessoa numeric(4),
idEvento numeric(4)
)

CREATE TABLE Voluntario (
ID numeric(4) PRIMARY KEY,
idPessoa numeric(4),
IDEvento numeric(4)
)

CREATE TABLE Doador (
ID numeric(4) PRIMARY KEY,
idPessoa numeric(4)
)

CREATE TABLE Arrecadacao (
ID numeric(4) PRIMARY KEY,
Quantidade numeric(5),
idItem numeric(4),
Duracao numeric(4),
ID_Evento numeric(4)
)

CREATE TABLE EmailInstituicao (
ID numeric(4) PRIMARY KEY,
idInstituicao numeric(4),
Email varchar(50),
FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID)
)

CREATE TABLE InstituicaoEvento (
ID numeric(4) PRIMARY KEY,
idInstuicao numeric(4),
IdEvento numeric(4),
FOREIGN KEY(idInstuicao) REFERENCES Instituicao (ID)
)

CREATE TABLE Evento (
ID numeric(4) PRIMARY KEY,
idEndereco numeric(4),
Data date(8),
Nome varchar(50),
FOREIGN KEY(idEndereco) REFERENCES Endereco (ID)
)

CREATE TABLE Divulgacao (
ID numeric(4) PRIMARY KEY,
dataInicial date,
dataFinal date,
idEvento numeric(4),
idInstituicao numeric(4),
FOREIGN KEY(idEvento) REFERENCES Evento (ID),
FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID)
)

CREATE TABLE Pessoa (
ID numeric(4) PRIMARY KEY,
Nome varchar(50),
Sobrenome varchar(50),
CPF varchar(15),
RG varchar,
Penalisado boolean
)

CREATE TABLE ItemDoado (
ID numeric(4) PRIMARY KEY,
dataDoado date,
idArrecadacao numeric(4),
observacao varchar(100),
idIten numeric(4),
FOREIGN KEY(idArrecadacao) REFERENCES Arrecadacao (ID)
)

CREATE TABLE Item (
ID numeric(4) PRIMARY KEY,
Item varchar(50)
)

CREATE TABLE Campanha (
ID numeric(4) PRIMARY KEY,
Meta numeric(10),
Moeda varchar(7),
Duracao date,
ID_Evento numeric(4),
FOREIGN KEY(ID_Evento) REFERENCES Evento (ID)
)

ALTER TABLE Email ADD FOREIGN KEY(IdPessoa) REFERENCES Pessoa (ID)
ALTER TABLE DoadoDoador ADD FOREIGN KEY(idDoador) REFERENCES Doador (ID)
ALTER TABLE DoadoDoador ADD FOREIGN KEY(idItem) REFERENCES ItemDoado (ID)
ALTER TABLE ValorDoador ADD FOREIGN KEY(idDoador) REFERENCES Doador (ID)
ALTER TABLE ValorDoador ADD FOREIGN KEY(idValor) REFERENCES ValoresDoados (ID)
ALTER TABLE ValoresDoados ADD FOREIGN KEY(idCampanha) REFERENCES Campanha (ID)
ALTER TABLE Telefone/Celular ADD FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID)
ALTER TABLE Tel/CelInstituicao ADD FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID)
ALTER TABLE EnderecoPessoa ADD FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID)
ALTER TABLE Responsavel ADD FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID)
ALTER TABLE Responsavel ADD FOREIGN KEY(idEvento) REFERENCES Evento (ID)
ALTER TABLE Voluntario ADD FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID)
ALTER TABLE Voluntario ADD FOREIGN KEY(IDEvento) REFERENCES Evento (ID)
ALTER TABLE Doador ADD FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID)
ALTER TABLE Arrecadacao ADD FOREIGN KEY(idItem) REFERENCES Item (ID)
ALTER TABLE Arrecadacao ADD FOREIGN KEY(ID_Evento) REFERENCES Evento (ID)
ALTER TABLE InstituicaoEvento ADD FOREIGN KEY(IdEvento) REFERENCES Evento (ID)
ALTER TABLE ItemDoado ADD FOREIGN KEY(idIten) REFERENCES Item (ID)
