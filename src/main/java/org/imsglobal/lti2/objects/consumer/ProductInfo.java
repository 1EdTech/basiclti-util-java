
package org.imsglobal.lti2.objects.consumer;

import org.imsglobal.lti2.LTI2Config;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.imsglobal.lti2.objects.BaseJson;

@JsonPropertyOrder({
    "product_name",
    "product_version",
    "description",
    "technical_description",
    "product_family"
})
public class ProductInfo extends BaseJson {

    private ProductName product_name;
    private String product_version;
    private Description description;
    private TechnicalDescription technical_description;
    private ProductFamily product_family;

    public ProductInfo(LTI2Config cnf) {
        this.product_name = new ProductName(cnf.getProduct_info_product_name());
        this.product_version = cnf.getProduct_info_product_version();
        this.description = new Description(cnf.getProduct_info_product_description());
        this.product_family = new ProductFamily(cnf);
    }
    
    public ProductInfo(){
        
    }

    public ProductName getProduct_name() {
        return product_name;
    }

    public void setProduct_name(ProductName product_name) {
        this.product_name = product_name;
    }

    public String getProduct_version() {
        return product_version;
    }

    public void setProduct_version(String product_version) {
        this.product_version = product_version;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public TechnicalDescription getTechnical_description() {
        return technical_description;
    }

    public void setTechnical_description(TechnicalDescription technical_description) {
        this.technical_description = technical_description;
    }

    public ProductFamily getProduct_family() {
        return product_family;
    }

    public void setProduct_family(ProductFamily product_family) {
        this.product_family = product_family;
    }
    
}
