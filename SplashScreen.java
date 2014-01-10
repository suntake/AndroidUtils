package com.epoch.app;

import com.epoch.app.login.Login_screen;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.WindowManager;

public class SplashScreen extends Activity {
	private SharedPreferences settings;
	private SharedPreferences.Editor editor;
	public static final String PREFS_NAME = "EPOCH_pref";
	// stopping splash screen starting home activity.
	private static final int STOPSPLASH = 0;
	// time duration in millisecond for which your splash screen should visible
	// to
	// user. here i have taken half second
	private static final long SPLASHTIME = 1000;

	// handler for splash screen
	private Handler splashHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case STOPSPLASH:
				// Generating and Starting new intent on splash time out
				settings = getSharedPreferences(PREFS_NAME, 0);
				String PatientId = settings.getString("PatientId", null);
				Log.v("SPLASH_SCREEN", "PatientId::" + PatientId);

				if (PatientId == null) {
					Intent intent = new Intent(getApplicationContext(),
							Login_screen.class);
					startActivity(intent);
				} else {

					Intent intent = new Intent(getApplicationContext(),
							HomeScreen_menu.class);
					startActivity(intent);
				}
				overridePendingTransition(R.anim.in_animation,
						R.anim.out_animation);
				SplashScreen.this.finish(); // Updated (Thanks to Jerimiah)
				break;
			}
			super.handleMessage(msg);
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		Log.v("", "+--------------------------------------+");
		Log.v("", "Splash_Screen");
		Log.v("", "+--------------------------------------+");

		WindowManager mWinMgr = (WindowManager) getApplicationContext()
				.getSystemService(getApplicationContext().WINDOW_SERVICE);

		// Generating message and sending it to splash handle
		Message msg = new Message();
		msg.what = STOPSPLASH;
		splashHandler.sendMessageDelayed(msg, SPLASHTIME);
	}
}
