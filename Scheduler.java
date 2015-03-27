import java.util.LinkedList;

public class Scheduler {

	private int quantum;
	private int policy;
	private LinkedList<Process> processes;
	private LinkedList<Process> ready;
	private LinkedList<Process> blocked;


	public Scheduler(LinkedList<Process> l) {
		this.policy = 0;
		this.processes = processes;
		this.ready = l;
		this.blocked = new LinkedList<Process>();
	}


	/* FIFO:0, RR:1, SRTF:2 */
	public void setPolicy(int p) {
		this.policy = p;
	}

	public Process nextProcess(int time) {
		Process p = null;
		switch(this.policy) {
			case 0:
				p = fifoNext();
				break;
			case 1:
				p = rountRobinNext();
				break;
			default:
				p = srtfNext();
				break;
		}
		return p;
	}

	public void addProcessReady(Process p) {
		this.ready.add(p);
	}

	public void addProcessBlocked(Process p) {
		this.blocked.add(p);
	}


	private Process fifoNext() {
		Process p = null;
		if(this.ready.size() != 0) {
			p = this.ready.poll();
		}
		return p;
	}

	private Process rountRobinNext() {
		return null;
	}

	private Process srtfNext() {
		return null;
	}


	

}