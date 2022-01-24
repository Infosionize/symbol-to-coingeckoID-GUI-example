import java.util.ArrayList;

public class MapListOfTokenSymbolsToCoingeckoId {

	public ArrayList<String> doit(ArrayList<String> input_tokenSymbols) {

		// input_tokenSymbols = new ArrayList<String>();
		// input_tokenSymbols.add("BTC");
		// input_tokenSymbols.add("ETH");
		// input_tokenSymbols.add("BNB");
		// input_tokenSymbols.add("HOT");
		// input_tokenSymbols.add("NAV");

		ArrayList<String> output_tokenCoingeckId = new ArrayList<String>();

		JSONReadFromFile jrff = new JSONReadFromFile();
		output_tokenCoingeckId = jrff.readJsonFileAndMapListOfTokenSymbolsToCoingeckoId(input_tokenSymbols);

		System.out.println(output_tokenCoingeckId);

		return output_tokenCoingeckId;

	}

}
