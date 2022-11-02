package com.ljm.fanxing;

import java.util.ArrayList;

class Point<T> {

     private T var;

     public void setVar(T var) {
         this.var = var;
     }

     public T getVar() {
         return var;
     }
 }
    class test{
        public  static void main(String args[]){
            Point<String> point =new   Point<String>();
            point.setVar("23");
            System.out.println(point.getVar());
        }
}


    class Point2<K,V> {

   private K Id;
    private V name;

        public void setId(K id) {
            this.Id = id;
        }

        public void setName(V name) {
            this.name = name;
        }

        public K getId() {
            return Id;
        }

        public V getName() {
            return name;
        }

        public Point2(K id, V name) {
            this.Id = id;
            this.name = name;
        }
        public Point2(){}
    }
    class test2{

     public static void main(String args[]){
         Point2<String, Integer> stringIntegerPoint2 = new Point2<String, Integer>();
     }
    }



    class test3{
        @SuppressWarnings({"all"})
        public static void main(String[] args) throws Exception {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.getClass().getMethod("add", Object.class).invoke(list,"asd");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }

    }
//




