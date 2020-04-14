package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MainActivityTest {

    val LAUNCHACTIVITY = true
    val INITIALTOUCHMODE = true

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, INITIALTOUCHMODE, LAUNCHACTIVITY)
    lateinit var mActivity: MainActivity


    @Before
    fun setup() {
        mActivity = activityRule.activity

    }


    @Test
    fun checkTextViewHelloWorld() {
        onView(withId(R.id.helloWorldTv))
            .check(matches(withText(mActivity.getString(R.string.hello_world))))
    }


    @Test
    fun checkButtonHelloWorld() {
        onView(withId(R.id.helloWorldBtn))
            .check(matches(withText(mActivity.getString(R.string.hello_world))))
    }


    @Test
    fun naviagteToNextScreen() {
        onView(withId(R.id.helloWorldBtn))
            .perform(ViewActions.click())
    }



}