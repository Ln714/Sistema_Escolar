package br.com.escola.dao.impl;

import br.com.escola.dao.MatriculaDAO;
import br.com.escola.database.Conexao;
import br.com.escola.model.Matricula;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class MatriculaDAOImpl
        implements MatriculaDAO {

    @Override
    public void cadastrar(
            Matricula matricula
    ) {

        String sql = """
                INSERT INTO matricula
                (id_aluno,
                 id_turma,
                 data_matricula)
                VALUES (?, ?, ?)
                """;

        try (
                Connection conn =
                        Conexao.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(
                    1,
                    matricula.getIdAluno()
            );

            stmt.setInt(
                    2,
                    matricula.getIdTurma()
            );

            stmt.setDate(
                    3,
                    Date.valueOf(
                            matricula.getDataMatricula()
                    )
            );

            stmt.executeUpdate();

            System.out.println(
                    "Matrícula cadastrada!"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao cadastrar matrícula."
            );

            e.printStackTrace();
        }
    }

    @Override
    public List<Matricula> listar() {

        String sql = """
                SELECT * FROM matricula
                """;

        List<Matricula> matriculas =
                new ArrayList<>();

        try (
                Connection conn =
                        Conexao.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql);

                ResultSet rs =
                        stmt.executeQuery()
        ) {

            while (rs.next()) {

                Matricula matricula =
                        new Matricula();

                matricula.setIdMatricula(
                        rs.getInt(
                                "id_matricula"
                        )
                );

                matricula.setIdAluno(
                        rs.getInt("id_aluno")
                );

                matricula.setIdTurma(
                        rs.getInt("id_turma")
                );

                matricula.setDataMatricula(
                        rs.getDate(
                                "data_matricula"
                        ).toLocalDate()
                );

                matriculas.add(matricula);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao listar matrículas."
            );

            e.printStackTrace();
        }

        return matriculas;
    }

    @Override
    public void atualizar(
            Matricula matricula
    ) {

        String sql = """
                UPDATE matricula
                SET id_aluno = ?,
                    id_turma = ?,
                    data_matricula = ?
                WHERE id_matricula = ?
                """;

        try (
                Connection conn =
                        Conexao.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(
                    1,
                    matricula.getIdAluno()
            );

            stmt.setInt(
                    2,
                    matricula.getIdTurma()
            );

            stmt.setDate(
                    3,
                    Date.valueOf(
                            matricula.getDataMatricula()
                    )
            );

            stmt.setInt(
                    4,
                    matricula.getIdMatricula()
            );

            int linhasAfetadas =
                    stmt.executeUpdate();

            if (linhasAfetadas > 0) {

                System.out.println(
                        "Matrícula atualizada!"
                );

            } else {

                System.out.println(
                        "Matrícula não encontrada."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao atualizar matrícula."
            );

            e.printStackTrace();
        }
    }

    @Override
    public void deletar(int idMatricula) {

    }

    @Override
    public void deletarPorAluno(
            int idAluno
    ) {

        String sql = """
            DELETE FROM matricula
            WHERE id_aluno = ?
            """;

        try (
                Connection conn =
                        Conexao.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, idAluno);

            stmt.executeUpdate();

            System.out.println(
                    "Matrículas removidas!"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao remover matrículas."
            );

            e.printStackTrace();
        }
    }
    public void listarDetalhado(){

        String sql =  """
            SELECT
                a.nome AS aluno,
                t.nome AS turma,
                p.nome AS professor,
                i.nome AS instituicao,
                m.data_matricula
            FROM matricula m
            
            INNER JOIN aluno a
                ON m.id_aluno = a.id_aluno
                
            INNER JOIN turma t
                ON m.id_turma = t.id_turma
                
            INNER JOIN professor p
                ON t.id_professor = p.id_professor
                
            INNER JOIN instituicao i
                ON t.id_instituicao = i.id_instituicao
                """;

        try(
                Connection conn = Conexao.conectar();

                PreparedStatement stmt = conn.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery()
        ) {
            System.out.println("\n=== RELATORIO ORGANIZADO ===");

            while (rs.next()) {

                System.out.printf(
                        "%-15s %-32s %-20s %-25s %-15s%n",

                        rs.getString("aluno"),

                        rs.getString("turma"),

                        rs.getString("professor"),

                        rs.getString("instituicao"),

                        rs.getDate("data_matricula")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro no relatório."
            );

            e.printStackTrace();
        }
    }

}