import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws Exception{
    
        Socket s=new Socket(String.valueOf(InetAddress.getLocalHost()).split("/")[1],5000);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String in="";
        String out="";
        while(!in.equals("stop"))
        {
            System.out.print("Client: ");
            out=br.readLine();
            dout.writeUTF(out);
            dout.flush();
            in=din.readUTF();
            System.out.println("Server: "+in);
            
        }
        dout.close();
        s.close();
        
    }
}
