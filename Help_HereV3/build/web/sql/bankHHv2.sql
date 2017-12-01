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

select * from enderecoevento eve, endereco e where e.id = eve.idendereco and eve.idevento = 1
-- drop table endereco cascade
alter table Endereco add column status boolean default true

alter table Endereco drop 
alter table Endereco drop column status 

select * from Endereco where id =3

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


CREATE TABLE Usuario (
ID serial PRIMARY KEY,
IDPessoa serial,
Tipo varchar(15),
Login varchar(45),
senha varchar(45),
status boolean
);

alter table usuario add column status boolean default true 
select * from usuario


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
status boolean,
constraint fk_Endereco Foreign Key(IdEnderecoInstituicao)
references EnderecoInstituicao (ID) on delete cascade
);


/*
select * from Instituicao
delete from Instituicao where ID = 20
drop table instituicao cascade
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
status boolean
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
sexo varchar
status boolean
FOREIGN KEY(IDEndereco) REFERENCES Endereco (ID)
);

alter table Pessoa add column status boolean default true

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
dataInicio date,
dataFim date,
nome varchar(50),
tipo varchar(50),
descricao varchar(100),
status boolean default true
);

/*alter table Evento add column dataFim date 
drop table Evento cascade

update Evento set (datainicio, datafim, nome, tipo, descricao) = (?,?,?,?,?) where id = ''

update Evento set (datainicio, datafim, nome, tipo, descricao) = ('01/01/2017','12/12/2017','campanhas do agasalho','Doacao','doar muito') where nome = 'campanha do agasalho'

update Evento set datafim = '02/04/2017' where id = 3

alter table Evento drop column dataFim
select * from Evento where nome ilike '%agasalho%' and status = true

select * from Evento where nome = 'campanha do agasalho' and status = true and ID in (select eve.idEvento from InstituicaoEvento eve, Instituicao e where e.id = eve.idInstituicao and e.senha = '123')

insert into Evento (dataInicio,datafim,nome,tipo,descricao) values ('28/04/2017','29/08/2017','agasalho','campanha','doação');
insert into Evento (dataInicio,datafim,nome,tipo,descricao,status) values ('28/04/2017','29/08/2017','agasalho2','campanha2','doação2',true);

insert into Evento (dataInicio, dataFim, nome, tipo, descricao) values ('28/04/2017','29/08/2020','agasalho4','campanha4','doação4');
*/

create table Interesses(
ID serial PRIMARY KEY,
IDUsuario integer references Usuario(id),
Interesse varchar(45)
);

insert into Interesses (IDUsuario, Interesse)values(2 , 'Voluntariado');
insert into Interesses (IDUsuario, Interesse)values(2 , 'Doacao');
select * from Evento where tipo = 'Doacao';
delete from interesses where id = 1

--Listar ids para buscar usuarios que tem interesse no evento
select u.id from usuario u, Interesses i where i.idusuario = u.id and i.interesse = 'Doação';

select * from usuario u, Interesses i where i.idusuario = u.id and i.interesse = 'Voluntariado';

--inserir no feeds
insert into feeds (IDUsuario, IDEvento)values(2, 2); 

--Trazer para o banco
--Trazer para o banco

select * from evento e, feeds f, usuario u where e.id = f.idevento and u.id = f.idusuario and f.idusuario = 2;
select * from feeds;
select * from interesses;

select u.id from usuario u, Interesses i where i.idusuario = u.id and i.interesse = 'Doacao'

select e.id, e.nome, e.datainicio, e.datafim, e.descricao, u.login, u.tipo from evento e, feeds f, usuario u where
 e.id = f.idevento and u.id = f.idusuario and f.idusuario = 2 and  CURRENT_DATE >= e.datainicio and CURRENT_DATE <= e.datafim LIMIT 5;

SELECT * FROM Usuario WHERE status=true and Login='teste' AND senha='teste'

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


create table Mensagem(
ID serial,
mensagem1	varchar(50),
mensagem2	varchar(50),
);

Alter table Mensagem drop column mensagem3
CREATE TABLE InstituicaoEvento (
IDtab serial PRIMARY KEY,
idInstituicao int,
IdEvento int
);

drop table InstituicaoEvento cascade
	-- todas instituições do evento 1
select * from InstituicaoEvento eve, Instituicao e where e.id = eve.idInstituicao and eve.idEvento = 1;

-- deletar evento usando cnpj e senha da instituicao ---
 update Evento set status = false where nome = 'agasalhe um idoso' and ID in (select eve.idEvento from InstituicaoEvento eve, Instituicao e where e.id = eve.idInstituicao and e.senha = '123')
select * from evento

 --drop table InstituicaoEvento cascade
-- select * from InstituicaoEvento

create table EnderecoEvento (
IDTab serial,
idEvento	int,
idEndereco	int,
FOREIGN KEY(idEvento) REFERENCES Evento (ID),
FOREIGN KEY(idEndereco) REFERENCES Endereco (ID)
)

 drop table EnderecoEvento cascade

 insert into EnderecoEvento (idEvento, idEndereco) values(1,2)

select * from EnderecoEvento

select * from Endereco
insert into InstituicaoEvento (idEvento, idInstituicao) values (11,2)

insert into InstituicaoEvento (idEvento, idInstituicao) values (11,2)

select * from InstituicaoEvento eve, Instituicao e where e.id = eve.idInstituicao and eve.idEvento = 4

update Endereco set (cep, nomelogradouro, numero, bairro, municipio, uf, pais) = ('0111','rua nove',09,'jardim camila','MOGI','SP','Brasil')   where id = 3

insert into EnderecoEvento (idEvento, idEndereco) values (2,7)

select * from Evento E, EnderecoEvento ee, InstituicaoEvento ie where E.ID = ee.IDTab and E.ID = ie.IDTab and E.nome = 'Campanha do agasalho'

delete from Evento where nome = 'Campanha do agasalho' 
select * from enderecoevento eve, evento ev, endereco e where e.id = eve.idendereco and ev.id = eve.idevento; 

-- todos enderecos do evento 1
select * from enderecoevento eve, endereco e where e.id = eve.idendereco and eve.idevento = 2;

-- mostra todos eventos que ocorreram no endereco 7

select * from enderecoevento eve, evento ev where ev.id = eve.idevento and eve.idendereco = 7;


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
ALTER TABLE InstituicaoEvento ADD FOREIGN KEY(idInstituicao) REFERENCES Instituicao (ID);
ALTER TABLE InstituicaoEvento ADD FOREIGN KEY(IdEvento) REFERENCES Evento (ID);
ALTER TABLE Usuario ADD FOREIGN KEY(IDPessoa) REFERENCES Pessoa (ID);
ALTER TABLE InstituicaoPessoa ADD FOREIGN KEY(ID_Pessoa) REFERENCES Pessoa (ID);
ALTER TABLE Responsavel ADD FOREIGN KEY(idEvento) REFERENCES Evento (ID);
ALTER TABLE ValoresDoados ADD FOREIGN KEY(idCampanha) REFERENCES CampanhaDinheiro (ID);
ALTER TABLE ItemDoado ADD FOREIGN KEY(idCampanhaItem) REFERENCES CampanhaItens (ID);