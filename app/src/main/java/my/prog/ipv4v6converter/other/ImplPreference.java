package my.prog.ipv4v6converter.other;

import android.content.Context;
import android.content.SharedPreferences;

import my.prog.ipv4v6converter.App;

/**
 * Created by Ruslan on 20.09.2017.
 */



public class ImplPreference implements Preference {

    private static final String APP_PREFERENCES = "ipv4v6preference";
    private static final String APP_PREFERENCES_IP = "IP";
    private static final String APP_PREFERENCES_MASK = "Mask";
    private static final String APP_PREFERENCES_SEEK_BAR = "SeekBar";
    private static final String APP_PREFERENCES_STANDART_IP = "192.168.0.1";
    private static final int IPV4_MAX_PROGRESS = 32;
    private static final int DEFAULT_MASK = 1;

    private SharedPreferences mSettings;

    public ImplPreference(Context context) {
        App.getComponent().inject(this);
        mSettings = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public void saveIP(String ip) {
        mSettings.edit().putString(APP_PREFERENCES_IP, ip).apply();
    }

    @Override
    public void saveMask(int prefics) {
        mSettings.edit().putInt(APP_PREFERENCES_MASK, prefics).apply();
    }

    @Override
    public String getIP() {
         return mSettings.getString(APP_PREFERENCES_IP, APP_PREFERENCES_STANDART_IP);
    }

    @Override
    public int getMask() {
        return mSettings.getInt(APP_PREFERENCES_MASK, DEFAULT_MASK);
    }

    @Override
    public void saveMaxSeekBar(int maxPosition) {
        mSettings.edit().putInt(APP_PREFERENCES_SEEK_BAR, maxPosition).apply();
    }

    @Override
    public int getMaxSeekBar() {
        return mSettings.getInt(APP_PREFERENCES_SEEK_BAR, IPV4_MAX_PROGRESS);
    }
}

