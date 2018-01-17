package com.starwars.puchault_tp_final.models;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by puchault on 17/01/2018.
 */

public class SWModelList<T> implements Serializable{
    public int count;
    public String next;
    public String previous;
    public List<T> results;

    public boolean hasMore() {
        return !TextUtils.isEmpty(next);
    }
}
