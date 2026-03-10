package test.hu1;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ EventGUIHU1Test.class, TableroMinasAlrededorTest.class, TableroTest3.class })
//@SelectPackages("test.hu1")
public class AllTests {

}
