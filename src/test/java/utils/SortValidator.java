package utils;

import org.testng.Assert;
import java.util.List;

public class SortValidator {

    // ---------------- NUMBERS ----------------

    public static void assertSortedLowToHigh(List<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Assert.assertTrue(
                    list.get(i) <= list.get(i + 1),
                    "List is not sorted low to high at index " + i
            );
        }
    }

    public static void assertSortedHighToLow(List<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Assert.assertTrue(
                    list.get(i) >= list.get(i + 1),
                    "List is not sorted high to low at index " + i
            );
        }
    }

    // ---------------- STRINGS (A-Z / Z-A) ----------------

    public static void assertSortedAZ(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Assert.assertTrue(
                    list.get(i).compareToIgnoreCase(list.get(i + 1)) <= 0,
                    "List is not sorted A-Z at index " + i
            );
        }
    }

    public static void assertSortedZA(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Assert.assertTrue(
                    list.get(i).compareToIgnoreCase(list.get(i + 1)) >= 0,
                    "List is not sorted Z-A at index " + i
            );
        }
    }
}