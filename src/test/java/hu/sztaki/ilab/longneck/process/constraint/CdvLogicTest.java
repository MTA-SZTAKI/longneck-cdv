package hu.sztaki.ilab.longneck.process.constraint;

import static org.junit.Assert.*;

import org.junit.Test;

public class CdvLogicTest {

    @Test
    public void test01() {
        CdvLogic logic = new CdvLogic();
        logic.setMod(10);
        logic.setCoeffs("1 1 1 -1");

        assertTrue(logic.check("5678"));
        assertFalse(logic.check("5674"));
    }

    public void test02() {
        CdvLogic logic = new CdvLogic();
        logic.setMod(11);
        logic.setCoeffs("1 2 3 4 5 6 7 8 9 10 -1");
        
        assertFalse(logic.check("27506303842"));
        assertTrue(logic.check("27506303846"));
    }
}
