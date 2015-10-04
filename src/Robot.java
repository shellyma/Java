import java.util.Hashtable;

/**
 * 
 */

/**
 * @author Shelly Ma
 *
 */
public class Robot implements Observer{

	public int number;
	public boolean status;
	public Hashtable<String,Position> position;//A robot can have more than 1 positions
	public Player player; //One player function at a time
	public Subject ball;

	//Constructor. Each robot is assigned a number and position; default to set active for playing.
	public Robot(int number, Position pos){
		this.number = number;
		this.status = Boolean.TRUE;
		this.position= new Hashtable<String,Position>();
        this.assignPosition(pos);
        this.setPlayer(pos);
	}
	
	public void setSubject(Subject ball){
		this.ball = ball;
	}
	public Player getPlayer(){
		return player;
	}
	
	public void setPlayer(Position pos){
		if(!this.position.contains(pos)){
			System.out.println("This is not your position to play!");
			return;
		}
		switch(pos){
		case GOALKEEPER:
			this.player = new GoalkeeperPlayer();
			break;
		case DEFENDER:
			this.player = new DefenderPlayer();
			break;
		case MIDFIELDER:
			this.player = new MidfielderPlayer();
			break;
		case FORWARD:
			this.player = new ForwardPlayer();
			break;
		}
	}
	
	public void putDown(){
		this.status = Boolean.FALSE;
	}
	
	public void putActivate(){
		this.status = Boolean.TRUE;
	}
	
	public void assignPosition(Position pos){
		switch(pos){
		case GOALKEEPER:
			this.position.put("goalkeeper", Position.GOALKEEPER);
			break;
		case DEFENDER:
			this.position.put("defender", Position.DEFENDER);
			break;
		case MIDFIELDER:
			this.position.put("midfielder", Position.MIDFIELDER);
			break;
		case FORWARD:
			this.position.put("forward", Position.FORWARD);
			break;
		}
	}
	
	public void play(){
		if(this.status){
			player.play(this.number);
		}else{
			System.out.println("Player "+this.number+" is down!");
		}
	}
	
	//Detects that ball is currently in range, play according to player position.
	private void detectBall(Pos pos){
		this.setPlayer(Position.DEFENDER); // not real implementation
		play();
	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		Pos currentPos = ball.getUpdate(this);
		detectBall(currentPos); // not real implementation, if detect ball is in range for the position, assign player role and play
		
	}
}
