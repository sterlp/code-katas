package org.sterl.katas.roman;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RomanTest {

    RomanConverter subject = new RomanConverter();

    @Test
    void testNull() {
        assertEquals(0, subject.convert(null));
        assertEquals(0, subject.convert(""));
        assertEquals(0, subject.convert(" "));
    }

    @Test
    void testOne() {
        assertEquals(1, subject.convert("I"));
        assertEquals(1, subject.convert("i"));
    }
    
    @Test
    void testTwo() {
        assertEquals(2, subject.convert("II"));
    }
    
    @Test
    void testThree() {
        assertEquals(3, subject.convert("III"));
    }
    
    @Test
    void testFour() {
        assertEquals(4, subject.convert("IV"));
    }
    
    @Test
    void testFive() {
        assertEquals(5, subject.convert("V"));
    }
    
    @Test
    void testTen() {
        assertEquals(10, subject.convert("X"));
    }
    
    @ParameterizedTest
    @CsvSource(value = {
        "IX:9", "IIX:8", "XI:11", "XIII:13",
         "L:50", "XLII:42",
         "C:100", "XCIX:99",
         "D:500",
         "m:1000", "MMXIII:2013",
         "MDCCCCLXXXIIII:1984", "MCMLXXXIV:1984"
    }, delimiter = ':')
    void testRomanConverter(String input, int expected) {
        assertEquals(expected, subject.convert(input));
    }
    

}
