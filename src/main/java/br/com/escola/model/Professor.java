package br.com.escola.model;

public class Professor {

    private int idProfessor;

    private String nome;

    private String disciplina;

    private String email;

    private int idInstituicao;

    public Professor() {
    }

    public Professor(
            int idProfessor,
            String nome,
            String disciplina,
            String email,
            int idInstituicao
    ) {

        this.idProfessor = idProfessor;
        this.nome = nome;
        this.disciplina = disciplina;
        this.email = email;
        this.idInstituicao = idInstituicao;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

        return "Professor{" +
                "idProfessor=" + idProfessor +
                ", nome='" + nome + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", email='" + email + '\'' +
                ", idInstituicao=" + idInstituicao +
                '}';
    }
}