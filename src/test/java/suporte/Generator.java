package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Generator {

    public static String dataHoraParaArquivo() {
        Timestamp ts = new Timestamp((System.currentTimeMillis()));
        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
    }

    public static String TextoAleatorio(int nCaracteres) {
        Random rand = new Random();
        char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nCaracteres; i++) {
            int ch = rand.nextInt(letras.length);
            sb.append(letras[ch]);
        }
        return sb.toString();
    }

    public static String TextoAleatorioComposto(int nCaracteres){
        return TextoAleatorio(nCaracteres) + " " + TextoAleatorio(nCaracteres);
    }

}
