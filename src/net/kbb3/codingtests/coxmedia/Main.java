package net.kbb3.codingtests.coxmedia;


/**
 * PP 1.4: In the programming language of your choice, 
 * write a program that parses a sentence and replaces 
 * each word with the following: first letter, number 
 * of distinct characters between first and last character, 
 * and last letter.  For example, Smooth would become S3h.  
 * Words are separated by spaces or non-alphabetic characters 
 * and these separators should be maintained in their original 
 * form and location in the answer.
 * 
 * @author Android1
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Input: Smooth");
		System.out.println("Output: " + CharCountSentenceEncoder.getInstance().encodeSentence("Smooth"));

		System.out.println("Input: Smooth sailing from now on");
		System.out.println("Output: " + CharCountSentenceEncoder.getInstance().encodeSentence("Smooth sailing from now on"));
		
		System.out.println("Input: Smooth#sailing%from&now*on");
		System.out.println("Output: " + CharCountSentenceEncoder.getInstance().encodeSentence("Smooth#sailing%from&now*on"));		
	}

}
