/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipcpractica1_1s2025;

/**
 *
 * @author astridkim
 */
public class Puntuaciones {
    private String jugador;
    private int puntaje;

    public Puntuaciones (String jugador, int puntaje) {
        this.jugador = jugador;
        this.puntaje = puntaje;
    }

    public String getJugador() {
        return jugador;
    }

    public int getPuntaje() {
        return puntaje;
    }
}


