package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.utils.ImageUtils;

public class BootstrapCircleThumbnail extends FrameLayout
{
    private static final int DEFAULT_IMAGE_WIDTH = 400;//px
    private static final int DEFAULT_IMAGE_HEIGHT = 400;//px

    private ViewGroup container;
    private LinearLayout placeholder;
    private ImageView image;
    private TextView dimensionsLabel;

    public BootstrapCircleThumbnail(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    public BootstrapCircleThumbnail(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapCircleThumbnail(Context context)
    {
        super(context);
        initialise(null);
    }

    private void initialise( AttributeSet attrs )
    {
        LayoutInflater inflator = (LayoutInflater)getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);


        TypedArray a = getContext().obtainStyledAttributes(attrs,
                R.styleable.BootstrapCircleThumbnail);

        String text = "";
        int imageDrawable = 0;

        if(a.getString(R.styleable.BootstrapCircleThumbnail_bct_image) != null)
        {
            imageDrawable = a.getResourceId(R.styleable.BootstrapCircleThumbnail_bct_image, 0);

        }

        if(a.getString(R.styleable.BootstrapCircleThumbnail_android_text) != null)
        {
            text = a.getString(R.styleable.BootstrapCircleThumbnail_android_text);
        }

        View v = inflator.inflate(R.layout.thumbnail_circle, null, false);
        dimensionsLabel = (TextView) v.findViewById(R.id.dimensionsLabel);
        container = (ViewGroup) v.findViewById(R.id.container);
        placeholder = (LinearLayout) v.findViewById(R.id.placeholder);
        image = (ImageView) v.findViewById(R.id.image);
        float scale = getResources().getDisplayMetrics().density;

        //if no image is given
        if(imageDrawable == 0)
        {
            placeholder.setLayoutParams(new LinearLayout.LayoutParams(DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT));

            //set placeholder image
            placeholder.setBackgroundResource(R.drawable.thumbnail_circle);

            this.dimensionsLabel.setVisibility(View.VISIBLE);
            this.dimensionsLabel.setText(text);

        }
        else
        {
            placeholder.setPadding(0, 0, 0, 0);
            Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), imageDrawable);
            Bitmap roundBitmap = ImageUtils.getCircleBitmap(bitmap);
            image.setImageBitmap(roundBitmap);

        }

        //Bitmap scaledBitmap = ImageUtils.decodeSampledBitmapFromResource(getResources(), R.drawable.test, 300, 300);

        container.setBackgroundResource(R.drawable.thumbnail_circle_container);

        this.addView(v);
    }
}
