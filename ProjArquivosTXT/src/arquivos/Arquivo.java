/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wesle
 */
public class Arquivo {

    public static void main(String[] args) throws IOException {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Wesley");
        pessoa1.setEmail("wesleysaraiva109@gmail.com");
        pessoa1.setIdade(25);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Jose");
        pessoa2.setEmail("jose@gmail.com");
        pessoa2.setIdade(23);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Pedro");
        pessoa3.setEmail("pedro@gmail.com");
        pessoa3.setIdade(20);

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        File arquivo = new File("C:\\Projetos Netbens\\ProjArquivosTXT\\"
                + "ProjArquivosTXT\\src\\arquivos\\arquivo.csv");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        FileWriter escrever_no_arquivo = new FileWriter(arquivo);

        /*for (int i = 1; i <= 10; i++) {
            escrever_no_arquivo.write("Meu texto na linha: " + i + "\n");
        }*/
        for (Pessoa p : pessoas) {
            escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";"
                    + p.getIdade() + "\n");
        }

        escrever_no_arquivo.flush();
        escrever_no_arquivo.close();

    }
}
