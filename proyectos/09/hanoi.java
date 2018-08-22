import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;
import javax.swing.JFrame;

class Hanoi extends JPanel //implements ActionListener
{
	private int discos;
    private int numDiscosTorre1;
	private int numDiscosTorre2;
	private int numDiscosTorre3;
	private int numTamTorre1;
	private int numTamTorre2;
	private int numTamTorre3;
	private int numXTorre1;
	private int numXTorre2;
	private int numXTorre3;

	private final int posDiscox10 = 50;
	private final int posDiscoy1  = 200;
	private final int posDiscox9  = 55;
	private final int posDiscoy2  = 185;
	private final int posDiscox8  = 60;
	private final int posDiscoy3  = 170;
	private final int posDiscox7  = 65;
	private final int posDiscoy4  = 155;
	private final int posDiscox6  = 70;
	private final int posDiscoy5  = 140;
	private final int posDiscox5  = 75;
	private final int posDiscoy6  = 125;
	private final int posDiscox4  = 80;
	private final int posDiscoy7  = 110;
	private final int posDiscox3  = 85;
	private final int posDiscoy8  = 95;
	private final int posDiscox2  = 90;
	private final int posDiscoy9  = 80;
	private final int posDiscox1  = 95;
	private final int posDiscoy10 = 65;
	private final int tamDisco10  = 120;
	private final int tamDisco9   = 110;
	private final int tamDisco8   = 100;
	private final int tamDisco7   = 90;
	private final int tamDisco6   = 80;
	private final int tamDisco5   = 70;
	private final int tamDisco4   = 60;
	private final int tamDisco3   = 50;
	private final int tamDisco2   = 40;
	private final int tamDisco1   = 30;
	private final int tamAncho    = 10;

// Colocar 3 arreglos para indicar el tamaño de cada disco en cada posición del arreglo
	
	Hanoi (int numDiscos) {
		discos = numDiscos;
		numDiscosTorre1 = numDiscos;
		numDiscosTorre2 = 0;
		numDiscosTorre3 = 0;
		repaint();
	}

	public void empezar()
	{
		numTamTorre1 = inicioTD(discos);
		numXTorre1 = inicioX(discos, 0);
		numTamTorre2 = 0;
		numTamTorre3 = 0;
		numXTorre2 = 0;
		numXTorre3 = 0;
		try        
		{
			Thread.sleep(1000);
		} 
		catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
		repaint();
		resolver(discos, 0, 1, 2, inicioTD(discos));
	}
	
	private void resolver(int n, int inicio, int auxiliar, int fin, int tamDisco) {
		int temporal;
		if (n == 1) {
			if (inicio == 0) {
				numDiscosTorre1--;
				if(numDiscosTorre1 == 0) {
					numTamTorre1 = 0;
					numXTorre1 = 0;
				}	
			} else if (inicio == 1) {
				numDiscosTorre2--;
				if(numDiscosTorre2 == 0) {
					numTamTorre2 = 0;
					numXTorre2 = 0;
				}	
			} else if (inicio == 2) {
				numDiscosTorre3--;
				if(numDiscosTorre3 == 0) {
					numTamTorre3 = 0;
					numXTorre3 = 0;
				}	
			}
			if (fin == 0) {
				numDiscosTorre1++;
				if(numTamTorre1 == 0) {
					numTamTorre1 = tamDisco;
					temporal = numDiscosTorre1;
					if (auxiliar == 1)
						temporal+=numDiscosTorre2;
					else
						temporal+=numDiscosTorre3;
					numXTorre1 = inicioX(temporal, 0);
				}
			} else if (fin == 1) {
				numDiscosTorre2++;
				if(numTamTorre2 == 0) {
					numTamTorre2 = tamDisco;
					temporal = numDiscosTorre2;
					if (auxiliar == 0)
						temporal+=numDiscosTorre1;
					else
						temporal+=numDiscosTorre3;
					numXTorre2 = inicioX(temporal, 1);
				}
			} else if (fin == 2) {
				numDiscosTorre3++;
				if(numTamTorre3 == 0) {
					numTamTorre3 = tamDisco;
					temporal = numDiscosTorre3;
					if (auxiliar == 0)
						temporal+=numDiscosTorre1;
					else
						temporal+=numDiscosTorre2;
					numXTorre3 = inicioX(temporal, 2);
				}
			}
			System.out.println(inicio + " -> " + fin);
			try        
			{
				Thread.sleep(1000);
			} 
			catch(InterruptedException ex) 
			{
				Thread.currentThread().interrupt();
			}
			repaint();
		} else {
			resolver(n - 1, inicio, fin, auxiliar, tamDisco - 10);
			if (inicio == 0) {
				numDiscosTorre1--;
				if(numDiscosTorre1 == 0) {
					numTamTorre1 = 0;
					numXTorre1 = 0;
				}	
			} else if (inicio == 1) {
				numDiscosTorre2--;
				if(numDiscosTorre2 == 0) {
					numTamTorre2 = 0;
					numXTorre2 = 0;
				}	
			} else if (inicio == 2) {
				numDiscosTorre3--;
				if(numDiscosTorre3 == 0) {
					numTamTorre3 = 0;
					numXTorre3 = 0;
				}	
			}
			if (fin == 0) {
				numDiscosTorre1++;
				if(numTamTorre1 == 0) {
					numTamTorre1 = tamDisco;
					temporal = numDiscosTorre1;
					if (auxiliar == 1)
						temporal+=numDiscosTorre2;
					else
						temporal+=numDiscosTorre3;
					numXTorre1 = inicioX(temporal, 0);
				}
			} else if (fin == 1) {
				numDiscosTorre2++;
				if(numTamTorre2 == 0) {
					numTamTorre2 = tamDisco;
					temporal = numDiscosTorre2;
					if (auxiliar == 0)
						temporal+=numDiscosTorre1;
					else
						temporal+=numDiscosTorre3;
					numXTorre2 = inicioX(temporal, 1);
				}
			} else if (fin == 2) {
				numDiscosTorre3++;
				if(numTamTorre3 == 0) {
					numTamTorre3 = tamDisco;
					temporal = numDiscosTorre3;
					if (auxiliar == 0)
						temporal+=numDiscosTorre1;
					else
						temporal+=numDiscosTorre2;
					numXTorre3 = inicioX(temporal, 2);
				}
			}
			try        
			{
				Thread.sleep(1000);
			} 
			catch(InterruptedException ex) 
			{
				Thread.currentThread().interrupt();
			}
			repaint();
			System.out.println(inicio + " -> " + fin);
			resolver(n - 1, auxiliar, inicio, fin, tamDisco);
		}
	}

	private void dibujaTorres(Graphics2D g) {
		g.setColor(Color.blue);
		Rectangle2D.Double torre1 = new Rectangle2D.Double(105,10,10,210);
		Rectangle2D.Double torre2 = new Rectangle2D.Double(251,10,10,210);
		Rectangle2D.Double torre3 = new Rectangle2D.Double(397,10,10,210);
		g.fill(torre1);
		g.fill(torre2);
		g.fill(torre3);
		g.draw(torre1);
		g.draw(torre2);
		g.draw(torre3);
	}

	private int totalDiscos(int numTorre) {
		if(numTorre == 0)
			return numDiscosTorre1;
		if(numTorre == 1)
			return numDiscosTorre2;
		return numDiscosTorre3;
	}
	
	private int inicioX(int numDiscos, int numTorre) {
		if(numDiscos == 1)
			return posDiscox1 + (146 * numTorre);
		if(numDiscos == 2)
			return posDiscox2 + (146 * numTorre);
		if(numDiscos == 3)
			return posDiscox3 + (146 * numTorre);
		if(numDiscos == 4)
			return posDiscox4 + (146 * numTorre);
		if(numDiscos == 5)
			return posDiscox5 + (146 * numTorre);
		if(numDiscos == 6)
			return posDiscox6 + (146 * numTorre);
		if(numDiscos == 7)
			return posDiscox7 + (146 * numTorre);
		if(numDiscos == 8)
			return posDiscox8 + (146 * numTorre);
		if(numDiscos == 9)
			return posDiscox9 + (146 * numTorre);
		if(numDiscos == 10)
			return posDiscox10 + (146 * numTorre);
		return 0;
	}

	private int inicioTD(int numDiscos) {
		if(numDiscos == 1)
			return tamDisco1;
		if(numDiscos == 2)
			return tamDisco2;
		if(numDiscos == 3)
			return tamDisco3;
		if(numDiscos == 4)
			return tamDisco4;
		if(numDiscos == 5)
			return tamDisco5;
		if(numDiscos == 6)
			return tamDisco6;
		if(numDiscos == 7)
			return tamDisco7;
		if(numDiscos == 8)
			return tamDisco8;
		if(numDiscos == 9)
			return tamDisco9;
		if(numDiscos == 10)
			return tamDisco10;
		return 0;
	}

	private void dibujaDiscos(Graphics2D g, int numTorre, int numDiscos, int numPosXini, int numPosYini, int numTamDisco) {
		g.setColor(Color.blue);
		Rectangle2D.Double disco;
		int numTotalDiscos = numDiscos;
		int numTD = numTamDisco;
		do {
			disco = new Rectangle2D.Double(numPosXini,numPosYini,numTD,tamAncho);
			g.fill(disco);
			g.draw(disco);
			numPosXini = numPosXini + 5;
			numPosYini = numPosYini - 15;
			numTD = numTD - 10;
			numTotalDiscos--;
		} while (numTotalDiscos > 0);
	}
	
	@Override public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		dibujaTorres((Graphics2D) g);
		int numTotalDiscos = totalDiscos(0);
		dibujaDiscos((Graphics2D) g, 0, numTotalDiscos, numXTorre1, posDiscoy1, numTamTorre1);
		numTotalDiscos = totalDiscos(1);
		dibujaDiscos((Graphics2D) g, 1, numTotalDiscos, numXTorre2, posDiscoy1, numTamTorre2);
		numTotalDiscos = totalDiscos(2);
		dibujaDiscos((Graphics2D) g, 2, numTotalDiscos, numXTorre3, posDiscoy1, numTamTorre3);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int discos = -1;
		
		do {
			System.out.print("Entre el numero de discos entre 1 y 10; 0 terminará el programa ");
			discos = scanner.nextInt();
		} while (discos < 0 || discos > 10); 
		
		if (discos >= 1 && discos <= 10) {

			JFrame frame = new JFrame("Torres de Hanoi");
			Hanoi torresDeHanoi = new Hanoi(discos);
			frame.add(torresDeHanoi);
			frame.setResizable(false);
			frame.pack();
			frame.setTitle("Torres de Hanoi");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(512,256);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			torresDeHanoi.empezar();
		}
	}
}
