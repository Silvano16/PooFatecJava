package com.company;

import java.io.FileOutputStream;
import java.io.PrintWriter;



public class Cesta {

    private Produto itens[] = new Produto[20];
    private int indice = 0;
    private double total;
    Produto prod;

    public void adicionarItem(Produto produto){
        if(indice < 20) {
            this.itens[indice] = produto;
            indice++;
            this.total += produto.getPrecoUnit();

            try {
                FileOutputStream resultado = new FileOutputStream("compra.txt", true);
                PrintWriter pw = new PrintWriter(resultado);

                pw.println("---------- Item adicionado no carrinho ----------");

                pw.println("Codigo de produto:  " + produto.getCodigo());
                pw.println("Descricao do produto: " + produto.getDescricao().toUpperCase());
                pw.println("Preco unit do produto: " + produto.getPrecoUnit());

                pw.println("--------------------------------------------------");
                pw.println("");

                pw.close();
                resultado.close();
            }catch (Exception e){
                System.out.println("Algo saiu errado!!!");
            }
        }
    }

    public void exibeLista(){
        for (Produto p: itens) {
            if(p!=null){
                p.imprimirEtiqueta(2, 0);
            }
        }

    }

    public void exibeTotalCompra(){
        int cont = 1;
        for (Produto p: itens) {
            if(p!=null){
                if (cont == 1) {
                    p.imprimirEtiqueta(3, calcularTotal());
                }
                cont++;
            }
        }

    }

    public double calcularTotal(){
        return total;
    }

}
