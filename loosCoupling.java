// Java program to illustrate 
// loose coupling concept 
interface topp
{ 
	void understand(); 
} 
class topp1 implements topp { 
public void understand() 
	{ 
		System.out.println("Got it"); 
	} 
} class topp2 implements topp { 
public void understand() 
	{ 
		System.out.println("understand"); 
	} 
} public class loosCoupling { 
public static void main(String[] args) 
	{ 
		topp t = new topp2(); 
		t.understand(); 
	} 
} 
