/* Copyright (c) 2011 Colin Faulkingham

MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files 
(the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, 
publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION 
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

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
    					int out = med / 26;
       					//System.out.print(out);
    					String text;
    					//if(j==0){
    					//	text = ""+out;
    					//}
    					//else{
    					//	text=","+out;
    					//}
    					text =""+out;
    					output.write(text);
    				}
   		 			output.write("\r");

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