CREATE TABLE Item(
ID serial PRIMARY KEY,
Item varchar(50),
peso numeric,
marca VARCHAR(20),
descricao VARCHAR(100)
);

CREATE TABLE Doador (
ID serial PRIMARY KEY,
idPessoa serial
);

CREATE TABLE Endereco (
ID serial PRIMARY KEY,
cep varchar(9),
NomeLogradouro varchar(50),
Numero numeric(100),
Bairro varchar(45),
Municipio varchar(45),
UF varchar(10),
pais varchar(45)
);

-- drop table endereco cascade

CREATE TABLE Voluntario (
ID serial PRIMARY KEY,
idPessoa serial,
IDEvento serial
);

CREATE TABLE Divulgacao (
ID serial PRIMARY KEY,	
dataInicial date,
dataFinal date,
idEvento serial,
idInstituicao serial,
arquivo varchar(50)
);

CREATE TABLE EmailInstituicao (
ID serial PRIMARY KEY,
idInstituicao serial,
Email varchar(50)
);

CREATE TABLE InstituicaoEvento (
ID serial PRIMARY KEY,
idInstuicao serial,
IdEvento serial
);

CREATE TABLE Usuario (
ID serial PRIMARY KEY,
IDPessoa serial,
Tipo varchar(15),
Login varchar(45),
senha varchar(45)
);

CREATE TABLE Instituicao (
ID serial PRIMARY KEY,
Nome varchar(50),
razaoSocial VARCHAR(50 ),
tipo varchar(15),
CNPJ varchar(19),
modalidade varchar(50),
email varchar(50),
idEnderecoInstituicao int,
senha varchar(50),
constraint fk_Endereco Foreign Key(IdEnderecoInstituicao)
references EnderecoInstituicao (ID) on delete cascade
);

drop table Instituicao cascade 
drop table EnderecoInstituicao cascade 
alter table Instituicao add column senha varchar(50)
--select * from EnderecoInstituicao
--delete from EnderecoInstituicao where ID = 1
UPDATE Instituicao SET nome='deu', razaoSocial='foi', tipo='isso', CNPJ='55', modalidade='deu', email='deu@deu' WHERE CNPJ='10';

select * from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID
select * from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID
DELETE from Instituicao, EnderecoInstituicao using Instituicao inner join EnderecoInstituicao where Instituicao.ID = EnderecoInstituicao.ID and CNPJ = '55' 

CREATE TABLE EnderecoInstituicao (
ID serial PRIMARY KEY,
cep varchar(9),
NomeLogradouro varchar(50),
Numero numeric(4),
Bairro varchar(45),
Municipio varchar(45),
UF varchar(10),
pais varchar(45)
);


CREATE TABLE InstituicaoPessoa (
ID serial PRIMARY KEY,
ID_Instituicao serial,
ID_Pessoa serial,
FOREIGN KEY(ID_Instituicao) REFERENCES Instituicao (ID)
);

CREATE TABLE TelCelInstituicao (
ID serial PRIMARY KEY,
idInstituicao serial,
Numero numeric(20),
Tipo Boolean,
FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID)
);

CREATE TABLE Pessoa (
ID serial PRIMARY KEY,
Nome varchar(50),
Sobrenome varchar(50),
CPF varchar(15),
RG varchar,
Penalisado boolean,
Datanascimento varchar,
email varchar(45),
IDEndereco serial,
Telefone varchar(19),
celular VARCHAR(20),
sexo varchar,
FOREIGN KEY(IDEndereco) REFERENCES Endereco (ID)
);

CREATE TABLE Responsavel(
ID serial PRIMARY KEY,
idPessoa serial,
idEvento serial,
FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID)
);

CREATE TABLE ValoresDoados (
ID serial PRIMARY KEY,
Valor numeric(20),
dataDoado date,
idCampanha serial
);

CREATE TABLE ItemDoado (
ID serial PRIMARY KEY,
dataDoado date,
idCampanhaItem serial,
observacao varchar(100),
idIten serial,
FOREIGN KEY(idIten) REFERENCES Item (ID)
);

CREATE TABLE DoadoDoador (
ID serial PRIMARY KEY,
idDoador serial,
idItem serial,
FOREIGN KEY(idDoador) REFERENCES Doador (ID),
FOREIGN KEY(idItem) REFERENCES ItemDoado (ID)
);

CREATE TABLE ValorDoador (
ID serial PRIMARY KEY,
idDoador serial,
idValor serial,
FOREIGN KEY(idDoador) REFERENCES Doador (ID),
FOREIGN KEY(idValor) REFERENCES ValoresDoados (ID)
);

CREATE TABLE Evento (
ID serial PRIMARY KEY,
idEndereco serial,
Data date,
Nome varchar(50),
dataInicio date,
dataFim date,
descricao varchar(100),
FOREIGN KEY(idEndereco) REFERENCES Endereco (ID)
);

CREATE TABLE CampanhaDinheiro (
ID serial PRIMARY KEY,
Meta numeric(1000),
Moeda varchar(7),
Duracao date,
ID_Evento serial,
FOREIGN KEY(ID_Evento) REFERENCES Evento (ID)
);



CREATE TABLE CampanhaItens (
ID serial PRIMARY KEY,
Quantidade numeric(5),
idItem serial,
ID_Evento serial,
FOREIGN KEY(idItem) REFERENCES Item (ID),
FOREIGN KEY(ID_Evento) REFERENCES Evento (ID)
);

-- select * from Pessoa
-- select * from Endereco

-- DROP ALL
--drop table CampanhaItens, CampanhaDinheiro, Evento, ValorDoador, DoadoDoador, ItemDoado, ValoresDoados, Responsavel, Pessoa, TelCelInstituicao, InstituicaoPessoa, EnderecoIstituicao, Instituicao, Usuario, InstituicaoEvento, EmailInstituicao, Voluntario, Endereco, Doador, Item

-- INSERTs

-- Pessoa
-- insert into Pessoa values(1,'admin','admin','123','123',false,'10-10-1995','aaa@aaa.com',1,'12345678','12345678','Masculino');	
-- insert into Endereco values(1,'123','aaa','123','123','bbb','sao paulo','brasil');

-- DELETEs

-- DELETE from Pessoa where id=1;
-- ALTER TABLE Endereco ID = 1

-- TRUNCATE TABLE Pessoa cascade


ALTER TABLE Doador ADD FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID);
ALTER TABLE Voluntario ADD FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID);
ALTER TABLE Voluntario ADD FOREIGN KEY(IDEvento) REFERENCES Evento (ID);
ALTER TABLE Divulgacao ADD FOREIGN KEY(idEvento) REFERENCES Evento (ID);
ALTER TABLE Divulgacao ADD FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID);
ALTER TABLE EmailInstituicao ADD FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID);
ALTER TABLE InstituicaoEvento ADD FOREIGN KEY(idInstuicao) REFERENCES Instituicao (ID);
ALTER TABLE Instituicao ADD FOREIGN KEY (idEnderecoInstituicao) REFERENCES EnderecoInstituicao (ID) on delete cascade;
ALTER TABLE InstituicaoEvento ADD FOREIGN KEY(IdEvento) REFERENCES Evento (ID);
ALTER TABLE Usuario ADD FOREIGN KEY(IDPessoa) REFERENCES Pessoa (ID);
ALTER TABLE InstituicaoPessoa ADD FOREIGN KEY(ID_Pessoa) REFERENCES Pessoa (ID);
ALTER TABLE Responsavel ADD FOREIGN KEY(idEvento) REFERENCES Evento (ID);
ALTER TABLE ValoresDoados ADD FOREIGN KEY(idCampanha) REFERENCES CampanhaDinheiro (ID);
ALTER TABLE ItemDoado ADD FOREIGN KEY(idCampanhaItem) REFERENCES CampanhaItens (ID);