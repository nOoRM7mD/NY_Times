package com.example.nytimesmostpopulararticles;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NyTimesUnitTest {

    @Test
    public void isBaseUrlMatch (){
        assertEquals("https://api.nytimes.com/", BuildConfig.BASE_URL);
    }
    
}
