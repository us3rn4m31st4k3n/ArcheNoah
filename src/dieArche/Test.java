package dieArche;
import tiergenerator.*;
public class Test {

	
	
//	public  void sort (AnimalQueue aq,Stall<Vogel> birdStall,Stall<Reptil>reptileStall,Stall<Saeuger>mammalStall ) {
//			int count=aq.size();
//		for(int i=0;i<count;i++) {
//			
//			Tier candidate=aq.progress();
//			if(candidate instanceof Reptil) {
//				reptileStall.add((Reptil)candidate);
//				
//				
//			}
//			if(candidate instanceof Saeuger) {
//				mammalStall.add((Saeuger)candidate);
//				
//				
//			}
//			if(candidate instanceof Vogel) {
//				
//				birdStall.add((Vogel)candidate);
//				
//				
//			}
//		}System.out.println(reptileStall.toString());
//		System.out.println(mammalStall.toString());
//		System.out.println(birdStall.toString());
//		
//	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Test arche=new Test();
		AnimalQueue aq= new AnimalQueue(100);
		
		aq.printQueue();
//		aq.storm();
//		aq.eat();
//		aq.queueIncreasement();
//		aq.queueIncreasement(5);
		
		Stall<Vogel> birdStall=new Stall<Vogel>();
		Stall<Reptil> reptileStall=new Stall<Reptil>();
		Stall<Saeuger> mammalStall=new Stall<Saeuger>();
		
		try {
			aq.sort(15,birdStall,reptileStall,mammalStall);
		}catch(queueToShortException qtse) {
			System.out.println(qtse.toString());
		}
		
		aq.printQueue();
		
		System.out.println(reptileStall.toString());
		System.out.println(mammalStall.toString());
		System.out.println(birdStall.toString());
		
		
		
	}

}
