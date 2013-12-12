package com.beardedhen.androidbootstraptest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.FontAwesomeText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get access to some FontAwesomeText items in the layout
        final FontAwesomeText tv1 = (FontAwesomeText) findViewById(R.id.lblOne);
        FontAwesomeText tv2 = (FontAwesomeText) findViewById(R.id.lblTwo);
        FontAwesomeText tv3 = (FontAwesomeText) findViewById(R.id.lblThree);

        BootstrapButton b = (BootstrapButton) findViewById(R.id.btnInfoTest);
        b.setRightIcon("fa-thumbs-o-up");
        b.setLeftIcon("fa-thumbs-o-up");
        b.setText("Hello");

        //flashing forever FAST
        tv1.startFlashing(this, true, FontAwesomeText.AnimationSpeed.FAST);

        //rotating clockwise slowly
        tv2.startRotate(this, true, FontAwesomeText.AnimationSpeed.SLOW);

        //rotating anti-clockwise at medium speed
        tv3.startRotate(this, false, FontAwesomeText.AnimationSpeed.MEDIUM);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
