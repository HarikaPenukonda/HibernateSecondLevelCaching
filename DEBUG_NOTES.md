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
