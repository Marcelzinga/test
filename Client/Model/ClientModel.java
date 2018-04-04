package Client.Model;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//Based on this source: https://www.careerbless.com/samplecodes/java/beginners/socket/SocketBasic1.php
public class ClientModel extends Model{
    private static Socket socket;
    private static String host = "localhost";
    private static int port = 7789;


    // TEMPORARY VARIABLES
    Button sendBtn, reversiBtn, tttBtn, connectBtn;
    Stage window;
    Scene mainScene, reversiScene, tttScene;
    TextField input;
    Label label;

    public ClientModel(){
        EstablishConnection();
    }

    public static void EstablishConnection (){
        try {
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
            System.out.println("Connection established");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void SendMsg (String input){
        try {
            //Send the message to the server
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write(input);
            bw.flush();
            System.out.println("Attempting to send to the server: " + input);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public static String ReceiveMsg (){
        String response = null;
        try {
            //Get the return message from the server
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            response = br.readLine();
            System.out.println("Message received from the server : " + response);
        } catch(Exception e){ e.printStackTrace();}
        return response;


    }

    public void sendBtn() {
        String message = input.getText();
        ClientModel.SendMsg(message);
        ClientModel.ReceiveMsg();
        label.setText("Attempting to send: \"" + message + "\" to server");
    }
}