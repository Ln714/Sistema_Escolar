package br.com.escola.model;

public class Turma {

    private int idTurma;

    private String nome;

    private String periodo;

    private int idProfessor;

    private int idInstituicao;

    public Turma() {
    }

    public Turma(
            int idTurma,
            String nome,
            String periodo,
            int idProfessor,
            int idInstituicao
    ) {

        this.idTurma = idTurma;
        this.nome = nome;
        this.periodo = periodo;
        this.idProfessor = idProfessor;
        this.idInstituicao = idInstituicao;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(
            int idProfessor
    ) {
        this.idProfessor = idProfessor;
    }

    public int getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(
            int idInstituicao
    ) {
        this.idInstituicao = idInstituicao;
    }

    @Override
    public String toString() {

        return "Turma{" +
                "idTurma=" + idTurma +
                ", nome='" + nome + '\'' +
                ", periodo='" + periodo + '\'' +
                ", idProfessor=" + idProfessor +
                ", idInstituicao=" + idInstituicao +
                '}';
    }
}