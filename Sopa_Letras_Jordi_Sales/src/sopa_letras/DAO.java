package sopa_letras;

/**
 *
 * @Monyert
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.swing.JPanel;



public class DAO extends JPanel {

    int TAM = 6;
    char[][] matriz_letras = new char[TAM][TAM];
    String sopa_letras = "";
    String solucion_lista = "";

    Path ruta_ab = FileSystems.getDefault().getPath("").toAbsolutePath();
    String separador = System.getProperty("file.separator");

    String rutaSopa = ruta_ab + separador + "sopa_letras.txt";
    String rutaDiccionario = ruta_ab + separador + "sopa_letras_solucio.txt";

    public DAO() {
        try {
            String line;
            String res = "";

            BufferedReader br = null;
            BufferedReader br2 = null;
            try {
                br = new BufferedReader(new FileReader(rutaSopa));
                br2 = new BufferedReader(new FileReader(rutaDiccionario));

                while ((line = br.readLine()) != null) {
                    res = res + line;
                }

            } catch (FileNotFoundException ex) {
                System.out.println("Error en la lectura del archivo.");
            }

            while ((line = br2.readLine()) != null) {
                solucion_lista = solucion_lista + line + " ";
            }

            for (int i = 0; i < matriz_letras.length; i++) {
                for (int j = 0; j < matriz_letras.length; j++) {
                    int valor = (i * TAM) + j;
                    matriz_letras[i][j] = res.charAt(valor);
                }
            }

            for (int i = 0; i < 36; i++) {
                sopa_letras += res.charAt(i) + "          ";
                if ((i > 0) && ((i + 1) % 6 == 0) && (i < 35)) {
                    sopa_letras += "\n\n";
                }
            }

        } catch (IOException ex) {
            System.out.println("Error de Lectura.");
        }

    }

    public String getVentana1() {
        return solucion_lista;
    }

    public String getLetras() {
        return sopa_letras;
    }

    public char[][] getSopa() {
        return matriz_letras;
    }

}
