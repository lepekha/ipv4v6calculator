package my.prog.ipv4v6converter.entity;


/**
 * Created by Ruslan on 09.09.2017.
 */

public class IP {
    private String ip;
    private String mask;
    private String broadcast;
    private String network;
    private String first_host;
    private String last_host;
    private String hosts_count;
    private String maskWithoutPrefics;

    public IP(String ip, String mask, String broadcast, String network, String first_host, String last_host, String hosts_count, String maskWithoutPrefics) {
        this.ip = ip;
        this.mask = mask;
        this.broadcast = broadcast;
        this.network = network;
        this.first_host = first_host;
        this.last_host = last_host;
        this.hosts_count = hosts_count;
        this.maskWithoutPrefics = maskWithoutPrefics;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getFirst_host() {
        return first_host;
    }

    public void setFirst_host(String first_host) {
        this.first_host = first_host;
    }

    public String getLast_host() {
        return last_host;
    }

    public void setLast_host(String last_host) {
        this.last_host = last_host;
    }

    public String getHosts_count() {
        return hosts_count;
    }

    public void setHosts_count(String hosts_count) {
        this.hosts_count = hosts_count;
    }

    public String getMaskWithoutPrefics() {
        return maskWithoutPrefics;
    }

    public void setMaskWithoutPrefics(String maskWithoutPrefics) {
        this.maskWithoutPrefics = maskWithoutPrefics;
    }

    @Override
    public String toString() {
        return "IP{" +
                "ip='" + ip + '\'' +
                ", mask='" + mask + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", network='" + network + '\'' +
                ", first_host='" + first_host + '\'' +
                ", last_host='" + last_host + '\'' +
                ", hosts_count='" + hosts_count + '\'' +
                '}';
    }
}
