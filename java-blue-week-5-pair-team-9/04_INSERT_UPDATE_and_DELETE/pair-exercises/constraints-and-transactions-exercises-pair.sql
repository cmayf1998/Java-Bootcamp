-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)
INSERT INTO city(name, district, countrycode, population)
VALUES ('Smallville', 'Kansas', 'USA', 45001);

SELECT * FROM city WHERE name = 'Smallville';

-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.
INSERT INTO countrylanguage(countrycode, language, percentage, isofficial)
VALUES ('USA', 'Kryptonese', 0.0001, false);

SELECT * FROM countrylanguage WHERE language = 'Kryptonese';

-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.
UPDATE countrylanguage
SET language = 'Krypto-babble'
WHERE language = 'Kryptonese';

SELECT * FROM countrylanguage WHERE language = 'Krypto-babble';

-- 4. Set the US captial to Smallville, Kansas in the country table.
SELECT * FROM country WHERE code = 'USA';

SELECT * FROM city WHERE name = 'Smallville'; --Smallville, Kansas

UPDATE country
SET capital = 4080
WHERE code = 'USA';

-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

--DELETE FROM city
--WHERE name = 'Smallville' AND district = 'Kansas';
--IT DIDNT WORK because id number from city table is a foreign key in the country table 
--WE could still delete it using 'CASCADE' but we would be violating REFERENTIAL INTEGRITY

-- 6. Return the US captial to Washington.

SELECT * FROM city WHERE id = 3813; --Washington id number

UPDATE country
SET capital = 3813
WHERE code = 'USA';

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

DELETE FROM city
WHERE name = 'Smallville' AND district = 'Kansas';

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)
UPDATE countrylanguage
SET isofficial = NOT isofficial
WHERE countrycode IN (SELECT code FROM country WHERE indepyear >= 1800 AND indepyear <= 1972);

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)

UPDATE city
SET population = ROUND(population/1000);

-- 10. Assuming a country's surfacearea is expressed in square miles, convert it to 
-- square meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)

--squaremiles to square meters formula: 
--m^2 = Miles^2 * 2589988.1103

UPDATE country
SET surfacearea = surfacearea * 2589988.1103
WHERE code IN (SELECT countrycode FROM countrylanguage WHERE language = 'French' AND percentage > 20);




