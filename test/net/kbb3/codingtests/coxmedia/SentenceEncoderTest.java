package net.kbb3.codingtests.coxmedia;

import static org.junit.Assert.*;

import org.junit.Test;

public class SentenceEncoderTest {

	@Test
	public void testEncodeSentence() {
		assertEquals("S3h",CharCountSentenceEncoder.getInstance().encodeSentence("Smooth"));

		assertEquals("S3h s4g f2m n1w on",
				CharCountSentenceEncoder.getInstance().encodeSentence("Smooth sailing from now on"));
		
		assertEquals("S3h#s4g%f2m&n1w*on",
				CharCountSentenceEncoder.getInstance().encodeSentence("Smooth#sailing%from&now*on"));
	}

}
