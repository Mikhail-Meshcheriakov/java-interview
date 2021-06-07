create table films (
    id                      bigserial primary key,
    title                   varchar(60) not null,
    duration                varchar(80) not null
);

create table sessions (
    id                      bigserial primary key,
    film_id                 bigint not null references films (id),
    start_time              time not null,
    price                   int not null
);

create table tickets (
    id                      bigserial primary key,
    session_id              bigint not null references sessions (id),
	place                   int not null
);

insert into films (title, duration)
values
('CRUELLA', 90),
('A Quiet Place Sequel', 120),
('Wrath of Man', 90),
('Untitled Spirit Riding Free Film', 60),
('Fast Furious 9', 120);

insert into sessions (film_id, start_time, price)
values
(4, '10:00', 180),
(1, '11:15', 200),
(2, '13:05', 210),
(5, '15:00', 230),
(4, '17:40', 210),
(3, '18:50', 220),
(1, '20:35', 200),
(5, '21:50', 200);

insert into tickets (session_id, place)
values
(1, 10),
(1, 11),
(1, 5),
(1, 3),
(2, 1),
(2, 13),
(2, 14),
(2, 15),
(2, 5),
(3, 10),
(3, 11),
(3, 20),
(4, 8),
(5, 1),
(5, 2),
(5, 3),
(5, 4),
(5, 10),
(5, 11),
(6, 5),
(8, 9),
(8, 10),
(8, 11);

select s1.title, s1.duration, s1.start_time, s1.end_time
from (SELECT f.id, title, duration, start_time, start_time + (duration||' minutes')::INTERVAL end_time from films f JOIN sessions s ON f.id = s.film_id) AS s1 
JOIN (SELECT f.id, title, duration, start_time, start_time + (duration||' minutes')::INTERVAL end_time from films f JOIN sessions s ON f.id = s.film_id) AS s2
ON s1.start_time < s2.end_time AND s1.end_time > s2.start_time and s1.id <> s2.id;

select s1.title, s1.duration, s1.start_time, s1.end_time, s2.title, s2.start_time, s2.end_time, s1.end_time - s2.start_time AS interval
from (SELECT f.id, title, duration, start_time, start_time + (duration||' minutes')::INTERVAL end_time from films f JOIN sessions s ON f.id = s.film_id) AS s1 
JOIN (SELECT f.id, title, duration, start_time, start_time + (duration||' minutes')::INTERVAL end_time from films f JOIN sessions s ON f.id = s.film_id) AS s2
ON s2.start_time - s1.end_time > '00:30:00' and s1.id = s2.id;