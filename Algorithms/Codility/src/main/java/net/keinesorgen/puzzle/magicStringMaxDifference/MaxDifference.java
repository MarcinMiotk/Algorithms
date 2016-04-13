package net.keinesorgen.puzzle.magicStringMaxDifference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class MaxDifference {

  

    static class Link implements Comparable<Link> {

        int value;
        int position;

        public Link(int value, int position) {
            this.value = value;
            this.position = position;
        }

        @Override
        public int compareTo(Link t) {
            //return value - t.value;
            return t.value-value;
        }

        @Override
        public String toString() {
            return value + "(" + position + ")";
        }

    }
    
    static class Pair {
        Link first;
        Link second;

        public Pair(Link first, Link second) {
            this.first = first;
            this.second = second;
        }
        
        
    }

    static int maxDifference(int[] a) {

        List<Link> links = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            links.add(new Link(a[i], i));
        }
        Collections.sort(links);

        int maxDifference = -1;
        
        System.out.println(links);

        for (int x = 0; x < links.size(); x++) {
            for (int y = links.size()-1; y >=0 ; y--) {               
                Link bigger = links.get(x);
                Link lower = links.get(y);
                if(bigger.position>lower.position) {
                    if(bigger.value>lower.value) {
                        int localDifference = bigger.value-lower.value;
                        
                        
                        System.out.println(bigger+ "and "+lower+" and "+localDifference);
                        
                        if(maxDifference<localDifference) {
                            maxDifference = localDifference;
                        }
                    }
                }

//                if(lower.position>bigger.position) {
//                    if(lower.value>bigger.value) {
//                        int localDifference = lower.value-bigger.value;
//                        if(maxDifference<localDifference) {
//                            maxDifference = localDifference;
//                        }
//                    }
//                }

                
                
            }
        }
        return maxDifference;
    }
}
