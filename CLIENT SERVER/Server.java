import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        // membuat server socket dan binding ke port tertentu
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server siap menerima koneksi");

        // menunggu koneksi masuk
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client terhubung");

        // inisialisasi input dan output stream untuk komunikasi dengan client
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // menerima pesan dari client
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Pesan dari client: " + inputLine);

            // mengirim balasan ke client
            out.println("Pesan diterima");

            // keluar dari loop jika pesan adalah "bye"
            if (inputLine.equals("bye")) {
                break;
            }
        }

        // menutup input dan output stream serta socket jika client memutuskan koneksi
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
