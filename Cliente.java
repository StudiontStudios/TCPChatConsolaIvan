package chatTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;
        Scanner sc = new Scanner(System.in);
        String mensaje;

        try {
            clientSocket = new Socket("192.168.1.49", 1234);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            do {
                mensaje = sc.next();
                out.println(mensaje);
            } while (!mensaje.equals("0"));

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
