package application;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<Pessoa> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int qtdPayer = sc.nextInt();

        for(int i = 1; i <= qtdPayer; i++){
            System.out.println("Tax payer #" + i + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char tipo = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            Double anualIncome = sc.nextDouble();
            Pessoa pessoa;
            if(tipo == 'i'){
                System.out.print("Health expenditures: ");
                Double health = sc.nextDouble();
                pessoa = new PessoaFisica(name,anualIncome,health);
            }else{
                System.out.print("Number of employees: ");
                int qtdEmployees = sc.nextInt();
                pessoa = new PessoaJuridica(name,anualIncome,qtdEmployees);
            }
            list.add(pessoa);
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        Double soma = 0.0;
        for(Pessoa p : list){
            System.out.println(p);
            soma += p.calculoImposto();
        }
        System.out.println();
        System.out.printf("TOTAL TAXES: $ %.2f",soma);
    }
}
