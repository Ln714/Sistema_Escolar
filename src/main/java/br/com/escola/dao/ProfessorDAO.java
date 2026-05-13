package br.com.escola.dao;

import br.com.escola.model.Professor;

import java.util.List;

public interface ProfessorDAO {

    void cadastrar(Professor professor);

    List<Professor> listar();

    void atualizar(Professor professor);

    void deletar(int idProfessor);
}