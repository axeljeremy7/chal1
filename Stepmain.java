import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Stack;

import javax.net.ssl.HttpsURLConnection;
public class Stepmain {
	
	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stepmain http = new Stepmain();

		

		System.out.println("\nSend Http POST request");
		//http.sendPost();
		//http.reverseWord("MESSI is the best");


	}
	
	
	
		private void sendPost() throws Exception {

			String url = "http://challenge.code2040.org/api/register";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			

			String urlParameters = "token=625e546a20c2f6d4b7dabe8be841a23e&github=github.com/axeljeremy7/chal1";

			
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			

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
	
	private void sendPosStep2t() throws Exception {

			
			String url = "http://challenge.code2040.org/api/reverse/validate";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = "token=625e546a20c2f6d4b7dabe8be841a23e&string="+strtoreturn;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			

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
		
		private void reverseWord(String str){
			char [] ar = str.toCharArray();
			int size = ar.length;
			String st = "";
			for(int i = size-1; i >=0; i--){
				st =st + ar[i];
			}
			System.out.println(st);
			
			
		}

}
