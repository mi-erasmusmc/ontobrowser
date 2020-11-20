/* 

Copyright 2015 Novartis Institutes for Biomedical Research

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

*/
package com.novartis.pcs.ontology.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CTRLD_VOCAB_CONTEXT", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CTRLD_VOCAB_CONTEXT")})
@AttributeOverride(name = "id",
		column = @Column(name = "CTRLD_VOCAB_CONTEXT_ID", unique = true, nullable = false))
@NamedQuery(name = ControlledVocabularyContext.QUERY_BY_NAME,
        query = "select cvc from ControlledVocabularyContext as cvc where cvc.name = :name",
        hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})

public class ControlledVocabularyContext extends ModifiableEntity {
	private static final long serialVersionUID = 1L;

    public static final String QUERY_BY_NAME = "ControlledVocabularyContext.byName";


	@NotNull
	@Column(name = "CTRLD_VOCAB_CONTEXT", nullable = false)
	private String name;

	protected ControlledVocabularyContext() {

	}

	public ControlledVocabularyContext(String name,
			Curator creator) {
		super(creator);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
