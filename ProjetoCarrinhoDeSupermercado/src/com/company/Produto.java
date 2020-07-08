package com.company;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;



public class Produto {

    private int codigo;
    private String descricao;
    private double precoUnit;
    private Fornecedor fornecedor;
    private LocalDate dataCompra = LocalDate.now();
    Cesta cesta;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void imprimirEtiqueta(int validCod, double vlTotal){
        if (validCod == 1){
            System.out.println("Codigo de produto: " + codigo);
            System.out.println("Descricao do produto: " + descricao);
            System.out.println("Preco unit do produto: " + precoUnit);
            System.out.println();
        }

        if (validCod == 2){
            try {
                FileOutputStream resultado = new FileOutputStream("compra.txt", true);
                PrintWriter pw = new PrintWriter(resultado);

                pw.println("-----------Itens dentro do carrinho-----------");
                pw.println("Codigo de produto: " + codigo);
                pw.println("Descricao do produto: " + descricao.toUpperCase());
                pw.println("Preco unit do produto: " + precoUnit);
                pw.println("----------------------------------------------");
                pw.println();

                /*pw.close();
                resultado.close();*/
            }catch (Exception e){
                System.out.println("Algo saiu errado!!!");
            }
        }

        if (validCod == 3){

            try {
                FileOutputStream caminho = new FileOutputStream("compra.txt", true);
                PrintWriter pw = new PrintWriter(caminho);

                pw.println("----------------------------------------------");
                pw.println("Data da Compra: " + dataCompra);
                pw.println("Preco total da Compra: " + vlTotal);
                pw.println("----------------------------------------------");

                pw.close();
                caminho.close();
            }catch (Exception e){
                System.out.println("Algo saiu errado!!!");
            }
        }

    }



}
