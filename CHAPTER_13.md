Search SQL Query

```
select
    distinct q.id,
    q.author_id,
    q.content,
    q.create_date,
    q.modify_date,
    q.subject
from question q
left outer join site_user u1 on q.author_id=u1.id
left outer join answer a on q.id=a.question.id
left outer join site_user u2 on a.author_id=u2.id
where
    q.subject like '%스프링%'
    or q.content like '%스프링%'
    or u1.username like '%스프링%'
    or a.content like '%스프링%'
    or u2.username like '%스프링%'
```