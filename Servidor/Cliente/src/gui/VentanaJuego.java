package gui;

import cliente.Cliente;
import comandos.ComandoFinalPartida;
import comandos.ComandoGraficarApuestas;
import comandos.ComandoGraficarCartas;
import comandos.ComandoSolicitarApuesta;
import comandos.ComandoSolicitarCambioCarta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * Clase que corre la ventana principal del juego.
 */
public class VentanaJuego extends javax.swing.JFrame {

    private int cantIgualar;//Cantidad a igualar en las apuestas.
    
    public VentanaJuego()
    {
        initComponents();
        
        for (JLabel label : this.getCartasMesa())
        {
            label.setVisible(false);
        }
        for (JLabel label : this.getCartasJugador())
        {
            label.setVisible(false);
        }
        
        //Se agregan los comandos relacionados con la ventana de juego.
        Cliente.getInstance().getsocketCliente().putComando("graficarApuestas", new ComandoGraficarApuestas(this));
        Cliente.getInstance().getsocketCliente().putComando("graficarCartas", new ComandoGraficarCartas(this));
        Cliente.getInstance().getsocketCliente().putComando("solicitarApuesta", new ComandoSolicitarApuesta(this));
        Cliente.getInstance().getsocketCliente().putComando("solicitarCarta", new ComandoSolicitarCambioCarta(this));
        Cliente.getInstance().getsocketCliente().putComando(ComandoFinalPartida.COMANDO, new ComandoFinalPartida(this));
    }
    
    public List<Integer> cambiarCartas()
    {
        DialogoCambiarCarta dialog = new DialogoCambiarCarta(this, true);
        dialog.establecerCartas(this.getCartasJugador());
        dialog.setVisible(true);
        
        return dialog.obtenerCartasCambiadas();
    }
    
    public void realizarApuesta()
    {
        this.setButtonsEnabled(true);
    }
    
    
    /**
     * Método que establece la cantidad a igualar.
     * @param cant Cantidad a igualar en la apuesta.
     */
    public void setCantIgualar(int cant)
    {
        this.cantIgualar = cant;
        this.labelAIgualar.setText(Integer.toString(cant));
    }
    
    /**
     * Método que habilita el botón de cambiar cartas.
     */
    public void setCambiarCartas()
    {
        this.botonCambioCarta.setEnabled(true);
    }
    
    
    /**
     * Método que le notifica al socket cliente la apuesta.
     * @param cantidad Cantidad a apostar.
     */
    private void igualar(int cantidad)
    {
        if(Cliente.getInstance().getJugador().getDinero() - cantidad >= 0 )
        {
           ArrayList<Object> params = new ArrayList<>();
           params.add(cantidad);
           params.add(Cliente.getInstance().getidMesa());
           params.add(Cliente.getInstance().getJugador().getId());
           Cliente.getInstance().getsocketCliente().enviarComando("apostar", params);//Se envía el comando al servidor.
           Cliente.getInstance().getJugador().setDinero(Cliente.getInstance().getJugador().getDinero() - cantidad);//Se rebaja la apuesta realizada.
           this.labelFichas.setText(Integer.toString(Cliente.getInstance().getJugador().getDinero()));
        }
        else//No posee fichas para apostar.
        {
            JOptionPane.showMessageDialog(this, "No posee fichas suficientes para igualar.", "Poker", 
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public final JLabel[] getCartasMesa()
    {
        return new JLabel[] { this.cartaMesa1, this.cartaMesa2, this.cartaMesa3, this.cartaMesa4, this.cartaMesa5 };
    }

    public final JLabel[] getCartasJugador()
    {
        return new JLabel[] { this.cartaJugador1, this.cartaJugador2, this.cartaJugador3, this.cartaJugador4, this.cartaJugador5 };
    }
    
    /*
     * Método que retorna el label donde se muestra el resultado de las apuestas.
     */
    public JLabel getLabelApuestas()
    {
        return this.labelApuestas;
    }
    
    /**
     * Método que establece el texto referente a la ronda de apuestas.
     * @param ronda Mensaje que contendrá el label.
     */
    public void setRondaApuestas(String ronda)
    {
        this.labelApuestas.setText(ronda);
    }
    
    /**
     * Método que establece los sidepots en la interfaz del jugador.
     * @param pots String con los sidePots.
     */
    public void setSidePots(String pots)
    {
        this.labelSidePots.setText(pots);
    }
    
    private void setButtonsEnabled(boolean enabled)
    {
        this.botonIgualar.setEnabled(enabled);
        this.botonPasar.setEnabled(enabled);
        this.botonRetirarse.setEnabled(enabled);
    }
    
    public void notificarFinalPartida(String estado)
    {
        JOptionPane.showMessageDialog(this, estado, "Fin Partida", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonIgualar = new javax.swing.JButton();
        botonRetirarse = new javax.swing.JButton();
        botonPasar = new javax.swing.JButton();
        botonCambioCarta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelFichas = new javax.swing.JLabel();
        panelCartasMesa = new javax.swing.JPanel();
        cartaMesa1 = new javax.swing.JLabel();
        cartaMesa2 = new javax.swing.JLabel();
        cartaMesa3 = new javax.swing.JLabel();
        cartaMesa4 = new javax.swing.JLabel();
        cartaMesa5 = new javax.swing.JLabel();
        panelCartasJugador = new javax.swing.JPanel();
        cartaJugador1 = new javax.swing.JLabel();
        cartaJugador2 = new javax.swing.JLabel();
        cartaJugador3 = new javax.swing.JLabel();
        cartaJugador4 = new javax.swing.JLabel();
        cartaJugador5 = new javax.swing.JLabel();
        panelApuestas = new javax.swing.JPanel();
        labelApuestas = new javax.swing.JLabel();
        labelSidePots = new javax.swing.JLabel();
        labelIgualar = new javax.swing.JLabel();
        labelAIgualar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonIgualar.setText("Igualar");
        botonIgualar.setEnabled(false);
        botonIgualar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIgualarActionPerformed(evt);
            }
        });

        botonRetirarse.setText("Retirarse");
        botonRetirarse.setEnabled(false);
        botonRetirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRetirarseActionPerformed(evt);
            }
        });

        botonPasar.setText("Pasar");
        botonPasar.setEnabled(false);
        botonPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPasarActionPerformed(evt);
            }
        });

        botonCambioCarta.setText("Cambiar Cartas");
        botonCambioCarta.setEnabled(false);
        botonCambioCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambioCartaActionPerformed(evt);
            }
        });

        jLabel1.setText("Fichas");

        labelFichas.setText("50");

        cartaMesa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaMesa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaMesa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaMesa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaMesa5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        javax.swing.GroupLayout panelCartasMesaLayout = new javax.swing.GroupLayout(panelCartasMesa);
        panelCartasMesa.setLayout(panelCartasMesaLayout);
        panelCartasMesaLayout.setHorizontalGroup(
            panelCartasMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCartasMesaLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(cartaMesa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaMesa2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaMesa3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaMesa4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaMesa5)
                .addGap(123, 123, 123))
        );
        panelCartasMesaLayout.setVerticalGroup(
            panelCartasMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCartasMesaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCartasMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cartaMesa1)
                    .addComponent(cartaMesa2)
                    .addComponent(cartaMesa3)
                    .addComponent(cartaMesa4)
                    .addComponent(cartaMesa5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cartaJugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaJugador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaJugador3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaJugador4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        cartaJugador5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cards/B-2.png"))); // NOI18N

        javax.swing.GroupLayout panelCartasJugadorLayout = new javax.swing.GroupLayout(panelCartasJugador);
        panelCartasJugador.setLayout(panelCartasJugadorLayout);
        panelCartasJugadorLayout.setHorizontalGroup(
            panelCartasJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCartasJugadorLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(cartaJugador1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaJugador2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaJugador3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaJugador4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartaJugador5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCartasJugadorLayout.setVerticalGroup(
            panelCartasJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCartasJugadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCartasJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cartaJugador1)
                    .addComponent(cartaJugador2)
                    .addComponent(cartaJugador3)
                    .addComponent(cartaJugador4)
                    .addComponent(cartaJugador5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelApuestas.setText("Apuestas");

        labelSidePots.setText("SidePots");

        javax.swing.GroupLayout panelApuestasLayout = new javax.swing.GroupLayout(panelApuestas);
        panelApuestas.setLayout(panelApuestasLayout);
        panelApuestasLayout.setHorizontalGroup(
            panelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelApuestasLayout.createSequentialGroup()
                .addGroup(panelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelApuestas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSidePots, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelApuestasLayout.setVerticalGroup(
            panelApuestasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelApuestasLayout.createSequentialGroup()
                .addComponent(labelApuestas, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelSidePots, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
        );

        labelIgualar.setText("Monto a igualar:");

        labelAIgualar.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCartasMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelCartasJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelApuestas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelFichas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(botonPasar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonRetirarse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonIgualar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCambioCarta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelIgualar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAIgualar)))
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonIgualar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonPasar)
                        .addGap(5, 5, 5)
                        .addComponent(botonRetirarse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCambioCarta)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labelFichas)))
                    .addComponent(panelApuestas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIgualar)
                    .addComponent(labelAIgualar))
                .addGap(8, 8, 8)
                .addComponent(panelCartasMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(panelCartasJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonIgualarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIgualarActionPerformed
       igualar(this.cantIgualar);
        this.setButtonsEnabled(false);
    }//GEN-LAST:event_botonIgualarActionPerformed

    private void botonPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPasarActionPerformed
        igualar(0);//No se apuesta nada. Verificar en serividor-> si apuesta es == 0 es que pasa.
        this.setButtonsEnabled(false);
    }//GEN-LAST:event_botonPasarActionPerformed

    private void botonRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRetirarseActionPerformed
        this.setButtonsEnabled(false);
    }//GEN-LAST:event_botonRetirarseActionPerformed

    private void botonCambioCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambioCartaActionPerformed
        List<Integer> cartasCambiar = cambiarCartas();//Se obtienen las cartas a cambiar.
        Cliente.getInstance().getsocketCliente().enviarComando("cambiarCarta", cartasCambiar);//Se le notifica al servidor las cartas a cambiar.
    }//GEN-LAST:event_botonCambioCartaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCambioCarta;
    private javax.swing.JButton botonIgualar;
    private javax.swing.JButton botonPasar;
    private javax.swing.JButton botonRetirarse;
    private javax.swing.JLabel cartaJugador1;
    private javax.swing.JLabel cartaJugador2;
    private javax.swing.JLabel cartaJugador3;
    private javax.swing.JLabel cartaJugador4;
    private javax.swing.JLabel cartaJugador5;
    private javax.swing.JLabel cartaMesa1;
    private javax.swing.JLabel cartaMesa2;
    private javax.swing.JLabel cartaMesa3;
    private javax.swing.JLabel cartaMesa4;
    private javax.swing.JLabel cartaMesa5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelAIgualar;
    private javax.swing.JLabel labelApuestas;
    private javax.swing.JLabel labelFichas;
    private javax.swing.JLabel labelIgualar;
    private javax.swing.JLabel labelSidePots;
    private javax.swing.JPanel panelApuestas;
    private javax.swing.JPanel panelCartasJugador;
    private javax.swing.JPanel panelCartasMesa;
    // End of variables declaration//GEN-END:variables
}
