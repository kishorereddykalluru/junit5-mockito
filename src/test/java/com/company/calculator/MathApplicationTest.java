package com.company.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MathApplicationTest {

    @InjectMocks
    MathApplication mathApplication;

    @Mock
    CalculatorService calculatorService;

    @Test
    void testCalcService_verifying_behaviour(){
        when(calculatorService.add(10.00, 20.00)).thenReturn(30.00);
        double add = mathApplication.add(10.00, 20.00);
        assertEquals(30.00, add);
        //verify() method is used to ensure whether a mock method is being called with required arguments or not....
        verify(calculatorService).add(10.00, 20.00); //true
        //verify(calculatorService).add(20.00, 20.00); //false because there is not mocking with arguments 20.00 and 20.00
    }


    /**
     * Expecting calls
     *
     * Mockito provides a special check on the number of calls that can be made on a particular method.
     * Suppose MathApplication should call the CalculatorService.serviceUsed() method only once,
     * then it should not be able to call CalculatorService.serviceUsed() more than once.
     *
     * limit the method call to 1, no less and no more calls are allowed
     */

    @Test
    void testCalcService_expecting_calls() {

        when(calculatorService.add(20.00, 40.00)).thenReturn(60.00);
        when(calculatorService.subtract(40.00, 10.00)).thenReturn(30.00);

        assertEquals(60.00, mathApplication.add(20.00, 40.00));
        assertEquals(60.00, mathApplication.add(20.00, 40.00));
        assertEquals(60.00, mathApplication.add(20.00, 40.00));
        assertEquals(30.00, mathApplication.subtract(40.00, 10.00));
        /**
         * verify(calculatorService).subtract(40.00,10.00); default count is 1. so true.
         *
         * check if add functionality is called 3 times
         * verify(calculatorService, times(3)).add(20.00, 40.00);
         *
         * verify that method was never called on a mock
         * verify(calculatorService, never()).multiply(40.00, 10.00);
         */
        verify(calculatorService).subtract(40.00,10.00);
        verify(calculatorService, times(3)).add(20.00, 40.00);
        verify(calculatorService, never()).multiply(40.00, 10.00);
     }

    /**
     * Mockito provides the following additional methods to vary the expected call counts.
     *
     * atLeast (int min) − expects min calls.
     *
     * atLeastOnce () − expects at least one call.
     *
     * atMost (int max) − expects max calls.
     */
    @Test
    void testCalcService_varying_calls(){
        when(calculatorService.add(10.00, 20.00)).thenReturn(30.00);
        when(calculatorService.subtract(20.00, 10.00)).thenReturn(10.00);

        assertEquals(30.00,mathApplication.add(10.00, 20.00));
        assertEquals(30.00,mathApplication.add(10.00, 20.00));
        assertEquals(30.00,mathApplication.add(10.00, 20.00));

        assertEquals(10.00,mathApplication.subtract(20.00, 10.00));

        //check a minimum 1 call support
        verify(calculatorService, atLeastOnce()).subtract(20.00, 10.00);
        //check add() is called minimum 2 times
        verify(calculatorService, atLeast(2)).add(10.00, 20.00);
        //check add() is called maximum 3 times
        verify(calculatorService, atMost(3)).add(10.00, 20.00);
        /**
         * fails because add() is called 3 times and maximum number of calls is 2 atmost
         */
        //verify(calculatorService, atMost(2)).add(10.00, 20.00);
     }

    /**
     * Mockito provides the capability to a mock object to throw exceptions, so exception handling can be tested.
     */
    @Test
     void testCalcService_exception_handling(){
       when(calculatorService.add(10.00, 20.00)).thenThrow(new RuntimeException("add operation not implemented"));
      //assertEquals(30.00, mathApplication.add(10.00, 20.00));
      // Throws exception when add() method is called
       assertThrows(RuntimeException.class, () -> mathApplication.add(10.00, 20.00));
     }

    /**
     * Mockito provides a Answer interface which allows stubbing with generic interface.
     */
    @Test
    void testCalcService_callbacks(){

     }

    @Test
    void testCalcService_spying(){

    }

    @Test
    void testCalcService_resetting_mocks(){

    }
}