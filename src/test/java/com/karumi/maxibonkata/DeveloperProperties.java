package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by PoL on 25/03/17.
 */

@RunWith(JUnitQuickcheck.class)
public class DeveloperProperties {


    private static final String FAKE_NAME = "String";

    @Property
    public void theNumberOfMaxiAreAlwaysPositiveOrZero(int numOfMaxi) {
        System.out.println("num of maxi generated =" + numOfMaxi);
        Developer developer = new Developer(FAKE_NAME, numOfMaxi);
        System.out.println(developer);
        assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    }

    @Property
    public void theNameOfADeveloperGenerator(String name) {
        //System.out.println(name);
        Developer developer = new Developer(name, 1);
        assertThat(developer, is(notNullValue()));
    }

    @Test
    public void pedroDeveloperHasThreeMaxis() {
        Developer pedro = Karumies.PEDRO;
        assertThat(pedro.getNumberOfMaxibonsToGrab(), is(3));
    }
}
