
package com.example.sebas.flickr.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Description implements Parcelable {

    @SerializedName("_content")
    @Expose
    private String content;

    /**
     * 
     * @return
     *     The content
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The _content
     */
    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.content);
    }

    public Description() {
    }

    protected Description(Parcel in) {
        this.content = in.readString();
    }

    public static final Creator<Description> CREATOR = new Creator<Description>() {
        public Description createFromParcel(Parcel source) {
            return new Description(source);
        }

        public Description[] newArray(int size) {
            return new Description[size];
        }
    };
}
