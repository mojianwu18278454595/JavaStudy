package com.sc.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import java.io.IOException;



import javax.imageio.ImageIO;

public class FileUtils
{
	public static byte[] imageToBinary(String imgPath)
	{
		File f=new File(imgPath);
		
		BufferedImage bi;
        try { 
        	bi = ImageIO.read(f); 
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
            ImageIO.write(bi, "jpg", baos);  //经测试转换的图片是格式这里就什么格式，否则会失真 
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
		return null;
	}
	
	public static void binaryToImage(byte[] bytes,String theImg)
	{		
		 try {  
	            ByteArrayInputStream bais = new ByteArrayInputStream(bytes); 
	            BufferedImage bi1 = ImageIO.read(bais); 
	            File image = new File(theImg);// 可以是jpg,png,gif格式
	            if(!image.exists())
	            {
	            	boolean result=image.createNewFile();
	            	System.out.println(result);
	            }
	            ImageIO.write(bi1, "jpg", image);// 不管输出什么格式图片，此处不需改动 
	        } catch (IOException e) { 
	            e.printStackTrace(); 
	        } 
		return ;
	}
}
