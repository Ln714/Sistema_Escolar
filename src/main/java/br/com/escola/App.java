package br.com.escola;

import br.com.escola.dao.ProfessorDAO;
import br.com.escola.dao.impl.ProfessorDAOImpl;
import br.com.escola.model.Professor;
import br.com.escola.dao.impl.AlunoDAOImpl;
import br.com.escola.dao.impl.MatriculaDAOImpl;
import br.com.escola.model.Aluno;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AlunoDAOImpl alunoDAO =
                new AlunoDAOImpl();

        ProfessorDAOImpl professorDAO = new ProfessorDAOImpl();

        MatriculaDAOImpl matriculaDAO =
                new MatriculaDAOImpl();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA ESCOLAR =====");

            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Atualizar aluno");
            System.out.println("4 - Remover aluno");
            System.out.println("5 - Relatorio Detalhado");
            System.out.println("6 - Cadastrar professor");
            System.out.println("7 - Listar professor");
            System.out.println("8 - Atualizar professor");
            System.out.println("9 - Remover professor");

            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            scanner.nextLine();

            switch (opcao) {

                case 1:

                    Aluno novoAluno = new Aluno();

                    System.out.print("Nome: ");
                    novoAluno.setNome(scanner.nextLine());

                    System.out.println("CPF:");
                    novoAluno.setCpf(scanner.nextLine());

                    System.out.print("Email: ");
                    novoAluno.setEmail(scanner.nextLine());

                    System.out.print("Ano nascimento: ");
                    int ano = scanner.nextInt();

                    System.out.print("Mes nascimento: ");
                    int mes = scanner.nextInt();

                    System.out.print("Dia nascimento: ");
                    int dia = scanner.nextInt();

                    scanner.nextLine();

                    novoAluno.setDataNascimento(LocalDate.of(ano, mes, dia));

                    alunoDAO.cadastrar(novoAluno);

                    break;

                case 2:

                    List<Aluno> alunos = alunoDAO.listar();

                    for (Aluno aluno : alunos) {

                        System.out.println(aluno);

                        System.out.println("----------------");
                    }

                    break;

                case 3:

                    Aluno alunoAtualizar = new Aluno();

                    System.out.print("ID do aluno: ");

                    alunoAtualizar.setIdAluno(scanner.nextInt());

                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    alunoAtualizar.setNome(scanner.nextLine());

                    System.out.print("Novo cpf: ");
                    alunoAtualizar.setCpf(scanner.nextLine());

                    System.out.print("Novo email: ");
                    alunoAtualizar.setEmail(scanner.nextLine());

                    System.out.print("Ano nascimento: ");
                    ano = scanner.nextInt();

                    System.out.print("Mes nascimento: ");
                    mes = scanner.nextInt();

                    System.out.print("Dia nascimento: ");
                    dia = scanner.nextInt();

                    scanner.nextLine();

                    alunoAtualizar.setDataNascimento(LocalDate.of(ano, mes, dia));
                    alunoDAO.atualizar(alunoAtualizar);

                    break;

                case 4:

                    System.out.print("ID do aluno: ");
                    int idAluno = scanner.nextInt();
                    scanner.nextLine();

                    matriculaDAO.deletarPorAluno(idAluno);

                    alunoDAO.deletar(idAluno);

                    break;
                case 5:
                    matriculaDAO.listarDetalhado();

                    break;
                case 6:
                    Professor professor = new Professor();

                    System.out.println("Nome: ");
                    professor.setNome(scanner.nextLine());

                    System.out.println("Disciplina: ");
                    professor.setDisciplina(scanner.nextLine());

                    System.out.println("Email: ");
                    professor.setEmail(scanner.nextLine());

                    System.out.println("ID da instituição: ");
                    professor.setIdInstituicao(scanner.nextInt());

                    scanner.nextLine();
                    professorDAO.cadastrar(professor);

                    break;

                case 7:
                    professorDAO.listar().forEach(System.out::println);

                    break;

                case 8:

                    Professor atualizarProfessor = new Professor();

                    System.out.print("ID Professor: ");
                    atualizarProfessor.setIdProfessor(scanner.nextInt());

                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    atualizarProfessor.setNome(scanner.nextLine());

                    System.out.print("Nova disciplina: ");
                    atualizarProfessor.setDisciplina(scanner.nextLine());

                    System.out.print("Novo email: ");
                    atualizarProfessor.setEmail(scanner.nextLine());

                    System.out.print("Nova instituição: ");
                    atualizarProfessor.setIdInstituicao(scanner.nextInt());

                    scanner.nextLine();
                    professorDAO.atualizar(atualizarProfessor);

                    break;

                case 0:

                    System.out.println("Encerrando sistema...");

                    break;

                case 9:

                    System.out.print("ID Professor: ");
                    int idProfessor = scanner.nextInt();

                    scanner.nextLine();
                    professorDAO.deletar(idProfessor);

                    break;

                default:

                    System.out.println("Opção incorreta.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}