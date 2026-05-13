package br.com.escola.dao.impl;

import br.com.escola.dao.ProfessorDAO;
import br.com.escola.database.Conexao;
import br.com.escola.model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDAOImpl
        implements ProfessorDAO {

    @Override
    public void cadastrar(
            Professor professor
    ) {

        String sql = """
                INSERT INTO professor
                (nome, disciplina, email, id_instituicao)
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
                    professor.getNome()
            );

            stmt.setString(
                    2,
                    professor.getDisciplina()
            );

            stmt.setString(
                    3,
                    professor.getEmail()
            );

            stmt.setInt(
                    4,
                    professor.getIdInstituicao()
            );

            stmt.executeUpdate();

            System.out.println(
                    "Professor cadastrado!"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao cadastrar professor."
            );

            e.printStackTrace();
        }
    }

    @Override
    public List<Professor> listar() {

        String sql = """
                SELECT * FROM professor
                """;

        List<Professor> professores =
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

                Professor professor =
                        new Professor();

                professor.setIdProfessor(
                        rs.getInt("id_professor")
                );

                professor.setNome(
                        rs.getString("nome")
                );

                professor.setDisciplina(
                        rs.getString("disciplina")
                );

                professor.setEmail(
                        rs.getString("email")
                );

                professor.setIdInstituicao(
                        rs.getInt(
                                "id_instituicao"
                        )
                );

                professores.add(professor);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao listar professores."
            );

            e.printStackTrace();
        }

        return professores;
    }

    @Override
    public void atualizar(
            Professor professor
    ) {

        String sql = """
                UPDATE professor
                SET nome = ?,
                    disciplina = ?,
                    email = ?,
                    id_instituicao = ?
                WHERE id_professor = ?
                """;

        try (
                Connection conn =
                        Conexao.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setString(
                    1,
                    professor.getNome()
            );

            stmt.setString(
                    2,
                    professor.getDisciplina()
            );

            stmt.setString(
                    3,
                    professor.getEmail()
            );

            stmt.setInt(
                    4,
                    professor.getIdInstituicao()
            );

            stmt.setInt(
                    5,
                    professor.getIdProfessor()
            );

            int linhasAfetadas =
                    stmt.executeUpdate();

            if (linhasAfetadas > 0) {

                System.out.println(
                        "Professor atualizado!"
                );

            } else {

                System.out.println(
                        "Professor não encontrado."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao atualizar professor."
            );

            e.printStackTrace();
        }
    }

    @Override
    public void deletar(
            int idProfessor
    ) {

        String sql = """
                DELETE FROM professor
                WHERE id_professor = ?
                """;

        try (
                Connection conn =
                        Conexao.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, idProfessor);

            int linhasAfetadas =
                    stmt.executeUpdate();

            if (linhasAfetadas > 0) {

                System.out.println(
                        "Professor removido!"
                );

            } else {

                System.out.println(
                        "Professor não encontrado."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao remover professor."
            );

            e.printStackTrace();
        }
    }
}