import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;
import java.time.Year;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        // Formatação de moeda em Real (R$)
        NumberFormat brl = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        System.out.println("--------------- Marinho's Store ---------------\n");

        System.out.print("Qual seu nome? ");
        String nome = sc.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("Nome inválido. Encerrando.");
            sc.close();
            return;
        }

        System.out.print("");

        System.out.print("Qual sua idade? ");

        if (!sc.hasNextInt()) {
            System.out.println("Idade inválida. Digite um número inteiro. Encerrando.");
            sc.close();
            return;
        }

        int idade = sc.nextInt();

        if (idade < 18) {
            System.out.println("Você não pode ser menor de idade!");
            sc.close();
            return;
        }

        int anoAtual = Year.now().getValue();
        System.out.println("\nOlá " + nome + ", seja bem vindo!\ndata de nascimento:" + (anoAtual - idade));
        System.out.println("");

        System.out.println("--------------- CATALOGO ---------------\n");

        double plano1 = 25.90;
        double plano2 = 19.90;
        double plano3 = 9.99;

        System.out.println("1) Plano Premium - " + brl.format(plano1));
        System.out.println("2) Plano Medium  - " + brl.format(plano2));
        System.out.println("3) Plano Beta    - " + brl.format(plano3));
        System.out.println();

        System.out.print("Qual plano quer? (1/2/3) ");
        int plano = sc.nextInt();

        double precoEscolhido;
        String nomePlano;

        switch (plano) {
            case 1:
                precoEscolhido = plano1;
                nomePlano = "Plano Premium";
                break;
            case 2:
                precoEscolhido = plano2;
                nomePlano = "Plano Medium";
                break;
            case 3:
                precoEscolhido = plano3;
                nomePlano = "Plano Beta";
                break;
            default:
                System.out.println("Opção inválida. Encerrando.");
                sc.close();
                return;
        }

        System.out.println("");

        System.out.println("--------------- PAGAMENTO ---------------\n");
        double saldo = 50.00;
        System.out.println("Seu saldo atual é " + brl.format(saldo));
        sc.nextLine();
        System.out.print("Prosseguir? (s/n) ");
        String prosseguir = sc.nextLine().trim().toLowerCase();

        if (prosseguir.equals("s")) {
            if (saldo >= precoEscolhido) {
                double pagamento = saldo - precoEscolhido;
                System.out.println("\nCompra aprovada!");
                System.out.println("Plano: " + nomePlano);
                System.out.println("Valor: " + brl.format(precoEscolhido));
                System.out.println("Saldo restante: " + brl.format(pagamento));
            } else {
                double falta = precoEscolhido - saldo;
                System.out.println("\nSaldo insuficiente.");
                System.out.println("Faltam " + brl.format(falta) + " para concluir a compra.");
            }
        } else {
            System.out.println("\nOperação cancelada.");
        }


        sc.close();
    }
}
