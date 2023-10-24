CREATE TABLE cin_financier;
\c cin_financier;

CREATE TABLE banque(
    id_banque SERIAL PRIMARY KEY,
    cin VARCHAR(12),
    solde FLOAT,
    banque VARCHAR(255)
);

INSERT INTO banque(cin, solde, banque) VALUES
    ('PERS0001', 1234567.0, 'BFV'),
    ('PERS0001', 654567.0, 'BMOI'),
    ('PERS0002', 1234567.0, 'BNI'),
    ('PERS0002', 1234567.0, 'BFV'),
    ('PERS0003', 1234567.0, 'BNI'),
    ('PERS0003', 1234567.0, 'BMOI');

UPDATE banque SET solde=90000 WHERE id_banque=7;
UPDATE banque SET solde=0 WHERE id_banque=9;

DELETE FROM banque WHERE id_banque=8;

-- DELETE FROM banque WHERE id_banque=11;

    -- ALTER TABLE banque 
    -- ADD COLUMN id_banque SERIAL PRIMARY KEY;
-- UPDATE banque SET solde=(solde - 4000000) WHERE id_banque=7;