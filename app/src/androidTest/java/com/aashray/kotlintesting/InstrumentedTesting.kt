package com.aashray.kotlintesting

import androidx.test.ext.junit.rules.activityScenarioRule
import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * The kotlin equivalent to the ChangeTextBehaviorTest, that
 * showcases simple view matchers and actions like [ViewMatchers.withId],
 * [ViewActions.click] and [ViewActions.typeText], and ActivityScenarioRule
 *
 *
 * Note that there is no need to tell Espresso that a view is in a different [Activity].
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class InstrumentedTesting {

    /**
     * Use [ActivityScenarioRule] to create and launch the activity under test before each test,
     * and close it after each test. This is a replacement for
     * [androidx.test.rule.ActivityTestRule].
     */
    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    //    TEST 1
    @Test
    fun testTextViewContentMainText() {
        onView(withId(R.id.textToBeChanged)).check(matches(withText(TEST1)))
    }

    //    TEST 2
    @Test
    fun testEditTextWithChangeTextButton() {
        onView(withId(R.id.editTextUserInput)).perform(replaceText(TEST23))
        onView(withId(R.id.changeTextBt)).perform(click())
        onView(withId(R.id.textToBeChanged)).check(matches(withText(TEST23)))
    }

    //    TEST 3
    @Test
    fun testEditTextWithOpenActivityAndChangeTextButton() {
        onView(withId(R.id.editTextUserInput)).perform(replaceText(TEST23))
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        onView(withId(R.id.show_text_view)).check(matches(withText(TEST23)))
    }

    //    TEST 4
    @Test
    fun testEmptyEditTextWithChangeTextButton() {
        onView(withId(R.id.changeTextBt)).perform(click())
        onView(withId(R.id.textToBeChanged)).check(matches(withText(TEST45)))
    }

    //    TEST 5
    @Test
    fun testEmptyEditTextWithOpenActivityAndChangeTextButton() {
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        onView(withId(R.id.show_text_view)).check(matches(withText(TEST45)))
    }

    //    TEST 6
    @Test
    fun testInvalidEditTextWithChangeTextButton() {
        onView(withId(R.id.editTextUserInput)).perform(replaceText(TEST67))
        onView(withId(R.id.changeTextBt)).perform(click())
        onView(withId(R.id.textToBeChanged)).check(matches(withText(TEST67)))
    }

    //    TEST 7
    @Test
    fun testInvalidEditTextWithOpenActivityAndChangeTextButton() {
        onView(withId(R.id.editTextUserInput)).perform(replaceText(TEST67))
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        onView(withId(R.id.show_text_view)).check(matches(withText(TEST67)))
    }

    //    TEST 8
    @Test
    fun testTextViewContentShowText() {
        ActivityScenario.launch(ShowTextActivity)
        onView(withId(R.id.show_text_view)).check(matches(withText("")))
    }

    companion object {
        val TEST1 = "Hello Espresso!"
        val TEST23 = "123"
        val TEST45 = ""
        val TEST67 = "abcdef"
    }
}

