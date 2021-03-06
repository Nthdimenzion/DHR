package com.patientadmission.master.dto;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.patientadmission.domain.AdmittingDepartment;
import com.patientadmission.domain.User;
import com.patientadmission.presentation.queries.PatientAdmissionFinder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2/12/2015.
 */
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNumber;
    private String gender;
    private Set<Map<String, ?>> selectedDepartments = Sets.newHashSet();
    private String selectedRole;
    private String password;
    private String userName;

    public String getSelectedRole() {
        if (selectedRole != null){
            return selectedRole.substring(1,selectedRole.length()-1);
        }
        return null;
    }

    public void setDetailsToEntity(User user) {
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setEmailId(this.emailId);
        user.setContactNumber(this.phoneNumber);
        user.setGender(this.gender);
    }
    public void setDepartmentsAssignedToHim(Set<AdmittingDepartment> departmentSet) {
        Set<Map<String,?>> departments = Sets.newHashSet();
        for(AdmittingDepartment department :departmentSet){
            Map<String, String> map = Maps.newLinkedHashMap();
            map.put("id",department.getId().toString());
            map.put("departmentName",department.getDepartmentName());
            departments.add(map);
        }
        this.selectedDepartments = departments;
    }
}
