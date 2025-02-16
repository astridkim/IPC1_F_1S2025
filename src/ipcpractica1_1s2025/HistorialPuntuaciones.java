/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipcpractica1_1s2025;

/**
 *
 * @author astridkim
 */
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class HistorialPuntuaciones {
    private ArrayList<Puntuaciones> puntuaciones;

    public HistorialPuntuaciones() {
        this.puntuaciones = new ArrayList<>();
    }

    public void agregarPuntuacion(String jugador, int puntaje) {
        puntuaciones.add(new Puntuaciones(jugador, puntaje));
        Collections.sort(puntuaciones, Comparator.comparingInt(Puntuaciones::getPuntaje).reversed()); 
        System.out.println("🏆 Puntuación agregada: " + jugador + " - " + puntaje + " puntos.");
    }

    public void mostrarHistorial() {
        if (puntuaciones.isEmpty()) {
            System.out.println(" No hay puntuaciones registradas.");
            return;
        }

        System.out.println("\n Historial de Puntuaciones:");
        for (Puntuaciones p : puntuaciones) {
            System.out.println(p.getJugador() + ": " + p.getPuntaje() + " puntos");
        }
    }

    public void mostrarPuntuacionesAltas() {
        if (puntuaciones.isEmpty()) {
            System.out.println(" No hay puntuaciones registradas.");
            return;
        }

        System.out.println("\n Puntuaciones Más Altas:");
        int limite = Math.min(3, puntuaciones.size());
        for (int i = 0; i < limite; i++) {
            Puntuaciones p = puntuaciones.get(i);
            System.out.println((i + 1) + ". " + p.getJugador() + ": " + p.getPuntaje() + " puntos");
        }
    }
}

