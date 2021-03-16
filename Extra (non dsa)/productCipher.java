//Only use samll letters  alphabets and space
//will not work for capital letter and other special symbol except space

import java.util.*;

public class ProductCipher {
	public static void main(String args[]) {
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter message:");
		String input = sc.nextLine();
		System.out.println("Enter a number of rows:");
		int n =sc.nextInt();
        System.out.println("Enter a substitution key:");
		int key =sc.nextInt();
		
		
		// Substitution encryption
		StringBuffer output = new StringBuffer();
		for(int i=0 ; i<input.length() ; i++) 
		{
			char c = input.charAt(i);
			if(c==32)
			  output.append("/");
			else
			  output.append((char)((97+(c-97+key+26)%26)));
		}
		System.out.println("\nAfter additive cipher:");
		System.out.println(output);

		// Transposition encryption
		String tInput =output.toString();
		int modulus;
		if((modulus = tInput.length()%n) != 0) 
		{
			modulus = n-modulus;
			for( ; modulus!=0 ; modulus--) 
			{
				tInput+= "/";
		    }
		}
		StringBuffer tOutput = new StringBuffer();
		System.out.println("\nTransposition Matrix:");
		for(int i=0 ; i<n ; i++) 
		{
			for(int j=0 ; j<tInput.length()/n ; j++) 
			{
				char c = tInput.charAt(i+(j*n));
				System.out.print(c+" ");
				tOutput.append(c);
			}
			System.out.println();
		}
		System.out.println("\nFinal encrypted text:");
		System.out.println(tOutput);


		// Transposition decryption
		n = tOutput.length()/n;
		StringBuffer tplaintext = new StringBuffer();
		for(int i=0 ; i<n ; i++) 
		{
			for(int j=0 ; j<tOutput.length()/n ; j++) 
			{
				char c = tOutput.charAt(i+(j*n));
				// System.out.print(c+" ");
				tplaintext.append(c);
			}
		}
		System.out.println();
		System.out.println("After transposition decryption:");
		tplaintext.setLength(output.length());
		System.out.println(tplaintext);
		System.out.println();
		// Substitution decryption
		StringBuffer plaintext = new StringBuffer();
		for(int i=0 ; i<tplaintext.length() ; i++) 
		{
			char c = tplaintext.charAt(i);
			if(c=='/')
			  	plaintext.append(" ");
			else
			    plaintext.append((char)(97+(c-97-key+26)%26));
		}

		System.out.println("After final decryption Plaintext is :");
		plaintext.setLength(input.length());
		System.out.println(plaintext);
	}
}