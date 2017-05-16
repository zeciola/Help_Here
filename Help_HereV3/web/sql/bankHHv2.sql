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
pais varchar(45),
status boolean default true
);

-- drop table endereco cascade
--alter table Endereco add column status boolean default true

--alter table Endereco drop column status 

--select * from Endereco

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
senha varchar(45),
status boolean default true
);

--alter table usuario add column status boolean default true 
--select * from usuario


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
status boolean default true,
constraint fk_Endereco Foreign Key(IdEnderecoInstituicao)
references EnderecoInstituicao (ID) on delete cascade
);


/*
select * from Instituicao
delete from Instituicao where ID = 20

select * from EnderecoInstituicao
delete from EnderecoInstituicao where ID = 20

alter table EnderecoInstituicao add column status boolean


update EnderecoInstituicao set status = false where ID in (select Ende.ID from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID and CNPJ = '5' and senha = '123')

select * from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID 

select * from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID and inst.CNPJ = '100' and inst.senha = '456'

DELETE from Instituicao, EnderecoInstituicao using Instituicao inner join EnderecoInstituicao where Instituicao.ID = EnderecoInstituicao.ID and CNPJ = '5' 

select CNPJ  from Instituicao where CNPJ = '10' and senha = '123';
DELETE from EnderecoInstituicao where ID in (select Ende.ID from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID and CNPJ = '10' and senha = '123')

select * from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID and CNPJ ='5' and inst.status = true;
insert into EnderecoInstituicao (ID, cep, NomeLogradouro, Numero, Bairro, Municipio, UF, pais, status) values(22,'111','ddd',33,'ddd','mogi','sp','brasil',true)
*/

CREATE TABLE EnderecoInstituicao (
ID serial PRIMARY KEY,
cep varchar(9),
NomeLogradouro varchar(50),
Numero numeric(4),
Bairro varchar(45),
Municipio varchar(45),
UF varchar(10),
pais varchar(45),
status boolean default true
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
status boolean default true,
FOREIGN KEY(IDEndereco) REFERENCES Endereco (ID)
);

--alter table Pessoa add column status boolean default true

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
dataInicio varchar(50),
dataFim varchar(50),
nome varchar(50),
tipo varchar(50),
descricao varchar(100),
status boolean default true
);
/*
alter table Evento add column status boolean default true
drop table Evento cascade

alter table Evento drop column idInstituicao
select * from Evento

insert into Evento (dataInicio,datafim,nome,tipo,descricao) values ('28/04/2017','29/08/2017','agasalho','campanha','doação');
insert into Evento (dataInicio,datafim,nome,tipo,descricao) values ('28/04/2017','29/08/2017','agasalho2','campanha2','doação2');

insert into Evento (dataInicio, dataFim, nome, tipo, descricao) values ('28/04/2017','29/08/2020','agasalho4','campanha4','doação4');
*/
create table EnderecoEvento (
ID serial,
idEvento	int,
idEndereco	int,
FOREIGN KEY(idEvento) REFERENCES Evento (ID),
FOREIGN KEY(idEndereco) REFERENCES Endereco (ID)
);

/*
select * from Endereco
insert into EnderecoEvento (idEvento, idEndereco) values (1,8

insert into EnderecoEvento (idEvento, idEndereco) values (1,7)

insert into EnderecoEvento (idEvento, idEndereco) values (2,7)

select * from enderecoevento eve, evento ev, endereco e where e.id = eve.idendereco and ev.id = eve.idevento; 

-- todos enderecos do evento 1
select * from enderecoevento eve, endereco e where e.id = eve.idendereco and eve.idevento = 1;

-- mostra todos eventos que ocorreram no endereco 7

select * from enderecoevento eve, evento ev where ev.id = eve.idevento and eve.idendereco = 7;
*/

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
-- select * from Usuario

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
ALTER TABLE InstituicaoEvento ADD FOREIGN KEY(IdEvento) REFERENCES Evento (ID);
ALTER TABLE Usuario ADD FOREIGN KEY(IDPessoa) REFERENCES Pessoa (ID);
ALTER TABLE InstituicaoPessoa ADD FOREIGN KEY(ID_Pessoa) REFERENCES Pessoa (ID);
ALTER TABLE Responsavel ADD FOREIGN KEY(idEvento) REFERENCES Evento (ID);
ALTER TABLE ValoresDoados ADD FOREIGN KEY(idCampanha) REFERENCES CampanhaDinheiro (ID);
ALTER TABLE ItemDoado ADD FOREIGN KEY(idCampanhaItem) REFERENCES CampanhaItens (ID);