/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author federico,giorgio,razvan
 */
public class Giocatore extends Thread {

    private String nickname;
    private String password;
    Circuito circ;
    Pilota pil[];
    Scanner scelta = new Scanner(System.in);
    File giocatore = new File("giocatore.csv");

    public Giocatore(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;

    }

    @Override
    public void run() {
        int n = 0;
        cifra();
        System.out.println("Decifratura del file giocatore.csv");
        decifra();
        System.out.println("Inserisca il nome del giudice di gara");
        String nome = scelta.nextLine();
        System.out.println("Inserisca il cognome del giudice di gara");
        String cognome = scelta.nextLine();
        GiudiceDiGara GDC = new GiudiceDiGara(nome, cognome);
        while (n < 2) {
            System.out.println("Inserisca il numero di macchine:");
            int nMacchine = scelta.nextInt();
            if (nMacchine < 2) {
                System.out.println("Inserisca almeno 2 macchine");
            } else {
                n = 2;
                scegliNAuto(nMacchine);
                for (int i = 0; i < nMacchine; i++) {
                    System.out.println("Inserisca il nome del pilota:");
                    pil[i].setNome(scelta.nextLine());
                    System.out.println("Inserisca il cognome del pilota:");
                    pil[i].setCognome(scelta.nextLine());
                    System.out.println("Inserisca la nazionalita' del pilota:");
                    pil[i].setNazionalita(scelta.nextLine());
                    System.out.println("Inserisca il numero del pilota:");
                    pil[i].setNumeroMacchina(scelta.nextInt());
                    System.out.println("Inserisca la marca della sua auto:");
                    pil[i].auto[i].setMarca(scelta.nextLine());
                    System.out.println("Inserisca il modello della macchina:");
                    pil[i].auto[i].setModello(scelta.nextLine());
                    pil[i].auto[i].setVelocitaRand();
                    System.out.println("La macchina andra' a" + pil[i].auto[i].getVelocita() + "Km/h");
                }
            }
        }
        n = 0;
        while (n < 1) {
            System.out.println("Inserisca la lunghezza del circuito in KM:");
            n = scelta.nextInt();

            circ.setLunghezza(n);
            int lungh = n;
            if (lungh < 1) {
                System.out.println("La lunghezza minima del circuito e' di almeno 1 KM e non possiamo avere valori con la virgola");
            } else {
                n = 2;
            }
        }
        n = 0;
        while (n < 1) {
            System.out.println("Inserisca il numero di giri:");
            n = scelta.nextInt();
            circ.setGiri(n);
            int laps = n;
            if (laps < 1) {
                System.out.println("La gara dovra' durare almeno 1 giro");
            } else {
                n = 2;
            }
        }
        n = -1;
        while (n < 0) {
            System.out.println("Inserisca il numero di pit stop:");
            int pit = scelta.nextInt();
            if (pit < 0) {
                System.out.println("La gara potra' avere come minimo 0 pit stop ");
            } else {
                n = 1;
            }
        }
        System.out.println("Configurazione gara terminata");
        System.out.println("Se desidera truccare una macchina digiti il numero 1");
        if (scelta.nextInt() == 1) {
            cheat();
        }
        GDC.start();

    }

    public void cheat() {//Metodo con cui il giocatore puo truccare una macchina in base al numero di macchina inserito
        System.out.println("Seleziona il numero della macchina da truccare");
        int x = scelta.nextInt();
        for (int i = 0; i < Auto.contaOggetti; i++) {
            if (pil[i].getNumeroMacchina() == x) {
                pil[i].auto[i].setVelocita(400);
            }
            System.out.println("Auto truccata con successo");

        }
    }

    public void safety() {
        int cambioMediaVelocita = 0;
        System.out.println("Safety car in pista");
        for (int i = 0; i < Auto.contaOggetti; i++) {
            cambioMediaVelocita = pil[i].auto[i].getVelocita() - 35;
            pil[i].auto[i].setVelocita(cambioMediaVelocita);
        }
        System.out.println("Cambio media velocita' eseguito");
        System.out.println("Bandiera verde");
    }

    public String cifra() { //Scrittura dei dati del giocatore in un file .csv utilizzando la cifratura di Vigenere
        nickname = nickname.toUpperCase(); //Modifica la formattazione della variabile da minuscolo a maiuscolo
        password = password.toUpperCase();
        String messaggio = nickname + password;
        System.out.print("Inserisca la chiave: ");
        String key = scelta.nextLine();
        key = key.toUpperCase();
        String messaggioCifrato = "";
        for (int i = 0, j = 0; i < messaggio.length(); i++) {
            char lettera = messaggio.charAt(i);
            messaggioCifrato += (char) (((lettera - 65) + (key.charAt(j) - 65)) % 26 + 65);
            //La riga di codice calcola la posizione del carattere da cifrare e la posizione del carattere chiave corrispondente.
            //Le due posizioni vengono sommate e il risultato viene "avvolto" su 26 lettere (usando il modulo 26).
            //Il valore finale viene convertito in un carattere, ottenendo il carattere cifrato.
            j = ++j % key.length();
        }
        try (FileWriter writer = new FileWriter(giocatore)) {
            writer.write(messaggioCifrato);
        } catch (IOException ex) {
            System.err.println("Problema con il FileWriter in Giocatore.cifra()");
        }
        System.out.println("L'username e la password corrispondono a:" + messaggioCifrato);
        return messaggioCifrato;
    }

    public String decifra() {//Lettura dei dati cifrati del giocatore da un file .csv, per poi decifrarli utilizzando la cifratura di Vigenere
        System.out.print("Inserisca la chiave: ");
        String key = scelta.nextLine();
        key = key.toUpperCase();
        String messaggioDecifrato = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(giocatore))) {
            String messaggioCifrato = reader.readLine();
            for (int i = 0, j = 0; i < messaggioCifrato.length(); i++) {
                char letter = messaggioCifrato.charAt(i);
                messaggioDecifrato += (char) ((letter - key.charAt(j) + 26) % 26 + 65);
                //La posizione del carattere chiave viene sottratta dalla posizione del carattere cifrato.
                //Il risultato viene "avvolto" su 26 lettere (usando il modulo 26) per gestire eventuali valori negativi.
                //Il valore finale viene convertito in un carattere, ottenendo il carattere decifrato.
                j = ++j % key.length();
            }
        } catch (IOException ex) {
            System.err.println("Problema con il BufferedReader in Giocatore.decifra()");
        }
        StringBuilder sb = new StringBuilder(messaggioDecifrato);
        sb.insert(nickname.length(), ";");//inserisce il ; tra nickname e password
        System.out.println("L'username e la password corrispondono a:" + sb.toString());
        return messaggioDecifrato;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void scegliNAuto(int macchine) {
        Pilota.MAX_AUTO_IN_GRIGLIA = macchine;
    }
}
