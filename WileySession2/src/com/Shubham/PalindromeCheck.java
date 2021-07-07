package com.Shubham;

import java.util.Scanner;

public class PalindromeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter to check Palindrome");
		str = sc.next();
		PalindCheck(str);
	}
	public static void PalindCheck(String str) {
		try {
			int num = Integer.parseInt(str);
			System.out.println("It's a number");
			int rem=0;
			String checkPal="";
			while(num>0) {
				rem=num%10;
				checkPal=checkPal+rem;
				num=num/10;
			}
			if(checkPal.equals(str))
				System.out.println("Palindrome Number");
			else
				System.out.println("Not a Palindrome Number");
		}
		catch(Exception e){
			System.out.println("It's a String ");
			StringBuilder checkPal = new StringBuilder();
			checkPal.append(str);
			checkPal.reverse();
			if(checkPal.toString().equalsIgnoreCase(str))
				System.out.println("Palindrome String");
			else
				System.out.println("Not Palindrome String");
		}
	}

}
