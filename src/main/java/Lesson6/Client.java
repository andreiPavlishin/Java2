package Lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Socket socket = null;

        final String IP_ADRESS = "localhost";
        final int PORT = 8189;
        try {
            socket = new Socket(IP_ADRESS, PORT);
            System.out.println("Подключились к серверу");

            Scanner typing = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            Thread outThread = new Thread(() -> {
                while (true) {
                    String msg = typing.nextLine();
                    out.println(msg);
                    out.flush();
                }
            });

            Thread inThread = new Thread(() -> {
                try {
                    while (true) {

                        String str = in.nextLine();
                        System.out.println("server: " + str);
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Подключение прервано. Сканер закрыт");
                }
            });

            outThread.start();
            inThread.start();

            inThread.join();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
