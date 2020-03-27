package com.bta.myloto.domain;

public abstract class BaseEntenty {
    private Long id;

    public BaseEntenty(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
