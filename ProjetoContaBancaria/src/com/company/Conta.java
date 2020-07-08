package com.company;

import javax.naming.Name;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public abstract class Conta {

    private int numeroConta;
    private Cliente cliente;
    private double saldo;
    static int qtdcontas = 0;

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta(Cliente titular){
        this.cliente = titular;
        qtdcontas++;
        this.numeroConta = qtdcontas;
        this.saldo = 0;
    }

    public boolean Depositar(double valor){
        if(valor > 0){
            /*System.out.println("");
            System.out.println("Realizado deposito");
            System.out.println("saldo anterior: " + this.saldo);
            this.saldo += pValor;
            System.out.println("saldo atual: " + this.saldo);
            System.out.println("---------------------------");*/
            try {
                FileOutputStream resultado = new FileOutputStream("resultado.txt", true);
                PrintWriter pw = new PrintWriter(resultado);

                pw.println("-------------- Gold Bank --------------");
                pw.println("Você efetuou um Depósito");
                pw.println("Número da Conta: " + numeroConta);
                pw.println("Tipo de Conta: " + getClass().getSimpleName());
                pw.println("Nome do Cliente: " + cliente.getNomeCliente().toUpperCase());
                pw.println("Saldo anterior: " + this.saldo);
                this.saldo += valor;
                pw.println("Saldo atual: " + this.saldo);
                pw.println("---------------------------------------");

                pw.close();
                resultado.close();
            }catch (Exception e){
                System.out.println("Algo saiu errado!!!");
            }
            return true;
        }
        try {
            FileOutputStream resultado = new FileOutputStream("resultado.txt", true);
            PrintWriter pw = new PrintWriter(resultado);

            pw.println("-------------- Gold Bank --------------");
            pw.println("Não é possivel depositar valor negativo");
            pw.println("---------------------------------------");

            pw.close();
            resultado.close();
        }catch (Exception e){
            System.out.println("Algo saiu errado!!!");
        }
        return false;
    }

    //Método abstrato sacar. Ele não possui código
    public abstract boolean Sacar(double valor);

    public void Transferir(Conta pDest, double pValor){
        if (pValor <= this.saldo){
            /*this.saldo -= pValor;
            pDest.saldo += pValor;
            System.out.println("saldo atual: " + this.saldo);
            System.out.println("saldo atual Destino: " + pDest.saldo);*/
            try {
                FileOutputStream resultado = new FileOutputStream("resultado.txt", true);
                PrintWriter pw = new PrintWriter(resultado);

                pw.println("-------------- Gold Bank --------------");
                pw.println("Você efetuou um Transferência");
                pw.println("Conta Remetente");
                pw.println("Número da Conta: " + numeroConta);
                pw.println("Nome do Cliente: " + cliente.getNomeCliente().toUpperCase());
                pw.println("Saldo anterior: " + this.saldo);
                this.saldo -= pValor;
                pw.println("Saldo atual: " + this.saldo);
                pw.println("---------------------------------------");
                pw.println("Conta Destinatario");
                pw.println("Número da Conta: " + pDest.numeroConta);
                pw.println("Nome do Cliente: " + pDest.getCliente().getNomeCliente().toUpperCase());
                pw.println("Saldo anterior: " + pDest.saldo);
                pDest.saldo += pValor;
                pw.println("Saldo atual: " + pDest.saldo);
                pw.println("Transferência efetuada com sucesso!!!");

                pw.close();
                resultado.close();
            }catch (Exception e){
                System.out.println("Algo saiu errado!!!");
            }

        }
        else {
            try {
                FileOutputStream resultado = new FileOutputStream("resultado.txt", true);
                PrintWriter pw = new PrintWriter(resultado);

                pw.println("-------------- Gold Bank --------------");
                pw.println("Saldo Insulficiente");
                pw.println("---------------------------------------");

                pw.close();
                resultado.close();
            }catch (Exception e){
                System.out.println("Algo saiu errado!!!");
            }
        }

    }

    public void listarContas() {
        try {
            FileOutputStream resultado = new FileOutputStream("resultado.txt", true);
            PrintWriter pw = new PrintWriter(resultado);

            pw.println("-------------- Gold Bank --------------");
            pw.println("Número da Conta: " + this.numeroConta);
            pw.println("Tipo de Conta: " + getClass().getSimpleName());
            pw.println("Nome do Cliente: " + this.cliente.getNomeCliente().toUpperCase());
            pw.println("Saldo da Conta: " + saldo);
            pw.println("---------------------------------------");

            pw.close();
            resultado.close();
        } catch (Exception e) {
            System.out.println("Algo saiu errado!!!");
        }
    }
}
