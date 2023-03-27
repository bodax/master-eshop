SELECT
    pl.product_id,
    pl.name as product_name,
    pl.url,
    pc.category_id,
    cl.name as category_name,
    c.iso,
    pp.base_price,
    pp.discount_percent,
    pi.filename
FROM product_lang pl
         JOIN product_category pc
              ON pc.product_id = pl.product_id
         JOIN product_image pi
              ON pi.product_id = pl.product_id
         JOIN category_lang cl
              ON cl.category_id = pc.category_id
         JOIN product_price pp
              ON pp.product_id = pl.product_id
         JOIN currency c
              ON c.id = pp.currency_id
WHERE cl.language_id = :lang
  AND pl.language_id = :lang
  AND pi.type = 'main'
  AND cl.url = :groupUrl
