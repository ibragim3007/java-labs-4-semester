package com.company.Coins;


import com.company.DList.DList;

import java.util.ArrayList;

public class Coins {
    private final int[] costs;
    private final ArrayList<Integer> used;
    private final ArrayList<Integer> minCoins;

    public Coins(int ...costs){
        this.costs = costs;
        used = new ArrayList<>();
        minCoins = new ArrayList<>();
    }

    public DList expand(int end){
        for (int i = used.size(); i <= end; i++){
            int count = i;
            int newCoin = 1;
            ArrayList<Integer> c = new ArrayList<>();
            for (int x: costs){
                if (x <= i){
                    c.add(x);
                }
            }
            for (int j: c ){
                if(minCoins.get(i-j) + 1 < count){
                    count = minCoins.get(i - j) + 1;
                    newCoin = j;
                }
            }
            minCoins.add(count);
            used.add(newCoin);
        }

        DList<Integer,Integer> DL = new DList<>();
        for (int i = 0; i <= end; i++){
            ArrayList<Integer> coinList = new ArrayList<>();
            int coin = i;
            while (coin > 0){
                coinList.add(used.get(coin));
                coin -= used.get(coin);
            }
            Integer[] arr = new Integer[coinList.size()];
            for(int j = 0; j < arr.length; j++){
                arr[j] = coinList.get(j);
            }
            DL.add(i, arr);
        }
        return DL;
    }




    public ArrayList<Integer> getMin() {
        return minCoins;
    }

}