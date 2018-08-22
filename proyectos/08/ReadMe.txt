Programa para traducir de archivos .vm a .asm
Compilacion:
	javac SuCodeWrite.java SuParser.java
Ejecucion:
	Para un solo archivo:
	java SuCodeWrite <nombreArchivo.vm>
	Para un directorio:
	java SuCodeWrite <path/path/folderName/>
Salida:
	si se ingreso un solo archivo, el archivo de salida estara en la misma ubicacion
	del programa java.
	si se ingreso un directorio, el archivo de salida estara dentro del directorio dado
	<nombreArchivo.asm>
Precaucion:
	El programa puede recibir de una ruta un solo archivo.vm , pero el archivo .asm
	de salida se enontrara ubicado en la misma ubicacion del programa java.
