import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Contains the methods to accomplish
 * the Step 2 of the Tech Assessment
 * @author Axel Solano
 *
 */
public class Step2 {
	private final String USER_AGENT = "Mozilla/5.0";
	private String key="";
	private String link="";
	private String strtoreturn = "";
	
	/**
	 * Constructor to set up the key and the first link
	 * @param key the token
	 * @param link  the first link is to get the information
	 */
	public Step2(String key, String link){
		this.key=key;
		this.link=link;
	}
	
	/***
	 * Method to sent an http post request with the token, 
	 * then receive the information as a string
	 * @throws Exception this is if something wrong happen to show the problems
	 */
	public void getPost() throws Exception {
		
		String url = link;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		
		String urlParameters = "token="+key;
		
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
		reverse(response.toString());
		System.out.println(response.toString());

	}
	
	/**
	 * Method to sent an http post request with the token and the reverse word
	 * @param link2 this is an url to sent the information 
	 * @throws Exception this is if something wrong happen to show the problems
	 */
	public void sendPost(String link2) throws Exception {
		
		String url = link2;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "token="+key+ "&string="+strtoreturn;

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
	
	/**
	 * Method to reverse a string
	 * @param str the string received of the first link
	 */
	private void reverse(String str){
		char [] ar = str.toCharArray();
		int size = ar.length;
		strtoreturn  = "";
		for(int i = size-1; i >=0; i--){
			strtoreturn =strtoreturn + ar[i];
		}
		System.out.println(strtoreturn);
		
		
	}

}
