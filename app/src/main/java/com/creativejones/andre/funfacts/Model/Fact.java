package com.creativejones.andre.funfacts.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Fact implements Comparable, Parcelable {

    String mFact;

    public Fact(String fact) {
        mFact = fact;
    }

    public String getFact(){
        return mFact;
    }


    @Override
    public int compareTo(Object another) {
        Fact anotherFact = (Fact)another;

        if(anotherFact.getFact().equals(mFact)) {
            return 1;
        } else {
            return 0;
        }
    }

    private Fact(Parcel in){
        mFact = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFact);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Fact createFromParcel(Parcel in) {
            return new Fact(in);
        }

        public Fact[] newArray(int size) {
            return new Fact[size];
        }
    };
}
