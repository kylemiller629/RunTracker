package edu.matc.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("postalCodes")
	private List<PostalCodesItem> postalCodes;

	public void setPostalCodes(List<PostalCodesItem> postalCodes){
		this.postalCodes = postalCodes;
	}

	public List<PostalCodesItem> getPostalCodes(){
		return postalCodes;
	}
}