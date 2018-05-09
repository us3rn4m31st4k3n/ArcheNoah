package dieArche;
import tiergenerator.*;
public class Test {

	
	
	public  void sort (int count,AnimalQueue aq,Stall<Vogel> birdStall,Stall<Reptil>reptileStall,Stall<Saeuger>mammalStall ) {
		for(int i=0;i<count;i++) {
			Tier candidate=aq.progress();
			if(candidate instanceof Reptil) {
				reptileStall.add((Reptil)candidate);
				System.out.println(reptileStall.toString());
				
			}
			if(candidate instanceof Saeuger) {
				mammalStall.add((Saeuger)candidate);
				System.out.println(mammalStall.toString());
				
			}
			if(candidate instanceof Vogel) {
				
				birdStall.add((Vogel)candidate);
				System.out.println(birdStall.toString());
				
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test arche=new Test();
		AnimalQueue aq= new AnimalQueue(10);
		
		aq.printQueue();
		//aq.storm();
		//aq.eat();
		//aq.storm();
		
		Stall<Vogel> birdStall=new Stall<Vogel>();
		Stall<Reptil> reptileStall=new Stall<Reptil>();
		Stall<Saeuger> mammalStall=new Stall<Saeuger>();
		
		arche.sort(10,aq,birdStall,reptileStall,mammalStall);
		
		
		
		
	}

}
