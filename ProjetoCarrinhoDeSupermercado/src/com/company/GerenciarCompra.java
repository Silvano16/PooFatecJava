package com.company;

import java.util.Scanner;

public class GerenciarCompra {

    public Fornecedor fornecedores[] = new Fornecedor[20];
    public Produto produtos[] = new Produto[20];
    int idFornc = 0, codProd = 0;


    Cesta cesta = new Cesta();

    public static void main(String[] args) {
        GerenciarCompra gc = new GerenciarCompra();
        Scanner sc = new Scanner(System.in);
        int op = 0;
        do{
            System.out.println("1 - Cadastrar Fornecedor");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Abrir Carrinho");
            System.out.println("4 - Fechar Carrinho");
            System.out.println("9 - Sair");
            System.out.println("Digite sua opção: ");
            op = Integer.parseInt(sc.nextLine());
            switch (op){
                case 1:
                    gc.cadastrarFornecedor();
                    break;
                case 2:
                    gc.cadastrarProduto();
                    break;
                case 3:
                    gc.abrirCarrinho();
                    break;
                case 4:
                    gc.fecharCarrinho();
                    break;
                case 9:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(op!=9);
    }

    private void cadastrarFornecedor(){
        Scanner sc = new Scanner(System.in);
        fornecedores[idFornc] = new Fornecedor();
        fornecedores[idFornc].setIdForn(idFornc+1);
        System.out.println("Digite o nome do fornecedor: ");
        fornecedores[idFornc].setNome(sc.nextLine());
        System.out.println("Digite o telefone: ");
        fornecedores[idFornc].setContato(sc.nextLine());
        System.out.println("Digite o email: ");
        fornecedores[idFornc].setEmail(sc.nextLine());
        System.out.println("Fornecedor cadastrado com sucesso!");
        idFornc++;
    }

    private void cadastrarProduto(){
        Scanner sc = new Scanner(System.in);
        produtos[codProd] = new Produto();
        produtos[codProd].setCodigo(codProd+1);
        System.out.println("Digite a descrição do produto: ");
        produtos[codProd].setDescricao(sc.nextLine());
        System.out.println("Digite o preço do produto: ");
        produtos[codProd].setPrecoUnit(Double.parseDouble(sc.nextLine()));
        int codForc;
        System.out.println("Informe o codigo do fornecedor: ");
        codForc = Integer.parseInt(sc.nextLine());
        for (Fornecedor f: fornecedores) {
            if(f!=null){
                if(f.getIdForn()==codForc){
                    produtos[codProd].setFornecedor(f);
                }
            }
        }
        codProd++;
        System.out.println("Produto cadastrado com sucesso!");
    }

    private void abrirCarrinho(){
        for (Produto p: produtos) {
            if(p!=null){
                p.imprimirEtiqueta(1, 0);
            }
        }
        Scanner sc = new Scanner(System.in);
        int codigo;
        System.out.println("Digite o codigo do produto a ser adicionado no carrinho: ");
        codigo = Integer.parseInt(sc.nextLine());
        for (Produto p: produtos) {
            if(p!=null) {
                if (p.getCodigo()==codigo) {
                    cesta.adicionarItem(p);
                    return;
                }
            }
        }
        System.out.println("Produto não encontrado!");
    }

    private void fecharCarrinho(){
        System.out.println("Seu carrinho");
        cesta.exibeLista();
        cesta.exibeTotalCompra();
        System.out.println("Total da compra: R$" + cesta.calcularTotal());
    }

}
