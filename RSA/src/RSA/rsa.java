package RSA;

public class rsa {
	public static double gcd(double a, double b)
	{
			
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}
	public static void main(String[] args)
	{
		double i;
		double p,q,n,et,e,d=1;
		double m,c=1;
		p = 7;//prime no 1
		q = 13;//prime no 2
		n = p*q;//product of primes
		et = (p-1) * (q-1);
		/* @reference https://www.securecoding.cert.org/confluence/display/java/
		 * EXP52-J.+Use+braces+for+the+body+of+an+if%2C+for%2C+or+while+statement */
		for(i=2;i<=et;i++)
		{
			if(gcd(i,et)==1){
				break;
			}
		}
		e=i;
		System.out.println("value of e is:"+e);
		for(i=2;i<=n;i++)
		{
		/* @reference https://www.securecoding.cert.org/confluence/display/java/
		 * EXP53-J.+Use+parentheses+for+precedence+of+operation
		 * Parentheses have been employed for the expression e*i % et == 1*/
			if((e*i)%et == 1){
				break;
			}
		}
		d=i;
		System.out.println("value of d is:"+d);
		//encryption
		m = 10;
		for(i=1;i<=e;i++)
		{
			c=(c*m)%n;
			c=c%n;
		}
		System.out.println("\n Cipher text :"+c);
		
		//decryption
		double m1=1;
		for(i=1;i<=d;i++)
		{
			m1=(m1*c)%n;
			m1=m1%n;
		}
		System.out.println("\n Plain text :"+m1);
		
		
		
	}

}
