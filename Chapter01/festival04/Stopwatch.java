package festival04;
/**
 * һ�ֱ�ʾ��ʱ���ĳ�����������
 * @author Administrator
 *
 */
public class Stopwatch {
	private final long start;
	/**
	 * ����һ����ʱ��
	 */
	public Stopwatch(){
		start = System.currentTimeMillis();
	}
	/**
	 * ���ض��󴴽�������������ʱ��.
	 * ��λ����.
	 * @return
	 */
	public double elapsedTime(){
		long now = System.currentTimeMillis();
		return (now - start)/1000.0;
	}
}
