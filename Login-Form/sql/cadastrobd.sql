create table Cadastro(
  idcad int unique not null primary key,
  nome varchar(50) not null,
  login varchar(30) unique not null,
  email varchar(30) unique not null,
  senha varchar(100) not null,
  cpf varchar(15) unique not null,
  rg varchar(15) unique not null,
  telefone varchar(13),
  celular varchar(14),
);
