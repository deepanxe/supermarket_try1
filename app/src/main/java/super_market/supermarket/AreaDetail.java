package super_market.supermarket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AreaDetail {

    @SerializedName("area_id")
    @Expose
    private Integer areaId;
    @SerializedName("area_name")
    @Expose
    private String areaName;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
