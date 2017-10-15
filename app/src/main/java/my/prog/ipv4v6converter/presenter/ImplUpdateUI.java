package my.prog.ipv4v6converter.presenter;

import javax.inject.Inject;

import inet.ipaddr.IPAddressString;
import my.prog.ipv4v6converter.App;
import my.prog.ipv4v6converter.data.ImplIpOperations;
import my.prog.ipv4v6converter.other.ImplFunc;
import my.prog.ipv4v6converter.other.ImplPreference;
import my.prog.ipv4v6converter.view.ImplMainActivity;

/**
 * Created by Ruslan on 12.09.2017.
 */


public class ImplUpdateUI implements UpdateUI {

    @Inject ImplPreference preference;
    @Inject ImplFunc implFunc;

    private ImplMainActivity view = null;
    private IPAddressString strIP;


    private static final int IPV4_MAX_PROGRESS = 32;
    private static final int IPV6_MAX_PROGRESS = 128;

    @Inject
    ImplIpOperations data;

    public ImplUpdateUI() {
        App.getComponent().inject(this);
    }

    @Override
    public void setView(ImplMainActivity view) {
        this.view = view;
    }

    @Override
    public void setDataToActivity() {
        view.setTextToSubnetMask(data.getIP().getMask());
        view.setTextToBroadcost(data.getIP().getBroadcast());
        view.setTextToNetwork(data.getIP().getNetwork());
        view.setTextToFirtsIp(data.getIP().getFirst_host());
        view.setTextToLastIp(data.getIP().getLast_host());
        view.setTextToHosts(data.getIP().getHosts_count());
        view.setTextToMask(data.getIP().getMaskWithoutPrefics());
        view.setTextToIP(data.getIP().getIp());
    }



    @Override
    public boolean setMaxProgressToSeekBar(String ip) {
        strIP = new IPAddressString(ip);
        if (strIP.isIPv4()){
            view.setMaxProgresstoBar(IPV6_MAX_PROGRESS);
            return true;
        }else if(strIP.isIPv6()){
            view.setMaxProgresstoBar(IPV4_MAX_PROGRESS);
            return true;
        }else{
            return false;
        }

    }



    @Override
    public void setMinusSeekBar(int position) {
        if (position - 1 >= 0){
            view.setSeekBarPosition(position - 1);
        }
    }

    @Override
    public void setPlusSeekBar(int position, int max) {
        if (position + 1 <= max){
            view.setSeekBarPosition(position + 1);
        }
    }

    @Override
    public void setMaxSeekBar(int maxPosition) {
        preference.saveMaxSeekBar(maxPosition);
    }

    @Override
    public void getMaxSeekBar() {
        view.setMaxAndCurrentToSeekBar(preference.getMaxSeekBar(), preference.getMask());
    }

    @Override
    public void errorMaskTooBig() {
        view.showErrorMaskTooBig();
    }

    @Override
    public void showMessageClipboardCopy(String text) {
        implFunc.copyToClipboard(text);
        view.showMessageClipboardCopy(text);
    }

    @Override
    public void showWrongEnterIP() {
        view.showMessageWongEnterIP();
    }
}
