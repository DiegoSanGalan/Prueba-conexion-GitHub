package val.examples.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClaseTest.class, ClaseTestAlumno.class, TestOperaciones.class })
public class AllTests {

}
