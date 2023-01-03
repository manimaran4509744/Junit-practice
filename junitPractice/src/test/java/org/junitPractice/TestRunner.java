package org.junitPractice;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({JunitDemo.class,Parameterization.class})
public class TestRunner
{
	

}
