package aplicacion.corredores.vista;

import aplicacion.corredores.controlador.GestionAplicacion;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mdlaf.MaterialLookAndFeel;
import mdlaf.utils.MaterialColors;
import org.openide.util.Exceptions;

/**
 * @author migue
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private GestionAplicacion gestion;
    private int minutos = 2;
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonGestionCarreras;
    private javax.swing.JButton jButtonGestionCorredores;
    private javax.swing.JLabel jLabelTituloAplicacion;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPPantallaPrincipal;

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {

        initComponents();
        this.setLocationRelativeTo(null);
        this.gestion = new GestionAplicacion();
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
            UIManager.put("Button.background", MaterialColors.BLUE_GRAY_500);
            UIManager.put("Button.foreground", MaterialColors.WHITE);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException ex) {
            Exceptions.printStackTrace(ex);
        }
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                gestion.GuardarCsvCarreras();
                gestion.GuardarCsvCorredores();
                try {
                    gestion.grabar();
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        });

        Handler handler = new Handler() {
            @Override
            public void publish(LogRecord record) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void flush() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void close() throws SecurityException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Timer timer = new Timer();
        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    gestion.grabar();
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        };

        timer.schedule(myTask, 0, minutos * 60000);
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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Locale.setDefault(new Locale("es", "ES"));
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jPPantallaPrincipal = new javax.swing.JPanel();
        jLabelTituloAplicacion = new javax.swing.JLabel();
        jButtonGestionCorredores = new javax.swing.JButton();
        jButtonGestionCarreras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulario Alta Corredor");
        setMaximumSize(new java.awt.Dimension(21474836, 21474836));
        setMinimumSize(new java.awt.Dimension(500, 300));

        jPPantallaPrincipal.setToolTipText("");
        jPPantallaPrincipal.setMaximumSize(new java.awt.Dimension(3276, 3276));

        jLabelTituloAplicacion.setFont(new java.awt.Font("Dialog", 2, 36)); // NOI18N
        jLabelTituloAplicacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloAplicacion.setText("Aplicacion para gestionar corredores y carreras");

        jButtonGestionCorredores.setText("Gestionar Corredores");
        jButtonGestionCorredores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionCorredoresActionPerformed(evt);
            }
        });

        jButtonGestionCarreras.setText("Gestionar Carreras");
        jButtonGestionCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionCarrerasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPPantallaPrincipalLayout = new javax.swing.GroupLayout(jPPantallaPrincipal);
        jPPantallaPrincipal.setLayout(jPPantallaPrincipalLayout);
        jPPantallaPrincipalLayout.setHorizontalGroup(
                jPPantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPPantallaPrincipalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPPantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTituloAplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPantallaPrincipalLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButtonGestionCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(jPPantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPPantallaPrincipalLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jButtonGestionCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(566, Short.MAX_VALUE)))
        );
        jPPantallaPrincipalLayout.setVerticalGroup(
                jPPantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPPantallaPrincipalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTituloAplicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonGestionCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(106, Short.MAX_VALUE))
                        .addGroup(jPPantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPPantallaPrincipalLayout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(jButtonGestionCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(96, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPPantallaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPPantallaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGestionCorredoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionCorredoresActionPerformed
        jDCorredores dialogCorredores = new jDCorredores(this, rootPaneCheckingEnabled, gestion);
        dialogCorredores.setVisible(true);
    }//GEN-LAST:event_jButtonGestionCorredoresActionPerformed

    private void jButtonGestionCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionCarrerasActionPerformed
        jDCarreras dialogCarreras = new jDCarreras(this, rootPaneCheckingEnabled, gestion);
        dialogCarreras.setVisible(true);
    }//GEN-LAST:event_jButtonGestionCarrerasActionPerformed
    // End of variables declaration                   

    /* private void pintarTablaCorredores() {
        ArrayList<Corredor> corredores = gestion.getCorredores();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("DNI");
        model.addColumn("Fecha Nacimiento");
        model.addColumn("Direccion");
        model.addColumn("Numero Telefono");
        for (int i = 0; i < corredores.size(); i++) {
            String nombre = corredores.get(i).getNombre();
            String dni = corredores.get(i).getDni();
            String fecha = sdf.format(corredores.get(i).getFechaNacimiento());
            String direccion = corredores.get(i).getDireccion();
            int telefono = corredores.get(i).getTelefono();

            Object[] datosCorredor = {nombre, dni, fecha, direccion, telefono};

            model.addRow(datosCorredor);
        }
        jTableCorredores.setModel(model);
    }*/
}
