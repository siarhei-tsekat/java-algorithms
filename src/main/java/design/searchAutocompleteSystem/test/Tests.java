package design.searchAutocompleteSystem.test;

import design.searchAutocompleteSystem.AutocompleteSystem;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Tests {

    @Test
    public void test1() {
        String[] strs = {"i love you", "island", "ironman", "i love leetcode"};
        int[] nums = {5, 3, 2, 2};

        AutocompleteSystem system = new AutocompleteSystem(strs, nums);

        List<String> input = system.input('i');
        assertEquals(input, Arrays.asList("i love you", "island", "i love leetcode"));

        List<String> input2 = system.input(' ');
        assertEquals(input2, Arrays.asList("i love you", "i love leetcode"));

        List<String> input3 = system.input('a');
        assertTrue(input3.isEmpty());

        List<String> input4 = system.input('#');
        assertTrue(input4.isEmpty());
    }

    @Test
    public void test2() {
        String[] strs = {"i love you","island","iroman","i love leetcode"};
        int[] nums = {5, 3, 2, 2};

        AutocompleteSystem system = new AutocompleteSystem(strs, nums);

        List<String> input = system.input('i');
        assertEquals(input, Arrays.asList("i love you", "island", "i love leetcode"));

        List<String> input2 = system.input(' ');
        assertEquals(input2, Arrays.asList("i love you", "i love leetcode"));

        List<String> input3 = system.input('a');
        assertTrue(input3.isEmpty());

        List<String> input4 = system.input('#');
        assertTrue(input4.isEmpty());

        List<String> input5 = system.input('i');
        assertEquals(input5, Arrays.asList("i love you", "island", "i love leetcode"));

        List<String> input6 = system.input(' ');
        assertEquals(input6, Arrays.asList("i love you","i love leetcode","i a"));

        List<String> input7 = system.input('a');
        assertEquals(input7, Arrays.asList("i a"));

        List<String> input8 = system.input('#');
        assertTrue(input8.isEmpty());

        List<String> input9 = system.input('i');
        assertEquals(input9, Arrays.asList("i love you","island","i a"));

        List<String> input10 = system.input(' ');
        assertEquals(input10, Arrays.asList("i love you","i a","i love leetcode"));

        List<String> input11 = system.input('a');
        assertEquals(input11, Arrays.asList("i a"));

        List<String> input12 = system.input('#');
        assertTrue(input12.isEmpty());
    }



















}
