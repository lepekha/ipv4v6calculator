package my.prog.ipv4v6converter.data;


import java.math.BigInteger;
import javax.inject.Inject;
import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressString;
import my.prog.ipv4v6converter.App;
import my.prog.ipv4v6converter.entity.IP;

/**
 * Created by Ruslan on 12.09.2017.
 */

public class ImplIpOperations implements IpOperations {

    private IPAddress address;
    private IPAddress maskWithPrefixLength;
    private IPAddress mask;
    private IPAddress subnet;

    private BigInteger number = new BigInteger("2");

    @Inject  IP ipAddress;


    public ImplIpOperations() {
        App.getComponent().inject(this);
    }


    @Override
    public void calcMask(String ip, int prefics) {
        address = new IPAddressString(ip).getAddress();
        maskWithPrefixLength = new IPAddressString("/" + prefics).getAddress(address.getIPVersion());
        mask = address.getNetwork().getNetworkMask(prefics, false);
        subnet = address.toSubnet(prefics);
    }

    @Override
    public void calcIPv4(int prefics) {
        ipAddress.setIp(address.toString());
        ipAddress.setMask(maskWithPrefixLength.toString());
        ipAddress.setBroadcast(subnet.getHighest().toString());
        ipAddress.setNetwork(subnet.toSubnet(mask).toString());
        ipAddress.setMaskWithoutPrefics(address.getNetwork().getNetworkMask(prefics, false).toString());
        if (prefics > 30){
            ipAddress.setHosts_count("0");
            ipAddress.setFirst_host("N/A");
            ipAddress.setLast_host("N/A");
        }else{
            ipAddress.setHosts_count(String.valueOf(subnet.getCount().subtract(number)));
            ipAddress.setFirst_host(subnet.getLowest().getSegment(0)+"."+subnet.getLowest().getSegment(1)+"."+subnet.getLowest().getSegment(2)+"."+(Integer.valueOf(subnet.getLowest().getSegment(3).toString())+1));
            ipAddress.setLast_host(subnet.getHighest().getSegment(0)+"."+subnet.getHighest().getSegment(1)+"."+subnet.getHighest().getSegment(2)+"."+(Integer.valueOf(subnet.getHighest().getSegment(3).toString())-1));
        }
    }

    @Override
    public void calcIPv6(int prefics) {
        ipAddress.setIp(address.toCompressedString());
        ipAddress.setMask(maskWithPrefixLength.toString());
        ipAddress.setHosts_count(String.valueOf(subnet.getCount()));
        ipAddress.setMaskWithoutPrefics(address.getNetwork().getNetworkMask(prefics, false).toCompressedString());
        ipAddress.setFirst_host(subnet.getLowest().toCompressedString());
        ipAddress.setLast_host(subnet.getHighest().toCompressedString());
        ipAddress.setBroadcast("N/A");
        ipAddress.setNetwork(subnet.toSubnet(mask).toCompressedString());
    }


    @Override
    public String convertToIPv4(String ip) {
        address = new IPAddressString(ip).getAddress().toIPv4();
        return address.toString();
    }

    @Override
    public String convertToIPv6(String ip) {
        address = new IPAddressString(ip).getAddress().toIPv6();
        return address.toString();
    }

    @Override
    public IP getIP() {
        return this.ipAddress;
    }

}
