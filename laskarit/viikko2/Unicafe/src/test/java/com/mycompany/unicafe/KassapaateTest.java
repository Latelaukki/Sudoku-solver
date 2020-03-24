
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
 
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    
    @Test
    public void oikeaRahamaaraAlussa() {
        assertEquals(100000,kassa.kassassaRahaa());
    }
    
    @Test
    public void myytyjenLounaidenMaaraOikeaAlussa() {
        assertEquals(0,kassa.edullisiaLounaitaMyyty());
        assertEquals(0,kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisostoKasvattaaKassaaKunRahatRiittaa() {
        kassa.syoEdullisesti(250);
        assertEquals(100240,kassa.kassassaRahaa());
        kassa.syoMaukkaasti(420);
        assertEquals(100640,kassa.kassassaRahaa());
    }
    
    @Test
    public void kateisostoAntaaTarpeeksiRahaaTakaisin() {
        assertEquals(10,kassa.syoEdullisesti(250));
        assertEquals(10,kassa.syoMaukkaasti(410));
    }
    
    @Test
    public void kateisostoLisaaMyytyjenLounaidenMaaraa() {
        kassa.syoEdullisesti(240);
        assertEquals(1,kassa.edullisiaLounaitaMyyty());
        kassa.syoMaukkaasti(400);
        assertEquals(1,kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisostoMaksuEiRiitaKassaRahaEiMuutu() {
        kassa.syoEdullisesti(230);
        assertEquals(100000,kassa.kassassaRahaa());
        kassa.syoMaukkaasti(390);
        assertEquals(100000,kassa.kassassaRahaa());
    }
    
    @Test
    public void kateisostoMaksuEiRiitaRahatPalautuuOikein() {
        assertEquals(230,kassa.syoEdullisesti(230));
        assertEquals(230,kassa.syoMaukkaasti(230));
    }
    
    @Test
    public void kateisostoMaksuEiRiitaMyydyissaEiMuutoksia() {
        kassa.syoEdullisesti(230);
        assertEquals(0,kassa.edullisiaLounaitaMyyty());
        kassa.syoMaukkaasti(230);
        assertEquals(0,kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiostoTarpeeksiRahaaVeloittaaOikein() {
        assertEquals(true,kassa.syoEdullisesti(kortti));
        assertEquals(760,kortti.saldo());
        assertEquals(true,kassa.syoMaukkaasti(kortti)); 
        assertEquals(360,kortti.saldo());
    }
    
    @Test
    public void korttiostoKasvattaaMyytyjenLounaidenMaaraa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1,kassa.edullisiaLounaitaMyyty());
        kassa.syoMaukkaasti(kortti);
        assertEquals(1,kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void eiTarpeeksiRahaaKortillaSaldoEiMuutuMyydytLounaatMuuttumatonPalauttaaFalse() {
        kortti.otaRahaa(900);
        kassa.syoEdullisesti(kortti);
        assertEquals(100,kortti.saldo());
        assertEquals(0,kassa.edullisiaLounaitaMyyty());
        assertEquals(false,kassa.syoEdullisesti(kortti));
        kassa.syoMaukkaasti(kortti);
        assertEquals(100,kortti.saldo());
        assertEquals(0,kassa.maukkaitaLounaitaMyyty());
        assertEquals(false,kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void kassanRahamaaraEiMuutuKorttiostossa() {
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000,kassa.kassassaRahaa());
    }
    
    @Test
    public void kortilleLadattaessaSaldoMuuttuuOikeinJaKassaRahamaaraKasvaa() {
        kassa.lataaRahaaKortille(kortti, -1);
        assertEquals(100000,kassa.kassassaRahaa());
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(1500,kortti.saldo());
        assertEquals(100500,kassa.kassassaRahaa());
    }
   
}
