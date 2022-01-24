import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLrequest {

	static String sendGET(String getURLInput) throws IOException {
		System.out.println("static String sendGET(String getURLInput) START");
		String output = "";

		final String GET_URL = getURLInput;
		// final String GET_URL =
		// "https://api.bscscan.com/api?module=stats&action=tokenCsupply&contractaddress=0x0e09fabb73bd3ade0a17ecc321fd13a19e81ce82&apikey=YourApiKeyToken";
		final String USER_AGENT = "Mozilla/5.0";

		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			output = response.toString();
			// print result
			System.out.println(output);
		} else {
			System.out.println("GET request not worked");
		}

		System.out.println("static String sendGET(String getURLInput) END");

		return output;

	}

	private static void sendPOST() throws IOException {
		final String POST_URL = "https://localhost:9090/SpringMVCExample/home";
		final String POST_PARAMS = "userName=Pankaj";
		final String USER_AGENT = "Mozilla/5.0";

		URL obj = new URL(POST_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
	}

}
