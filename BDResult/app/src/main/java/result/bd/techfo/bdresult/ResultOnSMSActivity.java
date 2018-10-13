package result.bd.techfo.bdresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class ResultOnSMSActivity extends AppCompatActivity {

    AdView mAdView;
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_on_sms);

        mAdView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });
    }

    public void btnSSC(View view) {
        Intent intent = new Intent(ResultOnSMSActivity.this,SSCActivity.class);
        startActivity(intent);
    }

    public void btnHSC(View view) {
        Intent intent = new Intent(ResultOnSMSActivity.this,HSCActivity.class);
        startActivity(intent);
    }

    public void btnJSC(View view) {
        Intent intent = new Intent(ResultOnSMSActivity.this,JSCActivity.class);
        startActivity(intent);
    }

    public void btnJDC(View view) {
        Intent intent = new Intent(ResultOnSMSActivity.this,JDCActivity.class);
        startActivity(intent);
    }

    public void btnPSC(View view) {
        Intent intent = new Intent(ResultOnSMSActivity.this,PSCActivity.class);
        startActivity(intent);
    }

    public void btnMadrasa(View view) {
        Intent intent = new Intent(ResultOnSMSActivity.this,MADRASAActivity.class);
        startActivity(intent);
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
