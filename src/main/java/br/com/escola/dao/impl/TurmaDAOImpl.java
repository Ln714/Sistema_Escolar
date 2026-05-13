package br.com.escola.dao.impl;

import br.com.escola.dao.TurmaDAO;
import br.com.escola.database.Conexao;
import br.com.escola.model.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class TurmaDAOImpl
        implements TurmaDAO {

    @Override
    public void cadastrar(Turma turma) {

        String sql = """
                INSERT INTO turma
                (nome, periodo,
                 id_professor,
                 id_instituicao)
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection conn =
                        Conexao.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setString(
                    1,
                    turma.getNome()
            );

            stmt.setString(
                    2,
                    turma.getPeriodo()
            );

            stmt.setInt(
                    3,
                    turma.getIdProfessor()
            );

            stmt.setInt(
                    4,
                    turma.getIdInstituicao()
            );

            stmt.executeUpdate();

            System.out.println(
                    "Turma cadastrada!"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao cadastrar turma."
            );

            e.printStackTrace();
        }
    }

    @Override
    public List<Turma> listar() {

        String sql = """
                SELECT * FROM turma
                """;

        List<Turma> turmas =
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

                Turma turma = new Turma();

                turma.setIdTurma(
                        rs.getInt("id_turma")
                );

                turma.setNome(
                        rs.getString("nome")
                );

                turma.setPeriodo(
                        rs.getString("periodo")
                );

                turma.setIdProfessor(
                        rs.getInt(
                                "id_professor"
                        )
                );

                turma.setIdInstituicao(
                        rs.getInt(
                                "id_instituicao"
                        )
                );

                turmas.add(turma);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao listar turmas."
            );

            e.printStackTrace();
        }

        return turmas;
    }

    @Override
    public void atualizar(Turma turma) {

        String sql = """
                UPDATE turma
                SET nome = ?,
                    periodo = ?,
                    id_professor = ?,
                    id_instituicao = ?
                WHERE id_turma = ?
                """;

        try (
                Connection conn =
                        Conexao.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setString(
                    1,
                    turma.getNome()
            );

            stmt.setString(
                    2,
                    turma.getPeriodo()
            );

            stmt.setInt(
                    3,
                    turma.getIdProfessor()
            );

            stmt.setInt(
                    4,
                    turma.getIdInstituicao()
            );

            stmt.setInt(
                    5,
                    turma.getIdTurma()
            );

            int linhasAfetadas =
                    stmt.executeUpdate();

            if (linhasAfetadas > 0) {

                System.out.println(
                        "Turma atualizada!"
                );

            } else {

                System.out.println(
                        "Turma não encontrada."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao atualizar turma."
            );

            e.printStackTrace();
        }
    }

    @Override
    public void deletar(int idTurma) {

        String sql = """
                DELETE FROM turma
                WHERE id_turma = ?
                """;

        try (
                Connection conn =
                        Conexao.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, idTurma);

            int linhasAfetadas =
                    stmt.executeUpdate();

            if (linhasAfetadas > 0) {

                System.out.println(
                        "Turma removida!"
                );

            } else {

                System.out.println(
                        "Turma não encontrada."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao remover turma."
            );

            e.printStackTrace();
        }
    }
}