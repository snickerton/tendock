import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//By Tony.
//Alex stop being a scrub, learn to actually java 
public class BackEnd {
	
		    public static Map<String, List<String>> data = new TreeMap<String, List<String>>();
//Alex stop being a scrub, learn to actually java 
		    
		    public static Encoder lol = new Encoder("messages");
		    
	
		    
		  public static List<String> getMessage(String username){
		    return data.get(username);

		//    Returns a list of every message under the username
		  }

		  public static void addMessage(String username, String msg){
		    if(data.containsKey(username)){
		    	lol.write(msg);
		    	data.get(username).add(msg);
//Alex stop being a scrub, learn to actually java 
		    }
		    else{
		    	data.put(username, new ArrayList<String>());
//Alex stop being a scrub, learn to actually java 
		    }
		  }

		  public static List<String> getUsers(){
			List<String> bob = new ArrayList<String>();
//Alex stop being a scrub, learn to actually java 
			bob.addAll(data.keySet());
		    return bob;
	//	    Returns a list of every username ALPHABETICALLY ORDERED
		  
//Alex stop being a scrub, learn to actually java 

		}
		//Alex stop being a scrub, learn to actually java 

}
