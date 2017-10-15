package my.prog.ipv4v6converter.data;

import my.prog.ipv4v6converter.entity.IP;

/**
 * Created by Ruslan on 12.09.2017.
 */

public interface IpOperations {
    void calcIPv4(int prefics);
    void calcIPv6(int prefics);
    void calcMask(String ip, int prefics);
    String convertToIPv4(String ip);
    String convertToIPv6(String ip);
    IP getIP();
}
