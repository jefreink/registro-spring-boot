package com.h2.api.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "phones")
public class PhonesTokenModel {
	

	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                @Parameter(
                    name = "uuid_gen_strategy_class",
                    value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                )
            }
        )
    @Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	@Column(name = "number", nullable = false, length = 100)
	private String number;
	
	@Column(name = "citycode", nullable = false, length = 100)
	private String citycode;
	
	@Column(name = "countrycode", nullable = false, length = 100)
	private String countrycode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_users")
	private UsersTokenModel users;
	

}
