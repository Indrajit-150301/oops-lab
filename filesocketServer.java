import java.io.*;
import java.net.*;
import java.util.*;

public class Server

{
	@SuppressWarnings("resource")
	public static void main(String [ ]args) throws IOException
	{
		ServerSocket serversock = new ServerSocket(4445);
		Socket sock = serversock.accept();
		Scanner in =  new Scanner(sock.getInputStream());
		InputStream is = sock.getInputStream();
		PrintWriter pr = new  PrintWriter(sock.getOutputStream(),true);
		String Filename = in.nextLine();
		int FileSize = in.nextInt();
		FileOutputStream fos = new FileOutputStream(Filename);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[ ] bytearray = new byte[FileSize];
		
		
		int file = is.read(bytearray,0,bytearray.length);
		bos.write(bytearray,0,file);
		
		
		System.out.println("Incoming File: " + Filename);
		System.out.println("File: Size " + FileSize + "Byte");
		pr.println("File Received Successfullly");
		bos.close();
		sock.close();
	}
}
