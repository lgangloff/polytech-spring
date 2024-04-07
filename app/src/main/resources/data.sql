-- Génération des adresses
CREATE TEMP TABLE temp_address AS
SELECT
    generate_series(1, 2000) AS id,
    'City' || generate_series(1, 2000) AS city,
    'Street' || generate_series(1, 2000) AS street,
    LPAD((random()*99999)::int::text, 5, '0') AS zip_code
FROM
    generate_series(1, 2000);

-- Insertion des adresses dans la table address
INSERT INTO address (id, city, street, zip_code)
SELECT
    id,
    city,
    street,
    zip_code
FROM
    temp_address
LIMIT 2000;

-- Génération des docteurs
INSERT INTO doctor (id_address, first_name, last_name)
SELECT
    id,
    'Doctor' || (random()*1000)::int::text,
    'Last' || (random()*1000)::int::text
FROM
    temp_address
LIMIT 100;

-- Génération des patients
INSERT INTO patient (birth_date, id_address, preferred_id_person_doctor, removed, mail, first_name, last_name)
SELECT
    CURRENT_DATE - INTERVAL '20 years' * random() AS birth_date,
    id,
    (random()*99 + 1)::int AS preferred_id_person_doctor,
    'N' AS removed,
    'patient' || (random()*1000)::int::text || '@example.com' AS mail,
    'Patient' || (random()*1000)::int::text,
    'Last' || (random()*1000)::int::text
FROM
    temp_address
LIMIT 100;

-- Suppression de la table temporaire
DROP TABLE temp_address;