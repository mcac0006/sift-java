/**
 * 
 */
package com.mcac0006.siftscience.exception;

/**
 * Used whenever an error has occurred during sending, receiving, marshal or 
 * demarshal of an event/label/score.
 * 
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class SiftScienceException extends RuntimeException {

	private static final long serialVersionUID = -8699213474050478659L;

	public SiftScienceException(final String msg, final Throwable t) {
		super(msg, t);
	}
}
