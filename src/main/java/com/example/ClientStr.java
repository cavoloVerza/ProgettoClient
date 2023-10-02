package com.example;

import java.io.*;
import java.net.*;

public class ClientStr {

    String nomeServer = "localHost";
    int portaServer = 6789;
    
    Socket miosocket;
    BufferedReader tastiera;
    String stringUtente;
    String stringaRicevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;

    public Socket connetti() {

        try {

            tastiera = new BufferedReader(new InputStreamReader(System.in));
            miosocket = new Socket(nomeServer, portaServer);

            outVersoServer = new DataOutputStream(miosocket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));

        }

        catch (UnknownHostException e) {
            System.err.println("Host sconosciuto");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Eroore durante la connessione!");
            System.exit(1);
        }

        return miosocket;

    }

    public void comunica() {

        try {

            System.out.println("4... inserisci la stringa da trasmettere: " + '\n');
            stringUtente = tastiera.readLine();

            System.out.println("5... invio la stringfa al server e attendo ...");
            outVersoServer.writeBytes(stringUtente + '\n');

            stringaRicevutaDalServer = inDalServer.readLine();
            System.out.println("8... Risposta dal server " + '\n' + stringaRicevutaDalServer);

            System.out.println("9 CLIENT: termine elaborazione e chiude connessione");
            miosocket.close();

        }

        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione del server!");
            System.exit(1);
        }

    }
    
}