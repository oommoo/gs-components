package com.gs.components;

import org.junit.Test;

import com.gs.components.EncryptedProperties;

import static org.junit.Assert.*;

public class EncryptedPropertiesTest {
    @Test
    public void canConstructAPersonWithAName() {
    	EncryptedProperties person;
		try {
			person = new EncryptedProperties("secret");
	    	person.put("person", new String("Larry"));
	        assertEquals("Larry", person.get("person"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
