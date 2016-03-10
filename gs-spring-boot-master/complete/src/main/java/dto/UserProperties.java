package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProperties {

	@JsonProperty("r_object_id")
	String r_object_id ;
	String user_name ;
	String user_os_name ;
	String dmadmin ;
	String user_group_name ;
	int user_privileges ;
	int owner_def_permit ;
	int world_def_permit ;
	int group_def_permit ;
	String default_folder ;
	boolean r_is_group ;
	
	@JsonProperty("user_db_name")
	String user_db_name ;
	String description ;
	String acl_domain ;
	
	@JsonProperty("acl_name")
	String acl_name ;
	String user_os_domain ;
	String home_docbase ;
	int user_state ;
	int client_capability ;
	boolean globally_managed ;
	//<r_modify_date>2014-03-03T00:32:38.000-08:00</r_modify_date>
	String user_delegation ;
	boolean workflow_disabled ;
	String alias_set_id ;
	String user_source ;
	String user_ldap_dn ;
	int user_xprivileges ;
	boolean r_has_events ;
	int failed_auth_attempt ;
	String user_admin ;
	String user_global_unique_id ;
	String user_login_name ;
	String user_login_domain ;
	String user_initials ;
	String user_web_page ;
	//<first_failed_auth_utc_time xsi:nil="true"/>
	//<last_login_utc_time>2014-03-02T23:13:07.000-08:00</last_login_utc_time>
	//<deactivated_utc_time xsi:nil="true"/>
	String deactivated_ip_addr ;
	//<restricted_folder_ids xsi:nil="true"/>
	String root_log_dir ;
	boolean i_is_replica ;
	int i_vstamp ;

	
	
	public String getR_object_id() {
		return r_object_id;
	}
	public void setR_object_id(String r_object_id) {
		this.r_object_id = r_object_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_os_name() {
		return user_os_name;
	}
	public void setUser_os_name(String user_os_name) {
		this.user_os_name = user_os_name;
	}
	public String getDmadmin() {
		return dmadmin;
	}
	public void setDmadmin(String dmadmin) {
		this.dmadmin = dmadmin;
	}
	public String getUser_group_name() {
		return user_group_name;
	}
	public void setUser_group_name(String user_group_name) {
		this.user_group_name = user_group_name;
	}
	public int getUser_privileges() {
		return user_privileges;
	}
	public void setUser_privileges(int user_privileges) {
		this.user_privileges = user_privileges;
	}
	public int getOwner_def_permit() {
		return owner_def_permit;
	}
	public void setOwner_def_permit(int owner_def_permit) {
		this.owner_def_permit = owner_def_permit;
	}
	public int getWorld_def_permit() {
		return world_def_permit;
	}
	public void setWorld_def_permit(int world_def_permit) {
		this.world_def_permit = world_def_permit;
	}
	public int getGroup_def_permit() {
		return group_def_permit;
	}
	public void setGroup_def_permit(int group_def_permit) {
		this.group_def_permit = group_def_permit;
	}
	public String getDefault_folder() {
		return default_folder;
	}
	public void setDefault_folder(String default_folder) {
		this.default_folder = default_folder;
	}
	public boolean isR_is_group() {
		return r_is_group;
	}
	public void setR_is_group(boolean r_is_group) {
		this.r_is_group = r_is_group;
	}
	public String getUser_db_name() {
		return user_db_name;
	}
	public void setUser_db_name(String user_db_name) {
		this.user_db_name = user_db_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAcl_domain() {
		return acl_domain;
	}
	public void setAcl_domain(String acl_domain) {
		this.acl_domain = acl_domain;
	}
	public String getAcl_name() {
		return acl_name;
	}
	public void setAcl_name(String acl_name) {
		this.acl_name = acl_name;
	}
	public String getUser_os_domain() {
		return user_os_domain;
	}
	public void setUser_os_domain(String user_os_domain) {
		this.user_os_domain = user_os_domain;
	}
	public String getHome_docbase() {
		return home_docbase;
	}
	public void setHome_docbase(String home_docbase) {
		this.home_docbase = home_docbase;
	}
	public int getUser_state() {
		return user_state;
	}
	public void setUser_state(int user_state) {
		this.user_state = user_state;
	}
	public int getClient_capability() {
		return client_capability;
	}
	public void setClient_capability(int client_capability) {
		this.client_capability = client_capability;
	}
	public boolean isGlobally_managed() {
		return globally_managed;
	}
	public void setGlobally_managed(boolean globally_managed) {
		this.globally_managed = globally_managed;
	}
	public String getUser_delegation() {
		return user_delegation;
	}
	public void setUser_delegation(String user_delegation) {
		this.user_delegation = user_delegation;
	}
	public boolean isWorkflow_disabled() {
		return workflow_disabled;
	}
	public void setWorkflow_disabled(boolean workflow_disabled) {
		this.workflow_disabled = workflow_disabled;
	}
	public String getAlias_set_id() {
		return alias_set_id;
	}
	public void setAlias_set_id(String alias_set_id) {
		this.alias_set_id = alias_set_id;
	}
	public String getUser_source() {
		return user_source;
	}
	public void setUser_source(String user_source) {
		this.user_source = user_source;
	}
	public String getUser_ldap_dn() {
		return user_ldap_dn;
	}
	public void setUser_ldap_dn(String user_ldap_dn) {
		this.user_ldap_dn = user_ldap_dn;
	}
	public int getUser_xprivileges() {
		return user_xprivileges;
	}
	public void setUser_xprivileges(int user_xprivileges) {
		this.user_xprivileges = user_xprivileges;
	}
	public boolean isR_has_events() {
		return r_has_events;
	}
	public void setR_has_events(boolean r_has_events) {
		this.r_has_events = r_has_events;
	}
	public int getFailed_auth_attempt() {
		return failed_auth_attempt;
	}
	public void setFailed_auth_attempt(int failed_auth_attempt) {
		this.failed_auth_attempt = failed_auth_attempt;
	}
	public String getUser_admin() {
		return user_admin;
	}
	public void setUser_admin(String user_admin) {
		this.user_admin = user_admin;
	}
	public String getUser_global_unique_id() {
		return user_global_unique_id;
	}
	public void setUser_global_unique_id(String user_global_unique_id) {
		this.user_global_unique_id = user_global_unique_id;
	}
	public String getUser_login_name() {
		return user_login_name;
	}
	public void setUser_login_name(String user_login_name) {
		this.user_login_name = user_login_name;
	}
	public String getUser_login_domain() {
		return user_login_domain;
	}
	public void setUser_login_domain(String user_login_domain) {
		this.user_login_domain = user_login_domain;
	}
	public String getUser_initials() {
		return user_initials;
	}
	public void setUser_initials(String user_initials) {
		this.user_initials = user_initials;
	}
	public String getUser_web_page() {
		return user_web_page;
	}
	public void setUser_web_page(String user_web_page) {
		this.user_web_page = user_web_page;
	}
	public String getDeactivated_ip_addr() {
		return deactivated_ip_addr;
	}
	public void setDeactivated_ip_addr(String deactivated_ip_addr) {
		this.deactivated_ip_addr = deactivated_ip_addr;
	}
	public String getRoot_log_dir() {
		return root_log_dir;
	}
	public void setRoot_log_dir(String root_log_dir) {
		this.root_log_dir = root_log_dir;
	}
	public boolean isI_is_replica() {
		return i_is_replica;
	}
	public void setI_is_replica(boolean i_is_replica) {
		this.i_is_replica = i_is_replica;
	}
	public int getI_vstamp() {
		return i_vstamp;
	}
	public void setI_vstamp(int i_vstamp) {
		this.i_vstamp = i_vstamp;
	}

	
	@Override
    public String toString() {
        return "Value{" + "db name =" + this.getUser_db_name() + ", acl name ='" + this.getAcl_name() + '\'' + '}';
    }
}