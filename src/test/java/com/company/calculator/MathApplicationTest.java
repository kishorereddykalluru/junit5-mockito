package com.company.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathApplicationTest {

    @InjectMocks
    MathApplication mathApplication;

    @Mock
    CalculatorService calculatorService;

    @Test
    void add() {
        when(calculatorService.add(anyDouble(),anyDouble())).thenReturn(30.00);
        double add = mathApplication.add(10.00, 20.00);
        assertEquals(30.00, add);
        //verify() method is used to ensure whether a mock method is being called with required arguments or not....
        verify(calculatorService).add(10.00, 20.00); //true
        //verify(calculatorService).add(20.00, 20.00); //false because there is not mocking with arguments 20.00 and 20.00
     }

    @Test
    void subtract() {
    }

    @Test
    void multiply() {
    }

    @Test
    void divide() {
    }
}