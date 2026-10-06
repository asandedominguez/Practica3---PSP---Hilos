// En este código ejecutamos tanto los hilos de descarga como los de Monitor, ya que debemos realizar el mismo proceso de descarga con las funcionalidades
// de la otra clase, ya que vamos a revisar dichas descargas, que están en sus respectivos hilos

import java.util.Scanner;

public class GestorDescargas2 {
    public static void main(String[] args) {

        // Creamos un array que tendrá los valores que introduzcamos
        String[] archivos;

        // Instanciamos una variable de tipo scanner que escuchará lo que escribamos en la linea de comandos
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los nombres (si no hay ninguno se utilizarán los predeterminados): ");

        // Se leé el contenido que introduzcamos y eliminará los espacios antes y después de lo que escribamos. Lo guarda en una variable llamda nombres
        String nombres = scanner.nextLine().trim();

        // Si nombres no está vacía separará cada valor que hayamos escrito a partir de los espacios que tienen entre medias.
        // Si esta vacía establecerá los valores por defecto
        if (!nombres.isEmpty()) {
            archivos = nombres.split("\\s+");
        } else {
            archivos = new String[]{
                    "cuarzos.png",
                    "meditacion.mp4",
                    "horoscopo.pdf",
                    "mantras.mp3"
            };
        }
        // Creamos un array de objetos Descarga, con el tamaño del número de valores que hayamos introducido
        // Recorremos la lista hasta que se termine, e introduciendo en cada posición el nombre del valor que hayamos introducido anteriormenete y el nombre del hilo.
        // Iniciamos los hilos de descarga
        Descarga[] descargas = new Descarga[archivos.length];
        for (int i = 0; i < archivos.length; i++) {
            descargas[i] = new Descarga(archivos[i]);
            descargas[i].setName("Descarga-" + descargas[i].nombre);
            descargas[i].start();
        }

        // Instanciamos un objeto monitor con los objetos ya guardados en la lista  descargas
        // Lo pasamos a un objeto Threads e iniciamos el hilo de monitor
        Monitor monitor = new Monitor(descargas);
        Thread hilo = new Thread(monitor);
        hilo.start();

        // Esperamos a que todos los hilos terminen a la vez, tanto los de descargas como los de monitor
        try {
            for (Descarga d : descargas) {
                d.join();
            }
            hilo.join();

        // Si surgió algún error se mostrará en pantalla
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
