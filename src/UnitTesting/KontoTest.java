package UnitTesting;

import Classes.Konto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KontoTest {
    Konto konto = new Konto(1000);
    @Test
    void negativeKontoTest() {
        boolean Success = konto.updatePengeBeholdning(-10000);
        assertFalse(Success);
    }

}