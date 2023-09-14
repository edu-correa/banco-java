package org.example;

public class Filme {
    private String nome;
    private String dataLanc;
    private Integer id;
    private Integer duracao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataLanc() {
        return dataLanc;
    }

    public void setDataLanc(String dataLanc) {
        this.dataLanc = dataLanc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", lancamento='" + dataLanc + '\'' +
                ", id=" + id +
                ", duracao=" + duracao +
                '}' + "\n";
    }
}
