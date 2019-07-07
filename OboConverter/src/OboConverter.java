import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OboConverter {

	protected List<String> lines;
	protected String foldername;

	public OboConverter(String foldername, String codelist_id) {
		try {
			this.foldername = foldername;
			this.lines = Files.readAllLines(Paths.get("input_codelist/" + foldername + "/" + foldername + "_" + codelist_id + ".txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


}
