package br.com.escola.dao.impl;

import br.com.escola.dao.AlunoDAO;
import br.com.escola.database.Conexao;
import br.com.escola.model.Aluno;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImpl implements AlunoDAO {

    @Override
    public void cadastrar(Aluno aluno) {

        String sql = """
                INSERT INTO aluno(nome, cpf,email, data_nascimento) VALUES (?, ?, ?, ?)
                """;

        try(Connection conn =Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setDate(4, Date.valueOf(aluno.getDataNascimento()));

            stmt.executeUpdate();

            System.out.println("Aluno cadastrado!");
        }catch (SQLException e) {

            System.out.println("Erro ao cadastrar aluno. :(");
            e.printStackTrace();
        }
    }
    @Override
    public List<Aluno> listar() {

        String sql = """
            SELECT * FROM aluno
            """;

        List<Aluno> alunos = new ArrayList<>();

        try (
                Connection conn = Conexao.conectar();

                PreparedStatement stmt =
                        conn.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                Aluno aluno = new Aluno();

                aluno.setIdAluno(
                        rs.getInt("id_aluno")
                );

                aluno.setNome(
                        rs.getString("nome")
                );

                aluno.setCpf(
                        rs.getString("cpf")
                );

                aluno.setEmail(
                        rs.getString("email")
                );

                aluno.setDataNascimento(
                        rs.getDate("data_nascimento")
                                .toLocalDate()
                );

                alunos.add(aluno);
            }

        } catch (SQLException e) {

            System.out.println("Erro ao listar alunos.");

            e.printStackTrace();
        }

        return alunos;
    }
    @Override
    public void atualizar(Aluno aluno) {

        String sql = """
                update aluno
                set nome = ?,
                cpf = ?,
                email = ?,
                data_nascimento = ?
                where id_aluno = ?
                """;
        try(
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)

        ){
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setDate(4, Date.valueOf(aluno.getDataNascimento()));
            stmt.setInt(5, aluno.getIdAluno());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Aluno atualizado!");

            }else {
                System.out.println("Aluno no encontrado");
            }

        }catch (SQLException e) {
            System.out.println("Erro ao atualizar aluno");
            e.printStackTrace();
        }
    }
    @Override
    public void deletar(int idAluno) {

        String sql = """
                delete from aluno
                where id_aluno = ?
                """;

        try(
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)

        ){
            stmt.setInt(1, idAluno);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Aluno removido");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover");
            e.printStackTrace();
        }
    }





}
