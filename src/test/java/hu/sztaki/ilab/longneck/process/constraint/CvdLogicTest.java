package hu.sztaki.ilab.longneck.process.constraint;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CvdLogicTest {

    @Test
    public void test01() {
        CvdLogic logic = new CvdLogic();
        logic.setMod(10);
        ArrayList<Integer> coeffs = new ArrayList<Integer>();
        coeffs.add(1);
        coeffs.add(1);
        coeffs.add(1);
        coeffs.add(-1);
        logic.setCoeffs(coeffs);

        assertTrue(logic.check("5678"));
        assertFalse(logic.check("5674"));
    }

    public void test02() {
        CvdLogic logic = new CvdLogic();
        logic.setMod(11);
        ArrayList<Integer> coeffs = new ArrayList<Integer>();
        for (int i = 1; i <= 11; ++i)
            coeffs.add(i);
        coeffs.add(-1);
        assertFalse(logic.check("27506303842"));
        assertTrue(logic.check("27506303846"));
    }
}
