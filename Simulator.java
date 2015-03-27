import java.io.File;
import java.io.BufferedReader;
import java.io.*;

public class Simulator {

	public static Scheduler scheduler;
	public static Parser parser;
	public static int quantum;

	public static void main(String[] args) {
		String textfile = "";
		String text = null;
		File file;

		if(args.length == 0) {
			System.out.println("HELP");
			return;
		} else {
			file = new File(args[0]);
		}
		BufferedReader reader = null;
		try {
	    reader = new BufferedReader(new FileReader(file));
	    while ((text = reader.readLine()) != null) {
	    	textfile = textfile + text;
	    }
		} catch (FileNotFoundException e) {
		  e.printStackTrace();
		} catch (IOException e) {
		  e.printStackTrace();
		} finally {
	    try {
	        if (reader != null) {
	            reader.close();
	        }
	    } catch (IOException e) {
	    }
		}
		parser = new Parser(textfile);
		scheduler = new Scheduler(parser.parseText());
		quantum = parser.getQuantum();
		start();
		//System.out.println(textfile);
	}


	public static void start() {
		int time = 0;

		
		scheduler.nextProcess(time);

	}



}