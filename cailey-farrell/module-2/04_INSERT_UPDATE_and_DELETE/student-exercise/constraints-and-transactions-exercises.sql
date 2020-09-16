-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
INSERT INTO actor(first_name, last_name)
VALUES('HAMPTON', 'AVENUE');
INSERT INTO actor (first_name, last_name)
VALUES('LISA','BYWAY');


-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
INSERT INTO film (title, description, release_year, length, language_id)
VALUES('EUCLIDEAN PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 198, 1);

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
INSERT INTO film_actor(actor_id, film_id)
VALUES(
        (SELECT actor_id FROM actor WHERE actor.first_name = 'HAMPTON' AND actor.last_name = 'AVENUE'),
        (SELECT film_id FROM film WHERE film.title = 'EUCLIDEAN PI'));
        
INSERT INTO film_actor(actor_id, film_id)
VALUES(
        (SELECT actor_id FROM actor WHERE actor.first_name = 'LISA' AND actor.last_name = 'BYWAY'),
        (SELECT film_id FROM film WHERE film.title = 'EUCLIDEAN PI'));
       
       
-- 4. Add Mathmagical to the category table.
INSERT INTO category(name)
VALUES('Mathmagical');


-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE
--INSERT INTO category(name)

INSERT INTO film_category(film_id, category_id)
VALUES((SELECT film_id FROM film WHERE film.title = 'EUCLIDEAN PI'),(SELECT category_id FROM category WHERE category.name= 'Mathmagical'));


INSERT INTO film_category(film_id, category_id)
VALUES((SELECT max(film_id) FROM film WHERE film.title = 'EGG IGBY'),(SELECT max(category_id) FROM category WHERE category.name= 'Mathmagical'));
INSERT INTO film_category(film_id, category_id)
VALUES((SELECT max(film_id) FROM film WHERE film.title = 'KARATE MOON'),(SELECT max(category_id) FROM category WHERE category.name= 'Mathmagical'));
INSERT INTO film_category(film_id, category_id)
VALUES((SELECT max(film_id) FROM film WHERE film.title = 'RANDOM GO'),(SELECT max(category_id) FROM category WHERE category.name= 'Mathmagical'));
INSERT INTO film_category(film_id, category_id)
VALUES((SELECT max(film_id) FROM film WHERE film.title = 'YOUNG LANGUAGE'),(SELECT max(category_id) FROM category WHERE category.name= 'Mathmagical'));

SELECT * FROM film_category
WHERE category_id = 17;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
UPDATE film
SET rating = 'G'
WHERE film_id IN
(       SELECT film_id
        FROM film_category
        WHERE category_id = (SELECT category_id FROM category WHERE name = 'Mathmagical')
);


-- 7. Add a copy of "Euclidean PI" to all the stores.
INSERT INTO inventory(film_id, store_id)
SELECT(SELECT film_id FROM film WHERE film.title = 'EUCLIDEAN PI'), store_id FROM store;

SELECT * FROM inventory WHERE film_id IN (SELECT film_id FROM film WHERE film.title = 'EUCLIDEAN PI');


-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- Did not suceed because it violates a foreign key constraint, it is referenced to other tables and cannot be deleted yet
DELETE FROM film
WHERE title = 'EUCLIDEAN PI';


-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- DId not suceed because of a violation with a foreign key constrainy
DELETE FROM category
WHERE name = 'Mathmagical';

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- Yes, it did suceed because it looked for all cases where Mathmagical exists
DELETE FROM film_category
WHERE category_id IN (SELECT category_id FROM category WHERE name = 'Mathmagical');

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- No this should not work because there are multiple connections to the film_id than just in category.
DELETE FROM category
WHERE name = 'Mathmagical';

DELETE FROM film
WHERE title = 'EUCLIDEAN PI';

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
--All links to Euclidean Pi need to be deleted first which exists in multiple tables with the foreign key as film_id,title for example: film_category
