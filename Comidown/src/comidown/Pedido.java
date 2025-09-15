package comidown;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
		private List<Item> itens = new ArrayList<>();
		private static int contador = 0;
		private int numero;
		private String nome;
		
		public List<Item> getItens() {
		    return itens;
		}

		public Pedido() {
			Scanner leitor = new Scanner(System.in);
			
			boolean verificador = true;
			String nome = "";
			
			while (verificador) {
				System.out.print("* Digite seu nome: ");
				nome = leitor.nextLine();
				
				if (nome.isEmpty()) {
					System.out.println("Inválido. Tente novamente.\n");
				} else {
					verificador = false;
				}
			}
			
			contador++;
			this.numero = contador;
			this.nome = nome;
			this.itens = new ArrayList<>();	
		}
		
		public int getNumero() {
			return numero;
		}
		
		public String getCliente() {
			return nome;
		}
		
		public void adicionarItem(Item item) {
			itens.add(item);
		}
		
		public void exibirPedido() {
			System.out.println("\n========================================");
		    System.out.println("       🍽️ Restaurante ComiDown 🍽️         ");
		    System.out.println("========================================");
		    System.out.println("Pedido N°: " + numero);
		    System.out.println("Cliente: " + nome);
		    System.out.println("----------------------------------------");
		    System.out.println("Itens:");

		    double total = 0;
		    for (Item item : itens) {
		        System.out.println("- " + item.getNome() + "   R$ " + item.getValor());
		        total += item.getValor();
		    }

		    System.out.println("----------------------------------------");
		    System.out.println("Total: R$ " + total);
		    System.out.println("========================================");
		    System.out.println(" Obrigado pela preferência! ❤️ ");
		    System.out.println("========================================\n");
		}
}