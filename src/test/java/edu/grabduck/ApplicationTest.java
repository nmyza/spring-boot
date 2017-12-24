package edu.grabduck;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class ApplicationTest {

    @Test
    public void testConfigureGlobal() throws Exception {
        System.out.println(new BCryptPasswordEncoder().encode("1"));
    }
}
