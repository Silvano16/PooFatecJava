package com.company;

public class Fornecedor {

    private int idForn;
    private String nome;
    private String contato;
    private String email;

    public void imprimirFornecedor(){
        System.out.println("idForn = " + idForn);
        System.out.println("nome = " + nome);
        System.out.println("contato = " + contato);
        System.out.println("email = " + email);
    }

    public int getIdForn() {
        return idForn;
    }

    public void setIdForn(int idForn) {
        this.idForn = idForn;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
