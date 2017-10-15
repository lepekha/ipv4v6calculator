package my.prog.ipv4v6converter.view;

/**
 * Created by Ruslan on 12.09.2017.
 */

public interface MainActivity extends View {
    void setTextToSubnetMask(String subnetMask);
    void setTextToBroadcost(String broadcost);
    void setTextToNetwork(String network);
    void setTextToFirtsIp(String firstIp);
    void setTextToLastIp(String lastIp);
    void setTextToHosts(String hosts);
    void setTextToIP(String ip);
    void setTextToMask(String mask);
    void setMaxProgresstoBar(int maxProgress);
    void setSeekBarPosition(int position);
    void setMaxAndCurrentToSeekBar(int maxPosition, int currentPosition);
    void showErrorMaskTooBig();
    void showMessageClipboardCopy(String text);
    void showMessageWongEnterIP();

}
