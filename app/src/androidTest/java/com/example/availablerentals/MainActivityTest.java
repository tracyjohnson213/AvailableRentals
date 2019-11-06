package com.example.availablerentals;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.concurrent.TimeoutException;
import java.util.function.BooleanSupplier;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void verifyTextDisplayedTest() {
        int[] object = {
                R.id.txtMgmtCompanyName,
                R.id.txtMgmtCompanyAddress,
                R.id.txtMgmtCompanyCityStateZip,
                R.id.txtMgmtCompanyPhone,
                R.id.txtMgmtCompanyFax
        };
        String[] elementText = {
                "B & B Properties",
                "711 E Wardlow #200",
                "Long Beach, CA 90807",
                "Phone: 562-424-3535",
                "Fax: 562-424-3536"
        };

        // verify object contains text
        for (int i=0; i < object.length; i++) {
            onView(withId(object[i])).check(matches(withText(elementText[i])));
        }
    }
}
