package br.com.escola.model;

import java.time.LocalDate;

public class Matricula {

    private int idMatricula;

    private int idAluno;

    private int idTurma;

    private LocalDate dataMatricula;

    public Matricula() {
    }

    public Matricula(
            int idMatricula,
            int idAluno,
            int idTurma,
            LocalDate dataMatricula
    ) {

        this.idMatricula = idMatricula;
        this.idAluno = idAluno;
        this.idTurma = idTurma;
        this.dataMatricula = dataMatricula;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(
            int idMatricula
    ) {
        this.idMatricula = idMatricula;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(
            LocalDate dataMatricula
    ) {
        this.dataMatricula = dataMatricula;
    }

    @Override
    public String toString() {

        return "Matricula{" +
                "idMatricula=" + idMatricula +
                ", idAluno=" + idAluno +
                ", idTurma=" + idTurma +
                ", dataMatricula=" + dataMatricula +
                '}';
    }
}