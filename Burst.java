
public class Burst {

	public int type; /* CPU:0 I/0:1 */
	public int time;

	public Burst(int ty, int ti) {
		this.type = ty;
		this.time = ti;
	}

}