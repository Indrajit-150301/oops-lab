import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4444);
        System.out.println("Connected to server on port 4444.");
        
        OutputStream out = socket.getOutputStream();
        InputStream in = new FileInputStream("file_to_transfer.txt");
        
        byte[] bytes = new byte[1024];
        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }
        
        out.close();
        in.close();
        socket.close();
        
        System.out.println("File transfer successful.");
    }
}
