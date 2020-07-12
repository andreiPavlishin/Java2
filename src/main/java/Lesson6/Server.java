package Lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");
            socket = server.accept();
            System.out.println("Клиент подключился");

            Scanner typing = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            Thread inThread = new Thread(()->{
                while (true) {
                    String str = in.nextLine();
                    if(str.equals("/end")){
                        System.out.println("Клиент отключился");
                        break;
                    }
                    System.out.println("client: " + str);
                }
            });

            Thread outThread = new Thread(() -> {
                while (true) {
                    out.println(typing.nextLine());
                    out.flush();
                }
            });

            inThread.start();
            outThread.start();

            inThread.join();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
