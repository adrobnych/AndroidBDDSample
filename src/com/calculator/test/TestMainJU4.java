package com.calculator.test;

import android.test.ActivityInstrumentationTestCase2;

import com.calculator.Main;
import com.jayway.android.robotium.solo.Solo;

public class TestMainJU4 extends ActivityInstrumentationTestCase2<Main> {
	private Solo solo;
	
	public TestMainJU4() {
		super(Main.class);
	}

	public void setUp() throws Exception {
		super.setUp();
		//configure Model Managers with whether MockDAO or any real DAO communicating with DB  
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void test(){
		Given3ProductsAreInTheTourWishList();
		WhenWeAreOnMainActivity(); 
		ThenWeCanSee3ProductsOnWishListActivity();
	}
	
	private void Given3ProductsAreInTheTourWishList() {
		//Use Configured Model Manager (from Application singleton)
		assertEquals(4, 2+2);
	}

	private void WhenWeAreOnMainActivity() {
		solo.assertCurrentActivity("wrong activiy", Main.class);
	}
	
	private void ThenWeCanSee3ProductsOnWishListActivity() {
		//Enter 10 in first editfield
		solo.enterText(0, "10");
		//Enter 20 in first editfield
		solo.enterText(1, "20");
		//Click on Multiply button
		solo.clickOnButton("Multiply");
		//Verify that resultant of 10 x 20
		assertTrue(solo.searchText("200"));
	}
	
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
