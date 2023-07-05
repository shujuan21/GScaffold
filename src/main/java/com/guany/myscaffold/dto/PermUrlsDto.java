package com.guany.myscaffold.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 权限-url关联dto
 *
 * @Auther: guany
 * @Date: 2023/05/16
 */
public class PermUrlsDto {

    @NotBlank(message = "权限id不能为空")
    private String PermId;

    @NotEmpty(message = "关联url不能为空")
    private List<String> urlList;

    public PermUrlsDto() {
    }

    public PermUrlsDto(String permId, List<String> urlList) {
        PermId = permId;
        this.urlList = urlList;
    }

    public String getPermId() {
        return PermId;
    }

    public void setPermId(String permId) {
        PermId = permId;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }
}
