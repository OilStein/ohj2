package demo.d4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    void hypotenuusaTest() {
        assertEquals(5, Kolmio.hypotenuusa(3, 4));
        assertEquals(1.4, Kolmio.hypotenuusa(1, 1), 0.1);
        assertEquals(0, Kolmio.hypotenuusa(0, 0));
        assertEquals(1.4, Kolmio.hypotenuusa(-1, -1), 0.1);
    }

    @Test
    void pintaalaTest() {
        assertEquals(6, Kolmio.kolmionAla(3, 4));
        assertEquals(0.5, Kolmio.kolmionAla(1, 1), 0.1);
        assertEquals(0, Kolmio.kolmionAla(0, 1));
        assertEquals(0.5, Kolmio.kolmionAla(-1, -1), 0.1);
    }

    @Test
    void demohyvitysTest() {
        assertEquals(6, Demo.demohyvitys(100, 100));
        assertEquals(6, Demo.demohyvitys(90, 100));
        assertEquals(5, Demo.demohyvitys(80, 100));
        assertEquals(4, Demo.demohyvitys(70, 100));
        assertEquals(3, Demo.demohyvitys(60, 100));
        assertEquals(2, Demo.demohyvitys(50, 100));
        assertEquals(1, Demo.demohyvitys(40, 100));
        assertEquals(0, Demo.demohyvitys(30, 100));
        assertEquals(6, Demo.demohyvitys(74, 10));
        assertThrowsExactly(IllegalArgumentException.class, () -> Demo.demohyvitys(-1, 100));
        assertThrowsExactly(IllegalArgumentException.class, () -> Demo.demohyvitys(100, -1));
    }
}
