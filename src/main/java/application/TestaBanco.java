package application;

import model.entities.Account;
import model.entities.AccountList;
import model.exception.DomainException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TestaBanco {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner resp = new Scanner(System.in);
        AccountList listaContas = new AccountList();
        try{
            boolean repetidor = true;
            while(repetidor){
                System.out.println();
                System.out.println("1.Cadastrar conta");
                System.out.println("2.Consultar saldo");
                System.out.println("3.Depósito");
                System.out.println("4.Saque");
                System.out.println("5.Sair");

                int opcao = Integer.parseInt(resp.nextLine());

                switch(opcao){
                    case 1:
                        System.out.print("Digite o número da conta: ");
                        int number = Integer.parseInt(resp.nextLine());

                        System.out.print("Digite o titular da conta: ");
                        String holder = resp.nextLine();

                        System.out.print("Digite o saldo da conta: ");
                        double balance = Double.parseDouble(resp.nextLine());

                        System.out.print("Digite o limite de saque desejado: ");
                        double withdrawLimit = Double.parseDouble(resp.nextLine());

                        Account contaElemento = new Account(number, holder, balance, withdrawLimit);
                        listaContas.registerAccount(contaElemento);
                        System.out.println("Conta registrada");
                        break;
                    case 2:
                        System.out.print("Digite o número da conta: ");
                        int numberSearch = Integer.parseInt(resp.nextLine());

                        System.out.print("Digite o titular da conta: ");
                        String holderSearch = resp.nextLine();

                        Account contaAchada = listaContas.searchAccount(numberSearch, holderSearch);
                        if(contaAchada != null){
                            System.out.println(contaAchada);
                        }else{
                            System.out.println("Conta inexistente");
                        }
                        break;
                    case 3:
                        System.out.print("Digite o número da conta: ");
                        int numberDeposit = Integer.parseInt(resp.nextLine());

                        System.out.print("Digite o titular da conta: ");
                        String holderDeposit = resp.nextLine();

                        System.out.print("Digite o valor que deseja depositar: ");
                        double amount = Double.parseDouble(resp.nextLine());

                        listaContas.accountListDeposit(numberDeposit, holderDeposit, amount);
                        break;
                    case 4:
                        System.out.print("Digite o número da conta: ");
                        int numberWithdraw = Integer.parseInt(resp.nextLine());

                        System.out.print("Digite o titular da conta: ");
                        String holderWithdraw = resp.nextLine();

                        System.out.print("Digite o valor que deseja sacar: ");
                        double amountWithdraw = Double.parseDouble(resp.nextLine());

                        listaContas.accountListWithdraw(numberWithdraw, holderWithdraw, amountWithdraw);
                        break;
                    case 5:
                        repetidor = false;
                        break;
                    default:
                        System.out.println("Opção Inválida. Digite novamente");
                }
            }
        }
        catch (DomainException e){
            System.out.println("Error: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected ERROR: " + e.getMessage());
        }
        System.out.println("Fim do programa");
        resp.close();
    }
}
