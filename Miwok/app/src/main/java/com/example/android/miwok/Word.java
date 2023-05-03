package com.example.android.miwok;
public class Word {
    private  String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId=NO_IMAGE_PROVIDED;
    private int mAudioId;

    public int getmAudioId() {
        return mAudioId;
    }

    private static final int NO_IMAGE_PROVIDED=-1;
    public Word(String mDefaultTranslation, String mMiwokTranslation,int mAudioId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mAudioId=mAudioId;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceId,int mAudioId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioId=mAudioId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
