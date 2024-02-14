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

    public Circuito(int lunghezza, int giri) {
        this.lunghezza = lunghezza;
        this.giri = giri;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public int getGiri() {
        return giri;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }

    public void setGiri(int giri) {
        this.giri = giri;
    }
}
