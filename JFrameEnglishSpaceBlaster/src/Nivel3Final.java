/*
 * Memorama en el cual tendra qeu unir la imagen con la palabra que  la describa
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

public class Nivel3Final extends JFrame implements Runnable, MouseListener, MouseMotionListener {
    
    private Animacion animPlaneta1; //objeto de la clase animacion
    private Animacion animplaneta2; // objero de la clase animacion de planeta
    private Iconos icoPlaneta1; // objeto de la clase iconos
    private Iconos icoPlaneta2; // objeto de la clase iconos
    private Image imaImagenFondo; // objeto para la imagen de fondo
    private boolean booIguales; // variable para comprobar las palabras
        // agregar al diagrama
    private Image imaInstrucciones; // imagen de instrucciones
    private boolean booInstrucciones;
    private Iconos icoContinuar; // iciono para empezar el juego
    private Image imaDBImage; // imagend e fondo
    private Graphics graDbg;
    private Iconos icoPlaneta3; // objeto de la clase iconos
    private Iconos icoPlaneta4;
    private Iconos icoFlecha; //icono auxiliar
    private Iconos icoContinue; // icono de continuar
    private Iconos icoSelect; // icono de select
    private boolean booFlecha;

    /** 
     * AppletExamen
     * 
     * Metodo constructor que llama a las clases init y start para que pueda
     * correr el juego
     * 
     */ 
    public Nivel3Final() {
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
        // inicializa las instrucciones en true
        booInstrucciones = true;
        
        booFlecha = false;
        
        // creo imagen de continuar
        URL urlImagenContinuar = this.getClass().getResource("go.png");
        // se crea la imagen de  continuaar
        icoContinuar = new Iconos(50,50,
                Toolkit.getDefaultToolkit().getImage(urlImagenContinuar));
        
        // creo imagen de continue
        URL urlImagenContinue = this.getClass().getResource("LevelSelect/continue.png");
        // se crea la imagen de final
        icoContinue = new Iconos(400,200,
                Toolkit.getDefaultToolkit().getImage(urlImagenContinue));
        
        // creo imagen de select
        URL urlImagenSelect = this.getClass().getResource("LevelSelect/selectselect.png");
        // se crea la imagen de final
        icoSelect = new Iconos(50,200,
                Toolkit.getDefaultToolkit().getImage(urlImagenSelect));
                        
       // creo imagen de planeta 1
        URL urlImagenPlaneta1 = this.getClass().getResource("Nivel 3/p1.png");
        // se crea la imagen de planeta 1
        icoPlaneta1 = new Iconos(100, 200,
                Toolkit.getDefaultToolkit().getImage(urlImagenPlaneta1));
        
         // creo imagen de planeta 2
        URL urlImagenPlaneta2 = this.getClass().getResource("Nivel 3/p2.png");
        // se crea la imagen de planeta 2
        icoPlaneta2 = new Iconos(350, 450,
                Toolkit.getDefaultToolkit().getImage(urlImagenPlaneta2));
        
         // creo imagen de planeta 3
        URL urlImagenPlaneta3 = this.getClass().getResource("Nivel 3/p3.png");
        // se crea la imagen de planeta 3
        icoPlaneta3 = new Iconos(650, 450,
                Toolkit.getDefaultToolkit().getImage(urlImagenPlaneta3));
        
         // creo imagen de planeta 4
        URL urlImagenPlaneta4 = this.getClass().getResource("Nivel 3/p4.png");
        // se crea la imagen de planeta 4
        icoPlaneta4 = new Iconos(230, 70,
                Toolkit.getDefaultToolkit().getImage(urlImagenPlaneta4));
        
         URL urlImagenFlecha = this.getClass().getResource("flecha.png");
        icoFlecha = new Iconos(100, 100,
                Toolkit.getDefaultToolkit().getImage(urlImagenFlecha));
        
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
          //  System.out.println("entra");
            booInstrucciones = false;
        }
        else if(icoFlecha.colisiona(mouEvent.getX(), mouEvent.getY())){
           booFlecha = true; 
       }
       else if(icoContinue.colisiona(mouEvent.getX(), mouEvent.getY())){
       //  System.out.println("entra");
                Nivel4Final  juego4 = new Nivel4Final (); // objeto de la clase applet
                juego4.setSize(800,600);// tamaño del juego
                juego4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// para cerrar 
                //juego
                juego4.setVisible(true); // para que se vea el juego
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
        URL urlImagenFondo = this.getClass().getResource("Nivel 3/background.jpg");
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
         //  System.out.println("sal");
            URL urlImagenAyuda = this.getClass().getResource("Instrucciones Planeta 3/Sprites_Videojuego.jpg");
            imaInstrucciones = Toolkit.getDefaultToolkit().
                                    getImage(urlImagenAyuda);
            graDbg.drawImage(imaInstrucciones, 0, 0,
                    getWidth(), getHeight(), this);
            
            //Dibuja la imagen de continuar en la posicion actualizada
            g.drawImage(icoContinuar.getImagen(), icoContinuar.getX(),
                    icoContinuar.getY(), this);            
        }
        else if(booFlecha){
            URL urlImagenAyuda = this.getClass().getResource("LevelSelect/background.jpg");
           Image imaLevel = Toolkit.getDefaultToolkit().
                                    getImage(urlImagenAyuda);
            graDbg.drawImage(imaLevel, 0, 0,
                    getWidth(), getHeight(), this);
            
            g.drawImage(icoContinue.getImagen(), icoContinue.getX(),
                    icoContinue.getY(), this);  
            
            g.drawImage(icoSelect.getImagen(), icoSelect.getX(),
                    icoSelect.getY(), this);            
        }
        else
        {
            if (icoPlaneta1 != null && icoPlaneta2 != null && icoPlaneta3 != null && icoPlaneta4 != null) {
            //Dibuja la imagen de planeta1 en la posicion actualizada 
                g.drawImage(icoPlaneta1.getImagen(), icoPlaneta1.getX(),
                    icoPlaneta1.getY(), this);
                
                //Dibuja la imagen de planeta1 en la posicion actualizada 
                g.drawImage(icoPlaneta2.getImagen(), icoPlaneta2.getX(),
                    icoPlaneta2.getY(), this);
                
                //Dibuja la imagen de planeta1 en la posicion actualizada 
                g.drawImage(icoPlaneta3.getImagen(), icoPlaneta3.getX(),
                    icoPlaneta3.getY(), this);
                
                //Dibuja la imagen de planeta1 en la posicion actualizada 
                g.drawImage(icoPlaneta4.getImagen(), icoPlaneta4.getX(),
                    icoPlaneta4.getY(), this);
                
                g.drawImage(icoFlecha.getImagen(), icoFlecha.getX(), 
                        icoFlecha.getY(), this);
            }
        }
    }
}
