package test;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class is only for the test purpose.
 */
public class UserSystemTest {
    private final String EXPECT_PORT = "1234";
    private final String SERVER_PORT = System.getProperty("SERVER_PORT", EXPECT_PORT);

<#list 1..62 as i>
    @Test
    public void name_${i}() {
        assertEquals(EXPECT_PORT, SERVER_PORT);
    }
</#list>

<#list 1..62 as i>
    @Test
    @Ignore
    public void skip_${i}() {}
</#list>
}
