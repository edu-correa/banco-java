package org.example;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Connection {
    private JdbcTemplate conexaoBanco;

    public Connection(){
        // Necessário
        BasicDataSource banco = new BasicDataSource();
        // Driver onde o banco está
        banco.setDriverClassName("org.h2.Driver");
        // caminho do banco local (obs: se não existir será criado) e essa forma aqui é pra teste
        banco.setUrl("jdbc:h2:file:./teste_banco");
        //Username
        banco.setUsername("sa");
        //Senha duurrr
        banco.setPassword("");
        conexaoBanco = new JdbcTemplate(banco);
    }
    public JdbcTemplate getConexaoBanco(){
        return conexaoBanco;
    }
}
