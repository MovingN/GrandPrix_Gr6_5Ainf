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

    public GiudiceDiGara(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public void printInizio() {
        System.out.println("La gara e' iniziata");
    }

    public void printFine() {
        System.out.println("La gara e' finita");
    }

    public void printVincitore() {
        System.out.println("Il vincitore del GrandPrix e'"); //Vedere file CSV
    }

    public void classifica() throws FileNotFoundException, IOException {
        System.out.println("La classifica e' composta da:"); 
        BufferedReader br = new BufferedReader(new FileReader(classifica));
        String riga;
        while ((riga = br.readLine()) != null) {
            System.out.println(riga);
        }
    }

    public void checkGara() {
        int maxSpeed = 350;
        for(int i=0;i<Auto.contaOggetti;i++){
            if (pil[i].auto[i].getVelocita()>maxSpeed){
                pil[i].setPos(998);
                System.out.println("Il pilota"+pil[i].getNome()+pil[i].getCognome()+"ha utilizzato una macchina truccata");
            }
        }
    }

    public void checkIncidenti() {
// inserire un if dove in qualche modo si riesca a capire l'avvenimento di un'incidente
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

    public void scriviClassifica() {
        String percorsoFile = "classifica.csv";
        try (FileWriter writer = new FileWriter(percorsoFile, true)) {
            writer.write("Nome" + ";" + "Cognome" + ";" + "Marca" + ";" + "Velocita" + ";" + "Posizione");
            int min = pil[0].getPos();
            int j = 0;
            int point = 0;
            for (int i = 0; i < Auto.contaOggetti; i++) {
                while (j < Auto.contaOggetti) {
                    if (pil[j].getPos() < min) {
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
            System.err.println("Errore durante la scrittura del file CSV: " + e.getMessage());
        }
    }

    public void calcolaDistanza() {//Serve per ottenere una variabile che possa permettere la comparazione tra piloti per la costruzione di una classifica ordinata in bvase a quante volte e' stata sottratta la velocita rispetto alla lunghezza del circuito 
        int distanzaTotale = cir.getLunghezza() * 1000;

        int b = 0;
        for (int i = 0; i < Auto.contaOggetti; i++) {
            while (distanzaTotale > 0) {
                distanzaTotale -= pil[i].auto[i].getVelocita();
                b++;
            }
            pil[i].setPos(b);
        }
    }
}
