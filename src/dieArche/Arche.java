package dieArche;
import tiergenerator.*;
public class Arche {
	Stall<Vogel> vogelStall = new Stall<>();
	Stall<Saeuger> saeugerStall = new Stall<>();
	Stall<Reptil> reptilStall = new Stall<Reptil>();

	/***
	 * @brief distribution of the elements to their adequate stalls 
	 * @param animal
	 * @return
	 */
	public boolean add(Tier animal) {
		
		if(animal instanceof Vogel) {
			vogelStall.add((Vogel) animal);
			return true;
		}
		else if(animal instanceof Saeuger) {
			saeugerStall.add((Saeuger) animal);
			return true;
		}
		else if(animal instanceof Reptil) {
			reptilStall.add((Reptil) animal);
			return true;
		}
		return false;
	} 

	/***
	 * @brief printing the content of all three stalls
	 */
	public void printStallBelegung() {
		
		System.out.println("Vogel-Stall");
		System.out.println(vogelStall.toString() + "\n");
		System.out.println("------------------------------------------------------");
		System.out.println("Säuger-Stall");
		System.out.println(saeugerStall.toString() + "\n");
		System.out.println("------------------------------------------------------");
		System.out.println("Reptil-Stall");
		System.out.println(reptilStall.toString());
		
	}
	
	public static void main(String[]Args) {
		Arche noah = new Arche();
		Tiergenerator animalGen = new Tiergenerator();
		
		for(int i=0;i<20;i++) {
		Tier tier = animalGen.getTier();
		noah.add(tier);
		}
		
		noah.printStallBelegung();
		
	}
	
}
