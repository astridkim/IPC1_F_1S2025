/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipcpractica1_1s2025;

/**
 *
 * @author astridkim
 * 
 */
import java.util.Scanner;

public class sopadeletras {
//aqui vamos a declarar las variables que vamos a usar en ests clase
    private Scanner scanner;
    private String[] palabras;
    private int tamañoTablero;
    private int minLongitud;
    private int maxLongitud;
    private Tablero tablero;
    private HistorialPuntuaciones historial;
    private String nombreCompleto;
    private String carnet;
    private String seccion;
    private int numPalabras;

    public sopadeletras() {
        this.palabras = new String[100]; 
        this.numPalabras = 0;
        this.scanner = new Scanner(System.in);
        this.historial = new HistorialPuntuaciones(); 
    }

    public void iniciarNuevaPartida() {
        System.out.print("Ingrese su nombre completo: ");
        nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese su carnet: "); //aqui nos pide el nombre carnet y seccion que en la otra clase de IPCPRACTICA usamos 
        carnet = scanner.nextLine();
        System.out.print("Ingrese su sección: ");
        seccion = scanner.nextLine();

        System.out.println("\nSeleccione una sección de la letra A a la G:");
        System.out.println("A. El tablero será de (17x17)");
        System.out.println("B. El tablero será de  (15x15)");
        System.out.println("C. El tablero será de (20x20)");
        System.out.println("D. El tablero será de (25x25)");// aqui solo pedimos que letra queremos o sea que longitud segun la tabla
        System.out.println("E. El tablero será de  (14x14)");
        System.out.println("F. El tablero será de (18x18)");
        System.out.println("G. El tablero será de (16x16)");

        char seccionTablero = scanner.next().toUpperCase().charAt(0);

        switch (seccionTablero) {
            case 'A': tamañoTablero = 17; minLongitud = 4; maxLongitud = 10; break;
            case 'B': tamañoTablero = 15; minLongitud = 3; maxLongitud = 8; break;
            case 'C': tamañoTablero = 20; minLongitud = 5; maxLongitud = 12; break;
            case 'D': tamañoTablero = 25; minLongitud = 6; maxLongitud = 15; break;
            case 'E': tamañoTablero = 14; minLongitud = 5; maxLongitud = 10; break;
            case 'F': tamañoTablero = 18; minLongitud = 4; maxLongitud = 12; break;
            case 'G': tamañoTablero = 16; minLongitud = 6; maxLongitud = 10; break;
            default:
                System.out.println("Incorrecto. Seleccionando A por defecto.");
                tamañoTablero = 17; minLongitud = 4; maxLongitud = 10;
                break;
        }

        System.out.println("\n Bienvenido 🫶🏻🫶, " + nombreCompleto + "!");
        System.out.println(" Has seleccionado la sección " + seccionTablero +
                ". Tamaño del tablero: " + tamañoTablero + "x" + tamañoTablero +
                ". Palabras entre " + minLongitud + " y " + maxLongitud + " caracteres.");
//  aqui solo  le estamos dando a conocer al usuario que ha sido su eleccion el tamaño de su tabla
        tablero = new Tablero(tamañoTablero);
        tablero.mostrarTablero();

        //esta es la segunda lista que nos aparece despues de la primera en IPCPRACTICA
        int opcionNuevaPartida;
        do {
            System.out.println("\n--- Menú Nueva Partida ---");
            System.out.println("1. Insertar, modificar o mostrar palabras");
            System.out.println("2. Jugar");
            System.out.println("3. Regresar al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcionNuevaPartida = scanner.nextInt();

            switch (opcionNuevaPartida) {
                case 1:
                    menuPalabras();
                    break;
                case 2:
                    jugar(nombreCompleto);
                    break;
                case 3:
                    System.out.println("Regresando al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcionNuevaPartida != 3);
    }

    private void menuPalabras() {
        int subOpcion;
        do {
            System.out.println("\n--- Menú Palabras ---");
            System.out.println("1. Insertar Palabras");
            System.out.println("2. Modificar");// esta es como al tercera lista de opciones que nos va a aparecer
            System.out.println("3. Mostrar Palabras");
            System.out.println("4. Salir ");
            System.out.print("Seleccione una opción: ");
            subOpcion = scanner.nextInt();

            switch (subOpcion) {
                case 1:
                    insertarPalabras();
                    return; // Volver al Menú Nueva Partida después de insertar palabras
                case 2:
                    modificarPalabra();
                    break;
                case 3:
                    mostrarPalabras();
                    break;
                case 4:
                    System.out.println("Saliendo del Menú Palabras...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (subOpcion != 4);
    }

    private void insertarPalabras() {
        System.out.print("Ingrese el número de palabras: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        for (int i = 0; i < cantidad; i++) {
            boolean palabraValida = false;
            while (!palabraValida) {
                System.out.print("Ingrese palabra: ");
                String palabra = scanner.nextLine();

                if (palabra.length() >= minLongitud && palabra.length() <= maxLongitud) {
                    palabras[numPalabras++] = palabra;
                    palabraValida = true;
                } else {
                    System.out.println(" Error: La palabra debe tener entre " + minLongitud + " y " + maxLongitud + " caracteres.");
                }
            }
        }

        System.out.println("\nPalabras ingresadas correctamente.");
    }


    private void mostrarPalabras() {
        System.out.print("Palabras en el banco: ");
        for (int i = 0; i < numPalabras; i++) {
            System.out.print(palabras[i] + " ");
        }
        System.out.println();
    }

    private void jugar(String nombreJugador) {
        if (numPalabras == 0) {
            System.out.println("No hay palabras para jugar. Agregue palabras primero.");
            return;
        }

        for (int i = 0; i < numPalabras; i++) {
            tablero.colocarPalabra(palabras[i]);
        }

        // solo vamos a llenar los espacios vacíos con letras aleatorias
        tablero.llenarEspaciosVacios();
        System.out.println("\n🔠 Tablero con letras aleatorias:");
        tablero.mostrarTablero();

        int palabrasEncontradas = 0;
        int puntos = 25; // Puntos iniciales que segun la practica nos esta pidiendo


        if (palabrasEncontradas == numPalabras) {
            System.out.println(" ¡Felicidades inge, usted ha encontrado todas las palabras!");
        } else {
            System.out.println(" Has perdido todas tus oportunidades. Fin del juego.");
        }

        historial.agregarPuntuacion(nombreJugador, puntos);
    }

    public void mostrarHistorial() {
        historial.mostrarHistorial();
    }

    public void mostrarPuntuacionesAltas() {
        historial.mostrarPuntuacionesAltas();
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }// aqui en estos 3 metodos vamos a pedir el nombre carnet y seccion 

    public String getCarnet() {
        return carnet;
    }

    public String getSeccion() {
        return seccion;
    }
}