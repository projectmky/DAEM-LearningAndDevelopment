package gr.athtech.daem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@SequenceGenerator(name = "idGenerator", allocationSize = 1)
public class Authority extends BaseModel {

	@Column(nullable = false, unique = true)
	@NotNull
	@NotEmpty
	private String name;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private TypeOfInstitution awardingBody;

	@JsonIgnore
	@OneToMany(mappedBy = "certificationAuthority")
	private List<Certification> certifications = new ArrayList<>();
}
