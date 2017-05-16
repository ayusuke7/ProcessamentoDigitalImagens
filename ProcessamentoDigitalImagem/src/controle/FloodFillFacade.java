/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Random;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author YU7
 */
public class FloodFillFacade {

    public static final int NULL_RANGE = 0;
    public static final int FIXED_RANGE = 1;
    public static final int FLOATING_RANGE = 2;
    private final boolean colored = true;
    private final boolean masked = true;
    private final int range = FIXED_RANGE;
    private final Random random = new Random();
    private final int connectivity = 4;
    private final int newMaskVal = 255;
    private final int lowerDiff = 20;
    private final int upperDiff = 20;

    public int fill(Mat image, Mat mask, int x, int y) {
        
        Point seedPoint = new Point(x, y);
        
        int b = random.nextInt(256);
        int g = random.nextInt(256);
        int r = random.nextInt(256);
        
        Rect rect = new Rect();
        
        Scalar newVal = isColored() ? new Scalar(b, g, r) : new Scalar(r * 0.299 + g * 0.587 + b * 0.114);
        Scalar lowerDifference = new Scalar(lowerDiff, lowerDiff, lowerDiff);

        Scalar upperDifference = new Scalar(upperDiff, upperDiff, upperDiff);

        if (range == NULL_RANGE) {
            lowerDifference = new Scalar(0, 0, 0);
            upperDifference = new Scalar(0, 0, 0);
        }
        
        int flags = connectivity + (newMaskVal << 8) + (range == FIXED_RANGE ? Imgproc.FLOODFILL_FIXED_RANGE : 0);
        int area = 0;
        
        if (masked) {
            area = Imgproc.floodFill(image, mask, seedPoint, newVal, rect,lowerDifference, upperDifference, flags);
        } else {
            area = Imgproc.floodFill(image, new Mat(), seedPoint, newVal,rect, lowerDifference, upperDifference, flags);
        }
        
        return area;
    }

    /**
     * @return the colored
     */
    public boolean isColored() {
        return colored;
    }
        
}
