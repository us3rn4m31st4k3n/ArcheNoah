package dieArche;

import java.util.*;
import tiergenerator.*;

public class Stall<T extends Tier> extends LinkedList <T>{
				 //^ ^^^^^^^ ^^^^ we were asked for the ability to put in Objects T,
				 //as we want the Objects T to be animals T has to be a subclass of Tier

	public String animalString (T e) {
	
		String animalString = "";
		animalString = ((tiergenerator.Tier) e).getTierart() + " ("+ e.getGeschlecht() + ")";
		return animalString;
	}
	
	
	public void finalCheck() {
		for(int j=0; j<10;j++) {
		for(int i= size()-2;i>=0;i--) {
			if(get(i).getTierart().equals(get(i+1).getTierart()) && get(i).getGeschlecht() == get(i+1).getGeschlecht()){
				
				remove(i);
				System.out.println("Duplicate "+ animalString(get(i)) + " removed");
				}
		}
		}
	}
	
	@Override
	public boolean add(T e) {	
	if(isEmpty()==true) { // to avoid nullPointerExceptions I implemented this condition
		add(size(),e);
		return true;
	}
	
		for(int i= size()-1;i>=0;i--) {
			if(e.getTierart().equals(get(i).getTierart())) {
				
				if(e.getGeschlecht() != get(i).getGeschlecht()) { // if sex is different the animal can be added to the list
				add(i, e);
				finalCheck();
				return true;
				}
				else if(e.getGeschlecht() == get(i).getGeschlecht()) { // if sex is equal the element is NOT added at all
				remove(e);
				System.out.println("excessive " + animalString(e) +" removed");
				finalCheck();
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
			T tier = get(i);
			animalStr += animalString(tier) + " | ";
		}
		return animalStr;
	}
	
	public static void main(String[]Args) {
		Stall tierStall = new Stall<>();
		
		Tiergenerator animalGen = new Tiergenerator();
		
		for(int i=0;i<50;i++) {
		Tier tier = animalGen.getTier();
		tierStall.add(tier);
		}
		System.out.println(tierStall.toString());
	}

}
