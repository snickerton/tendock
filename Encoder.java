import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Encoder{

  private File file;
  private List<String> messages;

  
  public Encoder(String filename) throws FileNotFoundException
  {
	  file = new File ("File.txt");
  }
  
  public void write (String message, String username)
  {
	  int shiftValue = 11;
	  List<String> use = read();
	  
	  String bar = "";
	  for (int i = 0; i < use.size(); i ++){
		  if (use.get(i).equals(username))
		  {
			  for (char c : message.toCharArray()) {
				     bar += Character.toString((char) (((c - 'a' + shiftValue) % 26) + 'a'));
				  }
		  }
		  else
		  {
			  for (char f: username.toCharArray())
			  {
				  bar += Character.toString((char) (((f - 'a' + shiftValue % 26) + 'a'))) + "\n" + ".";
			  }
			  
			  for (char c : message.toCharArray()) {
			     bar += Character.toString((char) (((c - 'a' + shiftValue) % 26) + 'a'));
			  }
		  }
		  
	  }
	  
	  try{
		   
			FileWriter fout = new FileWriter(file, true);
			fout.write(bar+ "\n");
			fout.close();
			
				 
		  	}catch(Exception ex){}
	  
	  System.out.println(bar);
  }
  
  public List<String> read()
  {
	messages = new ArrayList<String>();
	 
	 try{

         FileReader inputFile = new FileReader(file);
         BufferedReader bufferReader = new BufferedReader(inputFile);
         String line;
         while ((line = bufferReader.readLine()) != null)   {
           messages.add(line);
         }
         bufferReader.close();
      }catch(Exception e){
         System.out.println("Error while reading file line by line:" + e.getMessage());  
         e.printStackTrace();
      }
	 
	 for (int i = 0; i < messages.size(); i ++)
	 {
		 String n = "";
		 String name = messages.get(i);
		 if (name != ".")
		 {
			 for (char c : name.toCharArray()){
				 n += Character.toString((char) (((c - 'a' - 11) % 26) + 'a')) ;
			 }
		 }
		 else
		 {
			 n = name;
		 }
		 messages.set(i, n); 
		 System.out.println(messages.get(i));
	 }
	 
	 return messages;
  }
}
