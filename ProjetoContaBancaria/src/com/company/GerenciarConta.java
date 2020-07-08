package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciarConta {

    //ArrayList<Conta> listaContas = new ArrayList();
    ArrayList<Poupanca> lstPoupanca = new ArrayList();
    ArrayList<Corrente> lstCorrente = new ArrayList();
    ArrayList<Cliente> listaClientes = new ArrayList();
    Corrente ctCrt, ctCrt2;
    Poupanca ctPpc, ctPpc2;
    //Conta conta, conta2;
    Cliente cliente;


    public static void main(String[] args) {
        GerenciarConta gc = new GerenciarConta();
        Scanner leia = new Scanner(System.in);
        String aux;
        int opcao, num, num2;
        double valor;

        Conta ct, ct2;

        do {
            System.out.println();
            System.out.println("MENU");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Conta");
            System.out.println("3 - Listar Clientes");
            System.out.println("4 - Listar Contas");
            System.out.println("5 - Depósitar Dinheiro");
            System.out.println("6 - Saquar Dinheiro");
            System.out.println("0 - Sair");
            System.out.println("Digite a opção desejada: ");
            opcao = Integer.parseInt(leia.nextLine());

            switch (opcao) {
                case 1:
                    gc.cadastrarCliente();
                    break;
                case 2:
                    gc.cadastrarConta();
                    break;
                case 3:
                    gc.listarClientes();
                    break;
                case 4:
                    gc.listarContas();
                    break;
                case 5:
                    gc.efetuarDeposito();
                    break;
                case 6:
                    gc.efetuarSaque();
                    break;
                case 0:
                    System.out.println("Fim do Programa");
                    break;
                default:
                    System.out.println("Opção inválida!!!");
            }
        } while (opcao != 0);
    }

    public void cadastrarCliente() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Digite o nome do Cliente: "); // ver se é string
        String nomeCliente = leia.nextLine();
        this.cliente = new Cliente(nomeCliente);
        listaClientes.add(this.cliente);
    }

    public void cadastrarConta() {
        Scanner leia = new Scanner(System.in);
        int idtfConta;
        System.out.println("Que tipo de conta deseja criar?");
        System.out.println("1 - Corrente  ||  2 - Poupança");
        idtfConta = Integer.parseInt(leia.nextLine());
        System.out.println("Digite o número do Cliente: ");
        int idProcurado = Integer.parseInt(leia.nextLine());
        for (Cliente cliente : listaClientes) {
            if (cliente != null) {
                if (idProcurado == cliente.getIdCliente()) {
                    if (idtfConta == 1) {
                        this.ctCrt = new Corrente(cliente);
                        lstCorrente.add(this.ctCrt);
                        System.out.println("Conta corrente criada com sucesso!!!");
                    } else {
                        this.ctPpc = new Poupanca(cliente);
                        lstPoupanca.add(this.ctPpc);
                        System.out.println("Conta poupança criada com sucesso!!!");
                    }

                }
            }
        }
    }

    private void listarClientes() {
        for (Cliente cliente : listaClientes) {
            if (cliente != null) {
                cliente.listarClientes();
            }
        }
    }

    private void listarContas() {
        for (Corrente corrente : lstCorrente) {
            if (corrente != null) {
                corrente.listarContas();
            }
        }
        for (Poupanca poupanca : lstPoupanca) {
            if (poupanca != null) {
                poupanca.listarContas();
            }
        }
    }

    public void efetuarDeposito() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Qual o tipo da Conta que deseja Depositar");
        System.out.println("1 - Corrente  ||  2 - Poupança");
        int idtfConta = Integer.parseInt(leia.nextLine());
        System.out.println("Digite o número da conta: ");
        int idProcurado = Integer.parseInt(leia.nextLine());
        if (idtfConta == 1) {
            for (Corrente corrente : lstCorrente) {
                if (corrente != null) {
                    if (corrente == lstCorrente.get(idProcurado - 1)) {
                        System.out.println("Digite o valor do deposito: ");
                        double valor = Double.parseDouble(leia.nextLine());
                        boolean deuCerto = corrente.Depositar(valor);
                        if (deuCerto) {
                            System.out.println("Depósito efetuado com sucesso");
                        } else {
                            System.out.println("Valor inválido para depósito");
                        }
                    }
                }
            }
        }
        if (idtfConta == 2) {
            for (Poupanca poupanca : lstPoupanca) {
                if (poupanca != null) {
                    if (poupanca == lstPoupanca.get(idProcurado - 1)) {
                        System.out.println("Digite o valor do deposito: ");
                        double valor = Double.parseDouble(leia.nextLine());
                        boolean deuCerto = poupanca.Depositar(valor);
                        if (deuCerto) {
                            System.out.println("Depósito efetuado com sucesso");
                        } else {
                            System.out.println("Valor inválido para depósito");
                        }
                    }
                }
            }
        }
    }

    public void efetuarSaque() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Qual o tipo da Conta que deseja Depositar");
        System.out.println("1 - Corrente  ||  2 - Poupança");
        int idtfConta = Integer.parseInt(leia.nextLine());
        System.out.println("Digite o número da conta: ");
        int idProcurado = Integer.parseInt(leia.nextLine());
        if (idtfConta == 1) {
            for (Corrente corrente : lstCorrente) {
                if (corrente != null) {
                    if (corrente == lstCorrente.get(idProcurado - 1)) {
                        System.out.println("Digite o valor do saque: ");
                        double valor = Double.parseDouble(leia.nextLine());
                        boolean deuCerto = corrente.Sacar(valor);
                        if (deuCerto) {
                            System.out.println("Saque efetuado com sucesso");
                        } else {
                            System.out.println("Valor inválido para saque");
                        }
                    }
                }
            }
            for (Poupanca poupanca : lstPoupanca) {
                if (poupanca != null) {
                    if (poupanca == lstPoupanca.get(idProcurado - 1)) {
                        System.out.println("Digite o valor do saque: ");
                        double valor = Double.parseDouble(leia.nextLine());
                        boolean deuCerto = poupanca.Sacar(valor);
                        if (deuCerto) {
                            System.out.println("Saque efetuado com sucesso");
                        } else {
                            System.out.println("Valor inválido para saque");
                        }
                    }
                }
            }
        }
    }
}

