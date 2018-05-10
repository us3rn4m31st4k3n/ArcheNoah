package dieArche;

public class Main {

	public static void main(String[] args) {
		Queue archeQ = new Queue();
		Arche noah = new Arche ();
		int qSize = 100;
		
		archeQ.generateAnimalQ(qSize);
		
		for(int i=0; i<qSize; i++) {
			noah.add(archeQ.get(i));
		}
		noah.printStallBelegung();

	}

}
