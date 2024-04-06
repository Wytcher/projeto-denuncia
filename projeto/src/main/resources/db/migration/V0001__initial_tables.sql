set search_path to "denuncia";

create extension if not exists "uuid-ossp";

alter extension "uuid-ossp" set
schema "denuncia";

create table tb_users
(
    user_id SERIAL not null,
    id uuid default uuid_generate_v4(),
    first_name VARCHAR(50) not null,
    last_name VARCHAR(80) not null,
    email VARCHAR(120) not null,
    password VARCHAR(255) not null,
    created_at  TIMESTAMP DEFAULT NOW(),
    updated_at  TIMESTAMP,

    constraint PK_tb_users primary key (user_id),
    constraint UQ_tb_users_email unique (email)
);

create table tb_roles
(
    role_id SERIAL not null,
    id uuid default uuid_generate_v4(),
    role_name VARCHAR(30) not null,
    created_at  TIMESTAMP DEFAULT NOW(),
    updated_at  TIMESTAMP,

    constraint PK_tb_roles primary key (role_id)
);

create table tb_user_roles
(
    user_id INT not null,
    role_id INT not null,
    created_at  TIMESTAMP DEFAULT NOW(),
    updated_at  TIMESTAMP,

    constraint FK_user_roles_user foreign key (user_id) references tb_users (user_id),
    constraint FK_user_roles_role foreign key (role_id) references tb_roles (role_id)
);

create table tb_reports (
    report_id SERIAL not null,
    id uuid default uuid_generate_v4(),
    user_id int not null,
    manager_id int not null,
    protocol_number varchar,
    status varchar,
    description text not null,
    date_of_occurrence date,
    created_at  TIMESTAMP DEFAULT NOW(),
    updated_at  TIMESTAMP,

    constraint PK_tb_reports primary key (report_id),
    constraint FK_tb_reports_user foreign key (user_id) references tb_users (user_id),
    constraint FK_tb_reports_user_manager foreign key (manager_id) references tb_users (user_id)
);

insert into tb_roles (id, role_id, role_name)values (denuncia.uuid_generate_v4(), 1, 'USER');
insert into tb_roles (id, role_id, role_name)values (denuncia.uuid_generate_v4(), 2, 'ADMIN');