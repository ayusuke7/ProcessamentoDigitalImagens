package controle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;
import org.opencv.core.Mat;

/**
 *
 * @author Danilo
 */
public class Visualizador extends JFrame {

    public static ConverteMatToImage proc;
    public static BufferedImage image;
    public static JFrame frame;
    public static Mat picture;
    public static int larg;
    public static int alt;
    public static int modo;
  
    public static void showWindow(String nomeJanela, Mat picture, int l, int a) {
       
        frame = new JFrame(nomeJanela);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(l+30, a);//largura e altura
        proc = new ConverteMatToImage();
        image = proc.converteMatImage(picture);
        
        if (l == 0) {
            alt = image.getHeight();
            larg = image.getWidth();
        }
        
        larg = l;
        alt = a;
        
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, larg, alt, this);
                super.paintComponents(g);
            }
        };
        
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
