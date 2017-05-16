package controle;

import java.awt.image.BufferedImage;
import org.opencv.core.Mat;

/**
 *
 * @author YU7
 */
public class ConverteMatToImage {

    public BufferedImage converteMatImage(Mat matrix) {

        int colunas = matrix.cols();
        int linhas = matrix.rows();
        int elemSize = (int) matrix.elemSize();

        byte[] data = new byte[colunas * linhas * elemSize];

        int type;

        matrix.get(0, 0, data);

        switch (matrix.channels()) {
            case 1:
                type = BufferedImage.TYPE_BYTE_GRAY;
                break;
            case 3:
                type = BufferedImage.TYPE_3BYTE_BGR;
                // bgr to rgb  
                byte b;
                for (int i = 0; i < data.length; i = i + 3) {
                    b = data[i];
                    data[i] = data[i + 2];
                    data[i + 2] = b;
                }
                break;
            default:
                return null;
        }
        
        //Cria a Imagem através do vetor [] Bytes 
        BufferedImage img = new BufferedImage(colunas, linhas, type);
        img.getRaster().setDataElements(0, 0, colunas, linhas, data);

        return img;

    }

}
