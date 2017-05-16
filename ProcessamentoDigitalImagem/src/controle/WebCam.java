package controle;


import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author YU7
 */
public class WebCam {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    private JFrame frame;
    private JLabel lbImagem;

    public static void main(String[] args) {

        WebCam app = new WebCam();
        app.iniciarJanela();
        app.runMainLoop(args);
        
    }

    public void iniciarJanela() {
        
        frame = new JFrame("WebCam OpenCV");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        lbImagem = new JLabel();
        frame.add(lbImagem);
        frame.setVisible(true);
        
    }

    public void runMainLoop(String[] args) {
        
        ConverteMatToImage proc = new ConverteMatToImage();
        
        Mat frameWebCam = new Mat();
        
        Image tempImage;
        
        VideoCapture capture = new VideoCapture(0);
        
//        capture.set(Videoio.CAP_PROP_FRAME_WIDTH, 320);
//        capture.set(Videoio.CAP_PROP_FRAME_HEIGHT, 240);
        
        if (capture.isOpened()) {
            while (true) {
                capture.read(frameWebCam);
                if (!frameWebCam.empty()) {
                    tempImage = proc.converteMatImage(frameWebCam);
                    ImageIcon imageIcon = new ImageIcon(tempImage);
                    lbImagem.setIcon(imageIcon);
                    frame.pack(); 
                } else {
                    System.out.println("-- Quadro não capturado --");
                    break;
                }
            }
        } else {
            System.out.println("Não foi possível abrir captura de video");
        }
    }
}


