SELECT pvl3.property_value_id, pvl3.name, prpv3.property_id
FROM product_rel_property_value prpv3
         JOIN property_lang pl3
              ON pl3.property_id = prpv3.property_id
         JOIN property_value_lang pvl3
              ON pvl3.property_value_id = prpv3.property_value_id
         JOIN product_lang pll3
              ON pll3.product_id = prpv3.product_id
         JOIN product_category pc
              ON pc.product_id = pll3.product_id
         JOIN category_lang cl3
              ON cl3.category_id = pc.category_id
WHERE prpv3.status = 'enabled'
  AND cl3.language_id = :lang
  AND pl3.language_id = :lang
  AND pll3.language_id = :lang
  AND pvl3.language_id = :lang
  AND cl3.url = :url
GROUP BY property_value_id