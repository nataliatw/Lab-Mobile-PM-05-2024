package com.example.praktikumtigaapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Celebrity implements Parcelable {
    private String nama, caption, followers, following, postingan;
    private Integer imageprofil, imagefeed, imagestory;

    public Celebrity(String nama, String caption, String followers, String following, String postingan, Integer imageprofil, Integer imagefeed, Integer imagestory) {
        this.nama = nama;
        this.caption = caption;
        this.followers = followers;
        this.following = following;
        this.postingan = postingan;
        this.imageprofil = imageprofil;
        this.imagefeed = imagefeed;
        this.imagestory = imagestory;
    }

    protected Celebrity(Parcel in) {
        nama = in.readString();
        caption = in.readString();
        followers = in.readString();
        following = in.readString();
        postingan = in.readString();
        if (in.readByte() == 0) {
            imageprofil = null;
        } else {
            imageprofil = in.readInt();
        }
        if (in.readByte() == 0) {
            imagefeed = null;
        } else {
            imagefeed = in.readInt();
        }
        if (in.readByte() == 0) {
            imagestory = null;
        } else {
            imagestory = in.readInt();
        }
    }

    public static final Creator<Celebrity> CREATOR = new Creator<Celebrity>() {
        @Override
        public Celebrity createFromParcel(Parcel in) {
            return new Celebrity(in);
        }

        @Override
        public Celebrity[] newArray(int size) {
            return new Celebrity[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getPostingan() {
        return postingan;
    }

    public void setPostingan(String postingan) {
        this.postingan = postingan;
    }

    public Integer getImageprofil() {
        return imageprofil;
    }

    public void setImageprofil(Integer imageprofil) {
        this.imageprofil = imageprofil;
    }

    public Integer getImagefeed() {
        return imagefeed;
    }

    public void setImagefeed(Integer imagefeed) {
        this.imagefeed = imagefeed;
    }

    public Integer getImagestory() {
        return imagestory;
    }

    public void setImagestory(Integer imagestory) {
        this.imagestory = imagestory;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(caption);
        dest.writeString(followers);
        dest.writeString(following);
        dest.writeString(postingan);
        if (imageprofil == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imageprofil);
        }
        if (imagefeed == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imagefeed);
        }
        if (imagestory == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imagestory);
        }
    }
}
