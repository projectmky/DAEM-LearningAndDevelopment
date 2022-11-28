package gr.athtech.daem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TYPES_OF_COURSES")
@SequenceGenerator(name = "idGenerator", allocationSize = 1)
public class TypeOfCourse extends BaseModel {

	@Column(length = 50, nullable = false)
	@NotEmpty
	@NotNull
	private String name;

	@Column(length = 50, nullable = false)
	@NotEmpty
	@NotNull
	private String description;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "type")
	private List<Course> courses;
}