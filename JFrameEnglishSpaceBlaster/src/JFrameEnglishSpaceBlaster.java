
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

public class JFrameEnglishSpaceBlaster extends JFrame implements Runnable, MouseListener, MouseMotionListener {
    
    private int iDireccion; // variable para manejar la direccion
    private int iIncX; //variable para manejar la posicion x
    private int iIncY; // variable para manejar la posicion y
    private int iVidas; // variable para manejar las vidas
    private int iScore; // variable para manejar el puntaje
    private int WIDTH;
    private int HEIGHT;
    private Image imaDBImage; // variable para la imagen de fondo
    private Image imaGameOver; // imagen para el game over
    private Image imaPaused; // imagen para cuando se pausa el juego
    private Graphics graDbg;
    private SoundClip souSonido;
    // agregar al diagrama
    private Iconos icoBasic; // planeta del nivel basico
    private Iconos icoInter; // planeta del nivel intermedio
    private Iconos icoFinal; // planeta del nivel Avanzado
    private Iconos icoInstrucciones; //boton de instrucciones
    private Iconos icoStart; // boton para iniciar
    private Iconos icoContinuar; // boton para continuar un juego ya guardado
    private Iconos icoSonido; // boton para configurar sonido
    private Iconos icoCredits; // boton para ver creditos
    private Iconos icoSalir; // boton para salir
    private Iconos icoHome; // imagen para regresar al menu
    private boolean booHome; //booleana para saber cuando esta en home o no
    private boolean booInstrucciones; // booleana para ver instrucciones
    private boolean booCredits; // boleana para ver los creditos
    private boolean booStart; // booleana para ver niveles
    private boolean booSonido; // booleana para configuraciones de sonido
    private boolean booPlanetas; //booleana para los planetas
    private boolean booIntermedio; // boleana para ver habilidad
    private boolean booBasico; // booleana para ver el nivel de habilidad
    private boolean booFinal; // booleana para ver el nivel final de habilidad
    private Iconos icoPlaneta1; // icono para nivel 1
    private Iconos icoPlaneta2; // icono para nivel 2
    private Iconos icoPlaneta3; // icono para nivel 3
    private Iconos icoPlaneta4; // icono para nivel 4
    /** 
     * AppletExamen
     * 
     * Metodo constructor que llama a las clases init y start para que pueda
     * correr el juego
     * 
     */ 
    public JFrameEnglishSpaceBlaster() {
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
        
        // inicializa la boleana de home
        booHome = false;
        
        // inicializa la boleana de instrucciones
        booInstrucciones = false;
        
        // inicializa la boleana de  Start
        booStart = false;
        
        //inicialiaz la booleana de Planetas
        booPlanetas = false;
        
        // inicializa la booleana en falso
        booCredits = false;
        
        //inicializa la booleana en falso
        booBasico = false;
        
        //inicializa la booleana en falso
        booIntermedio = false;
        
        //inicializa la booleana en falso
        booFinal = false;
        
        // creo imagen de home
        URL urlImagenHome = this.getClass().getResource("Instrucciones/home.png");
        // se crea la imagen de home
        icoHome = new Iconos(30,50,
                Toolkit.getDefaultToolkit().getImage(urlImagenHome));
        
        // creo imagen de planeta basico
        URL urlImagenBasico = this.getClass().getResource("Niveles/basic.png");
        // se crea la imagen de basico
        icoBasic = new Iconos(300,50,
                Toolkit.getDefaultToolkit().getImage(urlImagenBasico));
        
         // creo imagen de planeta inter
        URL urlImagenInter = this.getClass().getResource("Niveles/inter.png");
        // se crea la imagen de inter
        icoInter = new Iconos(50,300,
                Toolkit.getDefaultToolkit().getImage(urlImagenInter));
        
         // creo imagen de planeta final
        URL urlImagenAvanzado = this.getClass().getResource("Niveles/final.png");
        // se crea la imagen de final
        icoFinal = new Iconos(500,300,
                Toolkit.getDefaultToolkit().getImage(urlImagenAvanzado));
        
        
        // se crea la imagen nave
        URL urlImagenNave = this.getClass().getResource("inicio/Nave.png");
        
        // se crea de Instrucciones 
	icoInstrucciones = new Iconos(260,260,
                Toolkit.getDefaultToolkit().getImage(urlImagenNave));
        
        // se crea el objeto de star
        icoStart = new Iconos(485,315,
                Toolkit.getDefaultToolkit().getImage(urlImagenNave));
        
        // se crea el objeto de Continuar
        icoContinuar = new Iconos(230,365,
                Toolkit.getDefaultToolkit().getImage(urlImagenNave));
        
        // se crea el objeto de Sonido
        icoSonido = new Iconos(490,410,
                Toolkit.getDefaultToolkit().getImage(urlImagenNave));
        
        // se crea el objeto de Creditos
        icoCredits = new Iconos(285,465,
                Toolkit.getDefaultToolkit().getImage(urlImagenNave));
        
        // se crea la imagen nave
        URL urlImagenPlaneta1 = this.getClass().getResource("Planetas/planet_1.png");
         // se crea el objeto de Planeta1
        icoPlaneta1 = new Iconos(200,55,
                Toolkit.getDefaultToolkit().getImage(urlImagenPlaneta1));
        
        // se crea la imagen nave
        URL urlImagenPlaneta2 = this.getClass().getResource("Planetas/planet_2.png");
         // se crea el objeto de Planeta1
        icoPlaneta2 = new Iconos(460,55,
                Toolkit.getDefaultToolkit().getImage(urlImagenPlaneta2));
        
        // se crea la imagen nave
        URL urlImagenPlaneta3 = this.getClass().getResource("Planetas/planet_3.png");
         // se crea el objeto de Planeta3
        icoPlaneta3 = new Iconos(50,300,
                Toolkit.getDefaultToolkit().getImage(urlImagenPlaneta3));
        
        // se crea la imagen nave
        URL urlImagenPlaneta4 = this.getClass().getResource("Planetas/planet_4.png");
         // se crea el objeto de Planeta1
        icoPlaneta4 = new Iconos(460,360,
                Toolkit.getDefaultToolkit().getImage(urlImagenPlaneta4));
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
            if( !booHome || !booInstrucciones || !booStart){
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
    public void mouseClicked(MouseEvent mouEvent) {
        if (icoInstrucciones.colisiona(mouEvent.getX(), mouEvent.getY())) {
           // System.out.println("entra");
            booInstrucciones = true;
            booHome = true;
            booStart = false;
        }
        else if (icoStart.colisiona(mouEvent.getX(), mouEvent.getY())) {
            //System.out.println("entra");
            booStart = true;
            booHome = true;
            booInstrucciones = false;
        }
        else if (icoCredits.colisiona(mouEvent.getX(), mouEvent.getY())){
            booCredits = true;
            booHome = true;
            booStart = booInstrucciones = false;
        }
        else if(icoHome.colisiona(mouEvent.getX(), mouEvent.getY())){
            booHome = false;
            booPlanetas = false;
        }
        else if(icoBasic.colisiona(mouEvent.getX(), mouEvent.getY())){
            booPlanetas = true;
            booBasico = true;
        }
        else if(icoInter.colisiona(mouEvent.getX(), mouEvent.getY())){
            booPlanetas = true;
            booIntermedio = true;
        }
        else if(icoFinal.colisiona(mouEvent.getX(), mouEvent.getY())){
            booPlanetas = true;
            booFinal = true;
        }
        else if (icoPlaneta1.colisiona(mouEvent.getX(), mouEvent.getY())) {
            if (booBasico) {
                //  System.out.println("entra");
                Nivel1  juego1 = new Nivel1 (); // objeto de la clase applet
                juego1.setSize(800,600);// tamaño del juego
                juego1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// para cerrar 
                //juego
                juego1.setVisible(true); // para que se vea el juego
            }
            else if(booIntermedio){
                //  System.out.println("entra");
                Nivel1Intermedio  juego1 = new Nivel1Intermedio (); // objeto de la clase applet
                juego1.setSize(800,600);// tamaño del juego
                juego1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// para cerrar 
                //juego
                juego1.setVisible(true); // para que se vea el juego
            }
            else if(booFinal){
                //  System.out.println("entra");
                Nivel1Final  juego1 = new Nivel1Final (); // objeto de la clase applet
                juego1.setSize(800,600);// tamaño del juego
                juego1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// para cerrar 
                //juego
                juego1.setVisible(true); // para que se vea el juego
            }
        }
        else if (icoPlaneta2.colisiona(mouEvent.getX(), mouEvent.getY())) {
            if (booBasico) {
                //  System.out.println("entra");
                Nivel2  juego2 = new Nivel2 (); // objeto de la clase applet
                juego2.setSize(800,600);// tamaño del juego
                juego2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// para cerrar 
                //juego
                juego2.setVisible(true); // para que se vea el juego
            }
            else if(booIntermedio){
                //  System.out.println("entra");
                Nivel2Intermedio  juego2 = new Nivel2Intermedio (); // objeto de la clase applet
                juego2.setSize(800,600);// tamaño del juego
                juego2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// para cerrar 
                //juego
                juego2.setVisible(true); // para que se vea el juego
            }
            else if(booFinal){
                //  System.out.println("entra");
                Nivel2Final  juego2 = new Nivel2Final (); // objeto de la clase applet
                juego2.setSize(800,600);// tamaño del juego
                juego2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// para cerrar 
                //juego
                juego2.setVisible(true); // para que se vea el juego
            }
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
        URL urlImagenFondo = this.getClass().getResource("Inicio/inicio.jpg");
        Image imaImagenFondo = Toolkit.getDefaultToolkit().
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
        if (booHome) {
            if(booInstrucciones){
                //System.out.println("sal");
                URL urlImagenAyuda = this.getClass().getResource("Instrucciones/instruccionesbg.jpg");
                Image imaImagenJuego = Toolkit.getDefaultToolkit().
                                    getImage(urlImagenAyuda);
                graDbg.drawImage(imaImagenJuego, 0, 0,
                    getWidth(), getHeight(), this);
            }
            else if(booStart){
                //System.out.println("sal");
                URL urlImagenAyuda = this.getClass().getResource("Niveles/background.jpg");
                Image imaImagenJuego = Toolkit.getDefaultToolkit().
                                    getImage(urlImagenAyuda);
                graDbg.drawImage(imaImagenJuego, 0, 0,
                    getWidth(), getHeight(), this);
                
                // Dibuja la imagen de planeta basico
                g.drawImage(icoBasic.getImagen(), icoBasic.getX(), 
                        icoBasic.getY(), this);
                
                // Dibuja la imagen de planeta inter
                g.drawImage(icoInter.getImagen(), icoInter.getX(), 
                        icoInter.getY(), this);
                
                // Dibuja la imagen de planeta avanzado
                g.drawImage(icoFinal.getImagen(), icoFinal.getX(),
                        icoFinal.getY(), this);
                
                if(booPlanetas){
                    URL urlImagenPlanetas = this.getClass().getResource("Planetas/background.jpg");
                        Image imaImagenPlanetas = Toolkit.getDefaultToolkit().
                                    getImage(urlImagenPlanetas);
                    graDbg.drawImage(imaImagenPlanetas, 0, 0,
                    getWidth(), getHeight(), this);
                    
                     // Dibuja la imagen de planeta 1
                    g.drawImage(icoPlaneta1.getImagen(), icoPlaneta1.getX(),
                        icoPlaneta1.getY(), this);
                    
                    // Dibuja la imagen de planeta 2
                    g.drawImage(icoPlaneta2.getImagen(), icoPlaneta2.getX(),
                        icoPlaneta2.getY(), this);
                    
                    // Dibuja la imagen de planeta 3
                    g.drawImage(icoPlaneta3.getImagen(), icoPlaneta3.getX(),
                        icoPlaneta3.getY(), this);
                    
                    // Dibuja la imagen de planeta 4
                    g.drawImage(icoPlaneta4.getImagen(), icoPlaneta4.getX(),
                        icoPlaneta4.getY(), this);
                }
            }
            else if(booCredits){
                //System.out.println("sal");
                URL urlImagenAyuda = this.getClass().getResource("Credits/Sprites_Videojuego.jpg");
                Image imaImagenJuego = Toolkit.getDefaultToolkit().
                                    getImage(urlImagenAyuda);
                graDbg.drawImage(imaImagenJuego, 0, 0,
                    getWidth(), getHeight(), this);
            }
          
            
            // Dibuja la imagend e home en la posicion actualizada
            g.drawImage(icoHome.getImagen(), icoHome.getX(), icoHome.getY(), 
                    this);
        }
        else{
            if (icoInstrucciones != null && icoStart != null && icoContinuar != null && icoSonido != null && icoCredits != null) {
            //Dibuja la imagen de Instrucciones en la posicion actualizada
                g.drawImage(icoInstrucciones.getImagen(), icoInstrucciones.getX(),
                        icoInstrucciones.getY(), this);
                
            //Dibuja la imagen de start en la posicion actualizada
                g.drawImage(icoStart.getImagen(), icoStart.getX(),
                        icoStart.getY(), this);
                
            //Dibuja la imagen de continuar en la posicion actualizada
                g.drawImage(icoContinuar.getImagen(), icoContinuar.getX(),
                        icoContinuar.getY(), this);
            //Dibuja la imagen de sonido en la posicion actualizada
                g.drawImage(icoSonido.getImagen(), icoSonido.getX(),
                        icoSonido.getY(), this);
            //Dibuja la imagen de creditos en la posicion actualizada
                g.drawImage(icoCredits.getImagen(), icoCredits.getX(),
                        icoCredits.getY(), this);
            }
            
        }  
    }
}
