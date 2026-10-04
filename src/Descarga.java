import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class Descarga extends Thread {
    int parada_random;
    public String nombre;

    public Descarga(String archivos) {
        super(archivos);
        parada_random = ThreadLocalRandom.current().nextInt(100, 500);
        nombre = archivos;

    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(parada_random);
                tiempo_total += parada_random;
                int calculo = (i + 1) * 10;
                System.out.println("[" + nombre + "] " + calculo + "%");
            }
            System.out.println("[" + nombre + "] " + "completado en " + tiempo_total + " ms");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int tiempo_total;

    public int getTiempoTotal() {
        return tiempo_total;
    }
}