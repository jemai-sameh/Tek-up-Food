package com.tekup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private Long id ;
    @CreatedDate
   @Column(name = "creationDate"  , nullable = false ,updatable = false)
  private Instant creationDate;
    @LastModifiedDate
    @Column(name = "lastModifiedDate" )
    private Instant lastModifiedDate;
    @PrePersist
    private void persistId() {
        if (this.creationDate == null) {
            this.creationDate = new Date().toInstant();

        }
        this.lastModifiedDate = new Date().toInstant();

    }
}