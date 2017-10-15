package my.prog.ipv4v6converter.other;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import my.prog.ipv4v6converter.App;

/**
 * Created by Ruslan on 24.09.2017.
 */

public class ImplFunc implements Func {

    private ClipboardManager clipboard;

    public ImplFunc(Context context) {
        App.getComponent().inject(this);
        clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
    }

    @Override
    public void copyToClipboard(String text) {
        ClipData clip = ClipData.newPlainText("", text);
        clipboard.setPrimaryClip(clip);
    }
}
