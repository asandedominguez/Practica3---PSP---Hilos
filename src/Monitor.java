// Esta clase servira para monitorizar en tiempo real el estado de las descargas. Implementaremos Runnable
public class Monitor implements Runnable {

    // Creamos una lista con objetos Descarga, esta contendrá los hilos que queremos manejar
    public Descarga[] descarga;

    // Recibimos el array y lo iniciamos en una variable con su mismo nombre
    public Monitor(Descarga [] descarga) {
        this.descarga = descarga;
    }

    // Recorremos cada objeto descarga y veremos si está vivo, dando como resultado true. Cuando no haya mas objetos el método pasará a false.
    public boolean vivo() {
        for (Descarga d : descarga) {
            if (d.isAlive()) {
                return true;
            }
        }
        return false;
    }

    // Creamos un bucle que estará en funcionamiento hasta que el método vivo() pase a estado false.
    // Recorremos cada valor de la lista, y si ese esta vivo aumentamos en 1 el valor de la variable que nos servirá como contador.
    // Si esta variable es mayor que 0 mostrará un mensaje con cuantas descargas quedan sin descargar. Se mostrara cada 500ms.
    // Cuando ya no quedan más se mostrará un mensaje confome a ello.

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
                Thread.sleep(500);
            }
            System.out.println("[MONITOR] No queda ninguna descarga en curso");
        }

        // Si ocurrió algún error se mostrará en pantalla y se cerrará la ejecución
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error: " + e.getMessage());
        }
    }
}
