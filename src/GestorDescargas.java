public class GestorDescargas {
    public static void main (String[] args) {
        // Creamos una lista de objetos Descarga, donde al crearlos les pondremos el nombre que le corresponde
        Descarga[] descargas = {
                new Descarga("cuarzos.png"),
                new Descarga("meditacion.mp4"),
                new Descarga("horoscopo.pdf"),
                new Descarga("mantras.mp3"),
        };

        // En esta variable iniciamos el método "System.currentTimeMillis()" para que capture el tiempo antes de la inicialización de los hilos
        long inicio = System.currentTimeMillis();

        // Iniciamos todos a la vez y le ponemos su respectivo nombre a los hilos
        for (Descarga d: descargas) {
            d.setName("Descarga-" + d.nombre);
            d.start();
        }

        // Esperamos a que todos los hilos terminen a la vez antes de continuar
        try {
            for (Descarga d: descargas) {
                d.join();
            }
        }

        // Si surgió algún error se mostrará aquí
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        // Mensaje con la confirmación de que se completaron todas las descargas
        System.out.println("Todas las descargas han terminado.");


        // Capturamos el tiempo que tado en finalizarse el programa, y hacemos una resta para sacar el tiempo total que tardó en ejecutarse y terminarse, es decir, el tiempo real de ejecución. Lo mostramos por pantalla
        long fin = System.currentTimeMillis();
        long real = fin - inicio;

        System.out.println("Tiempo real: " + real + " ms");

        // Hacemos un cáculo de cuanto habría tardado si se hubiera ejecutado de forma secuencial, sumando los tiempos de cada hilo
        int tiempo = 0;
        for (Descarga d : descargas) {
            tiempo += d.getTiempoTotal();
        }
        System.out.println("Si se hubieran descargado una detras de otra: " + tiempo + "ms");
    }
}

