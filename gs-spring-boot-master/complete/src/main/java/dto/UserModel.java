package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {

	@JsonProperty("properties")
	UserProperties userprop ;

	public UserProperties getUserprop() {
		return userprop;
	}

	public void setUserprop(UserProperties userprop) {
		this.userprop = userprop;
	}
}
