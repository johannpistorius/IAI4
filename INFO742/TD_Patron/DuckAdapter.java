
public class DuckAdapter {
	// You need to implement the interface your client expects to use.
    Character c;
    public DuckAdapter(Character c) 
    { 
        // we need reference to the object we are adapting 
        this.c = c; 
    } 
  
    public void combat() 
    { 
        // translate the methods appropriately 
        c.fight(); 
    } 
}
