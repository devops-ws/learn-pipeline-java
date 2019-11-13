package test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class is only for the test purpose.
 */
public class AccountSystemTest {
    private final String EXPECT_IP = "0.0.0.0";
    private final String SERVER_IP = System.getProperty("SERVER_IP", EXPECT_IP);

<#list 1..62 as i>
    @Test
    public void name_${i}() {
        assertEquals(EXPECT_IP, SERVER_IP);
    }
</#list>
}
