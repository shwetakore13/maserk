package com.maersk;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Size;

public class Container {

    public enum containerType {DIY,REEFER};
    @Value("20")
    //@Value("40")
    private Integer containerSize ;
    @Size(min = 5, max = 200)
    private String origin;
    @Size(min = 5, max = 200)
    private String destination;
    @Size(min = 1, max = 100)
    private Integer quantity;

    public Container(){}

    public Container(Container.containerType containerType,Integer containerSize, @Size(min = 5, max = 200) String origin, @Size(min = 5, max = 200) String destination, @Size(min = 1, max = 100) Integer quantity) {
        this.containerSize = containerSize;
        this.origin = origin;
        this.destination = destination;
        this.quantity = quantity;
    }

    public Integer getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(Integer containerSize) {
        this.containerSize = containerSize;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
