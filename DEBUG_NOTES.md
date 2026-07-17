------------------------------------------------------------
Error #001
------------------------------------------------------------

Date:
17-Jul-2026

Topic:
Hibernate One-to-One Mapping

Error Message:
org.hibernate.AnnotationException:
Property 'Question.answer' is a '@OneToOne' association and may not use '@Column'

Cause:
Used @Column on a @OneToOne relationship.

Solution:
Changed:
@Column(name = "answer_id")

To:
@JoinColumn(name = "answer_id")

Learning:
Use @JoinColumn for entity relationships (@OneToOne, @ManyToOne). Use @Column only for basic data types like String, int, double, etc.

Status:
✅ Resolved
------------------------------------------------------------
Error #002
------------------------------------------------------------

Date:
17-Jul-2026

Topic:
Hibernate Entity Lifecycle

Error Message:
org.hibernate.TransientPropertyValueException:
Persistent instance of 'Question' references an unsaved transient instance of 'Answer'

Cause:
Attempted to persist a Question entity that referenced an Answer entity which had not been saved.

Solution:
Either:
1. Persist the Answer entity before persisting Question.
OR
2. Add cascade:
@OneToOne(cascade = CascadeType.ALL)

Learning:
Hibernate cannot persist an entity that references another entity in the transient (unsaved) state unless the referenced entity is saved first or cascade persistence is enabled.

Status:
✅ Resolved
------------------------------------------------------------
Error #003
------------------------------------------------------------

Date:
17-Jul-2026

Topic:
Hibernate One-to-Many Mapping (@OneToMany)

Error Message:
org.hibernate.exception.ConstraintViolationException:
Cannot add or update a child row: a foreign key constraint fails

Cause:
In a unidirectional One-to-Many mapping, the `@JoinColumn` annotation was missing. Hibernate incorrectly mapped the relationship by using `employee_id` as the foreign key instead of creating a separate `department_id` foreign key column in the Employee table.

Incorrect Mapping:

@OneToMany(cascade = CascadeType.ALL)
private List<Employee> employees;

Generated Foreign Key (Incorrect):

FOREIGN KEY (employee_id)
REFERENCES Department(department_id)

Solution:
Added the `@JoinColumn` annotation to explicitly specify the foreign key column.

Correct Mapping:

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "department_id")
private List<Employee> employees;

Generated Foreign Key (Correct):

FOREIGN KEY (department_id)
REFERENCES Department(department_id)

Learning:
- In a unidirectional `@OneToMany` relationship, Hibernate needs `@JoinColumn` to know where to store the foreign key.
- The foreign key is stored in the child table (`Employee`), not the parent table (`Department`).
- Without `@JoinColumn`, Hibernate may generate an incorrect mapping or create an unnecessary join table depending on the mapping and Hibernate version.

Interview Insight:
Question:
Why is the foreign key `department_id` and not `employee_id`?

Answer:
`employee_id` is the primary key of the Employee table. A foreign key should store the primary key of the referenced (parent) entity. Since many employees belong to one department, each Employee row stores the `department_id` as a foreign key referencing `Department.department_id`.

Status:
✅ Resolved
