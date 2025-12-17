import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = leitura.nextLine();
        System.out.print("Tipo de conta: ");
        String conta = leitura.nextLine();
        System.out.print("Depositar: R$");
        double saldo = leitura.nextDouble();
        System.out.println("Conta criada com sucesso!");

        String extrato = """
                *****************************
                Nome: %s
                Tipo conta: %s
                Saldo: R$%.2f
                *****************************
                """.formatted(nome, conta, saldo);
        System.out.println(extrato);

        int operacoes = 0;
        while (operacoes != 4) {
            String menu = """
                    Operações:
                    1- Consultar saldo
                    2- Receber valor
                    3- Transferir valor
                    4- Sair
                    """;
            System.out.println(menu);
            System.out.print("Selecione uma operação: ");
            operacoes = leitura.nextInt();

            switch (operacoes) {
                case 1:
                    System.out.println(String.format("O saldo atualizado é: R$%.2f\n", saldo));
                    break;
                case 2:
                    System.out.print("Informe o valor a ser recebido: R$");
                    double recebido = leitura.nextDouble();
                    if (recebido > 0) {
                        saldo += recebido;
                        System.out.println(String.format("Depósito recebido.\nSaldo atualizado: R$%.2f\n", saldo));
                    } else {
                        System.out.println("Não foi possível concluir o depósito. Digite um valor válido.");
                    }
                    break;
                case 3:
                    System.out.print("Informe o valor a ser transferido: R$");
                    double transferido = leitura.nextDouble();
                    if (saldo >= transferido && transferido > 0) {
                        saldo -= transferido;
                        System.out.println(String.format("Transferência de R$%.2f realizada com sucesso.\nSaldo atualizado: R$ %.2f\n", transferido, saldo));
                    } else {
                        if (transferido < 0) {
                            System.out.println("Valor inválido. Não foi possível concluir a transferência.\n");
                        } else if (saldo < transferido) {
                            System.out.println("Saldo insuciente. Não foi possível concluir a transferência.\n");
                        }
                    }
                    break;
                case 4:
                    System.out.println("\nEncerrando...");
                    break;
                default:
                    System.out.println("Operação invalida. Selecione uma opção válida.\n");
                    break;
            }
        }
        leitura.close();
    }
}
