import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class IDCheckerTest {


    @Test
    @Parameters(method = "idCheckerValues")
    public void testIDValidation(String toCheck, boolean expected) {
        IDChecker idChecker = new IDChecker();
        assertEquals(expected, idChecker.validate(toCheck));

    }

    private Object[] idCheckerValues() {
        return new Object[]{
                //new Object[]{"ABC123456", false},
                new Object[]{"ABS123456", true},
                new Object[]{"ABA300000", true},
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegalValues")
    public void testInvalidValues(String toCheck) {
        Validator idChecker = new IDChecker();
        idChecker.validate(toCheck);
    }

    private Object[] illegalValues() {
        return new Object[]{
                new Object[]{"123456789"},
                new Object[]{"ABCD56789"},
                new Object[]{"ABA3-10000"},
                new Object[]{"-1BA3-10000"},
                new Object[]{"ABA3100A"},
                new Object[]{"BA310000"},
                new Object[]{"ABA31000"},
        };
    }
}


