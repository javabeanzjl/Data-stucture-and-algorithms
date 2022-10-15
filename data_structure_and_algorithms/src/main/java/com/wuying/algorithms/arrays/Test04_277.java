package com.wuying.algorithms.arrays;

public class Test04_277 {
    
    public int searchCeleBrity(int n) {
        
        if (n < 2) return - 1;
        int possible = 0;
        for (int i = 1; i < n; i++) {
            if (!knows(i, possible)) possible = i;
        }
        for (int i = 0; i < n; i++) {
            if (i != possible && !(knows(i, possible) || knows(possible, i))) return -1;
        }
        return possible;
    }
    
    public boolean knows(int i, int possible) {
        return true;    
    }
}
