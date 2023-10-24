CREATE DATABASE cin_foncier;
\c cin_foncier;

CREATE TABLE foncier(
    cin VARCHAR(12),
    terrain VARCHAR(255) NOT NULL
);

INSERT INTO foncier(cin, terrain, superficie) VALUES
    ('PERS0001', 'Ambatoloaka', 103.4),
    ('PERS0001', 'Ambohibao', 50.1),
    ('PERS0002', 'Andranomena', 43.5),
    ('PERS0002', 'Ivato', 87.2),
    ('PERS0003', 'Ambatolampy', 75.0);

ALTER TABLE foncier
ADD COLUMN id_foncier SERIAL PRIMARY KEY;

ALTER TABLE foncier
DROP COLUMN superficie;

ALTER TABLE foncier
ADD COLUMN superficie FLOAT DEFAULT 0.0;

CREATE TABLE latlon(
    id_latlon SERIAL PRIMARY KEY,
    id_foncier INTEGER REFERENCES foncier(id_foncier),
    lat FLOAT,
    lon FLOAT
);
