package my.prog.ipv4v6converter.view;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import my.prog.ipv4v6converter.App;
import my.prog.ipv4v6converter.R;
import my.prog.ipv4v6converter.entity.IP;
import my.prog.ipv4v6converter.presenter.ImplTransferIP;
import my.prog.ipv4v6converter.presenter.ImplUpdateUI;

public class ImplMainActivity extends AppCompatActivity implements MainActivity {

    @Inject
    ImplUpdateUI presenterUpdateUI;

    @Inject
    ImplTransferIP presenterTransferIP;

    @Inject
    IP ip;

    @BindString(R.string.message_mask_error) String ERROR_MASK_TOO_BIG;
    @BindString(R.string.message_clipboard_copy) String MESSAGE_CLIPBOARD_COPY;
    @BindString(R.string.message_wrong_enter_ip) String MESSAGE_WRONG_ENTER_IP;

    @BindView(R.id.constraintLayout)
    ConstraintLayout constraintLayout;

    @BindView(R.id.edtIP)
    EditText edtIP;

    @BindView(R.id.seeBarSubnetMask)
    SeekBar seeBarSubnetMask;

    @BindView(R.id.txtIP)
    TextView txtIP;

    @BindView(R.id.txtMask)
    TextView txtMask;

    @BindView(R.id.txtBroadcast)
    TextView txtBroadcast;

    @BindView(R.id.txtNameBroadcast)
    TextView txtNameBroadcast;

    @BindView(R.id.txtFirstIP)
    TextView txtFirstIP;

    @BindView(R.id.txtHosts)
    TextView txtHosts;

    @BindView(R.id.txtLastIP)
    TextView txtLastIP;

    @BindView(R.id.txtNework)
    TextView txtNework;

    @BindView(R.id.txtSubnetMask)
    TextView txtSubnetMask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
       // getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        ButterKnife.bind(this);
        App.getComponent().inject(this);
        presenterUpdateUI.setView(this);
        presenterUpdateUI.getMaxSeekBar();
        presenterTransferIP.recoverIpAndMask();//восстановление сохраненных ип и маски
        seeBarSubnetMask.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                presenterTransferIP.seekBarListener(edtIP.getText().toString(),i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @OnClick(R.id.btnDone)
    public void btnDone(){
        presenterTransferIP.btnClickDone(edtIP.getText().toString(), seeBarSubnetMask.getProgress());
    }

    @OnClick(R.id.btnMinusMask)
    public void btnPlusMask() {
        presenterUpdateUI.setMinusSeekBar(seeBarSubnetMask.getProgress());
    }

    @OnClick(R.id.btnPlusMask)
    public void btnMinusMask() {
        presenterUpdateUI.setPlusSeekBar(seeBarSubnetMask.getProgress(), seeBarSubnetMask.getMax());
    }

    @OnClick({ R.id.txtIP, R.id.txtBroadcast, R.id.txtMask, R.id.txtNework, R.id.txtSubnetMask, R.id.txtFirstIP, R.id.txtLastIP, R.id.txtHosts })
    public void pickTxtData(TextView ipText) {
       presenterUpdateUI.showMessageClipboardCopy(ipText.getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.ipv4:
                presenterTransferIP.convertToIPv4(edtIP.getText().toString(),seeBarSubnetMask.getProgress());
                break;
            case R.id.ipv6:
                presenterTransferIP.convertToIPv6(edtIP.getText().toString(),seeBarSubnetMask.getProgress());
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setMaxProgresstoBar(int maxProgress) {
        seeBarSubnetMask.setMax(maxProgress);
    }

    @Override
    public void setTextToBroadcost(String broadcost) {
        txtBroadcast.setText(broadcost);
    }

    @Override
    public void setTextToNetwork(String network) {
        txtNework.setText(network);
    }

    @Override
    public void setTextToFirtsIp(String firstIp) {
        txtFirstIP.setText(firstIp);
    }

    @Override
    public void setTextToLastIp(String lastIp) {
        txtLastIP.setText(lastIp);
    }

    @Override
    public void setTextToHosts(String hosts) {
        txtHosts.setText(hosts);
    }

    @Override
    public void setTextToSubnetMask(String subnetMask) {
        txtSubnetMask.setText(subnetMask);
    }

    @Override
    public void setTextToIP(String ip) {
        edtIP.setText(ip);
        txtIP.setText(ip);
    }

    @Override
    public void setTextToMask(String mask) {
        txtMask.setText(mask);
    }

    @Override
    public void showMessage(String text) {
        Snackbar.make(constraintLayout,text, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setSeekBarPosition(int position) {
        seeBarSubnetMask.setProgress(position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterUpdateUI.setMaxSeekBar(seeBarSubnetMask.getMax());
        presenterTransferIP.saveIpAndMask(edtIP.getText().toString(), seeBarSubnetMask.getProgress());
    }


    @Override
    public void setMaxAndCurrentToSeekBar(int maxPosition, int currentPosition) {
        seeBarSubnetMask.setMax(maxPosition);
        seeBarSubnetMask.setProgress(currentPosition);
    }

    @Override
    public void showErrorMaskTooBig() {
        showMessage(ERROR_MASK_TOO_BIG);
    }

    @Override
    public void showMessageClipboardCopy(String text) {
        showMessage(text + " " + MESSAGE_CLIPBOARD_COPY);
    }

    @Override
    public void showMessageWongEnterIP() {
        showMessage(MESSAGE_WRONG_ENTER_IP);
    }
}
