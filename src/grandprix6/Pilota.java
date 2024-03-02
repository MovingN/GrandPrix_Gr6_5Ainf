/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix6;

/**
 *
 * @author federico,giorgio,razvan
 */
public class Pilota extends Thread {
    private String nome;
    private String cognome;
    private String nazionalita;
    private int numeroMacchina;
    public Auto auto[];
    private int pos;

    public static int MAX_AUTO_IN_GRIGLIA = 25;

    public Pilota(String nome, String cognome, String nazionalita, int numeroMacchina) {
        this.nome = nome;
        this.cognome = cognome;
        this.nazionalita = nazionalita;
        this.numeroMacchina = numeroMacchina;
        auto = new Auto[MAX_AUTO_IN_GRIGLIA];//fa comunicare giocatore e pilota per settare il numero di auto in griglia
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public int getNumeroMacchina() {
        return numeroMacchina;
    }

    public int getPos() {
        return pos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public void setNumeroMacchina(int numeroMacchina) {
        this.numeroMacchina = numeroMacchina;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
