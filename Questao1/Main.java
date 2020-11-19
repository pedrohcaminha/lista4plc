import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int questoes = in.nextInt();
		int equipes = in.nextInt();

		Participante[] listaDeParticipantes = new Participante[3 * equipes];
		boolean[] listaDeParticipantesOciosos = new boolean[3 * equipes];
		Computador[] listaDeComputadores = new Computador[equipes];
		int[] listaDeQuestoes = new int[equipes];
		int[] listaDeQuestoesResolvidas = new int[equipes];
		
		for(int i = 0; i < equipes; i++) {
			listaDeComputadores[i] = new Computador();
			listaDeQuestoes[i] = questoes;
			listaDeQuestoesResolvidas[i] = questoes;
		}
		
		int campeao = 0;
		boolean getOut = false;
		while(!getOut) {
			for(int i = 0; i < equipes * 3; i++) {
				if(listaDeParticipantes[i] == null) {
					if(listaDeQuestoes[i/3] > 0) {						
						listaDeParticipantes[i] = new Participante(listaDeComputadores[i/3], i%3, i/3, listaDeQuestoes[i/3]--);
						listaDeParticipantes[i].start();
					}
				} else if (!listaDeParticipantes[i].isAlive()) {
					if(!listaDeParticipantesOciosos[i]) {
						listaDeQuestoesResolvidas[i/3]--;
						if(listaDeQuestoesResolvidas[i/3] <= 0) {
							getOut = true;
							campeao = i/3;
							break;
						}
					}
					if(listaDeQuestoes[i/3] > 0) {						
						listaDeParticipantes[i] = new Participante(listaDeComputadores[i/3], i%3, i/3, listaDeQuestoes[i/3]--);
						listaDeParticipantes[i].start();
					}else {
						listaDeParticipantesOciosos[i] = true;
					}
				}
			}
		}
		System.out.println("Ganhou "+ campeao);
	}
}
