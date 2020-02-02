import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import v1.V1AllTests;
import v2.V2AllTests;
import v3.V3AllTests;


@RunWith(Suite.class)
@SuiteClasses({V1AllTests.class, V2AllTests.class, V3AllTests.class})
public class AllTests {

}
