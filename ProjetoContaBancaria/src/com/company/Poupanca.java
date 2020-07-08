package com.company;

public class Poupanca extends Conta{

    private int diaAniversario;

    public Poupanca(Cliente titular) {
        super(titular);
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }
    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }



    @Override
    public boolean Sacar(double valor) {
        if(valor<=getSaldo()){
            setSaldo(getSaldo()-valor);
            return true;
        }
        return false;
    }

}
