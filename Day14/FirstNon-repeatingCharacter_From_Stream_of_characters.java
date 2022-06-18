
// Interview bit    
public class Solution {
 public  String solve(String A) {
	        Queue<Character> q  =  new ArrayDeque<>();
	        HashMap<Character,Integer> occr = new HashMap<>();
	        StringBuilder sb =  new StringBuilder();
	        
	        for(char ch : A.toCharArray() ){
	             
	            while(!q.isEmpty() && ( q.peek() == ch  ) ){
	                q.poll();
	            }
	            while(!q.isEmpty() && (occr.getOrDefault(q.peek() ,0 ) > 1 ) ){
	                q.poll();
	            }
	            
	            if(q.size() ==0 ){
	                if(occr.containsKey(ch) == false) sb.append(ch);
	                else sb.append("#");
	            }
	            else{
	                sb.append(q.peek());
	            }
	            if(occr.containsKey(ch) == false ){                
	                q.offer(ch);
	            }
	            occr.put(ch , occr.getOrDefault(ch,0)+1 );
	            

	            
	        }
	        return sb.toString();
	    }
}

