package net.keinesorgen.puzzle.magicStringMaxDifference;

/**
 *
 */
public class MagicStrings {

    enum Solution {
        EVEN, ODD;
    }
    
    
    
    public Solution solution(int M, String[] strings) {
    
        class Character {
            byte value;
            Solution parity;

            public Character(byte value) {
                this.value = value;
                this.parity = value%2==0 ? Solution.EVEN : Solution.ODD;
            }
            
            
            
        }
        
        
        for(String item : strings) {
            for(int i=0; i<item.length(); i++) {
                char character = item.charAt(i);
                System.out.println("character="+character+" "+(byte)character);
                
                // P^P = P
                // P^N = P
                // N^N = N
                // N^P = N
                
                // a^x * b^x = (ab)^x
                
                // 
                        
            }
        }
        
        
        return Solution.EVEN;
    }
}
