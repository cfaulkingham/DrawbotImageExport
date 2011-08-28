/*
 * Colin Faulkingham Drawbot Image Processing Code 2011
 * 
 */ 


import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class ImageExport extends Component {
          
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
    	if(args.length==2){
    		try{
    			BufferedImage img;

    			Writer output = null;
    			File file = new File(args[1]);
    			output = new BufferedWriter(new FileWriter(file));
    		
    			img = ImageIO.read(new File( args[0] ));
    			int w = img.getWidth();
    			int h = img.getHeight();
    			System.out.print("W:"+w+"xH:"+h);
    			for (int i=0; i<h; i++){
    				for (int j=0; j<w; j++){   
    					int pixel = img.getRGB(j, i);
    					//int alpha = (pixel >> 24) & 0xff;
    					int red = (pixel >> 16) & 0xff;
    					int green = (pixel >> 8) & 0xff;
    					int blue = (pixel) & 0xff;
    					int med = (red+green+blue) / 3;
    					int out = med / 24;
       					//System.out.print(out);
    					String text;
    					if(j==0){
    						text = ""+out;
    					}
    					else{
    						text=","+out;
    					}
    					output.write(text);

    					//System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
    				}
    				//System.out.println();
   		 			output.write("\n");

    			}
    			output.close();
   
    		}
    		catch(IOException e){System.out.println(e);}
    	}
    	else{
    		System.err.println();
    		System.err.println("usage: <Image_File> <Out_File.txt>");
    		System.err.println();
    	}
    }
}