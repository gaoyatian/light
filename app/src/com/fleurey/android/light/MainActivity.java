package com.fleurey.android.light;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.fleurey.android.light.backgroundmanager.LightService;
import com.fleurey.android.light.flashmanager.FlashManager;

public class MainActivity extends Activity {

	private ImageButton mImageButton;
	private boolean on = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		if (!mFlashManager.isFlashAvailable()) {
//			finish();
//		}
		mImageButton = (ImageButton) findViewById(R.id.button);
		mImageButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleStatus();
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
	}

	private void toggleStatus() {
		if (on) {
			stopService(new Intent(getApplicationContext(), LightService.class));
			mImageButton.setBackgroundResource(R.drawable.background_off);
			on = false;
		} else {
			startService(new Intent(getApplicationContext(), LightService.class));
			mImageButton.setBackgroundResource(R.drawable.background_on);
			on = true;
		}
	}
}