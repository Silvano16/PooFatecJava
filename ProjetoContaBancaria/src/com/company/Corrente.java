package com.company;

public class Corrente extends Conta {

    private double limite;

    public Corrente(Cliente titular) {
        super(titular);

    }

    public double getLimite() {
        return limite;
    }
    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean Sacar(double valor) {
        if(valor<=(getSaldo()+limite)){
            setSaldo(getSaldo()-valor);
            return true;
        }
        return false;
    }

}
