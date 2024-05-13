package chapter15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceClient {

    String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat.",
    "One word: inappropriate", "Just for today, be honest. Tell your boss what you *really* think",
            "You might want to rethink that haircut."};

    public void go() {
        try {
            // ServerSocket makes this server application 'listen' for client requests on port 4242 on the machine this code is running on
            ServerSocket serverSocket = new ServerSocket(4242);

            while (true) {
                // the accept method blocks until a request comes in, and then the method returns a Socket (on some
                // anonymous port) for communicating with the client
                Socket sock = serverSocket.accept();
                // use Socket connection to the client to make a PrintWriter and send it a String advice message
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                // close the Socket after we're done with this client
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }   // close go

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceClient server = new DailyAdviceClient();
        System.out.println("Test");
        server.go();
    }
}
