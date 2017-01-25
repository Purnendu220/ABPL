package abpl.android.com.abpl.utils;


public class ServiceConstants {

    public static final String REVIEW_URL_GOOGLE = "market://details?id=abpl.android.com.abp";
    public static int mProgramListPage = 0;
    public static int mMyWorkoutProgramListPage = 0;
    public static int mMyWorkoutGalleryPage = 0;
    public static int mMyWorkoutProgramGalleryPage = 0;
    public static int mFeedsPage = 0;
    public static int mCommentsPage = 0;
    public static int mLikesPage = 0;
    public static int mNotificationsPage = 0;
    public static int NOTIFICATION_ID = 100;
    public static boolean mHideEditButtonOnDestroy = true;


    public interface GeneralConstants
    {
        String IMAGE_STORE ="Image Capture";
        int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
        int RESULT_LOAD_IMAGE = 101;
    }

    public interface ServiceURL {

        String REGISTER="register.php";
        //String UPLOAD="upload_file.php";
        String UPLOAD="uploadimage";


    }

    public interface WebConstants {


        String BASE_URL_CONSTANT="http://cardamom-live.mobikasa.net/api/v1/";
        //String BASE_URL_CONSTANT="https://propitious-leather.000webhostapp.com/";//"http://app.getadue.com/api/v1/users/";//
        String FILE_URL="https://propitious-leather.000webhostapp.com/uploads/";
        int NETWORK_ERROR = 10000;
        int FAILED_ERROR = 10001;
        String INVALID_RESPONSE_MESSAGE = "Invalid reposne from server. Please try again later.";
        String NETWORK_MESSAGE = "Could not establish connection. Please check network settings or contact your mobile operator.";

        int CONNECTIONTIMEOUT = 30 * 1000;
        int READTIMEOUT = 30 * 1000;

    }




}
