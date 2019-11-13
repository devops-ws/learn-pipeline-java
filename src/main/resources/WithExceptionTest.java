package test;

import org.junit.Test;

/**
 * This class is only for the test purpose.
 */
public class WithExceptionTest {
    private final String EXPECT_EXCEPTION = "false";
    private final String TEST_EXCEPTION = System.getProperty("TEST_EXCEPTION", EXPECT_EXCEPTION);

<#list 1..62 as i>
    @Test
    public void name_${i}() throws Exception {
        if (!TEST_EXCEPTION.equals(EXPECT_EXCEPTION)) {
            throw new Exception();
        }
    }
</#list>
}
