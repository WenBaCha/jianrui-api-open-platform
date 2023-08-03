package com.fh.project.model.dto.userinterfaceinfo;

import lombok.Data;

/**
 * @author fanhe
 **/
@Data
public class UserInterfaceInfoPayRequest {
    private String userAccount;
    private String interfaceName;
    private Integer times;
}
