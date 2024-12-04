package Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;

public class SocketTcp {
    private Integer port;
    private HashMap<String, ArrayList<ServerClientSocket>> roomMap;

    public SocketTcp(Integer port) {
        this.port = port;
        this.roomMap = new HashMap<>();
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(this.port);
            System.out.println("Servidor ejecutándose en el puerto " + this.port);

            while (true) {
                ServerClientSocket client = new ServerClientSocket(serverSocket.accept(), this);
                client.start();
                client.addEventListener((roomName, clientJoin) -> {
                    roomMap.computeIfAbsent(roomName, k -> new ArrayList<>()).add(clientJoin);
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToRoom(String room, PackageData message) {
        ArrayList<ServerClientSocket> clients = roomMap.get(room);
        if (clients != null) {
            for (ServerClientSocket client : clients) {
                client.sendMessage(message);
            }
        }
    }
}

