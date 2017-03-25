package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * Created by PoL on 25/03/17.
 */

@RunWith(JUnitQuickcheck.class)
public class DeveloperProperties {


    private static final String FAKE_NAME = "String";

    @Property public void theNumberOfMaxiAreAlwaysPositiveOrZero(int numOfMaxi) {
        Developer developer = new Developer(FAKE_NAME, numOfMaxi);
        System.out.println(developer);
        assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    }
}
