package br.com.escola.dao;

import br.com.escola.model.Turma;

import java.util.List;

public interface TurmaDAO {

    void cadastrar(Turma turma);

    List<Turma> listar();

    void atualizar(Turma turma);

    void deletar(int idTurma);
}