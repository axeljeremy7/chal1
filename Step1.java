import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Contains the methods to accomplish
 * the Step 1 of the Tech Assessment
 * @author Axel Solano
 *
 */
public class Step1 {
	private final String USER_AGENT = "Mozilla/5.0";
	private String key="";
	private String github="";
	
	/**
	 * Constructor to set up the key and the github account
	 * @param key the token
	 * @param github  the name of my github account
	 */
	public Step1(String key, String github){
		this.key=key;
		this.github=github;
	}
	
	/***
	 * Method to sent an http post request with the token
	 * @param link a string variable which is an url to be sent with a query
	 * @throws Exception this is if something wrong happen to show the problems
	 */
	public void sendPost(String link) throws Exception {

		String url = link;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		String urlParameters = "token="+key+"&github=" + github;
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		System.out.println(response.toString());

	}
}
