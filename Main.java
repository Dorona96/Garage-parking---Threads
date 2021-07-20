public class Main {
	public static void main(String[] args) {
		
		Garage g = new Garage(30);
		
		for(int i=0; i<100;i++) {
			
			new Thread(new Car(g,i)).start();
		}
		

	}
}
