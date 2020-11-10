package com.jinchao.wsjc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsImplementationTest {

    @Test
    void combineAll() {
        FunctionsImplementation fi = new FunctionsImplementation();

        String result1 = "";
        for(int[] i: fi.combineAll(new int[][]{
                {49679, 52015}, {49800, 50000}, {51500, 53479}, {45012, 46937},
                {54012, 59607}, {45500, 45590}, {45999, 47900}, {44000, 45000}, {43012, 45950}}
                )){
            result1 += Arrays.toString(i);
        }
        assertEquals("[43012, 47900][49679, 53479][54012, 59607]", result1);

        String result2 = "";
        for(int[] i: fi.combineAll(new int[][]{ {94133,94133} ,{94200,94299} ,{94226,94399} })){
            result2 += Arrays.toString(i);
        }
        assertEquals("[94133, 94133][94200, 94399]", result2);

        String result3 = "";
        for(int[] i: fi.combineAll(new int[][]{ {94133,94133} ,{94200,94299} ,{94600,94699} })){
            result3 += Arrays.toString(i);
        }
        assertEquals("[94133, 94133][94200, 94299][94600, 94699]", result3);

        //null input testcase
        String result4 = "";
        for(int[] i: fi.combineAll(new int[][]{ })){
            result4 += Arrays.toString(i);
        }
        assertEquals("", result4);

        //single input testcase
        String result5 = "";
        for(int[] i: fi.combineAll(new int[][]{{98006, 99001}})){
            result5 += Arrays.toString(i);
        }
        assertEquals("[98006, 99001]", result5);

        //Disordered input testcase
        String result6 = "";
        for(int[] i: fi.combineAll(new int[][]{ {94133, 94133}, {94600,94699}, {94299, 94200} })){
            result6 += Arrays.toString(i);
        }
        assertEquals("[94133, 94133][94200, 94299][94600, 94699]", result6);

    }


}