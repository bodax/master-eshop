SELECT
    pl.name as product_name,
    cl.name as category_name,
    pl.url,
    pp.base_price,
    pp.discount_percent,
    pi.filename,
    pc.product_id,
    pc.category_id,
    c.iso,
    cl.category_id
FROM product_category pc
         JOIN product_lang pl
              ON pc.product_id = pl.product_id
         JOIN category_lang cl
              ON pc.category_id = cl.category_id
         JOIN product_price pp
              ON pc.product_id = pp.product_id
         JOIN product_image pi
              ON pi.product_id = pc.product_id
         JOIN currency c
              ON c.id = pp.currency_id
WHERE pl.language_id = :lang
  AND cl.language_id = :lang
  AND pp.discount_percent > 25