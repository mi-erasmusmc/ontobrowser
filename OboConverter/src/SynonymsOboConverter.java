import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SynonymsOboConverter extends OboConverter {

	private HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();

	public SynonymsOboConverter(String codelist_id) {
		super("synonyms", codelist_id);
	
		for (int i = 1; i <= lines.size() - 1; i++) {
			String x = lines.get(i);
			StringTokenizer st = new StringTokenizer(x, "\t");

			// First we remove the codelist id column
			st.nextToken();

			String term_id = st.nextToken();
			String value = "synonym: \"" + st.nextToken() + "\" " + st.nextToken() + " [" + st.nextToken() + "]\n";

			if (hmap.containsKey(term_id) == true) {
				List<String> listval = hmap.get(term_id);
				listval.add(value);
			} else {
				List<String> listval = new LinkedList<String>();
				listval.add(value);
				hmap.put(term_id, listval);
			}
		}
	}
	
	public List<String> getSynonyms (String term_id){
		return hmap.get(term_id);
	}

}
