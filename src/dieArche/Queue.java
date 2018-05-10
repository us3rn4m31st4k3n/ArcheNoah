package dieArche;

import tiergenerator.*;

import java.util.*;

public class Queue extends LinkedList<Tier> { // we chose LinkedList as the fitting Collection because it enables us to edit elements in the List

	Tiergenerator animalGen = new Tiergenerator(); // to be able to generate animals we need to create an object of the class Tiergenerator

	/***
	 * @brief generates the queue with the given amount of animals in it 
	 * @param numOfAnimals
	 */
	public void generateAnimalQ(int numOfAnimals) {
		for (int i = 0; i < numOfAnimals; i++) {
			Tier tier = animalGen.getTier();	// a new random animal is created
			add(tier);							// and added to the list (at the end)
		}
	}

	/***
	 * @brief prints out the queue which was created before
	 */
	public void printWarteschlange() {
		String animalStr = ""; 	//to avoid accumulation of the String the String is reset to an empty one
		for (int i = size() - 1; i >= 0; i--) {
			Tier tier = get(i);
			animalStr += tier.getTierart() + " (" + tier.getGeschlecht() + ")" + " | ";
		}
		System.out.println(animalStr);
	}

	/***
	 * @brief removes all elements which belong to the class Vogel
	 * @return number of birds which flew away
	 */
	public int sturm() {

		int numBirdsFlewAway = 0;	// to avoid accumulation again (see above with animalStr)

		for (int i = 0; i < size() - 1; i++) {	// the whole List is scanned for Objects with the class Vogel

			if (get(i) instanceof Vogel) {
				System.out.println(get(i).getTierart() + " flew away...");
				remove(i);
				numBirdsFlewAway++;

			}

		}

		System.out.println(numBirdsFlewAway + " bird(s) flew away!");
		return numBirdsFlewAway;
	}

	/***
	 * @brief all predators eat the animal in front of them (with certain conditions)
	 * @return number of animal that were eaten during the feast
	 */
	public int grossesFressen() {
		int animalsEaten = 0;
		boolean alreadyAte = false;
		for (int i = size() - 1; i >= 1; i--) {

			if (get(i).getRaubtier() == true && alreadyAte == false) {
				if (get(i - 1).getRaubtier() == false && get(i - 1) instanceof Reptil) { 	// temporal type
					if (((Reptil) get(i - 1)).getGiftig() == false) { 						// cast required
						System.out.println(get(i - 1).getTierart() + " was eaten" + " by " + get(i).getTierart() + "...");
						remove(i - 1);
						animalsEaten++;
						alreadyAte = true; 	// boolean to avoid double eating (is checked in condition)
					}
				} else if (get(i - 1).getRaubtier() == false) {
					System.out.println(get(i - 1).getTierart() + " was eaten" + " by " + get(i).getTierart() + "...");
					remove(i - 1);
					animalsEaten++;
					alreadyAte = true;
				}

			}

		}
		System.out.println(animalsEaten + " animal(s) tasted well!");
		return animalsEaten;
	}

	public static void main(String[] args) {
		Queue animalQ = new Queue();

		animalQ.generateAnimalQ(10);
		animalQ.printWarteschlange();
		animalQ.sturm();
		animalQ.printWarteschlange();
		animalQ.grossesFressen();
		animalQ.printWarteschlange();

	}

}
