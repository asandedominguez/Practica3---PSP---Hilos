public class GestorDescargas2 {
    public static void main(String[] args) {
        String[] archivos;

        if (args.length > 0) {
            archivos = args;
        } else {
            archivos = new String[]{
                    "cuarzos.png",
                    "meditacion.mp4",
                    "horoscopo.pdf",
                    "mantras.mp3"
            };
        }
        Descarga[] descargas = new Descarga[archivos.length];
        for (int i = 0; i < archivos.length; i++) {
            descargas[i] = new Descarga(archivos[i]);
            descargas[i].setName("Descarga-" + descargas[i].nombre);
            descargas[i].start();
        }
        Monitor monitor = new Monitor(descargas);
        Thread hilo = new Thread(monitor);
        hilo.start();

        try {
            for (Descarga d : descargas) {
                d.join();
            }
            hilo.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
