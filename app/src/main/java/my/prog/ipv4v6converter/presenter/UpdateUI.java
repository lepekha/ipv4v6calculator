package my.prog.ipv4v6converter.presenter;

import my.prog.ipv4v6converter.view.ImplMainActivity;

/**
 * Created by Ruslan on 12.09.2017.
 */

public interface UpdateUI {
    void setDataToActivity();

    //UI
    void setView(ImplMainActivity view);
    boolean setMaxProgressToSeekBar(String ip);
    void setMinusSeekBar(int position);
    void setPlusSeekBar(int position, int max);
    void setMaxSeekBar(int maxPosition);
    void getMaxSeekBar();
    void errorMaskTooBig();
    void showMessageClipboardCopy(String text);
    void showWrongEnterIP();
}
