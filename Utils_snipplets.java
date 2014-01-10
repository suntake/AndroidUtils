  Utils 
  
  
//*************************************************************************************
  make an activity full screen? I mean without the notification bar.
  
      requestWindowFeature(Window.FEATURE_NO_TITLE);
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
						WindowManager.LayoutParams.FLAG_FULLSCREEN);
				
	OR using XML
	
	<activity android:name=".ActivityName"
	          android:label="@string/app_name"
	          android:theme="@android:style/Theme.NoTitleBar.Fullscreen">
	</activity>
				
//*************************************************************************************				
  
  Android Splash Screen Using Timer
  
  
  in oncreate use below snipplet

  new Handler().postDelayed(new Runnable() {
 
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT); // splash_time_out must be int 



//*************************************************************************************






//*************************************************************************************
