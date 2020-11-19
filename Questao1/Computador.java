
public class Computador {
	public int done;
	
	public Computador() {this.done = 0;}
	
	public void implementa() {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println("Interrompido");
			Thread.currentThread().interrupt();
		}
		this.done++;	
	}
}
