package com.example.contextualcards.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class CtaUtils {
    public static void openUrl(String url, Context context) {
        try{
            if (url != null && !url.isEmpty()) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(browserIntent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Invalid URL", Toast.LENGTH_SHORT).show();
        }
    }
}
