import java.io.*;
import java.net.*;

// read and write both server and client side.
public class server {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(5000);
            System.out.println("waiting for client...");
            Socket s=ss.accept();
            System.out.println("connected successfully!!");
            DataInputStream din=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String in="";
            String out="";
            while(!in.equals("stop"))
            {
                in=din.readUTF();
                System.out.println("Client: "+in);
                System.out.print("Server: ");
                out=br.readLine();
                dout.writeUTF(out);
                dout.flush();
            }
            din.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
