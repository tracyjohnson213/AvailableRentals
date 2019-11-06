package com.example.availablerentals;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.example.availablerentals.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction textView = onView(
allOf(withId(R.id.txtMgmtCompanyName), withText("B and B Properties"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        textView.check(matches(withText("B and B Properties")));
        
        ViewInteraction textView2 = onView(
allOf(withId(R.id.txtMgmtCompanyName), withText("B and B Properties"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        textView2.check(matches(isDisplayed()));
        
        ViewInteraction textView3 = onView(
allOf(withId(R.id.txtMgmtCompanyAddress), withText("711 E Wardlow #200"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        textView3.check(matches(withText("711 E Wardlow #200")));
        
        ViewInteraction textView4 = onView(
allOf(withId(R.id.txtMgmtCompanyAddress), withText("711 E Wardlow #200"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        textView4.check(matches(isDisplayed()));
        
        ViewInteraction textView5 = onView(
allOf(withId(R.id.txtMgmtCompanyCityStateZip), withText("Long Beach, CA 90807"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        textView5.check(matches(isDisplayed()));
        
        ViewInteraction textView6 = onView(
allOf(withId(R.id.txtMgmtCompanyCityStateZip), withText("Long Beach, CA 90807"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        textView6.check(matches(withText("Long Beach, CA 90807")));
        
        ViewInteraction textView7 = onView(
allOf(withId(R.id.txtMgmtCompanyPhone), withText("Phone: 562-424-3535"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        textView7.check(matches(isDisplayed()));
        
        ViewInteraction textView8 = onView(
allOf(withId(R.id.txtMgmtCompanyPhone), withText("Phone: 562-424-3535"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        textView8.check(matches(withText("Phone: 562-424-3535")));
        
        ViewInteraction textView9 = onView(
allOf(withId(R.id.txtMgmtCompanyFax), withText("Fax: 562-424-3536"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()));
        textView9.check(matches(isDisplayed()));
        
        ViewInteraction textView10 = onView(
allOf(withId(R.id.txtMgmtCompanyFax), withText("Fax: 562-424-3536"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()));
        textView10.check(matches(withText("Fax: 562-424-3536")));
        
        ViewInteraction imageView = onView(
allOf(childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
0),
isDisplayed()));
        imageView.check(matches(isDisplayed()));
        
        ViewInteraction textView11 = onView(
allOf(withText("Available Rentals"),
childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
1),
isDisplayed()));
        textView11.check(matches(isDisplayed()));
        
        ViewInteraction textView12 = onView(
allOf(withText("Available Rentals"),
childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
1),
isDisplayed()));
        textView12.check(matches(withText("Available Rentals")));
        }
    
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
