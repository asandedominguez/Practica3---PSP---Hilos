public class GestorDescargas {
    public static void main (String[] args) {
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
    }
}

