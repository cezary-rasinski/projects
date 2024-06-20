package org.example.k2_client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ConnectionThread extends Thread {
    Socket socket;
    PrintWriter writer;

    public ConnectionThread(String address, int port) throws IOException {
        socket = new Socket(address, port);
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(input)
            );
            writer = new PrintWriter(output,true);

            String message;

            while((message = reader.readLine()) != null) {
                ClientReceiver.receiveWord(message);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

//GUI dziala na wątku
//Trzeba uzyc platform.runlater