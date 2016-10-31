
/**
 * Class to test all the steps in order to check if all works correctly
 * @author Axel Solano
 *
 */

public class StepMain {
	
	/**
	 * Method to test all the steps
	 * 
	 * @param args string array which is not used in this occasion
	 * @throws Exception  this is if something wrong happen to show the problems
	 */
	
	public static void main(String[] args) throws Exception {
		
		String name = "Axel Solano";
		String st = "\""+name+ "\"";
		
		System.out.println(st);
		

		Steps s = new Steps("625e546a20c2f6d4b7dabe8be841a23e");
	
		s.step1("http://challenge.code2040.org/api/register", "github.com/axeljeremy7/chal1");
		
		s.step2("http://challenge.code2040.org/api/reverse", "http://challenge.code2040.org/api/reverse/validate");
		
		s.step3("http://challenge.code2040.org/api/haystack","http://challenge.code2040.org/api/haystack/validate");
		
		s.step4("http://challenge.code2040.org/api/prefix","http://challenge.code2040.org/api/prefix/validate");
		
		s.step5("http://challenge.code2040.org/api/dating","http://challenge.code2040.org/api/dating/validate");
		

	}
	
	

	
	

   			

		
		

}
