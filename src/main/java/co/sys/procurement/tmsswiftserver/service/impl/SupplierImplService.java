package co.sys.procurement.tmsswiftserver.service.impl;

import co.sys.procurement.tmsswiftserver.dto.ResponseDto;
import co.sys.procurement.tmsswiftserver.dto.SupplierQuotationDto;
import co.sys.procurement.tmsswiftserver.model.Material;
import co.sys.procurement.tmsswiftserver.model.Quotation;
import co.sys.procurement.tmsswiftserver.service.QueryService;
import co.sys.procurement.tmsswiftserver.service.SupplierService;
import co.sys.procurement.tmsswiftserver.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Service
public class SupplierImplService implements SupplierService {
    @Autowired
    private QueryService queryService;

    @Override
    public ResponseDto saveQuotation(SupplierQuotationDto quotationDto) throws ParseException {
        //save the material
        Material material=new Material();
        material.setCost(quotationDto.getCost());
        material.setDeliveryDate(quotationDto.getDeliveryDate());
        material.setMaterialList(quotationDto.getMaterialList());
        material.setTransportCost(quotationDto.getTransportCost());
        material.setType(quotationDto.getType());
        material.setTransportType(quotationDto.getTransportType());

        Map<String, Object> params=new HashMap<>();
        params.put("material_cost", material.getCost());
        params.put("material_type", material.getType());
        params.put("material_list", material.getMaterialList());

        params.put("material_delivery_date", material.getDeliveryDate());
        params.put("material_transport_cost", material.getTransportCost());
        params.put("material_transport_type", material.getTransportType());
        SimpleJdbcInsert simpleJdbcInsert=new SimpleJdbcInsert(queryService.getProcurementJdbcTemplate()).withTableName("material").usingGeneratedKeyColumns("material_id");
        int value= simpleJdbcInsert.executeAndReturnKey(params).intValue();

        Quotation quotation=new Quotation();
        quotation.setDeliveryTime(quotationDto.getDeliveryTime());
        quotation.setValidity(quotationDto.getValidity());
        quotation.setQuote(quotationDto.getQuote());
        quotation.setMaterialCostId(value);

        Map<String, Object> params1=new HashMap<>();
        params1.put("quotation_quote", quotation.getQuote());
        params1.put("quotation_validity", quotation.getValidity());
        params1.put("quotation_delivery_time", DateUtil.parseDate(quotation.getDeliveryTime()));
        params1.put("quotation_material_cost_id", quotation.getMaterialCostId());
        SimpleJdbcInsert simpleJdbcInsert1=new SimpleJdbcInsert(queryService.getProcurementJdbcTemplate()).withTableName("quotation").usingGeneratedKeyColumns("quotation_id");
        int value1= simpleJdbcInsert1.executeAndReturnKey(params).intValue();


        //save the quotation, material_id should be saved in the quotation_material_cost_id column
        // hibernate should update the project table with the quotation_srn

        return null;
    }

    @Override
    public ResponseDto getQuotation(SupplierQuotationDto quotationDto) {
        return null;
    }
}
