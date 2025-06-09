/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cxz03
 */
public class Emulador {

    private static final int MAX_JUGADOR = 200;
    private static final int MAX_NOMBRE_JUGADOR = 510;
    private static final int MAX_TROFEO = 100;
    private static final String RUTA_FICHERO_TODOS = "src/ficheros/JUGADORES.dat";
    private static final String RUTA_FICHERO_NOMBRE = "src/ficheros/NOMBRE.dat";
    private static final String RUTA_FICHERO_BASTONES = "src/ficheros/BASTONES.dat";
    private static final String RUTA_FICHERO_COPAS = "src/ficheros/COPAS.dat";
    private static final String RUTA_FICHERO_ESPADAS = "src/ficheros/ESPADAS.dat";
    private static final String RUTA_FICHERO_OROS = "src/ficheros/OROS.dat";

    /**
     * Bucle principal donde está el principal flujo y logica del programa.
     */
    public void buclePrincipal() {
        // Declaramos las variables y objetos requeridos
        boolean programaFinalizado = false;
        Scanner lectorTerminal = new Scanner(System.in);
        int opcionUsuario;

        while (!programaFinalizado) {
            // Imprimimos las opciones disponibles
            System.out.println("1. Introducir aleatoriamente datos de jugador.");
            System.out.println("2. Mostrar los datos del fichero de jugador.");
            System.out.println("3. Mostrar las estaristicas del fichero de jugador.");
            System.out.println("4. Separar los jugadores en equipo.");
            System.out.println("5. Mostrar los datos de los ficheros de equipos.");
            System.out.println("6. Mostrar los estaristicas de los ficheros de equipos.");
            System.out.println("7. Salir.");
            System.out.println("");

            // Leemos la opción que ha elegido el usuario.
            try {
                opcionUsuario = lectorTerminal.nextInt();
            } catch (InputMismatchException e) {
                // Limpiar el buffer, si no todo el rato Scanner devuelve el caracter incorrecto
                lectorTerminal.nextLine();

                // Si el usuario no introduce un número irá al default del switch
                opcionUsuario = Integer.MAX_VALUE;
            }

            // Ejecutamos la elección del usuario
            switch (opcionUsuario) {
                case 1 -> {
                    introducirJugadores();
                }
                case 2 -> {
                    mostrarJugadores(RUTA_FICHERO_TODOS);
                    System.out.println("");
                }
                case 3 -> {
                    mostrarEstaristicaJugadores(RUTA_FICHERO_TODOS);
                    System.out.println("");
                }
                case 4 -> {
                    filtrarJugadores(RUTA_FICHERO_TODOS);
                }
                case 5 -> {
                    System.out.println("EQUIPO BASTONES: ");
                    mostrarJugadores(RUTA_FICHERO_BASTONES);
                    System.out.println("");
                    System.out.println("EQUIPO COPAS: ");
                    mostrarJugadores(RUTA_FICHERO_COPAS);
                    System.out.println("");
                    System.out.println("EQUIPO ESPADAS: ");
                    mostrarJugadores(RUTA_FICHERO_ESPADAS);
                    System.out.println("");
                    System.out.println("EQUIPO OROS: ");
                    mostrarJugadores(RUTA_FICHERO_OROS);
                    System.out.println("");

                }
                case 6 -> {
                    System.out.println("EQUIPO BASTONES: ");
                    mostrarEstaristicaJugadores(RUTA_FICHERO_BASTONES);
                    System.out.println("");
                    System.out.println("EQUIPO COPAS: ");
                    mostrarEstaristicaJugadores(RUTA_FICHERO_COPAS);
                    System.out.println("");
                    System.out.println("EQUIPO ESPADAS: ");
                    mostrarEstaristicaJugadores(RUTA_FICHERO_ESPADAS);
                    System.out.println("");
                    System.out.println("EQUIPO OROS: ");
                    mostrarEstaristicaJugadores(RUTA_FICHERO_OROS);
                    System.out.println("");
                }
                case 7 -> {
                    programaFinalizado = true;
                }
                default -> {
                    // Opción no implementada, avisar que el usuario introduzca de nuevo
                    System.out.println("Opción no válida, introzca de nuevo.");
                }
            }
        }

        // Fin del programa
        System.out.println("¡Hasta la próxima!");
    }

    /**
     * Método donde introducimos aleatoriamente los datos de los jugadores
     * teniendo como máximo MAX_JUGADOR en el fichero NOMBRE_FICHERO_TODOS.
     */
    private void introducirJugadores() {
        // Obtenemos la lista de nombres
        String nombreJugadores[] = null;
        try {
            nombreJugadores = new FicheroLecturaNombreJugador(RUTA_FICHERO_NOMBRE).leerNombresJugador(MAX_NOMBRE_JUGADOR);
        } catch (FileNotFoundException ex) {
            System.err.println("No se ha encontrado el fichero de nombres.");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        // Inicializar el fichero de escritura sobreescribiendo el contenido previo.
        FicheroEscrituraJugador escritorFicheroJugador = null;
        try {
            escritorFicheroJugador = new FicheroEscrituraJugador(RUTA_FICHERO_TODOS, false);

            // Generar la cantidad aleatorio de jugadores a introducir
            Random generadorAleatorio = new Random();
            int cantidadJugadoresAIntroducir = generadorAleatorio.nextInt(MAX_JUGADOR);
            for (int i = 0; i < cantidadJugadoresAIntroducir; i++) {
                escritorFicheroJugador.escribirJugador(new Jugador(
                        nombreJugadores[generadorAleatorio.nextInt(nombreJugadores.length)], // nombre random
                        Equipo.values()[generadorAleatorio.nextInt(Equipo.values().length)], // equipo random
                        generadorAleatorio.nextInt(MAX_TROFEO) // trofeos random
                ));

            }

            // Ponemos un jugador centinela para indicar el fin del fichero
            escritorFicheroJugador.escribirJugador(Jugador.CENTINELA);

            // Cerramos el fichero de jugadores
            escritorFicheroJugador.cerrar();
        } catch (IOException ex) {
            System.err.println("Error a la hora de escribir en el fichero jugador.");
        } finally {
            try {
                escritorFicheroJugador.cerrar();
            } catch (IOException ex) {
                System.err.println("Error a la hora de cerrar en el fichero jugador.");
            }
        }
    }

    /**
     * Se puestra todos los jugadores que hay en el fichero.
     *
     * @param rutaFicheroJugador
     */
    private void mostrarJugadores(String rutaFicheroJugador) {
        FicheroLecturaJugador lectorFicheroJugador = null;
        try {
            // Leemos e imprimimos todos los jugadores que hay en el fichero
            lectorFicheroJugador = new FicheroLecturaJugador(rutaFicheroJugador);
            Jugador jugadorLeidoActual = lectorFicheroJugador.leerJugador();
            while (!jugadorLeidoActual.esCentinela()) {
                jugadorLeidoActual.imprimir();
                System.out.println("");  // separar los jugadores

                // Leemos el siguiente jugador
                jugadorLeidoActual = lectorFicheroJugador.leerJugador();
            }

        } catch (ClassNotFoundException ex) {
            System.err.println("Error: no se ha encontrado la clase Jugador.");
        } catch (EOFException ex) {
            System.err.println("Error: ha llegado al final del fichero.");
        } catch (IOException ex) {
            System.err.println("Error: ha habido un problema de IO.");
        } finally {
            try {
                // Cerramos el lector de fichero
                lectorFicheroJugador.cerrar();
            } catch (IOException ex) {
                Logger.getLogger(Emulador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Se muestra los datos del fichero y las estaristicas de los jugadores.
     *
     * @param rutaFicheroJugador
     */
    private void mostrarEstaristicaJugadores(String rutaFicheroJugador) {
        // Declaramos una variable para almacenar cada datos que nos interesa
        String nombreFichero = null;
        String nombreObjetos = null;
        int sumatorioTrofeos = 0;
        double mediaAritmeticaTrofeos;
        double desviacionEstandardTrofeos = 0;
        Jugador[] top3Jugadores = new Jugador[3];

        // array de apoyo para guardar los trofeos de cada jugador
        int cantidadTrofeoPorJugador[] = new int[MAX_JUGADOR];
        int numeroJugador = 0;

        // Declaramos el lector para leer el fichero
        FicheroLecturaJugador lectorFicheroJugador = null;
        try {
            // Asignamos el lector de fichero
            lectorFicheroJugador = new FicheroLecturaJugador(rutaFicheroJugador);

            // Obtenemos el nombre del fichero
            nombreFichero = lectorFicheroJugador.getNombreFichero();

            // Leemos el primer jugador del fichero
            Jugador jugadorLeidoActual = lectorFicheroJugador.leerJugador();

            // Guardamos el nombre del objeto leido
            nombreObjetos = jugadorLeidoActual.getClass().getName();

            // Iteramos y actualizamos los datos
            while (!jugadorLeidoActual.esCentinela()) {
                // Guardamos el trofeo y lo sumamos al total
                cantidadTrofeoPorJugador[numeroJugador++] = jugadorLeidoActual.getCantidadTrofeos();
                sumatorioTrofeos += jugadorLeidoActual.getCantidadTrofeos();

                // Actualizamos el ranking
                actualizarTop(top3Jugadores, jugadorLeidoActual);

                // Leemos el siguiente jugador
                jugadorLeidoActual = lectorFicheroJugador.leerJugador();
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Error: no se ha encontrado la clase Jugador.");
        } catch (EOFException ex) {
            System.err.println("Error: ha llegado al final del fichero.");
        } catch (IOException ex) {
            System.err.println("Error: ha habido un problema de IO.");
        } finally {
            try {
                // Cerramos el lector de fichero
                lectorFicheroJugador.cerrar();
            } catch (IOException ex) {
                Logger.getLogger(Emulador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Calculamos la media aritmetica
        mediaAritmeticaTrofeos = (double) sumatorioTrofeos / numeroJugador;

        // Calculamos la desviacion estandard
        for (int i = 0; i < numeroJugador; i++) {
            desviacionEstandardTrofeos += Math.pow((double) (cantidadTrofeoPorJugador[i] - mediaAritmeticaTrofeos), 2);
        }
        desviacionEstandardTrofeos /= numeroJugador;
        desviacionEstandardTrofeos = Math.sqrt(desviacionEstandardTrofeos);

        // Mostramos los datos obtenidos
        System.out.println("a) nombre fichero: " + nombreFichero);
        System.out.println("b) nombre del objeto: " + nombreObjetos);
        System.out.println("c) sumatorio de los trofeos: " + sumatorioTrofeos);
        System.out.println("d) media aritmetica de los trofeos: " + mediaAritmeticaTrofeos);
        System.out.println("e) desviacion estandard de los trofeos: " + desviacionEstandardTrofeos);
        System.out.println("f) top 3 jugadores:");
        for (int i = 0; i < top3Jugadores.length; i++) {
            System.out.println("top " + (i + 1) + ":");
            if (top3Jugadores[i] != null) {
                top3Jugadores[i].imprimir();
            }

        }
    }

    /**
     * Actualiza una lista de top jugadores pasando el jugador que se quiere
     * incorporar.
     *
     * @param top
     * @param jugadorActual
     */
    private void actualizarTop(Jugador[] top, Jugador jugadorActual) {
        // Hacemos una copia del jugador para no tener problemas con referencias
        Jugador copiaJugador = new Jugador(
                jugadorActual.getNombre(),
                jugadorActual.getEquipo(),
                jugadorActual.getCantidadTrofeos()
        );

        // Miramos si el jugador puede entrara en el top 3 actual
        for (int i = 0; i < top.length; i++) {
            // Si la posicion esta vacia lo insertamos directamente
            if (top[i] == null) {
                top[i] = copiaJugador;
                return;
            } // Si el jugador actual tiene mas trofeos
            else if (copiaJugador.getCantidadTrofeos() > top[i].getCantidadTrofeos()) {
                // Desplazamos los jugadores para hacer hueco
                for (int j = top.length - 1; j > i; j--) {
                    top[j] = top[j - 1];
                }

                // Insertamos el jugador nuevo
                top[i] = copiaJugador;
                return;
            }
        }
    }

    /**
     * Separa los jugadores en 4 ficheros, cada fichero representa de un equipo
     *
     * @param rutaFicheroJugador
     */
    private void filtrarJugadores(String rutaFicheroJugador) {
        // Declaramos los lectores y escritores de ficheros
        FicheroLecturaJugador lectorFicheroJugador = null;
        FicheroEscrituraJugador escritorFicheroBastones = null;
        FicheroEscrituraJugador escritorFicheroCopas = null;
        FicheroEscrituraJugador escritorFicheroEspadas = null;
        FicheroEscrituraJugador escritorFicheroOros = null;
        try {
            // Inicializamos los lectores y escritores
            lectorFicheroJugador = new FicheroLecturaJugador(rutaFicheroJugador);
            escritorFicheroBastones = new FicheroEscrituraJugador(RUTA_FICHERO_BASTONES, false);
            escritorFicheroCopas = new FicheroEscrituraJugador(RUTA_FICHERO_COPAS, false);
            escritorFicheroEspadas = new FicheroEscrituraJugador(RUTA_FICHERO_ESPADAS, false);
            escritorFicheroOros = new FicheroEscrituraJugador(RUTA_FICHERO_OROS, false);

            // Leemos todos lo jugadores
            Jugador jugadorLeidoActual = lectorFicheroJugador.leerJugador();
            while (!jugadorLeidoActual.esCentinela()) {
                // Clasificamos los jugadores
                switch (jugadorLeidoActual.getEquipo()) {
                    case Equipo.BASTONES -> {
                        escritorFicheroBastones.escribirJugador(jugadorLeidoActual);
                    }
                    case Equipo.COPAS -> {
                        escritorFicheroCopas.escribirJugador(jugadorLeidoActual);
                    }
                    case Equipo.ESPADAS -> {
                        escritorFicheroEspadas.escribirJugador(jugadorLeidoActual);
                    }
                    case Equipo.OROS -> {
                        escritorFicheroOros.escribirJugador(jugadorLeidoActual);
                    }
                }
                // Leemos el siguiente jugador
                jugadorLeidoActual = lectorFicheroJugador.leerJugador();
            }

            // Ponemos un centinela al final de cada fichero
            escritorFicheroBastones.escribirJugador(Jugador.CENTINELA);
            escritorFicheroCopas.escribirJugador(Jugador.CENTINELA);
            escritorFicheroEspadas.escribirJugador(Jugador.CENTINELA);
            escritorFicheroOros.escribirJugador(Jugador.CENTINELA);

        } catch (ClassNotFoundException ex) {
            System.err.println("Error: no se ha encontrado la clase Jugador.");
        } catch (EOFException ex) {
            System.err.println("Error: ha llegado al final del fichero.");
        } catch (IOException ex) {
            System.err.println("Error: ha habido un problema de IO.");
        } finally {
            try {
                // Cerramos el lector y los escritores de fichero
                lectorFicheroJugador.cerrar();
                escritorFicheroBastones.cerrar();
                escritorFicheroCopas.cerrar();
                escritorFicheroEspadas.cerrar();
                escritorFicheroOros.cerrar();

            } catch (IOException ex) {
                Logger.getLogger(Emulador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
