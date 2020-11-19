
public class Participante extends Thread {
	private Computador computador;
	private int id;
	private int equipe;
	private int questao;

	public Participante(Computador computador, int id, int equipe, int questao) {
		this.computador = computador;
		this.id = id;
		this.equipe = equipe;
		this.questao = questao;
		}
	
	@Override
	public void run() {
		try {
			System.out.println("part " + this.id + " da equipe " + this.equipe + " Comecou a pensar a questao " + this.questao);
			Thread.sleep(1500);
			System.out.println("part " + this.id + " da equipe " + this.equipe + " Terminou de  pensar a questao " + this.questao);
		} catch(InterruptedException e) {
			System.out.print("Interrompido");
			Thread.currentThread().interrupt();
		}
		
		synchronized(computador) {
			System.out.println("part " + this.id + " da equipe " + this.equipe + " Comecou a implementar a questao " + this.questao);
			computador.implementa();
			System.out.println("part " + this.id + " da equipe " + this.equipe + " terminou de implementar a questao " + this.questao);
		}
	}
}
