package hu.sztaki.ilab.longneck.process.constraint;

import static org.junit.Assert.*;

import org.junit.Test;

public class CvdLogicTest {

    @Test
    public void test01() {
        CvdLogic logic = new CvdLogic();

        assertTrue(logic.check("5678", "1;1;1;-1", "10"));
        assertFalse(logic.check("5674", "1;1;1;-1", "10"));

        assertFalse(logic.check("27506303842", "1;2;3;4;5;6;7;8;9;10;-1", "11"));
        assertTrue(logic.check("27506303846", "1;2;3;4;5;6;7;8;9;10;-1", "11"));
    }
}
