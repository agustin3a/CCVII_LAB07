import java.io.File;
import java.io.BufferedReader;
import java.io.*;

public class Simulator {

	public static void main(String[] args) {
		String textfile = "";
		String text = null;
		File file;
		Parser parser;
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
		parser.parseText();
		//System.out.println(textfile);
	}
}