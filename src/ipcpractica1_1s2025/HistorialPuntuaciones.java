/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipcpractica1_1s2025;

/**
 *
 * @author astridkim
 */
public class HistorialPuntuaciones {
    private Puntuaciones[] puntuaciones;
    private int numPuntuaciones;

    public HistorialPuntuaciones() {
        this.puntuaciones = new Puntuaciones[100]; 
        this.numPuntuaciones = 0;
    }

    public void agregarPuntuacion(String jugador, int puntaje) {
        if (numPuntuaciones < puntuaciones.length) {
            puntuaciones[numPuntuaciones++] = new Puntuaciones(jugador, puntaje);
            ordenarPuntuaciones();
            System.out.println(" Puntuación agregada: " + jugador + " - " + puntaje + " puntos.");
        } else {
            System.out.println("No se pueden agregar más puntuaciones.");
        }
    }

    private void ordenarPuntuaciones() {
        for (int i = 0; i < numPuntuaciones - 1; i++) {
            for (int j = 0; j < numPuntuaciones - 1 - i; j++) {
                if (puntuaciones[j].getPuntaje() < puntuaciones[j + 1].getPuntaje()) {
                    Puntuaciones temp = puntuaciones[j];
                    puntuaciones[j] = puntuaciones[j + 1];
                    puntuaciones[j + 1] = temp;
                }
            }
        }
    }

    public void mostrarHistorial() {
        if (numPuntuaciones == 0) {
            System.out.println("No hay puntuaciones registradas.");
            return;
        }

        System.out.println("\n Historial de Puntuaciones:");
        for (int i = 0; i < numPuntuaciones; i++) {
            System.out.println(puntuaciones[i].getJugador() + ": " + puntuaciones[i].getPuntaje() + " puntos");
        }
    }

    public void mostrarPuntuacionesAltas() {
        if (numPuntuaciones == 0) {
            System.out.println(" No hay puntuaciones registradas.");
            return;
        }

        System.out.println("\n Puntuaciones Más Altas:");
        int limite = Math.min(3, numPuntuaciones);
        for (int i = 0; i < limite; i++) {
            System.out.println((i + 1) + ". " + puntuaciones[i].getJugador() + ": " + puntuaciones[i].getPuntaje() + " puntos");
        }
    }
}