package my.prog.ipv4v6converter.other;

/**
 * Created by Ruslan on 20.09.2017.
 */

public interface Preference {
    void saveIP(String ip);
    void saveMask(int prefics);
    String getIP();
    int getMask();
    void saveMaxSeekBar(int maxPosition);
    int getMaxSeekBar();
}
