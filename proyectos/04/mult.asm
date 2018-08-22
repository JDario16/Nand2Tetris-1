// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)

	// Put your code here.
	
	//Se inicializa cont con el valor de R0 
	@R0
	D=M // D=RAM[0]
	@cont
	M=D //RAM[cont]=D RAM[cont] = RAM[0]

	//@R2
	M=0 //RAM[2]=0
	

	(LOOP)
	//mientras que cont sea > 0 el ciclo ira trabajando para realizar las sumas correspondientes
	
	@cont
	D=M // D=RAM[cont]
	@END
	D;JEQ //if cont == 0 go to END (ciclo infinito)

	@R1
	D=M //D=RAM[1]
	@R2
	M=D+M //RAM[2]=RAM[1]+RAM[2]

	@cont
	M=M-1 // RAM[cont] = RAM[cont] - 1

	
	@LOOP
	0;JMP
	

	(END)
	0;JMP
	
	
	
	
	
	
