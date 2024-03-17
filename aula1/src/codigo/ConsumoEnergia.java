package codigo;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ConsumoEnergia{
    
    public static final double  PRECO_KWH = 0.50;
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
         List<Consumidor> consumidores = new ArrayList<>();

         System.out.println("Digite o número do consumidor (0 para sair):");
         int numeroConsumidor = sc.nextInt();
         while (numeroConsumidor != 0) {
             System.out.println("Digite o tipo de consumidor (residencial, comercial ou industrial):");
             String tipoConsumidor = sc.next();
             System.out.println("Digite a quantidade de kWh consumidos:");
             int consumoKwh = sc.nextInt();
 
             Consumidor consumidor = new Consumidor(numeroConsumidor, tipoConsumidor, consumoKwh, consumoKwh);
             consumidores.add(consumidor);
 
             System.out.println("Digite o número do consumidor (0 para sair):");
             numeroConsumidor = sc.nextInt();
         }

         double maiorConsumo = 0;
         double menorConsumo = Double.MAX_VALUE;
         double totalConsumoResidencial = 0;
         double totalConsumoComercial = 0;
         double totalConsumoIndustrial = 0;
         double totalConsumoGeral = 0;
 
         for (Consumidor consumidor : consumidores) {
             maiorConsumo = Math.max(maiorConsumo, consumidor.getConsumoKwh());
             menorConsumo = Math.min(menorConsumo, consumidor.getConsumoKwh());
             totalConsumoGeral += consumidor.getConsumoKwh();
             switch (consumidor.getTipo()) {
                 case "residencial":
                     totalConsumoResidencial += consumidor.getConsumoKwh();
                     break;
                 case "comercial":
                     totalConsumoComercial += consumidor.getConsumoKwh();
                     break;
                 case "industrial":
                     totalConsumoIndustrial += consumidor.getConsumoKwh();
                     break;
             }
         }
         double mediaConsumoGeral = totalConsumoGeral / consumidores.size();
 
         System.out.println("\n*Resultados finais:*");
         System.out.printf("Maior consumo: %.2f kWh\n", maiorConsumo);
         System.out.printf("Menor consumo: %.2f kWh\n", menorConsumo);
         System.out.printf("Total consumo residencial: %.2f kWh\n", totalConsumoResidencial);
         System.out.printf("Total consumo comercial: %.2f kWh\n", totalConsumoComercial);
         System.out.printf("Total consumo industrial: %.2f kWh\n", totalConsumoIndustrial);
         System.out.printf("Média geral de consumo: %.2f kWh\n", mediaConsumoGeral);
 
         for (Consumidor consumidor : consumidores) {
             System.out.println(consumidor);
         }
         sc.close();
        
    }
}