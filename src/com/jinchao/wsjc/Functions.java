package com.jinchao.wsjc;

import java.util.List;

public interface Functions {
    /*
    * */
    public List<int[]> cleanData(int[][] input);
    public List<int[]> sortData(List<int[]> input);
    public int[][] mergeData(List<int[]> input);
    public int[][] combineAll(int[][] input);
}
