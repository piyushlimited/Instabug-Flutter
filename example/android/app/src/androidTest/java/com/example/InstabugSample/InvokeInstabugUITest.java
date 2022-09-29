package com.example.InstabugSample;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withResourceName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import com.instabug.flutter.InstabugFlutterPlugin;

@RunWith(AndroidJUnit4.class)
public class InvokeInstabugUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureInstabugInvocati1on() throws InterruptedException {
        disableScreenShotByMediaProjection();
        Thread.sleep(1000);
        onView(withResourceName("instabug_floating_button")).perform(click());
        Thread.sleep(1000);
        onView(withText("Report a bug")).perform(click());
        Thread.sleep(1000);
        onView(withResourceName("instabug_edit_text_email")).perform(replaceText("inst@bug.com"));
        onView(withResourceName("instabug_bugreporting_send")).perform(click());
        onView(withResourceName("instabug_success_dialog_container")).perform(click());
    }

    private void disableScreenShotByMediaProjection() {
        InstabugFlutterPlugin.enableScreenShotByMediaProjection(false);
    }
}

