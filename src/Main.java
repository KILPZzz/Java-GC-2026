
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    // %.2f é um formatador de texto para exibir números decimais 🦈

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        String name;
        int intAccount;
        String accountType;
        double balance;

        System.out.print("Bem vindo?..  ");
        name = keyboard.nextLine();

        System.out.print("Tipo de conta  1 - Corrente | 2 - Poupança | 3 - Salário | 0 - Cancelar: ");
        intAccount = keyboard.nextInt();

        accountType = "Não Selecionado";
        switch (intAccount) {
            case 1:
                accountType = "corrente";
                break;
            case 2:
                accountType = "poupança";
                break;
            case 3:
                accountType = "salario";
                break;
            case 0:
                exit(0);
                break;
        }

        System.out.print("Saldo inicial da conta: R$ ");
        balance = keyboard.nextDouble();

        System.out.println(
                "\n--- Conta criada --- " +
                "\n Titular : " + name +
                "\n Tipo    : " + accountType +
                "\n Saldo   : R$ " + String.format("%.2f", balance) +
                "\n -------------------- \n"
        );

        // destinatário fixo para simular a transferência
        String destName    = "João da Silva";
        double destBalance = 500.00;

        boolean active = true;

        while (active) {

            System.out.println(
                    "O que deseja fazer?" +
                    "\n  1 - Ver saldo" +
                    "\n  2 - Depositar" +
                    "\n  3 - Transferir" +
                    "\n  0 - Sair"
            );
            System.out.print("Opção: ");

            int command = keyboard.nextInt();

            switch (command) {

                case 1:
                    System.out.println(
                            "\n Saldo atual de " + name +
                            ": R$ " + String.format("%.2f", balance) + "\n"
                    );
                    break;

                case 2:
                    System.out.print("Valor a depositar: R$ ");
                    double deposit = keyboard.nextDouble();
                    if (deposit <= 0) {
                        System.out.println("Valor inválido.\n");
                    } else {
                        balance += deposit;
                        System.out.println(
                                " Depósito de R$ " + String.format("%.2f", deposit) +
                                " realizado. Novo saldo: R$ " + String.format("%.2f", balance) + "\n"
                        );
                    }
                    break;

                case 3:
                    System.out.println(
                            "\n --- Simulação de Transferência ---" +
                            "\n Destinatário: " + destName +
                            "\n Saldo dele antes: R$ " + String.format("%.2f", destBalance)
                    );
                    System.out.print("Valor a transferir: R$ ");
                    double amount = keyboard.nextDouble();

                    if (amount <= 0) {
                        System.out.println("Valor inválido.\n");
                    } else if (amount > balance) {
                        System.out.println(
                                " Saldo insuficiente. Você tem R$ " + String.format("%.2f", balance) +
                                " e tentou transferir R$ " + String.format("%.2f", amount) + "\n"
                        );
                    } else {
                        balance     -= amount;
                        destBalance += amount;
                        System.out.println(
                                "\n Transferência feita com sucesso" +
                                "\n Você enviou       : R$ " + String.format("%.2f", amount) +
                                "\n Seu novo saldo    : R$ " + String.format("%.2f", balance) +
                                "\n Saldo de " + destName + ": R$ " + String.format("%.2f", destBalance) + "\n"
                        );
                    }
                    break;

                case 0:
                    System.out.println("Saindo..");
                    active = false;
                    break;

                default:
                    System.out.println("opção não reconhecida");
            }
        }

        keyboard.close();
    }
}
