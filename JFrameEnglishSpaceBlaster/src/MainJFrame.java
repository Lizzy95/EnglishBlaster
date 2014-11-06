/*
 * *Daniela Reyes Alatorre	    	    		A00618321
 *Norma Elizabeth  Morales Cruz 			A01195888
 *Humberto Makoto Morimoto Burgos			A01280458
 *Eduardo Andrade Martínez                    		A01035059
 */

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class MainJFrame {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        JFrameEnglishSpaceBlaster  juego = new JFrameEnglishSpaceBlaster (); // objeto de la clase applet
            juego.setSize(800,600);// tamaño del juego
            juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// para cerrar 
            //juego
            juego.setVisible(true); // para que se vea el juego
            
    }
}