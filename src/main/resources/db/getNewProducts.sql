SELECT distinct
    pl.name as product_name,
    cl.name as category_name,
    pl.url,
    pp.base_price,
    pp.discount_percent,
    pc.product_id,
    c.iso,
    pi.filename,
    cl.category_id
FROM product_category pc
         JOIN product_lang pl
              ON pc.product_id = pl.product_id
         JOIN category_lang cl
              ON cl.category_id = pc.category_id
         JOIN product_price pp
              ON pc.product_id = pp.product_id
         JOIN product_image pi
              ON pi.product_id = pc.product_id
         JOIN product p
              ON pc.product_id = p.id
         JOIN currency c
              ON c.id = pp.currency_id
WHERE pl.language_id = :lang
  AND cl.language_id = :lang
  AND pi.type = 'main'
ORDER BY p.t_created DESC
LIMIT 20