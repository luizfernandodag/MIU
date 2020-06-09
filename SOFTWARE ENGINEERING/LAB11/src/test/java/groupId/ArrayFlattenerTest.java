package groupId;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayFlattenerTest {

    private ArrayFlattener arrayflattener = null;
    @Before
    public void setUp() throws Exception {
        arrayflattener = new ArrayFlattener();
    }

    @After
    public void tearDown() throws Exception {
        this.arrayflattener = null;
    }

    @Test
    public void flattenArray() {
        //INPUT
        Integer[][] a_in = new Integer[3][];
        a_in[0] = new Integer[]{1,3};
        a_in[1] = new Integer[]{0};
        a_in[2] = new Integer[]{4,5,9};
        //OUPUT
        Integer [] actual = this.arrayflattener.flattenArray(a_in);
        //EXPECTED
        Integer[] a_out = new Integer[]{1,3,0,4,5,9};

        //TEST
        assertArrayEquals(a_out,actual);
    }

    @Test
    public void testInvalidInput() {
        //INPUT
        Integer[][] a_in = null;
        //OUPUT
        Integer [] actual = this.arrayflattener.flattenArray(a_in);
        //EXPECTED
        Integer[] a_out = null;
        Assert.assertNull("Failure: expected null", actual);

    }
}