package com.jinchao.wsjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FunctionsImplementation implements Functions{
    /**
     * Clean input to make input[i][0]<=input[i][1]
     *
     * @param  input the value should be a n*2 array
     * @return List of array as the input for sortData()
     */
    @Override
    public List<int[]> cleanData(int[][] input) {
        List<int[]> result = new ArrayList<>();
        for(int[] i : input){
            if(i[0]>i[1]){
                result.add(new int[]{i[1], i[0]});
            }else{
                result.add(i);
            }
        }
        return result;
    }


    /**
     * Sort array after cleanData() to make input[i][0] <= input[i+1][0]
     *
     * @param  input the value should be a list of array
     * @return List of array as the input for mergeData()
     */
    @Override
    public List<int[]> sortData(List<int[]> input) {
        Collections.sort(input, (array1, array2) -> array1[0] - array2[0]);

        return input;
    }

    /**
     * Merge array after sortData()
     *
     * @param  input the value should be a list of array
     * @return 2D array of no unmerged ranges
     */
    @Override
    public int[][] mergeData(List<int[]> input) {
        List<int[]> result = new ArrayList<>();
        int[] tmp = input.get(0);
        result.add(tmp);
        for(int[] i : input){
            if(i[0]<=tmp[1]){
                tmp[1] = Math.max(i[1],tmp[1]);
            }else{
                tmp = i;
                result.add(tmp);
            }
        }

        return result.toArray(new int[result.size()][]);
    }


    /**
     * Combine all the functions above and return a final result
     *
     * @param  input 2D array of uncleaned, unsorted, or unmerged data
     * @return 2D array of no unmerged ranges
     */
    @Override
    public int[][] combineAll(int[][] input) {
        if(input.length<1){
            return input;
        }
        List<int[]> tmp = cleanData(input);
        tmp = sortData(tmp);
        return mergeData(tmp);
    }
}
