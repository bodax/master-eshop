SELECT DISTINCT ml.manufacturer_id, ml.name
FROM manufacturer_lang ml
         JOIN product p
              ON p.manufacturer_id = ml.manufacturer_id
         JOIN product_category pc
              ON pc.product_id = p.id
         JOIN category_lang cl
              ON cl.category_id = pc.category_id
WHERE cl.url = :url
GROUP BY ml.manufacturer_id