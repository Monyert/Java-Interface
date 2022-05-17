package sopa_letras;

/**
 *
 * @Monyert
 */
import java.util.ArrayList;

import java.util.List;

public class SopaBLL {

    DAO datos = new DAO();
    char[][] matriz_BLL = datos.matriz_letras;
    String diccionario_BLL = datos.solucion_lista;
    String ventana_res = "";
    String ventana_dic = "";

    public SopaBLL() {

        String[] palabras = diccionario_BLL.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            Solucionar(palabras[i]);
        }
    }

    public void Solucionar(String encontrado) {

        for (int[] pos : Buscador(encontrado)) {
            String linea;

            linea = palabraEnMatriz(pos, encontrado.length(), 0, 1);
            if (linea.contains(encontrado)) {
                ventana_res += encontrado + " ";
            }

            linea = palabraEnMatriz(pos, encontrado.length(), 0, -1);
            if (linea.contains(encontrado)) {
                ventana_res += encontrado + " ";
            }

            linea = palabraEnMatriz(pos, encontrado.length(), 1, 0);
            if (linea.contains(encontrado)) {
                ventana_res += encontrado + " ";
            }

            linea = palabraEnMatriz(pos, encontrado.length(), -1, 0);
            if (linea.contains(encontrado)) {
                ventana_res += encontrado + " ";
            }

            linea = palabraEnMatriz(pos, encontrado.length(), -1, 1);
            if (linea.contains(encontrado)) {
                ventana_res += encontrado + " ";
            }

            linea = palabraEnMatriz(pos, encontrado.length(), -1, -1);
            if (linea.contains(encontrado)) {
                ventana_res += encontrado + " ";
            }

            linea = palabraEnMatriz(pos, encontrado.length(), 1, 1);
            if (linea.contains(encontrado)) {
                ventana_res += encontrado + " ";
            }

            linea = palabraEnMatriz(pos, encontrado.length(), 1, -1);
            if (linea.contains(encontrado)) {
                ventana_res += encontrado + " ";
            }
        }

    }

    public DAO getDAO() {
        return datos;
    }

    public String getSolucion() {
        return ventana_res;
    }

    public String getDiccionario() {
        return ventana_dic;
    }

    public int[][] Buscador(String linea) {
        char letra = linea.charAt(0);
        List<int[]> index = new ArrayList<>();

        for (int i = 0; i < matriz_BLL.length; i++) {
            for (int j = 0; j < matriz_BLL[i].length; j++) {
                if (matriz_BLL[i][j] == letra) {
                    index.add(new int[]{i, j});
                }
            }
        }
        if (index.size() > 0) {
            return Reverse(index);
        } else {
            index.add(new int[]{0, 0});
        }
        return Reverse(index);
    }

    private int[][] Reverse(List<int[]> list) {
        return (int[][]) list.toArray(new int[list.size()][list.get(0).length]);
    }

    public String palabraEnMatriz(int[] ini, int num, int fil, int col) {
        String palabra = "";
        int bucle = 0, fila = ini[0], columna = ini[1];

        while ((bucle < num)
                && (fila < matriz_BLL.length && columna < matriz_BLL.length)
                && (fila > -1 && columna > -1)) {

            palabra += matriz_BLL[fila][columna];
            fila = fila + fil;
            columna = columna + col;
            bucle++;
        }

        return palabra;
    }

}
