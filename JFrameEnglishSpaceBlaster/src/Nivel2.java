/*
* El astronauta tendra que llegar a la nave esquivando la basura espacial y 
*  entrando por la puerta con la escritura correcta de la palabra desplegada en
*  la ventana de la nave. Contara con tres vidas para completar su mision y 
*  llegar a la nave por su puerta indicada. se movera usando las flechas
 */

/**
 *
 * @author Lizzi_
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

public class Nivel2 extends JFrame implements Runnable, MouseListener, MouseMotionListener {
    
    private Iconos icoAstronauta; // objeto astrounata de la clase Iconos
    private Iconos icoNave; // objeto nave de la clase Iconos 
    private Image imaImagenFondo; // imagen de fondo
    private Image imaPause; // iimagen de pausa
    private boolean booPausa; // boleana para contron de pausa
    private Animacion animAstronauta; // variable de animacion
    private Animacion animNave; // variable nave de animacion
    // agregar al diagrama
    private Image imaInstrucciones; // imagen de instrucciones
    private boolean booInstrucciones;
    private Iconos icoContinuar; // iciono para empezar el juego
    private Image imaDBImage; // imagend e fondo
    private Graphics graDbg;
    /** 
     * AppletExamen
     * 
     * Metodo constructor que llama a las clases init y start para que pueda
     * correr el juego
     * 
     */ 
    public Nivel2() {
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
        //inicializa la booleana en true
        booInstrucciones  = true;
        
        // creo imagen de continuar
        URL urlImagenContinuar = this.getClass().getResource("go.png");
        // se crea la imagen de  continuaar
        icoContinuar = new Iconos(50,50,
                Toolkit.getDefaultToolkit().getImage(urlImagenContinuar));
        
        URL urlImagenAstronauta = this.getClass().getResource("Nivel 2/astronauta.png");
        //se crea la imagen de austronauta
        icoAstronauta = new Iconos((getWidth()/2), getHeight(),
                Toolkit.getDefaultToolkit().getImage(urlImagenAstronauta));
        icoAstronauta.setY(getHeight()-icoAstronauta.getAlto());
        icoAstronauta.setX((getWidth()/2)-(icoAstronauta.getAncho()/2));
        
        URL urlImagenNave = this.getClass().getResource("Nivel 2/navenivel2.png");
        //se crea la imagen de nave
        icoNave = new Iconos(getWidth()/2, 20,
                Toolkit.getDefaultToolkit().getImage(urlImagenNave));
        icoNave.setX((getWidth()/2)-(icoNave.getAncho()/2));
        
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
        URL urlImagenFondo = this.getClass().getResource("Nivel 2/background.jpg");
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
            System.out.println("sal");
            URL urlImagenAyuda = this.getClass().getResource("Instrucciones Planeta2/Sprites_Videojuego.jpg");
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
            if (icoNave != null && icoAstronauta != null) {
                //Dibuja la imagen de nave en la posicion actualizada
                g.drawImage(icoNave.getImagen(), icoNave.getX(), 
                        icoNave.getY(), this);
                
                //Dibuja la imagen del astronauta actualizada
                g.drawImage(icoAstronauta.getImagen(), icoAstronauta.getX(),
                        icoAstronauta.getY(), this);
            }
        }
    }
}
