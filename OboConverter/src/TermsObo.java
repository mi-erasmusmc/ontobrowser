import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

public class TermsObo {

	private static String foldername ="terms";
	
	private List<String> lines;

	private FileWriter fw;
	
	private String lastline;
	
	public TermsObo(String codelist_id) {
		try {
			this.lines = Files.readAllLines(Paths.get("input_codelist/" + foldername + "/" + foldername + "_" + codelist_id + ".txt"));
			
			fw = new FileWriter("output_obo/" + foldername + "/" + foldername + "_" + codelist_id + ".obo");
			fw.write("format-version: 1.2\n" + "data-version: 1\n" + "date: 29:01:2018 01:11\n"
					+ "auto-generated-by: OntoBrowser Export Service\n" + "\n");
			
			String main_id = foldername + ":0" + codelist_id.substring(1);
			String main_name = foldername + "_" + codelist_id;
			
			fw.write("[Term]\n");
			fw.write("id: " +  main_id +"\n");
			fw.write("name: " + main_name + "\n" + "");
			fw.write("\n");
			
			lastline = "is_a: " + main_id + " ! " + main_name + "\n\n";
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void convertObo() {
		try {

			for(int i=1;i<=lines.size()-1;i++) {
				String x=lines.get(i);
				StringTokenizer st = new StringTokenizer(x,"\t");
				
				//First we remove the codelist id column
				st.nextToken();
				
				//Now we create the term object
				fw.write("[Term]\n");
				
				//Now we create term contents
				fw.write("id: " + foldername + ":0" + st.nextToken().substring(1) + "\n");
				fw.write("name: " + st.nextToken() + "\n");
				fw.write("def: \"" + st.nextToken() + "\"[]\n");
				
				//we end with ending the term object
				fw.write(lastline);
				
			}
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
