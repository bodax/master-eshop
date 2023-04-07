SELECT DISTINCT relation_product_id AS product_id,
                pl.name             AS product_name,
                pl.description,
                pl.url,
                cl.name             AS category_name,
                cl.category_id,
                pp.base_price,
                pp.discount_percent,
                c.iso,
                pi.filename
FROM product_rel_product prp
         JOIN product_lang pl
              ON pl.product_id = prp.relation_product_id
         JOIN product_image pi
              ON pl.product_id = pi.product_id
         JOIN product_category pc
              ON pc.product_id = prp.relation_product_id
         JOIN product_price pp
              ON pp.product_id = prp.relation_product_id
         JOIN category_lang cl
              ON cl.category_id = pc.category_id
         JOIN currency c
              ON c.id = pp.currency_id
WHERE pl.language_id = :lang
  AND cl.language_id = :lang
  AND pi.type = 'main'
  AND prp.product_id IN (SELECT product_id
                         FROM product_lang pl
                         WHERE pl.url = :url)