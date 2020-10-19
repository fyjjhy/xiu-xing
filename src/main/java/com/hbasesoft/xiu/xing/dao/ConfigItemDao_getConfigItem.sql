SELECT ci.ID,
       ci.func_id,
       ci.config_name,
       ci.config_code,
       ci.config_value
FROM config_item ci,
     func f
WHERE ci.func_id = f.id
  AND f.func_code = :funcCode
  AND ci.config_code = :configCode