package dieArche;

/***
 * 
 * @author Jean-Luc Busch
 * @description if the queue will be reduced more than the size of the queue is,
 *              this Exception is thrown
 */
public class queueToShortException extends Exception {
	int length;
	int size;

	/***
	 * @description constructor
	 * @param length
	 * @param size
	 */
	queueToShortException(int length, int size) {
		this.length = length;
		this.size = size;
	}

	@Override

	/***
	 * @description overriden method, it puts the the important information on the
	 *              screen. The size of the queue and the planned value of reducing
	 */
	public String toString() {
		return ("Queue is to short. It will be reduce by: " + length + ". Size is: " + size);
	}
}
