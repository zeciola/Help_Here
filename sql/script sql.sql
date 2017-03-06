-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE DoadoDoador (
ID numeric(5) PRIMARY KEY,
idDoador numeric(5),
idItem numeric(5)
)

CREATE TABLE ValorDoador (
ID numeric(5) PRIMARY KEY,
idDoador numeric(5),
idValor numeric(5)
)

CREATE TABLE ValoresDoados (
ID numeric(5) PRIMARY KEY,
Valor numeric(20),
dataDoado date,
idCampanha numeric(5)
)

CREATE TABLE Arrecadacao (
ID numeric(5) PRIMARY KEY,
Quantidade numeric(5),
idItem numeric(5),
Duracao numeric(4),
ID_Evento numeric(5)
)

CREATE TABLE Item (
ID numeric(5) PRIMARY KEY,
Item varchar(50)
)

CREATE TABLE Campanha (
ID numeric(5) PRIMARY KEY,
Meta numeric(10),
Moeda varchar(7),
Duracao date,
ID_Evento numeric(5)
)

CREATE TABLE ItemDoado (
ID numeric(5) PRIMARY KEY,
dataDoado date,
idArrecadacao numeric(5),
observacao varchar(100),
idIten numeric(5),
FOREIGN KEY(idArrecadacao) REFERENCES Arrecadacao (ID),
FOREIGN KEY(idIten) REFERENCES Item (ID)
)

CREATE TABLE Doador (
ID numeric(5) PRIMARY KEY,
idPessoa numeric(5)
)

CREATE TABLE Pessoa (
ID numeric(5) PRIMARY KEY,
Nome varchar(50),
Sobrenome varchar(50),
CPF varchar(15),
RG varchar,
Penalisado boolean,
Datanascimento date,
email varchar(45),
IDEndereco numeric(5),
Telefone varchar(19)
)

CREATE TABLE Endereco (
ID numeric(5) PRIMARY KEY,
cep varchar(9),
NomeLogradouro varchar(50),
Numero numeric(4),
Bairro varchar(45),
Municipio varchar(45),
UF varchar(2),
pais varchar(45)
)

CREATE TABLE Voluntario (
ID numeric(5) PRIMARY KEY,
idPessoa numeric(5),
IDEvento numeric(5),
FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID)
)

CREATE TABLE Divulgacao (
ID numeric(5) PRIMARY KEY,
dataInicial date,
dataFinal date,
idEvento numeric(5),
idInstituicao numeric(5),
arquivo varchar(50)
)

CREATE TABLE TelCelInstituicao (
ID numeric(5) PRIMARY KEY,
idInstituicao numeric(5),
Numero numeric(20),
Tipo Boolean
)

CREATE TABLE EmailInstituicao (
ID numeric(5) PRIMARY KEY,
idInstituicao numeric(5),
Email varchar(50)
)

CREATE TABLE InstituicaoEvento (
ID numeric(5) PRIMARY KEY,
idInstuicao numeric(4),
IdEvento numeric(4)
)

CREATE TABLE Evento (
ID numeric(5) PRIMARY KEY,
idEndereco numeric(5),
Data date,
Nome varchar(50),
FOREIGN KEY(idEndereco) REFERENCES Endereco (ID)
)

CREATE TABLE Responsavel (
ID numeric(5) PRIMARY KEY,
idPessoa numeric(5),
idEvento numeric(5),
FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID),
FOREIGN KEY(idEvento) REFERENCES Evento (ID)
)

CREATE TABLE Usuario (
ID numeric(5) PRIMARY KEY,
IDPessoa numeric(5),
Tipo varchar(15),
Login varchar(45),
senha varchar(45),
FOREIGN KEY(IDPessoa) REFERENCES Pessoa (ID)
)

CREATE TABLE Instituicao (
ID numeric(5) PRIMARY KEY,
Nome varchar(50),
tipo varchar(15),
CNJP varchar(19),
Contato numeric(5),
FOREIGN KEY(Contato) REFERENCES Pessoa (ID)
)

CREATE TABLE EnderecoIstituicao (
ID numeric(5) PRIMARY KEY,
idInstituicao numeric(5),
idEndereco numeric(5),
FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID),
FOREIGN KEY(idEndereco) REFERENCES Endereco (ID)
)

CREATE TABLE InstituicaoPessoa (
ID numeric(5) PRIMARY KEY,
ID_Instituicao numeric(5),
ID_Pessoa numeric(5),
FOREIGN KEY(ID_Instituicao) REFERENCES Instituicao (ID),
FOREIGN KEY(ID_Pessoa) REFERENCES Pessoa (ID)
)

ALTER TABLE DoadoDoador ADD FOREIGN KEY(idDoador) REFERENCES Doador (ID)
ALTER TABLE DoadoDoador ADD FOREIGN KEY(idItem) REFERENCES ItemDoado (ID)
ALTER TABLE ValorDoador ADD FOREIGN KEY(idDoador) REFERENCES Doador (ID)
ALTER TABLE ValorDoador ADD FOREIGN KEY(idValor) REFERENCES ValoresDoados (ID)
ALTER TABLE ValoresDoados ADD FOREIGN KEY(idCampanha) REFERENCES Campanha (ID)
ALTER TABLE Arrecadacao ADD FOREIGN KEY(idItem) REFERENCES Item (ID)
ALTER TABLE Arrecadacao ADD FOREIGN KEY(ID_Evento) REFERENCES Evento (ID)
ALTER TABLE Campanha ADD FOREIGN KEY(ID_Evento) REFERENCES Evento (ID)
ALTER TABLE Doador ADD FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID)
ALTER TABLE Pessoa ADD FOREIGN KEY(IDEndereco) REFERENCES Endereco (ID)
ALTER TABLE Voluntario ADD FOREIGN KEY(IDEvento) REFERENCES Evento (ID)
ALTER TABLE Divulgacao ADD FOREIGN KEY(idEvento) REFERENCES Evento (ID)
ALTER TABLE Divulgacao ADD FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID)
ALTER TABLE TelCelInstituicao ADD FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID)
ALTER TABLE EmailInstituicao ADD FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID)
ALTER TABLE InstituicaoEvento ADD FOREIGN KEY(idInstuicao) REFERENCES Instituicao (ID)
ALTER TABLE InstituicaoEvento ADD FOREIGN KEY(IdEvento) REFERENCES Evento (ID)
