package org.junitPractice;

import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitDemo {

	@Test
	public void test_a_setUp() {
		System.out.println("method1");

	}
   
	@Test
	public void test_b_login() {
		Assume.assumeTrue(false);
		System.out.println("method2");
	}

	@Test
	public void test_c_tearDown() {
		System.out.println("method3");
	}
}
