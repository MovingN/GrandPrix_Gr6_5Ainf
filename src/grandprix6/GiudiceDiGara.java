/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author federico,giorgio,razvan
 */
public class GiudiceDiGara extends Thread {

    private String nome;
    private String cognome;
    File classifica = new File("classifica.csv");
    Pilota pil[];
    Auto aut[];
    Circuito cir;
    Giocatore giocatore;

    public GiudiceDiGara(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        printInizio();
        calcolaDistanza();//All'interno di questo metodo il giudice si assicura di controllare eventuali incidenti oltre che alla distanza effettuata dalle auto 
        checkGara();
        printFine();
        scriviClassifica();
        printVincitore();
        classifica();
    }

    public void printInizio() {
        System.out.println("La gara e' iniziata");
    }

    public void printFine() {
        System.out.println("La gara e' finita");
    }

    public void printVincitore() {
        try (BufferedReader leggi = new BufferedReader(new FileReader(classifica))) {
            String primaRiga = leggi.readLine();//Nella prima riga abbiamo l'indice del file dove vengono indicate a cosa si riferiscono ogni singola colonna
            String secondaRiga = leggi.readLine();
            System.out.println("Il vincitore del GrandPrix e'" + secondaRiga);
        } catch (IOException e) {
            System.err.println("Errore buffered nel metodo GiudiceDiGara.printVincitore()");
        }
    }

    public void classifica() {
        System.out.println("La classifica e' composta da:");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(classifica));
            String riga;
            while ((riga = br.readLine()) != null) {
                System.out.println(riga);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Errore FileReader nel metodo GiudiceDiGara.classifica()");
        } catch (IOException ex) {
            System.err.println("Errore buffered nel metodo GiudiceDiGara.classifica()");
        }
    }

    public void checkGara() {
        int maxSpeed = 350;
        for (int i = 0; i < Auto.contaOggetti; i++) {
            if (pil[i].auto[i].getVelocita() > maxSpeed) {
                pil[i].setPos(998);
                System.out.println("Il pilota" + pil[i].getNome() + pil[i].getCognome() + "ha utilizzato una macchina truccata");
            }
        }
    }

    public void scriviClassifica() {
        String percorsoFile = "classifica.csv";
        try (FileWriter writer = new FileWriter(percorsoFile, true)) {
            writer.write("Nome" + ";" + "Cognome" + ";" + "Marca" + ";" + "Velocita" + ";" + "Posizione");
            int min = pil[0].getPos();
            int j = 0;
            int point = 0;
            for (int i = 0; i < Auto.contaOggetti; i++) {
                while (j < Auto.contaOggetti) {
                    if (pil[j].getPos() < min) {//Riordinamento in base alla posizione calcolata tramite calcolaDistanza()
                        point = j;
                        min = pil[j].getPos();
                    }
                    j++;
                }
                writer.write(pil[point].getNome() + ";" + pil[point].getCognome() + ";" + aut[point].getMarca() + ";" + aut[point].getVelocita() + ";" + i + 1);
                pil[point].setPos(999);
            }
            System.out.println("Classifica salvata su file: " + percorsoFile);
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file CSV");
        }
    }

    public void calcolaDistanza() {//Serve per ottenere una variabile che possa permettere la comparazione tra piloti per la costruzione di una classifica ordinata in base a quante volte e' stata sottratta la velocita rispetto alla lunghezza del circuito 
        int distanzaTotale = cir.getLunghezza() * 1000;
        int pit;
        int b = 0;
        boolean incidenteValore = false;
        for (int i = 0; i < Auto.contaOggetti; i++) {
            System.out.println("Calcolo della distanza del pilota N" + pil[i].getNumeroMacchina());
            while (distanzaTotale > 0 || incidente() == false) {
                distanzaTotale -= pil[i].auto[i].getVelocita();
                b++;
                incidenteValore = incidente();
                if (incidenteValore == true) {
                    pil[i].setPos(998);
                    System.out.println("Il pilota" + pil[i].getNome() + pil[i].getCognome() + "e' stato coinvolto in un incidente");
                    giocatore.safety();
                }
            }
            if (incidenteValore == false) {
            for (int j = 0; j < cir.getPit(); j++) {
                pit = tempoPitStop();
                b += pit;
                System.out.println("La durata del" + j + "pitstop corrisponde a" + pit); 
            }
            pil[i].setPos(b);
            }
        }
    }

    public int tempoPitStop() {
        int min = 1;
        int max = 3;
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;
    }

    public boolean incidente() {
        int min = 1;
        int max = 100;
        int var = (int) Math.floor(Math.random() * (max - min + 1) + min);
        if (var == 50) {
            return true; //Incidente avvenuto
        } else {
            return false;//Incidente non avvenuto
        }
    }
}
