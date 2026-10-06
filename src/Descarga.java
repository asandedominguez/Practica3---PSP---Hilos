import java.util.Random;

public class Descarga extends Thread {
    int parada_random;
    public String nombre;
    public Random n_random = new Random();

    public Descarga(String archivos) {
        super(archivos);
        nombre = archivos;
        parada_random = n_random.nextInt(401) + 100;

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