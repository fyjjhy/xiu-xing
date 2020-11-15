select distinct
#if($leiBie == 'yu')
yu data_code,
yu data_name
#elseif($leiBie == 'jie')
jie data_code,
jie data_name
#elseif($leiBie == 'yaJie')
ya_jie data_code,
ya_jie data_name
#elseif($leiBie == 'men')
men data_code,
men data_name
#elseif($leiBie == 'yaMen')
ya_men data_code,
ya_men data_name
#elseif($leiBie == 'gang')
gang data_code,
gang data_name
#elseif($leiBie == 'yaGang')
ya_gang data_code,
ya_gang data_name
#elseif($leiBie == 'zongMu')
zong_mu data_code,
zong_mu data_name
#elseif($leiBie == 'mu')
mu data_code,
mu data_name
#elseif($leiBie == 'ke')
ke data_code,
ke data_name
#elseif($leiBie == 'shu')
shu data_code,
shu data_name
#elseif($leiBie == 'zhong')
zhong data_code,
zhong data_name
#else
yu data_code,
yu data_name
#end
from sheng_wu_fen_lei
where 1 = 1
ORDER BY code + 0 DESC