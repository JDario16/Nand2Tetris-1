// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.

	// Put your code here.

	(KAI) // Se verifica si el bit correspondiente al teclado = 24576 esta siendo modificado; una tecla esta siendo oprimida 
	
	@24576
	D=M // D = RAM[24576]
	@KURO
	D;JNE // if RAM[24576] != 0 GOTO KURO, se hunde una tecla
	

	//Inicia la secuencia para limpiar la pantalla 
	@SCREEN
	D=A // D = SCREEN
	M=0 // RAM[SCREEN] = 0 , Esto limpia el primer bit de la pantalla 
	@1
	M=D // RAM[1] = SCREEN , guardo el valor de SCREEN en la primera posicion de memoria 
	
	(LOOPS) // Inicia el ciclo para limpiar la pantalla
	@1
	M=M+1 //RAM[1] = RAM[1]+1 , aumenta el valor de SCREEN en 1 
	D=M //D = RAM[1] ,guardo en D el valor que hay en la posicion de memoria 1 , SCREEN + 1
	@2
	A=D // A = RAM[1] , guardo en A el valor que hay en la posicion de memoria 1 , SCREEN + 1 
	M=0 // RAM[SCREEN + 1] = 0 
	
	@24575 // Condicion de parada para evitar tocar el bit correspondiente al teclado 
	A=A-D // 24575 = 24575 - RAM[SCREEN + 1]
	D=A // D = 24575 - RAM[SCREEN + 1]

	@KAI
	D;JEQ // if (24575 - RAM[SCREEN + 1]) == 0 GOTO KAI
	@LOOPS
	0;JMP
	

	(KURO) // Inicia la secuencia para pintar la pantalla 
	@SCREEN
	D=A //D=SCREEN
	M=-1 //RAM[SCREEN]=-1
	@1
	M=D // RAM[1] = RAM[SCREEN]

	(LOOPK) // Inicia el ciclo para pintar la pantalla 
	@1
	M=M+1 // RAM[1] = RAM[1] + 1 , aumenta el valor de SCREEN en 1 
	D=M // D=RAM[1] , guardo en D el valor que hay en la posicion de memoria 1 , SCREEN + 1 
	@2
	A=D // A = RAM[1] , guardo en A el valor que hay en la posicion de memoria 1, SCREEN + 1 
	M=-1 // RAM[SCREEN + 1] = -1 
	
	@24575 // Condicion de parada para evitar tocar el bit correspondiente al teclado ; funciona igual que el anterior
	A=A-D
	D=A
	@KAI
	D;JEQ
	@LOOPK
	0;JMP
	

	

	
