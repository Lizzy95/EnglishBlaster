
/**
 * // Escuchar una grabacion y escribir la palabra de lo que se escucho
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
import java.util.logging.Level;
import java.util.logging.Logger;


public class Nivel1Final extends JFrame implements Runnable, KeyListener {
    private String sRespuesta; // variable para leer la respuesta
    private SoundClip souPregunta; // varibale con la grabacion a oir
    private Animacion animNave; // variable para el manejo de animacion
    private Image imaImagenFondo; // imagen de fondo
    private Image imaInstrucciones; // imagen de instrucciones
    private Image imaDBImage; // imagend e fondo
    private Graphics graDbg;
    private long lonTiempoActual;
    private long lonTiempoInicial;
    // agregar al diagrama
    private boolean booInstrucciones;
    private Iconos icoContinuar; // iciono para empezar el juego

    /** 
     * AppletExamen
     * 
     * Metodo constructor que llama a las clases init y start para que pueda
     * correr el juego
     * 
     */ 
    public Nivel1Final() {
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
      
      // inicializa instrucciones
      booInstrucciones = true;
      
      // creo imagen de continuar
        URL urlImagenAvanzado = this.getClass().getResource("go.png");
        // se crea la imagen de final
        icoContinuar = new Iconos(50,50,
                Toolkit.getDefaultToolkit().getImage(urlImagenAvanzado));
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
	
    /**
     * checaColision
     * 
     * Metodo usado para checar la colision del objeto nena, camina y corre
     * con las orillas del <code>Applet</code>.
     * 
     */
    public synchronized void checaPalabra(){
        
    }       
   
     /**
     * keyPressed
     * 
     * Metodo sobrescrito de la interface <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al dejar presionada
     * alguna tecla.
     * @param keyEvent es el <code>evento</code> generado al presionar.
     * 
     */
    public void keyPressed(KeyEvent keyEvent) {

    }
    
    /**
     * keyTyped
     * 
     * Metodo sobrescrito de la interface <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar una 
     * tecla que no es de accion.
     * @param e es el <code>evento</code> que se genera en al presionar.
     * 
     */
    public void keyTyped(KeyEvent e){
    	// no hay codigo pero se debe escribir el metodo
    }
    
    /**
     * keyReleased
     * Metodo sobrescrito de la interface <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar la tecla.
     * @param e es el <code>evento</code> que se genera en al soltar las teclas.
     */
    public void keyReleased(KeyEvent keyEvent){
        
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
        URL urlImagenFondo = this.getClass().getResource("Nivel 1/background.jpg");
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
        
        if (!booInstrucciones) {
            System.out.println("sal");
            URL urlImagenAyuda = this.getClass().getResource("Instrucciones Planeta1/Sprites_Videojuego.jpg");
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
            
        }
           
    }
}
