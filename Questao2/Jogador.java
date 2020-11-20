import java.util.Random;

public class Jogador extends Thread {
	
	private int nome;
	private Cadeira[] listaDeCadeiras;


	public Jogador(Cadeira[] listaDeCadeiras, int nome) {
		this.nome = nome;
		this.listaDeCadeiras = listaDeCadeiras;
	}
	
	
	public void run() {
		System.out.println(this.nome + " começou a procurar uma cadeira -----------");
	
		boolean achouCadeira = false;
		while(!achouCadeira) {
			int cadeiraIndex = new Random().nextInt(listaDeCadeiras.length);
			System.out.println(this.nome + " tentou    sentar na cadeira " + cadeiraIndex + " - ");			
			achouCadeira = this.listaDeCadeiras[cadeiraIndex].sentouNaCadeira(this.nome);
			if(achouCadeira == true) {
				System.out.println(this.nome + " conseguiu sentar na cadeira " + cadeiraIndex + " - OK");
			}
		}
	}
	
}