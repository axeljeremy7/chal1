import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Contains the methods to accomplish
 * the Step 3 of the Tech Assessment
 * @author Axel Solano
 *
 */
public class Step3 {
	private final String USER_AGENT = "Mozilla/5.0";
	private String key="";
	private String link="";
	private int indexOfNeedle = 0;
	

	/**
	 * Constructor to set up the key and the first link
	 * @param key the token
	 * @param link  the first link is to get the information
	 */
	public Step3(String key, String link){
		this.key=key;
		this.link=link;
	}
	
	/**
	 * Method to get the index of the value of the needle inside the haystack
	 * @param input the string received of the first link
	 */
	private void getIndexNeedle(String input){

		String delim1 = "[{\\:\"\"\\,\\}]+";
		input = input.replaceAll("\\[", "").replaceAll("\\]","");
		String[] strs = input.split(delim1);
	    String needle=strs[2];
	    // index 0 is empty
	    // index 1 is needle
	    // index 2 is what I need
	    // index 3 is haystack
	    // System.out.println(needle + " needle");
	    for(int i=4; i<strs.length;i++){
			System.out.println(strs[i]);
				if(strs[i].equals(needle)){
					indexOfNeedle = i-4;
					System.out.println(indexOfNeedle);
					break;
				}
			}
			
	}
	
	/**
	 * Method to make a http post request to get the information as string
	 * @throws Exception  this is if something wrong happen to show the problems
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
		getIndexNeedle(response.toString());
		System.out.println(response.toString());

	}
	
	/**
	 * Method to send by http post the token and the index of needle value
	 * @param link2 this is an url in which is going to sent the index of the needle
	 * @throws Exception this is if something wrong happen to show the problems
	 */
	public void sendPost(String link2) throws Exception {
		
		String url = link2;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "token="+key+ "&needle="+indexOfNeedle;

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
