package abpl.android.com.abpl.utils.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UploadModel {

@SerializedName("status")
@Expose
private Boolean status;
@SerializedName("msg")
@Expose
private String msg;
@SerializedName("file_url")
@Expose
private String fileUrl;

public Boolean getStatus() {
return status;
}

public void setStatus(Boolean status) {
this.status = status;
}

public String getMsg() {
return msg;
}

public void setMsg(String msg) {
this.msg = msg;
}

public String getFileUrl() {
return fileUrl;
}

public void setFileUrl(String fileUrl) {
this.fileUrl = fileUrl;
}

}