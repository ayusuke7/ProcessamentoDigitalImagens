/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and abertura the template in the editor.
 */
package controle;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author YU7
 */
public class OperadoresMorfologicos {

    public Mat erosao(Mat input, int elementSize, int elementShape) {

        Mat saida = new Mat();
        Mat element = getFormato(elementSize, elementShape);
        Imgproc.erode(input, saida, element);

        return saida;

    }

    public Mat dilatacao(Mat input, int elementSize, int elementShape) {

        Mat saida = new Mat();
        Mat element = getFormato(elementSize, elementShape);
        Imgproc.dilate(input, saida, element);

        return saida;

    }

    public Mat abertura(Mat input, int elementSize, int elementShape) {

        Mat saida = new Mat();
        Mat element = getFormato(elementSize, elementShape);
        Imgproc.morphologyEx(input, saida, Imgproc.MORPH_OPEN, element);
        
        return saida;

    }

    public Mat fechamento(Mat input, int elementSize, int elementShape) {

        Mat saida = new Mat();
        Mat element = getFormato(elementSize, elementShape);
        Imgproc.morphologyEx(input, saida, Imgproc.MORPH_CLOSE, element);
        
        return saida;

    }

    private Mat getFormato(int elementSize, int elementShape) {

        Size sz = new Size(elementSize * 2 + 1, elementSize * 2 + 1);
        Point pt = new Point(elementSize, elementSize);
        Mat saida = Imgproc.getStructuringElement(elementShape, sz, pt);

        return saida;
        
    }

}
