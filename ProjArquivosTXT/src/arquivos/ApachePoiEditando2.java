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
public class ApachePoiEditando2 {

    public static void main(String[] args) throws IOException {

         File file = new File("C:\\Projetos Netbens\\ProjArquivosTXT\\"
                + "ProjArquivosTXT\\src\\arquivos\\arquivo_excel.xls");
        
        FileInputStream entrada = new FileInputStream(file);
        
        HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(entrada);//Prepara a entrada doa rquivo xls excel
        HSSFSheet planilha = hSSFWorkbook.getSheetAt(0);//Pegando a planilha
        
        Iterator<Row> linhaIterator = planilha.iterator();
        
        while (linhaIterator.hasNext()) {//Enquanto tiver linha
            Row linha = linhaIterator.next();//Dados da pessoa na linha
            
            int numeroCelulas = linha.getPhysicalNumberOfCells();//Quantidade de celulas
            
            String valorCelula = linha.getCell(0).getStringCellValue();
            
            linha.getCell(0).setCellValue(valorCelula+" * valor gravado na aula");
            
        }
        entrada.close();
        
        FileOutputStream saida = new FileOutputStream(file);
        hSSFWorkbook.write(saida);
        saida.flush();
        saida.close();
        
        System.out.println("Planilha atulizada");

    }
}
