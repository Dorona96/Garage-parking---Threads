
public class Car implements Runnable {
	private Garage g; 
	private int carNum;


	public Car(Garage g, int carNum) {
		this.g = g; 
		this.carNum = carNum;
	}
	public void run() {
		while(true) {
			synchronized(this) {
				//driving
				try {
					System.out.println("the driving car is: "+carNum);
					Thread.sleep((long)(1000*(int)( Math.random()*10)));
				}
				catch (InterruptedException e){
					System.out.println("Interrupted!");
				}

				int result= g.park();
				while(result==-1) {

					try {	
						wait();
					}
					catch(InterruptedException e1){
						System.out.println("Interrupted!");
					}
					result= g.park();
				}
				try {		
					System.out.println("car number "+carNum+" is parking in zone:"+result);
					Thread.sleep((long)(1000*(int)(Math.random()*10)));
					g.release(result);
					System.out.println("car number "+carNum+" left zone:"+result);

				}catch (InterruptedException e){
					System.out.println("Interrupted!");
				}	
			}



		}

	}

}

