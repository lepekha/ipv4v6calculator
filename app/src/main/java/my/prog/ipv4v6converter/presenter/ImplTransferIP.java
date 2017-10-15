package my.prog.ipv4v6converter.presenter;

import javax.inject.Inject;

import inet.ipaddr.IPAddressString;
import my.prog.ipv4v6converter.App;
import my.prog.ipv4v6converter.data.ImplIpOperations;
import my.prog.ipv4v6converter.other.ImplPreference;

/**
 * Created by Ruslan on 20.09.2017.
 */

public class ImplTransferIP implements TransferIP {

    private IPAddressString strIP;

    @Inject ImplUpdateUI implUpdateUI;
    @Inject ImplIpOperations data;
    @Inject ImplPreference preference;

    private static final int IPV4_MAX_PROGRESS = 32;

    public ImplTransferIP() {
        App.getComponent().inject(this);
    }

    @Override
    public void convertToIPv4(String ip, int prefics) {
        strIP = new IPAddressString(ip);
        if (strIP.isIPv6()) {
            if (prefics <= IPV4_MAX_PROGRESS) {
                implUpdateUI.setMaxProgressToSeekBar(ip);
                calcIP(data.convertToIPv4(ip), prefics);
                implUpdateUI.setDataToActivity();
            }else {
                implUpdateUI.errorMaskTooBig();
            }
        }else{
            implUpdateUI.showWrongEnterIP();
        }
    }

    @Override
    public void convertToIPv6(String ip, int prefics) {
        strIP = new IPAddressString(ip);
        if (strIP.isIPv4()) {
            if (prefics <= IPV4_MAX_PROGRESS) {
                implUpdateUI.setMaxProgressToSeekBar(ip);
                calcIP(data.convertToIPv6(ip), prefics);
                implUpdateUI.setDataToActivity();
            }
        }else{
            implUpdateUI.showWrongEnterIP();
        }
    }

    @Override
    public void btnClickDone(String ip, int i) {
        calcIP(ip,i);
        implUpdateUI.setDataToActivity();
    }

    @Override
    public void seekBarListener(String ip, int i) {
        calcIP(ip,i);
        implUpdateUI.setDataToActivity();
    }

    @Override
    public void saveIpAndMask(String ip, int i) {
        preference.saveIP(ip);
        preference.saveMask(i);
    }

    @Override
    public void recoverIpAndMask() {
        calcIP(preference.getIP(),preference.getMask());
        implUpdateUI.setDataToActivity();
    }

    @Override
    public void calcIP(String ip, int prefics) {
        strIP = new IPAddressString(ip);
        if (strIP.isIPv4()) {
            data.calcMask(ip, prefics);
            data.calcIPv4(prefics);
        } else if (strIP.isIPv6()) {
            data.calcMask(ip, prefics);
            data.calcIPv6(prefics);
        } else {
            implUpdateUI.showWrongEnterIP();
        }
    }
}
