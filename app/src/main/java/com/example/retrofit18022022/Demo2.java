package com.example.retrofit18022022;

import java.util.List;

public class Demo2 {

    private List<Danhsach> danhsach = null;

    public List<Danhsach> getDanhsach() {
        return danhsach;
    }

    public void setDanhsach(List<Danhsach> danhsach) {
        this.danhsach = danhsach;
    }

    @Override
    public String toString() {
        return "Demo2{" +
                "danhsach=" + danhsach +
                '}';
    }
}
