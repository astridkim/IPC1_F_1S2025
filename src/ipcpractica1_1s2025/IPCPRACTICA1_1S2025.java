/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ipcpractica1_1s2025;

/**
 *
 * @author astridkim
 */
import java.util.Scanner;
public class IPCPRACTICA1_1S2025 {
 // voy a explicar un poco en cada clase el codigo son 5 clases
    private static String nombreCompleto;
    private static String carnet;
    private static String seccion;

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        sopadeletras juego = new sopadeletras();
        // aqui hice el primer swtich para desplazar como la primera lista de opciones 
        int opcion; 
        do {
            System.out.println("\n--- Sopita de Letras ---");
           System.out.println("1. Nueva Partida");
            System.out.println("2. Historial de Partidas");
            System.out.println("3. Mostrar Puntuaciones Más Altas");
            System.out.println("4. Mostrar Información del Estudiante");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    juego.iniciarNuevaPartida();// aqui estoy llamddo a el metodo, que creen en la clase sopadeletras.java
                    nombreCompleto = juego.getNombreCompleto();
                    carnet = juego.getCarnet();
                    seccion = juego.getSeccion();
                    break;
                case 2:
                    juego.mostrarHistorial();
                    break;
                case 3:
                    juego.mostrarPuntuacionesAltas();
                    break;
                case 4:
                    mostrarInformacionEstudiante();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 5);
        
        scanner.close();
    }

    private static void mostrarInformacionEstudiante() {
        System.out.println("Nombre Completo: " + nombreCompleto);
        System.out.println("Carnet: " + carnet);
        System.out.println("Sección: " + seccion);
    }
}
