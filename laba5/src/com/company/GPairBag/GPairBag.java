package com.company.GPairBag;

import com.company.Pair.Pair;
import com.company.PairBag.PairBag;

import java.util.Objects;

public class GPairBag extends PairBag {
    private String keyType = "null";
    private String valueType = "null";


    public GPairBag(int size) {
        super(size);
    }

    public void add(Pair<Object, Object> item) {
        String keyTypeCurrent = String.valueOf(item.getKey().getClass());
        String valueTypeCurrent = String.valueOf(item.getValue().getClass());

        if (Objects.equals(this.keyType, "null") && Objects.equals(this.valueType, "null")) {
            this.keyType = keyTypeCurrent;
            this.valueType = valueTypeCurrent;

            super.add(item);

        } else if (Objects.equals(this.keyType, keyTypeCurrent) && Objects.equals(this.valueType, valueTypeCurrent)) {
            super.add(item);
        } else {
            System.out.print("Типы не совпадают!");
        }
    }
}

