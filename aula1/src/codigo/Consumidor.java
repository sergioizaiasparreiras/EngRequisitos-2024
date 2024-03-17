package codigo;

public class Consumidor {
    private int numero;
    private String tipo;
    private int consumoKwh;
    private double totalPagar;

    public Consumidor(int numero, String tipo, double totalPagar, int consumoKwh){
        this.numero = numero;
        this.tipo = tipo;
        this.consumoKwh = consumoKwh;
        this.totalPagar = totalPagar;
    }
    public int getNumero(){
        return numero;
    }
    public String getTipo(){
        return tipo;
    }
    public int getConsumoKwh(){
        return consumoKwh;
    }
    public double getTotalPagar(){
        return totalPagar;
    }
    @Override
    public String toString(){
        return String.format("Consumidor %d: %s - %d kWh - R$ %.2f", 
        numero, tipo, consumoKwh, totalPagar);
    }
}