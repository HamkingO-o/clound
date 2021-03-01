package com.springcolud.demo.controller;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestController {
    String[] arr = new String[]{"1", "2","2"};
    int[] array = {1, 2, 5, 5, 5, 5, 6, 6, 7, 2, 9, 2};
    List<String> list= Arrays.asList(arr);

   @Test
   public void test( ){
       Iterator iterator=list.iterator();
       while (iterator.hasNext()){
           System.out.println(iterator.next());
       }

       Set set=new HashSet();
       set.add("aa");
       set.add("aa1");
       System.out.println(set);
       /*int[]转list*/
       //方法一：需要导入apache commons-lang3  jar
       //List<Integer> list = Arrays.asList(ArrayUtils.toObject(array));
       //方法二：java8及以上版本
       List<Integer> list1 = Arrays.stream(array).boxed().collect(Collectors.toList());
       System.out.println(list1);
       /*list转int[]*/
       //方法一：
     //  Integer[] intArr =  list.toArray(new Integer[list.size()]);
//      List list=new ArrayList();
//      list=removeDuplicate(list1);
//       System.out.println(list);

}


    public   static   List  removeDuplicate(List list)  {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }
}
