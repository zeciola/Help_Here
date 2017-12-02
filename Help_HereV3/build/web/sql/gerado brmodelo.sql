-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE Endereco (
ID serial PRIMARY KEY,
cep varchar(9),
NomeLogradouro varchar(50),
Numero numeric(4),
Bairro varchar(45),
Municipio varchar(45),
UF varchar(2),
pais varchar(45)
)

CREATE TABLE EmailInstituicao (
ID serial PRIMARY KEY,
idInstituicao serial,
Email varchar(50)
)

CREATE TABLE EnderecoIstituicao (
ID serial PRIMARY KEY,
idInstituicao serial,
idEndereco serial,
FOREIGN KEY(idEndereco) REFERENCES Endereco (ID)
)

CREATE TABLE TelCelInstituicao (
ID serial PRIMARY KEY,
idInstituicao serial,
Numero numeric(20),
Tipo Boolean
)

CREATE TABLE Pessoa (
ID serial PRIMARY KEY,
Nome varchar(50),
Sobrenome varchar(50),
CPF varchar(15),
RG varchar,
Penalisado boolean,
Datanascimento date,
email varchar(45),
IDEndereco serial,
Telefone varchar(19),
celular VARCHAR(20 ),
sexo varchar,
FOREIGN KEY(IDEndereco) REFERENCES Endereco (ID)
)

CREATE TABLE Instituicao (
ID serial PRIMARY KEY,
Nome varchar(50),
razaoSocial VARCHAR(50 ),
tipo varchar(15),
CNJP varchar(19),
Contato serial,
modalidade VARCHAR(50),
FOREIGN KEY(Contato) REFERENCES Pessoa (ID)
)

CREATE TABLE Evento_Instituicao (
ID numeric(4) PRIMARY KEY,
ID_INST serial,
ID_EVENTO serial,
FOREIGN KEY(ID_INST) REFERENCES Instituicao (ID)
)

CREATE TABLE Responsavel (
ID serial PRIMARY KEY,
idPessoa serial,
idEvento serial,
FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID)
)

CREATE TABLE Endereco_Evento (
ID numeric(4) PRIMARY KEY,
idEvento serial,
IdEndereco numeric(4)
)

CREATE TABLE Feeds (
id serial PRIMARY KEY,
idEvento serial,
idUsuario serial
)

CREATE TABLE Divulgacao (
ID serial PRIMARY KEY,
dataInicial date,
dataFinal date,
idEvento serial,
idInstituicao serial,
arquivo varchar(50),
FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID)
)

CREATE TABLE Interesses (
id serial PRIMARY KEY,
isUser serial,
Interesse varchar(45)
)

CREATE TABLE Usuario (
ID serial PRIMARY KEY,
IDPessoa serial,
Tipo varchar(15),
Login varchar(45),
senha varchar(45),
FOREIGN KEY(IDPessoa) REFERENCES Pessoa (ID)
)

CREATE TABLE InstituicaoPessoa (
ID serial PRIMARY KEY,
ID_Instituicao serial,
ID_Pessoa serial,
FOREIGN KEY(ID_Instituicao) REFERENCES Instituicao (ID),
FOREIGN KEY(ID_Pessoa) REFERENCES Pessoa (ID)
)

CREATE TABLE Evento (
ID serial PRIMARY KEY,
Data date,
Nome varchar(50),
dataInicio date,
dataFim date,
descricao varchar(100),
Meta numeric(10),
QuantVolu numeric(5),
ValorAtu numeric(10),
ConseguidoVolu numeric(4)
)

CREATE TABLE ValoresDoados (
ID serial PRIMARY KEY,
Valor numeric(20),
dataDoado date,
idCampanha serial,
idPessoa serial,
FOREIGN KEY(idCampanha) REFERENCES Evento (ID),
FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID)
)

CREATE TABLE Voluntario (
ID serial PRIMARY KEY,
idPessoa serial,
IDEvento serial,
DataVoluntario date,
FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID),
FOREIGN KEY(IDEvento) REFERENCES Evento (ID)
)

ALTER TABLE EmailInstituicao ADD FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID)
ALTER TABLE EnderecoIstituicao ADD FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID)
ALTER TABLE TelCelInstituicao ADD FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID)
ALTER TABLE Evento_Instituicao ADD FOREIGN KEY(ID_EVENTO) REFERENCES Evento (ID)
ALTER TABLE Responsavel ADD FOREIGN KEY(idEvento) REFERENCES Evento (ID)
ALTER TABLE Endereco_Evento ADD FOREIGN KEY(idEvento) REFERENCES Evento (ID)
ALTER TABLE Endereco_Evento ADD FOREIGN KEY(IdEndereco) REFERENCES Endereco_Evento (ID)
ALTER TABLE Feeds ADD FOREIGN KEY(idEvento) REFERENCES Evento (ID)
ALTER TABLE Feeds ADD FOREIGN KEY(idUsuario) REFERENCES Usuario (ID)
ALTER TABLE Divulgacao ADD FOREIGN KEY(idEvento) REFERENCES Evento (ID)
ALTER TABLE Interesses ADD FOREIGN KEY(isUser) REFERENCES Usuario (ID)
