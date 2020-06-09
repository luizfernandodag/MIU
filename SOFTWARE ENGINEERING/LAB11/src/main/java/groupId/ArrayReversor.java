package groupId;

import java.util.Arrays;
import java.util.Collections;

public class ArrayReversor {
    private ArrayFlattenerService arrayFlattenerService;

    public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }

    Integer[] reverseArray(Integer[][] in)
    {
        if(in == null)
            return null;
        Integer[] flatten = arrayFlattenerService.flattenArray(in);
        Collections.reverse(Arrays.asList(flatten));
        return flatten;
    }
}

