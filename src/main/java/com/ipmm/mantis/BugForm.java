package com.ipmm.mantis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by elijah on 01.05.17.
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BugForm {
    String category;
    String reproducibility;
    String severity;
    String priority;
    String assign_to;
    String summary;
    String description;
    String steps_to_reproduce;
    String additional_info;
    String submitBtn;
    String platform;
    String os;
    String osVersion;
}
