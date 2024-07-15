/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Controlls;
import Models.PackageDestinatory;

/**
 *
 * @author Carlos Fabricio
 */
public class ServerView extends javax.swing.JFrame implements Runnable {

    ArrayList<Controlls> lista2 = new ArrayList<Controlls>(); 
    
    /**
     * Creates new form ServerView
     */
    public ServerView() {
        initComponents();
        
        Thread mihilo = new Thread(this);
        mihilo.start();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaHistory = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("El Fondo Servidor");
        jLabel1.setToolTipText("");

        txaHistory.setEditable(false);
        txaHistory.setBackground(new java.awt.Color(51, 51, 51));
        txaHistory.setColumns(20);
        txaHistory.setForeground(new java.awt.Color(255, 255, 255));
        txaHistory.setRows(5);
        txaHistory.setBorder(null);
        jScrollPane1.setViewportView(txaHistory);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ServerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaHistory;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
                //System.out.println("jejejej");
        try {
            //puerto que debe abrir
            ServerSocket servidor = new ServerSocket(1024); // que esté a la escucha y abra ese puerto
            String nick,mensaje2,ip;
            ArrayList <String> listaIp4 = new ArrayList<String>();  //arrayList que alamcenará las ip conectadas
        
            PackageDestinatory paquete_recibido;
              Controlls aux = new Controlls();
                    
            while(true){   //bucle infinito que acepta las conexiones 
            Socket misocket = servidor.accept(); //que acepte las peticiones de conexion  
           
            /*...........fin de deteccion online xD*/
              //flujo de datos de entrada
            ObjectInputStream entrada =new ObjectInputStream(misocket.getInputStream()); 
            
            paquete_recibido=(PackageDestinatory) entrada.readObject();
        
            nick=paquete_recibido.getNick2();
            mensaje2=paquete_recibido.getMensaje();
            ip=paquete_recibido.getIp();
            int puertoCliente=9999;
            if(!mensaje2.equals(" Online")){
                String aux2=null;
                for(int i=0;i<lista2.size();i++){
                if(lista2.get(i).getNombrecontrol().equalsIgnoreCase(paquete_recibido.getDestinatario())){
                 aux2=lista2.get(i).getIpcontrol();
                  puertoCliente=lista2.get(i).getPuerto();
                  System.out.println("se quiere conectar con: "+puertoCliente);
                }
                }
            txaHistory.append("\n"+ nick+": "+mensaje2+"  para "+aux2);
            //ahora creamos un flujo de datos de entrada para que sea capaz de recoger los datos
                                            //socket viaja la informacion de entrada
             
            /*DataInputStream entrada = new DataInputStream(misocket.getInputStream());
            String mensaje = entrada.readUTF();
            txaHistory.append("\n"+mensaje);*/
            System.out.println(puertoCliente);
            Socket enviaDestinatario = new Socket(ip,puertoCliente);
            ObjectOutputStream reenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
            reenvio.writeObject(paquete_recibido);
                     
                     
            reenvio.close();
            enviaDestinatario.close();
            misocket.close();
            }else{  
                 /*++++++++++detección de usuarios onlines +++++
            almacenamos dentro de la variable localizacion la direccion del cliente que se conectó
            */       Controlls hola = new Controlls();
                     
                     InetAddress localizacion = misocket.getInetAddress();
                     int puerto = paquete_recibido.getPuerto();
                     String ipremota = localizacion.getHostAddress(); //almacenamos la direccion en string
                     aux.setIpcontrol(ipremota);
                     aux.setNombrecontrol(paquete_recibido.getNick2());
                     hola.setIpcontrol(ipremota);
                     hola.setNombrecontrol(nick);
                     hola.setPuerto(puerto);
                     lista2.add(hola);
                  //   lista2.add(aux);
          
                     txaHistory.append("\n------------------------------------------------------------------- -Conectado------------------------------------------------------");
                     txaHistory.append("\n"+ nick+" : ip "+ipremota +"  conectado desde el puerto "+puerto);
      
                     txaHistory.append("\n\n");
                   //  listaIp4.add(ipremota);
                     //paquete_recibido.setDirIps(listaIp4);
                     paquete_recibido.setControl(lista2);
                   
                    for(int i=0;i<lista2.size();i++){
                   // System.out.println("array: "+z);
                     Socket enviaDestinatario = new Socket(lista2.get(i).getIpcontrol(),lista2.get(i).getPuerto());
                     ObjectOutputStream reenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                      reenvio.writeObject(paquete_recibido);
                      reenvio.close();
                       enviaDestinatario.close();
                       misocket.close();
                    }
                    }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
