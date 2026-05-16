# Sistema_Escolar
Criação de um sistema para gerenciamento de instituições, professores, alunos, matriculas e turmas. Projeto criado usando a maven-archetype-quickstart, utilizando também as boas práticas de acesso aos dados do banco de dados com o DAO.




Sistema de gerenciamento escolar desenvolvido
em Java com JDBC e MySQL.

O projeto possui funcionalidades de cadastro, listagem, atualização e remoção de alunos, professores, turmas e matrículas, além de relatórios relacionais utilizando JOIN no banco de dados.

---

# Tecnologias utilizadas

- Java
- Maven
- JDBC
- MySQL
- IntelliJ IDEA
- Git
- GitHub

---

# Estrutura do projeto

src/main/java

br.com.escola
│
├── dao
│   ├── AlunoDAO
│   ├── ProfessorDAO
│   ├── TurmaDAO
│   └── MatriculaDAO
│
├── dao.impl
│   ├── AlunoDAOImpl
│   ├── ProfessorDAOImpl
│   ├── TurmaDAOImpl
│   └── MatriculaDAOImpl
│
├── database
│   └── Conexao
│
├── model
│   ├── Aluno
│   ├── Professor
│   ├── Turma
│   └── Matricula
│
└── App

---

# Funcionalidades

## Gestão de alunos
- Cadastrar aluno
- Listar alunos
- Atualizar aluno
- Remover aluno

## Gestão de professores
- Cadastrar professor
- Listar professores
- Atualizar professor
- Remover professor

## Gestão de turmas
- Cadastrar turma
- Listar turmas
- Atualizar turma
- Remover turma

## Gestão de matrículas
- Cadastrar matrícula
- Listar matrículas
- Atualizar matrícula
- Remover matrícula

## Relatórios
- Relatório detalhado utilizando INNER JOIN

---

# Banco de dados

O projeto utiliza MySQL com relacionamentos entre tabelas:

- aluno
- professor
- turma
- matricula
- instituicao

Relacionamentos realizados com FOREIGN KEY(FK).

---

# Como executar

## 1. Clone o repositório

```bash
git clone https://github.com/Ln714/Sistema_Escolar
````

## 2. Configure o MySQL

Execute o script:
BD_sistema_escolar.sql
## 3. Configure a conexão no arquivo

Conexao.java

## 4. Execute o projeto pelo IntelliJ IDEA

# Menu principal

===== SISTEMA ESCOLAR =====

--------Gestão Aluno---------

1 - Cadastrar aluno

2 - Listar alunos

3 - Atualizar aluno

4 - Remover aluno

5 - Relatorio Detalhado


--------Gestão Professor---------

6 - Cadastrar professor

7 - Listar professor

8 - Atualizar professor

9 - Remover professor

--------Gestão Turma---------

10 - Cadastrar turma

11 - Listar turmas

12 - Atualizar turma

13 - Remover turma

--------Gestão Matricula---------

14 - Cadastrar matrícula

15 - Listar matrículas

16 - Atualizar matrícula

17 - Remover matrícula

0 - Sair

# Autor
Lucas Nunes

