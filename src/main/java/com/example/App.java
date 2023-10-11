package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class App {
    public static void main( String[] args ) {

        //Client

        try {

           System.out.println("1. Il client è partito");
           Socket s = new Socket("localhost",3000);

           BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
           DataOutputStream out = new DataOutputStream(s.getOutputStream());

           out.writeBytes("ciao a tutti" + '\n');

           String stringaRicevuta = in.readLine();
           System.out.println("La string ricevuta" + stringaRicevuta);

           s.close();

        }

        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Eroore durante la connessione!");
            System.exit(1);
        }
    }
    
}