import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Contains the methods to accomplish
 * the Step 5 of the Tech Assessment
 * @author Axel Solano
 *
 */


public class Step5 {
	
	private String input5="";
	private String url="";
	private String dateString="";
	private String key = "";
	private final String USER_AGENT = "Mozilla/5.0";
	
	/**
	 * Constructor to set up the key and the first link
	 * @param key the token
	 * @param url  the first link is to get the information
	 */
	public Step5(String url,String key){
		this.url=url;
		this.key=key;
	}
	
	/**
	 * Method to add the seconds received by the first link
	 * I use the calendar and timestamp class to add the seconds 
	 */
	public void addSeconds(){
     	 String delim1 = "[{\\:\"\"\\,\\-\\}]+";
		 input5 = input5.replaceAll("Z", ",").replaceAll("T",",");
		 String[] strs = input5.split(delim1);
		 
		 for(int i=0; i<strs.length;i++){
			System.out.println(strs[i] + "  index:"+ i);
			
		}
		
		int year = Integer.parseInt(strs[2]);
		int month = Integer.parseInt(strs[3]);
		int date = Integer.parseInt(strs[4]);
		int hour = Integer.parseInt(strs[5]);
		int minute = Integer.parseInt(strs[6]);
		int second = Integer.parseInt(strs[7]);
		
		int secondsToAdd = Integer.parseInt(strs[9]);
		// int year, int month, int date, int hour, int minute, int second, int nano
		
		
		Calendar cal1 = Calendar.getInstance();
		cal1.set(year, month-1, date, hour, minute, second);// january is 0
		long time1 = cal1.getTimeInMillis();
		 
	    Timestamp original = new Timestamp(time1);
	        
	    Calendar cal = Calendar.getInstance();
	        
	    cal.setTimeInMillis(original.getTime());
	        
	    cal.add(Calendar.SECOND, secondsToAdd);
	    
	    Timestamp later = new Timestamp(cal.getTime().getTime());
	     
	    System.out.println(original);
	      
	    System.out.println(later);
	    
	    String ans = later.toString();
	    char[] c = ans.toCharArray();
	    int index=0;
	    // elimating the miliseconds
	    for(int i=0; i<c.length;i++){
	    	if(c[i]=='.'){
	    		index=i;
	    	}
	    }
	    
	    ans=ans.substring(0, index);
	    //Above i use the index to obtain thei index in whic the milisecons starts
	    
	    ans = ans.replaceAll(" ", "T");// replacing accoring to the format
	    ans = ans + "Z";// adding accoring to the format
	    //System.out.println(ans);
	    dateString = ans;
	     
        }//
	
	/**
	 * Method to send by http post the token and the date as  ISO 8601 datestamp. 
	 * @param urltosent this is an url in which is going to sent the date
	 * @throws Exception this is if something wrong happen to show the problems
	 */
	public void sendPost(String urltosent) throws Exception{
		String url = urltosent;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "token="+key+"&datestamp="+dateString;
        
		
		con.setDoOutput(true);
	
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

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
	public void getPostof5() throws Exception {

			String url = this.url;
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = "token=625e546a20c2f6d4b7dabe8be841a23e";

			
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				
				response.append(inputLine);
			}
			in.close();
			input5= response.toString();
			System.out.println(input5);

		}

}
