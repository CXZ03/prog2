/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller2;

import java.io.Serializable;

/**
 * Clase que representa un jugador.
 *
 * @author cxz03
 */
public class Jugador implements Serializable {

    public static final Jugador CENTINELA = new Jugador("", null, -1);

    private String nombre;
    private Equipo equipo;
    private int cantidadTrofeos;

    /**
     * Constructor que inicializa los atributos nombre, equipo y cantidadTrofeos
     * del jugador.
     *
     * @param nombre El nombre del jugador.
     * @param equipo El equipo que pertenece el jugador.
     * @param cantidadTrofeos La cantidad de trofeos que tiene el jugador.
     */
    public Jugador(String nombre, Equipo equipo, int cantidadTrofeos) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.cantidadTrofeos = cantidadTrofeos;
    }

    /**
     * Getter del atributo nombre.
     *
     * @return El nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter del atributo equipo.
     *
     * @return El equipo que pertenece el jugador.
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Getter del atributo cantidadTrofeos.
     *
     * @return La cantidad de trofeos que tiene el jugador.
     */
    public int getCantidadTrofeos() {
        return cantidadTrofeos;
    }

    /** 
     * Comprobar si es igual a CENTINELA.
     * 
     * @return true si es igual, false si no. 
     */
    public boolean esCentinela() {
        boolean mismoNombre = (nombre == null && CENTINELA.getNombre() == null)
                || (nombre != null && nombre.equals(CENTINELA.getNombre()));

        boolean mismoEquipo = (equipo == null && CENTINELA.getEquipo() == null)
                || (equipo != null && equipo.equals(CENTINELA.getEquipo()));

        boolean mismaCantidad = (cantidadTrofeos == CENTINELA.cantidadTrofeos);

        return mismoNombre && mismoEquipo && mismaCantidad;
    }

    /**
     * Print de los atributos.
     */
    public void imprimir() {
        System.out.println("nombre: " + nombre);
        System.out.println("equipo: " + equipo.toString());
        System.out.println("cantidad trofeos: " + cantidadTrofeos);
    }
}
