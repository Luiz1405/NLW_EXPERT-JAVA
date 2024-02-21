package com.LuizKubaszewski.NLW_EXPERT.seed;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CreateSeed {

    private final JdbcTemplate jdbcTemplate;
    private final boolean executeSeed; // Variável para controlar a execução do script SQL

    public CreateSeed(DataSource dataSource, boolean executeSeed) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.executeSeed = executeSeed;
    }

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5434/pg_nlw");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");

        // Defina true se quiser executar o seed ou false para desativar temporariamente
        boolean executeSeed = false;

        CreateSeed createSeed = new CreateSeed(dataSource, executeSeed);
        createSeed.run(args);
    }
 
    public void run(String... args) {
        if (executeSeed) {
            executeSqlFile("C:/NLW EXPERT/NLW/NLW_EXPERT/NLW_EXPERT/src/main/resources/create.sql");
        } else {
            System.out.println("Seed desativado temporariamente.");
        }
    }

    private void executeSqlFile(String filePath) {
        try {
            System.out.println("Lendo o conteúdo do arquivo SQL: " + filePath);

            // Verificando se o arquivo existe
            File file = new File(filePath);
            if (!file.exists()) {
                System.err.println("Arquivo não encontrado: " + filePath);
                return;
            }

            // Verificando permissões de leitura do arquivo
            if (!file.canRead()) {
                System.err.println("O usuário não tem permissão para ler o arquivo: " + filePath);
                return;
            }

            // Lendo o conteúdo do arquivo
            System.out.println("Lendo o conteúdo do arquivo...");
            byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
            String sqlScript = new String(fileContent);
            System.out.println("Conteúdo do script SQL:");
            System.out.println(sqlScript);

            // Executando o script SQL
            System.out.println("Executando o script SQL...");
            jdbcTemplate.execute(sqlScript);

            System.out.println("Seed realizado com sucesso");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + filePath + ": " + e.getMessage());
        } catch (Exception ex) {
            System.err.println("Erro ao executar o script SQL: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
