package MySocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Set;

public class MySocket {

public String GetLocalHost()
{
	try{
	InetAddress netAddress = InetAddress.getLocalHost();
	return netAddress.getHostAddress();
	}
	catch(UnknownHostException e)
	{
		return "Unkown host";
	}
}
	
public static void main(String[] args) {
	// TODO Auto-generated method stub
	MySocket mySock = new MySocket(); 
	String host = mySock.GetLocalHost();
	System.out.println("host name:" + host);
}

}
