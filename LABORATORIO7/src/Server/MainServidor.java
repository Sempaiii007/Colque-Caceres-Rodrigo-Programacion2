package Server;

public class MainServidor {

    public static void main(String[] args) {
        SocketTcp server = new SocketTcp(3000);
        server.start();
    }
}
