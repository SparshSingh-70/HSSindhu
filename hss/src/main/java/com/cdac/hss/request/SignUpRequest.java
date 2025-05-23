package com.cdac.hss.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    private Integer userId; //09-05-2025 Changes done to import DB
    private String username;
    private String email;
    private String password;
    private String mobile;
    private String designation;
    private List<Integer> roleId;
    private List<Integer> domainId;

}
