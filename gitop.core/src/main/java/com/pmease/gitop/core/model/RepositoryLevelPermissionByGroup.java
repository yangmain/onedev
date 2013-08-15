package com.pmease.gitop.core.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.FetchMode;

import com.pmease.commons.persistence.AbstractEntity;

@SuppressWarnings("serial")
@Entity
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames={"who", "what"})
})
@org.hibernate.annotations.Cache(
		usage=org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class RepositoryLevelPermissionByGroup extends AbstractEntity {

	@ManyToOne(fetch=FetchType.EAGER)
	@org.hibernate.annotations.Fetch(FetchMode.SELECT)
	@JoinColumn(nullable=false)
	private Group who;	

	@ManyToOne(fetch=FetchType.EAGER)
	@org.hibernate.annotations.Fetch(FetchMode.SELECT)
	@JoinColumn(nullable=false)
	private Repository what;
	
	public Group getWho() {
		return who;
	}

	public void setWho(Group who) {
		this.who = who;
	}
	
	public Repository getWhat() {
		return what;
	}

	public void setWhat(Repository what) {
		this.what = what;
	}

}
