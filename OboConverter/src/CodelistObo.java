public class CodelistObo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String dir = System.getProperty("user.dir");

        new TermsOboConverter("C66729").convertObo();
        new TermsOboConverter("C66732").convertObo();
        new TermsOboConverter("C67154").convertObo();
        new TermsOboConverter("C77530").convertObo();
        new TermsOboConverter("C77808").convertObo();
        new TermsOboConverter("C85493").convertObo();
        
	}

}
