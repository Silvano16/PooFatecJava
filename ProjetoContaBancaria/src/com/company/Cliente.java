package com.company;

public class Cliente {

    private int idCliente;
    private String nomeCliente;
    static int numeroCliente = 0;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Cliente(String nomeCliente){
        numeroCliente++;
        idCliente = numeroCliente;
        this.nomeCliente = nomeCliente;
    }

    public void listarClientes(){
        System.out.println("Número do Cliente: " + this.idCliente);
        System.out.println("Nome do Cliente: " + this.nomeCliente.toUpperCase());
        System.out.println("----------------------------------------");
    }

}
