package abpl.android.com.abpl.adapter;

/**
 * Created by purnendu on 21-01-2017.
 */

public class ModelAdapter {
    String mImageUrl,mItemTitle,mItemDescription,mItemSubDescription;

    public ModelAdapter(String mImageUrl, String mItemTitle, String mItemDescription, String mItemSubDescription) {
        this.mImageUrl = mImageUrl;
        this.mItemTitle = mItemTitle;
        this.mItemDescription = mItemDescription;
        this.mItemSubDescription = mItemSubDescription;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmItemSubDescription() {
        return mItemSubDescription;
    }

    public void setmItemSubDescription(String mItemSubDescription) {
        this.mItemSubDescription = mItemSubDescription;
    }

    public String getmItemDescription() {
        return mItemDescription;
    }

    public void setmItemDescription(String mItemDescription) {
        this.mItemDescription = mItemDescription;
    }

    public String getmItemTitle() {
        return mItemTitle;
    }

    public void setmItemTitle(String mItemTitle) {
        this.mItemTitle = mItemTitle;
    }
}
