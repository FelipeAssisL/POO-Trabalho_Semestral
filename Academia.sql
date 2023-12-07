CREATE DATABASE ACADEMIA;
USE ACADEMIA;

CREATE TABLE Aluno (
idAluno int auto_increment PRIMARY KEY, 
nomeAluno varchar(30), 
rgAluno char(9), 
nascimentoAluno date, 
entradaAluno date, 
emailAluno varchar(30), 
foneAluno char(11)
);

CREATE TABLE Plano (
tituloPlano varchar(30) PRIMARY KEY,
valorMensal decimal(5,2),
valorAnual decimal(6,2),
beneficiosPlano varchar(200)
);

CREATE TABLE Tutor (
nomeTutor varchar(30) PRIMARY KEY,
especialidade varchar(20),
descricaoTutor varchar(200)
);

CREATE TABLE Equipamento (
idEquip int auto_increment PRIMARY KEY,
nomeEquip varchar(30),
descricaoEquip varchar(200)
);

CREATE TABLE Aviso (
idAviso int auto_increment PRIMARY KEY,
tituloAviso varchar(30),
descricaoAviso varchar(200),
publicacaoAviso date
);

CREATE TABLE Evento (
idEvento int auto_increment PRIMARY KEY,
tituloEvento varchar(30),
dataEvento date,
horaEvento time,
descricaoEvento varchar(200),
limiteAlunos int,
codTutor varchar(30), FOREIGN KEY(codTutor) REFERENCES Tutor(nomeTutor),
codPlano varchar(30), FOREIGN KEY(codPlano) REFERENCES Plano(tituloPlano)
);

CREATE TABLE PresencaEvento (
codAluno int,
codEvento int,
PRIMARY KEY (codAluno, codEvento),
FOREIGN KEY(codAluno) REFERENCES Aluno(idAluno),
FOREIGN KEY(codEvento) REFERENCES Evento(idEvento)
);

CREATE TABLE SolicitacaoPlano (
codPlano VARCHAR(30),
codAluno int,
PRIMARY KEY (codPlano, codAluno),
FOREIGN KEY(codPlano) REFERENCES Plano(tituloPlano),
FOREIGN KEY(codAluno) REFERENCES Aluno (idAluno)
);

