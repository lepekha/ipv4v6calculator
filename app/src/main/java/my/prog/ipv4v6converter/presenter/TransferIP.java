package my.prog.ipv4v6converter.presenter;

/**
 * Created by Ruslan on 20.09.2017.
 */

public interface TransferIP {
    void convertToIPv4(String ip, int prefics);
    void convertToIPv6(String ip, int prefics);
    void seekBarListener(String ip, int i);
    void btnClickDone(String ip, int i);
    void saveIpAndMask(String ip, int i);
    void recoverIpAndMask();
    void calcIP(String ip, int prefics);
}
