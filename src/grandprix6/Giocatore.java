/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix6;

import java.util.Scanner;

/**
 *
 * @author federico,giorgio,razvan
 */
/**
 *
 * @author federico,giorgio,razvan
 */
public class Giocatore extends Thread {
//capire un modo per far comunicare il giocatore con tutte le altre classi
//inserire dati del giocatore in un CSV

    private String nickname;
    private String password;
    Scanner scelta = new Scanner(System.in);

    public Giocatore(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;

    }

    @Override
    public void run() { //run sostituisce il metodo gara nell'UML
        int i = 0;
        while (i < 2) {
            System.out.println("Inserisca il numero di macchine:");
            int nMacchine = scelta.nextInt();
            if (nMacchine < 2) {
                System.out.println("Inserisca almeno 2 macchine");
            } else {
                i = 2;
            }
        }
        i = 0;
        while (i < 1) {
            System.out.println("Inserisca la lunghezza del circuito:");
            int lunghezza_circ = scelta.nextInt();
            if (lunghezza_circ < 1) {
                System.out.println("La lunghezza minima del circuito e' di almeno 1 KM");
            } else {
                i = 2;
            }
        }
        i = 0;
        while (i < 1) {
            System.out.println("Inserisca il numero di giri:");
            int laps = scelta.nextInt();
            if (laps < 1) {
                System.out.println("La gara dovra' durare almeno 1 giro");
            } else {
                i = 2;
            }
        }
        while (i < 0) {
            System.out.println("Inserisca il numero di pit stop:");
            int pit = scelta.nextInt();
            if (pit < 0) {
                System.out.println("La gara potra' avere come minimo 0 pit stop ");
            } else {
                i = 1;
            }
        }
        System.out.println("Configurazione gara terminata");
    }

    public void cheat() {

    }

    public void safety() {
        System.out.println("Safety car in pista");
//trovare un modo per settare ed interagire con la velocita' di tutte le auto
        System.out.println("Scelga il numero di giri in cui sara' presente la safety car:");
        int lap_sf = scelta.nextInt();
        //verificare i giri passati sotto Safety car
        System.out.println("Bandiera verde");
    }

    public void cifra() {

    }

    public void decifra() {

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
}
