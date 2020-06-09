package groupId;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class ArrayReversorTest {
    private ArrayReversor arrayReversor;
    private ArrayFlattenerService arrayFlattenerService = mock( ArrayFlattenerService.class);

    @Before
    public void setUp() throws Exception {

        this.arrayReversor = new ArrayReversor(arrayFlattenerService );
    }

    @After
    public void tearDown() throws Exception {
        this.arrayReversor = null;
    }

    @Test
    public void reverseArray() {
        //INPUT
        Integer[][] a_in = new Integer[3][];
        a_in[0] = new Integer[]{1,3};
        a_in[1] = new Integer[]{0};
        a_in[2] = new Integer[]{4,5,9};
        //EXPECTED FLATTEN
        Integer[] a_out = new Integer[]{1,3,0,4,5,9};
        //MOCK
        when( arrayFlattenerService.flattenArray(a_in)).thenReturn(a_out);

        //ACTUAL
        Integer [] actual = arrayReversor.reverseArray(a_in);
        //EXPECTED
        Integer[] expected = new Integer[]{9,5,4,0,3,1};
        //TEST
        assertArrayEquals( expected,actual);

    }

    @Test
    public void testInvalidInput() {
        //INPUT
        Integer[][] a_in = null;
        //OUPUT
        Integer [] actual = this.arrayFlattenerService.flattenArray(a_in);
        //EXPECTED
        Integer[] a_out = null;
        Assert.assertNull("Failure: expected null", actual);

    }
}