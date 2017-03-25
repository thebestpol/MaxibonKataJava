package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by PoL on 25/03/17.
 */
@RunWith(JUnitQuickcheck.class)
public class KarumiHQTest {

    public static KarumiHQs hQs = new KarumiHQs();

    @Property
    public void karumiHQAlwaysMustHaveMoreThanTwo(
            @From(KarumiesGenerator.class) Developer developer) {
        //System.out.println(developer);

        hQs.openFridge(developer);

        assertThat(hQs.getMaxibonsLeft() > 2, is(true));
    }

    @Property
    public void karumiHQAlwaysMustHaveMoreThanTwoWithStrangePeople(
            @From(DevelopersGenerator.class) Developer developer) {
        System.out.println(developer);

        hQs.openFridge(developer);

        assertThat(hQs.getMaxibonsLeft() > 2, is(true));
    }

    // This kind of method is not supported in Android development due the annotation inside List<>
    @Property
    public void karumiHQAlwaysMustHaveMoreThanTwoWithListOfPeople(
            List<@From(DevelopersGenerator.class) Developer> developer) {
        System.out.println(developer);

        hQs.openFridge(developer);

        assertThat(hQs.getMaxibonsLeft() > 2, is(true));
    }

    @Property
    public void shouldCallChatIfMaxisAreLowerThanTwo(
            @From(HungryDevelopersGenerator.class)Developer hungryDeveloper) {

        Chat mockChat = mock(Chat.class);
        KarumiHQs karumiHQs = new KarumiHQs(mockChat);

        karumiHQs.openFridge(hungryDeveloper);

        verify(mockChat).sendMessage(anyString());

    }


}
