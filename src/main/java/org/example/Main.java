package org.example;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection banco = new Connection();
        JdbcTemplate con = banco.getConexaoBanco();
        BeanPropertyRowMapper desenfeiador = new BeanPropertyRowMapper<>(Filme.class);

        con.execute("DROP TABLE filme if EXISTS;");
        con.execute("""
                            CREATE TABLE filme(
                            id INT PRIMARY KEY AUTO_INCREMENT, 
                            nome VARCHAR(100), 
                            duracao INT,
                            dataLanc DATE);""");

        con.execute("""
                INSERT INTO filme (nome, duracao, dataLanc) VALUES('Shrek', 140, '2002-04-14')
                """);
        con.execute("""
                INSERT INTO filme (nome, duracao, dataLanc) VALUES('Shrek terceiro', 140, '2003-12-03')
                """);
        con.execute("""
                INSERT INTO filme (nome, duracao, dataLanc) VALUES('Shrek para sempre', 140, '2005-11-02')
                """);

        List<Filme> filmes = con.query("SELECT * FROM filme;",
                new BeanPropertyRowMapper<>(Filme.class));

        System.out.println(filmes);
        String terc = "'Matrix'; DROP TABLE filme;";
        List<Filme> busca = con.query("SELECT * FROM filme WHERE nome LIKE ?", desenfeiador, terc);
        System.out.println(busca);

        Filme novoFilme = new Filme();

        novoFilme.setDuracao(280);
        novoFilme.setNome("O Farol");
        novoFilme.setDataLanc("2021-08-23");
        System.out.println(novoFilme.getDataLanc());
        con.update("INSERT INTO filme (nome, dataLanc, duracao) VALUES (?, ?, ?)", novoFilme.getNome(), novoFilme.getDataLanc(), novoFilme.getDuracao());
        busca = con.query("SELECT * FROM filme", desenfeiador);
        System.out.println(busca);

        novoFilme.setNome("Jorrada nas Estrelas");
        novoFilme.setId(4);

        con.update("UPDATE filme SET nome = ?, dataLanc = ?, duracao = ? WHERE id = ?",
                novoFilme.getNome(), novoFilme.getDataLanc(), novoFilme.getDuracao(), novoFilme.getId());

        busca = con.query("SELECT * FROM filme", desenfeiador);
        System.out.println(busca);


        con.update("DELETE FROM filme WHERE id = ?", novoFilme.getId());

        busca = con.query("SELECT * FROM filme", desenfeiador);
        System.out.println(busca);

    }
}