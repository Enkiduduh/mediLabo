CREATE TABLE patient (
  patient_id       INT PRIMARY KEY,
  nom              VARCHAR(100) NOT NULL,
  prenom           VARCHAR(100) NOT NULL,
  date_naissance   DATE NOT NULL,
  genre            CHAR(1) NOT NULL,
  adresse          VARCHAR(200),
  telephone        VARCHAR(30),
  CONSTRAINT chk_genre CHECK (genre IN ('F','M')),
  CONSTRAINT uq_patient_natural UNIQUE (nom, prenom, date_naissance)
);