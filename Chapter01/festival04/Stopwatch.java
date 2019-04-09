package festival04;
/**
 * 一种表示计时器的抽象数据类型
 * @author Administrator
 *
 */
public class Stopwatch {
	private final long start;
	/**
	 * 创建一个计时器
	 */
	public Stopwatch(){
		start = System.currentTimeMillis();
	}
	/**
	 * 返回对象创建以来所经过的时间.
	 * 单位：秒.
	 * @return
	 */
	public double elapsedTime(){
		long now = System.currentTimeMillis();
		return (now - start)/1000.0;
	}
}
