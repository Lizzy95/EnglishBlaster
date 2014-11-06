/*
 *Daniela Reyes Alatorre	    	    		A00618321
 *Norma Elizabeth  Morales Cruz 			A01195888
 *Humberto Makoto Morimoto Burgos			A01280458
 *Eduardo Andrade Martínez                    		A01035059
 * Tres naves las cuales tendranuna imagen cada una de ellas asi como tambin 
 * con tres agujeros negros el usuario tendra que jalar la nave hacia el agujero 
 * negro que contenga la palabra que corresponda con la nave
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Nivel4Final extends JFrame implements Runnable, MouseListener, MouseMotionListener {
    
    private Iconos icoNave; // objeto de la clase iconos para la nave
    private Iconos icoAgujero; // objeto de la clase iconos para el agujero
    private Animacion animNave; // objeto de la clase animacion
    private Animacion animAgujero; // objeto de la clase animacion
     // agregar al diagrama
    private Image imaInstrucciones; // imagen de instrucciones
    private Image imaImagenFondo; //imagen de fondo
    private boolean booInstrucciones;
    private Iconos icoContinuar; // iciono para empezar el juego
    private Image imaDBImage; // imagend e fondo
    private Graphics graDbg;
    private Iconos icoNave2; // objeto de la clase iconos para la nave
    private Iconos icoAgujero2; // objeto de la clase iconos para el agujer
    private Iconos icoNave3; // objeto de la clase iconos para la nave
    private Iconos icoAgujero3; // objeto de la clase iconos para el agujer
    /** 
     * AppletExamen
     * 
     * Metodo constructor que llama a las clases init y start para que pueda
     * correr el juego
     * 
     */ 
    public Nivel4Final() {
       setSize(800, 600); //define tamaño del JFrame
       init();
       start();
     
   }
	
    /** 
     * init
     * 
     * Metodo sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se inizializan las variables o se crean los objetos
     * a usarse en el <code>Applet</code> y se definen funcionalidades.
     */
    public void init() {
        setSize(800, 600);
        // inicializa las instrucciones en true
        booInstrucciones = true;
        
        // creo imagen de continuar
        URL urlImagenContinuar = this.getClass().getResource("go.png");
        // se crea la imagen de  continuaar
        icoContinuar = new Iconos(50,50,
                Toolkit.getDefaultToolkit().getImage(urlImagenContinuar));
        
        // creo imagen de nave1
        URL urlImagenNave = this.getClass().getResource("Nivel_4/nave1.png");
        // se crea la imagen de  continuaar
        icoNave = new Iconos(20,20,
                Toolkit.getDefaultToolkit().getImage(urlImagenNave));
        
        // creo imagen de nave2
        URL urlImagenNave2 = this.getClass().getResource("Nivel_4/nave2.png");
        // se crea la imagen de  continuaar
        icoNave2 = new Iconos(550,20,
                Toolkit.getDefaultToolkit().getImage(urlImagenNave2));
        
        // creo imagen de nave3
        URL urlImagenNave3 = this.getClass().getResource("Nivel_4/nave3.png");
        // se crea la imagen de  continuaar
        icoNave3 = new Iconos(250,20,
                Toolkit.getDefaultToolkit().getImage(urlImagenNave3));
        icoNave3.setX((getWidth()/2) - (icoNave3.getAncho()/2));
               
             
        
        // creo imagen de agujero1
        URL urlImagenAgujero = this.getClass().getResource("Nivel_4/hoyo1.png");
        // se crea la imagen de  continuaar
        icoAgujero = new Iconos(20,getHeight(),
                Toolkit.getDefaultToolkit().getImage(urlImagenAgujero));
        icoAgujero.setY(getHeight() -icoAgujero.getAlto());
        
        // creo imagen de agujero2
        URL urlImagenAgujero2 = this.getClass().getResource("Nivel_4/hoyo2.png");
        // se crea la imagen de  continuaar
        icoAgujero2 = new Iconos(550,50,
                Toolkit.getDefaultToolkit().getImage(urlImagenAgujero2));
        icoAgujero2.setY(getHeight() -icoAgujero.getAlto());
        
        // creo imagen de agujero3
        URL urlImagenAgujero3 = this.getClass().getResource("Nivel_4/hoyo3.png");
        // se crea la imagen de  continuaar
        icoAgujero3 = new Iconos(300,50,
                Toolkit.getDefaultToolkit().getImage(urlImagenAgujero3));
        icoAgujero3.setY(getHeight() -icoAgujero.getAlto());
        
        
        addMouseListener(this);
        
    }
	
    /** 
     * start
     * 
     * Metodo sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se crea e inicializa el hilo
     * para la animAmbulanciaacion este metodo es llamado despues del init o 
     * cuando el usuario visita otra pagina y luego regresa a la pagina
     * en donde esta este <code>Applet</code>
     * 
     */
    public void start () {
        // Declaras un hilo
        Thread th = new Thread (this);
        // Empieza el hilo
        th.start ();
    }
	
    /** 
     * run
     * 
     * Metodo sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, que contendrá las instrucciones
     * de nuestro juego.
     * 
     */
    public void run () {
        // se realiza el ciclo del juego en este caso nunca termina
        while (true) {
            /* mientras dure el juego, se actualizan posiciones de jugadores
               se checa si hubo colisiones para desaparecer jugadores o corregir
               movimientos y se vuelve a pintar todo
            */ 
            if(!booInstrucciones){
                //actualiza();
               // checaColision();
                repaint();
            }
            
            try	{
                // El thread se duerme.
                Thread.sleep (20);
            }
            catch (InterruptedException iexError)	{
                System.out.println("Hubo un error en el juego " + 
                        iexError.toString());
            }    
	}
    }
    /** 
     * actualiza
     * 
     * Metodo que actualiza la posicion del objeto nena, camina y corredor
     * 
     */
    public synchronized void actualiza(){
        
    }
    public void mouseClicked(MouseEvent mouEvent) {
       if (icoContinuar.colisiona(mouEvent.getX(), mouEvent.getY())) {
            System.out.println("entra");
            booInstrucciones = false;
        }
    } 
    public void mouseEntered(MouseEvent e) {
        // no hay codigo pero se debe escribir el metodo
    }
     
    public void mouseExited(MouseEvent e) {
        // no hay codigo pero e debe escribir el metodo
    }
    
    public void mousePressed(MouseEvent mouEvent) {
    }
    
    
    public void mouseDragged(MouseEvent mouEvent){

    }

    public void mouseReleased(MouseEvent e) {
        
    }
      

      
      public void mouseMoved(MouseEvent mouEvent)
      {
          // no tiene codigo pero se pone el metodo
      }
     /**
     * paint
     * 
     * Metodo sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo lo que hace es actualizar el contenedor y 
     * define cuando usar ahora el paint
     * @param graGrafico es el <code>objeto grafico</code> usado para dibujar.
     * 
     */
    public void paint (Graphics graGrafico){
        // Inicializan el DoubleBuffer
        if (imaDBImage == null){
                imaDBImage = createImage (this.getSize().width, 
                        this.getSize().height);
                graDbg = imaDBImage.getGraphics ();
        }

        // creo imagen para el background
        URL urlImagenFondo = this.getClass().getResource("Nivel_4/background.jpg");
        imaImagenFondo = Toolkit.getDefaultToolkit().
                                                getImage(urlImagenFondo);

        // Despliego la imagen
        graDbg.drawImage(imaImagenFondo, 0, 0, 
                getWidth(), getHeight(), this);

        // Actualiza el Foreground.
        graDbg.setColor (getForeground());
        paint1(graDbg);

        // Dibuja la imagen actualizada
        graGrafico.drawImage (imaDBImage, 0, 0, this);
    }
    
    /**
     * paint
     * 
     * Metodo sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo se dibuja la imagen con la posicion actualizada,
     * ademas que cuando la imagen es cargada te despliega una advertencia.
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     * 
     */
    public void paint1(Graphics g) {
        if (booInstrucciones) {
           //System.out.println("sal");
            URL urlImagenAyuda = this.getClass().getResource("Instrucciones Planeta4/Sprites_Videojuego.jpg");
            imaInstrucciones = Toolkit.getDefaultToolkit().
                                    getImage(urlImagenAyuda);
            graDbg.drawImage(imaInstrucciones, 0, 0,
                    getWidth(), getHeight(), this);
            
            //Dibuja la imagen de continuar en la posicion actualizada
            g.drawImage(icoContinuar.getImagen(), icoContinuar.getX(),
                    icoContinuar.getY(), this);            
        }
        else
        {
            if (icoAgujero != null && icoAgujero2 != null && icoAgujero3 != null && icoNave != null && icoNave2 != null && icoNave3 != null) {
                //Dibuja la imagen de nave en la posicion actualizada
                g.drawImage(icoNave.getImagen(), icoNave.getX(),
                    icoNave.getY(), this); 
                
                //Dibuja la imagen de nave en la posicion actualizada
                g.drawImage(icoNave2.getImagen(), icoNave2.getX(),
                    icoNave2.getY(), this); 
                
                //Dibuja la imagen de nave en la posicion actualizada
                g.drawImage(icoNave3.getImagen(), icoNave3.getX(),
                    icoNave3.getY(), this); 
                
                //Dibuja la imagen de agujero en la posicion actualizada
                g.drawImage(icoAgujero.getImagen(), icoAgujero.getX(),
                    icoAgujero.getY(), this); 
                
                //Dibuja la imagen de agujero en la posicion actualizada
                g.drawImage(icoAgujero2.getImagen(), icoAgujero2.getX(),
                    icoAgujero2.getY(), this); 
                
                //Dibuja la imagen de agujero en la posicion actualizada
                g.drawImage(icoAgujero3.getImagen(), icoAgujero3.getX(),
                    icoAgujero3.getY(), this); 
            }
        }
    }
}
