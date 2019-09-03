package com.cxh.linked;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.*;

public class SkipLinkedTest {

    @Test
    public void addBySkipList() throws InterruptedException {
        int count = 0;
        Random rondom = new Random();
        SkipLinked<Integer> skipLinked = new SkipLinked<>();
        while (true) {
            count++;
            if (count > 1000) {
                break;
            }
            int r = rondom.nextInt(10000);
            skipLinked.add(r);
        }
        long maxTime = 0;
        count = 0;
        while (true) {
            count++;
            if (count>1000){
                break;
            }
            long startTime = System.nanoTime();
            int target = rondom.nextInt(10000);
            Node index = skipLinked.serach(target);
            long end = System.nanoTime();
            long diff = end-startTime;
            System.out.println("本次查询耗费时长"+diff+"纳秒");
            if (maxTime<diff){
                maxTime = diff;
            }
        }
        System.out.println("耗时最长"+maxTime);
    }

    @Test
    public void addByLinked() throws InterruptedException {
        int count = 0;
        Random rondom = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (true) {
            count++;
            if (count > 1000) {
                break;
            }
            int r = rondom.nextInt(10000);
            linkedList.add(r);
        }
        long maxTime = 0;
        count = 0;
        while (true) {
            count++;
            if (count>1000){
                break;
            }
            long startTime = System.nanoTime();
            int target = rondom.nextInt(10000);
            int index = linkedList.indexOf(target);
            long end = System.nanoTime();
            long diff = end-startTime;
            System.out.println("本次查询耗费时长"+diff+"纳秒");
            if (maxTime<diff){
                maxTime = diff;
            }
        }
        System.out.println("耗时最长"+maxTime);
    }


}