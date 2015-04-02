# Tendock


## Noelle & David - Encoder
### Documentation
```java
public Encoder(String filename){
  Makes an object that can read and write encoded text from a file.
}

public void write(String plaintext){
  Writes encoded message. 
  Encryption method:
  <David insert documentation>
  what am i suppose to insert here
  
}

public List<String> read(){
  Returns a list of each (line? word?) <Noelle insert documentation> UNENCODED
}
```


##Kavya - Front End
### Documentation
```java
 <Kavya insert anything you find necessary for us to know>
```

##Tony - Team Leader & Backend
### Documentation
```java
	public Map<String, List<String>> data;	
	data = new TreeMap<String, List<String>>();

  public List<String> getMessage(String username){
    return data.get(username);
    
    Returns a list of every message under the username
  }
  
  public void addMessage(String username, String msg){
    data.put(username, msg);
  }
  
  public List<String> getUsers(){
    return data.keySet().toArray();
    Returns a list of every username ALPHABETICALLY ORDERED
  }
  
  
```
