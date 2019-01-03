package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import SocketTrafmFile.SocketFileServer;

public class FileUtil
{
	public static List<String> readFile(String path)
	{
		byte[] buff=new byte[1024];
		List<String> list=new ArrayList<String>();
		File file=new File(path);
		FileInputStream fileInputStream;
		try
		{
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(buff);
			fileInputStream.close();
			String reslut=new String(buff,"GBK");
			
			list.add(reslut);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static String getFullPath(String path,String filename)
	{
		String product=path+"//"+filename;
		
		return product;
	}
	
	public static boolean writeFile(String pathname,List<String> context,boolean flag)
	{
		File file=new File(pathname);
		try
		{
			FileOutputStream fileOutputStream=new FileOutputStream(file);
			byte[] buff=new byte[1024];
			buff=context.get(0).getBytes();
			fileOutputStream.write(buff);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
}
