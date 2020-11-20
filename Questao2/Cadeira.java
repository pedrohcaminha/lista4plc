import java.util.concurrent.atomic.AtomicInteger;

public class Cadeira {

	final AtomicInteger id = new AtomicInteger(-1);
	
	public Cadeira() {}
	
	
	
	public boolean sentouNaCadeira(int nome) {
		return this.id.compareAndSet(-1, nome);
	}
}