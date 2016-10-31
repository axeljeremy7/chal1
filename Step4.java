import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Contains the methods to accomplish
 * the Step 4 of the Tech Assessment
 * @author Axel Solano
 *
 */
public class Step4 {
	
	private String url="";
	private final String USER_AGENT = "Mozilla/5.0";
	private String input="";
	private String key = "";
	private JSONObject ob;
	private JSONArray arr;
	
	
	/**
	 * Constructor to set up the key and the first link
	 * @param key the token
	 * @param url  the first link is to get the information
	 */
	public Step4(String url, String key){
		this.url=url;
		this.key=key;
	}
	
	/**
	 * Method to set an array that not contains the prefix that is received by the first link
	 * the array has to maintain the order that was when it was received
	 * @throws JSONException this is if something wrong happen to show the problems
	 */
    public void addOnlyWithoutPrefix() throws JSONException{
    	String delim1 = "[{\\:\"\"\\,\\}]+";
    	input = input.replaceAll("\\[", "").replaceAll("\\]","");
		String[] strs = input.split(delim1);
	   	String prefix=strs[2];
	   	
	   	//System.out.println( prefix);
	   	
	    arr = new JSONArray();
	   
	    for(int i=4; i<strs.length;i++){
			
			if(  !(strs[i].startsWith(prefix))){
				
				arr.put(strs[i]);  // "\""+name+ "\""  "\""
				//System.out.println( strs[i] );
				
			}
	    }
	
    }
    
    /**
	 * Method to send by http post the token and the array
	 * @param urltosent this is an url in which is going to sent the array
	 * @throws Exception this is if something wrong happen to show the problems
	 */
	
	public void sendPost(String urltosent) throws Exception{
		String url = urltosent;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type","application/json; charset=utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setDoOutput(true);
	
		ob = new JSONObject();
		ob.put("token", key);
		ob.put("array", arr);

		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.write(ob.toString().getBytes());
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
	 * Method to make a http post request to get the information as string
	 * @throws Exception  this is if something wrong happen to show the problems
	 */
	public void getPost() throws Exception {

		String url = this.url;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

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
		input = response.toString();
		System.out.println(response.toString());

	}
	
	

}
