import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class BackEnd {
	
		    public static Map<String, List<String>> data = new TreeMap<String, List<String>>();
		    
		    public static Encoder lol = new Encoder("messages");
		    
		  public static List<String> getMessage(String username){
		    return data.get(username);

		//    Returns a list of every message under the username
		  }

		  public static void addMessage(String username, String msg){
		    if(data.containsKey(username)){
		    	lol.write(msg);
		    	data.get(username).add(msg);
		    }
		    else{
		    	data.put(username, new ArrayList<String>());
		    }
		  }

		  public static List<String> getUsers(){
			List<String> bob = new ArrayList<String>();
			bob.addAll(data.keySet());
		    return bob;
	//	    Returns a list of every username ALPHABETICALLY ORDERED
		  

		}
}
