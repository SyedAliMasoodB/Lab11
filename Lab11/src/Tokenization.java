public class Tokenization {

	private void tokenize(String verse){
	String[] tokens = verse.split("[\\s.,!?]+");



		for (int i = 0; i < tokens.length; ++i) {

			tokensList.addItem(tokens[i]);

		}

	}

}
