package com.darothub.multimodulartestapp.navigation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.darothub.multimodulartestapp.MainActivity
import com.darothub.multimodulartestapp.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testThatHomeFragment_Is_Displayed_When_Activity_Is_Launched(){
        onView(withId(R.id.btn)).check(matches(isDisplayed()))
    }

    @Test
    fun testThatOnClickOfButton_DashboardFragment_Is_Displayed(){
        onView(withId(R.id.btn)).perform(click())
        onView(withId(R.id.dashboard_textView)).check(matches(isDisplayed()))
    }

}