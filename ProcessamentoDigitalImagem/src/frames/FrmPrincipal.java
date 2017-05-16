package frames;

import controle.Filtros;
import controle.OperadoresMorfologicos;
import controle.ConverteMatToImage;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import controle.Visualizador;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Alexandre
 */
public class FrmPrincipal extends javax.swing.JFrame {

    Filtros filtro;
    ConverteMatToImage proc;
    OperadoresMorfologicos oper;

    public Mat ImgOriginal, ImgTrabalhada;
    public ImageIcon imagemIcn;

    public FrmPrincipal() {
        initComponents();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        //Altera o Tema atraves do LookAndFeel        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao aplicar TEMA\n" + ex);
        }
        
        proc = new ConverteMatToImage();
        filtro = new Filtros();
        oper = new OperadoresMorfologicos();

        ImgOriginal = Imgcodecs.imread("imagem.jpeg");
        setaImagem(ImgOriginal);

    }

    public final void setaImagem(Mat mat) {

        Image bufferedImg = proc.converteMatImage(mat);
        lbImagem.setIcon(new ImageIcon(bufferedImg));
        ImgTrabalhada = mat;

    }

    public final void operadMorfologico() {

        int size = slideMorfologico.getValue();
        lbHistograma.setText("Operador Morfologico " + size + "%");

        int shape = 0;

        if (rbRetangulo.isSelected()) {
            shape = Imgproc.CV_SHAPE_RECT;
        }
        if (rbElipse.isSelected()) {
            shape = Imgproc.CV_SHAPE_ELLIPSE;
        }
        if (rbCross.isSelected()) {
            shape = Imgproc.CV_SHAPE_CROSS;
        }

        switch (cbMorfologico.getSelectedIndex()) {
            case 0:
                setaImagem(oper.erosao(ImgOriginal, size, shape));
                break;
            case 1:
                setaImagem(oper.dilatacao(ImgOriginal, size, shape));
                break;
            case 2:
                setaImagem(oper.abertura(ImgOriginal, size, shape));
                break;
            case 3:
                setaImagem(oper.fechamento(ImgOriginal, size, shape));
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        painelControleCam = new javax.swing.JPanel();
        btCarregarImg = new javax.swing.JButton();
        btCarregarCAM = new javax.swing.JButton();
        btRestaurarImg = new javax.swing.JButton();
        btVisualizarImg = new javax.swing.JButton();
        btSalvarImg = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelControleImg = new javax.swing.JPanel();
        btEscalaCinza = new javax.swing.JButton();
        lbHistograma = new javax.swing.JLabel();
        slideMorfologico = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        cbRGB = new javax.swing.JComboBox<>();
        btSubtrair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lbDesfocar = new javax.swing.JLabel();
        rbElipse = new javax.swing.JRadioButton();
        rbRetangulo = new javax.swing.JRadioButton();
        rbCross = new javax.swing.JRadioButton();
        cbMorfologico = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        slideDesfocar = new javax.swing.JSlider();
        jSliderLimiar = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lbImagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Processamento Digital de Imagens");
        setMinimumSize(new java.awt.Dimension(811, 496));

        painelControleCam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btCarregarImg.setText("UPLOAD");
        btCarregarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCarregarImgActionPerformed(evt);
            }
        });

        btCarregarCAM.setText("WEBCAM");
        btCarregarCAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCarregarCAMActionPerformed(evt);
            }
        });

        btRestaurarImg.setText("RESTAURAR");
        btRestaurarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRestaurarImgActionPerformed(evt);
            }
        });

        btVisualizarImg.setText("VISUALIZAR");
        btVisualizarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisualizarImgActionPerformed(evt);
            }
        });

        btSalvarImg.setText("SALVAR");
        btSalvarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarImgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelControleCamLayout = new javax.swing.GroupLayout(painelControleCam);
        painelControleCam.setLayout(painelControleCamLayout);
        painelControleCamLayout.setHorizontalGroup(
            painelControleCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelControleCamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCarregarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCarregarCAM, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRestaurarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVisualizarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSalvarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelControleCamLayout.setVerticalGroup(
            painelControleCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelControleCamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelControleCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCarregarImg)
                    .addComponent(btCarregarCAM)
                    .addComponent(btRestaurarImg)
                    .addComponent(btVisualizarImg)
                    .addComponent(btSalvarImg))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelControleImg.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btEscalaCinza.setText("Escala de Cinza");
        btEscalaCinza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEscalaCinzaActionPerformed(evt);
            }
        });

        lbHistograma.setText("Operador Morfologico : ");

        slideMorfologico.setMajorTickSpacing(2);
        slideMorfologico.setMaximum(10);
        slideMorfologico.setMinorTickSpacing(1);
        slideMorfologico.setPaintLabels(true);
        slideMorfologico.setPaintTicks(true);
        slideMorfologico.setValue(0);
        slideMorfologico.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slideMorfologicoStateChanged(evt);
            }
        });

        jLabel1.setText("Subtrair RGB (BGR)");

        cbRGB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum...", "Canal 0 (Blue)", "Canal 1 (Green)", "Canal 2 (Red)" }));
        cbRGB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRGBItemStateChanged(evt);
            }
        });

        btSubtrair.setText("Subtrair");
        btSubtrair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubtrairActionPerformed(evt);
            }
        });

        lbDesfocar.setText("Desfoque : ");

        buttonGroup1.add(rbElipse);
        rbElipse.setText("Elipse");
        rbElipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbElipseActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbRetangulo);
        rbRetangulo.setSelected(true);
        rbRetangulo.setText("Retangulo");
        rbRetangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRetanguloActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCross);
        rbCross.setText("Cross");
        rbCross.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCrossActionPerformed(evt);
            }
        });

        cbMorfologico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Erosão", "Dilatado", "Aberto", "Fechado" }));

        jLabel2.setText("thresholding : 0");

        slideDesfocar.setMajorTickSpacing(2);
        slideDesfocar.setMaximum(10);
        slideDesfocar.setMinorTickSpacing(1);
        slideDesfocar.setPaintTicks(true);
        slideDesfocar.setValue(0);
        slideDesfocar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slideDesfocarStateChanged(evt);
            }
        });

        jSliderLimiar.setMaximum(200);
        jSliderLimiar.setPaintTicks(true);
        jSliderLimiar.setToolTipText("");
        jSliderLimiar.setValue(0);
        jSliderLimiar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderLimiarStateChanged(evt);
            }
        });

        javax.swing.GroupLayout painelControleImgLayout = new javax.swing.GroupLayout(painelControleImg);
        painelControleImg.setLayout(painelControleImgLayout);
        painelControleImgLayout.setHorizontalGroup(
            painelControleImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(painelControleImgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelControleImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHistograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(slideMorfologico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDesfocar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelControleImgLayout.createSequentialGroup()
                        .addComponent(cbMorfologico, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                        .addComponent(rbRetangulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbElipse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCross))
                    .addComponent(btEscalaCinza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSliderLimiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelControleImgLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelControleImgLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbRGB, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSubtrair))
                    .addComponent(slideDesfocar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelControleImgLayout.setVerticalGroup(
            painelControleImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelControleImgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelControleImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRGB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSubtrair))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDesfocar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slideDesfocar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbHistograma, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slideMorfologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelControleImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMorfologico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbCross)
                    .addComponent(rbElipse)
                    .addComponent(rbRetangulo))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEscalaCinza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSliderLimiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fitros", painelControleImg);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tranformacao", jPanel1);

        lbImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane2.setViewportView(lbImagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelControleCam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelControleCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCarregarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCarregarImgActionPerformed
        // TODO add your handling code here:

        JFileChooser busca = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagen JPG", "jpg");
        busca.setFileFilter(filter);
        int janela = busca.showOpenDialog(this);

        if (janela == JFileChooser.APPROVE_OPTION) {

            File file = busca.getSelectedFile();
            imagemIcn = new ImageIcon(file.toString());
            ImgOriginal = Imgcodecs.imread(file.toString());
            ImgTrabalhada = ImgOriginal;
            setaImagem(ImgOriginal);

        }

    }//GEN-LAST:event_btCarregarImgActionPerformed

    private void btVisualizarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisualizarImgActionPerformed
        // TODO add your handling code here:

        Visualizador.showWindow("Visualizador", ImgTrabalhada, ImgTrabalhada.width(), ImgTrabalhada.height());

    }//GEN-LAST:event_btVisualizarImgActionPerformed

    private void btEscalaCinzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEscalaCinzaActionPerformed
        // TODO add your handling code here:

        setaImagem(filtro.converterEscalaCinza(ImgTrabalhada));


    }//GEN-LAST:event_btEscalaCinzaActionPerformed

    private void btRestaurarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRestaurarImgActionPerformed
        // TODO add your handling code here:

        setaImagem(ImgOriginal);
        slideDesfocar.setValue(0);
        slideMorfologico.setValue(0);
        jSliderLimiar.setValue(0);

    }//GEN-LAST:event_btRestaurarImgActionPerformed

    private void btSubtrairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubtrairActionPerformed
        // TODO add your handling code here:

        if (cbRGB.getSelectedIndex() > 0) {
            int canal = cbRGB.getSelectedIndex() - 1;
            setaImagem(filtro.subtrairBGR(ImgTrabalhada, canal));
        }

    }//GEN-LAST:event_btSubtrairActionPerformed

    private void slideMorfologicoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slideMorfologicoStateChanged
        // TODO add your handling code here:

        operadMorfologico();

    }//GEN-LAST:event_slideMorfologicoStateChanged

    private void btCarregarCAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCarregarCAMActionPerformed
        // TODO add your handling code here:

        FrmWebCam frm = new FrmWebCam(this, true);
        frm.setVisible(true);

        if (frm.isConfirma()) {
            ImgOriginal = frm.getMatImg();
            setaImagem(ImgOriginal);
        }


    }//GEN-LAST:event_btCarregarCAMActionPerformed

    private void btSalvarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarImgActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btSalvarImgActionPerformed

    private void rbRetanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRetanguloActionPerformed
        // TODO add your handling code here:
        operadMorfologico();
    }//GEN-LAST:event_rbRetanguloActionPerformed

    private void rbElipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbElipseActionPerformed
        // TODO add your handling code here:
        operadMorfologico();
    }//GEN-LAST:event_rbElipseActionPerformed

    private void rbCrossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCrossActionPerformed
        // TODO add your handling code here:
        operadMorfologico();
    }//GEN-LAST:event_rbCrossActionPerformed

    private void cbRGBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRGBItemStateChanged
        // TODO add your handling code here:
        if (cbRGB.getSelectedIndex() > 0) {
            btSubtrair.setEnabled(true);
        } else {
            btSubtrair.setEnabled(false);
        }
    }//GEN-LAST:event_cbRGBItemStateChanged

    private void slideDesfocarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slideDesfocarStateChanged
        // TODO add your handling code here:
        
        int value = slideDesfocar.getValue();
        
        lbDesfocar.setText("Desfoque : "+value+"%");
        
        Mat temp = filtro.desfocar(ImgOriginal, value);
        
        setaImagem(temp);
        
    }//GEN-LAST:event_slideDesfocarStateChanged

    private void jSliderLimiarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderLimiarStateChanged
        // TODO add your handling code here:

        int value = jSliderLimiar.getValue();

        jLabel2.setText("thresholding : " + value);

        BufferedImage img_bin = filtro.binarizar(proc.converteMatImage(ImgTrabalhada), value);

        lbImagem.setIcon(new ImageIcon(img_bin));


    }//GEN-LAST:event_jSliderLimiarStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCarregarCAM;
    private javax.swing.JButton btCarregarImg;
    private javax.swing.JButton btEscalaCinza;
    private javax.swing.JButton btRestaurarImg;
    private javax.swing.JButton btSalvarImg;
    private javax.swing.JButton btSubtrair;
    private javax.swing.JButton btVisualizarImg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbMorfologico;
    private javax.swing.JComboBox<String> cbRGB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSlider jSliderLimiar;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbDesfocar;
    private javax.swing.JLabel lbHistograma;
    private javax.swing.JLabel lbImagem;
    private javax.swing.JPanel painelControleCam;
    private javax.swing.JPanel painelControleImg;
    private javax.swing.JRadioButton rbCross;
    private javax.swing.JRadioButton rbElipse;
    private javax.swing.JRadioButton rbRetangulo;
    private javax.swing.JSlider slideDesfocar;
    private javax.swing.JSlider slideMorfologico;
    // End of variables declaration//GEN-END:variables
}
