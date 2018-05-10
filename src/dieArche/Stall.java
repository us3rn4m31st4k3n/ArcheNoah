package dieArche;

import java.util.*;
import tiergenerator.*;

public class Stall extends LinkedList <Tier> {

	public String animalString (Tier e) {
		String animalString = "";
		animalString = e.getTierart() + " ("+ e.getGeschlecht() + ")";
		return animalString;
	}
	
	
	public void finalCheck() {
		for(int i= size()-2;i>=0;i--) {
			if(get(i).getTierart().equals(get(i+1).getTierart()) && get(i).getGeschlecht() == get(i+1).getGeschlecht()){
				
				remove(i);
				System.out.println("Duplicate "+ animalString(get(i)) + " removed");
				}
		}
	}
	
	@Override
	public boolean add(Tier e) {	
	if(isEmpty()==true) { // to avoid nullPointerExceptions I implemented this condition
		add(size(),e);
		return true;
	}
	
		for(int i= size()-1;i>=0;i--) {
			if(e.getTierart().equals(get(i).getTierart())) {
				
				if(e.getGeschlecht() != get(i).getGeschlecht()) { // if sex is different the animal can be added to the list
				add(i, e);
				return true;
				}
				else if(e.getGeschlecht() == get(i).getGeschlecht()) { // if sex is equal the element is NOT added at all
				remove(e);
				System.out.println("excessive " + animalString(e) +" removed");
				return true;
				}
				
			}
			
		}
		finalCheck();
		add(size(),e); // independent of the previous actions the element is added to the head of the list
		return true;
	
	
	}
	
	
	@Override
	public String toString() {
		
		String animalStr = "";
		for (int i = size()-1; i >= 0; i--) {
			Tier tier = get(i);
			animalStr += animalString(tier) + " | ";
		}
		return animalStr;
	}
	
	public static void main(String[]Args) {
		Stall tierStall = new Stall();
		Queue checkQ = new Queue();
		Tiergenerator animalGen = new Tiergenerator();
		
		for(int i=0;i<20;i++) {
		Tier tier = animalGen.getTier();
		tierStall.add(tier);
		}
		System.out.println(tierStall.toString());
	}

}
