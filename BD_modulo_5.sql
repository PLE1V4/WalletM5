-- Creacion de Base de Datos
create schema walletdb;
use walletdb;

-- Creacion de UsuarioDB

CREATE USER 'walletdb'@'%' IDENTIFIED BY 'walletdb';
GRANT ALL PRIVILEGES ON * . * TO 'walletdb'@'%';

-- Creacion de Tablas

-- Tabla de Usuarios
create table usuarios(
user_id int primary key auto_increment,
nombres varchar(50) not null,
apellidos varchar(50) not null,
email varchar(50) not null unique,
contrasena varchar(15) not null
);

-- Tabla de Monedas
create table monedas(
currency_id int primary key auto_increment,
currency_name varchar(20) not null,
currency_symbol varchar(5) not null,
currency_exchangeRate double not null
);

-- Tabla de Cuentas
create table cuentas(
acc_number int primary key auto_increment,
acc_balance double not null,
acc_currency int not null,
foreign key (acc_currency) references monedas (currency_id)
);

alter table cuentas auto_increment=1000000;

--  Tabla Wallet

create table wallets (
wallet_id int primary key auto_increment,
wallet_user_id int not null,
wallet_acc_num int not null,
foreign key (wallet_user_id) references usuarios (user_id),
foreign key (wallet_acc_num) references cuentas (acc_number)
);

alter table wallets auto_increment=100000;

-- Tabla Contactos

create table contactos (
contact_id int primary key auto_increment,
wallet_id int not null,
contact_name Varchar(50) not null,
acc_number int not null,
foreign key (wallet_id) references wallets(wallet_id),
foreign key (acc_number) references cuentas(acc_number)
);

-- Tabla Transacciones

create table transactions (
ts_number int primary key auto_increment,
sender_id int not null,
receiver_id int not null,
amount double not null,
fecha_ts date not null,
ts_type int not null
);

insert into monedas values(1,'Chilean Peso','CLP$',1);
insert into monedas values(2,'US Dollar','USD$',0.0011);

Insert into usuarios (nombres, apellidos, email,contrasena) values
('Armando','Casas','acasas@wallet.cl','123456');

insert into cuentas (acc_balance,acc_currency) values
(500000,1);
insert into cuentas (acc_balance,acc_currency) values
(100000,1);

insert into wallets(wallet_user_id,wallet_acc_num) values
(1,1000000);

insert into contactos(wallet_id,contact_name,acc_number) values
(100000,"Bob el Constructor",1000001);


