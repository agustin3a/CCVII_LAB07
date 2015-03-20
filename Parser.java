import java.util.LinkedList;

public class Parser {

	private String text;
	private int quantum;
	
	public Parser(String text) {
		this.text = text;
	}

	public LinkedList<Process> parseText() {
		LinkedList<Process> processes = new LinkedList<Process>();
		String line = null;
		//Hashtable<String, Integer> operation = new Hashtable<String, Integer>();
		String[] p = this.text.split(";");
		for(int i = 0; i < p.length; i ++) {
			if(i == 0) {
				try {
					this.quantum = Integer.parseInt(p[i].replaceAll("\\s+",""));
					System.out.println(quantum);
				} catch(Exception e) {
				}
			}
			line = p[i].replaceAll("\\s+","").toLowerCase();
			System.out.println(line);

		}
		return processes;
	}

	public Process stringToProcess(String line) {
		Process process = null;
		int l = line.length();
		int aux = 0;
		char c;
		while(aux < l) {
			c = line.charAt(aux);
			if(c == 'c') {
				if((line.charAt(aux+1) == 'p') || (line.charAt(aux+2) == 'u')) {

				}
			} else if(c == 'i') {
				if((line.charAt(aux+1) == '/') || (line.charAt(aux+2) == 'o')) {

				}
			} else if(c == 't') {
				if(line.charAt(aux+1) == 'a') {

				}
			} else {

			}
		}
		return process;
	}

}