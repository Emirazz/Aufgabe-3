package de.hawhh.informatik.sml.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeldbetragTest
{
	private Geldbetrag _geldbetrag;
	private Geldbetrag _geldbetrag2;
	private Geldbetrag _geldbetrag0;
	public GeldbetragTest()
	{
		_geldbetrag = Geldbetrag.get(10,50);
		_geldbetrag2 = Geldbetrag.get(5,50);
		_geldbetrag0 = Geldbetrag.get(0,0);
	}
    @Test
    public void testeEquals()
    {
        assertFalse(_geldbetrag2.equals(_geldbetrag));
        assertFalse(_geldbetrag.equals(_geldbetrag2));
        assertTrue(_geldbetrag2.equals(_geldbetrag2));
        assertTrue(_geldbetrag.equals(_geldbetrag));
    }

    @Test
    public void testeKonstruktoren()
    {
        
        assertEquals(10, _geldbetrag.getEuro());
        assertEquals(50, _geldbetrag.getCent());
        assertNotNull(_geldbetrag.toString());
    }

    @Test
    public void testeAddieren()
    {
    	Geldbetrag geldbetrag = Geldbetrag.get(16,0);
    	
    	assertTrue(geldbetrag, _geldbetrag.addiere(_geldbetrag2));
    	assertTrue(geldbetrag, _geldbetrag2.addiere(_geldbetrag));
    	
    	assertTrue(_geldbetrag0, _geldbetrag0.addiere(_geldbetrag0));
    	assertTrue(geldbetrag, _geldbetrag0.addiere(geldbetrag));
    	assertTrue(geldbetrag, geldbetrag.addiere(_geldbetrag0));
    	
    }

    @Test
    public void testeSubtrahieren()
    {
    	Geldbetrag geldbetrag = Geldbetrag.get(5,0);
    	
    	assertTrue(geldbetrag, _geldbetrag.subtrahieren(_geldbetrag2));
    	assertTrue(_geldbetrag0, _geldbetrag0.subtrahieren(_geldbetrag0));
    	assertTrue(geldbetrag, geldbetrag.subtrahieren(_geldbetrag0));
    	
    }

    @Test
    public void testeMultiplizieren()
    {
    	
        
    }

    @Test
    public void testeToString()
    {
        
    }

    @Test
    public void testeToGeldbetragString()
    {
        
    }

    @Test
    public void testToGeldbetragInt()
    {
        
    }
}
