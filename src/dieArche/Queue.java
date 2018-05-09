package dieArche;

import tiergenerator.*;

import java.util.*;

public class Queue extends LinkedList<Tier> {

	Tiergenerator animalGen = new Tiergenerator();

	private int numOfAnimals;

	public void generateAnimalQ(int numOfAnimals) {
		for (int i = 0; i < numOfAnimals; i++) {
			Tier tier = animalGen.getTier();
			add(tier);
		}
	}

	public void printWarteschlange() {
		String animalStr = "";
		for (int i = size()-1; i >= 0; i--) {
			Tier tier = get(i);
			animalStr += tier.getTierart() + " (" + tier.getGeschlecht() + ")" + " | ";
		}
		System.out.println(animalStr);
	}

	public int sturm() {

		int numBirdsFlewAway = 0;
		
		for (int i = 0; i < size() - 1; i++) {

			if (get(i) instanceof Vogel) {
				System.out.println(get(i).getTierart() + " flew away...");
				remove(i);
				numBirdsFlewAway++;

			}

		}

		System.out.println(numBirdsFlewAway + " bird(s) flew away!");
		return numBirdsFlewAway;
	}

//	
//				Request	
//				for
//				Comment
//	
//	
	public int grossesFressen() {
		int animalsEaten = 0;
		boolean alreadyAte=false;
		for (int i = size()-1; i >= 1; i--) {
			
			if (get(i).getRaubtier() == true && alreadyAte == false) {
				if (get(i - 1).getRaubtier() == false && get(i-1) instanceof Reptil) {	// temporal type
					if(((Reptil) get(i - 1)).getGiftig() == false) {																					// cast required
					System.out.println(get(i - 1).getTierart() + " was eaten" + " by " + get(i).getTierart() + "...");
					remove(i - 1);
					animalsEaten++;
					alreadyAte = true;
					}
				}
				else if(get(i - 1).getRaubtier() == false) {
					System.out.println(get(i - 1).getTierart() + " was eaten" + " by " + get(i).getTierart() + "...");
					remove(i - 1);
					animalsEaten++;
					alreadyAte = true;
				}
				
			}

		}
		System.out.println(animalsEaten+ " animal(s) tasted well!");
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
