SELECT prpv2.property_id, pl2.name
FROM product_rel_property_value prpv2
         JOIN property_lang pl2
              ON pl2.property_id = prpv2.property_id
         JOIN property_value_lang pvl2
              ON pvl2.property_value_id = prpv2.property_value_id
         JOIN product_lang pll2
              ON pll2.product_id = prpv2.product_id
         JOIN product_category pc2
              ON pc2.product_id = pll2.product_id
         JOIN category_lang cl
              ON cl.category_id = pc2.category_id
WHERE prpv2.status = 'enabled'
  AND cl.language_id = :lang
  AND pl2.language_id = :lang
  AND pll2.language_id = :lang
  AND pvl2.language_id = :lang
  AND cl.url = :url
GROUP BY prpv2.property_id