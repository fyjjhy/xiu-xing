SELECT
   DISTINCT ckh.cang_ku_id,
   ckh.ling_wu_id id,
   ckh.ling_wu_id,
   ckh.ling_wu_his_id,
   ckh.ling_wu_state,
   ckh.ling_wu_shu_liang,
   ckh.dan_wei,
   ckh.ling_wu_shu_xing,
   ckh.hen_ji_id,
   ckh.jing_jie_id,
   ckh.pin_ji_id,
   ckh.suo_shu_id
FROM cang_ku_his ckh
INNER JOIN (
    SELECT
       h.cang_ku_id,
       h.suo_shu_id,
       MAX(h.update_time) update_time
    FROM cang_ku_his h
    WHERE h.suo_shu_id = :suoShuId
    GROUP BY h.cang_ku_id, h.suo_shu_id
) k
ON (k.cang_ku_id = ckh.cang_ku_id AND k.suo_shu_id = ckh.suo_shu_id  AND k.update_time = ckh.update_time)
WHERE ckh.suo_shu_id = :suoShuId