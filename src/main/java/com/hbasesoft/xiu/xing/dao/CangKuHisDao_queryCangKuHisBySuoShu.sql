select
   DISTINCT ckh.ling_wu_id id,
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
from cang_ku_his ckh
inner join (
    select
       h.suo_shu_id,
       h.ling_wu_id,
       MAX(update_time) update_time
    from cang_ku_his h
    where h.suo_shu_id = :suoShuId
    group by h.ling_wu_id, h.ling_wu_shu_xing
) k
on (k.suo_shu_id = ckh.suo_shu_id AND k.ling_wu_id = ckh.ling_wu_id AND k.update_time = ckh.update_time)
where ckh.suo_shu_id = :suoShuId