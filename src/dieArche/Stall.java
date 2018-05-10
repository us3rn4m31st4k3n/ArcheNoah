package dieArche;

import java.util.*;
import tiergenerator.*;

public class Stall<T extends Tier> extends LinkedList <T>{
				 //^ ^^^^^^^ ^^^^ we were asked for the ability to put in Objects T,
				 //as we want the Objects T to be animals T has to be a subclass of Tier

	/***
	 * @brief a helping method to visualize the animal in a fitting way
	 * @param e (animal in a way)
	 * @return String in following style: Echse (M)
	 */
	public String animalString (T e) {
	
		String animalString = "";
		animalString = ((tiergenerator.Tier) e).getTierart() + " ("+ e.getGeschlecht() + ")";
		return animalString;
	}
	
	/***
	 * @brief method to ensure that there are no duplicates in the list 
	 */
	public void finalCheck() {

		for(int i= size()-2;i>=0;i--) {
			if(get(i).getTierart().equals(get(i+1).getTierart()) && get(i).getGeschlecht() == get(i+1).getGeschlecht()){ // checks if neighbor in front is the same sex and the same type of animal 
				
				remove(i); 	// if so, the duplicate is removed and a fitting output on the console is shown
				System.out.println("Duplicate "+ animalString(get(i)) + " removed");
				}
		}

	}
	
	
	@Override
	/***
	 * @brief overridden method which only adds the elemt if certain conditions are met
	 */
	public boolean add(T e) {	
	if(isEmpty()==true) { // to avoid nullPointerExceptions I implemented this condition
		add(size(),e);
		return true;
	}
	
		for(int i= size()-1;i>=0;i--) {
			if(e.getTierart().equals(get(i).getTierart())) { // only if the potential element equals another animal the following conditions are checked
				
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
	/***
	 * @brief overridden method which returns the String of the List
	 */
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
