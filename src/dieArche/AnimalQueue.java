package dieArche;

import tiergenerator.Reptil;
import tiergenerator.Tier;
import tiergenerator.Tiergenerator;
import tiergenerator.Vogel;

import java.util.*;

public class AnimalQueue extends LinkedList<Tier> {
	String printedQueue;
	// LinkedList<Tier> aque = new LinkedList<Tier>();

	public AnimalQueue() {
		for (int i = 0; i < 10; i++) {

			this.add(Tiergenerator.getTier());
		}
	}

	public AnimalQueue(int length) {
		for (int i = 0; i < length; i++) {
			this.add(Tiergenerator.getTier());
		}
	}

	public void printQueue() {

		for (int i = 0; i < this.size(); i++) {
			Tier tierCache = this.get(i);
			System.out.print(tierCache.getTierart() + "(" + tierCache.getGeschlecht() + ")");// Erklärung für cast
			if (i != this.size() - 1) {
				System.out.print("|");
			}
		}
		System.out.println();
	}

	public void storm() {
		int count = 0;
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i) instanceof Vogel) {
				System.out.println(this.get(i).getTierart() + " flew away");
				this.remove(i);
				i--;
				count++;
			}
		}
		System.out.println(count + " animal(s) flew away!");
		printQueue();
	}

	public void eat() {
		int count = 0;
		for (int i = 1; i < this.size(); i++) {
			if (this.get(i).getRaubtier()) {
				if (isVictim(i)) {
					System.out.println(this.get(i).getTierart() + " ate " + this.get(i - 1).getTierart());

					this.remove(i - 1);
					i--;
					count++;
				}
			}
		}
		System.out.println(count + " animal(s) tasted well!");
		printQueue();
	}

	public boolean isVictim(int index) {
		if (this.get(index - 1).getRaubtier() == false) {
			if (this.get(index - 1) instanceof Reptil) {
				return ((Reptil) this.get(index - 1)).getGiftig();
			}
			return true;
		} else {
			return false;
		}

	}

	public Tier progress() {
		
			Tier outgoingAnimal = this.getFirst();
			this.removeFirst();
			return outgoingAnimal;
		
		
	}

}
