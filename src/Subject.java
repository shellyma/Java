/**
 * @author Shelly Ma
 *
 */
public interface Subject {

	public void register(Observer robot);
	public void unregister(Observer robot);
	public void notifyObservers();
	public Pos getUpdate(Observer ob);
}
