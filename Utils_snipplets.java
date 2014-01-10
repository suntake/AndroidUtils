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
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
 
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);



//*************************************************************************************






//*************************************************************************************
