Create table clients (id varchar(255), name varchar(255), email varchar(255), created_at date);
Create table accounts (id varchar(255), client_id varchar(255), balance int, created_at date);
Create table transactions (id varchar(255), account_id_from varchar(255), account_id_to varchar(255), amount int, created_at date);

insert into clients (id, name, email, created_at) values ('c1480326-c000-4e6d-9cf3-2786c10e6d4d', 'John Doe', 'j@j.com', '2020-01-01');
insert into accounts (id, client_id, balance, created_at) values ('dd37c557-0522-43ea-9717-11421ba134b6', 'c1480326-c000-4e6d-9cf3-2786c10e6d4d', 1000, '2020-01-01');
insert into accounts (id, client_id, balance, created_at) values ('b4d0e6ce-4695-4aba-9a0a-bddd54e7a903', 'c1480326-c000-4e6d-9cf3-2786c10e6d4d', 1000, '2021-01-01');