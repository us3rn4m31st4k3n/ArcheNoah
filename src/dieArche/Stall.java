package dieArche;

import java.util.LinkedList;

import tiergenerator.Tier;

public class Stall<T extends Tier> extends LinkedList<T> {

	// LinkedList<Tier> this = new LinkedList<>();
	String order = "";

	@Override
	public boolean add(T inputAnimal) {
		int place = 0;
		for (T c : this) {
			if (placeFree(c, inputAnimal) == false) {
				System.out.println(inputAnimal.getTierart() + "is already there");
				return false;
			} else {
				place++;
			}
		}
		this.add(getPlace(inputAnimal), inputAnimal);
		// this.toString();
		return true;
	}

	private boolean placeFree(T c, T inputAnimal) {
		// TODO Auto-generated method stub
		if (c.getTierart() == inputAnimal.getTierart() && c.getGeschlecht() == inputAnimal.getGeschlecht()) {
			return false;
		} else {
			return true;
		}

	}

	private int getPlace(T inputAnimal) {//big big big big problems!!!!
		int i = 0;
		if (this.size()>0) {
			System.out.println(i);
			System.out.println(this.size());
			System.out.println(this.get(i).getTierart());
			System.out.println(inputAnimal.getTierart());
			while ((this.get(i).getTierart() != inputAnimal.getTierart()) && i < this.size()) {
				i++;
			}

			if (i == this.size() - 1) {
				return 0;
			} else {
				return i + 1;
			}
		} else {
			return 0;
		}

		// if(i==stallSet.size()-1) {
		// stallSet.addFirst(inputAnimal);
		// }else {
		// if(stallSet.get(i).getGeschlecht()=='M') {
		// stallSet.add(i+1, inputAnimal);
		// }else {
		// stallSet.add(i-1, inputAnimal);
		// }
		// }

	}

	@Override
	public String toString() {
		for (Tier c : this) {
			order = order + c.getTierart() + "(" + c.getGeschlecht() + ")|";

		}
		return order;

	}
}