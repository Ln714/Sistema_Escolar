package br.com.escola.dao;

import br.com.escola.model.Matricula;

import java.util.List;

public interface MatriculaDAO {

    void cadastrar(Matricula matricula);

    List<Matricula> listar();

    void atualizar(Matricula matricula);

    void deletar(int idMatricula);

    void deletarPorAluno(int idAluno);
}