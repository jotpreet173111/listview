package com.example.listviewmidterm;

import android.os.Parcel;
import android.os.Parcelable;

public class Read implements Parcelable {
    private String name;


    private  String login;

    public Read(String name, String login, String branchUrl, String treeUrl) {
        this.name = name;
        this.login = login;
        this.branchUrl = branchUrl;
        this.treeUrl = treeUrl;
    }

    private String branchUrl;
    private String treeUrl;

    protected Read(Parcel in) {
        name = in.readString();
        login = in.readString();
        branchUrl = in.readString();
        treeUrl = in.readString();
    }

    public static final Creator<Read> CREATOR = new Creator<Read>() {
        @Override
        public Read createFromParcel(Parcel in) {
            return new Read(in);
        }

        @Override
        public Read[] newArray(int size) {
            return new Read[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getBranchUrl() {
        return branchUrl;
    }

    public void setBranchUrl(String branchUrl) {
        this.branchUrl = branchUrl;
    }

    public String getTreeUrl() {
        return treeUrl;
    }

    public void setTreeUrl(String treeUrl) {
        this.treeUrl = treeUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(login);
        dest.writeString(branchUrl);
        dest.writeString(treeUrl);
    }
}
