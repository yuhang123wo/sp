package com.yh.st.base.domain;

/**
 *
 * This class was generated by MyBatis Generator. This class corresponds to the
 * database table user_role
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class UserRole extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6390388477237581665L;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column user_role.user_id
	 *
	 * @mbggenerated
	 */
	private Long userId;

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column user_role.role_id
	 *
	 * @mbggenerated
	 */
	private Integer roleId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column user_role.user_id
	 *
	 * @return the value of user_role.user_id
	 *
	 * @mbggenerated
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column user_role.user_id
	 *
	 * @param userId
	 *            the value for user_role.user_id
	 *
	 * @mbggenerated
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column user_role.role_id
	 *
	 * @return the value of user_role.role_id
	 *
	 * @mbggenerated
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column user_role.role_id
	 *
	 * @param roleId
	 *            the value for user_role.role_id
	 *
	 * @mbggenerated
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}