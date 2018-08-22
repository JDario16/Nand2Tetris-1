Programa para traducir de archivos .vm a .asm
(no recibe nada que contenga funciones o saltos if || if-goto ni labels)
Compilacion:
	javac SuCodeWrite.java SuParser.java
Ejecucion:
	java SuCodeWrite <nombreArchivo.vm>
Salida:
	<nombreArchivo.asm>
