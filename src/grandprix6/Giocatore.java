/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix6;

import java.util.HashSet;
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
    GiudiceDiGara GDC;
    Circuito circ;
    Pilota pil;
    Auto aut;
    Scanner scelta = new Scanner(System.in);

    public Giocatore(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;

    }

    @Override
    public void run() { //run sostituisce il metodo gara nell'UML
        int n = 0;
        while (n < 2) {
            System.out.println("Inserisca il numero di macchine:");
            n = scelta.nextInt();
            if (n < 2) {
                System.out.println("Inserisca almeno 2 macchine");
            } else {
                scegliNumeroAutoInGriglia(n);
                n = 2;
            }
        }
        n = 0;
        while (n < 1) {
            System.out.println("Inserisca la lunghezza del circuito:");
            n = scelta.nextInt();
            if (n < 1) {
                System.out.println("La lunghezza minima del circuito e' di almeno 1 KM");
            } else {
                circ.setLunghezza(n);
                n = 2;
            }
        }
        n = 0;
        while (n < 1) {
            System.out.println("Inserisca il numero di giri:");
            n = scelta.nextInt();
            if (n < 1) {
                System.out.println("La gara dovra' durare almeno 1 giro");
            } else {
                circ.setGiri(n);
                n = 2;
            }
        }
        n = -1;
        while (n < 0) {
            System.out.println("Inserisca il numero di pit stop:");
            n = scelta.nextInt();
            if (n < 0) {
                System.out.println("La gara potra' avere come minimo 0 pit stop ");
            } else {
                circ.setPit(n);
                n = 1;
            }
        }
        System.out.println("Configurazione gara terminata");
    }

    public void scegliNumeroAutoInGriglia(int numeroAuto) {
        Pilota.MAX_AUTO_IN_GRIGLIA = numeroAuto;
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
