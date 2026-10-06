public class Monitor implements Runnable {
    public Descarga[] descarga;

    public Monitor(Descarga [] descarga) {
        this.descarga = descarga;
    }

    public boolean vivo() {
        for (Descarga d : descarga) {
            if (d.isAlive()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        try {

            while (vivo()) {
                int contador = 0;
                for (Descarga d: descarga) {
                    if (d.isAlive()) {
                        contador++;
                    }
                }
                if (contador > 0) {
                    System.out.println("[MONITOR] Descargas en curso: " + contador);
                }
                Thread.sleep(500); // Muestra el estado primero y luego espera
            }
            System.out.println("[MONITOR] No queda ninguna descarga en curso");
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error: " + e.getMessage());
        }
    }
}
