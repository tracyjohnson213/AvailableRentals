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
public class MainActivityTest2 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest2() {
        ViewInteraction viewGroup = onView(
allOf(withId(R.id.action_bar),
childAtPosition(
allOf(withId(R.id.action_bar_container),
childAtPosition(
withId(R.id.decor_content_parent),
0)),
0),
isDisplayed()));
        viewGroup.check(matches(isDisplayed()));
        
        ViewInteraction textView = onView(
allOf(withText("Available Rentals"),
childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
1),
isDisplayed()));
        textView.check(matches(withText("Available Rentals")));
        
        ViewInteraction imageView = onView(
allOf(childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
0),
isDisplayed()));
        imageView.check(matches(isDisplayed()));
        
        ViewInteraction imageView2 = onView(
allOf(childAtPosition(
allOf(withId(R.id.action_bar),
childAtPosition(
withId(R.id.action_bar_container),
0)),
0),
isDisplayed()));
        imageView2.check(matches(isDisplayed()));
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
