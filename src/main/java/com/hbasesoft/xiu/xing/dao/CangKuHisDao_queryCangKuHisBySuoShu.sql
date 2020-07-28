select
   ckh.ling_wu_id id,
   ckh.ling_wu_id,
   ckh.ling_wu_state,
   ckh.ling_wu_shu_liang,
   ckh.ling_wu_name,
   ckh.ling_wu_fen_lei,
   ckh.ling_wu_shu_xing,
   ckh.ling_wu_miao_shu,
   ckh.jing_jie_name,
   ckh.pin_ji_name,
   ckh.bei_zhu,
   ckh.suo_shu_id
from cang_ku_his ckh
inner join (
    select
       h.suo_shu_id,
       min(ling_wu_shu_liang) ling_wu_shu_liang
    from cang_ku_his h
    where h.suo_shu_id = :suoShuId
    group by h.suo_shu_id
) k
on k.suo_shu_id = ckh.suo_shu_id and ckh.ling_wu_shu_liang = k.ling_wu_shu_liang
where ckh.suo_shu_id = :suoShuId