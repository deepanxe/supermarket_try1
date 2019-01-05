package super_market.supermarket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AreaDetailList {
    @SerializedName("area_details")
    @Expose
    private List<AreaDetail> areaDetails = null;

    public List<AreaDetail> getAreaDetails() {
        return areaDetails;
    }

    public void setAreaDetails(List<AreaDetail> areaDetails) {
        this.areaDetails = areaDetails;
    }
}
