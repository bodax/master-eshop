SELECT cl.category_id,
       cl.name,
       cl.url,
       c.parent_id,
       ci.filename
FROM category c
         JOIN category_lang cl
              ON c.id = cl.category_id
         JOIN category_image ci
              ON ci.category_id = c.id
                  AND url IS NOT NULL
                  AND cl.language_id = :lang;