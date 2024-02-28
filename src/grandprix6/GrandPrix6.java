/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grandprix6;

import java.util.Scanner;

/**
 *
 * @author federico,giorgio,razvan
 */
public class GrandPrix6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisca il nome del giocatore");
        String user = scan.nextLine();
        System.out.println("Inserisca la password del giocatore");
        String pass = scan.nextLine();
        Giocatore g1 = new Giocatore(user, pass);
        g1.cifra();
        System.out.println("Decifratura del file giocatore.csv");
        g1.decifra();
        g1.start();
    }
}
