


create database barber_db;

       use barber_db;


create table barber
(
    id         int auto_increment primary key,
    first_name varchar(100)       not null,
    last_name  varchar(100),
    date_of_birth date not null,
    phone      varchar(20) unique not null,
    email      varchar(70) unique not null
);


create table client
(
    id         int auto_increment primary key,
    first_name varchar(100)       not null,
    last_name  varchar(100),
    date_of_birth date not null,
    phone      varchar(20) unique not null,
    email      varchar(70) unique not null
);


create table service
(
    id    int auto_increment primary key,
    title varchar(100) unique not null,
    description varchar(255),
    price int not null
);


create table appointment
(
    id    int auto_increment primary key,
    date_time date not null,
    time time not null,
    note varchar(255),
    client_id int,
    barber_id int,
    FOREIGN KEY (client_id) REFERENCES client (id),
    FOREIGN KEY (barber_id) REFERENCES barber (id)
);


create table transaction
(
    id    int auto_increment primary key,
    amount int not null,
    type varchar(255)  not null,
    date_time date not null,
    time time not null,
    appointment_id int,
    FOREIGN KEY (appointment_id) REFERENCES appointment (id)
);


create table Barber_Service
(
  barber_id int,
  service_id int,
  FOREIGN KEY (barber_id) references barber (id),
  FOREIGN KEY (service_id) references service (id),
  PRIMARY KEY (barber_id, service_id)
);



INSERT INTO barber (first_name, last_name, date_of_birth, phone, email)
VALUES
    ('Ivan', 'Ivanov', '1990-01-01', '012-345-67-89', 'ivan@gmail.com'),
    ('Petr', 'Petrov', '1985-02-15', '023-456-78-90', 'petr@gmail.com'),
    ('Anna', 'Sidorova', '1988-05-20', '034-567-89-01', 'anna@gmail.com'),
    ('Elena', 'Goat', '1992-09-10', '045-678-90-12', 'elena@gmail.com'),
    ('Sergey', 'Seri', '1983-11-30', '056-789-01-23', 'sergey@gmail.com');


insert into client (first_name, last_name, date_of_birth, phone, email,)
values
    ('John', 'Doe', '1980-05-15', '123-456-78-90', 'john.doe@example.com'),
    ('Alice', 'Smith', '1992-09-20', '987-654-32-10', 'alice.smith@example.com'),
    ('Michael', 'Johnson',  '1975-11-10', '555-123-45-67', 'michael.johnson@example.com'),
    ('Aurora', 'Lazy','1992-09-20', '924-124-35-17', 'aurora.lazy@example.com');


insert into service (title, description, price)
values
    ('Haircut', 'Standard haircut', 25),
    ('Shave', 'Traditional shave', 15),
    ('Coloring', 'Hair coloring service', 50);



insert into Barber_Service (barber_id, service_id)
values
    (1, (select id from service where title = 'Haircut')),
    (1, (select id from service where title = 'Shave')),
    (1, (select id from service where title = 'Coloring')),
    (2, (select id from service where title = 'Haircut')),
    (3, (select id from service where title = 'Shave')),
    (4, (select id from service where title = 'Coloring')),
    (5, (select id from service where title = 'Shave')),
    (5, (select id from service where title = 'Haircut'));


insert into appointment (date_time, time, note, barber_id, client_id)
values
('2023-05-18', '12:00:00', 'Make an appointment', 1, 1),
('2023-05-19', '14:30:00', 'Make an appointment', 2, 2),
('2023-05-20', '09:00:00', 'Make an appointment', 3, 3),
('2023-05-21', '16:00:00', 'Make an appointment', 4, 4),
('2023-05-22', '10:00:00', 'Make an appointment', 5, 4);


insert into transaction (amount, type, date_time, time, appointment_id)
values
    (25.00, 'Payment', '2024-05-20', '11:00:00', 1),
    (15.00, 'Payment', '2024-05-22', '16:00:00', 2),
    (50.00, 'Payment', '2024-05-25', '14:00:00', 3);







