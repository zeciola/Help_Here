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
select eve.idEvento from PessoaEvento eve, Usuario e where e.IDPessoa = eve.idPessoa and e.senha = 'teste'

insert into Usuario (id, IDPessoa, Tipo, Login, senha) values(3 ,3, 'comum', '3', '3');


TRUNCATE divulgacao, emailinstituicao, endereco,enderecoevento, enderecoinstituicao, evento, feeds, galeriaev, instituicao, instituicaoevento, instituicaopessoa, interesses, mensagem, pessoa, pessoaevento, responsavel, telcelinstituicao, ultimoboleto, usuario, valoresdoados, voluntario

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

select * from usuario where id = 38

select e.id, e.nome, e.datainicio, e.datafim, e.descricao, u.login, u.tipo from evento e, feeds f, usuario u where e.id = f.idevento and u.id = f.idusuario and f.idusuario = 3 and CURRENT_DATE >= e.datainicio and CURRENT_DATE <= e.datafim and e.status = true limit 9

select * from interesses where idusuario = 43

update evento set id = 16 where id = 93

select * from Evento where id = 16 and status = true and ID in (select eve.idEvento from PessoaEvento eve, Usuario e, Pessoa p where p.id = eve.idPessoa and e.senha = '123');

delete from instituicao where status = true
delete from evento where status = false
delete from enderecoinstituicao where status = false
select * from pessoa
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

update evento set status = false where id = 15;

SELECT CURRENT_DATE;
SELECT CURRENT_TIME;

select e.nome, e.datainicio, e.datafim, e.descricao, u.login, u.tipo from evento e, feeds f, usuario u where
 e.id = f.idevento and u.id = 2 and '20/05/2017' >= e.datainicio and '20/05/2017' <= e.datafim ;

select * from evento;

update evento set tipo = 'Voluntariado' where id = 83;

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
contador int,
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
alter table Instituicao add column contador int

update usuario set login = 'admin' where ID = 37

update usuario set senha = 'lucasgabriel' where ID = 38

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
contador int,
FOREIGN KEY(IDEndereco) REFERENCES Endereco (ID)
);

--contador
alter table Pessoa add column contador int
-- id da pessoa que criou o evento tal
select idpessoa from pessoaevento eve, pessoa e where e.id = eve.idpessoa and eve.idevento = 13;
--mudar o contador
update instituicao set contador = 1 where id in (select idpessoa from pessoaevento eve, pessoa e where e.id = eve.idpessoa and eve.idevento = 13;)
update Instituicao set contador = 1 where id = 3 


select * from Evento where nome = 'teste contador pessoa' and status = true and ID in (select eve.idEvento from PessoaEvento eve, Usuario e, Pessoa p where p.id = eve.idPessoa and e.senha = '123')
select * from Pessoa											select * from PessoaEvento eve, Pessoa e where e.id = eve.idPessoa and eve.idEvento = 12
select * from Instituicao
 

insert into Pessoa (Nome, Sobrenome, CPF, RG, Penalisado, Datanascimento, email, IDEndereco, Telefone, celular, sexo, status)
 values('Nome 1', 'Sobrenome 2', '1', '2', false, '13/12/1999', 'teste@teste.com', 1, '34343434', '9099999', 'f', true);

insert into Pessoa (id, nome, sobrenome, cpf, rg, penalisado, Datanascimento, email, IDEndereco, Telefone, celular, sexo)
 values(3, 'novo', 'user', '3', '3', false, '01/01/1990', 'pessoa@email.com', 1, '2323-2323', '9999999', 'f');

select * from PessoaEvento eve, Pessoa e where e.id = eve.idPessoa and eve.idEvento = 12
--alter table Pessoa add column status boolean default true

select * from pessoa where id = 0

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
	IDPessoa serial,
	boleto varchar(53),
	databaixa date,
	statusbaixa boolean default(false),
	alter table ValoresDoados add column numeroboleto numeric
);


insert into ValoresDoados (Valor, dataDoado, idCampanha, IDPessoa, boleto, statusbaixa)values(100.00, current_date, 2, 2, '11111', false);

select * from valoresdoados

alter table ValoresDoados add column boleto varchar(53);

alter table ValoresDoados add column databaixa date;

alter table ValoresDoados add column statusbaixa boolean default(false);

select * from valoresdoados;

create table ultimoboleto(
	ID serial PRIMARY KEY,
	numero numeric(20)default null
)

insert into ultimoboleto (numero) values(11111111111111111111);

drop table ultimoboleto

select * from ultimoboleto;



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


select * from Evento where status = true order by datainicio desc limit 10

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


create table PessoaEvento (
ID serial,
idPessoa	int,
idEvento	int,
FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID),
FOREIGN KEY(idEvento) REFERENCES Evento (ID)
);

create table EnderecoEvento (
ID serial,
idEvento	int,
idEndereco	int,
FOREIGN KEY(idEvento) REFERENCES Evento (ID),
FOREIGN KEY(idEndereco) REFERENCES Endereco (ID)
);


/*
select * from Endereco
select * from instituicao
insert into EnderecoEvento (idEvento, idEndereco) values (1,8

insert into EnderecoEvento (idEvento, idEndereco) values (1,7)

insert into EnderecoEvento (idEvento, idEndereco) values (2,7)

select * from enderecoevento eve, evento ev, endereco e where e.id = eve.idendereco and ev.id = eve.idevento; 

-- instituicao do evento tal
select idinstituicao from instituicaoevento eve, instituicao e where e.id = eve.idinstituicao and eve.idevento = 23;

update Instituicao set contador = 16 where id in (select idinstituicao from instituicaoevento eve, instituicao e where e.id = eve.idinstituicao and eve.idevento = 23)

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
ALTER TABLE PessoaEvento ADD FOREIGN KEY(idPessoa) REFERENCES Pessoa (ID);
ALTER TABLE PessoaEvento ADD FOREIGN KEY(IdEvento) REFERENCES Evento (ID);
ALTER TABLE Usuario ADD FOREIGN KEY(IDPessoa) REFERENCES Pessoa (ID);
ALTER TABLE InstituicaoPessoa ADD FOREIGN KEY(ID_Pessoa) REFERENCES Pessoa (ID);
ALTER TABLE Responsavel ADD FOREIGN KEY(idEvento) REFERENCES Evento (ID);
ALTER TABLE ValoresDoados ADD FOREIGN KEY(idCampanha) REFERENCES CampanhaDinheiro (ID);
ALTER TABLE ItemDoado ADD FOREIGN KEY(idCampanhaItem) REFERENCES CampanhaItens (ID);

update ultimoboleto set numeroboleto = '0001.0001.0001.0001.0001' where id = 1;

alter table evento add column metavalor numeric default(0);

alter table evento add column metavoluntario integer default(0);

select * from instituicao i, evento e, instituicaoevento instv where i.id = instv.idinstituicao and instv.idevento = e.id;

alter table evento add column analisado boolean default false

select p.id idpessoa, p.nome PessoaNome, p.cpf, i.id instid, i.nome InstNome,e.id idevento, e.tipo, e.nome NomeEvento, v.analisado from Voluntario v, Instituicao i, Pessoa p, evento e, instituicaoevento instv where v.idevento = e.id and v.idpessoa = p.id and i.id = instv.idinstituicao and instv.idevento = e.id and e.tipo = 'Voluntariado' and v.analisado = false and i.id = 2;

--LISTA EVENTOS QUE NÃO TIVERAM ANALISE

select e.*
from Voluntario v, Instituicao i, evento e, instituicaoevento instv 
where v.idevento = e.id and e.analisado = false and i.id = instv.idinstituicao and instv.idevento = e.id  and e.tipo = 'Voluntariado' and i.id = 2;

--UPDATE DO STATUS ANALISADO DO EVENTO

update evento set analisado = true where id = 26;

select e.*from Voluntario v, Instituicao i, evento e, instituicaoevento instv where v.idevento = e.id and e.analisado = false and i.id = instv.idinstituicao and instv.idevento = e.id  and e.tipo = 'Voluntariado' and i.id = 2;


--LISTA PESSOAS DE TAL EVENTO voluntariado
select p.* 
from voluntario v, pessoa p, evento e, instituicao i, instituicaoevento instv 
where v.idpessoa = p.id and v.idevento = e.id and v.certificado = FALSE and instv.idevento = e.id and instv.idinstituicao = i.id AND e.id = 28;

--lista certificados prontos

--COMANDOS PARA ATUALIZAR ISTATUS DE CERTIFICADO ACEITE E E NÃO ACEITE E ANALISADO E NÃO ANALISADO

update voluntario set certificado = true and analisado = true where idpessoa =2;

update voluntario set certificado = false, analisado = false where idpessoa = 24;

update voluntario set certificado = false, analisado = false where idpessoa = 24;

alter table voluntario drop column numboleto

select p.id idpessoa, p.nome PessoaNome, p.cpf, i.id instid, i.nome InstNome,e.id idevento, e.tipo, e.nome NomeEvento, v.analisado
 from Voluntario v, Instituicao i, Pessoa p, evento e, instituicaoevento instv where
 v.idevento = e.id and v.idpessoa = p.id and i.id = instv.idinstituicao and instv.idevento = e.id and e.tipo = 'Voluntariado' and v.analisado = false and i.id = 2

select u.id iduser, p.id idpessoa, p.nome nomepessoa, e.id idevento, e.nome nomeevento, i.nome nomeinst, i.id idinst 
from Usuario u, voluntario v, pessoa p, evento e, instituicao i, instituicaoevento instv 
where p.id = u.idpessoa and v.idpessoa = p.id and v.idevento = e.id and v.certificado = true and instv.idevento = e.id and instv.idinstituicao = i.id and u.id = 23;


---SOMAR VALORES PARA STATUS DO LOADER
--SOMA VALORES JA ARRECADADOS E CONFIRMADOS
select SUM(valor) from valoresdoados where idcampanha = 26 AND statusbaixa = true;

--VALOR META EVENTO
select metavalor from evento where id = 26;


---CONTAR VOLUNTARIOS PARA STATUS DO LOADER
--CONTA VOLUNTARIOS QUE SE CADASTRATRAM
select COUNT(*) from voluntario where idevento = 33;

--META VOLUNTARIO EVENTO
select metavoluntario from evento where id = 33;



--BAIXA BANCARIA

select * from evento;

select * from evento where tipo = 'Doacao';

update evento set datafim ='07/12/2017', status = true where id = 21;

SELECT * FROM VALORESDOADOS;

update valoresdoados set boleto = '11121212121212121' where idpessoa = 2 and idcampanha = 2;


update valoresdoados set databaixa = current_date, statusbaixa = true, boleto = '123123123' where id = 1; 


update valoresdoados set databaixa = current_date, statusbaixa = true where boleto = '123123123'; 

----------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------CONDUÇÃO 1 DE AVISAR VOLUNTÁRIOS--------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------
--Lista eventos voluntar com inicio 5 dias ou menos 
select id, nome from evento where tipo = 'Voluntariado' and CURRENT_DATE+5 <= datainicio and status = true;

--v2
select id, nome from evento where tipo = 'Voluntariado' and datainicio between current_date and current_date+5 and status = true;

--Lista E-mails voluntarios do evento
select p.email, p.nome 
from voluntario v, pessoa p, evento e, instituicao i, instituicaoevento instv 
where v.idpessoa = p.id and v.idevento = e.id and instv.idevento = e.id and instv.idinstituicao = i.id AND e.id = 28;
----------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------CONDUÇÃO 2 REMOVER PENALIDADE DE PESSOA--------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------

select * from usuario;

select * from pessoa where id = 24;

alter table pessoa add column datapenalisado date

--Atualiza status e dia de atualização do status
update pessoa set penalisado = true, datapenalisado = '08/10/2017' where id = (select p.id from usuario u, pessoa p where p.id = u.idpessoa and u.id = 23);

--Atualiza status e dia de atualização do status
update pessoa set penalisado = true, datapenalisado = '08/10/2017' where id = (select p.id from usuario u, pessoa p where p.id = u.idpessoa and u.id = 23);


--Lista penalisados prontos para sair do status
select id from pessoa where penalisado = true and datapenalisado+30 <= current_date;

select * from pessoa

update pessoa set datapenalisado = '26/10/2017' where id = 24;

update pessoa set penalisado = false where id = 24;
----------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------

select id from evento where tipo = 'Voluntariado' and datainicio between current_date and current_date+5 and status = true


select * from evento where id = 33;

update evento set metavoluntario = 30 where id = 33;

