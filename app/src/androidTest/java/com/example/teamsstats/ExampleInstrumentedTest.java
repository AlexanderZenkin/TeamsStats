package com.example.teamsstats;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.teamsstats.model.DateTimeFormater;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.Instant;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityActivityTestRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.findweather", appContext.getPackageName());
    }

    @Test
    public void clickButtonSearch(){
        onView(ViewMatchers.withId(R.id.search_button))
                .check(matches(isClickable()))
                .check(matches(isDisplayed()))
                .check(matches(withText("Поиск")));
    }

    @Test
    public void clickSearchField(){
        onView(withId(R.id.searchField))
                .check(matches(isClickable()))
                .check(matches(isDisplayed()));
    }

    @Test
    public void searchMatches(){
        String matchDay = DateTimeFormater.dateTimeFormatter(Instant.now().getEpochSecond(), "yyyy-MM-dd");

        onView(withId(R.id.search_button))
                .perform(click());

        onView(withId(R.id.searchField)).check(matches(withText(matchDay)));
    }
}