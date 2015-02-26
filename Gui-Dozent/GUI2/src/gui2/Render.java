package gui2;

public class Render implements Runnable
{

    private Bildschirmschoner schoner=new Bildschirmschoner();
    
    @Override
    public void run() 
    {
	while(true)
	{
	    schoner.render();
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    
	    
	}
	
    }

}
