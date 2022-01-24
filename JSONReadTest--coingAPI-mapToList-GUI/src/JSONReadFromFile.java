
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// Object object = parser.parse(new FileReader(fileName));         
// JsonArray  jsonArr = (JsonArray) object;   // Getting c
// jsonObject jsonObj = jsonArr.get(0);  //use index to access like a list

public class JSONReadFromFile {
	@SuppressWarnings("unchecked")
	public static ArrayList<String> readJsonFileAndMapListOfTokenSymbolsToCoingeckoId(
			ArrayList<String> input_tokenSymbols) {
		ArrayList<String> outputResultCoingeckoIdList = new ArrayList<String>();

		JSONParser parser = new JSONParser();
		try {

			// [OPTION 1: File Input from HDD]
			// a)
			// UPDATE THE .json FILE ON HDD FROM THIS LINK!
			// https://api.coingecko.com/api/v3/coins/list?include_platform=false
// b) SET PATH & NAME to file accordingly to your local HDD folder (keep in mind that Linux, Windows, Mac, ... may differ here)
			// TODO (i) UNCOMMENT NEXT LINE FOR USE
			// Object obj = parser.parse(new
			// FileReader("/home/YOUR_ACCOUNT_USER_NAME_HERE/TEST/jsontest/list4.json"));

			// [OPTION 2: File directly from online request]
			HttpURLrequest httpUrlRequest = new HttpURLrequest();
			COINGECKO_API_HTTP_GET_URL_CALLS cg_ahguc = new COINGECKO_API_HTTP_GET_URL_CALLS();
			String tempJsonObjStr = httpUrlRequest.sendGET(cg_ahguc.get_coins_list());

			// TODO (i) UNCOMMENT NEXT LINE FOR USE
			Object obj = parser.parse("" + tempJsonObjStr);

			JSONArray jsonArr = (JSONArray) obj; // Getting c

			// JSONObject jo = null;

			System.out.println("Array Size (from Input File): " + input_tokenSymbols.size());
			System.out.println("Array Size (from Coingecko 'to map' JSON File): " + jsonArr.size());

			System.out.println("Trying to find 'Coingecko ID' for 'Symbol's");

			for (int i = 0; i < input_tokenSymbols.size(); i++) {

				System.out.println("Try find CoingID for Smybol: " + input_tokenSymbols.get(i));

				String tempSmybol = input_tokenSymbols.get(i);
				tempSmybol = tempSmybol.trim();
				tempSmybol = tempSmybol.toLowerCase();

				String tempResult = "";
				tempResult = tryFindAndMapSingleSymbolToCoingId(tempSmybol, jsonArr);
				outputResultCoingeckoIdList.add(tempResult);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return outputResultCoingeckoIdList;

	}

	private static String tryFindAndMapSingleSymbolToCoingId(String tempSmybol, JSONArray jsonArr) {
		ArrayList<String> arrayResultList = new ArrayList<String>();

		JSONObject jo = null;
		for (int j = 0; j < jsonArr.size(); j++) {
			jo = (JSONObject) jsonArr.get(j); // use index to access like a list

			if (tempSmybol.equals("" + jo.get("symbol"))) {
				// return "" + jo.get("id");
				arrayResultList.add("" + jo.get("id"));
			}

		}

		// create single line of string from ArrayList of results
		String finalOutputResultLineOfText = tryFindAndMapSingleSymbolToCoingId_returnFinalResult(tempSmybol,
				arrayResultList);

		// "!!!_NOT_FOUND_!!!--" + tempSmybol
		return finalOutputResultLineOfText;
	}

	private static String tryFindAndMapSingleSymbolToCoingId_returnFinalResult(String tempSmybol,
			ArrayList<String> arrayResultList) {
		String result = "";

		// Case 1: none found at all
		if (arrayResultList.size() == 0) {
			result = "!!!_NOT_FOUND_!!!--" + tempSmybol;

		}

		// Case 2: found exactly one
		if (arrayResultList.size() == 1) {
			result = arrayResultList.get(0);

		}

		// Case 3: more than one found
		if (arrayResultList.size() > 1) {
			result = tryFindAndMapSingleSymbolToCoingId_returnFinalResult_listUpAllFoundTokensFromResultArrayInOneLineOfString(
					tempSmybol, arrayResultList);

			// Here also still l8r:
			// Output ID (ok) & Name(!!!)

		}

		return result;

	}

	private static String tryFindAndMapSingleSymbolToCoingId_returnFinalResult_listUpAllFoundTokensFromResultArrayInOneLineOfString(
			String tempSmybol, ArrayList<String> arrayResultList) {
		String outputResultText = "";

		outputResultText = tempSmybol + " >>> CHOOSE >>> |";
		for (int i = 0; i < arrayResultList.size(); i++) {
			outputResultText = outputResultText + arrayResultList.get(i) + "|";
		}

		outputResultText = outputResultText.trim();

		return outputResultText;
	}

}