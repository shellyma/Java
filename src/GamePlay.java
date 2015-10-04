/**
 * @author Shelly Ma
 *
 */
public class GamePlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//a soccer ball instantiated with default position.
		SoccerBall ball = new SoccerBall();
		
		//5 robots instantiated with numbers and positions assigned.
		Robot r1 = new Robot(1,Position.DEFENDER);
		Robot r2 = new Robot(2,Position.GOALKEEPER);
		Robot r3 = new Robot(3,Position.MIDFIELDER);
		Robot r4 = new Robot(4,Position.MIDFIELDER);
		Robot r5 = new Robot(5,Position.FORWARD);
		
		//each robot is registered with soccer ball 
		ball.register(r1);
		ball.register(r2);
		ball.register(r3);
		ball.register(r4);
		ball.register(r5);
		
		r1.setSubject(ball);
		r2.setSubject(ball);
		r3.setSubject(ball);
		r4.setSubject(ball);
		r5.setSubject(ball);
		
		//play function directly called from each robot which shall reflect its position to play accordingly.
		r3.play();
		r2.play();
		//test soccer ball position changed, observers all notified and triggered play function.
		Pos pos = new Pos(20,40);
		ball.changedPoisition(pos);
		r1.play();
		r5.play();
		r4.play();
		
		//test robot put down and assign with a second position.
		r5.putDown();
		r4.assignPosition(Position.FORWARD);
		r4.setPlayer(Position.FORWARD);
		r5.play();
		r4.play();
		//test: r4 is assigned MIDFIELDER and FORWARD, cannot play goalkeepr role.
		r4.setPlayer(Position.GOALKEEPER);
		r4.play();
		
	}

}
