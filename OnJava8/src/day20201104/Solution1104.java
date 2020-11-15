package day20201104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution1104 {
    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        if(label == 1){
            res.add(1);
            return res;
        }
        int tmp = 1,layer = 0;
        while(tmp < label){
            tmp *= 2;
            layer++;
        }


        for (int i = 0; i < layer; i++) {
            res.add(label);
            tmp /= 2;
            label = parent(label, tmp);
        }
        Collections.reverse(res);
        return res;


    }

    public static int parent(int son, int norm){
        return (norm- son/2) + (norm/2 -1);
    }

    public static void main(String[] args) {
        pathInZigZagTree(16);
    }
}