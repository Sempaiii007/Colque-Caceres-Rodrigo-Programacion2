package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerClientSocket extends Thread {
    private Socket clientSocket;
    private ObjectInputStream inDataServer;
    private ObjectOutputStream outDataServer;
    private Boolean isConnected;
    private SocketTcp server;
    private onEventLister listener;
    private String room = "";

    public ServerClientSocket(Socket clientSocket, SocketTcp server) {
        this.clientSocket = clientSocket;
        this.server = server;
        try {
            outDataServer = new ObjectOutputStream(this.clientSocket.getOutputStream());
            inDataServer = new ObjectInputStream(this.clientSocket.getInputStream());
            this.isConnected = true;
            System.out.println("Cliente Conectado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addEventListener(onEventLister listener) {
        this.listener = listener;
    }

    public void sendMessage(PackageData sendPackage) {
        try {
            outDataServer.writeObject(sendPackage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (this.isConnected) {
            try {
                PackageData data = (PackageData) inDataServer.readObject();
                System.out.println(data.getNick() + " > " + data.getMsn());
                if (data.getMsn().equals(":quit")) {
                    this.isConnected = false;
                } else if (data.getMsn().contains(":join")) {
                    String[] command = data.getMsn().split(" ");
                    if (command.length == 2) {
                        this.listener.join(command[1], this);
                        room = command[1];
                    }
                } else {
                    this.server.sendToRoom(room, data);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        disconnect();
    }

    public void disconnect() {
        try {
            this.clientSocket.close();
            this.isConnected = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
