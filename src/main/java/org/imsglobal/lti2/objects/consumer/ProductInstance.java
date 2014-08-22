
package org.imsglobal.lti2.objects.consumer;

import org.imsglobal.lti2.LTI2Config;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.imsglobal.lti2.objects.BaseJson;

@JsonPropertyOrder({
    "guid",
    "product_info",
    "support"
})
public class ProductInstance extends BaseJson {

    private String guid;
    private ProductInfo product_info;
    private ServiceOwner service_owner;
    private ServiceProvider service_provider;
    private Support support;

    public ProductInstance(LTI2Config cnf) {
        this.guid = cnf.getGuid();
        this.product_info = new ProductInfo(cnf);
        this.service_owner = new ServiceOwner(cnf);
        this.service_provider = new ServiceProvider(cnf);
        this.support = new Support(cnf.getSupport_email());
    }
    
    public ProductInstance() {
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public ProductInfo getProduct_info() {
        return product_info;
    }

    public void setProduct_info(ProductInfo product_info) {
        this.product_info = product_info;
    }

    public ServiceOwner getService_owner() {
        return service_owner;
    }

    public void setService_owner(ServiceOwner service_owner) {
        this.service_owner = service_owner;
    }

    public ServiceProvider getService_provider() {
        return service_provider;
    }

    public void setService_provider(ServiceProvider service_provider) {
        this.service_provider = service_provider;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

}
