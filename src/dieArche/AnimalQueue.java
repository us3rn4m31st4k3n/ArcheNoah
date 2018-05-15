package dieArche;

import tiergenerator.Reptil;
import tiergenerator.Saeuger;
import tiergenerator.Tier;
import tiergenerator.Tiergenerator;
import tiergenerator.Vogel;

import java.util.*;

/***
 * @description program simulates the arch
 * @author Jean-Luc Busch
 *
 */

public class AnimalQueue extends LinkedList<Tier> {
	String printedQueue;

	// LinkedList<Tier> aque = new LinkedList<Tier>();
	/***
	 * @author Jean-Luc Busch
	 * @description standard constructor. Creates a queue of 10 animals
	 */
	public AnimalQueue() {
		for (int i = 0; i < 10; i++) {

			this.add(Tiergenerator.getTier());
		}
	}

	/***
	 * @author Jean-Luc Busch
	 * @description overloaded constructor. Creates a queue of given length bei
	 *              param length
	 * @param length,type
	 *            of integer
	 */
	public AnimalQueue(int length) {
		for (int i = 0; i < length; i++) {
			this.add(Tiergenerator.getTier());
		}
	}

	/***
	 * @description this method increase the queue by 10 animals
	 */
	public void queueIncreasement() {
		for (int i = 0; i < 10; i++) {
			this.add(Tiergenerator.getTier());
		}
		printQueue();
	}

	/***
	 * @description overloaded method. Increases the length of animals by param
	 *              CountOfNewAnimals
	 * @param CountOfNewAnimals,type
	 *            of integer
	 */
	public void queueIncreasement(int CountOfNewAnimals) {
		for (int i = 0; i < CountOfNewAnimals; i++) {
			this.add(Tiergenerator.getTier());
		}
		printQueue();
	}

	/***
	 * @description prints the queue on the desktop
	 */
	public void printQueue() {

		for (int i = 0; i < this.size(); i++) {
			Tier tierCache = this.get(i);
			System.out.print(tierCache.getTierart() + "(" + tierCache.getGeschlecht() + ")");// prints the art and sex
																								// on the screen
			if (i != this.size() - 1) {// if the last animal is not reached an seprator "|" will be print
				System.out.print("|");
			}
		}
		System.out.println();
	}

	/***
	 * @description determine all birds of the queue
	 */
	public void storm() {
		int count = 0;// variable of type integer to count the bird who flew away
		for (int i = 0; i < this.size(); i++) {// goes through all elements of the queue...
			if (this.get(i) instanceof Vogel) {// and proofs whether the animal is an bird. If its a bird it will be
												// remove of the queue
				System.out.println(this.get(i).getTierart() + " flew away");// and will be printed on the screen.
				this.remove(i);
				i--;// The index of the pointer is reduced by on because on animal are eliminated.
				count++;// Count of birds who flew plus one
			}
		}
		System.out.println(count + " animal(s) flew away!");// Gives the whole count of eliminated birds on the screen
		printQueue();// prints the queue on the screen
	}

	/***
	 * @description meateater eats the animal before them if it is a possible victim
	 */
	public void eat() {
		int count = 0;// count variable for counting eaten animals
		for (int i = 1; i < this.size(); i++) {// goes through the whole queue and proofs
			if (this.get(i).getRaubtier()) { // if the element is a predator
				if (isVictim(i)) {// if it is, it proofs whether the animal before him is a possible victim
					System.out.println(this.get(i).getTierart() + " ate " + this.get(i - 1).getTierart());// if it is,
																											// this
																											// prints on
																											// screen
																											// which
																											// animal
																											// ate the
																											// animal
																											// before
																											// him

					this.remove(i - 1);// the victim will be removed-it´s dead=)
					i--;// The index of the pointer is reduced by on because on animal are eliminated.
					count++;// The count of eaten animals is higher by one
				}
			}
		}
		System.out.println(count + " animal(s) tasted well!");// Gives back how many animals are eaten
		printQueue();// prints the queue on the screen
	}

	/***
	 * @description proofs whether a animal can be eaten
	 * @param index,
	 *            type of integer, its the place of the hungry animal
	 * @return true if the place before is a victim, false if not
	 */
	private boolean isVictim(int index) {
		if (this.get(index - 1).getRaubtier() == false) {// proofs if the "victim" is meateater
			if (this.get(index - 1) instanceof Reptil) {// proofs it the victim is a reptile...
				return ((Reptil) this.get(index - 1)).getGiftig();// returns a true if the reptile is not poisoned
			}
			return true;// returns true
		} else {
			return false;// if it is predator too, it returns false
		}

	}

	/***
	 * @description the first animal leaves the queue
	 * @return the outgoing animal
	 */
	private Tier progress() {

		Tier outgoingAnimal = this.getFirst();
		this.removeFirst();
		return outgoingAnimal;

	}

	/***
	 * @description the whole queue are sorted in the stalls. But only one
	 *              pair(male/female) of a type are in one stall
	 * @param birdStall
	 * @param reptileStall
	 * @param mammalStall
	 */
	public void sort(Stall<Vogel> birdStall, Stall<Reptil> reptileStall, Stall<Saeuger> mammalStall) {
		int count = this.size();
		for (int i = 0; i < count; i++) {

			Tier candidate = progress();// the first animal of the queue is called.It will be proofed which art of
										// animal it is to sort it into the right stall.
			if (candidate instanceof Reptil) {
				reptileStall.add((Reptil) candidate);

			}
			if (candidate instanceof Saeuger) {
				mammalStall.add((Saeuger) candidate);

			}
			if (candidate instanceof Vogel) {

				birdStall.add((Vogel) candidate);

			}
		}
		// System.out.println(reptileStall.toString());
		// System.out.println(mammalStall.toString());
		// System.out.println(birdStall.toString());

	}

	/***
	 * @description overloaded method, this method reduce the queue by the parameter
	 *              length and sorts the animals into the right stall
	 * @param length
	 * @param birdStall
	 * @param reptileStall
	 * @param mammalStall
	 */
	public void sort(int length, Stall<Vogel> birdStall, Stall<Reptil> reptileStall, Stall<Saeuger> mammalStall) throws queueToShortException  {
//		System.out.println(length);
//		System.out.println(this.size());
		if(length>this.size()) {
			throw new queueToShortException(length,this.size());
		}
		int count = length;
		for (int i = 0; i < count; i++) {

			Tier candidate = progress();// the first animal of the queue is called.It will be proofed which art of
										// animal it is to sort it into the right stall.
			if (candidate instanceof Reptil) {
				reptileStall.add((Reptil) candidate);

			}
			if (candidate instanceof Saeuger) {
				mammalStall.add((Saeuger) candidate);

			}
			if (candidate instanceof Vogel) {

				birdStall.add((Vogel) candidate);

			}
		}
		// System.out.println(reptileStall.toString());
		// System.out.println(mammalStall.toString());
		// System.out.println(birdStall.toString());

	}
}
