-- INSERT

-- 1. Add Klingon as a spoken language in the USA
SELECT * FROM countrylanguage WHERE language = 'Klingon';
SELECT * FROM countrylanguage WHERE countrycode = 'USA';

INSERT INTO countrylanguage (language, isofficial, countrycode, percentage)
VALUES ('Klingon', true, 'USA', 1);

-- 2. Add Klingon as a spoken language in Great Britain

SELECT * FROM city WHERE countrycode='USA';

-- UPDATE
BEGIN TRANSACTION;
UPDATE countrylanguage
SET isofficial=false, percentage=15
WHERE countrycode='USA' AND language='Klingon';
COMMIT;

-- 1. Update the capital of the USA to Houston
-- 2. Update the capital of the USA to Washington DC and the head of state


-- DELETE
DELETE FROM countrylanguage
WHERE countrycode='USA' AND language='Klingon';

DROP TABLE countrylanguage CASCADE;


-- 1. Delete English as a spoken language in the USA
-- 2. Delete all occurrences of the Klingon language 


-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?

-- 3. Try deleting the country USA. What happens?


-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA

-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'


-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

-- 2. Try updating all of the cities to be in the USA and roll it back

-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.