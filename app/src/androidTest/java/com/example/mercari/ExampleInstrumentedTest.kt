package com.example.mercari

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.mercari", appContext.packageName)
    }

    fun registerAddress() {
        MainActivity().clickMyPageButton()
        MyPage().clickProfileButton()
        Profile().clickAddressButton()
        AddressList().clickRegAddressButton()
        RegAddress().inputAddress()
        AddressList().assertAddress()
    }
}

class MainActivity(){
    fun clickMyPageButton(): MyPage{
        onView(withId(R.id.btn_mypage)).perform(click())
        return MyPage()
    }
}

class MyPage() {
    fun clickProfileButton(): Profile{
        onView(withId(R.id.btn_profile)).perform(click())
        return Profile()
    }

    fun clickHomeButton(): MainActivity{
        onView(withId(R.id.btn_home)).perform(click())
        return MainActivity()
    }
}

class Profile() {
    fun clickAddressButton(): AddressList{
        onView(withId(R.id.btn_address)).perform(click())
        return AddressList()
    }

    fun clickBackButton(): MyPage{
        onView(withId(R.id.btn_back)).perform(click())
        return MyPage()
    }
}

class AddressList() {
    fun clickRegAddressButton(): RegAddress{
        onView(withId(R.id.btn_regAddr)).perform(click())
        return RegAddress()
    }

    fun assertAddress(): AddressList{
        onView(withId(R.id.textView_address)).check(
            matches(withText(EXTRA_MESSAGE))
        )
        return this
    }

    fun clickBackProfileButton(): Profile{
        onView(withId(R.id.btn_backProfile)).perform(click())
        return Profile()
    }
}

class RegAddress() {
    fun inputAddress(): RegAddress {
        onView(withId(R.id.editTextTextFamilyName)).perform(
            ViewActions.replaceText("test address")
        )
        return this
    }

    fun clickBackAddressButton(): AddressList {
        onView(withId(R.id.btn_backAddress)).perform(click())
        return AddressList()
    }
}