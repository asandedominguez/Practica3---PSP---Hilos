import java.util.Random;

// Esta clase, como su nombre y el enunciado indican, simulará la descarga de un archivo, y guardará cuanto a tardado. En este caso e utilizado Thread.
// Declaramos las siguientes variables. Servirán para guardar el tiempo que se pararán los hilos y sus nombres. Intanciaremos una variable random para obtener dicho valor de tiempo
public class Descarga extends Thread {
    int parada_random;
    public String nombre;
    public Random n_random = new Random();

    // Establecemos el nombre del archivo, que se guardará en la variable nombre.
    // parada_random tendrá un valor aleatorio de 100 a 500. Al añadirle el + 100 establecemos que al rango tanto mínimo como máximo hay que sumarle ese valor, sin el de normal daría un número entre 0 y 400,
    // al hacer esto será entre 100 y 500.
    public Descarga(String archivos) {
        super(archivos);
        nombre = archivos;
        parada_random = n_random.nextInt(401) + 100;

    }

    // Creamos un bucle con 10 iteraciones, donde guardaremos el tiempo que tarda en ejecutarse cada una en una variable llamada
    // tiempo_total (declarada fuera del run()), sumando el valor de parada_random en cada iteración, y guardandolo en una variable tiempo_total. Dormiremos cada iteración el tiempo indicado.
    // Hacemos que en cada iteración progrese la descarga un 10%, y este mismo valor se vea en pantalla.
    // Se mostrará el tiempo total que tardo.
    // Si ocurre algún error se dejará de realizar el proceso y mostrará en pantalla el porque.
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

    // devuelve el tiempo total que tardó en ejecutarse cada hilo
    public int getTiempoTotal() {
        return tiempo_total;
    }
}