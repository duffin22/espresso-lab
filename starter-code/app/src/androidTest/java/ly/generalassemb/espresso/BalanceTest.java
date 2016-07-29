package ly.generalassemb.espresso;

import android.app.Application;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Created by matthewtduffin on 29/07/16.
 */

@RunWith(AndroidJUnit4.class)
public class BalanceTest {


    @Rule
    public ActivityTestRule<BalanceActivity> mActivityRule = new ActivityTestRule(BalanceActivity.class);

    @Test
    public void IsBalanceDisplayed() {
        onView(withId(R.id.balanceTextView))
                .check(matches(isDisplayed()));
    }

    @Test
    public void IsWithdrawWorking() {

        onView(withId(R.id.newTransactionButton))
                .perform(click());

        onView(withId(R.id.descriptionEditText))
                .perform(typeText("Stuff that I spend money on"));
        onView(withId(R.id.amountEditText))
                .perform(typeText("369.42"));
        onView(withId(R.id.withdrawButton))
                .perform(click());

        onView(withId(R.id.balanceTextView))
                .check(matches(withText("-$369.42")));

    }

    @Test
    public void IsDepositWorking() {

        onView(withId(R.id.newTransactionButton))
                .perform(click());

        onView(withId(R.id.descriptionEditText))
                .perform(typeText("Stuff that I spend money on"));
        onView(withId(R.id.amountEditText))
                .perform(typeText("369.42"));
        onView(withId(R.id.depositButton))
                .perform(click());

        onView(withId(R.id.balanceTextView))
                .check(matches(withText("$369.42")));

    }

    @Test
    public void IsDepositWithdrawWorking() {
        onView(withId(R.id.newTransactionButton))
                .perform(click());

        onView(withId(R.id.descriptionEditText))
                .perform(typeText("Stuff that I spend money on"));
        onView(withId(R.id.amountEditText))
                .perform(typeText("200"));
        onView(withId(R.id.withdrawButton))
                .perform(click());


        onView(withId(R.id.newTransactionButton))
                .perform(click());

        onView(withId(R.id.descriptionEditText))
                .perform(typeText("Stuff that I spend money on"));
        onView(withId(R.id.amountEditText))
                .perform(typeText("400"));
        onView(withId(R.id.depositButton))
                .perform(click());


        onView(withId(R.id.newTransactionButton))
                .perform(click());

        onView(withId(R.id.descriptionEditText))
                .perform(typeText("Stuff that I spend money on"));
        onView(withId(R.id.amountEditText))
                .perform(typeText("205"));
        onView(withId(R.id.withdrawButton))
                .perform(click());

        onView(withId(R.id.balanceTextView))
                .check(matches(withText("-$5.00")));

    }


}
