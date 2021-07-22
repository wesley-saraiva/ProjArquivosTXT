/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author wesle
 */
public class ApachePoi2 {

    public static void main(String[] args) throws IOException {

        FileInputStream entrada = new FileInputStream("C:\\Projetos Netbens\\"
                + "ProjArquivosTXT\\ProjArquivosTXT\\src\\arquivos\\"
                + "arquivo_excel.xls");

        HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(entrada);//Prepara a entrada do arquivo excel para ler
        HSSFSheet planilha = hSSFWorkbook.getSheetAt(0);//Pega a primeira planilha do nosso arquivo excel

        Iterator<Row> linhaIterator = planilha.iterator();

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        while (linhaIterator.hasNext()) {//Enquanto tiver linha no arquivo excel
            Row linha = linhaIterator.next();//Dados da pessoa na linha

            Iterator<Cell> celulas = linha.iterator();

            Pessoa pessoa = new Pessoa();

            while (celulas.hasNext()) {//Percorrer as celulas
                Cell cell = celulas.next();

                switch (cell.getColumnIndex()) {
                    case 0:
                        pessoa.setNome(cell.getStringCellValue());
                        break;
                    case 1:
                        pessoa.setEmail(cell.getStringCellValue());
                        break;
                    case 2:
                        pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
                        break;
                    default:
                        break;
                }
            }//Fim das celulas da linha
            pessoas.add(pessoa);
        }

        entrada.close();//terminou de ler o arquivo excel
        for (Pessoa p : pessoas) {//Poderia gravar no banco de dados  
            System.out.println(p);
        }

    }
}
