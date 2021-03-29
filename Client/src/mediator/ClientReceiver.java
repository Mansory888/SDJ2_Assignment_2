package mediator;

import java.io.BufferedReader;

public class ClientReceiver implements Runnable{
    private BufferedReader in;
    private ChatClinet client;

    public ClientReceiver(ChatClinet chatClinet, BufferedReader in){
        this.in = in;
        this.client = chatClinet;
    }

    @Override
    public void run() {
        while (true){
            try {
                String serverReply = in.readLine();
                client.receive(serverReply);
            } catch (Exception e){

            }
        }
    }
}
