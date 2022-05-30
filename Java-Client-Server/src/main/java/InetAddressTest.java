import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

class InetAddressTest {
    public static void main(String args[])
            throws UnknownHostException {
        InetAddress Address = InetAddress.getLocalHost();
        System.out.println("Local host: " + Address);
        Address = InetAddress.getByName("www.yandex.ru");
        System.out.println(Address);
        InetAddress SW[] = InetAddress.getAllByName("www.yandex.ru");
        System.out.println(Arrays.toString(SW));
        System.out.println("Get Host Name: " + Address.getHostName());
        System.out.println("is Multicast Address: " + Address.isMulticastAddress());

    }
}