package frames;

import controle.Filtros;
import controle.ConverteMatToImage;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author YU7
 */
public class FrmWebCam extends javax.swing.JDialog {

    ConverteMatToImage proc;
    VideoCapture video;

    private Mat frameCaptura;
    private Mat matImg;
    private boolean confirma = false;

    public FrmWebCam(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        proc = new ConverteMatToImage();
        frameCaptura = new Mat();
        video = new VideoCapture(0);

//     video.set(Videoio.CAP_PROP_FRAME_WIDTH, 320);
//     video.set(Videoio.CAP_PROP_FRAME_HEIGHT, 240);

        new Thread(() -> {
            if (video.isOpened()) {
                BufferedImage tempImage;
                while (true) {
                    video.read(frameCaptura);
                    if (!frameCaptura.empty()) {
                        tempImage = proc.converteMatImage(frameCaptura);
//                      ImageIcon imageIcon = new ImageIcon(new Filtros().binarizar(tempImage, 50));
                        ImageIcon imageIcon = new ImageIcon(tempImage);
                        lbCam.setIcon(imageIcon);
                    } else {
                        JOptionPane.showMessageDialog(null, "-- Quadro (Frame) não capturado --");
                        break;
                    }
                }
            } else {
                System.out.println("Não foi possível abrir captura de video");
            }
        }).start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btCapturar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        painelCam = new javax.swing.JPanel();
        lbCam = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Captura Imagem OPENCV");
        setMinimumSize(new java.awt.Dimension(660, 560));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btCapturar.setText("Capturar");
        btCapturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapturarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, 0, 381, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCapturar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btCapturar)
                .addComponent(btSair)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        painelCam.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbCam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout painelCamLayout = new javax.swing.GroupLayout(painelCam);
        painelCam.setLayout(painelCamLayout);
        painelCamLayout.setHorizontalGroup(
            painelCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbCam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelCamLayout.setVerticalGroup(
            painelCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbCam, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelCam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelCam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapturarActionPerformed
        // TODO add your handling code here:

        setConfirma(true);
        setMatImg(frameCaptura);
        video = null;
        this.dispose();

    }//GEN-LAST:event_btCapturarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:

        this.dispose();

    }//GEN-LAST:event_btSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCapturar;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCam;
    private javax.swing.JPanel painelCam;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the confirma
     */
    public boolean isConfirma() {
        return confirma;
    }

    /**
     * @param confirma the confirma to set
     */
    public void setConfirma(boolean confirma) {
        this.confirma = confirma;
    }

    /**
     * @return the matImg
     */
    public Mat getMatImg() {
        return matImg;
    }

    /**
     * @param matImg the matImg to set
     */
    public void setMatImg(Mat matImg) {
        this.matImg = matImg;
    }

}
