package com.example.codex.model.bo;

import java.util.Date;

public class DeviceMaster {

    private Long iddevice;
    private UserMaster idUser;
    private Date createdDate;
    private String deviceId;

    public Long getIddevice() {
        return iddevice;
    }

    public void setIddevice(Long iddevice) {
        this.iddevice = iddevice;
    }

    public UserMaster getIdUser() {
        return idUser;
    }

    public void setIdUser(UserMaster idUser) {
        this.idUser = idUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
