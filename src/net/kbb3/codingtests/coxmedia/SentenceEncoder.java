package net.kbb3.codingtests.coxmedia;

/**
 * An interface that contains a method to accept a string and return a string. 
 * The method may do some conversion on the string or just pass it through.
 * @author Kenneth Brewer
 *
 */
public interface SentenceEncoder {
	public String encodeSentence(String sentence);
}
