package sk.stopangin.spring.l3.examples.auditable;

import java.util.Date;

public interface Modifiable {
    Date getLastModifiedDate();

    void setLastModifiedDate(Date lastModifiedDate);
}
