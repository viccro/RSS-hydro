package VisualServo;
import java.util.Arrays;
import java.awt.Color;

/**
 * BlobTracking performs image processing and tracking for the VisualServo
i * module.  BlobTracking filters raw pixels from an image and classifies blobs,
 * generating a higher-level vision image.
 *
 * @author previous TA's, prentice
 */
public class BlobTracking {
	protected int stepCounter = 0;
	protected double lastStepTime = 0.0;

	public int width;
	public int height;
	private int areaOfBlob = 0;
	// upper and lower thresholds for blob color
	public static int RED_UPHOLD;
	public static int RED_LOWHOLD;
	public static int BLUE_UPHOLD;
	public static int BLUE_LOWHOLD;
	public static int GREEN_UPHOLD;
	public static int GREEN_LOWHOLD;
    //Calibrated to red ball
    public static float H_UPHOLD = 0.96f;
    public static float H_LOWHOLD = 0.047f;
    public static float S_LOWHOLD = 0.5f;
    public static float S_UPHOLD = 1.0f;
    public static float V_LOWHOLD = 0.1f;
    public static float V_UPHOLD = 0.8f;


	// Variables used for velocity controller that are available to calling
	// process.  Visual results are valid only if targetDetected==true; motor
	// velocities should do something sane in this case.
	public boolean targetDetected = false; // set in blobPresent()
	public double centroidX = 0.0; // set in blobPresent()
	public double centroidY = 0.0; // set in blobPresent()
	public double targetArea; // set in blobPresent()
	public double targetRange; // set in blobFix()
	public double targetBearing; // set in blobFix()

	/**
	 * <p>Create a BlobTracking object</p>
	 *
	 * @param width image width
	 * @param height image height
	 */
	public BlobTracking(int width, int height) {

		this.width = width;
		this.height = height;

	}

	public void changeThresholds(float Hup, float Hlow, float Sup, float Slow, float Vup, float Vlow){ 
 	      	 H_UPHOLD = Hup;
       		 H_LOWHOLD = Hlow;
       		 S_UPHOLD = Sup;
       		 S_LOWHOLD = Slow;
       		 V_UPHOLD = Vup;
       		 V_LOWHOLD = Vlow;


	}

    public void blobPixel (Image src, Image dest, int[] binaryImage) {
		int x = src.getWidth();
		int y = src.getHeight(); 

		int j;
		int k; 
				
		//CHECK THE DIMENSIONS MATCH
		if (x*y != binaryImage.length){
			System.err.println("the binary array is not the right size");
			
		}else{
		for (j = 0; j<x; j++){
		        for (k = 0; k<y; k++) {
			        if (binaryImage[j+k*src.getWidth()] == 1) {
				    dest.setPixel(j,k,(byte)0xff,(byte)0,(byte)0);
				} else {
					int r = src.pixelRed(src.getPixel(j,k));
					int b = src.pixelBlue(src.getPixel(j,k));
					int g = src.pixelGreen(src.getPixel(j,k)); 
					byte c = (byte)(r+g+b/3);
					dest.setPixel(j,k,c,c,c); 
				}
			}
		}
		} 			
	}

	public void drawCentroid(Image src, int x, int y) {
        //Draw crosshairs of a contrasting color onto the image, at the coordinates (x, y)
		if (areaOfBlob == 0){return;}
		for (int j = -8; j < 0; j++){
		    src.setPixel(Math.max(x+j, 0), y, (byte)0, (byte)255, (byte)0 );
		    src.setPixel(x,Math.max(y+j, 0), (byte)0, (byte)255, (byte)0);  
		}
		for (int i = 0; i <= 8; i ++){
		    src.setPixel(Math.min(width-1, x+i), y, (byte)0, (byte)255, (byte)0 );
		    src.setPixel(x, Math.min(y+i, height-1), (byte)0, (byte)255, (byte)0 );
		}
	}
	
	public synchronized boolean isBlob(Image src, int x, int y) {
        //Is the pixel in a blob of the correct color?
		int pixel = src.getPixel(x,y); 
		int r = src.pixelRed(pixel);
		int b = src.pixelBlue(pixel);
		int g = src.pixelGreen(pixel);
		if (r < 0){r += 256;}
		if (b < 0){b += 256;}
		if (g < 0){g += 256;} 

		float[] hsv = Color.RGBtoHSB(r,g,b,null);
		if ((hsv[0] > H_LOWHOLD ||hsv[0] < H_UPHOLD) && hsv[1] > S_LOWHOLD && hsv[1] < S_UPHOLD && hsv[2] > V_LOWHOLD && hsv[2] < V_UPHOLD) { 
           // Color is red, as in the ball (within the HSB thresholds)
			return true; } 
		
		return false; 
	}
	
	
	public synchronized int[] blobPresent(Image src) {
        //
		// create a copy of the image for now; later, img will be the gaussian blur instead
		Image img = new Image(src);
		int w = img.getWidth();
		int h = img.getHeight();
		
		// a list of black pixels that could be in blobs, in the image format
		// used by ConnectedComponents.java, which is an array of ints
		// where 0 represents black and 1 represents white
		int length = w*h;
		int[] binaryImage = new int[length];
		
		// mark all the possible blob pixels
		targetDetected = false;
		for (int x = 0; x < w; x++){
			for (int y = 0; y < h; y++){
			        if (isBlob(img, x, y)) {
					// color white
					binaryImage[x + y * w] = 1;
					targetDetected = true;
				}
			}
		}
		
        //Could be using something like doLabel, but that doesn't work.

		// actually, we want the region that fits the largest circle, but we could implement this later
		// or, for a more general thing, maybe all the largest circles for every region
		// at this point, a great tool to use would be a hough transform, which could detect
		// imperfect instances of circles in every blob.
		
		// get the centroid and radius
		//System.out.printf("Get bounding box\n");
		int sumx = 0;
		int sumy = 0;
		int mass = 0;
		
		// iterate over the pixels, finding the min and max indices of white pixels
		int x = 0;
		int y = 0;
		for (int i = 0; i < binaryImage.length; i++){
		        x = i % w;
		        y = i / w;
		        if (binaryImage[i] == 1) {
			        sumx += x;
			        sumy += y;
			        mass++;
			}
		}

		areaOfBlob = mass;
		int[] blob = new int[binaryImage.length];

		if (mass == 0){return blob;} //no good pixels detected

        // calculate centroids and radius
		centroidX = sumx/mass;
		centroidY = sumy/mass;
		targetArea = (double)mass;
		double radius = Math.pow(targetArea/Math.PI, 0.5);
		
        //Finds the radius of the ball, based on width of the blob	
		for (int i = 0; i < blob.length; i++){
			x = i % width;
			y = i / width;
			double distance2center = Math.pow(Math.pow(centroidX-x,2) + Math.pow(centroidY-y,2),0.5);
			if (distance2center <= radius) {
			    blob[i] = 1;
			}
		}
		
		return blob;
	}
	
    public void blobFix() {
        //Transforms area -> range, and centroid -> bearing
	
        double rangeScaleFactor = 100; //used in sqrt
	//System.out.println("area of blob: " + areaOfBlob);
        if (targetArea == 0){
		//System.out.println("target area was 0");
		targetRange = .2;
		targetBearing = 0;}
    	else{
		//System.out.println("area wasn't 0");
		targetRange = Math.pow(rangeScaleFactor / targetArea, .5);    //Area decreases with distance as an inverse-square

        double bearingScaleFactor = 75.0/width; //linear?
        targetBearing = bearingScaleFactor * (centroidX - width/2); }
    }

	/**
	 * <p>Computes frame rate of vision processing</p>
	 */
	private void stepTiming() {
		double currTime = System.currentTimeMillis();
		stepCounter++;
		// if it's been a second, compute frames-per-second
		if (currTime - lastStepTime > 1000.0) {
			stepCounter = 0;
			lastStepTime = currTime;
		}
	}

	/**
	 * <p>Segment out a blob from the src image (if a good candidate exists).</p>
	 *
	 * <p><code>dest</code> is a packed RGB image for a java image drawing
	 * routine. If it's not null, the blob is highlighted.</p>
	 *
	 * @param src the source RGB image, not packed
	 * @param dest the destination RGB image, packed, may be null
	 */
	public void apply(Image src, Image dest) {

		stepTiming(); // monitors the frame rate

		// Begin Student Code
        int height = src.getHeight();
        int width = src.getWidth();
        
        double averageRed, averageGreen, averageBlue;
    	averageRed= averageGreen= averageBlue=0;
        int numAvePixels = width/3 * height/3;
        //compute average RGB values for about 11% center area of the frame

        for (int x=width/3; x <= 2*width/3; x ++){
            for (int y= height/3; y<= 2*height/3; y++){
		int tempRed = src.getPixelRed(x, y);
		int tempGreen = src.getPixelGreen(x, y);
		int tempBlue = src.getPixelBlue(x, y);
		if (tempRed < 0){tempRed += 256;}
		if (tempGreen < 0){tempGreen += 256;}
		if (tempBlue < 0){tempBlue += 256;}
                averageRed +=  tempRed;
                averageGreen += tempGreen;
                averageBlue += tempBlue;
            }
        }
//
        //calcualte the average
        averageRed = averageRed / numAvePixels;
        averageGreen = averageGreen / numAvePixels;
        averageBlue = averageBlue /numAvePixels;

        //get color values in the four corners of the average area and the center pixel

        //Print RGB values
      /*  System.out.println(" The average (R, G, B) (" + (int)averageRed+", " + (int)averageGreen+" ," +(int)averageBlue + ")\n");
        System.out.printf(" upper left corner (R, G, B) = (%d, %d, %d)\n", src.getPixelRed(width/3, height*2/3) , src.getPixelGreen(width/3, height*2/3), src.getPixelBlue(width/3, height*2/3));
        System.out.printf(" lower left corner (R, G, B) = (%d, %d, %d)\n", src.getPixelRed(width/3, height/3), src.getPixelGreen(width/3, height/3),src.   getPixelBlue(width/3, height/3));
        System.out.printf(" lower right corner (R, G, B) = (%d, %d, %d)\n", src.getPixelRed(2*width/3, height/3), src.getPixelGreen(2*width/3, height/3),src.getPixelBlue(2*width/3, height/3));
        System.out.printf(" upper right corner (R, G, B) = (%d, %d, %d)\n", src.getPixelRed(2*width/3, height*2/3), src.getPixelGreen(2*width/3, height*2/3),src.getPixelBlue(2*width/3, height*2/3));
        System.out.printf(" Center Pixel (R, G, B) = (%d, %d, %d)\n", src.getPixelRed(width/2, height/2), src.getPixelGreen(width/2, height/2),src.   getPixelBlue(width/2, height/2));
       */ //END PRINTING RGB VALUES

	//Start printing hsb values
	float[] hsbavg = Color.RGBtoHSB((int)averageRed, (int)averageGreen, (int)averageBlue, null);
	//System.out.println(" AvgH: " + hsbavg[0] + ", AvgS: " + hsbavg[1] + ", AvgB: " + hsbavg[2]);
	int centerRed = src.getPixelRed(width/2, height/2);
	if (centerRed<0){centerRed += 256;}
	int centerGreen = src.getPixelGreen(width/2, height/2);
	if (centerGreen<0){centerGreen += 256;}
	int centerBlue = src.getPixelBlue(width/2, height/2);
	if (centerBlue<0){centerBlue += 256;}
	float[] hsbcenter = Color.RGBtoHSB(centerRed, centerGreen, centerBlue, null);
	//System.out.println("Center HSB stuff: " + hsbcenter[0] + ", " + hsbcenter[1] + ", " + hsbcenter[2]);
	//end printing hsb values       

	blobPixel(src, dest, blobPresent(src));
    drawCentroid(dest, (int)centroidX, (int)centroidY);
	Histogram.getHistogram(src, dest, true); 
	}
}
