/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipcpractica1_1s2025;

/**
 *
 * @author astridkim
 */  
import java.util.Random;

public class Tablero {
    private char[][] matriz;
    private int tamaño;
    private Random random = new Random();

    public Tablero(int tamaño) {
        this.tamaño = tamaño;
        this.matriz = new char[tamaño][tamaño];
        inicializarTablero();
    }

    // Inicializa el tablero con espacios vacíos
    private void inicializarTablero() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                matriz[i][j] = ' '; // Inicialmente vacío porque necesitmos que el estudiante vea el tamaño de el tablero
            }
        }
    }

    // Coloca una palabra en una posición aleatoria
    public boolean colocarPalabra(String palabra) {
        int intentos = 0;
        while (intentos < 25) { // Intentar 100 veces antes de rendirse
            boolean horizontal = random.nextBoolean();
            int fila, columna;

            if (horizontal) {
                fila = random.nextInt(tamaño);
                columna = random.nextInt(tamaño - palabra.length());
            } else {
                fila = random.nextInt(tamaño - palabra.length());
                columna = random.nextInt(tamaño);
            }

            // Verificar si hay espacio
            boolean espacioDisponible = true;
            for (int i = 0; i < palabra.length(); i++) {
                if (horizontal && matriz[fila][columna + i] != ' ') espacioDisponible = false;
                if (!horizontal && matriz[fila + i][columna] != ' ') espacioDisponible = false;
            }

            if (espacioDisponible) {
                // Insertar palabra
                for (int i = 0; i < palabra.length(); i++) {
                    if (horizontal) {
                        matriz[fila][columna + i] = palabra.charAt(i);
                    } else {
                        matriz[fila + i][columna] = palabra.charAt(i);
                    }
                }
                return true;
            }

            intentos++;
        }
        return false; // No se pudo colocar la palabra
    }

    // Llena los espacios vacíos con letras aleatorias, ya que nosotros tenemos las letras de nuestras palabras asi que se agregan letras faltantes
    public void llenarEspaciosVacios() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (matriz[i][j] == ' ') {
                    matriz[i][j] = (char) ('A' + random.nextInt(26)); // Letra aleatoria A-Z
                }
            }
        }
    }

    // Sustituye una palabra encontrada con '#'
    public void sustituirPalabra(String palabra) {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (buscarYReemplazar(i, j, palabra, true) || buscarYReemplazar(i, j, palabra, false)) {
                    return;
                }
            }
        }
    }

    // Busca y reemplaza una palabra en la matriz
    private boolean buscarYReemplazar(int fila, int columna, String palabra, boolean horizontal) {
        int longitud = palabra.length();
        if (horizontal) {
            if (columna + longitud > tamaño) return false;
            for (int i = 0; i < longitud; i++) {
                if (matriz[fila][columna + i] != palabra.charAt(i)) return false;
            }
            for (int i = 0; i < longitud; i++) {
                matriz[fila][columna + i] = '#';
            }
        } else {
            if (fila + longitud > tamaño) return false;
            for (int i = 0; i < longitud; i++) {
                if (matriz[fila + i][columna] != palabra.charAt(i)) return false;
            }
            for (int i = 0; i < longitud; i++) {
                matriz[fila + i][columna] = '#';
            }
        }
        return true;
    }

    // Imprime el tablero con separadores "|"
    public void mostrarTablero() {
        for (int i = 0; i < tamaño; i++) {
            System.out.print("| ");
            for (int j = 0; j < tamaño; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
    }

}
