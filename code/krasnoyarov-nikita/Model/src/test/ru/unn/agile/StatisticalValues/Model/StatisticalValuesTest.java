package ru.unn.agile.StatisticalValues.Model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StatisticalValuesTest {

    @Test
    public void canCalculateExpectedValueWithOneNumber() {
        List values = Arrays.asList(1.0);
        List probabilities = Arrays.asList(1.0);
        StatisticalValues statisticalCalculator = new StatisticalValues(values, probabilities);
        double expectedValue = 0;

        try {
            expectedValue = statisticalCalculator.calculateExpectedValue();
        }
        catch (Exception e)
        {

        }

        assertEquals(1, expectedValue, Float.MIN_VALUE);
    }

    @Test
    public void canCalculateExpectedValueWithTwoNumbers() {
        List values = Arrays.asList(1.0, 2.0);
        List probabilities = Arrays.asList(0.3, 0.7);
        StatisticalValues statisticalCalculator = new StatisticalValues(values, probabilities);
        double expectedValue = 0;

        try {
            expectedValue = statisticalCalculator.calculateExpectedValue();
        }
        catch (Exception e)
        {

        }

        assertEquals(1.7, expectedValue, Float.MIN_VALUE);
    }

    @Test
    public void canCalculateExpectedValueWithMultipleNumbers() {
        List values = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        List probabilities = Arrays.asList(0.2, 0.2, 0.2, 0.2, 0.2);
        StatisticalValues statisticalCalculator = new StatisticalValues(values, probabilities);
        double expectedValue = 0;

        try {
            expectedValue = statisticalCalculator.calculateExpectedValue();
        }
        catch (Exception e)
        {

        }

        assertEquals(3.0, expectedValue, Float.MIN_VALUE);
    }

    @Test
    public void checkSumProbabilitiesValueEqualsOne() {
        List values = Arrays.asList(1.0, 2.0);
        List probabilities = Arrays.asList(0.1, 0.5);
        double expectedValue = 0;
        StatisticalValues statisticalCalculator = new StatisticalValues(values, probabilities);
        String message = "";

        try {
            expectedValue = statisticalCalculator.calculateExpectedValue();
        }
        catch (Exception e)
        {
            message = e.getMessage();
        }

        assertEquals("Sum of probabilities doesn't equal to 1", message);
    }

    @Test
    public void checkNegativeProbabilitiesValue() {
        List values = Arrays.asList(1.0, 2.0);
        List probabilities = Arrays.asList(-5.0, 0.9);
        double expectedValue = 0;
        StatisticalValues statisticalCalculator = new StatisticalValues(values, probabilities);
        String message = "";

        try {
            expectedValue = statisticalCalculator.calculateExpectedValue();
        }
        catch (Exception e)
        {
            message = e.getMessage();
        }

        assertEquals("One of probabilities is negative", message);
    }

    @Test
    public void checkProbabilitiesValueMoreOne() {
        List values = Arrays.asList(1.0, 2.0);
        List probabilities = Arrays.asList(0.3, 1.5);
        double expectedValue = 0;
        StatisticalValues statisticalCalculator = new StatisticalValues(values, probabilities);
        String message = "";

        try {
            expectedValue = statisticalCalculator.calculateExpectedValue();
        }
        catch (Exception e)
        {
            message = e.getMessage();
        }

        assertEquals("One of probabilities is more than 1", message);
    }

    @Test
    public void checkDifferentSizeOfLists() {
        List values = Arrays.asList(1.0, 2.0, 3.0);
        List probabilities = Arrays.asList(0.3, 0.7);
        double expectedValue = 0;
        StatisticalValues statisticalCalculator = new StatisticalValues(values, probabilities);
        String message = "";

        try {
            expectedValue = statisticalCalculator.calculateExpectedValue();
        }
        catch (Exception e)
        {
            message = e.getMessage();
        }

        assertEquals("Size of values and probabilities lists doesn't match", message);
    }

}
