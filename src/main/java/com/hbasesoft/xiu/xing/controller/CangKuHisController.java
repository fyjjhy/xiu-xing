package com.hbasesoft.xiu.xing.controller;

import com.hbasesoft.xiu.xing.api.CangKuHisApi;
import com.hbasesoft.xiu.xing.bean.CangKuHis;
import com.hbasesoft.xiu.xing.entity.FenLeiEntity;
import com.hbasesoft.xiu.xing.service.CangKuHisService;
import com.hbasesoft.xiu.xing.service.FenLeiService;
import com.hbasesoft.xiu.xing.util.BeanTransferUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月31日 <br>
 * @see com.hbasesoft.xiu.xing.api <br>
 * @since V1.0 <br>
 */
@RestController
public class CangKuHisController implements CangKuHisApi {

    @Resource
    private CangKuHisService cangKuHisService;

    @Resource
    private FenLeiService fenLeiService;

    @Override
    public List<CangKuHis> queryCangKuHisBySuoShu(@RequestParam("suoShuId") String suoShuId) {
        return BeanTransferUtil.mapList(cangKuHisService.queryCangKuHisBySuoShu(suoShuId), hisEntity -> {
            CangKuHis cangKuHis = new CangKuHis();
            BeanUtils.copyProperties(hisEntity, cangKuHis);
            if (StringUtils.isNotEmpty(hisEntity.getLingWuState())) {
                FenLeiEntity state = fenLeiService.getFenLei(hisEntity.getLingWuState());
                if (state != null) {
                    cangKuHis.setLingWuStateName(state.getFenLeiName());
                }
            }

            if (StringUtils.isNotEmpty(hisEntity.getLingWuFenLei())) {
                FenLeiEntity fenLei = fenLeiService.getFenLei(hisEntity.getLingWuFenLei());
                if (fenLei != null) {
                    cangKuHis.setLingWuFenLeiName(fenLei.getFenLeiName());
                }
            }
            return cangKuHis;
        });
    }
}
