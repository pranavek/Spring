drop table users;
create table if not exists users(
      username varchar(50) not null primary key,
      password varchar(50) not null,
      role varchar(50) not null,
      enabled boolean not null);