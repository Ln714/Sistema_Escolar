package br.com.escola;

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

        MatriculaDAOImpl matriculaDAO =
                new MatriculaDAOImpl();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA ESCOLAR =====");

            System.out.println("1 - Cadastrar aluno");

            System.out.println("2 - Listar alunos");

            System.out.println("3 - Atualizar aluno");

            System.out.println("4 - Remover aluno");

            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            scanner.nextLine();

            switch (opcao) {

                case 1:

                    Aluno novoAluno = new Aluno();

                    System.out.print("Nome: ");
                    novoAluno.setNome(scanner.nextLine());

                    System.out.print("Email: ");
                    novoAluno.setEmail(scanner.nextLine());

                    System.out.print(
                            "Ano nascimento: "
                    );
                    int ano = scanner.nextInt();

                    System.out.print(
                            "Mes nascimento: "
                    );
                    int mes = scanner.nextInt();

                    System.out.print(
                            "Dia nascimento: "
                    );
                    int dia = scanner.nextInt();

                    scanner.nextLine();

                    novoAluno.setDataNascimento(
                            LocalDate.of(ano, mes, dia)
                    );

                    alunoDAO.cadastrar(novoAluno);

                    break;

                case 2:

                    List<Aluno> alunos =
                            alunoDAO.listar();

                    for (Aluno aluno : alunos) {

                        System.out.println(aluno);

                        System.out.println(
                                "----------------"
                        );
                    }

                    break;

                case 3:

                    Aluno alunoAtualizar =
                            new Aluno();

                    System.out.print(
                            "ID do aluno: "
                    );

                    alunoAtualizar.setIdAluno(
                            scanner.nextInt()
                    );

                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    alunoAtualizar.setNome(
                            scanner.nextLine()
                    );

                    System.out.print("Novo email: ");
                    alunoAtualizar.setEmail(
                            scanner.nextLine()
                    );

                    System.out.print(
                            "Ano nascimento: "
                    );
                    ano = scanner.nextInt();

                    System.out.print(
                            "Mes nascimento: "
                    );
                    mes = scanner.nextInt();

                    System.out.print(
                            "Dia nascimento: "
                    );
                    dia = scanner.nextInt();

                    scanner.nextLine();

                    alunoAtualizar.setDataNascimento(
                            LocalDate.of(ano, mes, dia)
                    );

                    alunoDAO.atualizar(
                            alunoAtualizar
                    );

                    break;

                case 4:

                    System.out.print(
                            "ID do aluno: "
                    );

                    int idAluno =
                            scanner.nextInt();

                    scanner.nextLine();

                    matriculaDAO.deletarPorAluno(
                            idAluno
                    );

                    alunoDAO.deletar(idAluno);

                    break;

                case 0:

                    System.out.println(
                            "Encerrando sistema..."
                    );

                    break;

                default:

                    System.out.println(
                            "Opção inválida."
                    );
            }

        } while (opcao != 0);

        scanner.close();
    }
}