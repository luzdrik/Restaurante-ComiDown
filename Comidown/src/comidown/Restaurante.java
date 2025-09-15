package comidown;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Restaurante {
	public static void removerPedido(List<Pedido> pedidos, int numeroRemover) {
		Pedido pedidoRemover = null;
		
		for (Pedido p : pedidos) {
			if (p.getNumero() == numeroRemover) {
				pedidoRemover = p;
				break;
			}
		}
		
		if (pedidoRemover != null) {
			pedidos.remove(pedidoRemover);
			System.out.println("Pedido " + numeroRemover + " removido com sucesso!");
		} else {
			System.out.println("⚠ Pedido não encontrado!");
		}	
	}
	
	public static void removerItem(Pedido pedido, int idItem) {
        Item itemRemover = null;

        for (Item i : pedido.getItens()) {
            if (i.getId() == idItem) {
                itemRemover = i;
                break;
            }
        }

        if (itemRemover != null) {
            pedido.getItens().remove(itemRemover);
            System.out.println("Item [" + idItem + "] removido com sucesso!");
        } else {
            System.out.println("⚠ Item não encontrado!");
        }
    }
	
	public static void main(String[] args) {
		List<Pedido> pedidos = new ArrayList<>();
		Scanner leitor = new Scanner(System.in);
		
		boolean continuar = true;
		
		System.out.println("\n========================================");
	    System.out.println("       🍽️ Restaurante ComiDown 🍽️         ");
	    System.out.println("========================================\n");
		
		while (continuar) {
			Pedido pedido = new Pedido();
			
			boolean adicionar = true;
			
			while (adicionar) {
				System.out.print("Nome do item: ");
	            String nomeItem = leitor.nextLine();

	            System.out.print("Preço do item: ");
	            double valorItem = leitor.nextDouble();
	            leitor.nextLine();

	            Item item = new Item(nomeItem, valorItem);
	            pedido.adicionarItem(item);
	            
	            System.out.print("Deseja ADICIONAR outro item? (s/n): ");
	            String resposta = leitor.nextLine();
	            if (resposta.equalsIgnoreCase("n")) {
	                adicionar = false;
	            }
			}
			
			pedidos.add(pedido);
			
			System.out.println("\nResumo do Pedido registrado:");
			pedido.exibirPedido();
			System.out.println("");
			
			System.out.print("Deseja REMOVER um item do pedido? (s/n): ");
            String respostaItem = leitor.nextLine();
            if (respostaItem.equalsIgnoreCase("s")) {
            	System.out.print("Itens do pedido:\n");
            	for (Item i : pedido.getItens()) {
            		System.out.println("[" + i.getId() + "] " + i.getNome() + " - R$ " + i.getValor());
            	}
            	
                System.out.print("\nDigite o ID do item que deseja remover: ");
                int idItem = leitor.nextInt();
                leitor.nextLine();
                removerItem(pedido, idItem);
            }
            
            System.out.print("Deseja REMOVER um pedido inteiro? (s/n): ");
            String respostaPedido = leitor.nextLine();
            if (respostaPedido.equalsIgnoreCase("s")) {
            	System.out.print("\nPedidos registrados:\n");
            	for (Pedido p : pedidos) {
                    System.out.println("Pedido Nº " + p.getNumero() + " - Cliente: " + p.getCliente());
                }
                System.out.print("\nDigite o número do pedido que deseja remover: ");
                int numeroRemover = leitor.nextInt();
                leitor.nextLine();
                
                removerPedido(pedidos, numeroRemover);
            }
            
            System.out.print("Deseja registrar outro pedido? (s/n): ");
            String confirmacao = leitor.nextLine();
            if (confirmacao.equalsIgnoreCase("n")) {
            	System.out.println("\nVolte sempre!");
            	continuar = false;
            	break;
            }
		}
	}
}
