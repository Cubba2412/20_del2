package UnitTesting;

import Classes.FeltListKeyValue;
import org.junit.jupiter.api.Test;
import Classes.FeltListe;

import static org.junit.jupiter.api.Assertions.*;

class FeltListeTest {
    FeltListe feltList = new FeltListe();

    //Test for correct field values
    @Test
    void getValueTest() {
        int[] feltKeys = new int[] {2,3,4,5,6,7,8,9,10,11,12};
        int[] values = new int[] {250,-100,100,-20,180,0,-70,60,-80,-50,650};
        for (int i =0;i< feltKeys.length;i++) {
            FeltListKeyValue keyValue = feltList.getValue(feltKeys[i]);
            int value = keyValue.getValue();
            assertEquals(value,values[i]);
        }
    }
}