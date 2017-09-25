package lehilima.zapmoveis_teste.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Lehiteixeira on 13/09/17.
 */

public class Util {
    private Context context;

    public Util(Context context) {
        this.context = context;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static String convertDate(String date){
        long unixSeconds = Long.parseLong(date.replace("/Date(","").replace(")/",""));
        Date dates = new Date(unixSeconds); // milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); //
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-4")); //
        String formattedDate =  "Atualizado em " + sdf.format(dates);
        return formattedDate;
    }

}
