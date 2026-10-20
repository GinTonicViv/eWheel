create table User(
    id int primary key not null auto_increment,
    name varchar(45),
    last_name varchar(45),
    password varchar(256) -- hash
    role varchar(10)
);

create table Access_token(
    id int primary key not null auto_increment,
    token id_user fk to user.id
);

create table Vehicle(
    id int primary key not null auto_increment,

)