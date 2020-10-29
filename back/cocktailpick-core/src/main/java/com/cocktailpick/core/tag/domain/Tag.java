package com.cocktailpick.core.tag.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.cocktailpick.core.common.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Tag extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_sequence_gen")
	@SequenceGenerator(
		name = "tag_sequence_gen",
		sequenceName = "tag_sequence"
	)
	private Long id;

	@Column(name = "name")
	private String name;

	@Enumerated(EnumType.STRING)
	private TagType tagType;

	@Builder
	private Tag(Long id, String name, TagType tagType) {
		this.id = id;
		this.name = name;
		this.tagType = tagType;
	}

	public boolean isSameName(Tag tag) {
		return this.name.equals(tag.name);
	}

	public void update(String updateName, TagType tagType) {
		this.name = updateName;
		this.tagType = tagType;
	}

	public String getTagType() {
		return tagType.getTagType();
	}
}
