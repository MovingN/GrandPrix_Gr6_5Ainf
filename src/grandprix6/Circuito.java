/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix6;

/**
 *
 * @author federico,giorgio,razvan
 */
public class Circuito {

    private int lunghezza;
    private int giri;
    private int pit;

    public Circuito(int lunghezza, int giri, int pit) {
        this.lunghezza = lunghezza;
        this.giri = giri;
        this.pit = pit;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public int getGiri() {
        return giri;
    }

    public int getPit() {
        return pit;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }

    public void setGiri(int giri) {
        this.giri = giri;
    }

    public void setPit(int pit) {
        this.pit = pit;
    }

}
