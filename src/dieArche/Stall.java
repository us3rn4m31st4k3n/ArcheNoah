package dieArche;

import java.util.LinkedList;

import tiergenerator.Tier;

/***
 * 
 * @author Jean-Luc Busch
 * @description this class symbolizes the stalls on the arch. There are only
 *              stalls for reptiles, birds, and mammals. Thats the reason why
 *              this class is a generic class
 * @param <T>,generic
 *            type
 */
public class Stall<T extends Tier> extends LinkedList<T> {

	// LinkedList<Tier> this = new LinkedList<>();
	int sortedPlace = -1;
	// int declined=0;

	@Override

	/***
	 * @description overriden add-method. This method adds an animal if an animal of
	 *              this art and sex isn´t there. If an animal is there of the same
	 *              art but with a different sex, the new animal are place next to
	 *              him
	 * @param <T>
	 *            inputAnimal, generic type
	 */
	public boolean add(T inputAnimal) {
		// int declined=0;
		int place = 0;// count variable to count the place where it could be add
		for (T c : this) {// go through all animals of the stall and proofs if the same animal is in there
			if (placeFree(c, inputAnimal, place) == false) {// if it is it will be declined
				System.out.println(inputAnimal.getTierart() + " is already there");
				sortedPlace = -1;
				// declined++;
				return false;
			} else {// else the next animal will be proof and the place counter gets plus one
				place++;
			}
		}
		if (sortedPlace == -1) {// if there isnt a animal of the same art, it will be add at the end
			this.add(place, inputAnimal);
		} else {// else it will be add to his friend
			this.add(sortedPlace, inputAnimal);
			sortedPlace = -1;
		}

		// this.add(getPlace(inputAnimal), inputAnimal);
		// this.toString();
		return true;
	}

	/***
	 * @description proofs whether to animals have the same sex and are the same art
	 * @param c
	 * @param inputAnimal
	 * @param place
	 * @return true if the animal isnt the same, false if it is the same
	 */
	private boolean placeFree(T c, T inputAnimal, int place) {
		// TODO Auto-generated method stub
		if (c.getTierart() == inputAnimal.getTierart()) {// proofs the art
			sortedPlace = place;// if it is the placed will be saved to add the animal next to him

			if (c.getGeschlecht() == inputAnimal.getGeschlecht()) {// proofs the sex
				return false;// if they have the same sex it returns false
			} else {
				return true;
			}

		}
		return true;
	}

	// private int getPlace(T inputAnimal) {// big big big big problems!!!!
	//
	// if (this.size() == 0) {
	// return 0;
	// } else if (this.size() == 1) {
	// return 1;
	//
	// } else {
	// int i = 0;
	// while (rightPlace(i, inputAnimal)) {
	// i++;
	// }
	// if (i == this.size() - 1) {
	// return i + 1;
	// } else {
	// return i;
	// }
	// }
	//
	// // if (this.size()>0) {
	// // System.out.println(i);
	// // System.out.println(this.size());
	// // System.out.println(this.get(i).getTierart());
	// // System.out.println(inputAnimal.getTierart());
	// // while ((this.get(i).getTierart() != inputAnimal.getTierart()) && i <
	// // this.size()) {
	// // i++;
	// // }
	// //
	// // if (i == this.size() - 1) {
	// // return 0;
	// // } else {
	// // return i + 1;
	// // }
	// // } else {
	// // return 0;
	// // }
	//
	// // if(i==stallSet.size()-1) {
	// // stallSet.addFirst(inputAnimal);
	// // }else {
	// // if(stallSet.get(i).getGeschlecht()=='M') {
	// // stallSet.add(i+1, inputAnimal);
	// // }else {
	// // stallSet.add(i-1, inputAnimal);
	// // }
	// // }
	//
	// }
	//
	// private boolean rightPlace(int i, T inputAnimal) {
	// boolean sameArt = false;
	// boolean firstExemplar = false;
	// System.out.println(this.get(i));
	// System.out.println(inputAnimal.getTierart());
	// if (this.get(i).getTierart() != inputAnimal.getTierart()) {
	// sameArt = true;
	// }
	// if (i == this.size()) {
	// firstExemplar = true;
	// }
	// if (sameArt && !firstExemplar) {
	// return true;
	// } else {
	// return false;
	// }
	//
	// }
	/***
	 * @description gives the stall on the screen
	 */
	@Override
	public String toString() {
		String order = "";
		for (Tier c : this) {

			order = order + c.getTierart() + "(" + c.getGeschlecht() + ")|";

		}
		return order;

	}
}