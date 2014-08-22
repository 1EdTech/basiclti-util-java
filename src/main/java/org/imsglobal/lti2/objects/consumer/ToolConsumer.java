package org.imsglobal.lti2.objects.consumer;

import org.imsglobal.lti2.LTI2Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.imsglobal.lti2.objects.BaseJson;

@JsonPropertyOrder({
    "@context",
    "@type",
    "@id"
})
@com.fasterxml.jackson.annotation.JsonPropertyOrder({
    "@context",
    "@type",
    "@id"
})
public class ToolConsumer extends BaseJson {

    @JsonProperty("@context")
    @com.fasterxml.jackson.annotation.JsonProperty("@context")
    private Object _context;
    @JsonProperty("@type")
    @com.fasterxml.jackson.annotation.JsonProperty("@type")
    private String _type;
    @JsonProperty("@id")
    @com.fasterxml.jackson.annotation.JsonProperty("@id")
    private String _id;
    private String lti_version;
    private String guid;
    private ProductInstance product_instance;
    private List<String> capability_offered = new ArrayList<String>();
    private List<ServiceOffered> service_offered = new ArrayList<ServiceOffered>();

    public static final class LtiCapability {
        public static final String BASICLTI_LAUNCH = "basic-lti-launch-request";
        public static final String USER_ID = "User.id";
        public static final String USER_IMAGE = "User.image";
        public static final String COURSE_SECTION_ID = "CourseSection.sourcedId";
        public static final String PERSON_ID = "Person.sourcedId";
        public static final String MEMBERSHIP_ROLE = "Membership.role";
    }

    public static String TYPE = "ToolConsumerProfile";
    public static String TC_PROFILE_CONTEXT = "http://purl.imsglobal.org/ctx/lti/v2/ToolConsumerProfile";

    public ToolConsumer(){}

    // Constructor
    public ToolConsumer(String guid, String ltiVersion, String tcp, LTI2Config cnf) {
        this._context = TC_PROFILE_CONTEXT;
        this._type = TYPE;
        this.lti_version = ltiVersion; // "LTI-2p0";
        this.guid = guid;
        this.product_instance = new ProductInstance(cnf);
    }

    public Object get_context() {
        return _context;
    }

    public void set_context(List<Object> _context) {
        this._context = _context;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getLti_version() {
        return lti_version;
    }

    public void setLti_version(String lti_version) {
        this.lti_version = lti_version;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public ProductInstance getProduct_instance() {
        return product_instance;
    }

    public void setProduct_instance(ProductInstance product_instance) {
        this.product_instance = product_instance;
    }

    public List<String> getCapability_offered() {
        return capability_offered;
    }

    public void setCapability_offered(List<String> capability_offered) {
        this.capability_offered = capability_offered;
    }

    public List<ServiceOffered> getService_offered() {
        return service_offered;
    }

    public void setService_offered(List<ServiceOffered> service_offered) {
        this.service_offered = service_offered;
    }

    // Convienence method
    public void addCapabilites(List<String> capabilities) {
        this.capability_offered.addAll(capabilities);
    }
    
    public void addServiceOffered(ServiceOffered service) {
        this.service_offered.add(service);
    }
    
    public void addAllServiceOffered(List<ServiceOffered> service) {
        this.service_offered.addAll(service);
    }

}
