package com.college;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testGreet(){
        assertEquals("Hello, Jenkins!", App.greet("Jenkins"));
    }
}
