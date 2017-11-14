package org.imsglobal.lti.launch;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by paul on 5/28/14.
 */
public class LtiLaunch {

    // Required
    private String version;
    private String messageType;
    private String resourceLinkId;

    // Recommended
    private LtiUser user;
    private String contextId;
    private String launchPresentationReturnUrl;
    private String launchPresentationDocumentTarget;
    private String launchPresentationWidth;
    private String launchPresentationHeight;
    private String toolConsumerInstanceGuid;
    
    // Optional
    private String contextType;
    private String launchPresentationLocale;
    private String launchPresentationCssUrl;
    private String roleScopeMentor;
    private String userImage;
    private Map<String, String> custom;
    private Map<String, String> ext;
    
    // Deprecated parameters
	private String lis_result_sourcedid;
	private String lis_outcome_service_url;


    public LtiLaunch(HttpServletRequest request) {
        
        this.version = request.getParameter("lti_version");
        this.messageType = request.getParameter("lti_message_type");
        this.resourceLinkId = request.getParameter("resource_link_id");
        
        this.user = new LtiUser(request);
        this.contextId = request.getParameter("context_id");
        this.launchPresentationReturnUrl = request.getParameter("launch_presentation_return_url");
        this.launchPresentationDocumentTarget = request.getParameter("launch_presentation_document_target");
        this.launchPresentationWidth = request.getParameter("launch_presentation_width");
        this.launchPresentationHeight = request.getParameter("launch_presentation_height");
        this.toolConsumerInstanceGuid = request.getParameter("tool_consumer_instance_guid");
        
        this.contextType = request.getParameter("context_type");
        this.launchPresentationLocale = request.getParameter("launch_presentation_locale");
        this.launchPresentationCssUrl = request.getParameter("launch_presentation_css_url");
        this.roleScopeMentor = request.getParameter("role_scope_mentor");
        this.userImage = request.getParameter("user_image");
        
        this.lis_result_sourcedid = request.getParameter("lis_result_sourcedid");
        this.lis_outcome_service_url = request.getParameter("lis_outcome_service_url");
        
        Map<String, String[]> allRequestParameters = request.getParameterMap();
        if (allRequestParameters != null && !allRequestParameters.isEmpty()) {
        	Set<String> keys = allRequestParameters.keySet();
        	for (String key : keys) {
        		if (key != null) {
        			if (key.startsWith("custom_")) {
        				if (this.custom == null) {
        					this.custom = new TreeMap<String, String>();
        				}
        				
        				String [] values = allRequestParameters.get(key);
        				if (values != null) {
        					if (values.length > 1) {
        						this.custom.put(key, stringArrayToCommaDelimitedString(values));
        					}
        					else {
        						this.custom.put(key, values[0]);
        					}
        				}
        			}
        			else if (key.startsWith("ext_")) {
        				if (this.ext == null) {
        					this.ext = new TreeMap<String, String>();
        				}
        				
        				String [] values = allRequestParameters.get(key);
        				if (values != null) {
        					if (values.length > 1) {
        						this.ext.put(key, stringArrayToCommaDelimitedString(values));
        					}
        					else {
        						this.ext.put(key, values[0]);
        					}
        				}
        			}
        		}
        	}
        }

    }

    public LtiLaunch(Map<String, String> parameters) {
        
        this.version = parameters.get("lti_version");
        this.messageType = parameters.get("lti_message_type");
        this.resourceLinkId = parameters.get("resource_link_id");
        
        this.user = new LtiUser(parameters);
        this.contextId = parameters.get("context_id");
        this.launchPresentationReturnUrl = parameters.get("launch_presentation_return_url");
        this.launchPresentationDocumentTarget = parameters.get("launch_presentation_document_target");
        this.launchPresentationWidth = parameters.get("launch_presentation_width");
        this.launchPresentationHeight = parameters.get("launch_presentation_height");
        this.toolConsumerInstanceGuid = parameters.get("tool_consumer_instance_guid");
        
        this.contextType = parameters.get("context_type");
        this.launchPresentationLocale = parameters.get("launch_presentation_locale");
        this.launchPresentationCssUrl = parameters.get("launch_presentation_css_url");
        this.roleScopeMentor = parameters.get("role_scope_mentor");
        this.userImage = parameters.get("user_image");
        
        this.lis_result_sourcedid = parameters.get("lis_result_sourcedid");
        this.lis_outcome_service_url = parameters.get("lis_outcome_service_url");
        
    	Set<String> keys = parameters.keySet();
    	for (String key : keys) {
    		if (key != null) {
    			if (key.startsWith("custom_")) {
    				if (this.custom == null) {
    					this.custom = new TreeMap<String, String>();
    				}
    				
    				String value = parameters.get(key);
    				this.custom.put(key, value);
    			}
    			else if (key.startsWith("ext_")) {
    				if (this.ext == null) {
    					this.ext = new TreeMap<String, String>();
    				}
    				
    				String value = parameters.get(key);
    				this.custom.put(key, value);
    			}
    		}
    	}
    }

    public LtiUser getUser() {
        return user;
    }

    public void setUser(LtiUser user) {
        this.user = user;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getResourceLinkId() {
        return resourceLinkId;
    }

    public void setResourceLinkId(String resourceLinkId) {
        this.resourceLinkId = resourceLinkId;
    }

    public String getContextId() {
        return contextId;
    }

    public void setContextId(String contextId) {
        this.contextId = contextId;
    }

    public String getLaunchPresentationReturnUrl() {
        return launchPresentationReturnUrl;
    }

    public void setLaunchPresentationReturnUrl(String launchPresentationReturnUrl) {
        this.launchPresentationReturnUrl = launchPresentationReturnUrl;
    }

    public String getLaunchPresentationDocumentTarget() {
		return launchPresentationDocumentTarget;
	}

	public void setLaunchPresentationDocumentTarget(
			String launchPresentationDocumentTarget) {
		this.launchPresentationDocumentTarget = launchPresentationDocumentTarget;
	}

	public String getLaunchPresentationWidth() {
		return launchPresentationWidth;
	}

	public void setLaunchPresentationWidth(String launchPresentationWidth) {
		this.launchPresentationWidth = launchPresentationWidth;
	}

	public String getLaunchPresentationHeight() {
		return launchPresentationHeight;
	}

	public void setLaunchPresentationHeight(String launchPresentationHeight) {
		this.launchPresentationHeight = launchPresentationHeight;
	}

	public String getToolConsumerInstanceGuid() {
        return toolConsumerInstanceGuid;
    }

    public void setToolConsumerInstanceGuid(String toolConsumerInstanceGuid) {
        this.toolConsumerInstanceGuid = toolConsumerInstanceGuid;
    }

	public String getContextType() {
		return contextType;
	}

	public void setContextType(String contextType) {
		this.contextType = contextType;
	}

	public String getLaunchPresentationLocale() {
		return launchPresentationLocale;
	}

	public void setLaunchPresentationLocale(String launchPresentationLocale) {
		this.launchPresentationLocale = launchPresentationLocale;
	}

	public String getLaunchPresentationCssUrl() {
		return launchPresentationCssUrl;
	}

	public void setLaunchPresentationCssUrl(String launchPresentationCssUrl) {
		this.launchPresentationCssUrl = launchPresentationCssUrl;
	}

	public String getRoleScopeMentor() {
		return roleScopeMentor;
	}

	public void setRoleScopeMentor(String roleScopeMentor) {
		this.roleScopeMentor = roleScopeMentor;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public Map<String, String> getCustom() {
		return custom;
	}

	public void setCustom(Map<String, String> custom) {
		this.custom = custom;
	}

	public Map<String, String> getExt() {
		return ext;
	}

	public void setExt(Map<String, String> ext) {
		this.ext = ext;
	}
	
	public String getLis_result_sourcedid() {
		return lis_result_sourcedid;
	}

	public void setLis_result_sourcedid(String lis_result_sourcedid) {
		this.lis_result_sourcedid = lis_result_sourcedid;
	}

	public String getLis_outcome_service_url() {
		return lis_outcome_service_url;
	}

	public void setLis_outcome_service_url(String lis_outcome_service_url) {
		this.lis_outcome_service_url = lis_outcome_service_url;
	}
	
	private String stringArrayToCommaDelimitedString(String [] values) {
		
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			stringBuilder.append(values[i]);
			if (i < values.length - 1) {
				stringBuilder.append(",");
			}
		}

		return stringBuilder.toString();
	}
}
