package comidown;

public class Item {
	private static int contador = 0;
	private int id;
	private String nome;
	private double valor;
	
	public Item(String nome, double valor) {
		contador++;
		this.id = contador;
		this.nome = nome;
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getValor() {
		return valor;
	}
}
