package org.wordcamp.objects;

/**
 * Created by aagam on 28/1/15.
 */
public class SpeakerDB {

    public int wc_id;
    public String name;
    public int speaker_id;
    public int post_id;
    public String info;
    public String featured_image;
    public String last_scanned_gmt;
    public String gson_object;

    public SpeakerDB(int wc_id, String name, int speaker_id, int post_id, String info, String featured_image, String last_scanned_gmt, String gson_object) {
        this.wc_id = wc_id;
        this.name = name;
        this.speaker_id = speaker_id;
        this.post_id = post_id;
        this.info = info;
        this.featured_image = featured_image;
        this.last_scanned_gmt = last_scanned_gmt;
        this.gson_object = gson_object;
    }

    public int getWc_id() {
        return wc_id;
    }

    public void setWc_id(int wc_id) {
        this.wc_id = wc_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(int speaker_id) {
        this.speaker_id = speaker_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public void setFeatured_image(String featured_image) {
        this.featured_image = featured_image;
    }

    public String getLast_scanned_gmt() {
        return last_scanned_gmt;
    }

    public void setLast_scanned_gmt(String last_scanned_gmt) {
        this.last_scanned_gmt = last_scanned_gmt;
    }

    public String getGson_object() {
        return gson_object;
    }

    public void setGson_object(String gson_object) {
        this.gson_object = gson_object;
    }
}
