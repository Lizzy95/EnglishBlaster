
/**
 * // Escuchar una grabacion y escribir la palabra de lo que se escucho
 * *Daniela Reyes Alatorre	    	    		A00618321
 *Norma Elizabeth  Morales Cruz 			A01195888
 *Humberto Makoto Morimoto Burgos			A01280458
 *Eduardo Andrade Martínez                    		A01035059
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Nivel1Intermedio extends JFrame implements Runnable, KeyListener, MouseListener, MouseMotionListener{
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
    private Iconos icoNave; // icono de la nave
    private Iconos icoPlaneta1; // icono de la planeta
    private Iconos icoPlaneta3; //icono de la planeta
    private Iconos icoPlaneta2; //icono de planeta
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
    public Nivel1Intermedio() {
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
      
      booFlecha = false;
      
      // creo imagen de continuar
        URL urlImagenAvanzado = this.getClass().getResource("go.png");
        // se crea la imagen de final
        icoContinuar = new Iconos(50,50,
                Toolkit.getDefaultToolkit().getImage(urlImagenAvanzado));
        
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
        
        // creo imagen de nave
        URL urlImagenNave = this.getClass().getResource("Nivel 1/Nave.png");
        // se crea la imagen de planeta 1
        icoNave = new Iconos(200, 50,
                Toolkit.getDefaultToolkit().getImage(urlImagenNave));
        icoNave.setX((getWidth()/2) - (icoNave.getAncho()/2));
        
        // creo imagen de planeta 1
        URL urlImagenPlaneta1 = this.getClass().getResource("Nivel 1/1.png");
        // se crea la imagen de planeta 1
        icoPlaneta1 = new Iconos(600, 450,
                Toolkit.getDefaultToolkit().getImage(urlImagenPlaneta1));
        
         // creo imagen de planeta 2
        URL urlImagenPlaneta2 = this.getClass().getResource("Nivel 1/2.png");
        // se crea la imagen de planeta 2
        icoPlaneta2 = new Iconos(400, 450,
                Toolkit.getDefaultToolkit().getImage(urlImagenPlaneta2));
        
         // creo imagen de planeta 3
        URL urlImagenPlaneta3 = this.getClass().getResource("Nivel 1/3.png");
        // se crea la imagen de planeta 3
        icoPlaneta3 = new Iconos(50, 400,
                Toolkit.getDefaultToolkit().getImage(urlImagenPlaneta3));
        
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
    
    public void mouseClicked(MouseEvent mouEvent) {
       if (icoContinuar.colisiona(mouEvent.getX(), mouEvent.getY())) {
         //   System.out.println("entra");
            booInstrucciones = false;
        }
       else if(icoFlecha.colisiona(mouEvent.getX(), mouEvent.getY())){
           booFlecha = true; 
       }
       else if(icoContinue.colisiona(mouEvent.getX(), mouEvent.getY())){
       //  System.out.println("entra");
                Nivel2Intermedio  juego2 = new Nivel2Intermedio (); // objeto de la clase applet
                juego2.setSize(800,600);// tamaño del juego
                juego2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// para cerrar 
                //juego
                juego2.setVisible(true); // para que se vea el juego
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
        
        if (booInstrucciones) {
       //    System.out.println("sal");
            URL urlImagenAyuda = this.getClass().getResource("Instrucciones Planeta1/Sprites_Videojuego.jpg");
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
           if (icoPlaneta1 != null && icoPlaneta2 != null && icoPlaneta3 != null && icoNave != null) {
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
                g.drawImage(icoNave.getImagen(), icoNave.getX(),
                    icoNave.getY(), this);
                
                g.drawImage(icoFlecha.getImagen(), icoFlecha.getX(), 
                        icoFlecha.getY(), this);
            }
        }
           
    }
}
