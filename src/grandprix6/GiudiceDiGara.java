/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix6;
import java.io.File;
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

    public void classifica() {
        System.out.println("La classifica e' composta da:"); //aggiungere un file csv per aggiornare man mano le posizioni
        
    
    }

    public void checkGara() {

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
        String percorsoFile="classifica.csv";
        try (FileWriter writer = new FileWriter(percorsoFile)) {
            for(int i=0;i<Auto.getLunghezza();i++){
            writer.write(pil[i].getNome()+";"+pil[i].getCognome()+";"+ aut[i].getVelocita()+";");
            }
            System.out.println("Classifica salvata su file: " + percorsoFile);
        } catch (IOException e) {
           System.err.println("Errore durante la scrittura del file CSV: " + e.getMessage());
        }
    }
}
