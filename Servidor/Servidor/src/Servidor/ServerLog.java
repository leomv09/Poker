/*
 * Instituto Tecnológico de Costa Rica
 * Escuela de Ingeniería en Computación
 * Lenguajes de Programación
 * Casa de Apuestas de Eddy
 */

package Servidor;

import comandos.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ventana del servidor donde se va a ir mostrando la 
 * actividad del servidor de la aplicación
 * @author  kortega
 */
public class ServerLog extends javax.swing.JFrame {

    /**
     * Atributo para ir manejando la acción del servidor.
     */
    Servidor servidor;
    //Constructor
    /**
     * Crea una nueva instancia de la ventana
     */
    public ServerLog() {
        initComponents();
        // se instancia el servidor y se pasa como
        // referencia la ventana
        servidor = Servidor.getInstance();
        servidor.asignarVentana(this);
        this.getContentPane().setBackground(new Color(18,30,49));
        this.txaMensajes.setEditable(false);
        this.txaMensajes.setBackground(new Color(18,30,49));
        this.txaMensajes.setForeground(Color.WHITE);
        
        this.txaMesas.setEditable(false);
        this.txaMesas.setBackground(new Color(18,30,49));
        this.txaMesas.setForeground(Color.WHITE);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setTitle("Casa de apuestas de Eddy");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txaMensajes = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaMesas = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor");
        setBackground(new java.awt.Color(18, 30, 49));

        txaMensajes.setColumns(20);
        txaMensajes.setRows(5);
        txaMensajes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(txaMensajes);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mesas activas");

        txaMesas.setColumns(20);
        txaMesas.setRows(5);
        jScrollPane2.setViewportView(txaMesas);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bítacora de eventos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleName("Mesas activas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
                String comando = "String";
                String argumentos = "";
                Object comAEjecutar;
        try {
             comAEjecutar = Class.forName(comando).newInstance();
             System.out.println(comAEjecutar.getClass());
        } catch (ClassNotFoundException |InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ServerLog.class.getName()).log(Level.SEVERE, null, ex);
        }
                
//        ServerLog ventana = new ServerLog();
//        ventana.setVisible(true);
//        ventana.post(".::Servidor Iniciado::.");
    }
    
    /**
     * Escribe en el area de texto.
     * @param texto 
     */
    public void post(String texto){
        txaMensajes.append(texto+"\n");
        txaMensajes.setCaretPosition(txaMensajes.getDocument().getLength());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txaMensajes;
    private javax.swing.JTextArea txaMesas;
    // End of variables declaration//GEN-END:variables

}