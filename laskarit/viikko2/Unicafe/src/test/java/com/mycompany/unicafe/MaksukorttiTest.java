package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1005);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals(1005,kortti.saldo());
    }
    
    @Test
    public void rahanLataaminenToimii() {
        kortti.lataaRahaa(125);
        assertEquals("saldo: 11.30",kortti.toString());
    }
    
    @Test
    public void saldoVäheneeOikeinJosOnRahaa() {
        kortti.otaRahaa(540);
        assertEquals("saldo: 4.65",kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosEiOleRahaa() {
        kortti.otaRahaa(1010);
        assertEquals("saldo: 10.05",kortti.toString());
    }
    
    @Test
    public void rahanOttoPalauttaaTrueJosRahatRiittää() {
        assertEquals(true,kortti.otaRahaa(1000));
    }
    
    @Test
    public void rahanOttoPalauttaaFalseJosRahatEiRiitä() {
        assertEquals(false,kortti.otaRahaa(1010));
    }
}
