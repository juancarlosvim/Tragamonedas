
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JuanCarlosVim
 */




//Creamos una classe TimerTask. Esto nos permite ejuecutar un proceso cuando queramos.
class Tiempo extends TimerTask {
    
    public int i = 0;
    
    public int numeroFotos;
    public Gráficos graficos;
    public ArrayList<ImageIcon> listII;
    public int numeroQuePare;
    public int numeroEjecuciones;
    public int numeroLabel;
    public boolean terminado;
    
    Tiempo(Gráficos graficos, ArrayList<ImageIcon> listII, int numeroLabel, int numeroQuepare) {
        this.numeroFotos = listII.size();
        this.graficos = graficos;
        this.listII = listII;
        this.numeroEjecuciones = 0;
        this.numeroQuePare = numeroQuepare;
        this.numeroLabel = numeroLabel;
    }
    public void run(){ 
        if (numeroEjecuciones == numeroQuePare){
            
            switch(numeroLabel){
                case 1:
                    graficos.terminado1 = true;
                    break;
                case 2:
                    graficos.terminado2 = true;
                    break;
                case 3: 
                    graficos.terminado3 = true;
                    break;
            }
            
            this.cancel(); // para parar el proceso
           
            
        }  
        if (i < numeroFotos -1){
            i++; //si es la ultima imagen que pinte la primera
        } else {
            i = 0;
        }
        switch(numeroLabel){
            case 1:
                graficos.setLabelImagen1(listII.get(i));
                break;
            case 2:
                graficos.setLabelImagen2(listII.get(i));
                break;
            case 3:
                graficos.setLabelImagen3(listII.get(i));
        }
        
        numeroEjecuciones++;
    }
}


public class Gráficos extends javax.swing.JFrame {
private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Creates new form Gráficos
     */
    
    private double saldo;
    private Double restarSaldo;
    private Saldo sal = new Saldo();
    private int numero1 =7, numero2=7, numero3=7;
    private int numeroAleatorio;
    Random rand = new Random();
    
    public boolean terminado1 = false;
    public boolean terminado2 = false;
    public boolean terminado3 = false;
    
    public boolean sw = false;
     SaldoMaquina saldoMaquina; //objeto de saldo maquina
    DataOutputStream fsalida; // para grabar fichero
    DataInputStream fentrada; //para leer fichero
    String input;
    
    

    
    private ArrayList<ImageIcon> imagenes = new ArrayList<ImageIcon>();
    
  
    public Gráficos() {
        initComponents();
        cargarImagenes(); //primero llamo al metodo cargarImagenes para que se añada al array list
        limpiar();
        colocarImagenes(); // cargan las primeras imagenes del arraylist de imagenes
        setIconImage(new ImageIcon(getClass().getResource("images/Coin.png")).getImage());
        
    }
    
    public void limpiar(){
        lblImagen1.setText("");
        lblImagen2.setText("");
        lblImagen3.setText("");
        lblInfo.setVisible(false);
    }
    public void limpiarlblInfo(){
        lblInfo.setVisible(false);
    }
    
    public void colocarImagenes(){
        
        
        //numeroAleatorio = rand.nextInt(imagenes.size());
        
        lblImagen1.setIcon(imagenes.get(1));
        lblImagen2.setIcon(imagenes.get(1));
        lblImagen3.setIcon(imagenes.get(1));
        
        
    }
    
   
    
    
    public void GenerarNumeros(){ 
        
        
       
        
        if(cbGanarSiempre.isSelected()==true){
            int ganar = rand.nextInt(4); // genero numeros entre 0 y 3 
            
            numero1 = rand.nextInt(imagenes.size());
            
            if(ganar==0){
                numero2 = numero1;
                numero3 = numero1;
            }else if(ganar ==1){
                numero2 = numero1;
                numero3 = numero1;
            }else if(ganar==2){
                 numero2 = numero1;
                numero3 = numero1;
            }else{
                if(numero1>=0){
                    numero2 = numero1 +1;
                    numero3 = numero1 +1;
                }if(numero1 == imagenes.size()-1){
                    numero2 = numero1 -1;
                    numero3 = numero1-1;
                }
            }
        }else{ 
            numero1 = rand.nextInt(imagenes.size());
            numero2 = rand.nextInt(imagenes.size());
            numero3 = rand.nextInt(imagenes.size());
        }
        
        ColocarImagen(numero1, numero2, numero3); //llamo a la funcion para coger imagenes de los numeros de azar
        
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        cbGanarSiempre = new javax.swing.JCheckBox();
        lblImagen3 = new javax.swing.JLabel();
        lblImagen2 = new javax.swing.JLabel();
        lblImagen1 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        lblSaldo = new javax.swing.JLabel();
        txtApuesta = new javax.swing.JTextField();
        lblApuesta = new javax.swing.JLabel();
        btnPulsar = new javax.swing.JButton();
        btnRetirarSaldo = new javax.swing.JButton();
        lblSaldoMaquina = new javax.swing.JLabel();
        txtSaldoMaquina = new javax.swing.JTextField();
        btnIngresarSaldoMaquina = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmAcercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TragaMonedas");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        lblInfo.setBackground(new java.awt.Color(51, 0, 204));
        lblInfo.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(255, 255, 0));
        lblInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lblInfo.setOpaque(true);

        cbGanarSiempre.setText("Ganar Siempre");

        lblImagen3.setText("Imagen 3");
        lblImagen3.setBorder(new javax.swing.border.MatteBorder(null));

        lblImagen2.setText("Imagen 2");
        lblImagen2.setBorder(new javax.swing.border.MatteBorder(null));

        lblImagen1.setText("Imagen 1");
        lblImagen1.setBorder(new javax.swing.border.MatteBorder(null));

        txtSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActionPerformed(evt);
            }
        });

        lblSaldo.setText("Saldo:");

        lblApuesta.setText("Apuesta:");

        btnPulsar.setText("Pulsar");
        btnPulsar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPulsarActionPerformed(evt);
            }
        });

        btnRetirarSaldo.setText("Retirar premio");
        btnRetirarSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarSaldoActionPerformed(evt);
            }
        });

        lblSaldoMaquina.setText("Saldo Máquina:");

        txtSaldoMaquina.setEditable(false);

        btnIngresarSaldoMaquina.setText("Ingresar Saldo Máquina");
        btnIngresarSaldoMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarSaldoMaquinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbGanarSiempre)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIngresarSaldoMaquina)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblSaldo)
                                            .addComponent(lblApuesta))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtApuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                            .addComponent(txtSaldo))
                                        .addGap(368, 368, 368))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(lblImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(lblImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(192, 192, 192))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnPulsar, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                            .addComponent(btnRetirarSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(49, 49, 49))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSaldoMaquina)
                                .addGap(18, 18, 18)
                                .addComponent(txtSaldoMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cbGanarSiempre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnIngresarSaldoMaquina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldoMaquina)
                    .addComponent(txtSaldoMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPulsar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaldo))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApuesta))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRetirarSaldo)
                        .addGap(20, 20, 20))))
        );

        jMenu1.setText("Archivo");

        jmSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmSalir.setText("Salir");
        jmSalir.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jmSalirMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jmSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jmAcercade.setText("Acerca de");
        jmAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAcercadeActionPerformed(evt);
            }
        });
        jMenu2.add(jmAcercade);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
     public void comprobar(){//la funcion comprobar hará que si coincide las imagenes ganaras tanto
        
            limpiarlblInfo(); //limpiar label
            if(( "".equals(txtSaldo.getText()) ) && ("".equals(txtApuesta.getText()) )){
                JOptionPane.showMessageDialog(null, "No has introducido saldo");
                JOptionPane.showMessageDialog(null, "No has introducido saldo en apuesta");
            }else if((Double.valueOf(txtSaldo.getText())<=0) ||(Double.valueOf(txtApuesta.getText())<=0) || (Double.valueOf(txtSaldoMaquina.getText())<=0)){
                JOptionPane.showMessageDialog(null, "El saldo es insuficiente");
            }else{
                
                
                //if(terminado1==true && terminado2==true && terminado3 == true){
                    
                     //GenerarNumeros(); //genero las tres imagenes aleatorias
                 saldo = Double.valueOf(txtSaldo.getText());
                 Double saldoApuesta = Double.valueOf(txtApuesta.getText());
                 sal = new Saldo(saldo);
                 restarSaldo = Double.valueOf(txtApuesta.getText()); // esto es el saldo apuesta
                  //System.out.println("restarSaldo => "+restarSaldo);
                    //saldo -= restarSaldo;
                   
                 if(  numero1 ==numero2 && numero2 ==numero3 ){ //cuando las tres imagenes sean iguales el premio se multiplica por 3
                
                System.out.println("Entro en el primer IF");     
                lblInfo.setVisible(true);
                lblInfo.setText(" Gran Premio! x3");
                  try {
                         
                        
                      System.out.println("LLAMO A LA FUNCION ACTUALIZARMAQUINAPREMIOTRIPLE =>"+saldoMaquina.actualizarMaquinaPremioTriple(restarSaldo));
                      fsalida.writeDouble(saldoMaquina.actualizarMaquinaPremioTriple(restarSaldo));
                     
                      System.out.println(" "+fsalida.size()); //COMPRUEBO QUE ESCRIBO EN EL FICHERO
                         leerSaldoMaquina(); // LEO FICHERO
                         System.out.println("VALOR DE SALDO MAQUINA  => "+saldoMaquina.MostrarSaldoMaquina());
                         txtSaldoMaquina.setText(""+saldoMaquina.MostrarSaldoMaquina());
                         
                        
                         
                     } catch (IOException ex) {
                         Logger.getLogger(Gráficos.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 
    
                }else if(   numero1 ==numero2 || numero2 == numero3  ){
                    System.out.println("ENTRO EN EL SEGUNDO IF");
                    lblInfo.setVisible(true);
                    lblInfo.setText("Premio! x2");
                    
                     try {

                         System.out.println("LLAMO A LA FUNCION ACTUALIZARMAQUINAPREMIODOBLE => "+saldoMaquina.actualizarMaquinaPremioDoble(restarSaldo)); //lo hace bien
                        
                          fsalida.writeDouble(saldoMaquina.actualizarMaquinaPremioDoble(restarSaldo));  //no me escribe en el fichero
 
                         System.out.println(" "+fsalida.size()); //COMPRUEBO QUE ESCRIBO EN EL FICHERO
                         leerSaldoMaquina(); // LEO FICHERO
                         System.out.println("VALOR DE SALDO MAQUINA  => "+saldoMaquina.MostrarSaldoMaquina());
                         txtSaldoMaquina.setText(""+saldoMaquina.MostrarSaldoMaquina());
                         
                         
                     } catch (IOException ex) {
                         Logger.getLogger(Gráficos.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    
                    System.out.println("RestarSaldo Vale => "+restarSaldo);
                    txtSaldo.setText(""+sal.DobleSaldo(restarSaldo));
                    //saldoMaquina.MostrarSaldoMaquina();
                    
                    
                    System.out.println("Saldo vale => "+sal.DobleSaldo(restarSaldo));

              }else{
                     try {
                        //txtSaldo.setText(""+saldo);
                        sw =false;
                        
                        sal.RestarSaldo(restarSaldo);
                        actualizarSaldoMaquina(restarSaldo,sw);
                       txtSaldo.setText(""+sal.getSaldo());
                       
                       System.out.println("Saldo => "+sal.getSaldo());
                    } catch (IOException ex) {
                        Logger.getLogger(Gráficos.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }  
                 
        }   
     
            //}
     }  
       
     
   

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        // Se introducirá el saldo :
         
         
         
       
    }//GEN-LAST:event_txtSaldoActionPerformed

    private void btnRetirarSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarSaldoActionPerformed
        // Botón retirar :
        saldo = Double.valueOf(txtSaldo.getText());
        JOptionPane.showMessageDialog(null, "Su salo para retirar es de "+saldo);
        txtSaldo.setText("");
        txtApuesta.setText("");
    }//GEN-LAST:event_btnRetirarSaldoActionPerformed

    private void btnPulsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPulsarActionPerformed
        // boton recorrer array:
       
      if( ("".equals(txtSaldo.getText())) || ("".equals(txtApuesta.getText())) || ("".equals(txtSaldoMaquina.getText())) ){
          JOptionPane.showMessageDialog(null, "No has introducido dinero, en saldo maquina, saldo y apuesta");
      }else{
            recorrerArray();
            comprobar(); 
      }
       
    }//GEN-LAST:event_btnPulsarActionPerformed

    private void btnIngresarSaldoMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarSaldoMaquinaActionPerformed
    try {
        // Boton ingresar Saldo maquina en fichero:
        IngresarSaldoMaquina();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Gráficos.class.getName()).log(Level.SEVERE, null, ex);
    }
       
        
        
    }//GEN-LAST:event_btnIngresarSaldoMaquinaActionPerformed

    private void jmSalirMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jmSalirMenuKeyPressed
        boolean teclaControl = false;
        boolean teclaAlt = false ;
        if(evt.getKeyCode() == KeyEvent.VK_CONTROL){
           teclaControl = true;
        }else if(evt.getKeyCode() == KeyEvent.VK_ALT){
            teclaAlt = true;
        }else if(teclaControl && teclaAlt && evt.getKeyCode() == KeyEvent.VK_S){
            
            //combinacion de tres teclas
           this.dispose();
        }
    }//GEN-LAST:event_jmSalirMenuKeyPressed

    private void jmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSalirActionPerformed
        // al hacer click en salir se saldra:
       this.dispose();
    }//GEN-LAST:event_jmSalirActionPerformed

    private void jmAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAcercadeActionPerformed
        // acerca de aquí llamaré a otra ventana:
        
        Informacion inf = new Informacion(this);
        inf.setVisible(true);
    }//GEN-LAST:event_jmAcercadeActionPerformed
    
    // realizar fichero
    public void IngresarSaldoMaquina() throws FileNotFoundException{
        
        try {
        //realizo esta funcion para ingresar el saldo de la mquina en un fichero

        Double saldoMaquinaAux;
        
       fsalida = new DataOutputStream(new FileOutputStream("DatosMaquina.txt"));
        
        String n2 = JOptionPane.showInputDialog(null, "Introduce el saldo a la máquina ");
        saldoMaquinaAux = Double.parseDouble(n2);
  
        //System.out.println("saldoMaquinaAux => "+saldoMaquinaAux);
        
        saldoMaquina = new SaldoMaquina(saldoMaquinaAux);
        
        saldoMaquina.grabarSaldoMaquina(fsalida);
        
        System.out.println("Tamaño del archivo de salida "+fsalida.size());
       
    } catch (IOException ex) {
        Logger.getLogger(Gráficos.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
            try {
                leerSaldoMaquina(); // una vez ingresado el dinero leemos el fichero y lo colocamos en nuestro txt
            } catch (IOException ex) {
                Logger.getLogger(Gráficos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    //leer fichero
    public void leerSaldoMaquina() throws IOException{
        
        fentrada = new DataInputStream(new FileInputStream("DatosMaquina.txt"));
        
        while(fentrada.available()>0){
            saldoMaquina.LeerSaldoMaquina(fentrada);
            //saldoMaquina.MostrarSaldoMaquina();
            
            txtSaldoMaquina.setText(""+saldoMaquina.MostrarSaldoMaquina());
        }
    }
    
    
    
    public void actualizarSaldoMaquina(double sal, boolean sw) throws IOException{
       //Intento de actualizar el saldo de la maquina cuando pierdo
       
       Double saldoActualizar = sal;
       this.sw = sw;
     
       if(this.sw==false){
           
           
        System.out.println("ENTRO EN SW FALSE");
       
        System.out.println("SaldoActualizar sw fase => "+saldoActualizar);
        fsalida.writeDouble(saldoMaquina.SumarSaldoMaquina(saldoActualizar));  
        txtSaldoMaquina.setText(""+saldoMaquina.MostrarSaldoMaquina());
        System.out.println("SALDO SW FALSE"+saldoMaquina.MostrarSaldoMaquina());
       }
       
       

       
      
   
    }
    
    public void recorrerArray(){
       GenerarNumeros();
       boolean sw = true ;
       terminado1 = false;
       terminado2 = false;
       terminado3 = false;
       Timer t1 = new Timer();
        System.out.println("num1 " + numero1 + " num2: " + numero2 + " num3: " + numero3);
        
       t1.schedule(new Tiempo(this, imagenes, 1, numero1), 0, 50);
       Timer t2 = new Timer();
       t2.schedule(new Tiempo(this, imagenes, 2, numero2), 0, 50);
       Timer t3 = new Timer();
       t3.schedule(new Tiempo(this, imagenes, 3, numero3), 0, 50);

            
    }
    
    
    //
    public void ColocarImagen(int icono1, int icono2, int icono3){
        lblImagen1.setIcon(imagenes.get(icono1));
        lblImagen2.setIcon(imagenes.get(icono2));
        lblImagen3.setIcon(imagenes.get(icono3));
    }
    
    public void cargarImagenes(){
        imagenes.add(createImageIcon("images/Banana.png", "Banana"));
        imagenes.add(createImageIcon("images/Bar.png", "Bar"));
        imagenes.add(createImageIcon("images/Bell.png", "Bell"));
        imagenes.add(createImageIcon("images/Cherry.png", "Cherry"));
        imagenes.add(createImageIcon("images/Clover.png", "Clover"));
        imagenes.add(createImageIcon("images/Diamond.png", "Diamond"));
        imagenes.add(createImageIcon("images/Plum.png", "Plum"));
        imagenes.add(createImageIcon("images/Seven.png", "Seven"));
        imagenes.add(createImageIcon("images/Watermelon.png", "Watermelon"));
    }
    
    
    public ArrayList<ImageIcon> getImagenes(){
        return imagenes;
    }
   
    
    
    public ImageIcon createImageIcon(String path, String descripcion){
        java.net.URL imgUrl = getClass().getResource(path);
        
        if(imgUrl != null){
            return new ImageIcon(imgUrl, descripcion);
        }else{
            System.err.println("No se ha podido encontrar la ruta "+path);
        }
        
        return null;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gráficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gráficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gráficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gráficos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gráficos().setVisible(true);
            }
        });
    }
    
    public void setLabelImagen1(ImageIcon param){
        lblImagen1.setIcon(param);
    }
    public void setLabelImagen2(ImageIcon param){
        lblImagen2.setIcon(param);
    }
    public void setLabelImagen3(ImageIcon param){
        lblImagen3.setIcon(param);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresarSaldoMaquina;
    private javax.swing.JButton btnPulsar;
    private javax.swing.JButton btnRetirarSaldo;
    private javax.swing.JCheckBox cbGanarSiempre;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jmAcercade;
    private javax.swing.JMenuItem jmSalir;
    private javax.swing.JLabel lblApuesta;
    private javax.swing.JLabel lblImagen1;
    private javax.swing.JLabel lblImagen2;
    private javax.swing.JLabel lblImagen3;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblSaldoMaquina;
    private javax.swing.JTextField txtApuesta;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtSaldoMaquina;
    // End of variables declaration//GEN-END:variables

   
}
