import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server started. Listening to port 4444...");
        
        Socket clientSocket = serverSocket.accept();
        System.out.println("Accepted connection : " + clientSocket);
        
        InputStream in = clientSocket.getInputStream();
        OutputStream out = new FileOutputStream("received_file.txt");
        
        byte[] bytes = new byte[1024];
        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }
        
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
        
        System.out.println("File transfer successful.");
    }
}
