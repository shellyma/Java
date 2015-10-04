import java.util.ArrayList;
import java.util.List;

/**
 * @author Shelly Ma
 *
 */
public class SoccerBall implements Subject {

	public Pos current;
	public List<Observer> observers;
	

	public SoccerBall(){
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer robot) {
		// TODO Auto-generated method stub
		if(!observers.contains(robot)) observers.add(robot);
	}

	@Override
	public void unregister(Observer robot) {
		// TODO Auto-generated method stub
		if(observers.contains(robot)) observers.remove(robot);
		
	}
	
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer ob:observers){
			ob.update();
		}

	}
	
	@Override
	public Pos getUpdate(Observer ob) {
		// TODO Auto-generated method stub
		return this.current;
	}
	
	public void changedPoisition(Pos pos){
		System.out.println("Ball position changed");
		notifyObservers();
	}


}
