
package org.imsglobal.lti2.objects;

import org.imsglobal.lti2.LTI2Config;

import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
    "guid",
    "product_info",
    "support"
})
public class ProductInstance {

    private String guid;
    private Product_info product_info;
    private Service_owner service_owner;
    private Service_provider service_provider;
    private Support support;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ProductInstance(LTI2Config cnf) {
        this.guid = cnf.getGuid();
        this.product_info = new Product_info(cnf);
        this.service_owner = new Service_owner(cnf);
        this.service_provider = new Service_provider(cnf);
        this.support = new Support(cnf.getSupport_email());
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Product_info getProduct_info() {
        return product_info;
    }

    public void setProduct_info(Product_info product_info) {
        this.product_info = product_info;
    }

    public Service_owner getService_owner() {
        return service_owner;
    }

    public void setService_owner(Service_owner service_owner) {
        this.service_owner = service_owner;
    }

    public Service_provider getService_provider() {
        return service_provider;
    }

    public void setService_provider(Service_provider service_provider) {
        this.service_provider = service_provider;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    @com.fasterxml.jackson.annotation.JsonAnyGetter
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    
    @com.fasterxml.jackson.annotation.JsonAnySetter
    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
