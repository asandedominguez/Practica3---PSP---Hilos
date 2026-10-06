import java.util.Scanner;

public class GestorDescargasTotal {
    public static void main(String[] args) {
        Descarga[] descargas = {
                new Descarga("cuarzos.png"),
                new Descarga("meditacion.mp4"),
                new Descarga("horoscopo.pdf"),
                new Descarga("mantras.mp3"),
        };

        for (Descarga d: descargas) {
            d.setName("Descarga-" + d.nombre);
            d.start();
        }

        try {
            for (Descarga d: descargas) {
                d.join();
            }
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Todas las descargas han terminado.");

        int real = Math.max(Math.max(descargas[0].getTiempoTotal(), descargas[1].getTiempoTotal()),
                Math.max(descargas[2].getTiempoTotal(), descargas[3].getTiempoTotal()));

        System.out.println("Tiempo real: " + real + " ms");

        int tiempo = 0;
        for (Descarga d : descargas) {
            tiempo += d.getTiempoTotal();
        }
        System.out.println("Si se hubieran descargado una detras de otra: " + tiempo + "ms");

        String[] archivos;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los nombres (si no hay ninguno se utilizarán los predeterminados): ");
        String nombres = scanner.nextLine().trim();

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
        Descarga[] descargas2 = new Descarga[archivos.length];
        for (int i = 0; i < archivos.length; i++) {
            descargas2[i] = new Descarga(archivos[i]);
            descargas2[i].setName("Descarga-" + descargas2[i].nombre);
            descargas2[i].start();
        }
        Monitor monitor = new Monitor(descargas2);
        Thread hilo = new Thread(monitor);
        hilo.start();

        try {
            for (Descarga d : descargas2) {
                d.join();
            }
            hilo.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}