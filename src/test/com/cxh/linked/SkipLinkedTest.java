package com.cxh.linked;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.*;

public class SkipLinkedTest {
    final int size = 100000;
    final int serachCount = 1000;
    @Test
    public void addBySkipList() throws InterruptedException {
        int count = 0;
        Random rondom = new Random();
        SkipLinked<Integer> skipLinked = new SkipLinked<>();
        while (true) {
            count++;
            if (count > size) {
                break;
            }
            int r = rondom.nextInt(size);
            skipLinked.add(r);
        }
        long maxTime = 0;
        count = 0;
        while (true) {
            count++;
            if (count>serachCount){
                break;
            }
            long startTime = System.nanoTime();
            int target = rondom.nextInt(size);
            Node index = skipLinked.serach(target);
            long end = System.nanoTime();
            long diff = end-startTime;
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
            if (count > size) {
                break;
            }
            int r = rondom.nextInt(size);
            linkedList.add(r);
        }
        long maxTime = 0;
        count = 0;
        while (true) {
            count++;
            if (count>serachCount){
                break;
            }
            long startTime = System.nanoTime();
            int target = rondom.nextInt(size);
            int index = linkedList.indexOf(target);
            long end = System.nanoTime();
            long diff = end-startTime;
            if (maxTime<diff){
                maxTime = diff;
            }
        }
        System.out.println("耗时最长"+maxTime);
    }


}