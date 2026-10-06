# Tarea 09 - Descargas Cuánticas: el gestor de Don Magufo

### En esta práctica e realizados los ejercicios 1 y 2.

### Se puede ver que hay 3 gestores de descargas, el llamado "GestorDescargas" equivale al ejercicio 1. <br> "GestorDescargas2" al ejercicio 2. "GestorDescargasTotal" son los 2 ejercicios únidos. Lo hice de esta forma porque no sabía si querias revisarlos individualmente o todos juntos.

## AYUDA DE LA IA

### En mi código inicial de "GestorDescargas", para calcular el tiempo real que habia tardado en ejecutarse el programa utilizaba math.max de la siguiente forma:
int real = Math.max(Math.max(descargas[0].getTiempoTotal(), descargas[1].getTiempoTotal()),

Math.max(descargas[2].getTiempoTotal(), descargas[3].getTiempoTotal()));

### Esto no seria correcto, ya que simplemente me daría el tiempo mas alto entre las ejecuciones, por tanto le pregunte a Gemini lo siguiente con este prompt:

"Que instrucción puedo utilizar para calcular el tiempo real exacto en milisegundos que tarda un programa en ejecutarse, solo dime cual, no me hagas ningún código de ejemplo"

### Me dió la instrucción "System.currentTimeMillis()", que sirve para hacer eso exactamente, calcular el tiempo exacto que tarda un programa en ejecutarse de principio a fin, por eso en el código esta esta instrucción justo antes del start, para que  se ejecute justo antes del cominezo, y otra al final para que calcule el tiempo que tardo en terminarse el proceso. Por último hacemos una resta que nos dará el resultado total en milisegundos que tardo el programa en terminar con precisión.

## TABLA 

| Ejecución | Descarga mas lenta   | Tiempo real (ms) | Suma (ms)
| :--- |:---------------------| :--- | :--- |
| 1 | mantras.mp3 (4770ms) | 4781ms | 14270ms
| 2 | mantras.mp3 (4640ms) | 4649ms | 11210ms
| 3 | horoscopo.pdf (3480ms) | 3488ms | 10350ms

## 1º COMPROBACIÓN

![1](/Capturas/1.png)

![2](/Capturas/2.png)

![3](/Capturas/3.png)

## 2º COMPROBACIÓN

![4](/Capturas/4.png)

![5](/Capturas/5.png)

![6](/Capturas/6.png)

## 3º COMPROBACIÓN

![7](/Capturas/7.png)

![8](/Capturas/8.png)

![9](/Capturas/9.png)

## ¿Porque el tiempo real es menor que la suma?

Porque el programa se esta ejecutando de manera concurrente, es decir, en vez de esperar a que una descarga termine para iniciar la siguiente, estamos pausando los hilos un tiempo determinado (con ".sleep") mientras el resto se siguen ejecutando, haciendo así que la velocidad sea mucho mas rápida, ya que se estará trabajando en mas de un hilo a la vez en esos tiempo de espera.

## ¿Qué pasa si hacéis start() y join() dentro del mismo bucle? Probadlo y poned el tiempo real que os sale.

Estaremos creando un programa secuencial. iniciaremos el hilo e inmediatamente esperaremos a que termine, lo que hará que el tiempo aumento mucho, ya que irá trabajando en ellos uno por uno.

### CÓDIGO DE ESTA FORMA:

![10](/Capturas/10.png)

![11](/Capturas/11.png)

### RESULTADO: 

![12](/Capturas/12.png)

![13](/Capturas/13.png)

![14](/Capturas/14.png)

## CÓDIGO EJECICIO 1 - LOS RESULTADOS YA APARECEN EN LAS CAPTURAS DE PANTALLA REFERÍDAS A LA TABLA, ASÍ QUE NO LOS VUELVO A PONER AQUÍ

### DESCARGA

![15](/Capturas/15.png)

![16](/Capturas/16.png)

### GESTOR DESCARGAS

![17](/Capturas/17.png)

![18](/Capturas/18.png)

## CÓDIGO EJERCICIO 2

### MONITOR

![19](/Capturas/19.png)

![20](/Capturas/20.png)

### GESTOR DESCARGAS 2

![21](/Capturas/21.png)

![22](/Capturas/22.png)

### SALIDA

![23](/Capturas/23.png)

![24](/Capturas/24.png)

![25](/Capturas/25.png)

![30](/Capturas/30.png)

![31](/Capturas/31.png)

![32](/Capturas/32.png)

## CÓDIGO GESTOR DESCARGAS TOTAL 

![26](/Capturas/26.png)

![27](/Capturas/27.png)

![28](/Capturas/28.png)

![29](/Capturas/29.png)

## SALIDA

![33](/Capturas/33.png)

![34](/Capturas/34.png)

![35](/Capturas/35.png)

### LAS EXPLICACIONES DE QUE HACE CADA CLASE Y MÉTODO ESTÁN INTRODUCIDAS EN FORMA DE COMENTARIOS EN EL CÓDIGO

### LA CLASE GestorDescargaaTotal NO LA EXPLICO YA QUE ES UNA COMBINACIÓN DE AMBAS, LAS CUALES, COMO YA E DICHO, ESTÁN EXPLICADAS
