SELECT pl.name  AS characteristic,
       pvl.name AS value,
       pl.property_id
FROM product_rel_property_value prpv
         JOIN property_value_lang pvl ON pvl.property_value_id = prpv.property_value_id
         JOIN property_lang pl ON pl.property_id = prpv.property_id
         JOIN product p ON p.id = prpv.product_id
         JOIN product_lang pll
              ON pll.product_id = p.id
WHERE pl.language_id = :lang
  AND pvl.language_id = :lang
  AND prpv.status LIKE 'enabled'
  AND pll.url = :url
GROUP BY pl.name