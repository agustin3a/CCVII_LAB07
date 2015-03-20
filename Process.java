public class Process {

	public String name;
	public int cpu;
	public int io;
	public int ta;
	
	public Process(String name, int cpuburst, int io, int ta) {
		this.name = name;
		this.cpu = cpuburst;
		this.io = io;
		this.ta = ta;
	}
}