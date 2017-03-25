package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by PoL on 25/03/17.
 */
@RunWith(JUnitQuickcheck.class)
public class KarumiHQTest {

    public static KarumiHQs hQs = new KarumiHQs();

    @Property
    public void karumiHQAlwaysMustHaveMoreThanTwo(@From(KarumiesGenerator.class) Developer developer) {
        //System.out.println(developer);

        hQs.openFridge(developer);

        assertThat(hQs.getMaxibonsLeft() > 2, is(true));
    }

    @Property
    public void karumiHQAlwaysMustHaveMoreThanTwoWithStrangePeaple(@From(DevelopersGenerator.class) Developer developer) {
        System.out.println(developer);

        hQs.openFridge(developer);

        assertThat(hQs.getMaxibonsLeft() > 2, is(true));
    }


}
