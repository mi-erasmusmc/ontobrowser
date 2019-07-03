import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

public class CodelistObo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        
        new TermsObo("C66729").convertObo();
        new TermsObo("C66732").convertObo();
        new TermsObo("C67154").convertObo();
        new TermsObo("C77530").convertObo();
        new TermsObo("C77808").convertObo();
        new TermsObo("C85493").convertObo();
        
	}

}
