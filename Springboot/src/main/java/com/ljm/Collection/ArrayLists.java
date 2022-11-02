package com.ljm.Collection;
import org.junit.Test;
import java.util.ArrayList;
public class ArrayLists {

    @Test
    public void test(){
        ArrayList arrayList=new ArrayList(10);
        arrayList.add("222");
        System.out.println(arrayList.size());
        arrayList.add(3333);
        arrayList.add(33333);
        arrayList.set(0,333);
        arrayList.add("212");
        System.out.println(arrayList.get(0));
        arrayList.forEach(f->{
            System.out.println(f);
        });
     }}
