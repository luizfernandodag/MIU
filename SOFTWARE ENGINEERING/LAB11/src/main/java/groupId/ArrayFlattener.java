package groupId;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayFlattener {

    public ArrayFlattener()
    {

    }

    public Integer[] flattenArray(Integer [][] in)
    {   if(in == null)
        return null;

        Integer [] out = Arrays.stream(in).flatMap(Arrays::stream).collect(Collectors.toList()).toArray(Integer[] :: new);
        return out;
        //return Arrays.stream(in).flatMap(Arrays::stream).collect(Collectors.toList());


    }


    public Integer[] reverseArray(Integer [][] in)
    {
        if(in == null)
            return null;
        Integer[] flatten = flattenArray(in);
        Collections.reverse(Arrays.asList(flatten));
        return flatten;
    }
}
