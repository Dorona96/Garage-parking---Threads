public class Garage{
	private int spaces;
	private boolean[] parkingArea;
	

	public Garage(int spaces){
		this.spaces = spaces;
		parkingArea= new boolean[spaces];
		for(int i=0;i<spaces;i++) {
			parkingArea[i]=true;
		}

	}


	public synchronized int park() {
	
		int result =-1;
		for(int i=0; i<spaces;i++) {
			if(parkingArea[i]==true)
			{
				result =i;
				parkingArea[i] = false;
				return result;
				
			}
		}
		return result;

	}

	public synchronized void release(int freeSpaces) {	
		parkingArea[freeSpaces]=true;
		notifyAll();
		
	}


}
