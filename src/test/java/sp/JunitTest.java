package sp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitTest {

	@Before
	public void before() {
		System.out.println("before");
	}

	@Test
	public void test() {
		System.out.println("test");
	}

	@After
	public void after() {
		System.out.println("after");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass");
	}

	public static void main(String[] args) {
		int a = 1, b = 2;
		Integer aa = new Integer(10), bb = new Integer(22);
		swapInt(a, b);
		swapIntger(aa, bb);
		System.out.println(a + ":" + b);
		System.out.println(aa + ":" + bb);

	}

	public static void swapInt(int a, int b) {
		int c = a;
		a = b;
		b = c;
	}

	public static void swapIntger(Integer a, Integer b) {
		Integer c = a;
		a = b;
		b = c;

		System.out.println(a);
		System.out.println(b);
	}

}
