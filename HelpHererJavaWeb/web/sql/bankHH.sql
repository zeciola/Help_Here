create table Pessoa (
    id int primary key serial unique not null,
    nome varchar(50),
    email varchar(30),
    datanas Date,
    celular varchar(15),
    rg varchar(20),
    cpf varchar(20),
    sexo varchar(10),
    status boolean
);

create table endereco(
    id int primary key serial unique not null,
    endereco varchar(100),
    numeroen varchar(7),
    cidade varchar(30),
    estado varchar(20),
    cep varchar(10)
    status boolean
);

--Insert Endereco
insert into endereco (endereco, numeroen, cidade, estado, cep) values(?,?,?,?,?);

--Select all
select * from endereco;

--Select from id
select * from endereco where id=? status=true;


