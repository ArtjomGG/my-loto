drop table user_account;
drop table my_loto_results;
drop table my_loto_tickets;
drop table user_account cascade;

create table user_account (
    id serial  primary key,
    username varchar (100) not null,
    password varchar (100) not null,
    firstName varchar (100) not null,
    lastName varchar (100) not null,
    isikuKood bigint unique not null,
    active boolean not null,
    role varchar (100) not null,
    email varchar (100) not null
);

create table my_loto_results (
    id serial  primary key,
    resultsDate  timestamp not null,
    number1 int not null,
    number2 int not null,
    number3 int not null,
    number4 int not null,
    number5 int not null,
    number6 int not null
);

create table my_loto_tickets (
    id serial  primary key,
	my_lotto_results_id int references my_loto_results(id),
	user_account_id int references user_account(id),
    number1 int not null,
    number2 int not null,
    number3 int not null,
    number4 int not null,
    number5 int not null,
    number6 int not null
);

select * from user_account;
select * from my_loto_results;
select * from my_loto_tickets;

