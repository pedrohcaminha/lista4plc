import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int JogadoresRestantes = in.nextInt();
		boolean[] listaDeJogadoresQueSairam = new boolean[JogadoresRestantes];
		
		
		int rodada = 0;
		while(JogadoresRestantes > 1) {
			Cadeira[] listaDeCadeiras = new Cadeira[JogadoresRestantes - 1];
			Jogador[] listaDeJogadores = new Jogador[JogadoresRestantes];
		
			System.out.println("Iniciando a rodada " + rodada);
			System.out.println("Existem " + JogadoresRestantes + " jogadores restantes");
			
			for(int i = 0; i < JogadoresRestantes - 1; i++) {
				listaDeCadeiras[i] = new Cadeira();
			}
			
			System.out.print("Estao jogando: ");
			int indexDosJogadoresRestantes = 0;
			for(int i = 0; i < listaDeJogadoresQueSairam.length; i++) {
				if(!listaDeJogadoresQueSairam[i]) {
					listaDeJogadores[indexDosJogadoresRestantes] = new Jogador(listaDeCadeiras, i);
					System.out.print(i + " ");
					indexDosJogadoresRestantes++;
				}
			}
			System.out.println("");
			
			for(int i = 0; i < listaDeJogadores.length; i++) {
				listaDeJogadores[i].start();
			}
			
			boolean disponivel = false;
			while(!disponivel) {
				disponivel = true;
				for(int i = 0; i < listaDeJogadoresQueSairam.length; i++) {
					listaDeJogadoresQueSairam[i] = true;
				}
				for(int i = 0; i < listaDeCadeiras.length; i++) {
					if(listaDeCadeiras[i].id.get()== -1) {
						disponivel = false;
					}else {
						listaDeJogadoresQueSairam[listaDeCadeiras[i].id.get()] = false;
					}
				}
			}
			
			for(int i = 0; i < listaDeJogadores.length; i++) {
				listaDeJogadores[i].stop();;
			}
			
			JogadoresRestantes--;
			rodada++;
		}
		
		int campeao = -1;
		for(int i = 0; i < listaDeJogadoresQueSairam.length; i++) {
			if(!listaDeJogadoresQueSairam[i]) {
				campeao = i;
			}
		}
		
		System.out.println(" ------ O jogador " + campeao + " foi campeao!!!!! ------- ");
	}

}


//
//import java.util.Scanner;
//
//public class Main {
//
//
//	@SuppressWarnings("deprecation")
//	public static void main(String[] args) {
//		Scanner tec = new Scanner(System.in);
//		
//		int Njogadores = tec.nextInt();
//		boolean[] jogadoresSairam = new boolean[Njogadores];
//		int rodadas = 0;
//		
//		
//		while(Njogadores >= 2) {
//			System.out.println("Rodada "+ rodadas + " com " + Njogadores + " e " + (Njogadores - 1) + " cadeiras");
//			Jogador[] jogadores = new Jogador[Njogadores];
//			Cadeira[] cadeiras = new Cadeira[Njogadores - 1];
//			for(int i = 0; i < Njogadores - 1; i++) {
//				cadeiras[i] = new Cadeira();
//			}
//			int tempId = 0;
//			for(int i = 0; i < jogadoresSairam.length; i++) {//adiciona os jogadores
//				if(!jogadoresSairam[i]) {
//					jogadores[tempId] = new Jogador(cadeiras, i);
//					tempId++;
//				}
//				
////				while(true) {
////			
////					if(!jogadoresSairam[tempId]) {
////						break;
////					}else if(jogadoresSairam[tempId]){
////						tempId++;
////					}
////				}
//
//			}
//			for(int i = 0; i < jogadores.length; i++) {
//				jogadores[i].start();
//			}
//			boolean disponivel = false;
//			while(!disponivel) {
//				disponivel = true;
//				for(int i = 0; i < jogadoresSairam.length; i++) {
//					jogadoresSairam[i] = true;
//				}
//				for(int i = 0; i < cadeiras.length; i++) {
//					if(cadeiras[i].id.get()== -1) {
//						disponivel = false;
//					}else {
//						jogadoresSairam[cadeiras[i].id.get()] = false;
//					}
//				}
//			}
//			Njogadores--;
//			for(int i = 0; i < jogadores.length; i++) {
//				jogadores[i].stop();
//			}
//			rodadas++;
//
//		}
//		for(int i = 0; i < jogadoresSairam.length; i++) {
//			if(!jogadoresSairam[i]) {
//				System.out.println("O JOGADOR " + i + " GANHOU");
//			}
//		}
//		
//
//
//	}
//
//}
