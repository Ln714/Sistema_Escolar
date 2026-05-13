package br.com.escola.dao;

import br.com.escola.model.Aluno;

import java.util.List;

public interface AlunoDAO {
    void cadastrar(Aluno aluno);

    List<Aluno> listar();

    void atualizar(Aluno aluno);

    void deletar(int idAluno);
}

