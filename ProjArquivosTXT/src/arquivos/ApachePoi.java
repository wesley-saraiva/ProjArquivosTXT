/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author wesle
 */
public class ApachePoi {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Projetos Netbens\\ProjArquivosTXT\\"
                + "ProjArquivosTXT\\src\\arquivos\\arquivo_excel.xls");

        if (!file.exists()) {
            file.createNewFile();
        }

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
        
        HSSFWorkbook hSSFWorkbook = new HSSFWorkbook();//vai ser usado para escrever a planilha
        HSSFSheet linhasPessoas = hSSFWorkbook.createSheet("Planilha de pessoas");//cria a planilha
        
        int numeroLinha =0;
        
        for (Pessoa p : pessoas) {
            Row linha = linhasPessoas.createRow(numeroLinha++);//Criando a linha da planilha
            
            int celula =0;
            
            Cell cellNome = linha.createCell(celula++);//Celula 1
            cellNome.setCellValue(p.getNome());
            
            Cell cellEmail = linha.createCell(celula++);//Celula 2
            cellEmail.setCellValue(p.getEmail());
            
            Cell cellIdade = linha.createCell(celula ++); //Celula 3
            cellIdade.setCellValue(p.getIdade());
        }
        
        FileOutputStream saida = new FileOutputStream(file);
        hSSFWorkbook.write(saida);//Escreve planilha em arquivo
        saida.flush();
        saida.close();
        
        System.out.println("Planilha foi criada");
    }
}
