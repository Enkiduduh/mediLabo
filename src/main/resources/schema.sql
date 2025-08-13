CREATE TABLE IF NOT EXISTS patient (
  patient_id       INT PRIMARY KEY AUTO_INCREMENT,
  nom              VARCHAR(100) NOT NULL,
  prenom           VARCHAR(100) NOT NULL,
  date_naissance   DATE NOT NULL,
  genre            CHAR(1) NOT NULL,
  adresse          VARCHAR(200),
  telephone        VARCHAR(30),
  CONSTRAINT chk_genre CHECK (genre IN ('F','M')),
  CONSTRAINT uq_patient_natural UNIQUE (nom, prenom, date_naissance)
);

CREATE TABLE IF NOT EXISTS user (
    id INT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    password VARCHAR(100)
);