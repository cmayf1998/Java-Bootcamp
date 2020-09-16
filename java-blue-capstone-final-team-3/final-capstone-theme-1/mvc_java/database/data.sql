BEGIN;
DROP TABLE IF EXISTS itinerary_landmark;
DROP TABLE IF EXISTS Itinerary;
DROP TABLE IF EXISTS landmark;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS rating;
CREATE TABLE city (
  city_id SERIAL,
  city_name varchar(32) NOT NULL,
constraint pk_city primary key (city_id)
);
CREATE TABLE landmark (
  landmark_id SERIAL,
  city_id integer NOT NULL,
  landmark_name varchar(32) NOT NULL,
  address varchar(255) NOT NULL,
  day_open integer NOT NULL,
  day_close integer NOT NULL,
  opening_time time(32) NOT NULL,
  closing_time time(32) NOT NULL,
  venue_type varchar(32) NOT NULL,
  image varchar(32) NOT NULL,
  description varchar(255) NOT NULL,
  likes integer NOT NULL,
  dislikes integer NOT NULL,
constraint pk_landmark primary key (landmark_id),
constraint fk_city_id foreign key (city_id) references city (city_id)
);
CREATE TABLE itinerary (
        itinerary_id SERIAL,
        user_id integer NOT NULL,
        itinerary_name VARCHAR(64) NOT NULL,
        starting_point VARCHAR(64) NOT NULL,
        start_date date NOT NULL,
        end_date date NOT NULL,
constraint pk_itinerary_id PRIMARY KEY (itinerary_id),
constraint fk_user_id FOREIGN KEY (user_id) REFERENCES app_user(id)
);
CREATE TABLE itinerary_landmark (
        itinerary_id integer NOT NULL,
        landmark_id integer NOT NULL,
        constraint fk_itinerary_id FOREIGN KEY (itinerary_id) REFERENCES itinerary(itinerary_id),
        constraint fk_landmark_id FOREIGN KEY (landmark_id) REFERENCES landmark(landmark_id)
);

COMMIT;
INSERT INTO city (city_name)
VALUES ('Vancouver');
INSERT INTO landmark (landmark_name, address, city_id, day_open, day_close, opening_time, closing_time, venue_type, image, description, likes, dislikes)
VALUES ('Parq Casino', '39 Smithe St, Vancouver, BC V6B 5E7, Canada', 1, 1, 7, '09:00', '03:00', 'Casino', 'parqCasino.jpg', 'Plush riverside resort offering upscale dining, an indoor pool & a spa, plus a casino.', 0, 0);
INSERT INTO landmark (landmark_name, address, city_id, day_open, day_close, opening_time, closing_time, venue_type, image, description, likes, dislikes)
VALUES ('Vancouver Lake Regional Park', '6801 NW Lower River Rd, Vancouver, WA 98660', 1, 1, 7, '07:00', '19:00', 'Park', 'vancouverLake.jpg', 'Regional park with a sandy lakefront beach, BBQ grills, picnic tables & volleyball courts.', 0, 0);
INSERT INTO landmark (landmark_name, address, city_id, day_open, day_close, opening_time, closing_time, venue_type, image, description, likes, dislikes)
VALUES ('Le Crocodile', '909 Burrard St #100, Vancouver, BC V6Z 2N2, Canada', 1, 1, 6, '11:30', '22:00', 'Food', 'leCrocodile.jpg', 'Long-standing destination for Michel Jacobs traditional French cooking in an elegant space.', 0, 0);
INSERT INTO landmark (landmark_name, address, city_id, day_open, day_close, opening_time, closing_time, venue_type, image, description, likes, dislikes)
VALUES ('Rogers Arena', '800 Griffiths Way, Vancouver, BC V6B 6G1, Canada', 1, 1, 7, '12:00', '24:00', 'Entertainment', 'rogersArena.jpg', 'Spacious venue that hosts the Vancouver Canucks & concerts by big-name touring acts.', 0, 0);
INSERT INTO itinerary (user_id, itinerary_name, starting_point, start_date, end_date)
VALUES (1, 'Dayan Vancouver Trip', 'Hotel', '2020-09-06', '2020-09-12');
INSERT INTO itinerary_landmark (itinerary_id, landmark_id)
VALUES (1, 4);
INSERT INTO itinerary_landmark (itinerary_id, landmark_id)
VALUES (1, 3);
INSERT INTO itinerary_landmark (itinerary_id, landmark_id)
VALUES (1, 2);
INSERT INTO itinerary_landmark (itinerary_id, landmark_id)
VALUES (1, 1);
SELECT * FROM itinerary WHERE user_id = 1;

