package controle;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Vector;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author YU7
 */
public class Filtros {

    public Mat converterEscalaCinza(Mat img) {

        Mat ImgCinza = new Mat(img.rows(), img.cols(), CvType.CV_8UC1);
        Imgproc.cvtColor(img, ImgCinza, Imgproc.COLOR_BGR2GRAY);

        return ImgCinza;

    }

    public Mat histograma(Mat img) {

        Mat src = new Mat(img.height(), img.width(), CvType.CV_8UC2);

        Imgproc.cvtColor(img, src, Imgproc.COLOR_RGB2GRAY);

        Vector<Mat> bgr_planes = new Vector<>();
        Core.split(src, bgr_planes);

        MatOfInt histSize = new MatOfInt(256);

        final MatOfFloat histRange = new MatOfFloat(0f, 256f);

        boolean accumulate = false;

        Mat b_hist = new Mat();

        Imgproc.calcHist(bgr_planes, new MatOfInt(0), new Mat(), b_hist, histSize, histRange, accumulate);

        int hist_width = 512;
        int hist_heigth = 600;

        long bin_w;

        bin_w = Math.round((double) (hist_width / 256));

        Mat histImage = new Mat(hist_heigth, hist_width, CvType.CV_8UC1);

        Core.normalize(b_hist, b_hist, 3, histImage.rows(), Core.NORM_MINMAX);

        for (int i = 1; i < 256; i++) {

//            Core.line(histImage, new Point(bin_w * (i - 1), hist_h - Math.round(b_hist.get(i - 1, 0)[0])),
//                    new Point(bin_w * (i), hist_h - Math.round(Math.round(b_hist.get(i, 0)[0]))),
//                    new Scalar(255, 0, 0), 2, 8, 0);
        }

        return histImage;
    }

    public Mat subtrairBGR(Mat img, int canal) {

        Mat matBGR = new Mat(img.rows(), img.cols(), img.type());

        for (int i = 0; i < img.rows(); i++) {
            for (int j = 0; j < img.cols(); j++) {
                double[] temp = img.get(i, j);
                temp[canal] = 0;       //0 é a escala AZUL >> 1 é a escala VERDE >> 2 é a escala VERMELHO
                matBGR.put(i, j, temp);
            }
        }

        return matBGR;
    }

    public Mat desfocar(Mat img, int nivel) {

        Size sz = new Size(45, 45); //Melhor abertura do Foco
//      Size sz = new Size(11, 11);

        Mat saida = new Mat(img.rows(), img.cols(), img.type());
        Imgproc.GaussianBlur(img, saida, sz, nivel);

        return saida;

    }

    //Retorna o Buffered de acordo com o Thrueshod
    public BufferedImage binarizar(BufferedImage img, int t) {

        int BLACK = Color.BLACK.getRGB();
        int WHITE = Color.WHITE.getRGB();

        BufferedImage saida = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        // Percorre a imagem definindo na saída o pixel como branco se o valor
        // na entrada for menor que o threshold, ou como preto se for maior.

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                Color pixel = new Color(img.getRGB(x, y));
                saida.setRGB(x, y, pixel.getRed() < t ? BLACK : WHITE);
            }
        }

        return saida;
    }

}
