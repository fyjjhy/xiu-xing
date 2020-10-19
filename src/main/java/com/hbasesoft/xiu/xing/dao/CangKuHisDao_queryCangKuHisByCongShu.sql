SELECT
   DISTINCT ckh.cang_ku_id,
   ckh.cong_id id,
   ckh.cong_id,
   ckh.cong_his_id,
   ckh.cong_state,
   ckh.cong_shu_liang,
   ckh.dan_wei,
   ckh.cong_shu_xing,
   ckh.hen_ji_id,
   ckh.cong_jing_jie_id,
   ckh.cong_pin_ji_id,
   ckh.shu_id
FROM cang_ku_his ckh
INNER JOIN (
    SELECT
       h.cang_ku_id,
       h.shu_id,
       MAX(h.update_time) update_time
    FROM cang_ku_his h
    WHERE h.shu_id = :congShuId
    GROUP BY h.cang_ku_id, h.shu_id
) k
ON (k.cang_ku_id = ckh.cang_ku_id AND k.shu_id = ckh.shu_id  AND k.update_time = ckh.update_time)
WHERE ckh.shu_id = :congShuId