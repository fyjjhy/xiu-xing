SELECT
  m.ID,
  m.tree_table_flag,
  m.child_column_code,
  m.parent_column_code,
  m.model_code,
  m.model_name,
  fm.title,
  fm.parent_model_id,
  fm.relationship,
  fm.master_flag,
  fm.func_model_code,
  fm.mult_choose_flag,
  fm.position,
  fm.search_flag
FROM func_model fm,
meta_model m
WHERE fm.model_id = m.ID
AND fm.func_id = :funcId