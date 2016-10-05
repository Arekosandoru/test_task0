package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String address = "127.0.0.1";
        int port = 8746;

        try  {
            ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
            System.out.println("Waiting for a client...");
            Socket socket = ss.accept(); // заставляем сервер ждать подключений
            System.out.println("Got a client");
            System.out.println();
            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
            OutputStream sout = socket.getOutputStream();
            BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(sout);

            while(true) {
                Date d = new Date();
                Random r = new Random();
                String result="", randch="", getword="",hexword="";

                out.writeUTF(" ");
                getword=in.readLine();
                System.out.println("Input word is "+ getword);
                for (int i = 0; i < 5; i++) {
                    randch += alphabet.charAt(r.nextInt(52));
                }
                SimpleDateFormat stime = new SimpleDateFormat("dd/MM/yy hh:mm:ss");

                for (int i = 0; i < getword.length(); i++) {
                    char ch = getword.charAt(i);
                    hexword += String.format("%02X ", (int) ch);
                }
                result=randch+" "+stime.format(d)+" "+hexword;
                System.out.println(result);

                out.writeUTF(" "+result+" ");
                out.flush();

                if (getword.equals("q") || getword.equals("quit")) {
                    break;
                }
            }
        } catch(Exception e) { e.printStackTrace(); }
    }
}
