package com.overtow.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by cosborn on 12/29/18.
 */
public class PingResponse implements Serializable
{
    private String success = "true";

    @JsonProperty("success")
    public String getSuccess()
    {
        return success;
    }

    public void setSuccess(String success)
    {
        this.success = success;
    }
}
