/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix6;

import java.util.Random;

/**
 *
 * @author federico,giorgio,razvan
 */
public class Auto {

    private String marca;
    private String modello;
    private int velocita;

    public Auto(String marca, String modello, int velocita) {
        this.marca = marca;
        this.modello = modello;
        this.velocita = velocita;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getVelocita() {
        return velocita;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setVelocita(int velocita) {
        int min = 120;
        int max = 350;
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        this.velocita = random_int;
    }
}
