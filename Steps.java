/**
 * Class for setting the methods to test all the steps
 * @author Axel Solano
 *
 */
public class Steps {
	
	private String key = "";
	
	/**
	 * In this constructor I set up the key which is going to be
	 * used for the other classes
	 * @param key a String variable that represent the token
	 */
	public Steps(String key){
		this.key=key;
	}
	
	/**
	 * Method to set up the Class Step1 which
	 * correspond to the Step 1 
	 * @param link a String variable which represents the first link to get the information
	 * @param github a String variable which represents 
	 * @throws Exception  this is if something wrong happen to show the problems
	 */
	public void step1(String link, String github) throws Exception{
		Step1 s1 = new Step1(key,github);
		s1.sendPost(link);
	}
	/**
	 * Method to set up the Class Step2 which
	 * correspond to the Step 2
	 * @param link1 a String variable which represents the first link to get the information
	 * @param link2 a String variable which represents the second link in which I going to return the information
	 * @throws Exception this is if something wrong happen to show the problems
	 */
	public void step2(String link1, String link2) throws Exception{
		Step2 s2 = new Step2(key,link1);
		s2.getPost();
		s2.sendPost(link2);
	}
	
	/**
	 * Method to set up the Class Step3 which
	 * correspond to the Step 3
	 * @param link1 a String variable which represents the first link to get the information
	 * @param link2 a String variable which represents the second link in which I going to return the information
	 * @throws Exception this is if something wrong happen to show the problems
	 */
	public void step3(String link1, String link2) throws Exception{
		Step3 s3 = new Step3(key,link1);
		s3.getPost();
		s3.sendPost(link2);
	}

	/**
	 * Method to set up the Class Step4 which
	 * correspond to the Step 4
	 * @param link1 a String variable which represents the first link to get the information
	 * @param link2 a String variable which represents the second link in which I going to return the information
	 * @throws Exception this is if something wrong happen to show the problems
	 */
	public void step4(String link1, String link2) throws Exception{
		Step4 s4 = new Step4(link1,key );
		s4.getPost();
		s4.addOnlyWithoutPrefix();
		s4.sendPost(link2);
	}
	
	/**
	 * Method to set up the Class Step5 which
	 * correspond to the Step 5
	 * @param link1 a String variable which represents the first link to get the information
	 * @param link2 a String variable which represents the second link in which I going to return the information
	 * @throws Exception this is if something wrong happen to show the problems
	 */
	public void step5(String link1, String link2) throws Exception{
		Step5 s5 = new Step5(link1,key);
		s5.getPostof5();
		s5.addSeconds();
		s5.sendPost(link2);
	}
	
}
