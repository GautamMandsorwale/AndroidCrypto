package com.example.crypto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Home extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button mDecryptBtn = (Button) findViewById(R.id.decryptBtnId);
        Button mEncryptBtn = (Button) findViewById(R.id.encryptBtnId);

        final EditText mEncryptEditTxtId = (EditText) findViewById(R.id.encryptEditTxtId);
        final EditText mDecryptEditTxtId = (EditText) findViewById(R.id.decryptEditTxtId);


        mEncryptBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    MD5Test md = new MD5Test();
                    String mEncryptEditTxtStr = mEncryptEditTxtId.getText().toString().trim();
//					String mEncryptedStr = md.md5("q4m'x68n6_YDB4ty8VC4&}wqBtn^68W");
                    Crypto mCrypto = new Crypto();
                    String mEncryptedStr = Crypto.byteArrayToHexString(mCrypto.encrypt(mEncryptEditTxtStr));
//                    String mEncryptedStr = Crypto.byteArrayToHexString(mCrypto.encrypt("asfaesdf237263923902;/.�;./>23y283g2k3nre�D;ASdsn;fnddffk"));
                    mDecryptEditTxtId.setText(mEncryptedStr);
//			     mEncryptEditTxtId.setText("");
                } catch (Exception e) {
                    String s = null;
                }
            }
        });


        mDecryptBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    Crypto mCrypto = new Crypto();
                    String mDecrptyEditTxtstr = mDecryptEditTxtId.getText().toString().trim();
                    String mDecryptedStr = new String(mCrypto.decrypt(mDecrptyEditTxtstr));
                    mEncryptEditTxtId.setText(mDecryptedStr);
                    mDecryptEditTxtId.setText("");
                } catch (Exception e) {
                    String s = null;
                }
            }
        });


    }

}
