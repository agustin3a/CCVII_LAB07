import java.util.LinkedList;

public class Process {

	private String name;
	private int ta;
	private LinkedList<Burst> bursts;
	private int cont;
	
	public Process(String name) {
		this.name = name;
		this.ta = 0;
		this.cont = 0;
	}

	public void setTA(int ta) {
		this.ta = ta;
	}

	/* Return next burst, return null if the process is over and reset cont */
	public Burst getNextBurst() {
		Burst b;
		if(cont < bursts.size()) {
			b = this.bursts.get(cont);
			cont++;
		} else {
			b = null;
			cont = 0;
		}
		return b;
	}

	public void addBurst(Burst burst) {
		this.bursts.add(burst);
	}

	public int timeLeft(int offset) {
		int r = offset;
		for(int i = this.cont; i < this.bursts.size(); i++) {
			r = r + this.bursts.get(i).time;
		}
		return r;
	}


}