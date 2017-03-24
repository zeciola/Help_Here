CREATE TABLE Item (
ID numeric(5) PRIMARY KEY,
Item varchar(50),
peso real,
marca VARCHAR(20 ),
descricao VARCHAR(100 )
);

CREATE TABLE Doador (
ID numeric(5) PRIMARY KEY,
idPessoa numeric(5)
);

CREATE TABLE Endereco (
ID numeric(5) PRIMARY KEY   ,
cep varchar(9),
NomeLogradouro varchar(50),
Numero numeric(4),
Bairro varchar(45),
Municipio varchar(45),
Estado varchar(2),
Pais varchar(45)
);
-- insert into endereco values(1, '88888888', 'avenida admin', 10, 'vila admin', 'mogi', 'sp', 'brasil');
-- insert into endereco values(2, '88888888', 'avenida mariana', 10, 'vila mariana', 'mogi', 'sp', 'brasil');

CREATE TABLE Voluntario (
ID numeric(5) PRIMARY KEY,
idPessoa numeric(5),
IDEvento numeric(5)
);

CREATE TABLE Divulgacao (
ID numeric(5) PRIMARY KEY,
dataInicial date,
dataFinal date,
idEvento numeric(5),
idInstituicao numeric(5),
arquivo varchar(50)
);

CREATE TABLE EmailInstituicao (
ID numeric(5) PRIMARY KEY,
idInstituicao numeric(5),
Email varchar(50)
);

CREATE TABLE InstituicaoEvento (
ID numeric(5) PRIMARY KEY,
idInstuicao numeric(4),
IdEvento numeric(4)
);

CREATE TABLE Usuario (
ID numeric(5) PRIMARY KEY,
IDPessoa numeric(5),
Login varchar(45),
senha varchar(45),
Tipo varchar(15),
FOREIGN KEY(IDPessoa) REFERENCES Pessoa (ID)
);

-- drop table Usuario;
-- insert into Usuario values(1, 1, 'admin', 'admin', 'administrador');
-- insert into Usuario values(2, 2, 'comum', '123', 'comum');

CREATE TABLE Instituicao (
ID numeric(5) PRIMARY KEY,
Nome varchar(50),
razaoSocial VARCHAR(50 ),
tipo varchar(15), --checkbox com os tipos de Intituição: ONG, Igrejas, etc. 
CNJP varchar(19),
Contato numeric(5),
modalidade VARCHAR(50)
);

CREATE TABLE EnderecoIstituicao (
ID numeric(5) PRIMARY KEY,
idInstituicao numeric(5),
idEndereco numeric(5),
FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID),
FOREIGN KEY(idEndereco) REFERENCES Endereco (ID)
);

CREATE TABLE InstituicaoPessoa (
ID numeric(5) PRIMARY KEY,
ID_Instituicao numeric(5),
ID_Pessoa numeric(5),
FOREIGN KEY(ID_Instituicao) REFERENCES Instituicao (ID)
);

CREATE TABLE TelCelInstituicao (
ID numeric(5) PRIMARY KEY,
idInstituicao numeric(5),
Numero numeric(20),
Tipo Boolean,
FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID)
);

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
Telefone varchar(19),
celular VARCHAR(20 ),
sexo varchar,
FOREIGN KEY(IDEndereco) REFERENCES Endereco (ID)
);

-- insert into Pessoa values(1, 'admin', 'admin', '123','20',false,'01/01/1990','maria@email.com',1,'01147121212','0000000000','Masculino');
-- insert into Pessoa values(2, 'Maria', 'De Sa', '111', '22', false, '01/01/1990', 'maria@email.com', 1, '01147474747', '011959595955', 'Feminino');

-- drop table Pessoa cascade

CREATE TABLE Responsavel (
ID numeric(5) PRIMARY KEY,
idPessoa numeric(5),
idEvento numeric(5),
FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID)
);

CREATE TABLE ValoresDoados (
ID numeric(5) PRIMARY KEY,
Valor numeric(20),
dataDoado date,
idCampanha numeric(5)
);

CREATE TABLE ItemDoado (
ID numeric(5) PRIMARY KEY,
dataDoado date,
idCampanhaItem numeric(5),
observacao varchar(100),
idIten numeric(5),
FOREIGN KEY(idIten) REFERENCES Item (ID)
);

CREATE TABLE DoadoDoador (
ID numeric(5) PRIMARY KEY,
idItem numeric(5),
idDoador numeric(5),
FOREIGN KEY(idDoador) REFERENCES Doador (ID),
FOREIGN KEY(idItem) REFERENCES ItemDoado (ID)
);

CREATE TABLE ValorDoador (
ID numeric(5) PRIMARY KEY,
idDoador numeric(5),
idValor numeric(5),
FOREIGN KEY(idDoador) REFERENCES Doador (ID),
FOREIGN KEY(idValor) REFERENCES ValoresDoados (ID)
);

CREATE TABLE Evento (
ID numeric(5) PRIMARY KEY,
idEndereco numeric(5),
Data date,
Nome varchar(50),
dataInicio date,
dataFim date,
descricao varchar(100),
FOREIGN KEY(idEndereco) REFERENCES Endereco (ID)
);

CREATE TABLE CampanhaDinheiro (
ID numeric(5) PRIMARY KEY,
Meta numeric(10),
Moeda varchar(7),
Duracao date,
ID_Evento numeric(5),
FOREIGN KEY(ID_Evento) REFERENCES Evento (ID)
);

CREATE TABLE CampanhaItens (
ID numeric(5) PRIMARY KEY,
Quantidade numeric(5),
idItem numeric(5),
ID_Evento numeric(5),
FOREIGN KEY(idItem) REFERENCES Item (ID),
FOREIGN KEY(ID_Evento) REFERENCES Evento (ID)
);

 -- select * from Pessoa
 -- select * from Endereco
 -- select * from Usuario

ALTER TABLE Doador ADD FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID);
ALTER TABLE Voluntario ADD FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID);
ALTER TABLE Voluntario ADD FOREIGN KEY(IDEvento) REFERENCES Evento (ID);
ALTER TABLE Divulgacao ADD FOREIGN KEY(idEvento) REFERENCES Evento (ID);
ALTER TABLE Divulgacao ADD FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID);
ALTER TABLE EmailInstituicao ADD FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID);
ALTER TABLE InstituicaoEvento ADD FOREIGN KEY(idInstuicao) REFERENCES Instituicao (ID);
ALTER TABLE InstituicaoEvento ADD FOREIGN KEY(IdEvento) REFERENCES Evento (ID);
ALTER TABLE Usuario ADD FOREIGN KEY(IDPessoa) REFERENCES Pessoa (ID);
ALTER TABLE Instituicao ADD FOREIGN KEY(Contato) REFERENCES Pessoa (ID);
ALTER TABLE InstituicaoPessoa ADD FOREIGN KEY(ID_Pessoa) REFERENCES Pessoa (ID);
ALTER TABLE Responsavel ADD FOREIGN KEY(idEvento) REFERENCES Evento (ID);
ALTER TABLE ValoresDoados ADD FOREIGN KEY(idCampanha) REFERENCES CampanhaDinheiro (ID);
ALTER TABLE ItemDoado ADD FOREIGN KEY(idCampanhaItem) REFERENCES CampanhaItens (ID);