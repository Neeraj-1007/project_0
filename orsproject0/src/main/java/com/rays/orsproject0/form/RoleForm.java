package com.rays.orsproject0.form;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.rays.orsproject0.dto.BaseDTO;
import com.rays.orsproject0.dto.RoleDTO;
import com.rays.orsproject0.util.Util;

public class RoleForm extends BaseForm {

	@NotEmpty
	private String roleName;

	@NotEmpty
	private String roleDescription;



	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	@Override
	public BaseDTO getDto() {
		// TODO Auto-generated method stub

		RoleDTO dto = new RoleDTO();

		dto.setId(id);
		dto.setRoleName(roleName);
		dto.setRoleDescription(roleDescription);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub

		if (bDto == null) {
			return;
		}
		RoleDTO dto = (RoleDTO) bDto;
		id = dto.getId();
		roleName = dto.getRoleName();
		roleDescription = dto.getRoleDescription();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		if (dto.getCreatedDatetime() != null)
			createdDatetime = dto.getCreatedDatetime().getTime();
		if (dto.getModifiedDatetime() != null)
			modifiedDatetime = dto.getModifiedDatetime().getTime();
		
	
	}

}
