import java.util.Scanner;

public class GestorDescargasTotal {
    public static void main(String[] args) {
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

        Descarga[] descargas = new Descarga[archivos.length];
        long inicio = System.currentTimeMillis();

        for (int i = 0; i < archivos.length; i++) {
            descargas[i] = new Descarga(archivos[i]);
            descargas[i].setName("Descarga-" + descargas[i].nombre);
            descargas[i].start();
        }

        Monitor monitor = new Monitor(descargas);
        Thread hiloMonitor = new Thread(monitor);
        hiloMonitor.start();

        try {
            for (Descarga d : descargas) {
                d.join();
            }
            hiloMonitor.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Todas las descargas han terminado.");

        long fin = System.currentTimeMillis();
        long real = fin - inicio;

        System.out.println("Tiempo real: " + real + " ms");

        int tiempo = 0;
        for (Descarga d : descargas) {
            tiempo += d.getTiempoTotal();
        }
        System.out.println("Si se hubieran descargado una detras de otra: " + tiempo + "ms");
    }
}