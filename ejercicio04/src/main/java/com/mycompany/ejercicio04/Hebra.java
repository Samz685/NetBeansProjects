package com.mycompany.ejercicio04;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hebra extends Thread {

    private int n;
    private int fibAc;
    private int fibAnt;

    public Hebra(int numero) {
        this.n = numero;

    }

    public int getN() {
        return n;
    }

    public int getfibAc() {
        return fibAc;
    }

    public int getfibAnt() {
        return fibAnt;
    }

    @Override
    public void run() {
        if (n == 2) {
            fibAnt = 1;
            fibAc = 1;
        } else {
            Hebra h1 = new Hebra(n - 1);
            h1.start();
            while (h1.isAlive()) {
                this.fibAnt = h1.getfibAc();
            }
            this.fibAc = h1.getfibAc() + h1.getfibAnt();
            //System.out.println(this.fibAc);

        }

    }
}
