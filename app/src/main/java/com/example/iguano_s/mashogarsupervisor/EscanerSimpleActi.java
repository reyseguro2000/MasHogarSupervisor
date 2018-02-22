package com.example.iguano_s.mashogarsupervisor;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

/**
 * Created by IGUANO-S on 22/06/2017.
 */

public class EscanerSimpleActi extends Activity implements ZBarScannerView.ResultHandler {
    private ZBarScannerView mScannerView;
    public static final String TAG = "ScannerActivity";
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);    // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }



    @Override
    public void handleResult(Result result) {
        final String TAG=result.getContents();
        final Intent data=new Intent();
        data.putExtra("codigo",TAG);
        setResult(Activity.RESULT_OK,data);
       /* try {
            Uri notificacion= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(),notificacion);
            r.play();
        }catch (Exception e) {
            Log.e(TAG, result.getContents());
        }
        // / return result.getContents();
        /*
        try {
            Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }*/
    }

}
