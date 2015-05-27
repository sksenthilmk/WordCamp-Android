package org.wordcamp.utils;

import org.wordcamp.objects.WordCampDB;
import org.wordcamp.objects.speaker.Session;
import org.wordcamp.objects.wordcamp.PostMetum;
import org.wordcamp.objects.wordcamp.WordCampNew;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by aagam on 29/1/15.
 */
public class WordCampUtils {

    public static String getProperDate(WordCampDB wdb) {

        if (!wdb.getWc_end_date().isEmpty()) {
            Date d = new Date(Long.parseLong(wdb.getWc_start_date()) * 1000);
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd", Locale.getDefault());
            Date d1 = new Date(Long.parseLong(wdb.getWc_end_date()) * 1000);
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd, yyyy", Locale.getDefault());
            return sdf.format(d) + " - " + sdf1.format(d1);
        } else {
            Date d = new Date(Long.parseLong(wdb.getWc_start_date()) * 1000);
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
            return sdf.format(d);
        }

    }

    public static String getProperFormatDate(String s) {

        Date d1 = new Date(Long.parseLong(s) * 1000);

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd, MMM yyyy", Locale.getDefault());

        return sdf1.format(d1);
    }

    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String formatProperTime(int time) {
        Date d = new Date((long) time * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int minutes = 5 * (Math.round(calendar.get(Calendar.MINUTE) / 5));
        if (minutes == 60) {
            minutes = 0;
            calendar.set(Calendar.HOUR, (calendar.get(Calendar.HOUR) + 1));
        }
        calendar.set(Calendar.MINUTE, minutes);
        d = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, HH:mm", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(d);
    }

    public static int findFirstUpcomingFrag(List<WordCampDB> wcdb) {
        int counter = -1;
        if (wcdb != null) {
            long lowestDiff = Integer.MAX_VALUE;
            long now = System.currentTimeMillis();

            for (int i = 0; i < wcdb.size(); i++) {
                long startDate = Long.parseLong(wcdb.get(i).getWc_start_date()) * 1000;
                long diffDate = (startDate - now) / (1000 * 60 * 60 * 24);
                if (diffDate >= -1 && diffDate < lowestDiff) {
                    lowestDiff = diffDate;
                    counter = i;
                }
            }
        }
        return counter;
    }

    public static int formatProperTimeHash(int time) {
        Date d = new Date((long) time * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int minutes = 5 * (Math.round(calendar.get(Calendar.MINUTE) / 5));
        if (minutes == 60) {
            minutes = 0;
            calendar.set(Calendar.HOUR, (calendar.get(Calendar.HOUR) + 1));
        }
        calendar.set(Calendar.MINUTE, minutes);
        d = calendar.getTime();

        return d.hashCode();
    }


    public static HashMap<String, String> getTwitterAndUrl(WordCampNew wcn) {
        List<PostMetum> meta = wcn.getPostMeta();

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < meta.size(); i++) {
            PostMetum metum = meta.get(i);
            map.put(metum.getKey(), metum.getValue());
        }

        return map;
    }

    public static HashMap<String, String> getTimeAndTypeSession(Session ss) {
        List<org.wordcamp.objects.speaker.PostMetum> meta = ss.getPostMeta();

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < meta.size(); i++) {
            org.wordcamp.objects.speaker.PostMetum metum = meta.get(i);
            map.put(metum.getKey(), metum.getValue());
        }

        return map;
    }


}
