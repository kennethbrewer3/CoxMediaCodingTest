package net.kbb3.codingtests.coxmedia;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.ArrayUtils;

/**
 * A concrete SentenceEncoder that has a method that returns a String
 * of the sentence passed to it. The encoding that occurs is that each
 * word in the sentence is spaced apart by a space character. Each word
 * in the sentence is replaced by a word with the start and end characters
 * left intact, and the center replaced by the count of the unique 
 * occurrences of each character in the word.
 * 
 * @author Kenneth Brewer
 *
 */
public class CharCountSentenceEncoder implements SentenceEncoder {

	private static CharCountSentenceEncoder instance;
	
	private CharCountSentenceEncoder(){}
	
	public static CharCountSentenceEncoder getInstance() {
		if(instance == null) {
			instance = new CharCountSentenceEncoder();
		}
		
		return instance;
	}
	
	@Override
	public String encodeSentence(String sentence) {
		StringBuilder builder = new StringBuilder();
		
		if(sentence.isEmpty()) return sentence;
		
		//Split on all non-alpha characters
		String[] tokens = sentence.split("[^a-zA-Z]");
		
		
		//If there are more than one token then build the string
		//based on the multiple tokens. Otherwise just return the
		//single token after encoding it.
		if(tokens.length > 1) {
			char[] separators = getSeparators(sentence,tokens);

			for(int counter = 0; counter < tokens.length; counter++) {
				builder.append(encodeToken(tokens[counter]));
				
				if(counter < separators.length) {
					builder.append(separators[counter]);
				}
			}
		} else {
			builder.append(encodeToken(tokens[tokens.length-1]));
		}
		
		return builder.toString();
	}
	
	//Encode the string to match the criteria of
	//[first char][unique char count][last char]
	//since this requires at least three characters
	//the method returns the exact token back if
	//the parameter has less than three characters.
	private String encodeToken(String token) {
		if(token.length() <= 2) return token;
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(token.charAt(0));
		
		//Use Apache Commons Lang ArrayUtils to convert the substring into a
		//Character array needed to pass in to the Set constructor.
		Character[] middleCharsArray = ArrayUtils.toObject(token.substring(1, token.length()-1).toCharArray());
		
		Set<Character> middleChars = new TreeSet<Character>(Arrays.asList(middleCharsArray));
		
		builder.append(middleChars.size());
		
		builder.append(token.charAt(token.length()-1));
		
		return builder.toString();
	}
	
	//Get the separators more efficiently by basing the loop off of the
	//token position and length. This means that the loop does not need
	//to traverse the entire length of the string. Only the number of tokens
	//minus one.
	private char[] getSeparators(String sentence, String[] tokens) {
		char[] separators = new char[tokens.length - 1];

		int separatorLocation = -1;
		for(int counter = 0; counter < tokens.length - 1; counter++) {
			separatorLocation += tokens[counter].length()+1;
			separators[counter] = sentence.charAt(separatorLocation);
		}
		
		return separators;
	}

}
