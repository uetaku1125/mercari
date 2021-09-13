package com.example.mercari

import android.content.ClipData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Before
import org.junit.Rule
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

 //   @get:Rule
 //   val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun registerAddress() {
        MainActivity().clickMyPageButton()
        MyPage().clickProfileButton()
        Profile().clickAddressButton()
        AddressList().clickRegAddressButton()
        RegAddress().inputAddress()
        AddressList().assertAddress()
    }

    @Test
    fun searchItem(){
        MainActivity().inputSearchString()
        SearchResult().clickItem()
        ItemDetail().checkItemDetail()
    }

}

class MainActivity(){
    fun clickMyPageButton(): MyPage{
        onView(withId(R.id.btn_mypage)).perform(click())
        isDisplayed()
        return MyPage()
    }

    fun inputSearchString(){
        onView(withId(R.id.search)).perform(ViewActions.typeText("MacBook"))
        onView(withId(R.id.search)).perform(click())
    }
}

class MyPage() {
    fun clickProfileButton(): Profile{
        onView(withId(R.id.btn_profile)).perform(click())
        isDisplayed()
        return Profile()
    }

    fun clickHomeButton(): MainActivity{
        onView(withId(R.id.btn_home)).perform(click())
        isDisplayed()
        return MainActivity()
    }
}

class Profile() {
    fun clickAddressButton(): AddressList{
        onView(withId(R.id.btn_address)).perform(click())
        isDisplayed()
        return AddressList()
    }

    fun clickBackButton(): MyPage{
        onView(withId(R.id.btn_back)).perform(click())
        isDisplayed()
        return MyPage()
    }
}

class AddressList() {
    fun clickRegAddressButton(): RegAddress{
        onView(withId(R.id.btn_regAddr)).perform(click())
        isDisplayed()
        return RegAddress()
    }

    fun assertAddress(){
        onView(withId(R.id.textView_address)).check(
            matches(withText(EXTRA_MESSAGE))
        )
    }

    fun clickBackProfileButton(): Profile{
        onView(withId(R.id.btn_backProfile)).perform(click())
        isDisplayed()
        return Profile()
    }
}

class RegAddress() {
    fun inputAddress(){
        onView(withId(R.id.editTextTextFamilyName)).perform(
            ViewActions.replaceText("test address")
        )
    }

    fun clickBackAddressButton(): AddressList{
        onView(withId(R.id.btn_backAddress)).perform(click())
        isDisplayed()
        return AddressList()
    }
}

class SearchResult(){
    fun clickItem(): ItemDetail{
        onView(withId(R.id.list_item)).perform(click())
        return ItemDetail()
    }
}

class ItemDetail(){
    fun checkItemDetail(){
        onView(withId(R.id.textView_itemDetail)).check(matches(withText("macbook")))
    }
}