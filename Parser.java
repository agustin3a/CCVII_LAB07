import java.util.LinkedList;

public class Parser {

	private String text;
	private int quantum;
	
	public Parser(String text) {
		this.text = text;
	}

	public int getQuantum() {
		return this.quantum;
	}

	public LinkedList<Process> parseText() {
		LinkedList<Process> processes = new LinkedList<Process>();
		String line = null;
		//Hashtable<String, Integer> operation = new Hashtable<String, Integer>();
		String[] p = this.text.split(";");
		for(int i = 0; i < p.length; i++) {
			if(i == 0) {
				try {
					this.quantum = Integer.parseInt(p[i].replaceAll("\\s+",""));
					System.out.println(quantum);
				} catch(Exception e) {
				}
			}
			line = p[i].replaceAll("\\s+","").toLowerCase();
			processes.add(stringToProcess(line));
			System.out.println(line);

		}
		return processes;
	}

	public Process stringToProcess(String line) {
		Process process = null;
		int l = line.length();
		int aux = 0;
		char c;
		String acc = "";
		int foo;
		int flip = 0;
		while(aux < l) {
			c = line.charAt(aux);
			switch(flip) {
				case 0 :
					if(c == 'c') {
						if((aux+3 < l) || (line.charAt(aux+1) == 'p') || (line.charAt(aux+2) == 'u') || (line.charAt(aux+2) == ':')) {
								//System.out.println("CPU");
								aux += 4;
								flip = 1;
						}
					} else if(c == 'i') {
						if((aux+3 < l) || (line.charAt(aux+1) == '/') || (line.charAt(aux+2) == 'o') || (line.charAt(aux+2) == ':')) {
								//System.out.println("I/O");
								aux += 4;
								flip = 1;
						}
					} else if(c == 't') {
						if((aux+2 < l) || (line.charAt(aux+1) == 'a') || (line.charAt(aux+2) == ':')) {
							//System.out.println("TA");
							aux += 3;
							flip = 1;
						}
					} else {
						aux++;
					}
					break;
				case 1 :
					acc = "";
					while(aux < l) {
						try {
							foo = Integer.parseInt(Character.toString(line.charAt(aux)));
							acc = acc + foo;
							aux++;
						} catch(Exception e) {
							//System.out.println("no entro " + e.getMessage());
							break;
						}
					}
					flip = 0;
					System.out.println(acc);
			}
		}
		return process;
	}

}