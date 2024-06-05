package br.com.luds.Luds;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.OrientationRequested;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class PrintTest {

    public static void main(String[] args) {
        try {
            String text = "Este é um teste de impressão em uma impressora térmica. \n\n\n\n\n\n\n\n\n";

            InputStream is = new ByteArrayInputStream(text.getBytes("UTF8"));

            // Procurar impressoras disponíveis
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            pras.add(new Copies(1));
            pras.add(OrientationRequested.PORTRAIT);

            PrintService printService[] = PrintServiceLookup.lookupPrintServices(null, null);
            if (printService.length == 0) {
                System.err.println("No printer found");
                return;
            }

            PrintService service = printService[5];

            DocPrintJob job = service.createPrintJob();
            Doc doc = new SimpleDoc(is, flavor, null);

            // Enviar o trabalho de impressão
            job.print(doc, pras);

            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
