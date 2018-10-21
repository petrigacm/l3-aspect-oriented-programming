package sk.stopangin.spring.introduction.aspect;

import java.util.Date;

public class LastModifiedImpl implements LastModified {
    private Date lastModified;

    @Override
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public Date getLastModified() {
        return lastModified;
    }
}
