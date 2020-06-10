package com.hbasesoft.xiu.xing.controller;

import com.hbasesoft.framework.common.utils.date.DateConstants;
import com.hbasesoft.framework.common.utils.date.DateUtil;
import com.hbasesoft.xiu.xing.api.MetaModelApi;
import com.hbasesoft.xiu.xing.bean.ConfigItem;
import com.hbasesoft.xiu.xing.bean.Dict;
import com.hbasesoft.xiu.xing.bean.DictData;
import com.hbasesoft.xiu.xing.bean.FuncComponent;
import com.hbasesoft.xiu.xing.bean.FuncMetaData;
import com.hbasesoft.xiu.xing.bean.MetaModel;
import com.hbasesoft.xiu.xing.bean.MetaModelAction;
import com.hbasesoft.xiu.xing.bean.MetaModelColumn;
import com.hbasesoft.xiu.xing.constant.XiuXingErrorCodeDef;
import com.hbasesoft.xiu.xing.entity.ConfigItemEntity;
import com.hbasesoft.xiu.xing.entity.DictDataEntity;
import com.hbasesoft.xiu.xing.entity.DictEntity;
import com.hbasesoft.xiu.xing.entity.FuncComponentEntity;
import com.hbasesoft.xiu.xing.entity.FuncEntity;
import com.hbasesoft.xiu.xing.entity.MetaModelActionEntity;
import com.hbasesoft.xiu.xing.entity.MetaModelColumnEntity;
import com.hbasesoft.xiu.xing.entity.MetaModelEntity;
import com.hbasesoft.xiu.xing.service.ConfigItemService;
import com.hbasesoft.xiu.xing.service.DictDataService;
import com.hbasesoft.xiu.xing.service.DictService;
import com.hbasesoft.xiu.xing.service.FuncComponentService;
import com.hbasesoft.xiu.xing.service.FuncMetaDataService;
import com.hbasesoft.xiu.xing.service.FuncService;
import com.hbasesoft.xiu.xing.service.MetaModelActionService;
import com.hbasesoft.xiu.xing.service.MetaModelColumnService;
import com.hbasesoft.xiu.xing.util.BeanTransferUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月28日 <br>
 * @see com.hbasesoft.xiu.xing.controller <br>
 * @since V1.0 <br>
 */
@RestController
public class MetaModelController implements MetaModelApi {

    @Resource
    private FuncService funcService;

    @Resource
    private ConfigItemService configItemService;

    @Resource
    private DictService dictService;

    @Resource
    private DictDataService dictDataService;

    @Resource
    private FuncMetaDataService funcMetaDataService;

    @Resource
    private FuncComponentService funcComponentService;

    @Resource
    private MetaModelActionService metaModelActionService;

    @Resource
    private MetaModelColumnService metaModelColumnService;


    @Override
    public FuncMetaData getMetaModel(@PathVariable("funcCode") String funcCode) {
        Assert.hasLength(funcCode, XiuXingErrorCodeDef.FUNC_CODE_IS_EMPTY);
        // 查出功能
        FuncEntity funcEntity = funcService.getFuncByFuncCode(funcCode);
        Assert.notNull(funcEntity, XiuXingErrorCodeDef.FUNCTION_NOT_FOUND);

        List<MetaModelEntity> metaModelEnties = funcMetaDataService.queryMetaModelByFuncId(funcEntity.getId());
        Assert.notEmpty(metaModelEnties, XiuXingErrorCodeDef.FUNCTION_META_DATA_NOT_FOUND);

        FuncMetaData metaData = new FuncMetaData();
        BeanUtils.copyProperties(funcEntity, metaData);
        metaData.setStateTime(DateUtil.date2String(funcEntity.getStateTime(), DateConstants.DATETIME_FORMAT_19));

        List<FuncComponentEntity> functionComponentList = funcComponentService.queryFunctionComponent(funcEntity.getId());

        // 处理功能组件信息
        metaData.setFuncComponentList(BeanTransferUtil.mapList(functionComponentList, funcComponentEntity -> {
            FuncComponent funcComponent = new FuncComponent();
            BeanUtils.copyProperties(funcComponentEntity, funcComponent);
            return funcComponent;
        }));

        // 处理模型信息
        metaData.setMetaModelList(getMetaModelList(functionComponentList, metaModelEnties));

        // 处理数据字典
        metaData.setDictList(getDictList(funcEntity.getId()));

        // 处理配置项
        metaData.setConfigList(getConfigList(funcEntity.getId()));
        return metaData;
    }

    private List<ConfigItem> getConfigList(String funcId) {
        List<ConfigItemEntity> configItemEntities = configItemService.queryConfItems(funcId);
        return CollectionUtils.isNotEmpty(configItemEntities) ? configItemEntities.stream().map((entity) -> {
            ConfigItem configItem = new ConfigItem();
            BeanUtils.copyProperties(entity, configItem);
            return configItem;
        }).collect(Collectors.toList()) : new ArrayList<>();
    }

    private List<Dict> getDictList(String funcId) {
        List<DictEntity> dictEntities = dictService.queryDictByFuncId(funcId);
        return CollectionUtils.isNotEmpty(dictEntities) ? dictEntities.stream().map((entity) -> {
            Dict dict = new Dict();
            BeanUtils.copyProperties(entity, dict);
            // 处理字典值
            dict.setDictDataList(getDictDataList(entity.getId()));
            return dict;
        }).collect(Collectors.toList()) : new ArrayList<>();
    }

    private List<DictData> getDictDataList(String dictId) {
        List<DictDataEntity> dictDataEntities = dictDataService.queryDictDataByDictId(dictId);
        return CollectionUtils.isNotEmpty(dictDataEntities) ? dictDataEntities.stream().map((d) -> {
            DictData dictData = new DictData();
            BeanUtils.copyProperties(d, dictData);
            return dictData;
        }).collect(Collectors.toList()) : new ArrayList<>();
    }

    private List<MetaModel> getMetaModelList(List<FuncComponentEntity> functionComponentList,
                                             List<MetaModelEntity> metaModelEntities) {

        Map<String, FuncComponentEntity> componentMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(functionComponentList)) {
            for (FuncComponentEntity component : functionComponentList) {
                componentMap.put(component.getCode(), component);
            }
        }

        return metaModelEntities.stream().map((entity) -> {
            MetaModel metaModel = new MetaModel();
            BeanUtils.copyProperties(entity, metaModel);

            // 处理Model的Action
            metaModel.setActionList(getActionList(componentMap, entity.getId()));

            // 处理Model的Column
            metaModel.setColumnList(getColumnList(entity.getId()));

            return metaModel;
        }).collect(Collectors.toList());
    }

    private List<MetaModelColumn> getColumnList(String metaModelId) {
        List<MetaModelColumnEntity> modelColumnEntities = metaModelColumnService
                .queryMetaModelColumnByModelId(metaModelId);
        return CollectionUtils.isNotEmpty(modelColumnEntities) ? modelColumnEntities.stream().map((m) -> {
            MetaModelColumn metaModelColumn = new MetaModelColumn();
            BeanUtils.copyProperties(m, metaModelColumn);
            metaModelColumn.setColumnWidth(m.getColumnWidth());
            return metaModelColumn;
        }).collect(Collectors.toList()) : new ArrayList<>();
    }

    private List<MetaModelAction> getActionList(Map<String, FuncComponentEntity> componentMap,
                                                String metaModelId) {
        List<MetaModelActionEntity> metaModelActionEntities = metaModelActionService
                .queryMetaModelActionByModelId(metaModelId);
        if (CollectionUtils.isNotEmpty(metaModelActionEntities)) {
            List<MetaModelAction> returnList = new ArrayList<>();
            for (MetaModelActionEntity actionEntity : metaModelActionEntities) {
                MetaModelAction metaModelAction = new MetaModelAction();
                BeanUtils.copyProperties(actionEntity, metaModelAction);
                FuncComponentEntity component = componentMap.get(actionEntity.getCode());
                if (component == null) {
                    // 如果没有对应的中文
                    returnList.add(metaModelAction);
                } else {
                    metaModelAction.setName(component.getName());
                    metaModelAction.setIcon(component.getIcon());
                    metaModelAction.setDisplayType(component.getDisplayType());
                    returnList.add(metaModelAction);
                }
            }
            return returnList;
        } else {
            return new ArrayList<>();
        }
    }

}
