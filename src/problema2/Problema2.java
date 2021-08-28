/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema2;

import java.io.*;
import java.text.ParseException;

/**
 *
 * @author Windows
 */
public class Problema2 {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) throws ParseException {

        String archivoEntrada = "entrada.txt";
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(archivoEntrada));

            int noRondas = Integer.parseInt(br.readLine());
            String ronda = "";
            int puntajeJugador1 = 0;
            int puntajeJugador2 = 0;
            int diferenciaPuntos = 0;
            int diferenciaMasGrande = 0;
            int jugadorGanador = 0;
            for (int i = 0; i < noRondas; i++) {
                ronda = br.readLine();
                String[] resultados = ronda.split(" ");
                puntajeJugador1 = Integer.parseInt(resultados[0]);
                puntajeJugador2 = Integer.parseInt(resultados[1]);
                if (puntajeJugador1 > puntajeJugador2) {
                    diferenciaPuntos = puntajeJugador1 - puntajeJugador2;
                } else {
                    diferenciaPuntos = puntajeJugador2 - puntajeJugador1;
                }

                if (diferenciaPuntos > diferenciaMasGrande) {
                    diferenciaMasGrande = diferenciaPuntos;
                    if (puntajeJugador1 > puntajeJugador2) {
                        jugadorGanador = 1;
                    } else {
                        jugadorGanador = 2;
                    }
                }

            }

            FileWriter archivoSalida = null;
            PrintWriter pw = null;
            try {
                archivoSalida = new FileWriter("salida.txt");
                pw = new PrintWriter(archivoSalida);

                pw.println(jugadorGanador + " " + diferenciaMasGrande);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != archivoSalida) {
                        archivoSalida.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error de lectura de archivo");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error de lectura de archivo");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar de archivo");
                System.out.println(e.getMessage());
            }
        }

    }
}
