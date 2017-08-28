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

CREATE TABLE Voluntario (
ID serial PRIMARY KEY,
idPessoa serial,
IDEvento serial,
datavoluntario date,
certificado boolean default false,
analisado boolean default false
);

select * from voluntario;

alter table voluntario add column certificado boolean default false;
alter table voluntario add column analisado boolean default false;


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

insert into Usuario (id, IDPessoa, Tipo, Login, senha) values(3 ,3, 'comum', '3', '3');

create table Interesses(
ID serial PRIMARY KEY,
IDUsuario integer references Usuario(id),
Interesse varchar(45)
);

insert into Interesses (IDUsuario, Interesse)values(3 , 'Voluntariado');
insert into Interesses (IDUsuario, Interesse)values(2 , 'Doação');
select * from Evento where tipo = 'Doação';

--Listar ids para buscar usuarios que tem interesse no evento
select u.id from usuario u, Interesses i where i.idusuario = u.id and i.interesse = 'doacao';

select * from usuario u, Interesses i where i.idusuario = u.id and i.interesse = 'voluntariado';

select * from interesses

--inserir no feeds
insert into feeds (IDUsuario, IDEvento)values(3, 1); 

--Trazer para o banco

select * from evento e, feeds f, usuario u where e.id = f.idevento and u.id = f.idusuario and f.idusuario = 3;
select * from feeds;

select e.id, e.nome, e.datainicio, e.datafim, e.descricao, u.login, u.tipo from evento e, feeds f, usuario u where
 e.id = f.idevento and u.id = f.idusuario and f.idusuario = 3 and '27/05/2017' >= e.datainicio and '27/05/2017' <= e.datafim LIMIT 5;

select e.id, e.nome, e.datainicio, e.datafim, e.descricao, u.login, u.tipo from evento e, feeds f, usuario u where
 e.id = f.idevento and u.id = f.idusuario  and  CURRENT_DATE >= e.datainicio and CURRENT_DATE < e.datafim LIMIT 5;



select e.id, e.nome, e.datainicio, e.datafim, e.descricao, u.login, u.tipo from evento e, feeds f, usuario u where
 e.id = f.idevento and u.id = f.idusuario and f.idusuario = 3 and CURRENT_DATE >= e.datainicio or e.datafim >= CURRENT_DATE  ;

SELECT * FROM Usuario WHERE status=true and Login='3' AND senha='3'

SELECT CURRENT_DATE;
SELECT CURRENT_TIME;

select e.nome, e.datainicio, e.datafim, e.descricao, u.login, u.tipo from evento e, feeds f, usuario u where
 e.id = f.idevento and u.id = 2 and '20/05/2017' >= e.datainicio and '20/05/2017' <= e.datafim ;

select * from evento;

update evento set tipo = 'Voluntariado' where id = 4;

create table Feeds (
ID serial PRIMARY KEY,
IDUsuario integer references Usuario(id),
IDEvento integer references Evento(id)
);
insert into feeds(IDUsuario, IDEvento) values (3, 4)

select * from feeds;

select * from feeds f, evento e where f.idEvento = e.id and datainicio >= '26/05/2017';  

select * from usuario;

insert into feeds (IDUsuario, IDEvento)values(3, 1); 

--insert into evento(idendereco, data, nome, datainicio, datafim, descricao)values(1, '25/05/2017', 'Evento com nome teste', '20/05/2017', '25/05/2017', 'Doação');

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

select * from usuario;

select * from instituicao;
delete from instituicao where id = 2
/*
select * from Instituicao
delete from Instituicao where ID = 20

select * from EnderecoInstituicao
delete from EnderecoInstituicao where ID = 20

alter table EnderecoInstituicao add column status boolean

update usuario set login = 'admin' where ID = 37

update EnderecoInstituicao set status = false where ID in (select Ende.ID from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID and CNPJ = '5' and senha = '123')

select * from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID 

select * from Instituicao inst, EnderecoInstituicao Ende where inst.ID = Ende.ID and inst.CNPJ = '30' and inst.senha = '123'

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

insert into Pessoa (Nome, Sobrenome, CPF, RG, Penalisado, Datanascimento, email, IDEndereco, Telefone, celular, sexo, status)
 values('Nome 1', 'Sobrenome 2', '1', '2', false, '13/12/1999', 'teste@teste.com', 1, '34343434', '9099999', 'f', true);

insert into Pessoa (id, nome, sobrenome, cpf, rg, penalisado, Datanascimento, email, IDEndereco, Telefone, celular, sexo)
 values(3, 'novo', 'user', '3', '3', false, '01/01/1990', 'pessoa@email.com', 1, '2323-2323', '9999999', 'f');

--alter table Pessoa add column status boolean default true

select * from pessoa

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
idCampanha serial,
IDPessoa serial
);

insert into valoresdoados (Valor, dataDoado, idCampanha, IDPessoa) values(100.00, CURRENT_DATE, 1, 2);

select * from valoresdoados;

alter table valoresdoados add column IDPessoa serial references Pessoa(id);

alter table Voluntario add column DataVoluntario date;

alter table Voluntario add column NumBoleto varchar(54);


drop table doador cascade;
drop table valordoador cascade;
drop table doadodoador cascade;

drop table itemdoado cascade;
drop table item cascade;

drop table campanhaitens cascade;
drop table campanhadinheiro cascade;

select * from doadodoador;
select * from valordoador;

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

Create Table GaleriaEV(
	ID serial primary key,
	IDEV integer references Evento(ID) not null,
	nomeImg varchar(100) default('defaut.jpg')
);

alter table Evento add column img varchar(100) default('defaut2.jpg');

CREATE TABLE Evento (
ID serial PRIMARY KEY,
dataInicio varchar(50),
dataFim varchar(50),
nome varchar(50),
tipo varchar(50),
descricao varchar(100),
status boolean default true,
img varchar(100) default('defaut2.jpg')
);

insert into evento (idendereco, data, nome, datainicio, datafim, descricao, tipo) values (1, '07/08/2017', 'EVENTO CARREGA INDEX', '07/08/2017', '30/09/2017', 'CARREGA INDEX 1', 'Doação');
insert into evento (idendereco, data, nome, datainicio, datafim, descricao, tipo) values (1, '07/08/2017', 'EVENTO CARREGA INDEX', '07/08/2017', '30/09/2017', 'CARREGA INDEX 2', 'Voluntario');


select * from Evento;

select e.id, e.nome, e.datainicio, e.datafim, e.descricao, u.login, u.tipo from evento e, feeds f, usuario u
 where e.id = f.idevento and u.id = f.idusuario and f.idusuario = 3 and CURRENT_DATE >= e.datainicio and CURRENT_DATE <= e.datafim and e.status = true;


select * from Evento;

update evento set status = true;

/*
alter table Evento add column tipo varchar(50)

alter table Evento add column status boolean default true
drop table Evento cascade

alter table Evento drop column idInstituicao
select * from Evento

select * from evento;

insert into Evento (dataInicio,datafim,nome,tipo,descricao) values ('28/04/2017','29/08/2017','agasalho','campanha','doação');
insert into Evento (dataInicio,datafim,nome,tipo,descricao) values ('28/04/2017','29/08/2017','agasalho2','campanha2','doação2');

insert into Evento (dataInicio, dataFim, nome, tipo, descricao) values ('28/04/2017','29/08/2020','agasalho4','campanha4','doação4');
*/
insert into evento (idendereco, data, nome, datainicio, datafim, descricao, tipo) values (1, '25/05/2017', 'EVENTO 5 HOJE', '27/05/2017', '31/05/2017', 'Evento 4', 'Doação');

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

select * from voluntario;
