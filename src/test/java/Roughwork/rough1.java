package Roughwork;

import org.apache.commons.lang3.RandomStringUtils;

public class rough1 {

	public String randomAlphaNumeric()
	{
		String generatealphanum=RandomStringUtils.randomAlphanumeric(0);
				return generatealphanum;
	}
	public String randomNumer()
	{
		String generatenum=RandomStringUtils.randomNumeric(10);
				return generatenum;
	}
	
	public String randomString()
	{
		
		String generateString=RandomStringUtils.randomAlphabetic(0);
		return generateString;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rough1 r=new rough1();
		System.out.println(r.randomAlphaNumeric());;
		System.out.println(r.randomNumer());;
		System.out.println(r.randomString());;
		
	}

}
