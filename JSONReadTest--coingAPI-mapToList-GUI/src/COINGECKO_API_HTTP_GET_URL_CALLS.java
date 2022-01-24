
public class COINGECKO_API_HTTP_GET_URL_CALLS {

	// String get_BEP20Token_TotalSupply_aka_MaxSupply_by_ContractAddress(String
	// contractAddress) {
	// return
	// "https://api.bscscan.com/api?module=stats&action=tokensupply&contractaddress="
	// + contractAddress
	// + "&apikey=YourApiKeyToken";
	// }

	// https://api.coingecko.com/api/v3/ping
	String get_ping() {
		return "https://api.coingecko.com/api/v3/ping";
	}

	// https://api.coingecko.com/api/v3/coins/list?include_platform=false
	String get_coins_list() {
		return "https://api.coingecko.com/api/v3/coins/list?include_platform=false";
	}

	// https://api.coingecko.com/api/v3/coins/binancecoin?localization=false&tickers=false&market_data=true&community_data=true&developer_data=true&sparkline=false
	// restricted version (some false)

	// get_coins rather MEANS get_coins_info ...!

	String get_coins_FROM_id(String id) {
		return "https://api.coingecko.com/api/v3/coins/" + id
				+ "?localization=false&tickers=false&market_data=true&community_data=true&developer_data=true&sparkline=false";
	}

}
