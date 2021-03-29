package mediator;

import com.google.gson.Gson;
import model.Message;
import model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ChatClinet implements ServerModel{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Model model;
    private Gson gson;


    public ChatClinet(String host, int port, Model model){
        try {
            socket = new Socket(host, port);
            this.model = model;
            this.gson = new Gson();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);


            ClientReceiver clientReceiver = new ClientReceiver(this, in);
            Thread t1 = new Thread(clientReceiver, "");
            t1.start();

        } catch (Exception e){

        }
    }

    public void receive(String s) throws IOException {
        Message m = gson.fromJson(s, Message.class);

        if(m.getType().equals("BROADCAST")){
            model.addMessage(m.getMessage());
        } else {
            if(m.getMessage().equals("Exit")){
                socket.close();
                in.close();
                out.close();
            } else {
                model.setServerLabel(m.getMessage());
            }
        }



    }

    @Override public void Send(String s){
        out.println(s);
    }

    @Override public void Login(String s){
        out.println("Login");
        out.println(s);
    }




}
