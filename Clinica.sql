CREATE DATABASE IF NOT EXISTS Clínica2;

USE Clínica2;

CREATE TABLE IF NOT EXISTS Paciente
(
  id_p INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome_p VARCHAR(55),
  cpf_p VARCHAR(55),
  ende_p VARCHAR (55),
  idade_p INT, 
  telefone_p VARCHAR(55),
  convenio_p VARCHAR(55)
);

CREATE TABLE IF NOT EXISTS Profissional
(
  id_pr INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome_pr VARCHAR(55),
  cpf_pr VARCHAR(55),
  ende_pr VARCHAR(55),
  idade_pr INT,
  telefone_pr VARCHAR(55),
  especialidade_pr VARCHAR(55)
);

CREATE TABLE IF NOT EXISTS Consulta
(
  numero_c INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  data_c date,
  receita_c VARCHAR(55),
  feita BOOLEAN,
  id_p INT REFERENCES Paciente(id_p),
  id_pr INT REFERENCES Profissional(id_pr)
);

CREATE TABLE IF NOT EXISTS Usuário
(
  id_u INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(55),
  password VARCHAR(55)
);
SELECT * FROM Consulta;
INSERT INTO Usuário(login_u, senha_u)
VALUES("Joaquim@J", "876"),
      ("Ana@A", "012"),
	  ("Miguel@M" , "999");